 package jpaedu.exam.test;

import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import jpaedu.exam.dao.EmpDao;

public class EmpTest {
	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		Scanner sc = new Scanner(System.in);
//		dao.printAll();
//		
//		System.out.println("찾을 이름 : ");
//		String name = sc.next();
//		dao.serachName(name);
//		dao.searchNameAndJob(name, name);
		
//		dao.updateSal(1100, 11111);
		dao.deleteEmpno(7902);
		
		dao.close();
	}
}
