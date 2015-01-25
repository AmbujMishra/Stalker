package com.kingAm.Stalker;
/*
 * Author# Ambuj Mishra
 * Date# 25 JAN 2015
  */
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class StalkerGame extends Game{
	
/*	final width and height constants that will be used to specify 
	the target resolution of the game. We'll later use these constants
	to set the size of our game stage. Note that these values aren't physical pixel dimensions,
	they are an abstract idea of the size of our play area.
	Our LibGDX Scene2D Stage will be stretched to fit the players device as best possible, 
	which means our game will display nicely on devices with 320x240px screens, 1920x1080px screens, 
	and anything in between!*/
	public final static int WIDTH = 800;
	public final static int HEIGHT = 480;

	public Texture skr;			//Texture for stalker
	public Texture tgt;			//Texture for target
	
	StalknigScreen SGS;			// StalkingScreen
	
	// Below are the constants which will be multiplied to control animation speed of characters.
	  private int StSpeed;		// Stalker's speed, It depends on User's touch time. User touch time*StSpeed will decide it.
	  private int TgSpeed;		// Target's speed, It will be dynamic, AI of game will decide it.
	
	  
	  public int getStSpeed()
	  {
		  return StSpeed;
	  }
	  public int getTgSpeed()
	  {
		  return TgSpeed;
	  }
	@Override
	public void create() {
	//Enhancement: Use Texture Atlas to bind and load images
		//initializing texture
		skr=new Texture(Gdx.files.internal("stalker1.png"));	
      	tgt=new Texture(Gdx.files.internal("target1.png"));
      	
      	//initializing screen
      	SGS= new StalknigScreen(this);	
      	
      	//set animation speed
      	StSpeed=300;
      	TgSpeed=300;
      	setScreen(SGS);
	}

	public void render() 
	 	{
	        super.render(); //important!
	    }
	 
	@Override
	public void dispose() {
		skr.dispose();
		tgt.dispose();
		SGS.dispose();
	}

}
