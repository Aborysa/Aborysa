package youtube.aborysa.game.GameObjects;

import youtube.aborysa.game.Input.KeyHandler;
import youtube.aborysa.game.Input.KeyListener;
import youtube.aborysa.game.Input.MouseHandler;
import youtube.aborysa.game.Input.MouseListener;
import youtube.aborysa.game.World.GameLoop;
import youtube.aborysa.game.World.Level;

public abstract class Entity implements KeyListener, MouseListener, GameLoop{
	
	public Entity(Level level){
		
	}
	public void draw(){
		
	}
	public void tick(){
		
	}
	private void initDraw(){
		
	}
	private void initTick(){
		
	}
	private void initBasic(){
		initTick();
		initDraw();
	}
	private void initInput(){
		initKey();
		initMouse();
	}
	private void initAll(){
		initBasic();
		initInput();
	}
	
	private void initKey(){
		KeyHandler.addKeyListener(this);
	}
	private void initMouse(){
		MouseHandler.addMouseListener(this);
	}
	@Override
	public void ButtonPressed(int keyCode) {
	}

	@Override
	public void ButtonReleasd(int keyCode) {
	}

	@Override
	public void mouseClick(float x, float y, int code) {
	}

	@Override
	public void mouseRelease(float x, float y, int code) {
	}

}
