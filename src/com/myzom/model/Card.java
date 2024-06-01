package com.myzom.model;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;
import com.myzom.superclass.ZomObject;

public class Card extends ZomObject{

	private static Image [] images;
	private int type;
	protected int price;

	static {
		images = new Image[10];
		images[0] = ZomImages.CAED1;
		images[1] = ZomImages.CAED2;
		images[2] = ZomImages.CAED3;
		images[3] = ZomImages.CAED4;
		images[4] = ZomImages.CAED5;
		images[5] = ZomImages.CAED6;
		images[6] = ZomImages.CAED7;
		images[7] = ZomImages.CAED8;
		images[8] = ZomImages.CAED9;
		images[9] = ZomImages.CAED10;
	}

	public Card(int x, int price,int type) {
		super(66, 80, x, 0);
		this.type = type;
		this.price = price;

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
		case 10:
			return images[9];
		}
		return null;

	}

	public int getType() {
		return type;
	}

	public int getPrice() {
		return price;
	}

    @Override
	public BufferedImage getBuff() {

		return null;
	}

}
