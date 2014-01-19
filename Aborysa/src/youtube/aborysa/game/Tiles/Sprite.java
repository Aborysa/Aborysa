package youtube.aborysa.game.Tiles;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;


public class Sprite implements Cloneable{
	private Texture[] textures;
	private int imageIndex = 0;
	private int sIndex, indexLength;
	private SpriteSheat sheat;
	private boolean regSprite = true;
	
	public Sprite(Texture[] tex){
		textures = tex;
		sIndex = 0;
		indexLength = tex.length;
	}
	public Sprite(SpriteSheat sheat, int sIndex, int indexL){
		regSprite = false;
		this.sheat = sheat;
		this.sIndex = sIndex;
		this.indexLength = indexL;
	}
	public Sprite(Texture tex){
		regSprite = false;
		sheat = new SpriteSheat(tex, tex.getImageWidth(), tex.getImageHeight());
		textures = new Texture[1];
		textures[0] = tex;
		sIndex = 0;
		indexLength = 1;
	}
	public void setImageIndex(int index){
		imageIndex = (index % indexLength);
	}
	public Texture getTexture(){	
		return textures[imageIndex];
	}
	public int getSindex(){
		return sIndex;
	}
	public int getIndexLength(){
		return indexLength;
	}
	public SpriteSheat getSheat(){
		if (regSprite)
		return new SpriteSheat(getTexture(),getTexture().getImageWidth(),getTexture().getImageHeight());
		else
		return sheat;
	}
	public int getImageIndex(){
		return imageIndex;
	}
	public void advance(){
		imageIndex = ((imageIndex+1) % indexLength);
	}
	public Vector2f getTexCords(){
		if (!regSprite){
			return sheat.getTexCords(imageIndex+sIndex);
		}else{
			return new Vector2f(1,1,new Point2f(0,0,false));
		}
	}
	public Sprite clone(){
		try {
			return (Sprite)(super.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}


