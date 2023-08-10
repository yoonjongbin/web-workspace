package servlet.controller;

import servlet.controller.component.AllshowController;
import servlet.controller.component.FindController;
import servlet.controller.component.LoginController;
import servlet.controller.component.LogoutController;
import servlet.controller.component.RegisterController;
import servlet.controller.component.UpdateController;

public class HandlerMapping {
	private static HandlerMapping hm = new HandlerMapping();
	
	private HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		return hm;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("find.do")) {
			controller = new FindController();
		} else if(command.equals("register.do")) {
			controller = new RegisterController();
		} else if(command.equals("login.do")) {
			controller = new LoginController();
		} else if(command.equals("update.do")) {
			controller = new UpdateController();
		}else if(command.equals("logout.do")) {
			controller = new LogoutController();
		}else if(command.equals("allshow.do")) {
			controller = new AllshowController();
		}
		
		return controller;
	}
}
