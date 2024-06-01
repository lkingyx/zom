package com.myzom.data;

import com.my.tools.ZomConstant;
import com.myzom.components.Component;
import com.myzom.enemy.Enemy;
import com.myzom.event.GameEvent;
import com.myzom.model.Card;
import com.myzom.model.Floor;
import com.myzom.model.Model;
import com.myzom.model.UserMouse;
import com.myzom.plants.Bomb;
import com.myzom.plants.Car;
import com.myzom.plants.PlantsObject;
import com.myzom.plants.Sun;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 游戏状态、数据
 */
public class GameState {
    /**
     * 敌人
     */
    private final List<Enemy> enemies = new CopyOnWriteArrayList<>();

    /**
     * 植物卡牌
     */
    private final List<Card> cards = new CopyOnWriteArrayList<>();

    /**
     * 地板
     */
    private final List<Floor> floors = new CopyOnWriteArrayList<>();

    /**
     * 植物
     */
    private final List<PlantsObject> plants = new CopyOnWriteArrayList<>();

    /**
     * 子弹
     */
    private final List<Bomb> bombs = new CopyOnWriteArrayList<>();

    /**
     * 小车
     */
    private final List<Car> cars = new CopyOnWriteArrayList<>();

    /**
     * 环境太阳
     */
    private final List<Sun> envSuns = new CopyOnWriteArrayList<>();

    /**
     * 植物太阳
     */
    private final List<Sun> plantSuns = new CopyOnWriteArrayList<>();

    /**
     * 鼠标模型
     */
    private Model model;

    /**
     * 阳光数量
     */
    private int sunCount;

    /**
     * 游戏计时（毫秒）
     */
    private long runTimeMillis;

    /**
     * 游戏状态
     */
    private int state;

    /**
     * 鼠标类
     */
    private final UserMouse userMouse;

    /**
     * 游戏组件
     */
    private final List<Component> componentList;

    /**
     * 游戏事件列表
     */
    private final List<GameEvent> gameEventList;

    private static GameState gameState;

    public GameState(){
        sunCount = 500;
        runTimeMillis = 0;
        state = ZomConstant.START_UP;
        userMouse = new UserMouse();
        componentList = new ArrayList<>();
        gameEventList = new ArrayList<>();
    }

    public static GameState getInstance() {
        if (gameState == null) {
            gameState = new GameState();
        }
        return gameState;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<PlantsObject> getPlants() {
        return plants;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Sun> getEnvSuns() {
        return envSuns;
    }

    public List<Sun> getPlantSuns() {
        return plantSuns;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getSunCount() {
        return sunCount;
    }

    public void setSunCount(int sunCount) {
        this.sunCount = sunCount;
    }

    public void subSunCount(int sunCount) {
        this.sunCount -= sunCount;
    }

    public void addSunCount(int sunCount) {
        this.sunCount += sunCount;
    }

    public long getRunTimeMillis() {
        return runTimeMillis;
    }

    public void setRunTimeMillis(long runTimeMillis) {
        this.runTimeMillis = runTimeMillis;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public UserMouse getUserMouse() {
        return userMouse;
    }

    public void initData() {
        enemies.clear();
        floors.clear();
        plants.clear();
        bombs.clear();
        cars.clear();
        envSuns.clear();
        plantSuns.clear();
        model = null;
        sunCount = 50;
        runTimeMillis = 10;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public List<GameEvent> getGameEventList() {
        return gameEventList;
    }
}
