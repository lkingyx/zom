package com.myzom.components;

import com.my.tools.ZomConstant;
import com.my.tools.ZomMusic;
import com.myzom.data.GameState;
import com.myzom.event.MousePressedEvent;
import com.myzom.model.Card;
import com.myzom.model.Floor;
import com.myzom.model.Model;
import com.myzom.plants.*;

import java.awt.*;
import java.util.List;

/**
 * 植物卡牌组件
 */
public class CardComponent implements Component, MousePressedEvent {

    private final GameState state;

    public CardComponent() {
        state = GameState.getInstance();
    }

    @Override
    public void initAction() {
        List<Card> cards = state.getCards();
        cards.add(new Card(0, 0, 10));
        cards.add(new Card(66, 50, 5));
        cards.add(new Card(66*2, 100, 2));
        cards.add(new Card(66*3, 175, 4));
        cards.add(new Card(66*4, 175, 6));
        cards.add(new Card(66*5, 50, 7));
        cards.add(new Card(66*6, 200, 3));
        cards.add(new Card(66*7, 150, 8));
        cards.add(new Card(66*8, 250, 1));
        cards.add(new Card(66*9, 0, 9));
    }

    @Override
    public void runAction() {

    }

    @Override
    public void paint(Graphics g) {
        for(Card c : state.getCards()) {
            c.paintObject(g);
        }
        if(state.getModel() != null) {
            state.getModel().paintObject(g);
        }
    }

    @Override
    public void mousePressed() {
        // 购买植物
        if(state.getState() != ZomConstant.RUNING) return;
        for(Card c : state.getCards()) {
            if (c.hit(state.getUserMouse()) && c.getType() != 10) {
                if(state.getModel() == null && state.getSunCount() >= c.getPrice()) {
                    state.setModel(new Model(state.getUserMouse().getX() - 35, state.getUserMouse().getY() - 35, c.getType()));
                    ZomMusic.getSeedlift().play();
                } else {
                    state.setModel(null);
                    ZomMusic.getSeedlift().play();
                }
            }
        }
        createPlants();
        deletePlant();
    }

    /**
     * 创建植物
     */
    private void createPlants(){

        if(state.getModel() == null) return;
        for(Floor f : state.getFloors()) {
            if (f.hit(state.getUserMouse()) && !f.isUse()) {
                int x = f.getX();
                int y = f.getY();
                ZomMusic.getPlant().play();
                switch (state.getModel().getType()) {
                    case 1:
                        state.getPlants().add(new GatlingPea(x, y));
                        state.subSunCount(250);
                        state.setModel(null);
                        break;
                    case 2:
                        state.getPlants().add(new Peashooter(x, y));
                        state.subSunCount(100);
                        state.setModel(null);
                        break;
                    case 3:
                        state.getPlants().add(new Repeater(x, y));
                        state.subSunCount(200);
                        state.setModel(null);
                        break;
                    case 4:
                        state.getPlants().add(new SnowPea(x, y));
                        state.subSunCount(175);
                        state.setModel(null);
                        break;

                    case 5:
                        state.getPlants().add(new SunFlower(x, y));
                        state.subSunCount(50);
                        state.setModel(null);
                        break;
                    case 6:
                        state.getPlants().add(new Torchwood(x, y));
                        state.subSunCount(175);
                        state.setModel(null);
                        break;
                    case 7:
                        state.getPlants().add(new WallNut(x, y));
                        state.subSunCount(50);
                        state.setModel(null);
                        break;

                    case 8:
                        state.getPlants().add(new TwinSunflower(x, y));
                        state.subSunCount(150);
                        state.setModel(null);
                        break;
                }
                f.setUse(true);
                return;
            }
        }
    }

    /**
     * 删除植物
     */
    private void deletePlant() {

        if (state.getModel()!=null && state.getModel().getType()==9){
            for(PlantsObject p: state.getPlants()) {
                if (p.isLife()&&state.getModel()!=null&&p.hit(state.getModel())&&p.hit(state.getUserMouse())) {
                    for(Floor f:state.getFloors()) {
                        if (f.getX()==p.getX()&&f.getY()==p.getY()) {
                            f.setUse(false);
                        }
                    }
                    p.goDead();
                    state.setModel(null);
                }
            }
        }
    }
}
