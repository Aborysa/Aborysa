package youtube.aborysa.game.Render;

import java.util.ArrayList;

import youtube.aborysa.game.Render.Texture.*;
import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Polygon;
import youtube.aborysa.game.Math.geometrics.Triangle;
import youtube.aborysa.game.Math.geometrics.Vector2f;
import youtube.aborysa.game.Math.geometrics.polyShape;
import youtube.aborysa.game.Tiles.SheatSprite;
import youtube.aborysa.game.Tiles.Sprite;
import youtube.aborysa.game.Tiles.SpriteSheat;
import youtube.aborysa.game.Tiles.USprite;
import youtube.aborysa.game.Tiles.USpriteSheat;
public class Drawer {
	private static Color c = new Color(1,1,1,1);
	private static BlendMode b = new BlendMode(BlendMode.BLEND_ALPHA);
	private static ArrayList<Graphics> g = new ArrayList<Graphics>();
	public static void draw(Graphics g){
		g.setColor(c);
		g.setBlendMode(b);
		Screen.draw(g);
	}
	public static void drawSprite(USpriteSheat sheat,int index,int layerIndex,float x, float y){
		Graphics g = new RenderTexture(new Vector2f(sheat.getTileWidth(),sheat.getTileHeight(),new Point2f(x,y,false)),sheat.getTexCords(index,layerIndex), sheat.getTexture(layerIndex));
		//Drawer.g.add(g);
		draw(g);
	}
	public static void drawSprite(USprite spr, Point2f pos){
		if(spr.isSheatSprite()){
			drawSpriteStr(spr, pos,spr.getSheat().getTileWidth(), spr.getSheat().getTileHeight());			
		}else{
			drawSpriteStr(spr, pos, spr.getTexture().getWidth(), spr.getTexture().getHeight());	
		}
		
	}
	public static void drawSpriteStr(USprite spr, Point2f pos, float w, float h){
		Texture tex = spr.getTexture();
		Graphics g = new RenderTexture(new Vector2f(w,h,pos),spr.getTexCords(), tex); 
		draw(g);
	}

	public static void drawFillRec(Vector2f dim){
		Graphics g = new RenderRec(dim);
		draw(g);
		
	}
	public static void drawRec(Vector2f dim){
	} 
	public static void drawShape(polyShape shape){
		RenderPolygon g = new RenderPolygon(shape.getPos(),new Polygon(shape.getVertecies(),null),c);
		setColor(1,0,0,1);
		draw(g);
	}
	public static void drawPolygon(Polygon t){
		RenderPolygon g = new RenderPolygon(t.getPos(),t,c);
		draw(g);
	}
	public static void setColor(float r, float g, float b, float a){
		c = new Color(r,g,b,a);	
	}
	public static void setBlendMode(int blendMode){
		b = new BlendMode(blendMode);
	}
	public Color getColor(){
		return c;
	}
}

