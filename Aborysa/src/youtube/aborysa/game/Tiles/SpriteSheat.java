package youtube.aborysa.game.Tiles;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;

public class SpriteSheat{
	private Texture tex;
	private int TILE_WIDTH;
	private int TILE_HEIGHT;
	private Vector2f texCord;
	public SpriteSheat(Texture tex, int TileW, int TileH){
		TILE_WIDTH = TileW;
		TILE_HEIGHT = TileH;
		this.tex = tex;
		texCord = new Vector2f((float)((float)(TILE_WIDTH)/tex.getImageWidth()),(float)((float)(TILE_HEIGHT)/tex.getImageHeight()),null);
	}
	public Texture getTex(){
		return tex;
	}
	public int getTileWitdth(){
		return TILE_WIDTH;
	}
	public int getTileHeight(){
		return TILE_HEIGHT;
	}
	public Vector2f getTexCords(int index){
		int xIndex = (int)(index%(tex.getImageWidth() / (float)(TILE_WIDTH)));
		int yIndex = (int) Math.floor(index / ((tex.getImageWidth() / (float)(TILE_WIDTH))));
		Point2f  sTemp = new Point2f(((xIndex*(float)(TILE_WIDTH)) / (tex.getImageWidth())),(float)(yIndex*(float)(TILE_WIDTH) /tex.getImageHeight()),false);
		Vector2f tempVec = new Vector2f(texCord.getX()+sTemp.getX(),texCord.getY()+sTemp.getY(),sTemp);
		return tempVec;	
	}

}
