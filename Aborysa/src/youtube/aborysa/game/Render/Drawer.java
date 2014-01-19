package youtube.aborysa.game.Render;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;
import youtube.aborysa.game.Tiles.SheatSprite;
import youtube.aborysa.game.Tiles.Sprite;
import youtube.aborysa.game.Tiles.SpriteSheat;
import youtube.aborysa.game.Tiles.USprite;
import youtube.aborysa.game.Tiles.USpriteSheat;

public class Drawer {
	private static Color c = new Color(1,1,1,1);
	
	
	public static void draw(Graphics g){
		Screen.draw(g);
	}
	public static void drawSprite(USpriteSheat sheat,int index,int layerIndex,float x, float y){
		Graphics g = new RenderTexture(new Vector2f(sheat.getTileWidth(),sheat.getTileHeight(),new Point2f(x,y,false)),sheat.getTexCords(index,layerIndex), sheat.getTexture(layerIndex));
		draw(g);
	}
	public static void drawSprite(USprite spr, float x, float y){
		drawSpriteStr(spr, x, y, spr.getTexture().getImageWidth(), spr.getSheat().getTexture().getImageHeight());
	}
	public static void drawSpriteStr(USprite spr, float x, float y, float w, float h){
		Texture tex = spr.getTexture();
		Graphics g = new RenderTexture(new Vector2f(w,h,new Point2f(x,y,false)),new Vector2f(1,1,new Point2f(0,0,false)), tex); 
		draw(g);
	}
	public static void setColor(float r, float g, float b, float a){
		c.setColor(r, g, b, a);
	}
	public Color getColor(){
		return c;
	}
}

