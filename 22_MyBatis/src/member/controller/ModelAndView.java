package member.controller;

public class ModelAndView {
	private String path;
	private boolean inRedirect;
	
	
	public ModelAndView(String path) {	// foward 방식!
		this.path = path;
	}
	public ModelAndView(String path, boolean inRedirect) {	// sendRedirects! true 같이 넘겨서
		this.path = path;
		this.inRedirect = inRedirect;
	}
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public boolean isInRedirect() {
		return inRedirect;
	}
	
	
	public void setInRedirect(boolean inRedirect) {
	}

	
	
}
