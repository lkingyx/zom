package com.myzom.plants;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;

public class TwinSunflower extends PlantsObject{

	private static Image image;

	private int generateTime;

	static {
		image = ZomImages.twinSunflower;
	}

	public TwinSunflower(int x, int y) {
		super(73, 87, x, y);

		blood = 1000;
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

	public List<Sun> createSun() {
		List<Sun> list = new ArrayList<>();
		list.add(new Sun(x-40, y-66));
		list.add(new Sun(x+40, y-66));
		return list;
	}

	public int getGenerateTime() {
		return generateTime;
	}

	public void addGenerateTime() {
		generateTime = 35000;
	}

	public void subGenerateTime() {
		generateTime -= 10;
	}

	@Override
	public BufferedImage getBuff() {

		return ZomImages.twinSunflower_1;
	}
}
