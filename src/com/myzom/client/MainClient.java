package com.myzom.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.my.tools.ZomConstant;
import com.my.tools.ZomImages;

public class MainClient extends JPanel{
	public static void main(String[] args) {
		
		GamePanel page = new GamePanel();
		JFrame frame = new JFrame();
		MainClient mainClient = new MainClient();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(ZomConstant.WIDTH, ZomConstant.HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(mainClient);
		frame.setVisible(true);
		mainClient.mouse(frame, page, mainClient);
		mainClient.rp();


	}
	public void rp() {
		while(true) {
			try {
				repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void mouse(JFrame frame, GamePanel page, MainClient main) {
		MouseAdapter l = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.remove(main);
				frame.add(page);
				page.action();
				frame.setVisible(true);
			}
		};
		addMouseListener(l);
		addMouseMotionListener(l);
	}
	int index = 0;
	@Override
	public void paint(Graphics g) {
		index++;
		Font font = ZomConstant.ttf;
		g.drawImage(ZomImages.titlescreen, 0, 0, null);
		g.setColor(Color.white);
		g.setFont(new Font("cc", Font.PLAIN, 30));
		g.setFont(new Font("aa", Font.PLAIN, 20));
		if(index%50<25) {
			g.setColor(Color.black);
		}
			
		g.drawString("点击开始游戏", 330, 500);
	}

} 
