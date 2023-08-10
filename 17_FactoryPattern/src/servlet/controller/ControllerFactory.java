package servlet.controller;

import servlet.controller.component.FindUser;

public class ControllerFactory {
	private static ControllerFactory cf = new ControllerFactory();
	
	private ControllerFactory() {}
	
	public static ControllerFactory getInstance() {
		return cf;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("find")) {
			controller = new FindUser();
		}
		
		return controller;
	}
}
