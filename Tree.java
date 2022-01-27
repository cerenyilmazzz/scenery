/**
 * This class storing information about the tree
 */

public class Tree {
    public double centerX;
    public static double TREE_BODY_HEIGHT = 0.08;
    public static double TREE_BODY_WIDTH = 0.02;
    public static double TREE_RADIUS = 0.04;

    /**
     * Constructor which as the new instance forms, the trees fills its attributes
     *
     * @param centerX double number of center
     */
    public Tree(double centerX) {
        this.centerX = centerX;
    }

    /**
     * This method displays  tree to the screen.
     */
    public void drawTrees() {
        double centerYRec = TREE_BODY_HEIGHT / 2;
        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.filledRectangle(centerX, centerYRec, TREE_BODY_WIDTH / 2, TREE_BODY_HEIGHT / 2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.003);
        StdDraw.rectangle(centerX, centerYRec, TREE_BODY_WIDTH / 2, TREE_BODY_HEIGHT / 2);

        double centerYCircle = TREE_BODY_HEIGHT + TREE_RADIUS;
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(centerX, centerYCircle, TREE_RADIUS);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.003);
        StdDraw.circle(centerX, centerYCircle, TREE_RADIUS);


    }
}
