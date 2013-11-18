package youtube.aborysa.game.Render;

import org.newdawn.slick.opengl.Texture;

public class RenderTexture {
	public int x,y;
	byte depth;
	Texture tex;
	
	public RenderTexture(Texture tex){
		this.tex = tex;
	}
	
	
}
