package youtube.aborysa.game.Tiles;

import org.newdawn.slick.opengl.Texture;


public class Sprite {
	private Texture[] textures;
	private int imageIndex;
	
	public Sprite(Texture[] tex){
		textures = new Texture[tex.length];
		int counter = 0;
		for(Texture i : tex){
			textures[counter] = i;
			counter++;
		}
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
	
	
}


