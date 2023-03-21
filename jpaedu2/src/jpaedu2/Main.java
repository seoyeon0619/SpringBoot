package jpaedu2;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class Main {
	public static void main(String[] args) {
		
		//dept테이블에 primary key  지정
		//alter table dept add constraint PK_DEPT primary key(deptno);
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("emptest");
		
		//factory - 공장, 객체를 생성해내는 별도의 클래스 
		EntityManager em = factory.createEntityManager();
		
		EmpDto dto = new EmpDto();
		dto.setEmpno(8000);
		dto.setEname("홍길동");
		//문자열형태의 날짜를 ->  Date  타입으로 바꾸어서 전달한다 
		dto.setHiredate(Date.valueOf("2023-02-21"));
		dto.setDept(new DeptDto(10)); //부서번호 10번 
		dto.setJob("개발자");
		dto.setSal(8000L);  //long형 상수 숫자뒤에 l 또는 L을 붙인다
		dto.setComm(200);
		
		em.getTransaction().begin();
		em.persist(dto); //추가하기 
		em.getTransaction().commit();
		
		TypedQuery<EmpDto> q = em.createQuery(
				"select a from EmpDto a ", EmpDto.class);
		List<EmpDto> list = q.getResultList();
		list.stream().forEach(e->{
			System.out.println(e.ename + " " + e.getDept().deptno
					+" " + e.getDept().dname);
		});
		
		em.close();
		factory.close();
	
	}
}
