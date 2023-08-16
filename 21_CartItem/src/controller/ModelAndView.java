package controller;

public class ModelAndView {
	private String path;
	private boolean inRedirect;
	public ModelAndView() {}
	
	public ModelAndView(String path) {
		this.path = path;
	}
	
	public ModelAndView(String path, boolean inRedirect) {
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
		this.inRedirect = inRedirect;
	}
	
	
}
