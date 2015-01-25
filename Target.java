package com.kingAm.Stalker;

/*
 * Author# Ambuj Mishra
 * Date# 25 JAN 2015
  */


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Target extends Actor{
	

	StalkerGame sg;
	private Rectangle bounds = new Rectangle();
	
	public Target(StalkerGame sg) {
		this.sg=sg;
		setWidth(64);
		setHeight(64);
		setPosition(Gdx.graphics.getWidth()/2-getWidth()/2, Gdx.graphics.getHeight()/2-getHeight()/2);		//Starting position of Actor, set accordingly
		
	}
	@Override
	public void act(float delta){
		super.act(delta);			//Investigate: Why are we using super.act here? I think we can skip it.
		updateBounds();
	}
	
	private void updateBounds() {
		bounds.set(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		System.out.println("trgt");
		//batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);		
		batch.draw(sg.tgt, getX(), getY());
	}
	public Rectangle getBounds() {
		return bounds;
	}
}
