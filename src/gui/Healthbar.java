package gui;

import graphics.TwoColoredBar;
import maths.MyVector2f;

public class Healthbar extends GUIElement {
	protected MyVector2f coordinates;
	private int maxHealth;
	private float healthLeft;
	private int length;
	private int height;
	private TwoColoredBar bar;
	
	
	public Healthbar(float x, float y, int maxHealth, int length, int height) {
		this.coordinates = new MyVector2f(x, y);
		this.maxHealth = maxHealth;
		this.healthLeft = maxHealth;
		this.length = length;
		this.height = height;
		
		this.bar = new TwoColoredBar(this.length, this.height);
		
		
	}

	
	
	public void changeHealth(float amount) {
		this.healthLeft += amount;
		this.bar.setFractionLeft(this.healthLeft/this.maxHealth);
	}
	
	public void setHealth(float amount) {
		this.healthLeft = amount;
		this.bar.setFractionLeft(this.healthLeft/this.maxHealth);
	}
	



	@Override
	public void render() {
		this.bar.setFractionLeft(this.healthLeft/this.maxHealth);
		this.bar.render(this.coordinates.getX(), this.coordinates.getY());
		
	}

}
