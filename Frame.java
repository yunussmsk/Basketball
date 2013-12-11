import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener {

	private Ball ball = new Ball(0, 500);

	private Image image = new ImageIcon("basketbolpota.jpg").getImage();

	private Timer time;

	private long period;

	private int firstX, finalX, firstY, finalY;

	private int attempts = 0;

	private static int score = 0;
	
	public Frame() {
		super("Basketball");
		Toolkit tk = Toolkit.getDefaultToolkit();
		setSize(tk.getScreenSize());
		setUndecorated(true);
		add(new GamePanel());
		addMouseListener(new Handler());
		addMouseMotionListener(new Handler2());
		time = new Timer(50, this);
		time.start();
	}
	
	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		Frame.score = score;
	}

	private class GamePanel extends JPanel {

		public GamePanel() {
			setBackground(new Color(41, 49, 156));
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("", Font.BOLD, 20));

			g.setColor(Color.RED);
			
			g.drawString("5 points area",300,30);
			g.drawString("2 points area",1200,30);
			g.drawString("non-shooting area",1600,30);
			
			g.fillRect(1495, 0, 10, 1080);
			g.fillRect(745, 0, 10, 1080);

			g.fillRect(850, 10, 100, 20);

			g.setColor(Color.BLACK);
			
			g.drawString("Attempts", 860, 25);

			g.setColor(Color.RED);

			g.fillRect(980, 10, 100, 20);

			g.setColor(Color.BLACK);

			g.drawString("  Score", 990, 25);

			g.setColor(Color.WHITE);

			g.fillRect(850, 40, 100, 50);
			g.fillRect(980, 40, 100, 50);

			g.setColor(Color.BLACK);

			g.setFont(new Font("", Font.BOLD, 50));
			g.drawString(((attempts / 100 > 0) ? "" : "0")
					+ ((attempts / 10 > 0) ? "" : "0") + attempts, 860, 80);
			g.drawString(((score / 100 > 0) ? "" : "0")
					+ ((score / 10 > 0) ? "" : "0") + score, 990, 80);

			g.drawImage(ball.getImage(), ball.getX(), ball.getY(),
					ball.getSize(), ball.getSize(), null);

			g.drawImage(image, 1820, 300, 100, 100, null);

		}

	}

	public void actionPerformed(ActionEvent e) {
		ball.checkY();
		ball.gravity();
		ball.checkX();
		ball.fraction();
		ball.checkHoopStrike();
		ball.checkScore();
		repaint();
	}

	private class Handler implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			if (e.getX() <= 1500) {
				ball.setX(e.getX() - ball.getSize() / 2);
				ball.setY(e.getY() - ball.getSize() / 2);
				ball.setSpeedX(0);
				ball.setSpeedY(0);
			}
		}

		public void mousePressed(MouseEvent e) {
			if (e.getX() <= 1500) {
				firstX = e.getX() - ball.getSize() / 2;
				firstY = e.getY() - ball.getSize() / 2;

				ball.setX(firstX);
				ball.setY(firstY);

				ball.setSpeedX(0);
				ball.setSpeedY(0);

				period = e.getWhen();
			}
		}

		public void mouseReleased(MouseEvent e) {
			if (e.getX() <= 1500) {
				attempts++;

				finalX = e.getX() - ball.getSize() / 2;
				finalY = e.getY() - ball.getSize() / 2;

				ball.setSpeedX((finalX - firstX) / (int) (e.getWhen() - period)
						* 10);
				ball.setSpeedY((finalY - firstY) / (int) (e.getWhen() - period)
						* 10);
			}
		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {

		}

	}

	private class Handler2 implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
			if (e.getX() <= 1500) {
				ball.setX(e.getX() - ball.getSize() / 2);
				ball.setY(e.getY() - ball.getSize() / 2);
			}
		}

		public void mouseMoved(MouseEvent e) {

		}
	}

}
