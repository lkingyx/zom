package com.my.tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

/**
 * 工具类
 * @author Administrator
 *
 */
public class Tools {
	/**
	 * 动画
	 * @param index
	 * @return
	 */
	public static BufferedImage getImage(BufferedImage[] images,int index) {
		for (int i = 0,j=0; i < images.length; i++) {
			j+=20;
			if (index%160<j&&(index%160-20)<=j) {
				index = i;
				break;
			}
		}
		return images[index];
	}
	/**
	 * 读取图片
	 * @param str
	 * @return
	 */
	public static BufferedImage readImage(String str) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new FileInputStream(str));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}

}
