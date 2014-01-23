package youtube.aborysa.game.Render;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;

public class RenderRec implements Graphics{

	Vector2f dim;
	Color c = null;
	BlendMode b = null;
	public RenderRec(Vector2f dim){
		this.dim = dim;
	}
	
	@Override
	public void draw() {
		Screen.drawRect(dim.getPos().getX(), dim.getPos().getY(), dim.getX(), dim.getY());
	}
	@Override
	public void setDepth(float d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getDepth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point2f getPosition() {
		// TODO Auto-generated method stub
		return dim.getPos();
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
	public void setColor(Color c) {
		this.c = c;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBlendMode(BlendMode b) {
		this.b = b;
	}

	@Override
	public BlendMode getBlendMode() {
		return b;
	}

	@Override
	public Texture getTex() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
