package com.myzom.components;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;
import com.my.tools.ZomMusic;
import com.myzom.data.GameState;
import com.myzom.event.MouseMovedEvent;
import com.myzom.event.MousePressedEvent;
import com.myzom.model.ZomButton;

import java.awt.Graphics;

/**
 * 游戏开始页面组件
 * @author llx
 * on 2024/6/1 21:58
 */
public class StartPageComponent implements Component, MouseMovedEvent, MousePressedEvent {

    private final ZomButton startGame = new ZomButton(331, 146, 0, 0);

    private final GameState state;

    public StartPageComponent() {
        state = GameState.getInstance();
    }

    /**
     * 组件初始化操作
     */
    @Override
    public void initAction() {
        startGameAction();
    }

    /**
     * 运行中组件操作
     */
    @Override
    public void runAction() {

    }

    /**
     * 组件画图
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        if (state.getState()==ZomConstant.START||state.getState()==ZomConstant.START_UP) {
            g.drawImage(ZomImages.Store_Background, 0, 0, null);
            g.drawImage(ZomImages.muen, 0, -3, null);
            startGame.paintObject(g);
            g.drawImage(ZomImages.b3, 410, 155, null);
            g.drawImage(ZomImages.b4, 410, 240, null);
            g.drawImage(ZomImages.b5, 410, 315, null);
        }
    }

    /**
     * 点击事件
     */
    @Override
    public void mousePressed() {
        if (state.getState() == ZomConstant.START || state.getState() == ZomConstant.START_UP) {
            if (startGame.hit(state.getUserMouse())) {
                state.setState(ZomConstant.RUNING);
                ZomMusic.getGravebutton().play();
                ZomMusic.getac().loop();
            }
        }
    }

    public void startGameAction() {
        startGame.setImage(ZomImages.b1);
        startGame.setX(410);
        startGame.setY(50);
    }

    /**
     * 移动事件
     */
    @Override
    public void mouseMoved() {
        if (state.getState()==ZomConstant.START || state.getState()==ZomConstant.START_UP) {
            if (startGame.hit(state.getUserMouse())) {
                startGame.setImage(ZomImages.b2);
            }else {
                startGame.setImage(ZomImages.b1);
            }
        }
    }
}
