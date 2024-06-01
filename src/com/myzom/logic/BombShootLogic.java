package com.myzom.logic;

import com.my.tools.ZomMusic;
import com.myzom.data.GameState;
import com.myzom.plants.Bomb;
import com.myzom.plants.PlantsObject;

/**
 * BombShootLogic类定义了一个植物的射击逻辑。
 */
public class BombShootLogic {

    /**
     * 植物的最大弹量
     */
    private final int bombNum;

    /**
     * 植物的当前弹量
     */
    private int currentBombNum;

    /**
     * 植物炮弹每发发射间隔时间（ms）
     */
    private long bombInterval;

    /**
     * 植物炮弹每轮发射间隔时间（ms）
     */
    private long roundInterval;

    /**
     * 植物的上次发射炮弹时间（ms）
     */
    private long lastBombTime;

    /**
     * 植物
     */
    private final PlantsObject plantsObject;

    /**
     * 构造函数，用于创建一个新的BombShootLogic对象。
     * @param bombNum 植物的最大弹量
     * @param bombInterval 植物炮弹每发发射间隔时间（ms）
     * @param plantsObject 植物
     */
    public BombShootLogic(int bombNum, long bombInterval, PlantsObject plantsObject) {
        this.bombNum = bombNum;
        this.bombInterval = bombInterval;
        this.plantsObject = plantsObject;
        currentBombNum = 0;
        roundInterval = 2000;
        lastBombTime = 0;
    }

    /**
     * 植物的射击方法。
     * 植物每次射击时，会发射一轮炮弹。
     * 植物的射击逻辑是：如果上次发射炮弹的时间距离当前时间大于等于炮弹每轮发射间隔时间，那么发射一轮炮弹；
     * 如果植物的当前炮弹数量不为0且小于最大炮弹数量，并且当前时间距离上次发射炮弹的时间是炮弹发射间隔时间的倍数，那么发射一轮炮弹。
     */
    public void shoot() {

        // 新一轮炮弹发射
        long runTime = GameState.getInstance().getRunTimeMillis();
        if (lastBombTime == 0 || (currentBombNum == 0 && lastBombTime + roundInterval <= runTime)) {
            lastBombTime = GameState.getInstance().getRunTimeMillis();
            createAndAddBomb();
            currentBombNum++;
        } else if (currentBombNum != 0 && currentBombNum < bombNum && (runTime - lastBombTime) % bombInterval == 0) {
            createAndAddBomb();
            currentBombNum++;
        }
        if (currentBombNum == bombNum) {
            currentBombNum = 0;
        }

    }

    /**
     * 创建并添加炮弹
     */
    private void createAndAddBomb() {
        int x = this.plantsObject.getX() + this.plantsObject.getWidth();
        int y = this.plantsObject.getY() + 10;
        GameState.getInstance().getBombs().add(new Bomb(x, y, 0));
        ZomMusic.getLimbs_pop().play();
    }
}
