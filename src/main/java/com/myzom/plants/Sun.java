package com.myzom.plants;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.my.tools.ZomImages;

public class Sun extends PlantsObject{

	private static Image image;
	private int speed;

	static {
		image = ZomImages.sun;
	}

	public Sun(int x, int y) {
		super(66, 65, x, y);

		speed = 1;
	}

	public void step() {
		if(this.y<=400) {
			this.y += speed;
		}
	}

	@Override
	public Image getImage() {

		return image;
	}

	@Override
	public BufferedImage getBuff() {

		return null;
	}

}
