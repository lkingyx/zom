package com.myzom.plants;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;
import com.myzom.logic.BombShootLogic;

public class Repeater extends PlantsObject implements BombSource{

	private final BombShootLogic bombShootLogic;

	private static Image image;

	static {
		image = ZomImages.repeater;
	}

	public Repeater(int x, int y) {
		super(73, 71, x, y);
		blood = 1000;
		bombShootLogic = new BombShootLogic(2, 500, this);
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


	@Override
	public BufferedImage getBuff() {

		return ZomImages.repeater_1;
	}

	@Override
	public void shoot() {
		bombShootLogic.shoot();
	}
}
