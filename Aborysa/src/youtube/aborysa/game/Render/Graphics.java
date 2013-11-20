package youtube.aborysa.game.Render;

import org.newdawn.slick.Color;

import youtube.aborysa.game.Math.geometrics.*;
public interface Graphics {
	void draw();
	float setDepth(float d);
	float getDepth();
	Point2f getPosition();
	void setPosition(float x, float y);
	void setPosition(Point2f point);
	void setColor4f(float r, float g, float b, float a);
	Color getColor();
	void kill();
}