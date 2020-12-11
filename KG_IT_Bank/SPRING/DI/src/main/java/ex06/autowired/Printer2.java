package ex06.autowired;

import javax.annotation.Resource;

public class Printer2 {
	
	/*
	 * @Resource는 이름으로 찾는다. -> 타입으로 찾음
	 * - 세터, 멤버변수에만 적용이 가능하다
	 * 
	 * Resource의 강제 연결은 name속성을 이용
	*/
	
	@Resource(name = "doc2")
	private Document document;
	
	public Printer2() {
		// TODO Auto-generated constructor stub
	}
	
//	생성자
	public Printer2(Document document) {
		this.document = document;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	

}
