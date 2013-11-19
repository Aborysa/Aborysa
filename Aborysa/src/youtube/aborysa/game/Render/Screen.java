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
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import static org.lwjgl.opengl.GL11.*;


public class Screen{
	static int FPS = 60;
	private static int WIDTH, HEIGHT;
	private static Color color = new Color(1, 1, 1, 1);
	private static Color backGroundColor = new Color(1,1,1,1);
	private static Texture tex, lastTex, colorTexture;
	private static ArrayList<GraphicsComp> gCompList = new ArrayList<GraphicsComp>();
	public static boolean isRunning = false;
	
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
		tex = loadImage("PNG","img/Test.png");	
		colorTexture = loadImage("PNG","img/Cimg.png");
		setColor(1,1,1);
		setAlpha(1);
	}
	public static void drawBackground(){
		
		
	}
	public static void run(){
		//glColor3f(0.8f,0.25f,0.1f);
			isRunning = !(Display.isCloseRequested());
			glClear(GL_COLOR_BUFFER_BIT);
			
			for(GraphicsComp i : gCompList) {
				drawImgStr(i.x,i.y,i.width,i.height,i.tex);
			}
			setColor(1f,0f,0f);
			Screen.drawCircle(200, 200, 128, 16,4);
			Screen.drawLine(200,200,232,200,4);
			setColor(1f,1f,1f);
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
	public static void drawImagePartStr(int x, int y, int width, int height, int xStart, int yStart, int xWidth, int yHeight, Texture tex){
		if (!tex.equals(Screen.lastTex)){
			tex.bind();
			Screen.lastTex = tex;
		}	
		float xS, yS, xE, yE;
		xS = xStart / tex.getImageWidth();
		yS = yStart / tex.getImageHeight();
		xE = xWidth / tex.getImageWidth();
		yE = yHeight / tex.getImageHeight();
		
		glBegin(GL_QUADS);
			glTexCoord2f(xS + xE,yS);
			glVertex2f(width+x,y);
			glTexCoord2f(xS,yS);
			glVertex2f(x, y);
			glTexCoord2f(xS,yS+ yE);
			glVertex2f(x,height+y);
			glTexCoord2f(xS+xE,yS+yE);
			glVertex2f(width+x,height+y);
		glEnd();
	}
	private static void drawImagePart(int x, int y, int xStart, int yStart, int xWidth, int yHeight,Texture tex){
		drawImagePartStr(x, y, xWidth, yHeight,xStart, yStart,xWidth, yHeight, tex);
	}
	public static void drawImage(int x, int y, Texture tex){
		drawImageStr(x,y,tex.getImageWidth(),tex.getImageHeight(),tex);
	}
	private static void drawPolygon(float[] x, float[] y){
		glBegin(GL_QUADS);
		for (int i=0; i < y.length;i++){
			glVertex2f(x[i],y[i]);
		}
		glEnd();
	}
	private static void drawImgStr(int x, int y, int width, int height, Texture tex){
		drawImagePartStr(x, y, width, height,0, 0,tex.getImageWidth(), tex.getImageHeight(), tex);
	}
	
	public static void drawImageStr(int x,int y, int width , int height, Texture tex){
		gCompList.add(new GraphicsComp(x,y,width,height,tex));
	}
	public static void setColor(float r, float g, float b){
		color.r = r;
		color.b = b;
		color.g = g;
		glColor4f(r,g,b,color.a);
	}
	public static void setAlpha(float a){
		color.a = a;
		glColor4f(color.r, color.g, color.b, a);
	}
	public static float getAlpha(){
		return color.a;
	}
	public static Color getColor(){
		return color;
	}
	public static void drawLine(float x, float y, float x2, float y2,float size){
		glPointSize(size);
		glBegin(GL_LINES);
			glVertex2f(x, y);
			glVertex2f(x2, y2);	
		glEnd();
	}
	public static void drawCircle(float x, float y, float radius,int verteces,float size){
		glPointSize(size);
		glBegin(GL_LINE_LOOP);
			for(int i=0; i<verteces;i++){
				glVertex2f(x+(float)(radius*(Math.cos(Math.PI*2*i/verteces))),y+(float)(radius*(Math.sin(Math.PI*2*i/verteces))));
			}
		glEnd();
	}
	public static void drawRect(int x, int y, int width, int height){
		drawImgStr(x,y,width,height,colorTexture);
	}
	public static void drawPoly(int[] x, int[] y){
		
	}

	
}