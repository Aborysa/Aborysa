package youtube.aborysa.game.Render;

import java.awt.geom.Dimension2D;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;
//import youtube.aborysa.game.Render;
public class RenderTexture implements Graphics{
	float depth;
	Texture tex;
	Vector2f dim;
	Vector2f part;
	public RenderTexture(Point2f pos,Texture tex){
		this.tex = tex;
		dim = new Vector2f((float) tex.getImageWidth(),(float) tex.getImageHeight(), pos);
	}
	public RenderTexture(Vector2f dimention,Texture tex){
		this.tex = tex;
		dim = dimention;
	}
	public RenderTexture(Vector2f dimention,Vector2f texPart,Texture tex){
		this.tex = tex;
		dim = dimention;
		part = texPart;
	}
	@Override
	public void draw() {
		Point2f pos = dim.getPos();
		if (part != null){
			Point2f partStart = part.getPos();
			Screen.drawImagePartStr(pos.getX(), pos.getY(), dim.getX(), dim.getY(), partStart.getX() , partStart.getY(), part.getX(), part.getY(), tex);
		}else{
			Screen.drawImageStr(pos.getX(), pos.getY(),dim.getX(),dim.getY(), tex);
		}
	}
	public Texture getTex(){
		return tex;
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