package com.myzom.components;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;

/**
 * 背景组件
 */
public class BackgroundComponent implements Component {

    /**
     * 绘制背景图片中的坐标
     */
    private static final List<Integer> DRAW_IMAGE_POINT = Arrays.asList(220, 0, 1020, 600);

    @Override
    public void initAction() {

    }

    @Override
    public void runAction() {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ZomImages.background, 0, 0, ZomConstant.WIDTH, ZomConstant.HEIGHT,
                DRAW_IMAGE_POINT.get(0),DRAW_IMAGE_POINT.get(1),DRAW_IMAGE_POINT.get(2),DRAW_IMAGE_POINT.get(3) , null);
    }
}
