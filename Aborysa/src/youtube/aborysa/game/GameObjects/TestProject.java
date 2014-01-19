package youtube.aborysa.game.GameObjects;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;
import youtube.aborysa.game.Render.Drawer;
import youtube.aborysa.game.Render.RenderTexture;
import youtube.aborysa.game.Render.Screen;
import youtube.aborysa.game.Tiles.Sprite;
import youtube.aborysa.game.Tiles.USprite;

public class TestProject {
	Vector2f speed;
	Point2f pos;
	USprite spr;
	public boolean killed = false;
	public TestProject(Vector2f dir, USprite spr){
		speed = dir;
		this.pos = dir.getPos();
		this.spr = spr;
	}
	public void update(){
		pos.setCords(speed.getX()+pos.getX(), speed.getY() + pos.getY());
		Drawer.drawSprite(spr,pos.getX(),pos.getY());
		if ((pos.getX() > 640)||(pos.getX() < 0)||(pos.getY()<0)||(pos.getY() > 480) ){
			killed = true;
		} 
	}
	
	
}
