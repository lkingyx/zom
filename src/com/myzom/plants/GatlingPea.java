package com.myzom.plants;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;
import com.my.tools.ZomMusic;
import com.myzom.data.GameState;
import com.myzom.logic.BombShootLogic;

public class GatlingPea extends PlantsObject implements BombSource {

	/**
	 * 炮弹发射逻辑
	 */
	private final BombShootLogic bombShootLogic;;

	/**
	 * 植物的图像。
	 */
	private static Image image;

	/**
	 * 静态代码块，用于初始化植物的图像。
	 */
	static {
		image = ZomImages.gatlingPea;
	}

	/**
	 * 构造函数，用于创建一个新的GatlingPea对象。
	 * @param x 植物的x坐标
	 * @param y 植物的y坐标
	 */
	public GatlingPea(int x, int y) {
		super(73, 74, x, y);
		blood = 1000;
		bombShootLogic = new BombShootLogic(4, 300,this);
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
		return ZomImages.gatlingPea_1;
	}

	@Override
	public void shoot() {
		bombShootLogic.shoot();
	}
}
