package com.myzom.plants;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;
import com.myzom.logic.BombShootLogic;

public class SnowPea extends PlantsObject implements BombSource{

	private final BombShootLogic bombShootLogic;

	private static final Image image;

	static {
		image = ZomImages.snowPea;
	}

	public SnowPea(int x, int y) {
		super(71, 71, x, y);
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

		return ZomImages.snowPea_1;
	}

	@Override
	public void shoot() {
		bombShootLogic.shoot();
	}
}
