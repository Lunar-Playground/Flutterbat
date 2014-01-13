package com.lunarPlay.Flutterbat.Model;

import com.badlogic.gdx.math.Vector2;

public class Player extends MoveableEntity {

	/**
	 * 
	 * @param position The position of Player
	 * @param width The width of bounding box
	 * @param height The height of bounding box
	 * @param rotation The rotation of Player
	 * @param SPEED The speed constant
	 */
	public Player(Vector2 position, float width, float height, float rotation, float SPEED) {
		super(SPEED, rotation, width, height, position);
	}

	@Override
	public void update() {
		
	}

	
}
