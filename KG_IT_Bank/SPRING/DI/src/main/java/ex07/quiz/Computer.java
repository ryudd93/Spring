package ex07.quiz;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Computer {
//	키보드, 마우스, 모니터에 대한 멤버변수를 만들고, resource, autowired를 사용해서 자동 주입
//	main에서 computerInfo기능을 확인
	
	
	public void computerInfo() {
		monitor.info();
		mouse.info();
		keyboard.info();
		
	}
	
	@Resource(name = "keyboard")
	private Keyboard keyboard;
	
	@Autowired
	@Qualifier("mouse")
	private Mouse mouse;

	@Autowired
	@Qualifier("monitor")
	private Monitor monitor;
	
	
	

}
