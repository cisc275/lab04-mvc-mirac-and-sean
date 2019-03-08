/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 * detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

public class Model {

  //Location and direction
  private int xLoc;
  private int yLoc;
  private Direction direction;

  //Display properties
  private int viewWidth;
  private int viewHeight;
  private int imgWidth;
  private int imgHeight;

  public Model(int viewWidth, int viewHeight, int imageWidth, int imageHeight) {
    this.viewWidth = viewWidth;
    this.viewHeight = viewHeight;
    imgWidth = imageWidth;
    imgHeight = imageHeight;
  }

  public void updateLocationAndDirection() {

  }

  private boolean detectCollision() {
    //return whether or not we are colliding with the view boundaries
    return false;
  }

  public int getX() {
    return xLoc;
  }

  public int getY() {
    return yLoc;
  }

  public Direction getDirect() {
    return direction;
  }
}
