package youtube.aborysa.game.Tiles;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;

public class SheatSprite implements Cloneable{
	private SpriteSheat sheat;
	private int sIndex, indexLength;
	private int imageIndex = 0;

	public SheatSprite(SpriteSheat sheat, int sIndex, int indexL){
		this.sheat = sheat;
		this.indexLength= indexL;
		this.sIndex = sIndex;
	}
	public SpriteSheat getSheat(){
		return sheat;
	}
	public int getSindex(){
		return sIndex;
	}
	public int getIndexLength(){
		return indexLength;
	}
	public int getIndex(){
		return imageIndex;
	}
	public void setImageIndex(int index){
		imageIndex = (index % indexLength);
	}
	public SheatSprite clone(){
		try {
			return (SheatSprite) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void advance(){
		imageIndex = ((imageIndex+1) % indexLength);
	}
	public Vector2f getTexCords(){
		return sheat.getTexCords(imageIndex+sIndex);
	}
}
