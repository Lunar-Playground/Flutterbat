package com.lunarPlay.Flutterbat.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.lunarPlay.Flutterbat.View.World;

public class Player extends MoveableEntity {
	
	protected World world;
	protected Dummy dummy1, dummy2;
	protected float timer;
	
	/**
	 * 
	 * @param position The position of Player
	 * @param width The width of bounding box
	 * @param height The height of bounding box
	 * @param rotation The rotation of Player
	 * @param SPEED The speed constant
	 */
	public Player(World world, Vector2 position, float width, float height, float rotation, float SPEED) {
		super(SPEED, rotation, width, height, position);
		this.world = world;
		dummy1 = new Dummy(SPEED, 0, width / 100, height / 100, new Vector2(position));
		dummy2 = new Dummy(SPEED, 0, width / 100, height / 100, position);
	}

	public void update() {
		dummy1.update(this);
		dummy2.position.x = this.position.x;
		dummy2.position.y = this.position.y;
		dummy2.update(this);
		
		if(!dummy1.getBounds().overlaps(dummy2.getBounds())) {
			this.rotation = this.velocity.angle();
			position.lerp(dummy1.position, Gdx.graphics.getDeltaTime() * 4);
		}
		
		this.velocity.set(dummy1.position.cpy().sub(this.position.cpy()));
		
		bounds.x = position.x;
		bounds.y = position.y;
	}
	
	public Dummy getDummy1() {
		return dummy1;
	}
	
	public Dummy getDummy2() {
		return dummy2;
	}
}
