package youtube.aborysa.game.Render;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;
import youtube.aborysa.game.Tiles.SheatSprite;
import youtube.aborysa.game.Tiles.Sprite;
import youtube.aborysa.game.Tiles.SpriteSheat;

public class Drawer {
	private static Color c = new Color(1,1,1,1);
	
	
	public static void draw(Graphics g){
		Screen.draw(g);
	}

	/*public static void drawSprite(SheatSprite spr, float x, float y){
		SpriteSheat sheat = spr.getSheat();
		Screen.drawImagePart(x, y, spr.getTexCords().getPos().getX(), spr.getTexCords().getPos().getY(), spr.getTexCords().getX(), spr.getTexCords().getY(), spr.getSheat().getTex());
	}*/
	public static void drawSprite(SpriteSheat sheat,int index,float x, float y){
		Graphics g = new RenderTexture(new Vector2f(sheat.getTileWitdth(),sheat.getTileHeight(),new Point2f(x,y,false)),sheat.getTexCords(index), sheat.getTex());
		draw(g);
	}
	public static void drawSprite(Sprite spr, float x, float y){
		drawSpriteStr(spr, x, y, spr.getTexture().getImageWidth(), spr.getTexture().getImageHeight());
	}
	public static void drawSpriteStr(Sprite spr, float x, float y, float w, float h){
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

