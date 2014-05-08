package youtube.aborysa.game.Input;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Vector2f;
public class MouseHandler {
	static Vector2f delta = new Vector2f(0,0,null);
	static Point2f pos = new Point2f(0,0,false);
	static ArrayList<MouseListener> listeners = new ArrayList<MouseListener>();
	
	public static void init(){
		if (!Mouse.isCreated()){
			try {
				Mouse.create();
			} catch (LWJGLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//TODO: cleanup, maybe change the getters
	public static void setMousePos(int x, int y){
		Mouse.setCursorPosition(x, y);
	}
	public static void grabMouse(boolean grab){
		Mouse.setGrabbed(grab);
	}
	public static void addMouseListener(MouseListener listener){
		listeners.add(listener);
	}
	public static void removeMouseListener(MouseListener listener){
		listeners.remove(listener);
	}
	public static void dispose(){
		listeners.clear();
		Mouse.destroy();
	}
	public static void update(){
		if(Mouse.isCreated()){
			pos.setCords(Mouse.getX(), Mouse.getY());
			delta.set(Mouse.getDX(), Mouse.getDY());
			boolean next = Mouse.next();
			float mWheel = Mouse.getDWheel();
			while(next){
				int mCode = Mouse.getEventButton();
				boolean pressed = Mouse.getEventButtonState();
				if (mCode != -1){
					for(MouseListener l : listeners){
						if(pressed)
							l.mouseClick(pos.getX(), pos.getY(), mCode);
						else
							l.mouseRelease(pos.getX(), pos.getY(), mCode);
					}
				}
			next = Mouse.next();
			}
		}
	}
	public static Point2f getPos(){
		return pos;
	}
}
