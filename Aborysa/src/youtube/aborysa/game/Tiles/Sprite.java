package youtube.aborysa.game.Tiles;

import org.newdawn.slick.opengl.Texture;


public class Sprite implements Cloneable{
	private Texture[] textures;
	private int imageIndex = 0;
	
	public Sprite(Texture[] tex){
		textures = tex;
	}
	public Sprite(Texture tex){
		textures = new Texture[1];
		textures[1] = tex;
	}
	public void setImageIndex(int index){
		imageIndex = index % textures.length;
	}
	public Texture getTexture(){	
		return textures[imageIndex];
	}
	
	public int getImageIndex(){
		return imageIndex;
	}
	public void advance(){
		imageIndex++;
		imageIndex %= textures.length;
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


