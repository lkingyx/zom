package com.myzom.components;

import com.my.tools.ZomMusic;
import com.myzom.data.GameState;
import com.myzom.enemy.Enemy;
import com.myzom.plants.Bomb;

import java.awt.Graphics;

/**
 * 炮弹组件
 */
public class BombComponent implements Component{

    private final GameState state;

    public BombComponent() {
        state = GameState.getInstance();
    }

    @Override
    public void initAction() {

    }

    @Override
    public void runAction() {
        stepBombAction();
        state.getBombs().removeIf(bomb -> bomb.outOfBounds() || bomb.isRemove());
        bombBangAction();
    }

    @Override
    public void paint(Graphics g) {
        for(Bomb b : state.getBombs()) {
            b.paintObject(g);
        }
    }

    /**
     * 炮弹移动
     */
    public void stepBombAction() {
        for(Bomb b : state.getBombs()) {
            b.step();
        }
    }

    /**
     * 炮弹与僵尸碰撞检测
     */
    public void bombBangAction() {
        for(Bomb b : state.getBombs()) {
            for(Enemy e : state.getEnemies()) {
                if (b.isLife()&&e.isLife()&&e.hit(b)&&e.rbgHit(b)) {
                    ZomMusic.getKernelpult().play();
                    b.goDead();
                    if (b.getType()==1) {
                        e.setFreeze(100);
                        e.subBlood();
                    }else if (b.getType()==2) {
                        e.subBlood();
                        e.subBlood();
                    }else {
                        e.subBlood();
                    }
                }
            }
        }

    }
}
