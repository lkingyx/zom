package com.myzom.components;

import com.my.tools.ZomThread;
import com.myzom.data.GameState;
import com.myzom.enemy.Enemy;
import com.myzom.plants.Car;

import java.awt.Graphics;

/**
 * 小车组件
 */
public class CarComponent implements Component{

    private final GameState state;

    public CarComponent() {
        state = GameState.getInstance();
    }

    @Override
    public void initAction() {
        createCarAction();
    }

    @Override
    public void runAction() {
        // 小车移动
        for(Car c : state.getCars()) {
            c.step();
        }
        // 小车删除、越界判断
        state.getCars().removeIf(car -> car.outOfBounds() || car.isRemove());
        carBangAction();
    }

    @Override
    public void paint(Graphics g) {
        for(Car c:GameState.getInstance().getCars()) {
            c.paintObject(g);
        }
    }

    /**
     *  小车创建
     */
    private void createCarAction() {

        for(int i=1;i<=5;i++) {
            state.getCars().add(new Car(i*100));
        }
    }

    /**
     * 小车僵尸碰撞检测
     */
    public void carBangAction() {
        for(Enemy e : state.getEnemies()) {
            int ey = e.getY()+e.getHeight();
            for(Car c : state.getCars()) {
                int cy = c.getY()+70;
                if (e.isLife()&&c.isLife()&&ey==cy&&e.hit(c)&&e.rbgHit(c)) {
                    e.goDead();
                    c.goStartMove();
                }

            }

        }
    }
}
