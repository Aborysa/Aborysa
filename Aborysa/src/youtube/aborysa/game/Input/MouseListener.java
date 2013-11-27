package youtube.aborysa.game.Input;

public interface MouseListener {
	void mouseHover();
	void mouseLeave();
	void mouseEnter();
	void mouseClick(float x, float y,int code);
	void mouseRelease(int code);
	
}
