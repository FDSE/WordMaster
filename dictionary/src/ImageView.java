

import java.awt.*;

import javax.swing.*;

public class ImageView extends JPanel{

	Image im = null;
	/*
	public static void main(String[] args) {

	}
    */
	public ImageView(Image im) {
		this.im = im;
		
	}
	
	public Image getIm() {
		return im;
	}

	public void setIm(Image im) {
		this.im = im;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
}
