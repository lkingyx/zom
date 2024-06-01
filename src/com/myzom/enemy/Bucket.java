package com.myzom.enemy;

import java.awt.Image;
import java.awt.image.BufferedImage;

import com.my.tools.ZomImages;

/**
 * Bucket类是Enemy的子类，代表游戏中的铁桶僵尸。
 * 它包含了铁桶僵尸的基本属性和行为。
 * 它也定义了铁桶僵尸的图像，这些图像在静态初始化块中被初始化。
 *
 * @author Administrator
 */
public class Bucket extends Enemy{
    /**
     * 存储铁桶僵尸的图像的数组。
     */
    private static final Image[] images;

    /**
     * 静态初始化块，用于初始化铁桶僵尸的图像。
     */
    static {
        images = new Image[2];
        images[0] = ZomImages.bucketheadZombie0;
        images[1] = ZomImages.bucketheadZombie1;
    }

    /**
     * 构造函数，用于创建一个新的Bucket对象。
     */
    public Bucket() {
        super(166, 144);
        blood = 50;
        speed = 4;
    }

    /**
     * 获取铁桶僵尸的图像的方法。
     * @return 铁桶僵尸的图像
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
     * 获取铁桶僵尸的缓冲图像的方法。
     * @return 铁桶僵尸的缓冲图像
     */
    @Override
    public BufferedImage getBuff() {
        return ZomImages.zom1;
    }
}
