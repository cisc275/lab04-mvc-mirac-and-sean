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
  private int xloc;
  private int yloc;
  private Direction direction;
  private int xDir;
  private int yDir;

  //Pixels moved per update
  private final int xIncr = 8;
  private final int yIncr = 2;

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
	   if(xloc <= 0) {
      	if(yDir>0) {
      		direction = Direction.SOUTHEAST;
      	}
        else {
      		direction = Direction.NORTHEAST;
      	}
          xDir = 1;
      }
      else if (xloc + imgWidth >= viewWidth) {
      	if(yDir > 0) {
      		direction = Direction.SOUTHWEST;
        }
        else {
          direction = Direction.NORTHWEST;
        }
        xDir = -1;
      }

      if (yloc <= 0) {
      	if(xDir > 0) {
      		direction = Direction.SOUTHEAST;
        }
        else {
          direction = Direction.SOUTHWEST;
        }
        yDir = 1;
      }
      else if (yloc + imgHeight >= viewHeight) {
      	if(xDir > 0) {
      		  direction = Direction.NORTHEAST;
			  }
        else {
          direction = Direction.NORTHWEST;
			  }
        yDir = -1;
      }

      xloc += xIncr * xDir;
      yloc += yIncr * yDir;
    }


  public int getX() {
    return xloc;
  }

  public int getY() {
    return yloc;
  }

  public Direction getDirect() {
    return direction;
  }
}
