package pong_java;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public boolean right;
	public boolean left;
	
	public int x, y;
	public int width,height;
	
	public Player(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public void tick() {
		if (right) {
			x += 4;
		}
		if (left) {
			x -= 4;
		}
		
		if (x + width > Game.WIDTH) {
			x = Game.WIDTH - width;
		}
		
		if (x < 0) {
			x = 0;
		}
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 40, 10);
	}

}
