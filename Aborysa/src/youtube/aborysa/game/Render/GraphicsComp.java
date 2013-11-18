package youtube.aborysa.game.Render;

import org.newdawn.slick.opengl.Texture;

public class GraphicsComp {
	public int x,y,width,height;
	public Texture tex;
	public GraphicsComp(int x, int y, int width, int height, Texture tex){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.tex = tex;
	}

}
