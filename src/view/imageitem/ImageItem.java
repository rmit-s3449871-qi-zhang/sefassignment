package view.imageitem;

import javax.swing.ImageIcon;

public abstract class ImageItem {
	private ImageIcon image;
	
	public ImageItem(ImageIcon image){
		this.image = image;
	}
	
	public ImageIcon getImage(){
		return this.image;
	}
}
