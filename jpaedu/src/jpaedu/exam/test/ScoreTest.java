package jpaedu.exam.test;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpaedu.exam.dto.ScoreDto;

public class ScoreTest {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
		//factory - 공장, 객체를 생성해내는 별도의 클래스 
		EntityManager em = factory.createEntityManager();
		System.out.println("JPA실습");
	
	/* conn user02/1234
	 * select tname from tab;
	 */
	
	ScoreDto dto = new ScoreDto();
	dto.setName("홍길동");
	dto.setKor(100);
	dto.setEng(90);
	dto.setMat(80);
	dto.setWdate(LocalDateTime.now());
	
//	em.getTransaction().begin();
//	em.persist(dto);
//	em.getTransaction().commit();
	
	// 데이터 가져오기
	// TypedQuery : 테이블이 아니라 클래스에서 데이터 가져옴
	TypedQuery<ScoreDto> q = em.createQuery("select t from ScoreDto t", ScoreDto.class	);
	List<ScoreDto> list = q.getResultList();
	
	list.stream().forEach(e->{
		System.out.println(String.format("%s %d %d %d", e.getName(), e.getKor(), e.getEng(), e.getMat()));
	});
	
	System.out.println("번호로 검색하기");
	// 검색
	q = em.createQuery(
			"select a from ScoreDto a where a.seq=:seq", ScoreDto.class	);
	q.setParameter("seq", 1);
	list = q.getResultList();
	list.stream().forEach(e->{
		System.out.println(String.format("%s %d %d %d", e.getName(), e.getKor(), e.getEng(), e.getMat()));
	});
	
	em.close();
	factory.close();
	}
}

