package ex06.autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class Printer {

	
	private Document document;
	
//	생성자
	@Autowired
	public void setDocument(Document document) {
		this.document = document;
	}
	
	public Printer(Document document) {
		super();
		this.document = document;
	}

	public Document getDocument() {
		return document;
	}

	
	
}
