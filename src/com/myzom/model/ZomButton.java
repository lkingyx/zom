package com.myzom.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import com.my.tools.ZomImages;
import com.my.tools.ZomThread;
import com.myzom.superclass.ZomObject;

public class ZomButton extends ZomObject{
	private BufferedImage image;

	public ZomButton(int width, int height,int x,int y) {
		super(width, height,x,y);
		image = ZomImages.button;
	}

	@Override
	public Image getImage() {
		return null;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

    public void setX(int x) {
		this.x = x;
	}

    public void setY(int y) {
		this.y = y;
	}

    public void setWidth(int width) {
		this.width = width;
	}

    public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void paintObject(Graphics g) {
		g.drawImage(image, x, y, width, height, null);
	}

	@Override
	public BufferedImage getBuff() {
		return image;
	}

	public void ButtonPressed() {
		x+=1;
		y+=1;
		ZomThread.geExecutorService().execute(() -> {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ButtonReleased();
		});
	}

	private void ButtonReleased() {
		x-=1;
		y-=1;
	}

}
