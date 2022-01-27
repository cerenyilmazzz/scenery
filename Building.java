/**
 * This class storing information about the building
 */
public class Building {
    public int floorCount;
    public double centerX;
    public double buildingWidth;
    public String buildingColor;
    public static double FLOOR_HEIGHT = 0.06;

    /**
     * Constructor which as the new instance forms, the building fills its attributes
     *
     * @param floorCount    integer number of floor count
     * @param centerX       double number of center
     * @param buildingWidth double building's width
     * @param buildingColor String building's color
     */

    public Building(int floorCount, double centerX, double buildingWidth, String buildingColor) {
        this.floorCount = floorCount;
        this.centerX = centerX;
        this.buildingWidth = buildingWidth;
        this.buildingColor = buildingColor;
    }

    /**
     * This method displays buildings to the screen.
     */

    public void drawBuilding() {

        double centerY = FLOOR_HEIGHT / 2; //calculates center for y coordinate

        switch (buildingColor) { //adjusts the color according to the String building color
            case "Red":
                StdDraw.setPenColor(StdDraw.RED);
                break;
            case "Yellow":
                StdDraw.setPenColor(StdDraw.YELLOW);
                break;
            case "Orange":
                StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
                break;
            case "Blue":
                StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                break;
            case "Green":
                StdDraw.setPenColor(StdDraw.GREEN);
                break;
            case "Pink":
                StdDraw.setPenColor(StdDraw.PINK);
                break;
            default:
                StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        }

        //Draws rectangles for buildings
        for (int i = 0; i < floorCount; i++) {
            StdDraw.filledRectangle(centerX, centerY, buildingWidth / 2, FLOOR_HEIGHT / 2);
            centerY += FLOOR_HEIGHT; //Each time increases the centerY
        }

        //returns centerY to its initial state.
        centerY = FLOOR_HEIGHT / 2;

        //Draws rectangles that indicate multiples
        for (int j = 0; j < floorCount; j++) {
            StdDraw.setPenRadius(0.003);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.rectangle(centerX, centerY, buildingWidth / 2, FLOOR_HEIGHT / 2);
            centerY += FLOOR_HEIGHT; //It increases the centerY

        }


        double[] x = {centerX - buildingWidth / 2, centerX + buildingWidth / 2, centerX}; //array which has x coordinates
        centerY -= FLOOR_HEIGHT / 2; //ensures that the Y axis is at the top of the building
        double[] y = {centerY, centerY, centerY + FLOOR_HEIGHT / 2}; //array which has y coordinates
        StdDraw.setPenColor(StdDraw.BOOK_RED); //set color as red
        StdDraw.filledPolygon(x, y); //draws triangle

        double[] xx = {centerX - buildingWidth / 2, centerX + buildingWidth / 2, centerX};
        double[] yy = {centerY, centerY, centerY + FLOOR_HEIGHT / 2};
        StdDraw.setPenRadius(0.003); //set pen
        StdDraw.setPenColor(StdDraw.BLACK); //set color as black
        StdDraw.polygon(xx, yy);  //draws triangle


    }
}
