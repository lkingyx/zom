package com.myzom.components;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;
import com.my.tools.ZomMusic;
import com.myzom.data.GameState;
import com.myzom.event.MousePressedEvent;
import com.myzom.model.ZomButton;

import java.awt.*;

/**
 * 游戏菜单组件
 * @author llx
 * on 2024/6/1 21:44
 */
public class MenuComponent implements Component, MousePressedEvent {

    private final ZomButton menu = new ZomButton(110, 50, 0, 0);

    private final ZomButton again = new ZomButton(200, 50, 290, 250);

    private final ZomButton menuMain = new ZomButton(200, 50, 290, 320);

    private final ZomButton backGame = new ZomButton(320, 80, 230, 425);

    private final GameState state;

    public MenuComponent() {
        state = GameState.getInstance();
    }

    /**
     * 组件初始化操作
     */
    @Override
    public void initAction() {
        menu.setX(ZomConstant.WIDTH - menu.getWidth());
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
        menu.paintObject(g);
        Font font = ZomConstant.ttf;
        g.setFont(font.deriveFont(Font.PLAIN,23));
        g.drawString("菜单", menu.getX() + 30, menu.getY() + 32);
        if (state.getState()==ZomConstant.PAUSE) {
            g.drawImage(ZomImages.menuback, 180, 30, null);
            again.paintObject(g);
            g.drawString("重新开始", again.getX() + 55, again.getY() + 33);

            menuMain.paintObject(g);
            g.drawString("返回主菜单", menuMain.getX() + 45, menuMain.getY() + 32);
            backGame.paintObject(g);
            g.setFont(font.deriveFont(Font.PLAIN, 40));
            g.drawString("返回游戏", backGame.getX() + 80, backGame.getY() + 52);
        }
    }

    /**
     * 点击事件
     */
    @Override
    public void mousePressed() {
        clickedMenu();
        clickedButton();
    }

    private void clickedMenu() {
        
        if (state.getState()==ZomConstant.RUNING&&menu.hit(state.getUserMouse())) {
            state.setState(ZomConstant.PAUSE);
            menu.ButtonPressed();
            ZomMusic.getGravebutton().play();
            ZomMusic.getac().stop();
        }
    }

    private void clickedButton() {
        if (GameState.getInstance().getState() == ZomConstant.PAUSE) {
            if (backGame.hit(GameState.getInstance().getUserMouse())) {
                GameState.getInstance().setState(ZomConstant.RUNING);
                menu.ButtonPressed();
                ZomMusic.getGravebutton().play();
                ZomMusic.getac().loop();
            }
            if (again.hit(GameState.getInstance().getUserMouse())) {
                clearAll();
                GameState.getInstance().setState(ZomConstant.RUNING);
                ZomMusic.getac().loop();
            }
            if (menuMain.hit(GameState.getInstance().getUserMouse())) {
                clearAll();
                GameState.getInstance().setState(ZomConstant.START);
                ZomMusic.getac().loop();
                ZomMusic.getac().stop();
            }
        }

    }

    private void clearAll() {
        state.initData();
    }
}
