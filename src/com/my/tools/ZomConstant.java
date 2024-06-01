package com.my.tools;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ZomConstant {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final int LIFE = 0;
	public static final int DEAD = 1;
	public static final int REMOVE = 2;
	/**
	 * 单向日葵 
	 */
	public static final String MODEL1 = "./images/Card/Plants/1.png";
	/**
	 * 火盘
	 */
	public static final String MODEL2 = "./images/Card/Plants/2.png";
	/**
	 * 土豆
	 */
	public static final String MODEL3 = "./images/Card/Plants/3.png";
	/**
	 * 寒冰抢手
	 */
	public static final String MODEL4 = "./images/Card/Plants/4.png";
	/**
	 * 单发豆
	 */
	public static final String MODEL5 = "./images/Card/Plants/5.png";
	/**
	 * 机关枪
	 */
	public static final String MODEL6 = "./images/Card/Plants/6.png";
	/**
	 * 两发豆
	 */
	public static final String MODEL7 = "./images/Card/Plants/7.png";
	/**
	 * 	双向日葵
	 */
	public static final String MODEL8 = "./images/Card/Plants/8.png";
	/**
	 * 铲子
	 */
	public static final String MODEL9 = "./images/cz.png";
	
	/**
	 * 机关枪
	 */
	public static final String CAED1 = "./images/Card/Plants/GatlingPea1.png";
	/**
	 * 单发豆
	 */
	public static final String CAED2 = "./images/Card/Plants/Peashooter1.png";
	/**
	 * 两发豆
	 */
	public static final String CAED3 = "./images/Card/Plants/Repeater1.png";
	/**
	 * 寒冰抢手
	 */
	public static final String CAED4 = "./images/Card/Plants/SplitPea1.png";
	
	/**
	 * 单向日葵
	 * 
	 */
	public static final String CAED5 = "./images/Card/Plants/SunFlower1.png";
	/**
	 * 火盘
	 */
	public static final String CAED6 = "./images/Card/Plants/Torchwood1.png";
	/**
	 * 土豆
	 */
	public static final String CAED7 = "./images/Card/Plants/WallNut1.png";
	/**
	 * 	双向日葵
	 */
	public static final String CAED8 = "./images/Card/Plants/TwinSunflower1.png";
	/**
	 * 铲子
	 */
	public static final String CAED9 = "./images/chanzi.png";
	/**
	 * 阳光
	 */
	public static final String CAED10 = "./images/Card/Plants/sun.png";
	
	public static final int START = 0;
	public static final int RUNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3; 
	public static final int START_UP = 4;
	public static Font ttf;
	static {
		try {
			FileInputStream fis = new FileInputStream("./fzse_gbk.ttf");
			ttf = Font.createFont(Font.TRUETYPE_FONT, fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
