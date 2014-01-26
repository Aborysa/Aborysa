package youtube.aborysa.game.Tiles;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;

public class USprite implements Cloneable{
	
	
	USpriteSheat sheat;
	int imageIndex,indexL,sIndex;
	boolean SheatSprite = false;
	public USprite(USpriteSheat sheat, int sIndex, int indexL){
		this.sheat = sheat;
		this.sIndex = sIndex;
		this.indexL = indexL;
		imageIndex = 0;
		SheatSprite = true;
	}
	public USprite(Texture tex){
		this(new Texture[]{tex})    ;
	}
	public USprite(Texture[] textures){
		int temp_W = 0;
		int temp_H = 0;
		for(int i = 0; i<textures.length;i++){
			if (textures[i].getImageWidth() > temp_W){
				temp_W = textures[i].getImageWidth();
			}
			if(textures[i].getImageHeight() > temp_H){
				temp_H = textures[i].getImageHeight();
			}
		}
		sheat = new USpriteSheat(textures,temp_W,temp_H);
		sIndex = 0;
		indexL = textures.length;
		imageIndex = 0;
	}
	public int getSindex(){
		return sIndex;
	}
	public int getIndexLength(){
		return indexL;
	}
	public int getImageIndex(){
		return imageIndex;
	}
	public USpriteSheat getSheat(){
		return sheat;
	}
	public void advance(){
		imageIndex = ((imageIndex+1) % indexL);
	}
	public Texture getTexture(){
		if(!SheatSprite)
			return sheat.getTexture(imageIndex);
		else
			return sheat.getTexture(0);
	}
	public boolean isSheatSprite(){
		return SheatSprite;
	}
	public Vector2f getTexCords(){
		if (SheatSprite){
			return sheat.getTexCords(imageIndex+sIndex);
		}else{
			return sheat.getTexCords(imageIndex+sIndex, imageIndex);
		}
		
	}
	public USprite clone(){
		try {
			return (USprite)(super.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void setImageIndex(int index){
		imageIndex = (index % indexL);
	}
	
}