package youtube.aborysa.game.Render.Texture;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.newdawn.slick.opengl.PNGDecoder;
import org.newdawn.slick.opengl.PNGDecoder.Format;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
public class TextureLoader {
	
	static ArrayList<Integer> textureIds = new ArrayList<Integer>();
	
	public static Texture loadTexture(String filePath){
		InputStream input;
		PNGDecoder decoder;
		ByteBuffer pBuffer = null;
		int texId = -1;
		int width = 0;
		int height = 0;
		try {
			input = new FileInputStream(new File(filePath));
			decoder = new PNGDecoder(input);
			width = decoder.getWidth();
			height = decoder.getHeight();
			pBuffer = ByteBuffer.allocateDirect(4*width*height);
			decoder.decode(pBuffer,width*4,Format.RGBA);
			pBuffer.flip();
			input.close();
			texId = genTexture(pBuffer,width);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return new Texture(texId, pBuffer,width, height);
	}
	
	
	private static int genTexture(ByteBuffer buffer, int width){
	 	int texId = GL11.glGenTextures();
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D,texId);
		GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGB, width,buffer.capacity()/(4*width), 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer);	 
		textureIds.add(texId);
		return texId;
	}
	public static Texture emptyTexture(int width, int height){
		ByteBuffer pBuffer = ByteBuffer.allocateDirect(4*width*height);
		int texId = genTexture(pBuffer,width);
		
		//pBuffer.clear();
		//pBuffer.flip();
		return new Texture(texId,pBuffer,width,height);
	}
	public static void bindTexture(int textureId){
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureId);
	}
	public static void deleteTexture(int textureId){
		for(Integer i : textureIds){
			if (textureId == i.intValue()){
				textureIds.remove(i);
				GL11.glDeleteTextures(textureId);
				break;
			}
		}
		}
	public static void cleanUp(){
		for(Integer i : textureIds){
			GL11.glDeleteTextures(i.intValue());
		}
	}
}
