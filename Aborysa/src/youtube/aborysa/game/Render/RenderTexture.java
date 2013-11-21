package youtube.aborysa.game.Render;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;

public class RenderTexture implements Graphics{
	Point2f pos;
	float depth;
	Texture tex;
	
	public RenderTexture(Texture tex){
		this.tex = tex;
	}

	@Override
	public void draw() {
		//Make render method
	}

	@Override
	public void setDepth(float d) {
		depth = d;
	}

	@Override
	public float getDepth() {
		return depth;
	}

	@Override
	public Point2f getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosition(float x, float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(Point2f point) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor4f(float r, float g, float b, float a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub
		
	}
	
	
}
