package graphics;

public class TwoColoredBar extends AdvancedRenderObject {
	private int maxHealth;
	private float healthLeft;
	private int length;
	private int height;
	private Rectangle base;
	private Rectangle health;
	
	public TwoColoredBar(int maxHealth, int length, int height) {
		this.maxHealth = maxHealth;
		this.healthLeft = maxHealth;
		this.length = length;
		this.height = height;
		this.base = new Rectangle(this.length, this.height);
		this.base.setColor(0.5f, 0.1f, 0.1f);
		this.health = new Rectangle(this.length, this.height);
		this.health.setColor(0.1f, 0.5f, 0.1f);
		
	}

	@Override
	public void render(float x, float y) {
		this.base.render(x, y);
		this.health.setWidth((this.healthLeft/this.maxHealth) * this.length);
		this.health.render(x, y);

	}
	
	public void changeHealth(int amount) {
		this.healthLeft += amount;
	}

}
