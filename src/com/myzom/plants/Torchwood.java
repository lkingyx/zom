package com.myzom.plants;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;

public class Torchwood extends PlantsObject{

	private static Image image;

	static {
		image = ZomImages.torchwood;
	}
	public Torchwood(int x, int y) {
		super(83, 84, x, y);
		blood = 1000;
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

		return ZomImages.torchwood_1;
	}
}
