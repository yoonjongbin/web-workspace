package pattern.controller;

import pattern.controller.component.FindController;

public class ControllerFactory {
	// 싱글톤 패턴(Singleton Pattern)
	
	private static ControllerFactory cf = new ControllerFactory();
	private ControllerFactory() {}

	public static ControllerFactory getInstance(){
		return cf;
	}

	
	// createController : 컨트롤러 생성하는 기능

	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("findModel")) {
			controller = new FindController();
		}
		
		return controller;
	}
	

	
}
