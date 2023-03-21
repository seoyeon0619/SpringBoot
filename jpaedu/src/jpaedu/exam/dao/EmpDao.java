package jpaedu.exam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import jpaedu.exam.dto.EmpDto;

public class EmpDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
	EntityManager em = factory.createEntityManager();
			
	public void close()
	{
		em.close();
		factory.close();
	}
	
	public void printAll()
	{
		TypedQuery<EmpDto> query = em.createQuery("select t from EmpDto t", EmpDto.class);
		List<EmpDto> list = query.getResultList();
//		for(int i=0; i<list.size(); i++)
//		{
//			System.out.println(list.get(i));
//		}
		
		// 람다식으로 전환
		// 자바8부터 람다식을 프로그램에 편입
		// list -> stream 객체로 전환
		// forEach는 매개변수로 함수를 전달
		list.stream().forEach(e->{
			System.out.println(e);
		});
	}
	public void serachName(String name)
	{
		String sql="select t from EmpDto t where t.ename like :ename";
		TypedQuery q = em.createQuery(sql, EmpDto.class);
		q.setParameter("ename", name+"%");
		
		List<EmpDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(item);
		});
	}
	
	// 두가지 조건
	public void searchNameAndJob(String name, String job)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("select t from EmpDto t where t.ename like :ename and t.job = like job");
		TypedQuery q = em.createQuery(buffer.toString(), EmpDto.class);
		q.setParameter("ename", "%"+name+"%");
		q.setParameter("job", "%"+job+"%");
		
		List<EmpDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(item);
		});
	}
	
	public void searchNameAndJob2(String name, String job)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("select t from EmpDto t where t.ename like ?1 and t.job like ?2");
		// ?1 : 첫번째 파라미터
		// ?2 : 두번째 파라미터
		TypedQuery q = em.createQuery(buffer.toString(), EmpDto.class);
		// 위치값을 지정해서 값을 전달
		q.setParameter(1, "%"+name+"%");
		q.setParameter(2, "%"+job+"%");
		
		List<EmpDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(item);
		});
	}
	
	// 그룹함수 호출
	public void groupFunctionTest()
	{
		Query query = em.createQuery("select sum(t.sal) from EmpDto t");
		Object result = (Object)query.getSingleResult();
		System.out.println(result);
	}
	
	public void updateSal(Integer empno, Integer sal)
	{
		try
		{
			em.getTransaction().begin();
			EmpDto dto  = em.find(EmpDto.class, empno);
			dto.setSal(sal);
			em.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public void updateSal2(Integer empno, Integer sal)
	{
		TypedQuery q  = em.createQuery(
				"select t from EmpDto t where t.empno=:empno",
				EmpDto.class);
		q.setParameter("empno", empno);
		
		try
		{
			em.getTransaction().begin();
			EmpDto dto  = (EmpDto)q.getSingleResult();
			dto.setSal(sal);
			em.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public void deleteEmpno(Integer empno)
	{
		try
		{
			em.getTransaction().begin();
			EmpDto dto  = em.find(EmpDto.class, empno);
			em.remove(dto);
			em.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
}
