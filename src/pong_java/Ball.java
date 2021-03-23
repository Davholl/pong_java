package pong_java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	public double x,y;
	public int width;
	public int height;
	
	public double dx, dy;
	public double speed = 2.0;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 3;
		this.height = 3;
		
		dx = new Random().nextGaussian();
		dy = new Random(). nextGaussian();
	}
	
	public void tick() {
		
		//Colisão com paredes
		if (x + (dx*speed) + width >= Game.WIDTH) {
			dx*=-1;
		}else if (x+(dx*speed) < 0) {
			dx*=-1;
		}
		
		if (y >= Game.HEIGHT){
			//ponto do inimigo
			new Game();
		}else if (y <0) {
			//ponto do jogador
			new Game();
		}
		
		Rectangle bounds = new Rectangle((int)(x+dx*speed),(int) (y+(dx*speed)), width, height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
		
		if (bounds.intersects(boundsPlayer) || bounds.intersects(boundsEnemy)){
			dy*=-1;
		}
		
		x+=dx*speed;
		y+=dy*speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
	}
}
