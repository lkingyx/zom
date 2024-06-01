package com.myzom.model;

import java.awt.Image;
import java.awt.image.BufferedImage;

import com.myzom.superclass.ZomObject;

public class Floor extends ZomObject{

	private boolean isUse = false;

	public Floor(int x, int y) {
		super(80, 100, x, y);

	}

	@Override
	public Image getImage() {
		
		return null;
	}

    public int getY() {
		return this.y+10;
	}

	public boolean isUse() {
		return isUse;
	}

	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}

	@Override
	public BufferedImage getBuff() {
		
		return null;
	}

}
