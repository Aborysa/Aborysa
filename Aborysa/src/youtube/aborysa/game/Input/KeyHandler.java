package youtube.aborysa.game.Input;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

public class KeyHandler{
	
	static ArrayList<KeyListener> listeners = new ArrayList<KeyListener>();
	
	public static void addKeyListener(KeyListener listener){
		listeners.add(listener);
	}
	public static void clearListener(KeyListener listener){
		listeners.remove(listener);
	}
	public static void checkKeys(){
		for(KeyListener i : listeners){
			int[] l = i.getKeyCodes();
		}
	}
	public static int getKey(){
		return 0;
	}
}
