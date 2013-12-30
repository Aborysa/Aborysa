package youtube.aborysa.game.Render;

import youtube.aborysa.game.Tiles.SheatSprite;
import youtube.aborysa.game.Tiles.Sprite;
import youtube.aborysa.game.Tiles.SpriteSheat;

public class Drawer {
	
	
	
	private static void draw(Graphics g){
		Screen.draw(g);
	}
	public static void drawSprite(Sprite spr, float x, float y){
		Screen.drawImage(x, y, spr.getTexture());
	}
	public static void drawSprite(SheatSprite spr, float x, float y){
		SpriteSheat sheat = spr.getSheat();
		Screen.drawImagePart(x, y, spr.getTexCords().getPos().getX(), spr.getTexCords().getPos().getY(), spr.getTexCords().getX(), spr.getTexCords().getY(), spr.getSheat().getTex());
	}
	public static void drawSprite(SpriteSheat sheat,int index){
		
	}
}

