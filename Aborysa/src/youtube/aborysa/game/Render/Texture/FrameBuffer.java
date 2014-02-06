package youtube.aborysa.game.Render.Texture;



import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.EXTFramebufferObject.*;
import static org.lwjgl.opengl.GL11.*;


import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GLContext;

public class FrameBuffer {
	int bufferId = -1;
	int width = 0;
	int height = 0;
	int renderBufferId = -1;
	Texture tex;
	public FrameBuffer(int width, int height){
		this.width = width;
		this.height = height;
		bufferId = createFBO();
	}
	public int getFBOId(){
		return bufferId;
	}
	public int createFBO(){
		int framebufferID = -1;
		int colorTextureID = -1;
		int depthRenderBufferID = -1;
		IntBuffer pBuffer;
		boolean FBOEnabled = GLContext.getCapabilities().GL_EXT_framebuffer_object;
		if (FBOEnabled){
			framebufferID = glGenFramebuffersEXT();											// create a new framebuffer
			colorTextureID = glGenTextures();												// and a new texture used as a color buffer
			depthRenderBufferID = glGenRenderbuffersEXT();									// And finally a new depthbuffer
	
			glBindFramebufferEXT(GL_FRAMEBUFFER_EXT, framebufferID); 						// switch to the new framebuffer
	
			// initialize color texture
			glBindTexture(GL_TEXTURE_2D, colorTextureID);									// Bind the colorbuffer texture
			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);				// make it linear filterd
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, 512, 512, 0,GL_RGBA, GL_INT, (java.nio.ByteBuffer) null);	// Create the texture data
			glFramebufferTexture2DEXT(GL_FRAMEBUFFER_EXT,GL_COLOR_ATTACHMENT0_EXT,GL_TEXTURE_2D, colorTextureID, 0); // attach it to the framebuffer
	
	
			// initialize depth renderbuffer
			glBindRenderbufferEXT(GL_RENDERBUFFER_EXT, depthRenderBufferID);				// bind the depth renderbuffer
			glRenderbufferStorageEXT(GL_RENDERBUFFER_EXT, GL14.GL_DEPTH_COMPONENT24, 512, 512);	// get the data space for it
			glFramebufferRenderbufferEXT(GL_FRAMEBUFFER_EXT,GL_DEPTH_ATTACHMENT_EXT,GL_RENDERBUFFER_EXT, depthRenderBufferID); // bind it to the renderbuffer
	
			glBindFramebufferEXT(GL_FRAMEBUFFER_EXT, 0);									// Swithch back to normal framebuffer rendering
		
			
			
			
		}
		tex = new Texture(colorTextureID,null,width,height);
		return bufferId;
	}
	public void bindBuffer(){
		glBindFramebufferEXT(GL_FRAMEBUFFER_EXT, bufferId);
		glPushAttrib(GL_VIEWPORT_BIT);
		//GL11.glMatrixMode(GL11.GL_PROJECTION);
		glViewport(0, 0, width, height);
		//GL11.glOrtho(0, width, height, 0, -1, 1);
		//GL11.glMatrixMode(GL11.GL_MODELVIEW);
		glClear(GL_COLOR_BUFFER_BIT);
		glColor4f(1,0,0,1);
		//glTranslatef(0, 0, -6f);
		glBegin(GL_QUADS);
		glVertex2f(0, 0);
		glVertex2f(32, 32);
		glVertex2f(32, 32);
		glVertex2f(0, 32);
		glEnd();
		glColor4f(1,1,1,1);
	}
	public void unbindBuffer(){
		//tex.getBuffer().flip();
		//glTranslated(0, 0, 6f);
		glBindFramebufferEXT( GL_FRAMEBUFFER_EXT, 0);
		glPopAttrib();
	}
	public int getFrameBufferId(){
		return bufferId;
	}
	public Texture getTexture(){
		return tex;
	}
}
