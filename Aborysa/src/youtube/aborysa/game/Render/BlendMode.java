package youtube.aborysa.game.Render;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL11.*;
public class BlendMode {
	
	int bMode_a, bMode_b;
	public final static int BLEND_ALPHA = 0, BLEND_COLOR = 1, BLEND_ONE = 2, BLEND_NONE = 3;
	public BlendMode(int blendMode){
		switch(blendMode){
			case BLEND_ALPHA:
				bMode_a = GL11.GL_SRC_ALPHA;
				bMode_b = GL11.GL_ONE_MINUS_SRC_ALPHA;
			break;
			case BLEND_COLOR:
				bMode_a = GL11.GL_SRC_COLOR;
				bMode_b = GL11.GL_ONE_MINUS_SRC_COLOR;
			break;
			case BLEND_ONE:
				bMode_a = GL11.GL_ONE;
				bMode_b = GL11.GL_NONE;
			break;
			case BLEND_NONE:
				bMode_a = GL11.GL_NONE;
				bMode_b = GL11.GL_ONE;
			break;
			default:
				bMode_a = GL11.GL_SRC_ALPHA;
				bMode_b = GL11.GL_ONE_MINUS_SRC_ALPHA;
			break;
		}
	
	}
	public int[] getBlendMode(){
		return new int[]{bMode_a,bMode_b};
	}
}
