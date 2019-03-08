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
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel {

  private final int width = 500;
  private final int height = 300;
  private final int imgWidth = 165;
  private final int imgHeight = 165;

  public static void main(String[] args) {
    new Controller();
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

  private void loadImages() {
    //load the images and store them in a 2d-array
  }

  public void update(int modelX, int modelY, Direction modelDir) {
    
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
