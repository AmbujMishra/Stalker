package com.kingAm.Stalker;

/*
 * Author# Ambuj Mishra
 * Date# 25 JAN 2015
  */


import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.input.GestureDetector;
//import com.badlogic.gdx.input.GestureDetector.GestureListener;
//import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.graphics.GL20;

public class StalknigScreen implements Screen/*,InputProcessor, GestureListener*/{
	
	StalkerGame sg;		//u can remove this instance if it is not being used anywhere
/*	This class will contain main logic of game
	StalkingGame extends Table, this is a special type of Actor that has a funky setClip(true) function,
	it means that anything outside the bounds of the TrafficGame won't be drawn. 
	Remember that we don't allow the aspect ratio to be stretched, 
	clipping means we won't have actors spilling out over our nice black letterboxing bars. 
	I think this is probably abusing tables, it's no doubt not what they were really meant for, 
	but I think it's a great little hack and am more than happy with the results!
*/	
	private StalkingGame Sking;
	/*The Stage class has a camera, SpriteBatch, and a root group and handles drawing the actors and distributing input events.
	Stage is an InputProcessor. When it receives input events, it fires them on the appropriate actors.*/
	private Stage stage;
	
	//public boolean tDown=false;
	//public boolean tUp=false;
	public StalknigScreen(StalkerGame sg) {
		this.sg=sg;
		stage = new Stage(new StretchViewport(sg.WIDTH, sg.HEIGHT));
		Sking = new StalkingGame(sg); 
		stage.addActor(Sking);
		
		//Add actors here, in constructor. You can directly add your 2 actors here.
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		//if (Gdx.input.isTouched())
			//stage.act(delta);
			//tDown=true;
		if(Gdx.input.justTouched() && !Sking.sr.getMoving())
		{
			//Gdx.input.setInputProcessor(null);
			Sking.sr.setMoving(true);
		}
		/*if(!Sking.sr.getMoving())
		{
			//Gdx.input.setInputProcessor(stage);
		}*/
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		//stage.setViewport(new StretchViewport());
		//Gdx.input.setInputProcessor(stage);
		//Gdx.input.setInputProcessor(null);
		
	}

	@Override
	public void hide() {
		//Gdx.input.setInputProcessor(null);			//it won't affect anything as inputProcessor is not implemented
		
	}
	@Override public void resume() {}
	@Override public void pause() {}
	@Override public void dispose() {}	
	/*@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		 Write your logic here
		return false;
	}
	@Override public void resume() {}
	@Override public void pause() {}
	@Override public void dispose() {}	
	@Override public boolean tap(float x, float y, int count, int button) {return false;}
	@Override public boolean touchDown(float x, float y, int pointer, int button) {return false;}
	@Override public boolean longPress(float x, float y) {return false;}
	@Override public boolean pan(float x, float y, float deltaX, float deltaY) {return false;}
	@Override public boolean zoom(float initialDistance, float distance) {return false;}
	@Override public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {return false;}
	@Override public boolean panStop(float x, float y, int pointer, int button) {return false;}
*//*
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		//tDown=true;
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		//tUp=true;
		//tDown=false;
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
*/

}
