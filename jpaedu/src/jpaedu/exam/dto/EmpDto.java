package jpaedu.exam.dto;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="emp") // 테이블명과 클래스 이름이 다를 경우 꼭 해당 어노테이션을 꼭 사용
public class EmpDto {
	@Id // primary key 지정
	private int empno; 
	private String ename;
	private String job;
	private String mgr;
	private Date hiredate;
	private int sal;
	private Integer comm;
	private Integer deptno;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Integer getComm() {
		return comm;
	}
	public void setComm(Integer comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public EmpDto() {
		super();
		
	}
	public EmpDto(int empno, String ename, Date hiredate, int sal, Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.hiredate = hiredate;
		this.sal = sal;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %d %d %d %s %d", empno, ename, deptno, sal, comm, hiredate, mgr);
	}

	
}
