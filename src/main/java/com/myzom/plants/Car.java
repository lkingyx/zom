package com.myzom.plants;

import java.awt.Image;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;

public class Car extends PlantsObject{

	private static final Image image;

	private final int speed;
	private boolean startMove;

	static {
		image = ZomImages.lawnMower;
	}

	public Car(int y) {
		super(70, 57, -45, y);
		speed = 2;
		startMove = false;
	}

	public void step() {
		if (startMove) {
			this.x += speed;
		}
	}

	public boolean outOfBounds() {
		return x >= ZomConstant.WIDTH+this.width;
	}

	public void goStartMove() {
		this.startMove = true;
	}

	@Override
	public Image getImage() {
		return image;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public BufferedImage getBuff() {
		return ZomImages.car;
	}

}
