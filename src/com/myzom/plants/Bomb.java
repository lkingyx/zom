package com.myzom.plants;

import java.awt.Image;
import java.awt.image.BufferedImage;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;

public class Bomb extends PlantsObject{

	private static final Image[] images;
	private int type;
	private final int speed;

	static {
		images = new Image[3];
		images[0] = ZomImages.PB01;
		images[1] = ZomImages.SPBullet;
		images[2] = ZomImages.PB10;

	}

	public Bomb(int x, int y,int type) {
		super(24, 24, x, y);

		this.type = type;
		this.speed = 3;
	}

	public void step() {

		x += speed;
	}

	@Override
	public Image getImage() {
		if (isLife()) {
			switch (type) {
			case 0:
				return images[0];

			case 1:
				return images[1];
			case 2:
				return images[2];
			}

		}else if(isDead()){
			state=ZomConstant.REMOVE;
		}
		return null;
	}

	/**
	 * 设置炮弹的类型
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}

	public boolean outOfBounds() {
		return this.x>=ZomConstant.WIDTH;
	}

	public int getType() {
		return type;
	}

	@Override
	public BufferedImage getBuff() {

		return ZomImages.pb01;
	}
}
