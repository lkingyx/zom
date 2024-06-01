package com.myzom.components;

import com.my.tools.ZomConstant;
import com.my.tools.ZomMusic;
import com.my.tools.ZomThread;
import com.myzom.data.GameState;
import com.myzom.enemy.Bucket;
import com.myzom.enemy.Conehead;
import com.myzom.enemy.Enemy;
import com.myzom.enemy.Normal;
import com.myzom.model.Floor;
import com.myzom.plants.PlantsObject;

import java.awt.Graphics;
import java.util.Random;

/**
 * 敌人组件
 */
public class EnemyComponent implements Component{

    private final GameState state;

    /**
     * 创建速度（毫秒/个）
     */
    private int createSpeed;

    public EnemyComponent() {
        state = GameState.getInstance();
        createSpeed = 20000;
    }

    @Override
    public void initAction() {

    }

    @Override
    public void runAction() {
        enemyAction();
        if(state.getRunTimeMillis() % 150 == 0) {
            for(Enemy e : state.getEnemies()) {
                e.step();
            }
        }
        state.getEnemies().removeIf(Enemy::isRemove);
        zombiesLoop();
    }

    @Override
    public void paint(Graphics g) {
        for (Enemy e:state.getEnemies()) {
            e.paintObject(g);
        }
    }

    /**
     * 僵尸对象循环
     */
    private void zombiesLoop() {
        for(Enemy enemy : state.getEnemies()) {
            zombiesEatPlants(enemy);
            detectEnemyBlood(enemy);
            detectZombiesEnterHouse(enemy);
            detectEnemyRemoved(enemy);
        }
    }

    /**
     * 创建僵尸
     * @return Enemy
     */
    private Enemy nextOne () {
        Random random = new Random();
        int type = random.nextInt(30);
        if(state.getRunTimeMillis() < 100000) {
            return new Normal();
        } else if(state.getRunTimeMillis() < 360000){
            if (type<10) {
                return new Conehead();
            }else {
                return new Normal();
            }
        }else {
            return new Bucket();
        }
    }

    /**
     * 敌人行动方法。
     * 如果游戏运行时间满足创建僵尸的条件（即运行时间是创建速度的倍数，并且运行时间大于等于30000毫秒），则创建一个新的僵尸。
     * 如果创建速度大于等于2000，并且游戏运行时间是60000毫秒的倍数，则将创建速度减少2000，但不会低于1000。
     */
    private void enemyAction() {

        if (state.getRunTimeMillis() % createSpeed == 0 && state.getRunTimeMillis() >= 30000) {
            state.getEnemies().add(nextOne());
        }
        if (createSpeed >= 2000 && state.getRunTimeMillis() % 60000 == 0) {
            createSpeed = Math.max(1000, createSpeed - 2000);
        }
    }

    /**
     * 检测僵尸是否进入房子的方法。
     * 如果有僵尸出界（即进入了房子），则将游戏状态设置为游戏结束，并播放失败音乐。
     */
    private void detectZombiesEnterHouse(Enemy enemy) {
        if (enemy.outOfBound()) {
            state.setState(ZomConstant.GAME_OVER);
            ZomMusic.getLosemusic().play();
        }
    }

    /**
     * 这个方法处理僵尸吃植物的逻辑。
     * 对于游戏状态中的每一个植物和僵尸，如果植物和僵尸都还活着，并且他们在同一行上，且僵尸碰到了植物，那么植物的血量就会减少。
     * 如果僵尸还没有开始战斗，那么它就会开始播放咀嚼的声音，并且将其状态设置为正在战斗。
     * 如果植物的血量降到0或以下，那么植物就会死亡并被移除，同时僵尸会停止战斗和咀嚼的声音。
     */
    private void zombiesEatPlants(Enemy e) {

        for(PlantsObject p:state.getPlants()) {
            int py = p.getY() + 85;
            int ey = e.getY() + e.getHeight();
            if (p.isLife() && e.isLife() && py == ey && e.hit(p) && e.rbgHit(p)) {
                p.subBlood();
                if (!e.isFighting()) {
                    e.playChomp();
                }
                e.setFighting(true);
                if (p.getBlood() <= 0) {
                    for(Floor f:state.getFloors()) {
                        if (f.getX()==p.getX()&&f.getY()==p.getY()) {
                            f.setUse(false);
                        }
                    }
                    p.goDead();
                    p.goRemove();
                    e.setFighting(false);
                    e.stopChomp();
                }
            }
        }
    }

    /**
     * 检测敌人血量
     */
    private void detectEnemyBlood(Enemy enemy) {
        if (enemy.getBlood() <= 0) {
            enemy.goDead();
        }
    }

    /**
     * 检测敌人对象是否可以删除
     * @param enemy
     */
    private void detectEnemyRemoved(Enemy enemy) {
        if (enemy.isDead()){
            if (enemy.getDisappearanceTime() <= 0) {
                enemy.goRemove();
                return;
            }
            enemy.subDisappearanceTime();
        }
    }
}
