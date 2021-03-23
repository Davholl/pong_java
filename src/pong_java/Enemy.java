package pong_java;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	
	public double x,y;
	public int width;
	public int height;
	
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 10;
	}
	
	public void tick() {
		if (Game.ball.x > x) {
			x++;
		}else if (Game.ball.dx < x){
			x--;
		} else {
			return;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, width, height);
	}
}
