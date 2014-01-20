package youtube.aborysa.game.Render;

public class Color {
	float r,g,b,a;
	public Color(float r, float g, float b, float a){
		this.r = (r);
		this.g = (g);
		this.b = (b);
		this.a = (a);
	}
	public float getAlpha(){
		return a;
	}
	public float getRed(){
		return r;
	}
	public float getBlue(){
		return b;
	}
	public float getGreen(){
		return g;
	}
	public void setColor(float r, float g, float b, float a){
		this.r = (r);
		this.g = (g);
		this.b = (b);
		this.a = (a);
	}
}
