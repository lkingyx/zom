package com.myzom.client;

import com.my.tools.ZomConstant;
import com.myzom.components.Component;
import com.myzom.components.MenuComponent;
import com.myzom.components.*;
import com.myzom.data.GameState;
import com.myzom.event.GameEvent;
import com.myzom.event.GameMouseAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel{

	private final GameState state;

	public GamePanel() {

		state = GameState.getInstance();
		state.getComponentList().add(new BackgroundComponent());
		state.getComponentList().add(new CardComponent());
		state.getComponentList().add(new FloorComponent());
		state.getComponentList().add(new PlantsComponent());
		state.getComponentList().add(new EnemyComponent());
		state.getComponentList().add(new CarComponent());
		state.getComponentList().add(new BombComponent());
		state.getComponentList().add(new SunComponent());
		state.getComponentList().add(new MenuComponent());
		state.getComponentList().add(new GameOverComponent());
		state.getComponentList().add(new StartPageComponent());
		for (Component component : state.getComponentList()) {
			if (component instanceof GameEvent) {
				state.getGameEventList().add((GameEvent)component);
			}
		}

	}

	public void action() {

		state.getComponentList().forEach(Component::initAction);
		MouseAdapter mouseAdapter = new GameMouseAdapter();
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				if(GameState.getInstance().getState()==ZomConstant.RUNING) {
                    GameState.getInstance().setRunTimeMillis(GameState.getInstance().getRunTimeMillis() + 10);
					state.getComponentList().forEach(Component::runAction);
				}
				repaint();
			}
		}, 10, 10);
	}

	@Override
	public void paint(Graphics g) {
		state.getComponentList().forEach(component -> component.paint(g));
	}
}
