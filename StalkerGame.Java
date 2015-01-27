package com.kingAm.Stalker;
/*
 * Author# Ambuj Mishra
 * Date# 25 JAN 2015
  */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.graphics.g2d.Batch;

/*	This class will contain main logic of game
StalkingGame extends Table, this is a special type of Actor that has a funky setClip(true) function,
it means that anything outside the bounds of the TrafficGame won't be drawn. 
Remember that we don't allow the aspect ratio to be stretched, 
clipping means we won't have actors spilling out over our nice black letterboxing bars. 
I think this is probably abusing tables, it's no doubt not what they were really meant for, 
but I think it's a great little hack and am more than happy with the results!
*/	


//Learn how to add action to Actions to actors
public class StalkingGame extends Table{
	
	StalkerGame sg;
	public Stalker sr;
	private Target tr;
	
	public StalkingGame(StalkerGame sg)
	{
		this.sg=sg;
		//setBounds(0, 0, sg.WIDTH, sg.HEIGHT);
		setBounds(0, 0, 800, 480);
		setClip(true);
		//tr = new Target(this);    //If you want to use any parameter or method of this class then use this initialization
		tr = new Target(sg);
		addActor(tr);
		//sr = new Stalker(this);    //If you want to use any parameter or method of this class then use this initialization
		sr = new Stalker(sg);		// it will pass through main game class instance to load texture in actor classes
		addActor(sr);
	}
	@Override
	public void act(float delta) {
		//Investigate: Reason for calling super.act()
		//Found: super.act(delta) will call act method of it's Actors i.e. Target and Stalker
		super.act(delta);						// very Important :)
		//Write logic here
	}
	//Investigate: why?...FYI, u can override with Batch parameter instead of SpriteBatch...why?
	//Found: Stage.draw() will call draw method of it's Actor i.e. StalkingGame class in our case. 
	//But to call draw method of this class's (Table) Actor (Target and Stalker)
	//You have to call super.draw(Batch b, float f) method again
	@Override					
	public void draw(Batch batch, float parentAlpha) {
		//System.out.println("here");
		batch.setColor(Color.GRAY);		//Interesting: Its is changing background color of your actors
		super.draw(batch, parentAlpha);    //Important :(
	}


}
