package com.myzom.components;

import com.my.tools.ZomConstant;
import com.my.tools.ZomMusic;
import com.myzom.data.GameState;
import com.myzom.event.MousePressedEvent;
import com.myzom.plants.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 太阳组件
 */
public class SunComponent implements Component, MousePressedEvent {

    /**
     * 环境阳光生成间隔时间（ms）
     */
    private final long envSunInterval;

    private final GameState state;

    public SunComponent() {
        state = GameState.getInstance();
        envSunInterval = 30000;
    }

    @Override
    public void initAction() {

    }

    @Override
    public void runAction() {

        sunGenerateAction();
        for(Sun s : state.getEnvSuns()) {
            s.step();
        }
        state.getPlantSuns().removeIf(Sun::isRemove);
        state.getEnvSuns().removeIf(Sun::isRemove);
    }

    @Override
    public void paint(Graphics g) {
        for(Sun s : state.getEnvSuns()) {
            s.paintObject(g);
        }
        for(Sun s : state.getPlantSuns()) {
            s.paintObject(g);
        }
        g.setColor(Color.white);
        g.drawString(state.getSunCount()+"", 25, 70);
    }

    @Override
    public void mousePressed() {
        sunBangAction();
    }

    /**
     * 生成一个太阳
     * @return 生成的太阳
     */
    private Sun nextOneSun() {
        Random random = new Random();
        int x = random.nextInt(ZomConstant.WIDTH - 66);
        int y = 0;
        return new Sun(x, y);
    }

    /**
     * 太阳生成逻辑
     */
    private void sunGenerateAction() {
        if (state.getRunTimeMillis() % envSunInterval == 0) {
            state.getEnvSuns().add(nextOneSun());
        }
        for(PlantsObject p:state.getPlants()) {
            if (p instanceof SunFlower) {
                SunFlower sFlower = (SunFlower)p;
                if (sFlower.getGenerateTime() <= 0) {
                    state.getPlantSuns().add(sFlower.createSun());
                    sFlower.addGenerateTime();
                }
                sFlower.subGenerateTime();
            }
            if (p instanceof TwinSunflower) {
                TwinSunflower tsf = (TwinSunflower)p;
                if (tsf.getGenerateTime()<=0) {
                    state.getPlantSuns().addAll(tsf.createSun());
                    tsf.addGenerateTime();
                }
                tsf.subGenerateTime();
            }
        }
    }

    /**
     * 负责处理游戏中用户鼠标与太阳对象之间的交互。
     * 如果用户的鼠标击中太阳对象，太阳对象将被移除，并且游戏状态中的太阳计数将增加25。
     * 此方法处理环境太阳和植物生成的太阳。
     */
    public void sunBangAction() {
        List<Sun> allSuns = new ArrayList<>();
        allSuns.addAll(state.getEnvSuns());
        allSuns.addAll(state.getPlantSuns());

        for(Sun s: allSuns) {
            if (s.hit(state.getUserMouse())) {
                ZomMusic.getPoints().play();
                state.addSunCount(25);
                s.goRemove();
            }
        }
    }
}
