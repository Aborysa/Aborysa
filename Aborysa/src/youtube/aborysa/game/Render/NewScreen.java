package youtube.aborysa.game.Render;

import static org.lwjgl.opengl.GL11.*;


public class NewScreen {
	boolean init = false;
	public boolean inti(){
		if (!init){
			initGL();
			initDisplay();
			init = true;
			return true;
		}
		return false;
	}
	
	private void initGL(){
		
	}
	private void initDisplay(){
		
	}
}
