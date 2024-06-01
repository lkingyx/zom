package com.myzom.plants;

import com.myzom.superclass.ZomObject;

/**
 * 这是一个抽象类，代表游戏中的植物对象。
 * 它继承自ZomObject类，包含了植物对象的基本属性和方法。
 * 具体的植物类型（如豌豆射手、向日葵等）应该继承这个类，并实现具体的行为。
 *
 * @author Administrator
 */
public abstract class  PlantsObject extends ZomObject{

	/**
	 * 变量blood代表游戏中植物对象的生命值。
	 * 它是受保护的，意味着可以被这个类、子类和同一包中的类访问。
	 * 当blood值达到0时，植物对象被视为死亡，应从游戏中移除。
	 */
	protected int blood;

	/**
	 * 构造函数用于创建一个新的植物对象。
	 * @param width 植物对象的宽度
	 * @param height 植物对象的高度
	 * @param x 植物对象的x坐标
	 * @param y 植物对象的y坐标
	 */
	public PlantsObject(int width, int height, int x, int y) {
		super(width, height, x, y);

	}

	/**
	 * 获取植物对象的生命值。
	 * @return 植物对象的生命值
	 */
	public int getBlood() {
		return blood;
	}


	/**
	 * 这个方法用于减少植物对象的生命值。
	 * 它将植物对象的生命值减少1。
	 */
	public void subBlood() {
	  blood--;
	}

}
