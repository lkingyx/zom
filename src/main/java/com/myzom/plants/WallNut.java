package com.myzom.plants;

import java.awt.Image;
import java.awt.image.BufferedImage;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;

public class WallNut extends PlantsObject{

	private static Image[] images;

	static {
		images = new Image[3];
		images[0] = ZomImages.wallNut;
		images[1] = ZomImages.wallNut_cracked1;
		images[2] = ZomImages.wallNut_cracked2;
	}

	public WallNut(int x, int y) {
		super(61, 71, x, y);

		blood = 6000;
	}

	@Override
	public Image getImage() {
		if (isLife()) {
			if(blood>4000) {
				return images[0];
			}else if (blood>2000) {
				return images[1];
			}else {
				return images[2];
			}
		}else if (isDead()) {
			state = ZomConstant.REMOVE;
		}
		return null;
	}

	@Override
	public BufferedImage getBuff() {

		return ZomImages.wallNut_1;
	}
}
