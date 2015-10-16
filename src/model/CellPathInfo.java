package model;

public class CellPathInfo {
	private boolean path;
	private CellPathInfo previousSquare;
	
	public CellPathInfo() {
		this.path = false;
	}

	public boolean isPath() {
		return path;
	}

	public void setPath(boolean path) {
		this.path = path;
	}
	
}
