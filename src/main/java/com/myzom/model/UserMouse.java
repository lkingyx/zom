package com.myzom.model;

import java.awt.Image;
import java.awt.image.BufferedImage;

import com.myzom.superclass.ZomObject;

public class UserMouse extends ZomObject{

	public UserMouse() {
		super(10, 10, 0, 0);
	}

	public void moveMouse(int x,int y) {
		this.x=x;
		this.y=y;
	}

	@Override
	public Image getImage() {
		return null;
	}

    @Override
	public BufferedImage getBuff() {
		return null;
	}

}
