package graphics;

public class TwoColoredBar extends AdvancedRenderObject {
	private Rectangle base;
	private Rectangle health;
	private float length;
	private float height;
	private float length2;
	
	
	
	public TwoColoredBar(float length, float height) {
		this.length = length;
		this.height = height;
		
		this.base = new Rectangle((int)this.length, (int)this.height);
		this.base.setColor(0.5f, 0.1f, 0.1f);
		this.health = new Rectangle((int)this.length, (int)this.height);
		this.health.setColor(0.1f, 0.5f, 0.1f);
		
		this.length2 = length;
	}



	@Override
	public void render(float x, float y) {
		this.base.render(x, y);
		this.health.setWidth(length2);
		this.health.render(x, y);

	}
	
	public void setFractionLeft(float fraction) {
		this.length2 = this.length * fraction;
	}
}
