package com.myzom.plants;

import java.awt.Image;
import java.awt.image.BufferedImage;

import com.my.tools.Tools;

public class Hammer extends PlantsObject{

	private static Image[] images;

	static {
		images = new Image[2];
		for (int i = 0; i < images.length; i++) {
			images[i] = Tools.readImage("./img/hammer/hammer"+i+".png");
		}
	}

	private boolean mouth;

	public Hammer() {
		super(124, 120, 0, 0);
		mouth = false;

	}

	public void moveTo(int x,int y) {
		this.x = x-width/2;
		this.y = y-height;
	}

	@Override
	public Image getImage() {
		if (mouth) {
			return images[1];
		}else {
			return images[0];
		}
	}

	public void setMouth(boolean mouth) {
		this.mouth = mouth;
	}

	@Override
	public BufferedImage getBuff() {

		return null;
	}
}
