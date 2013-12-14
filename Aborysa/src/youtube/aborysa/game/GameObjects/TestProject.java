package youtube.aborysa.game.GameObjects;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;
import youtube.aborysa.game.Render.RenderTexture;
import youtube.aborysa.game.Render.Screen;

public class TestProject {
	Vector2f speed;
	Point2f pos;
	Texture tex;
	public boolean killed = false;
	public TestProject(Vector2f dir, Texture tex){
		speed = dir;
		this.pos = dir.getPos();
		this.tex = tex;
	}
	public void update(){
		pos.setCords(speed.getX()+pos.getX(), speed.getY() + pos.getY());
		Screen.drawImgStr(pos.getX(),pos.getY(),tex.getImageWidth(),tex.getImageHeight(),tex);
		if ((pos.getX() > 640)||(pos.getX() < 0)||(pos.getY()<0)||(pos.getY() > 480) ){
			killed = true;
		} 
	}
	
	
}
