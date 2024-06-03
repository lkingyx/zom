package com.myzom.superclass;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import com.my.tools.ZomConstant;

/**
 * ZomObject类是所有植物和僵尸的超类。
 * 它定义了一些共享的属性和方法，如状态、宽度、高度、x坐标和y坐标等。
 * 它也定义了一些共享的行为，如绘制对象、碰撞检测、生命状态检测等。
 * 具体的植物和僵尸类应该继承这个类，并实现具体的行为。
 *
 * @author Administrator
 */
public abstract class ZomObject {

	 /**
	  * 对象的状态，可以是LIFE、DEAD或REMOVE。
	  */
	 protected int state;

	 /**
	  * 对象的宽度。
	  */
	 protected int width;

	 /**
	  * 对象的高度。
	  */
	 protected int height;

	 /**
	  * 对象的x坐标。
	  */
	 protected int x;

	 /**
	  * 对象的y坐标。
	  */
	 protected int y;

	 /**
	  * 构造函数，用于创建一个新的ZomObject对象。
	  * @param width 对象的宽度
	  * @param height 对象的高度
	  * @param x 对象的x坐标
	  * @param y 对象的y坐标
	  */
	 public ZomObject(int width, int height, int x, int y) {
		 super();
		 this.width = width;
		 this.height = height;
		 this.x = x;
		 this.y = y;
	 }

	 /**
	  * 构造函数，用于创建一个新的ZomObject对象。
	  * @param width 对象的宽度
	  * @param height 对象的高度
	  */
	 public ZomObject(int width, int height) {
	  super();
	  this.width = width;
	  this.height = height;
	 }

	 /**
	  * 获取对象的图像。
	  * @return 对象的图像
	  */
	 public abstract Image getImage() ;

	 /**
	  * 在画布上绘制对象。
	  * @param g 画布
	  */
	 public void paintObject(Graphics g) {
		 g.drawImage(getImage(),this.x,this.y,null);
	 }

	 /**
	  * 检查这个对象是否与另一个对象碰撞。
	  * @param obj 另一个对象
	  * @return 如果两个对象碰撞，返回true，否则返回false。
	  */
	 public boolean hit(ZomObject obj) {
		 int x1 = this.x-obj.width;
		 int x2 = this.x+this.width;
		 int y1 = this.y-obj.height;
		 int y2 = this.y+this.height;
		 int x = obj.x;
		 int y = obj.y;
		 return x>x1&&x<x2&&y>y1&&y<y2;
	 }

	 /**
	  * 检查对象是否还活着。
	  * @return 如果对象还活着，返回true，否则返回false。
	  */
	 public boolean isLife() {
		 return state == ZomConstant.LIFE;
	 }

	 /**
	  * 检查对象是否已经死亡。
	  * @return 如果对象已经死亡，返回true，否则返回false。
	  */
	 public boolean isDead() {
		 return state == ZomConstant.DEAD;
	 }

	 /**
	  * 检查对象是否应该被移除。
	  * @return 如果对象应该被移除，返回true，否则返回false。
	  */
	 public boolean isRemove() {
		 return state == ZomConstant.REMOVE;
	 }

	 /**
	  * 将对象的状态设置为REMOVE。
	  */
	 public void goRemove() {
		 state = ZomConstant.REMOVE;
	 }

	 /**
	  * 将对象的状态设置为DEAD。
	  */
	 public void goDead() {
		 state = ZomConstant.DEAD;
	 }

	 /**
	  * 获取对象的缓冲图像。
	  * @return 对象的缓冲图像
	  */
	 public abstract BufferedImage getBuff();

	 /**
	  * 使用RGB值检查这个对象是否与另一个对象碰撞。
	  * @param obj 另一个对象
	  * @return 如果两个对象碰撞，返回true，否则返回false。
	  */
	 public boolean rbgHit(ZomObject obj) {
		 BufferedImage b1 = this.getBuff();
		 BufferedImage b2 = obj.getBuff();
		 Rectangle r1 = new Rectangle(this.x, this.y, b1.getWidth(),b1.getHeight());
		 Rectangle r2 = new Rectangle(obj.x, obj.y, b2.getWidth(), b2.getHeight());
		 Rectangle r12 = r1.intersection(r2);
		 int x1 = r12.x-this.x;
		 int y1 = r12.y-this.y;
		 int x2 = r12.x-obj.x;
		 int y2 = r12.y-obj.y;
		 if (r12.width>0&&r12.height>0) {
			 for(int i=0;i<r12.width;i++) {
				 for(int j=0;j<r12.height;j++) {
					 int b1Rgb = b1.getRGB(x1+i, y1+j);
					 int b2Rgb = b2.getRGB(x2+i, y2+j);
					 int b1a = (b1Rgb & 0xff000000)>>24;
					 int b2a = (b2Rgb & 0xff000000)>>24;
					 if (b1a==-1&&b2a==-1) {
						 return true;
					 }
				 }
			 }
		 }
	 	return false;
	 }

	 /**
	  * 获取对象的宽度。
	  * @return 对象的宽度
	  */
	 public int getWidth() {
		 return width;
	 }

	 /**
	  * 获取对象的高度。
	  * @return 对象的高度
	  */
	 public int getHeight() {
		 return height;
	 }

	 /**
	  * 获取对象的x坐标。
	  * @return 对象的x坐标
	  */
	 public int getX() {
		 return x;
	 }

	 /**
	  * 获取对象的y坐标。
	  * @return 对象的y坐标
	  */
	 public int getY() {
		 return y;
	 }

}
