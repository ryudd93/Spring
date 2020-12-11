package ex08.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ex02.construct.Chef;
import ex02.construct.Hotel;
import ex03.setter.DatabaseDev;
import ex03.setter.MemberDAO;
import ex04.quiz.Airplane;
import ex04.quiz.Battery1;
import ex04.quiz.Battery2;
import ex04.quiz.Car;

@Configuration	//이 클래스가 스프링 설정 파일이라는 것을 표기 - xml문서를 대신
public class JavaConfig {
	
//	xml코드
//	<bean id="chef" class="ex02.construct.Chef" />
//	<bean id="hotel" class="ex02.construct.Hotel">
//		<constructor-arg ref="chef" />
//	</bean>
	
	
	
//	자바코드
	@Bean	//@Bean이 붙은 메서드를 스프링 컨테이너가 객체로 생성
	public Chef chef() {
		return new Chef();
	}
	
	@Bean
	public Hotel hotel() {
//		return new Hotel(new Chef());
		return new Hotel(chef());
	}
	
	
	
//	xml코드
//	<bean id="db" class="ex03.setter.DatabaseDev">
//	<property name="url" value="bean으로 넣은 데이터베이스 주소" />
//	<property name="uid" value="bean으로 넣은 데이터베이스 아이디" />
//	<property name="upw" value="bean으로 넣은 데이터베이스 비밀번호" />
//	</bean>
//
//	<bean id="memberDAO" class="ex03.setter.MemberDAO">
//		<property name="ds" ref="db" />
//	</bean>
	
	
	
//	자바 코드	
	@Bean
	public DatabaseDev db() {
		DatabaseDev dev = new DatabaseDev();
		dev.setUrl("자바로 설정한 데이터베이스 주소");
		dev.setUid("자바로 설정한 데이터베이스 아이디");
		dev.setUpw("자바로 설정한 데이터베이스 비밀번호");
		
		return dev;
	}
	
	@Bean
	public MemberDAO memberDAO() {
		MemberDAO dao = new MemberDAO();
		dao.setDs(db());
		return dao;
	}
	
	
	
	
//	xml코드
//	<bean id="b1" class="ex04.quiz.Battery1"/>
//	<bean id="b2" class="ex04.quiz.Battery2"/>
//	<bean id="car" class="ex04.quiz.Car">
//		<constructor-arg ref="b1" />
//	</bean>
//	<bean id="op" class="ex04.quiz.Airplane">
//		<property name="battery" ref="b2"/>
//	</bean>
	
	
	
	
//	자바코드
	@Bean
	public Battery1 b1() {
		return new Battery1();
	}
	
	@Bean
	public Battery2 b2() {
		return new Battery2();
	}
	
	@Bean
	public Car car() {
		return new Car(b1());
	}
	
	@Bean
	public Airplane ap() {
		Airplane ap = new Airplane();
		ap.setBattery(b2());
		return ap;
	}
	
	
}
