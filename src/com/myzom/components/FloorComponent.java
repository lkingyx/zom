package com.myzom.components;

import com.myzom.data.GameState;
import com.myzom.model.Floor;

import java.awt.Graphics;

/**
 * 地板组件
 */
public class FloorComponent implements Component {

    @Override
    public void initAction() {
        createFloorAction();
    }

    @Override
    public void runAction() {

    }

    @Override
    public void paint(Graphics g) {

    }

    /**
     * 创建地板
     */
    private void createFloorAction() {

        for(int x=30,i=1;i<=9;x+=80,i++) {
            for(int y = 75,j = 1;j<=5;y+=100,j++) {
                GameState.getInstance().getFloors().add(new Floor(x, y));
            }
        }
    }
}
