package com.myzom.plants;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;
import com.myzom.logic.BombShootLogic;

public class Peashooter extends PlantsObject implements BombSource{

	private final BombShootLogic bombShootLogic;

	private static Image image;

	static {
		image = ZomImages.peashooter;
	}

	public Peashooter(int x, int y) {
		super(74, 80, x, y);
		blood = 1000;
		bombShootLogic = new BombShootLogic(1, 300, this);
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

		return ZomImages.peashooter_1;
	}

	@Override
	public void shoot() {
		bombShootLogic.shoot();
	}
}
