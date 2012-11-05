package com.Broders.Entities;

import com.Broders.Logic.CoreLogic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Asteroid extends Entity{

	public Asteroid(String id, EntityType type, float x, float y) {
		super(id, type);
		// TODO Write initialization for Asteroid body/sprite
		Vector2 vertices[] = new Vector2[7];
		if(id.equals("small")){
			vertices[0] = new Vector2(0.548f, 2.5f);
			vertices[1] = new Vector2(2.039f, 1.167f);
			vertices[2] = new Vector2(1.347f, -0.241f);
			vertices[3] = new Vector2(2.169f, -1.243f);
			vertices[4] = new Vector2(0.627f, -2.5f);
			vertices[5] = new Vector2(-2.161f, -1.585f);
			vertices[6] = new Vector2(-2.161f, 1.419f);
		}
		if(id.equals("medium")){
			vertices[0] = new Vector2(0.548f*2, 2.5f*2);
			vertices[1] = new Vector2(2.039f*2, 1.167f*2);
			vertices[2] = new Vector2(1.347f*2, -0.241f*2);
			vertices[3] = new Vector2(2.169f*2, -1.243f*2);
			vertices[4] = new Vector2(0.627f*2, -2.5f*2);
			vertices[5] = new Vector2(-2.161f*2, -1.585f*2);
			vertices[6] = new Vector2(-2.161f*2, 1.419f*2);
		}
		if(id.equals("large")){
			vertices[0] = new Vector2(0.548f*3, 2.5f*3);
			vertices[1] = new Vector2(2.039f*3, 1.167f*3);
			vertices[2] = new Vector2(1.347f*3, -0.241f*3);
			vertices[3] = new Vector2(2.169f*3, -1.243f*3);
			vertices[4] = new Vector2(0.627f*3, -2.5f*3);
			vertices[5] = new Vector2(-2.161f*3, -1.585f*3);
			vertices[6] = new Vector2(-2.161f*3, 1.419f*3);
		}
		
		PolygonShape shape = new PolygonShape();
		shape.set(vertices);

		FixtureDef fixDef = new FixtureDef();
		fixDef.shape = shape;
		fixDef.density = 0.5f;

		BodyDef bodDef = new BodyDef();
		bodDef.type = BodyType.DynamicBody;
		bodDef.angularDamping = 0.0f;
		bodDef.linearDamping = 0.0f;

		bodDef.position.set(x, y);
		bodDef.angle = MathUtils.PI;
		bodDef.allowSleep = false;
		super.createBody(bodDef, fixDef);

		//sprite
		float meter = Gdx.graphics.getHeight()/CoreLogic.getHeight();			

		super.setSprite(type.getSubType().getSpritePath());
		super.getSprite().setOrigin((meter)/2, (meter)/2);
		super.getSprite().setSize(meter, meter);
		super.getSprite().setColor(Color.WHITE);
	}

	@Override
	public void Draw(SpriteBatch sb) {
		// TODO Kris - Implement this draw method
		float screenWidth =  Gdx.graphics.getWidth();
		float screenHeight =  Gdx.graphics.getHeight();

		float x = super.getBody().getPosition().x;
		float y = super.getBody().getPosition().y;

		float posX;
		float posY;

		//this will only work for single player
		posX = screenWidth*(x/CoreLogic.getWidth());
		posY =  screenHeight*(y/CoreLogic.getHeight());

		super.getSprite().setPosition(posX, posY);
		super.getSprite().setRotation(super.getBody().getAngle());
		super.getSprite().draw(sb);

	}

}
