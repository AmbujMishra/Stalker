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
	         //setWidth(64);	//It's in pixels. correct it
		setWidth(64f*((float)Gdx.graphics.getWidth()/sg.WIDTH));	//Done
		//setHeight(64);	//It's in pixel. correct it
		setHeight(64f*((float)Gdx.graphics.getHeight()/sg.HEIGHT));	//Done
		//setPosition(Gdx.graphics.getWidth()/2-getWidth()/2, Gdx.graphics.getHeight()/2-getHeight()/2);		//Starting position of Actor, set accordingly
		setPosition(sg.WIDTH/2-getWidth()/2, sg.HEIGHT/2-getHeight()/2);	//Independent of pixel
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
