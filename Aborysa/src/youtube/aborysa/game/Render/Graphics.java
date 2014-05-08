package youtube.aborysa.game.Render;

import youtube.aborysa.game.Render.Texture.Texture;
import youtube.aborysa.game.Math.geometrics.*;


public interface Graphics {
	void draw();
	void setDepth(float d);
	float getDepth();
	Point2f getPosition();
	void setPosition(float x, float y);
	void setPosition(Point2f point);
	void setColor(Color c);
	Color getColor();
	void kill();
	void setBlendMode(BlendMode b);
	BlendMode getBlendMode();
	public Texture getTex();
}