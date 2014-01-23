package youtube.aborysa.game.Render;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Polygon;

public class RenderPolygon implements Graphics{
	
	Point2f pos;
	Color c;
	Polygon p;
	BlendMode b;
	public RenderPolygon(Point2f pos, Polygon p){
		this.p = p;
		this.pos = pos;
	}
	@Override
	public void draw() {
		float[][] points = new float[p.getPoints().length+1][2];
		for(int i = 0; i< p.getPoints().length;i++){
			points[i][0] = p.getPoints()[i].getX() + pos.getX();
			points[i][1] = p.getPoints()[i].getY() + pos.getY();
			System.out.println("X: " + points[i][0] + ", Y: " + points[i][1] + ", I: " + i);
		}
		points[points.length-1][0] = points[0][0];
		points[points.length-1][1] = points[0][1];
		
		Screen.drawPolyFan(points);
	}

	@Override
	public void setDepth(float d) {
		
	}

	@Override
	public float getDepth() {
		return 0;
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
		
	}

	@Override
	public Texture getTex() {
		return null;
	}
	@Override
	public void setBlendMode(BlendMode b) {
		this.b = b;
	}
	public BlendMode getBlendMode(){
		return b;
	}

}
