import javax.swing.*;
import java.awt.*;

public class Ball {
	private int x;
	private int y;
	private int speedX = 0;
	private int speedY = 0;
	private int accX = 0;
	private int accY = 0;
	private int size = 50;
	private Image image = new ImageIcon("basketball.png").getImage();

	public Ball() {
		x = 0;
		y = 0;
	}

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void gravity() {

		speedY++;
		y += speedY;
	}

	public void checkY() {
		if (y >= 1030) {
			y = 1030;
			speedY = -2 * speedY / 3;
		}
		if (y <= 0) {
			y = 0;
			speedY = -2 * speedY / 3;
		}

	}

	public void fraction() {
		if (speedX > 0) {
			if (x % 8 == 0)
				speedX--;
			x += speedX;
		}
		if (speedX < 0) {
			if (x % 8 == 0)
				speedX++;
			x += speedX;
		}
	}

	public void checkX() {
		if (x >= 1870) {
			x = 1870;
			speedX = -2 * speedX / 3;
		}

		if (x <= 0) {
			x = 0;
			speedX = -2 * speedX / 3;
		}

	}

	public void checkHoopStrike() {
		if (x < 1830 && x > 1770 && y > 250 && y < 305) {
			if (x < 1800) {
				x--;
				speedX = speedY + speedX;
			}
			if (x >= 1800) {
				x++;
				speedX = -speedY - speedX;
			}
			speedX = -speedX / 3;
			speedY = -2 * speedY / 3;
		}
		if (x < 1920 && x > 1860 && y > 250 && y < 310) {
			if (x < 1890) {
				x--;
				speedX = speedY + speedX;
			}
			if (x >= 1890) {
				x++;
				speedX = -speedY - speedX;
			}
			speedX = -speedX / 3;
			speedY = -2 * speedY / 3;
		}

	}
	
	public void checkScore(){
		if(x > 1820 && x < 1920 && y > 300 && y < 320)
		Frame.setScore(Frame.getScore() + 1);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public int getAccX() {
		return accX;
	}

	public void setAccX(int accX) {
		this.accX = accX;
	}

	public int getAccY() {
		return accY;
	}

	public void setAccY(int accY) {
		this.accY = accY;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
