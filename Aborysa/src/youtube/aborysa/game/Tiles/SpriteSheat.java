package youtube.aborysa.game.Tiles;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;

public class SpriteSheat {
	private Texture tex;
	private int TILE_WIDTH;
	private int TILE_HEIGHT;
	
	public SpriteSheat(Texture tex, int TileW, int TileH){
		TILE_WIDTH = TileW;
		TILE_HEIGHT = TileH;
		this.tex = tex;
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
		int xIndex = (int)(index%(tex.getImageWidth() / TILE_WIDTH));
		int yIndex = (int) Math.floor(index / ((tex.getImageWidth() / TILE_WIDTH)));
		//System.out.println("Index: "+ index +", X: " + xIndex + ", Y: " + yIndex);
		//System.out.printf("%d%n",(index / (tex.getImageWidth() / TILE_WIDTH)))
		Point2f s = new Point2f((float)(xIndex / ((tex.getImageWidth() / TILE_WIDTH))),(float)(yIndex / (tex.getImageHeight() / TILE_HEIGHT)),false);
		Vector2f texCord = new Vector2f((float)((xIndex+1) / (tex.getImageWidth() / TILE_WIDTH)),(float)((yIndex+1) / (tex.getImageHeight() / TILE_HEIGHT)),s);
		System.out.println("XX: " + texCord.getPos().getX()*tex.getImageWidth() + ", YY: " + texCord.getPos().getY()* tex.getImageHeight() );
		return texCord;
	}

}
