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

  int dir;
  final static int north = 0;
  final static int east = 1;
  final static int south = 2;
  final static int west = 3;
  final static int northeast = 4;
  final static int northwest = 5;
  final static int southeast = 6;
  final static int southwest = 7;

  public Model(int viewWidth, int viewHeight, int imageWidth, int imageHeight) {
    this.viewWidth = viewWidth;
    this.viewHeight = viewHeight;
    imgWidth = imageWidth;
    imgHeight = imageHeight;
  }

  public void updateLocationAndDirection() {
	  if (xloc <= 0) {
      	if(yDir>0) {
      		direction = Direction.SOUTHEAST;
      	}else {
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
