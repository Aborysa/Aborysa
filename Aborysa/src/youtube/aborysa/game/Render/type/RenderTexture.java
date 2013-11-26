package youtube.aborysa.game.Render.type;

import java.awt.geom.Dimension2D;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Render.Graphics;
import youtube.aborysa.game.Render.Screen;
//import youtube.aborysa.game.Render;
public class RenderTexture implements Graphics{
	Point2f pos;
	float depth,width,height;
	Dimension2D dim;
	Texture tex;
	
	public RenderTexture(Point2f pos,Texture tex){
		this.tex = tex;
		this.pos = pos;
		width = tex.getWidth();
		height = tex.getHeight();
	}
	public RenderTexture(Point2f pos, float width, float height,Texture tex){
		this.pos = pos;
		this.tex = tex;
		this.width = width;
		this.height = height;
	}
	@Override
	public void draw() {
		//System.out.println("Go fuck your self");
		Screen.drawImage(pos.getX(), pos.getY(), tex);
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
