package com.myzom.components;

import com.my.tools.ZomConstant;
import com.myzom.data.GameState;
import com.myzom.enemy.Enemy;
import com.myzom.plants.Bomb;
import com.myzom.plants.BombSource;
import com.myzom.plants.PlantsObject;
import com.myzom.plants.Torchwood;

import java.awt.Graphics;

/**
 * 植物组件
 */
public class PlantsComponent implements Component{

    private final GameState state;

    public PlantsComponent() {
        state = GameState.getInstance();
    }

    @Override
    public void initAction() {

    }

    @Override
    public void runAction() {
        state.getPlants().removeIf(PlantsObject::isRemove);
        shootAction();
        fireBangAction();
    }

    @Override
    public void paint(Graphics g) {
        for(PlantsObject p : state.getPlants()) {
            p.paintObject(g);
        }
    }

    /**
     * 射击
     */
    private void shootAction() {

        for(PlantsObject p : state.getPlants()) {
            for (Enemy e : state.getEnemies()) {
                if (e.getY()+e.getHeight()==p.getY()+85&&e.getX()<= ZomConstant.WIDTH) {
                    if (p instanceof BombSource) {
                        BombSource bombSource = (BombSource) p;
                        bombSource.shoot();
                    }
                }
            }
        }
    }

    /**
     * 炮弹经过火盆处理
     */
    private void fireBangAction() {

        for(PlantsObject p : state.getPlants()) {
            if (p instanceof Torchwood) {
                for(Bomb b : state.getBombs()) {
                    if (p.isLife()&&b.isLife()&&p.hit(b)) {
                        b.setType(2);
                    }
                }
            }
        }
    }
}
