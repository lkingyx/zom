package com.myzom.event;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;
import com.myzom.components.Component;
import com.myzom.data.GameState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 游戏鼠标适配器
 * @author llx
 * on 2024/6/1 22:03
 */
public class GameMouseAdapter extends MouseAdapter {

    private final GameState state;

    public GameMouseAdapter() {
        state = GameState.getInstance();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        int x = e.getX();
        int y = e.getY();
        GameState.getInstance().getUserMouse().moveMouse(x, y);
        if(GameState.getInstance().getModel()!=null) {
            GameState.getInstance().getModel().moveTo(x, y);
        }
        for (GameEvent gameEvent : state.getGameEventList()) {
            if (gameEvent instanceof MouseMovedEvent) {
                ((MouseMovedEvent) gameEvent).mouseMoved();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        for (GameEvent gameEvent : state.getGameEventList()) {
            if (gameEvent instanceof MousePressedEvent) {
                ((MousePressedEvent) gameEvent).mousePressed();
            }
        }
    }
}
