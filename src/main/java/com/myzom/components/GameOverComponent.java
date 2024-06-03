package com.myzom.components;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;
import com.myzom.data.GameState;
import com.myzom.event.MousePressedEvent;

import java.awt.Graphics;

/**
 * 游戏结束组件
 */
public class GameOverComponent implements Component, MousePressedEvent {

    @Override
    public void initAction() {

    }

    @Override
    public void runAction() {
        if (GameState.getInstance().getState() == ZomConstant.GAME_OVER) {
            GameState.getInstance().getPlants().clear();
            GameState.getInstance().getEnemies().clear();
        }
    }

    @Override
    public void paint(Graphics g) {
        if (GameState.getInstance().getState()==ZomConstant.GAME_OVER) {
            g.drawImage(ZomImages.ZombiesWon, 100, 60, null);
        }
    }

    @Override
    public void mousePressed() {
        if (GameState.getInstance().getState()==ZomConstant.GAME_OVER) {
            GameState.getInstance().setState(ZomConstant.START);
        }
    }
}
