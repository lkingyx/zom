package com.myzom.plants;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;

public class SunFlower extends PlantsObject{

	private static Image image;

	private int generateTime;

	static {
		image = ZomImages.sunFlower;
	}

	public SunFlower(int x, int y) {
		super(73, 74, x, y);

		this.blood = 1000;
		addGenerateTime();
	}

	@Override
	public Image getImage() {
		if (isLife()) {
			return image;
		}else if (isDead()) {
			state = ZomConstant.REMOVE;
		}
		return null;
	}

	public int getGenerateTime() {
		return generateTime;
	}

	public void subGenerateTime() {
		generateTime -= 10;
	}

	public void addGenerateTime() {
		this.generateTime = 20000;
	}

	public Sun createSun() {
		return new Sun(this.x, this.y-66);
	}

	@Override
	public BufferedImage getBuff() {

		return ZomImages.sunFlower_1;
	}

}
