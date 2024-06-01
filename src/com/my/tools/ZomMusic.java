package com.my.tools;

import java.applet.AudioClip;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;

public class ZomMusic {

	private static AudioClip ac ;
	private static AudioClip chomp;
	private static AudioClip gravebutton;
	private static AudioClip kernelpult;
	private static AudioClip limbs_pop;
	private static AudioClip losemusic;
	private static AudioClip plant;
	private static AudioClip points;
	private static AudioClip seedlift;
	static {
		try {
			ac = JApplet.newAudioClip(getURL("./day.wav"));
			chomp = JApplet.newAudioClip(getURL("./sounds/chomp.wav"));
			gravebutton = JApplet.newAudioClip(getURL("./sounds/gravebutton.wav"));
			kernelpult = JApplet.newAudioClip(getURL("./sounds/kernelpult.wav"));
			limbs_pop = JApplet.newAudioClip(getURL("./sounds/limbs_pop.wav"));
			losemusic = JApplet.newAudioClip(getURL("./sounds/losemusic.wav"));
			plant = JApplet.newAudioClip(getURL("./sounds/plant.wav"));
			points = JApplet.newAudioClip(getURL("./sounds/points.wav"));
			seedlift = JApplet.newAudioClip(getURL("./sounds/seedlift.wav"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * 背景音乐
	 * @return
	 */
	public static AudioClip getac() {
		return ac;
	}
	/**
	 * 僵尸吃植物
	 * @return
	 */
	public static AudioClip getChomp() {
		return chomp;
	}
	/**
	 * 按钮音效
	 * @return
	 */
	public static AudioClip getGravebutton() {
		return gravebutton;
	}
	/**
	 * 打僵尸音效
	 * @return
	 */
	public static AudioClip getKernelpult() {
		return kernelpult;
	}
	/**
	 * 发子弹音效
	 * @return
	 */
	public static AudioClip getLimbs_pop() {
		return limbs_pop;
	}
	/**
	 * 游戏结束音效
	 * @return
	 */
	public static AudioClip getLosemusic() {
		return losemusic;
	}
	/**
	 * 放植物音效
	 * @return
	 */
	public static AudioClip getPlant() {
		return plant;
	}
	/**
	 * 点阳光音效
	 * @return
	 */
	public static AudioClip getPoints() {
		return points;
	}
	/**
	 * 卡片音效
	 * @return
	 */
	public static AudioClip getSeedlift() {
		return seedlift;
	}

	public static URL getURL(String path) {
        URL url = null;
        try {
            url = new File(path).toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
	}

}
