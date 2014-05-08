package youtube.aborysa.game.Render;

import java.awt.geom.Dimension2D;

import youtube.aborysa.game.Render.Texture.*;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;
//import youtube.aborysa.game.Render;
public class RenderTexture implements Graphics{
	float depth;
	Texture tex;
	Vector2f dim;
	Vector2f part;
	Color c = null;
	boolean killed = false;
	BlendMode b;
	public RenderTexture(Point2f pos,Texture tex){
		this.tex = tex;
		dim = new Vector2f((float) tex.getWidth(),(float) tex.getHeight(), pos);
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
		if (!killed){
			Point2f pos = dim.getPos();
			if (part == null){
				part = new Vector2f(1, 1, new Point2f(0,0,false));
			}
			Point2f partStart = part.getPos();
			Screen.drawImagePartStr(pos.getX(), pos.getY(), dim.getX(), dim.getY(), partStart.getX() , partStart.getY(), part.getX(), part.getY(), tex);
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
		return null;
	}

	@Override
	public void setPosition(float x, float y) {
	}

	@Override
	public void setPosition(Point2f point) {
	}

	@Override
	public void setColor(Color c) {
		this.c = c;
	}

	@Override
	public Color getColor() {
		return c;
	}

	@Override
	public void kill() {
		killed = true;
	}

	@Override
	public void setBlendMode(BlendMode b) {
		this.b = b;
	}
	public BlendMode getBlendMode(){
		return b;
	}
	
	
}
