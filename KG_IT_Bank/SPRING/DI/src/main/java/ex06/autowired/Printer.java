package ex06.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {
	
	/*
	Autowired - 자동 주입
	타입을 주입 -> id이름으로 주입
	- 생성자, 세터, 멤버 변수만 사용이 가능 
	 
	required = false 옵션은
	스프링이 주입할 빈이 없으면 자동으로 에러를 발생시키는데,
	이를 무시하고 지나가주세요.라는 속성
	
	Qualifier - 빈 강제 연결
	컨테이너 안에 객체가 여러개 있을 때 id이름으로 강제 연결해주는 어노테이션
	*/
	
	@Autowired(required = false)
	@Qualifier("xxxxxx")
	private Document document;
	
//	기본생성자
	public Printer() {}
	
//	생성자
	public Printer(Document document) {
		super();
		this.document = document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Document getDocument() {
		return document;
	}

	
	
}
