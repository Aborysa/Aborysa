package youtube.aborysa.game.Render;


import java.awt.Canvas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import youtube.aborysa.game.Render.Texture.*;

import youtube.aborysa.Main;
import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Render.Texture.FrameBuffer;


import static org.lwjgl.opengl.GL11.*;


public class Screen{
	static int FPS = 60;
	private static int WIDTH, HEIGHT;
	private static Color color = new Color(1, 1, 1, 1);
	private static Color backGroundColor = new Color(1,1,1,1);
	private static Texture tex, lastTex;
	private static BlendMode cBlendMode = new BlendMode(BlendMode.BLEND_ALPHA);
	private static ArrayList<Graphics> gCompList = new ArrayList<Graphics>();
	public static boolean isRunning = false;
	private static float[][] arrayTest = {{0,0},{1,0},{1f,1f},{0,0},{1,1},{0,1}};
	private static float[][] arrayTest2 = {{0,0},{90,0},{180,180},{0,0},{180,180},{0,180*1.5f}};
	
	private static FrameBuffer FrameTest;
	private static FrameBuffer FrameTest2;
	private static youtube.aborysa.game.Render.Texture.Texture texTest;
	public static void init(int width, int height, String title, Canvas canvas){
		isRunning = true;
		try {
			WIDTH = width;
			HEIGHT = height;
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.setTitle(title);
			//Display.setVSyncEnabled(true);
			Display.setParent(canvas);
			Display.create();
			initGL();
			pastInit();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void setCanvas(Canvas canvas){
		try {
			Display.setParent(canvas);
			Display.update();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	private static void initGL(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		//Enabling GL_Rendering_Mode
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		glOrtho(0, WIDTH, HEIGHT, 0, -100, 100);
		glDepthFunc(GL_DEPTH_TEST);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}
	private static void pastInit(){
		/*tex = Screen.loadImage("img/test.png");
		FrameTest = new FrameBuffer(64,64);
		FrameTest2 = new FrameBuffer(64,64);
		texTest = youtube.aborysa.game.Render.Texture.TextureLoader.loadTexture("img/Potet.png");
		System.out.println(new File("img/test.png").getAbsolutePath());
		 */
	}
	// Will be removed and replaced by shader programs
	protected static void setBlendMode(BlendMode b){
		if ((!cBlendMode.equals(b)) && (b !=null)){
			cBlendMode = b;
			int[] bModes = cBlendMode.getBlendMode();
			glBlendFunc(bModes[0],bModes[1]);
			
		}
		
		
	}
	public static void run(){
			isRunning = !(Display.isCloseRequested());
			glClear(GL_COLOR_BUFFER_BIT);
			for(Graphics i : gCompList) {	
				setColor(i.getColor());
				setBlendMode(i.getBlendMode());
				i.draw();
				i.kill(); // <------ Kind of pointless for now
			}			
			gCompList.clear();
			Display.sync(60);
			Display.update();
	}
	
	public static void cleanUp(){	
		Display.destroy();
	}
	
	public static Texture loadImage(String source){
		Texture temp = null;
		try {
			temp = TextureLoader.loadTexture(source);
			//temp = TextureLoader.getTexture(type, new FileInputStream(source));
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST); 
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return temp;
	}
	static void drawImagePartStr(float x, float y, float width, float height, float xStart, float yStart, float xEnd, float yEnd, Texture tex){
		if (tex == null){
			glDisable(GL_TEXTURE_2D);
		}
		else if (!tex.equals(Screen.lastTex)){
			glEnable(GL_TEXTURE_2D);
			tex.bindTexture();
			Screen.lastTex = tex;
		}

		glBegin(GL_QUADS);
			glTexCoord2f(xEnd,yStart);
			glVertex3f(width+x,y,0);
			glTexCoord2f(xStart,yStart);
			glVertex3f(x, y,0);
			glTexCoord2f(xStart,yEnd);
			glVertex3f(x,height+y,0);
			glTexCoord2f(xEnd,yEnd);
			glVertex3f(width+x,height+y,0);
		glEnd();
	}
	protected static void drawPolyTexFan(float[][] points, float[][] texCords,Texture tex) throws ArrayIndexOutOfBoundsException{
		if (!tex.equals(Screen.lastTex)){
			tex.bindTexture();
			Screen.lastTex = tex;
		}		
		glBegin(GL_TRIANGLE_FAN);
		for (int i=0; i < points.length;i++){
			glTexCoord2f(texCords[i][0],texCords[i][1]);
			glVertex2f(points[i][0],points[i][1]);
		}
		glEnd();
	}
	protected static void drawPolyFan(float[][] points) throws ArrayIndexOutOfBoundsException{
		glDisable(GL_TEXTURE_2D);
		glBegin(GL_TRIANGLE_FAN);
		for (int i=0; i < points.length;i++){
			glVertex2f(points[i][0],points[i][1]);
		}
		glEnd();
		glEnable(GL_TEXTURE_2D);
	}
	protected static void drawPolygon(float[][] points) throws ArrayIndexOutOfBoundsException{
		glDisable(GL_TEXTURE_2D);
		glBegin(GL_LINE_LOOP);
		for (int i=0; i < points.length;i++){
			glVertex2f(points[i][0],points[i][1]);
		}
		glEnd();
		glEnable(GL_TEXTURE_2D);
	}
	protected static void drawPolygon(float[] x, float[] y) throws ArrayIndexOutOfBoundsException{
		glDisable(GL_TEXTURE_2D);
		glBegin(GL_LINE_LOOP);
		for (int i=0; i < y.length;i++){
			glVertex2f(x[i],y[i]);
		}
		glEnd();
		glEnable(GL_TEXTURE_2D);
	}
	protected static void draw(Graphics g){
		gCompList.add(g);
	}
	protected static void setColor(Color c){
		if (c != null && !color.equals(c)){
			color = c;
			glColor4f(c.r,c.g,c.b,c.a);
		}
	}
	protected static void setColor(float r,float g, float b, float a){
		color.setColor(r, g, b, a);;
		glColor4f(r,g,b,a);
	}
	
	protected static Color getColor(){
		return color;
	}
	protected static void drawLine(float x, float y, float x2, float y2,float size){
		//glPointSize(size);
		glBegin(GL_LINES);
			glVertex2f(x, y);
			glVertex2f(x2, y2);	
		glEnd();
	}
	protected static int genFBO(){
		return 0;
	}
	protected static void drawCircle(float x, float y, float radius,int verteces,float size){
		glBegin(GL_LINE_LOOP);
			for(int i=0; i<verteces;i++){
				glVertex2f(x+(float)(radius*(Math.cos(Math.PI*2*i/verteces))),y+(float)(radius*(Math.sin(Math.PI*2*i/verteces))));
			}
		glEnd();
	}
	protected static void drawRect(float x, float y, float width, float height){
		glDisable(GL_TEXTURE_2D);
		glBegin(GL_QUADS);
			glVertex2f(x,y);
			glVertex2f(x+width,y);
			glVertex2f(x+width,y+height);
			glVertex2f(x,y+height);
		glEnd();
		glEnable(GL_TEXTURE_2D);
	}
}