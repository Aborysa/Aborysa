package youtube.aborysa.game.Render;


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
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import youtube.aborysa.game.Math.geometrics.Point2f;
import static org.lwjgl.opengl.GL11.*;


public class Screen{
	static int FPS = 60;
	private static int WIDTH, HEIGHT;
	private static Color color = new Color(1, 1, 1, 1);
	private static Color backGroundColor = new Color(1,1,1,1);
	private static Texture tex, lastTex, colorTexture;
	
	private static ArrayList<Graphics> gCompList = new ArrayList<Graphics>();
	public static boolean isRunning = false;
	private static float[][] arrayTest = {{0,0},{1,0},{1f,1f},{0,0},{1,1},{0,1}};
	private static float[][] arrayTest2 = {{0,0},{90,0},{180,180},{0,0},{180,180},{0,180*1.5f}};
	/*synchronized static ArrayList<Graphics> getRenderList(){
		return gCompList;
	}*/
	public static void init(int width, int height, String title){
		isRunning = true;
		try {
			WIDTH = width;
			HEIGHT = height;
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.setTitle(title);
			Display.setVSyncEnabled(true);
			Display.create();
			initGL();
			pastInit();
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
		glOrtho(0, WIDTH, HEIGHT, 0, -1, 1);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}
	private static void pastInit(){
		tex = loadImage("PNG", "img/Potet_2.png");	
		colorTexture = loadImage("PNG","img/Cimg.png");
		setColor(1,1,1,1);
	}
	public static void run(){
		//glColor3f(0.8f,0.25f,0.1f);
			isRunning = !(Display.isCloseRequested());
			glClear(GL_COLOR_BUFFER_BIT);
			for(Graphics i : gCompList) {	
				setColor(i.getColor());
				i.draw();
				i.kill(); // <------ Kind of pointless for now
			}
			setColor(1f,0f,0f,1f);
			//Screen.drawImage(0,0,tex);
			//Screen.drawImagePartStr(0,0,tex.getImageWidth()*2,tex.getImageHeight()*2,0,0,2f,2f,tex);
			//Screen.drawCircle(200, 200, 128, 64,4);
			//Screen.drawLine(200,200,328,200,4);
			//Screen.drawRect(64, 64, 32, 32);
			Screen.drawPolyTexFan(arrayTest2,arrayTest, tex);
			setColor(0,0.1f,0.9f,1f);
			Screen.drawPolygon(arrayTest2);
			setColor(1f,1f,1f,1f);
			gCompList.clear();
			Display.sync(FPS);
			Display.update();
	}
	
	public static void cleanUp(){	
		Display.destroy();
	}
	public static Texture loadImage(String type, String source){
		Texture temp = null;
		try {
			temp = TextureLoader.getTexture(type, new FileInputStream(source));
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST); 
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return temp;
	}
	static void drawImagePartStr(float x, float y, float width, float height, float xStart, float yStart, float xEnd, float yEnd, Texture tex){
		if (!tex.equals(Screen.lastTex)){
			tex.bind();
			Screen.lastTex = tex;
		}	
		glBegin(GL_QUADS);
			glTexCoord2f(xEnd,yStart);
			glVertex2f(width+x,y);
			glTexCoord2f(xStart,yStart);
			glVertex2f(x, y);
			glTexCoord2f(xStart,yEnd);
			glVertex2f(x,height+y);
			glTexCoord2f(xEnd,yEnd);
			glVertex2f(width+x,height+y);
		glEnd();
	}
	protected static void drawImagePart(float x, float y, float xStart, float yStart, float xEnd, float yEnd,Texture tex){
		drawImagePartStr(x, y, xEnd*tex.getImageWidth(), yEnd*tex.getImageHeight(),xStart, yStart,xEnd, yEnd, tex);
	}
	/*protected static void drawImage(float x, float y, Texture tex){
		drawImgStr(x,y,tex.getImageWidth(),tex.getImageHeight(),tex);
	}*/
	protected static void drawPolyTexFan(float[][] points, float[][] texCords,Texture tex) throws ArrayIndexOutOfBoundsException{
		if (!tex.equals(Screen.lastTex)){
			tex.bind();
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
		glBegin(GL_TRIANGLE_FAN);
		for (int i=0; i < points.length;i++){
			glVertex2f(points[i][0],points[i][1]);
		}
		glEnd();
	}
	protected static void drawPolygon(float[][] points) throws ArrayIndexOutOfBoundsException{
		glBegin(GL_LINE_LOOP);
		for (int i=0; i < points.length;i++){
			glVertex2f(points[i][0],points[i][1]);
		}
		glEnd();
	}
	protected static void drawPolygon(float[] x, float[] y) throws ArrayIndexOutOfBoundsException{
		glBegin(GL_LINE_LOOP);
		for (int i=0; i < y.length;i++){
			glVertex2f(x[i],y[i]);
		}
		glEnd();
	}
	protected static void drawImageStr(float x, float y, float width, float height, Texture tex){
		drawImagePartStr(x, y, width, height,0, 0,1, 1, tex);
	}
/*	public static void drawImgStr(float x,float y, float width , float height, Texture tex){
		gCompList.add(new RenderTexture(new Point2f(x,y,false),tex)); //TODO: CHANGE THE FUNCTION NAME AND MAKE IT MORE ABSTRACT!!!!!
	}*/
	protected static void draw(Graphics g){
		gCompList.add(g);
	}
	protected static void setColor(Color c){
		if (c != null && !color.equals(c)){
			color = c;
			System.out.println(c.getGreen());
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
		glPointSize(size);
		glBegin(GL_LINES);
			glVertex2f(x, y);
			glVertex2f(x2, y2);	
		glEnd();
	}
	protected static void drawCircle(float x, float y, float radius,int verteces,float size){
		glPointSize(size);
		glBegin(GL_LINE_LOOP);
			for(int i=0; i<verteces;i++){
				glVertex2f(x+(float)(radius*(Math.cos(Math.PI*2*i/verteces))),y+(float)(radius*(Math.sin(Math.PI*2*i/verteces))));
			}
		glEnd();
	}
	/*public static void drawRect(int x, int y, int width, int height){
		drawImgStr(x,y,width,height,colorTexture);
	}*/
	protected static void drawRect(float x, float y, float width, float height){
		glBegin(GL_QUADS);
			glVertex2f(x,y);
			glVertex2f(x+width,y);
			glVertex2f(x+width,y+height);
			glVertex2f(x,y+height);
		glEnd();
	}
}