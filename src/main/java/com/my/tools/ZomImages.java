package com.my.tools;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Image;

public class ZomImages {
	
	public static Image bucketheadZombie0;
	public static Image bucketheadZombie1;
	public static Image coneheadZombie0;
	public static Image coneheadZombie1;
	public static Image Zombie0;
	public static Image Zombie1;
	public static Image PB01;
	public static Image SPBullet;
	public static Image PB10;
	public static Image lawnMower;
	public static Image gatlingPea;
	public static Image peashooter;
	public static Image repeater;
	public static Image snowPea;
	public static Image sun;
	public static Image sunFlower;
	public static Image torchwood;
	public static Image twinSunflower;
	public static Image wallNut;
	public static Image wallNut_cracked1;
	public static Image wallNut_cracked2;
	public static Image CAED1;
	public static Image CAED2;
	public static Image CAED3;
	public static Image CAED4;
	public static Image CAED5;
	public static Image CAED6;
	public static Image CAED7;
	public static Image CAED8;
	public static Image CAED9;
	public static Image CAED10;
	public static Image MODEL1;
	public static Image MODEL2;
	public static Image MODEL3;
	public static Image MODEL4;
	public static Image MODEL5;
	public static Image MODEL6;
	public static Image MODEL7;
	public static Image MODEL8;
	public static Image MODEL9;
	public static Image background;
	public static Image ZombiesWon;
	public static BufferedImage zom1;
	public static BufferedImage zom2;
	public static BufferedImage zom3;
	public static BufferedImage pb01;
	public static BufferedImage gatlingPea_1;
	public static BufferedImage peashooter_1;
	public static BufferedImage repeater_1;
	public static BufferedImage snowPea_1;
	public static BufferedImage sunFlower_1;
	public static BufferedImage torchwood_1;
	public static BufferedImage twinSunflower_1;
	public static BufferedImage wallNut_1;
	public static BufferedImage car;
	public static BufferedImage button;
	public static BufferedImage menuback;
	public static BufferedImage muen;
	public static BufferedImage Store_Background;
	public static BufferedImage b1;
	public static BufferedImage b2;
	public static BufferedImage b3;
	public static BufferedImage b4;
	public static BufferedImage b5;
	public static BufferedImage titlescreen;

	static {
		bucketheadZombie0 = readImage("./images/Zombies/BucketheadZombie/BucketheadZombie00.gif");
		bucketheadZombie1 = readImage("./images/Zombies/BucketheadZombie/BucketheadZombie01.gif");
		coneheadZombie0 = readImage("./images/Zombies/ConeheadZombie/ConeheadZombie00.gif");
		coneheadZombie1 = readImage("./images/Zombies/ConeheadZombie/ConeheadZombie01.gif");
		Zombie0 = readImage("./images/Zombies/Zombie/Zombie00.gif");
		Zombie1 = readImage("./images/Zombies/Zombie/Zombie01.gif");
		PB01 = readImage("./images/Plants/PB01.png");
		SPBullet = readImage("./images/Plants/SnowPeashooterBullet.png");
		PB10 = readImage("./images/Plants/PB10.gif");
		lawnMower = readImage("./images/LawnMower.png");
		gatlingPea = readImage("./images/Plants/GatlingPea/GatlingPea.gif");
		peashooter = readImage("./images/Plants/Peashooter/Peashooter.gif");
		repeater = readImage("./images/Plants/Repeater/Repeater.gif");
		snowPea = readImage("./images/Plants/SnowPea/SnowPea.gif");
		sun = readImage("./images/Sun.gif");
		sunFlower = readImage("./images/Plants/SunFlower/SunFlower.gif");
		torchwood = readImage("./images/Plants/Torchwood/Torchwood.gif");
		twinSunflower = readImage("./images/Plants/TwinSunflower/TwinSunflower.gif");
		wallNut = readImage("./images/Plants/WallNut/WallNut.gif");
		wallNut_cracked1 = readImage("./images/Plants/WallNut/Wallnut_cracked1.gif");
		wallNut_cracked2 = readImage("./images/Plants/WallNut/Wallnut_cracked2.gif");
		CAED1 = readImage(ZomConstant.CAED1);
		CAED2 = readImage(ZomConstant.CAED2);
		CAED3 = readImage(ZomConstant.CAED3);
		CAED4 = readImage(ZomConstant.CAED4);
		CAED5 = readImage(ZomConstant.CAED5);
		CAED6 = readImage(ZomConstant.CAED6);
		CAED7 = readImage(ZomConstant.CAED7);
		CAED8 = readImage(ZomConstant.CAED8);
		CAED9 = readImage(ZomConstant.CAED9);
		CAED10 = readImage(ZomConstant.CAED10);
		MODEL1 = readImage(ZomConstant.MODEL1);
		MODEL2 = readImage(ZomConstant.MODEL2);
		MODEL3 = readImage(ZomConstant.MODEL3);
		MODEL4 = readImage(ZomConstant.MODEL4);
		MODEL5 = readImage(ZomConstant.MODEL5);
		MODEL6 = readImage(ZomConstant.MODEL6);
		MODEL7 = readImage(ZomConstant.MODEL7);
		MODEL8 = readImage(ZomConstant.MODEL8);
		MODEL9 = readImage(ZomConstant.MODEL9);
		background = readImage("./img/background.jpg");
		ZombiesWon = readImage("./images/ZombiesWon.png");
		try {
			zom1 = ImageIO.read(new File("./images/Zombies/zom1.png"));
			zom2 = ImageIO.read(new File("./images/Zombies/zom2.png"));
			zom3 = ImageIO.read(new File("./images/Zombies/zom3.png"));
			pb01 = ImageIO.read(new File("./images/Plants/PB01.png"));
			gatlingPea_1 = ImageIO.read(new File("./images/Plants/GatlingPea/GatlingPea.gif"));
			peashooter_1 = ImageIO.read(new File("./images/Plants/Peashooter/Peashooter.gif"));
			repeater_1 = ImageIO.read(new File("./images/Plants/Repeater/Repeater.gif"));
			snowPea_1 = ImageIO.read(new File("./images/Plants/SnowPea/SnowPea.gif"));
			sunFlower_1 = ImageIO.read(new File("./images/Plants/SunFlower/SunFlower.gif"));
			torchwood_1 = ImageIO.read(new File("./images/Plants/Torchwood/Torchwood.gif"));
			twinSunflower_1 = ImageIO.read(new File("./images/Plants/TwinSunflower/TwinSunflower.gif"));
			wallNut_1 = ImageIO.read(new File("./images/Plants/WallNut/WallNut.gif"));
			car = ImageIO.read(new File("./images/LawnMower.png"));
			button = ImageIO.read(new File("./images/button/button.png"));
			menuback = ImageIO.read(new File("./images/button/options_menuback.png"));
			muen = ImageIO.read(new File("./images/button/muen.png"));
			Store_Background = ImageIO.read(new File("./images/button/Store_Background.jpg"));
			b1 = ImageIO.read(new File("./images/button/b1.png"));
			b2 = ImageIO.read(new File("./images/button/b2.png"));
			b3 = ImageIO.read(new File("./images/button/b3.png"));
			b4 = ImageIO.read(new File("./images/button/b4.png"));
			b5 = ImageIO.read(new File("./images/button/b5.png"));
			titlescreen = ImageIO.read(new File("./images/titlescreen.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static Image readImage(String str) {
		return Toolkit.getDefaultToolkit().createImage(str);
	}
}
