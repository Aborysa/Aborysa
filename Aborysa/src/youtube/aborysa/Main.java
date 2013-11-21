package youtube.aborysa;

import org.newdawn.slick.opengl.Texture;
import youtube.aborysa.game.Render.Screen;
import youtube.aborysa.game.Math.geometrics.*;

public class Main {
	
	public static void main(String[] args){	
		/*Screen.init(640,480,"TEST");
		Texture tex = Screen.loadImage("PNG", "img/Test.png");
		Texture t = Screen.loadImage("PNG","img/Potet.png");
		Texture t2 = Screen.loadImage("PNG", "img/Potet_2.png");
		Texture t3 = Screen.loadImage("PNG", "img/Potet_3.png");
		Screen.setColor(1f, 1f, 1f);
		while (Screen.isRunning){
			Screen.drawImage(32, 32, tex);
			Screen.drawImage(64, 32, tex);
			Screen.drawImage(96, 32, tex);
			Screen.drawImage(128, 32, tex);
			Screen.drawImage(100, 100, t);
			Screen.drawImage(164, 100, t2);
			Screen.drawImageStr(228, 100,128,128, t3);
			//Screen.setColor(1f,0f,0f);
			//Screen.setColor(1f,1f,1f);
			//Screen.drawImagePart(228+64, 100,0,0,64,64, p3);
			Screen.run();
		}
		System.out.println("Terminating");
		Screen.cleanUp();
		*/
		Point2f p1 = new Point2f(1,1,false);
		Point2f p2 = new Point2f(3,-1,false);
		Vector2f a = new Vector2f(2,2,p1);
		Vector2f b = new Vector2f(-5,1,p2);
		Point2f p3 = geo.getIntersection(a, b);
		if (p3 == null){
			System.out.println("Lines are not intersecting!");
		}else{
			System.out.println(p3.toString());
		}
	}
}
