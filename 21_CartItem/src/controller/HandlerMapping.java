package controller;

import controller.component.itemListController;

public class HandlerMapping {
	private static HandlerMapping hm = new HandlerMapping();
	
	public HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		return hm;
	}
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("itemList.do")) {
			controller = new ItemListController();
		}else if(command.equals("itemView.do")) {
			controller = new ItemViewController();
		}
		
		return controller;
	}
}
