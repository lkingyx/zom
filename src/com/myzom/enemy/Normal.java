package com.myzom.enemy;

import java.awt.Image;
import java.awt.image.BufferedImage;
import com.my.tools.ZomImages;

/**
 * Normal类是Enemy的子类，代表游戏中的普通僵尸。
 * 它包含了普通僵尸的基本属性和行为。
 * 它也定义了普通僵尸的图像，这些图像在静态初始化块中被初始化。
 *
 * @author Administrator
 */
public class Normal extends Enemy {

    /**
     * 存储普通僵尸的图像的数组。
     */
    private static final Image[] images;

    /**
     * 静态初始化块，用于初始化普通僵尸的图像。
     */
    static {
        images = new Image[2];
        images[0] = ZomImages.Zombie0;
        images[1] = ZomImages.Zombie1;
    }

    /**
     * 构造函数，用于创建一个新的Normal对象。
     */
    public Normal() {
        super(166, 144);
        blood = 10;
    }

    /**
     * 获取普通僵尸的图像的方法。
     * @return 普通僵尸的图像
     */
    @Override
    public Image getImage() {
        if(isLife()) {
            if (fighting) {
                return images[1];
            } else {
                return images[0];
            }
        } else if (isDead()) {
            return image;
        }
        return null;
    }

    /**
     * 获取普通僵尸的缓冲图像的方法。
     * @return 普通僵尸的缓冲图像
     */
    @Override
    public BufferedImage getBuff() {
        return ZomImages.zom2;
    }
}
