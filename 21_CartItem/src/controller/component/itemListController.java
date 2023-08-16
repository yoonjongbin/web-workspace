package controller.component;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.Item;
import model.ItemDAO;

public class itemListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ItemDAO dao = new ItemDAO();
		String path = "index.jsp";
		
		ArrayList<Item> list = dao.getAllItem();
		
		for(Item item : list) {
			System.out.println(item.getItemName());
		}
		
		if(!list.isEmpty()) {
			request.setAttribute("list", list);
			path = "itemList.jsp";
		}
		
		return new ModelAndView(path);
	}

}
