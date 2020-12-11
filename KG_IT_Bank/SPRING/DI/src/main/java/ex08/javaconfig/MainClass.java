package ex08.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex02.construct.Hotel;
import ex03.setter.MemberDAO;
import ex04.quiz.Airplane;
import ex04.quiz.Car;

public class MainClass {
	
	public static void main(String[] args) {
		
//		자바 설정을 확인하는 클래스
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);		
		
		Hotel h = ctx.getBean(Hotel.class);
		h.getChef().cooking();
		
		MemberDAO dao = ctx.getBean(MemberDAO.class);
		dao.info();
		
		Car car = ctx.getBean(Car.class);
		car.getBattery().energy();
		
		Airplane ap = ctx.getBean(Airplane.class);
		ap.getBattery().energy();
		
	}

}
