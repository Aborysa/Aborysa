package youtube.aborysa.game.Tiles;

import org.newdawn.slick.opengl.Texture;

public class SpriteSheat {
	private Texture tex;
	private int TILE_WIDTH;
	private int TILE_HEIGHT;
	
	public SpriteSheat(Texture tex, int TileW, int TileH){
		TILE_WIDTH = TileW;
		TILE_HEIGHT = TileH;
		this.tex = tex;
	}

}
