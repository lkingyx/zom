package com.myzom.enemy;

import java.awt.Image;
import java.awt.image.BufferedImage;
import com.my.tools.ZomImages;

/**
 * Conehead类是Enemy的子类，代表游戏中的路障僵尸。
 * 它包含了路障僵尸的基本属性和行为。
 * 它也定义了路障僵尸的图像，这些图像在静态初始化块中被初始化。
 *
 * @author Administrator
 */
public class Conehead extends Enemy {

    /**
     * 存储路障僵尸的图像的数组。
     */
    private static final Image[] images;

    /**
     * 静态初始化块，用于初始化路障僵尸的图像。
     */
    static {
        images = new Image[2];
        images[0] = ZomImages.coneheadZombie0;
        images[1] = ZomImages.coneheadZombie1;
    }

    /**
     * 构造函数，用于创建一个新的Conehead对象。
     */
    public Conehead() {
        super(166, 144);
        blood = 25;
    }

    /**
     * 获取路障僵尸的图像的方法。
     * @return 路障僵尸的图像
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
     * 获取路障僵尸的缓冲图像的方法。
     * @return 路障僵尸的缓冲图像
     */
    @Override
    public BufferedImage getBuff() {
        return ZomImages.zom3;
    }
}
