package ex04.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		Car, Airplane 빈을 생성하고, 아무 베터리나 의존성 주입을 시킴
//		각 객체 안에 있는 베터리를 자바 클래스에서 출력
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
		
		Car car = ctx.getBean(Car.class);
		car.getBattery().energy();
		
		Airplane ap = ctx.getBean(Airplane.class);
		ap.getBattery().energy();
		
		IBattery b1 = ctx.getBean(Battery1.class);
		b1.energy();
		
		IBattery b2 = ctx.getBean(Battery2.class);
		b2.energy();
		

	}

}
