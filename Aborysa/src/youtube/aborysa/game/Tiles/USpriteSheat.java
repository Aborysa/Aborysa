package youtube.aborysa.game.Tiles;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;

public class USpriteSheat {
	private final int TILE_WIDTH, TILE_HEIGHT;
	Texture[] textures;
	private Vector2f[] texCords;
	public USpriteSheat(Texture tex, int TILE_WIDTH,int TILE_HEIGHT){
		textures = new Texture[1];
		textures[0] = tex;
		this.TILE_WIDTH = TILE_WIDTH;
		this.TILE_HEIGHT = TILE_HEIGHT;
		texCords = new Vector2f[1];
		texCords[0] = new Vector2f((float)((float)(TILE_WIDTH)/tex.getImageWidth()),(float)((float)(TILE_HEIGHT)/tex.getImageHeight()),null);
	}
	public USpriteSheat(Texture[] textures, int TILE_WIDTH,int TILE_HEIGHT){
		this.textures = new Texture[textures.length];
		texCords = new Vector2f[textures.length];
		for(int i = 0; i < textures.length;i++){
			this.textures[i] = textures[i];
			texCords[i] = new Vector2f((float)((float)(TILE_WIDTH)/textures[i].getImageWidth()),(float)((float)(TILE_HEIGHT)/textures[i].getImageHeight()),null);
		}
		this.TILE_WIDTH = TILE_WIDTH;
		this.TILE_HEIGHT = TILE_HEIGHT;
	}
	public int getTileWidth(){
		return TILE_WIDTH;
	}
	public int getTileHeight(){
		return TILE_HEIGHT;
	}
	public Texture getTexture(int index){
		return textures[index];
	}
	public Texture getTexture(){
		return textures[0];
	}
	public Vector2f getTexCords(int index){
		/*int xIndex = (int)(index%(tex.getImageWidth() / (float)(TILE_WIDTH)));
		int yIndex = (int) Math.floor(index / ((tex.getImageWidth() / (float)(TILE_WIDTH))));
		Point2f  sTemp = new Point2f(((xIndex*(float)(TILE_WIDTH)) / (tex.getImageWidth())),(float)(yIndex*(float)(TILE_WIDTH) /tex.getImageHeight()),false);
		Vector2f tempVec = new Vector2f(texCords[0].getX()+sTemp.getX(),texCords[0].getY()+sTemp.getY(),sTemp);*/
		return getTexCords(index,0);
		
	}
	public Vector2f getTexCords(int index, int sheatIndex){
		Texture tex = textures[sheatIndex];
		int xIndex = (int)(index%(tex.getImageWidth() / (float)(TILE_WIDTH)));
		int yIndex = (int) Math.floor(index / ((tex.getImageWidth() / (float)(TILE_WIDTH))));
		Point2f  sTemp = new Point2f(xIndex*texCords[sheatIndex].getX(),(float)(yIndex*(texCords[sheatIndex].getY())),false);
		Vector2f tempVec = new Vector2f(texCords[sheatIndex].getX()+sTemp.getX(),texCords[sheatIndex].getY()+sTemp.getY(),sTemp);
		return tempVec;	
	}
	
}
