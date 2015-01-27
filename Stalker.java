package com.kingAm.Stalker;
/*
 * Author# Ambuj Mishra
 * Date# 25 JAN 2015
  */


//import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Stalker extends Actor {
	
	StalkerGame sg;
	//private StalkingGame sg;    u can uncomment it if you are using any method or parameter of this class
	private Rectangle bounds = new Rectangle();
	private boolean moving=false;
	private float nY;		// holding previous Y position of stalker
	private float sM=30;	// Movement of stalker in one single touch	
		
	public Stalker(StalkerGame sg) {
		this.sg=sg;
		setWidth(64);
		setHeight(64);
		//setPosition(Gdx.graphics.getWidth()/2- getWidth()/2,0 );		// Initial position of stalker, set accordingly
		setPosition(sg.WIDTH/2- getWidth()/2,0 );	//Independent of pixel
		setColor(Color.RED);	//Experiment: on this line
		nY=getY()+sM;
	}

	@Override
	public void act(float delta){
		System.out.println("StalkerAct");
		//setY(getY()+sg.getStSpeed()*delta);
		//super.act(delta);				//Investigate: Why are we using super.act here? I think we can skip it.
		updateBounds();					//We are not doing anything with Actor's bound, so remove it.
		
		if(getMoving() && getY()<= nY)
		{
			setY(getY()+sg.getStSpeed()*delta);
		}
		if(getY()> nY)
			{
			nY=getY()+sM;
			setMoving(false);
			}
	}
	
	private void updateBounds() {
		bounds.set(getX(), getY(), getWidth(), getHeight());
		
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	public boolean getMoving()
	{
		return moving;
	}
	
	public void setMoving(boolean m)
	{
		moving=m;
	}
	
	//Refer below methods to add action to this actor
/*	public void tryMoveUp() {
		if ((getActions().size == 0) && (lane != 2)) moveToLane(lane+1);
	}

	public void tryMoveDown() {
		if ((getActions().size == 0) && (lane != 0)) moveToLane(lane-1);
	}*/
/*	private void moveToLane(int lane) {
		this.lane = lane;
		
		switch (lane) {
			case 0:
				addAction(moveTo(getX(), trafficGame.lane0 - getHeight()/2, 0.5f));
				break;
			case 1:
				addAction(moveTo(getX(), trafficGame.lane1 - getHeight()/2, 0.5f));
				break;
			case 2:
				addAction(moveTo(getX(), trafficGame.lane2 - getHeight()/2, 0.5f));
				break;
		}
	}*/
	//Investigate: why?...FYI, u can override with Batch parameter instead of SpriteBatch...why?
	
	@Override		
	public void draw(Batch batch, float parentAlpha) {
		System.out.println("stkr");
		//batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);		
		//batch.draw(sg.skr, getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());
		batch.draw(sg.skr, getX(), getY());
	}

}
