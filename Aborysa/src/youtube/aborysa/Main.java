package youtube.aborysa;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

import youtube.aborysa.game.Render.RenderTexture;
import youtube.aborysa.game.Render.Screen;
import youtube.aborysa.game.Tiles.SheatSprite;
import youtube.aborysa.game.Tiles.SpriteSheat;
import youtube.aborysa.game.Util.FPSCounter;
import youtube.aborysa.game.GameObjects.TestProject;
import youtube.aborysa.game.Input.KeyHandler;
import youtube.aborysa.game.Input.KeyListener;
import youtube.aborysa.game.Input.MouseHandler;
import youtube.aborysa.game.Input.MouseListener;
import youtube.aborysa.game.Math.geometrics.*;

public class Main implements KeyListener, MouseListener {
	static boolean left = false;
	static boolean up = false;
	static boolean down = false;
	static boolean right = false;
	static float x = 0;
	static float y = 0;
	static Texture tex;
	static ArrayList<TestProject> pros = new ArrayList<TestProject>();
	static ArrayList<TestProject> killed = new ArrayList<TestProject>();
	static int killCount = 0;
	public final static URL Root = Main.class.getResource("");
	public Main(){}
	
	public static void main(String[] args) {	
		System.setProperty("org.lwjgl.librarypath", new File("natives").getAbsolutePath());
		Screen.init(640,480,"TEST");
		System.out.println(Root);
		//System.exit(0);
		KeyHandler.init();
		KeyHandler.addKeyListener(new Main());
		MouseHandler.init();
		MouseHandler.addMouseListener(new Main());
		tex = Screen.loadImage("PNG", "img/Test.png");
		Texture t = Screen.loadImage("PNG","img/Potet.png");
		Texture t2 = Screen.loadImage("PNG", "img/Potet_2.png");
		Texture t3 = Screen.loadImage("PNG", "img/Potet_3.png");
		Texture sheat1 = Screen.loadImage("PNG", "img/SpriteSheet.png");
		SpriteSheat sTest = new SpriteSheat(sheat1,32,32);
		SheatSprite testSprite = new SheatSprite(sTest,1,1);
		FPSCounter counter = new FPSCounter();
		while (Screen.isRunning){
			
			KeyHandler.update();
			MouseHandler.update();
			Screen.setColor(1f, 1f, 1f);
			Screen.drawImgStr(x, y,32,32, tex);
			Screen.drawImgStr(64, 32,32,32, tex);
			Screen.drawImgStr(96, 32,32,32, tex);
			Screen.drawImgStr(128, 32,32,32, tex);
			Screen.drawImgStr(100, 100,32,32, t);
			Screen.drawImgStr(164, 100,32,32, t2);
			Screen.drawImgStr(228, 100,128,128, t3);
			
			Screen.draw(new RenderTexture(new Vector2f(32,32,new Point2f(300,300,false)),testSprite.getTexCords(), sTest.getTex()));
			for(TestProject i : pros){
				i.update();
				if (i.killed){
					killed.add(i);
				}
			}

			for(TestProject i : killed){
				pros.remove(i);
				killCount++;
			}
			killed.clear();
			killCount = 0;
			if(right){
				x+=3;			
			}
			if(left){
				x-=3;
			}
			if(up){
				y-=3;
			}
			if(down){
				y+=3;
			}
			//Screen.drawImageStr(228+64, 100,128,128, t3);
			//	System.out.println(KeyHandler.getKey()); 
			//Screen.setColor(1f,0f,0f);
			//Screen.setColor(1f,1f,1f);
			//Screen.drawImagePart(228+64, 100,0,0,64,64, p3);
			Screen.run();
			counter.tick();
			System.out.println("FPS: " + counter.getFPS());
		}
		System.out.println("Terminating");
		MouseHandler.dispose();
		KeyHandler.dispose();
		Screen.cleanUp();
	
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

	@Override
	public void ButtonPressed(int keyCode) {
		if (keyCode == 200){
			up = true;
		}
		if (keyCode == 208){
			down = true;
		}
		if (keyCode == 203){
			left = true;
		}
		if (keyCode == 205){
			right = true;
		}
	}

	@Override
	public void ButtonReleasd(int keyCode) {
		if (keyCode == 200){
			up = false;
		}
		if (keyCode == 208){
			down = false;
		}
		if (keyCode == 203){
			left = false;
		}
		if (keyCode == 205){
			right = false;
		}		
	}
	@Override
	public void mouseClick(float x, float y, int code) {
		//System.out.println("Mouse pressed: " + x + ", " + y + ", " + code);
		float dx = x - Main.x;
		float dy = ((480-y) - Main.y);
		float xV = (float) (dx/Math.sqrt(Math.pow(dx,2) + Math.pow(dy, 2))+(Math.random()-0.5));
		float yV = (float) (dy/Math.sqrt(Math.pow(dx,2) + Math.pow(dy, 2))+(Math.random()-0.5));
		//System.out.println(xV);
		//System.out.println(yV);
		pros.add(new TestProject(new Vector2f(xV*6,yV*6, new Point2f(this.x,this.y,false)), Main.tex));
	}
	@Override
	public void mouseRelease(float x, float y, int code) {
		
	}
}
