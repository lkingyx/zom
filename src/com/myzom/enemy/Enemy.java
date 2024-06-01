package com.myzom.enemy;

import com.my.tools.ZomImages;
import com.my.tools.ZomMusic;
import com.myzom.superclass.ZomObject;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.util.Random;

/**
 * Enemy类是ZomObject的子类，代表游戏中的敌人。
 * 它包含了敌人的基本属性，如速度、战斗状态、血量和冻结状态等。
 * 它也定义了敌人的基本行为，如移动、检查是否出界、设置战斗状态、减少血量、获取和设置冻结状态等。
 * 具体的敌人类应该继承这个类，并实现具体的行为。
 *
 * @author Administrator
 */
public abstract class Enemy extends ZomObject {
    /**
     * 敌人的速度。
     */
    protected int speed;

    /**
     * 敌人的战斗状态，如果为true，表示敌人正在战斗。
     */
    protected boolean fighting;

	protected static int randonY = 70;

	/**
	 * 敌人的血量。
	 */
	protected int blood;

	/**
	 * 敌人的冻结状态，如果大于0，表示敌人被冻结。
	 */
	protected int freeze;

	/**
	 * 敌人死亡后尸体消失时间（ms）
	 */
	protected long disappearanceTime;

	/**
	 * 敌人的图像。
	 */
	protected Image image = ZomImages.readImage("./images/Zombies/Zombie/ZombieDie.gif");

	/**
	 * 僵尸吃植物音效
	 */
	protected AudioClip chomp;

	/**
	 * 构造函数，用于创建一个新的Enemy对象。
	 * @param width 敌人的宽度
	 * @param height 敌人的高度
	 */
	public Enemy(int width, int height) {
		super(width, height);
		this.x = 800+width;
		Random random = new Random();
		int y =	Integer.parseInt((random.nextInt(5)+1)+"70");
		if (y==randonY) {
			if (y==570) {
				y -= 100;
			}else if (y==170) {
				y += 100;
			}else {
				y += 100;
			}
			randonY = y;
		}
		this.y = y-this.height;
		speed = 2;
		fighting = false;
		freeze = 0;
		disappearanceTime = 1000;
		chomp = JApplet.newAudioClip(ZomMusic.getURL("./sounds/chomp.wav"));
	}

	/**
	 * 敌人移动的方法。
	 */
	public void step() {
		if(!fighting&&isLife()&&freeze<=0) {
			this.x -= speed;
		}else if(freeze>0){
			freeze--;
			this.x -= speed/2;
		}

	}

	/**
	 * 检查敌人是否出界的方法。
	 * @return 如果敌人出界，返回true，否则返回false。
	 */
	public boolean outOfBound() {
		return x<=-this.width;
	}

	/**
	 * true为战斗状态
	 * @param fighting
	 */
	public void setFighting(boolean fighting) {
		this.fighting = fighting;
	}

	/**
	 * 减少敌人的血量的方法。
	 */
	public void subBlood() {
		this.blood--;
	}

	/**
	 * 获取敌人的冻结状态的方法。
	 * @return 敌人的冻结状态
	 */
	public int getFreeze() {
		return freeze;
	}

	/**
	 * 设置敌人的冻结状态的方法。
	 * @param freeze 新的冻结状态
	 */
	public void setFreeze(int freeze) {
		this.freeze = freeze;
	}

	/**
	 * 获取敌人的血量的方法。
	 * @return 敌人的血量
	 */
	public int getBlood() {
		return this.blood;
	}

	/**
	 * 增加敌人的x和y坐标的方法。
	 */
	public void addXY() {
		this.x = this.x+50;
		this.y = this.y+50;

	}

    public boolean isFighting() {
		return fighting;
	}

	public void playChomp(){
		chomp.loop();
	}

	public void stopChomp(){
		chomp.stop();
	}

	@Override
	public void goDead() {
		super.goDead();
		stopChomp();
	}

	public long getDisappearanceTime() {
		return disappearanceTime;
	}

	public void subDisappearanceTime() {
		this.disappearanceTime -= 10;
	}
}
