package youtube.aborysa.game.Render.Texture;

import java.nio.ByteBuffer;

public class Texture {

	int texId;
	int width = 0;
	int height = 0;
	ByteBuffer pixelBuffer;
	public Texture(int textureId, ByteBuffer pBuffer, int width, int height){
		texId = textureId;
		this.width = width;
		this.height = height;
		pixelBuffer = pBuffer;
	}
	public ByteBuffer getBuffer(){
		return pixelBuffer;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public void bindTexture(){
		TextureLoader.bindTexture(texId);
	}
	public int getTextureId(){
		return texId;
	}
	
}
