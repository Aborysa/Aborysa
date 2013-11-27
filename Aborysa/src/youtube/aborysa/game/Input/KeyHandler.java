package youtube.aborysa.game.Input;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

public class KeyHandler{
	
	static ArrayList<KeyListener> listeners = new ArrayList<KeyListener>();
	static int[] keys;
	static int[][] keyCodes;
	static boolean[] down = new boolean[65535];
	public static void addKeyListener(KeyListener listener){
		listeners.add(listener);
	}
	public static void clearListener(KeyListener listener){
		listeners.remove(listener);
	}
	public static void checkKeys(){
		keyCodes = new int[listeners.size()][];
		int count = 0;
		for(KeyListener i : listeners){
			keyCodes[count] = i.getKeyCodes();
			count++;
		}
		for(int i=0; i<keyCodes.length;i++){
			
		}
	}
	public static int getKey(){
		return 0;
	}
}
