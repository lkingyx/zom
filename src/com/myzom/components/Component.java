package com.myzom.components;

import java.awt.*;

/**
 * 组件接口
 */
public interface Component {

    /**
     * 组件初始化操作
     */
    void initAction();

    /**
     * 运行中组件操作
     */
    void runAction();

    /**
     * 组件画图
     */
    void paint(Graphics g);
}
