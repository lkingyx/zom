package com.myzom.model;

import java.awt.Image;

import java.awt.image.BufferedImage;

import com.my.tools.ZomImages;
import com.myzom.superclass.ZomObject;

public class Model extends ZomObject{

	private static final Image[] images;
	private final int type;
	static {
		images = new Image[9];
		images[0] = ZomImages.MODEL1;
		images[1] = ZomImages.MODEL2;
		images[2] = ZomImages.MODEL3;
		images[3] = ZomImages.MODEL4;
		images[4] = ZomImages.MODEL5;
		images[5] = ZomImages.MODEL6;
		images[6] = ZomImages.MODEL7;
		images[7] = ZomImages.MODEL8;
		images[8] = ZomImages.MODEL9;
	}

	public Model(int x, int y , int type) {
		super(70, 70, x, y);
		this.type = type;
	}

	public void moveTo(int x,int y) {
		this.x = x-this.width/2;
		this.y = y-this.height/2;
	}

	@Override
	public Image getImage() {
		switch (type) {
		case 1:
			return images[0];
		case 2:
			return images[1];
		case 3:
			return images[2];
		case 4:
			return images[3];
		case 5:
			return images[4];
		case 6:
			return images[5];
		case 7:
			return images[6];
		case 8:
			return images[7];
		case 9:
			return images[8];
		}
		return null;
	}

	public int getType() {
		return type;
	}

	@Override
	public BufferedImage getBuff() {
		
		return null;
	}

}
