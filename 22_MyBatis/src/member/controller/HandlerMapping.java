package member.controller;

import member.controller.component.AllshowController;
import member.controller.component.FindController;
import member.controller.component.LoginController;
import member.controller.component.LogoutController;
import member.controller.component.RegisterController;
import member.controller.component.UpdateController;

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
		}else if(command.equals("allShow.do")) {
			controller = new AllshowController();
		}
		
		return controller;
	}
}
