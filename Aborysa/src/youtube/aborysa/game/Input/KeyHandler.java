package youtube.aborysa.game.Input;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

public class KeyHandler{
	
	static ArrayList<KeyListener> listeners = new ArrayList<KeyListener>();
	static int[] keys;
	static int[][] keyCodes;
	static boolean[] down = new boolean[65535];
	public static void addKeyListener(KeyListener listener){
		if (Keyboard.isCreated())
			listeners.add(listener);
	}
	public static void clearListener(KeyListener listener){
		if (Keyboard.isCreated())
			listeners.remove(listener);
	}
	public static void init(){
		if (!Keyboard.isCreated())
			try {
				Keyboard.create();
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
	}
	public static void dispose(){
		listeners.clear();
		Keyboard.destroy();
	}
	public static void update(){
		if (Keyboard.isCreated()){
			boolean getNext = Keyboard.next();
			if (getNext){
				int keyCode = Keyboard.getEventKey();
				char Char = Keyboard.getEventCharacter();
				boolean pressed = Keyboard.getEventKeyState();
				//System.out.println("Keycode: " + keyCode + ", char: " + Char + ", pressed: " + pressed + ", keyName: " + Keyboard.getKeyName(keyCode));
				for(KeyListener l : listeners){
					if(pressed)
						l.ButtonPressed(keyCode);
					else
						l.ButtonReleasd(keyCode);
				}
			}
		}
	}
}
