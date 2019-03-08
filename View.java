
/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/
 import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.image.BufferedImage;
 import java.io.File;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 import javax.swing.JFrame;
 import javax.swing.JPanel;

public class View extends JPanel {

	private final int width = 500;
	private final int height = 300;
	private final int imgWidth = 165;
	private final int imgHeight = 165;
	private final int totalNumDir = 8;
	BufferedImage[][] pics;
	private int xloc;
	private int yloc;
	private Direction direction;
	int picNum = 0;


	public static void main(String[] args) {
		new Controller();
	}

	public void paint(Graphics g) {
		g.drawImage(pics[dir][picNum], xloc += (xIncr * xDir), yloc += (yIncr * yDir), Color.gray, this);
	}

	public View() {
		JFrame frame = new JFrame();
		frame.getContentPane().add(this);
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);

		loadImages();

		frame.setVisible(true);
	}

	private BufferedImage createImage(String imageStr) { // takes in one of the 8 .png string
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(imageStr));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void update(int modelX, int modelY, Direction modelDir) {
		xloc = modelX;
		yloc = modelY;
		direction = modelDir;

	}

	public void loadImages() {
    	BufferedImage[] img = new BufferedImage[totalNumDir];

    	pics = new BufferedImage[totalNumDir][10];

    	String[] files = {"images/orc/orc_forward_north.png", "images/orc/orc_forward_east.png",
    			"images/orc/orc_forward_south.png", "images/orc/orc_forward_west.png",
    			"images/orc/orc_forward_northeast.png","images/orc/orc_forward_northwest.png",
    			"images/orc/orc_forward_southeast.png","images/orc/orc_forward_southwest.png"};

		for(int i = 0; i < totalNumDir; i++) {
			img[i] = createImage(files[i]);
		}


		for(int i = 0; i < totalNumDir; i++) { //number of pictures in array
			for(int j = 0; j < frameCount; j++) { //number of subimages in each picture
	    		pics[i][j] = img[i].getSubimage(imgWidth*j, 0, imgWidth, imgHeight);
			}
		}
    }

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getImageWidth() {
		return imgWidth;
	}

	public int getImageHeight() {
		return imgHeight;
	}
}
