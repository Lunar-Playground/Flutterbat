package com.lunarPlay.Flutterbat.Model;

import com.badlogic.gdx.math.Vector2;

public abstract class MoveableEntity extends Entity {

	protected Vector2 velocity;
	protected float SPEED;
	protected float rotation;
	
	public MoveableEntity(float SPEED, float rotation, float width, float height, Vector2 position) {
		super(position, width, height);
		this.SPEED = SPEED;
		this.rotation = rotation;
	}
	
	public abstract void update();
	
	/**
	 * @return the velocity
	 */
	public Vector2 getVelocity() {
		return velocity;
	}
	
	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}
	
	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return SPEED;
	}

	/**
	 * @return the rotation
	 */
	public float getRotation() {
		return rotation;
	}

	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
}
