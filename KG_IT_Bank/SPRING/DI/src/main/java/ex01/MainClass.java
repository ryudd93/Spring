package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

//		SpringTest st = new SpringTest();
//		st.test();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
		SpringTest st = ctx.getBean(SpringTest.class);
		st.test();
		
//		스프링 설정 파일에서 빈을 사용할  때마다 기본적으로 싱글톤형식을 가지고 있음
		SpringTest st2 = ctx.getBean(SpringTest.class);
		System.out.println(st == st2);	//application-context.xml의 bean의 scope속성이 프로토타입일때는  false, 아닐때는 true(매번 새로운 빈이 생성되기 때문에)
		
		
	}

}
