package youtube.aborysa.game.Input;

public interface KeyListener {
	//void ButtonPressed(float keyCode);
	//void ButtonReleasd(float keyCode);
	void ButtonDown(float keyCode);
	int[] getKeyCodes();
}
