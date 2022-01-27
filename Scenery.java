import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program finds the two furthest points from the point entered by the user and draws a circle that makes this distance a diameter.
 *
 * @author Ceren YILMAZ
 * @since Date: 17.05.2021
 */
public class Scenery {
    public static void main(String[] args) throws FileNotFoundException {

        String filename = "data1.txt"; // input filename
        ArrayList<Building> buildings = new ArrayList<>(); // store scene elements in array lists
        ArrayList<Tree> trees = new ArrayList<>();
        loadData(filename, buildings, trees); // load scene elements from the input file
        plotScene(buildings, trees); // plot scene elements
    }

    /**
     * This method calls drawBuilding and drawTrees method other classes.
     *
     * @param buildings ArrayList which holds information about the building
     * @param trees     ArrayList which holds information about the tree
     */
    public static void plotScene(ArrayList<Building> buildings, ArrayList<Tree> trees) {
        int canvas_width = 600; // specify canvas width
        int canvas_height = 600; // specify canvas height
        StdDraw.setCanvasSize(canvas_width, canvas_height);
        StdDraw.setXscale(0, 1); // x axis scale is in the range [0,1]
        StdDraw.setYscale(0, 1); // y axis scale is in the range [0,1]


        for (Building building : buildings) { //calls drawBuilding method from Building class
            building.drawBuilding();
        }
        for (Tree tree : trees) { //calls drawTrees method from Tree class
            tree.drawTrees();
        }
    }

    /**
     * This method loads the file and reads each line to retrieve the information
     *
     * @param filename  String name of uploaded file
     * @param buildings ArrayList1, which holds information about the building
     * @param trees     ArrayList2, which holds information about the tree
     * @throws FileNotFoundException
     */

    public static void loadData(String filename, ArrayList<Building> buildings, ArrayList<Tree> trees)
            throws FileNotFoundException {
        File file = new File(filename); //created an instance of the file type

        if (!file.exists()) { // if file is not found, print an error msg and quit
            System.out.println(filename + " can not be found.");
            System.exit(1); // exit the program
        }

        Scanner scanner = new Scanner(file); //Create an instance of the Scanner type and set the file

        while (scanner.hasNextLine()) { //loop continues as long as line exists
            String line = scanner.nextLine(); //scanner  reads nextLine
            String[] details = line.split(";"); //; divides it from where it sees it and keeps it in the array

            if (details[0].equals("Building")) { //if the first element is a "Building", it enters
                Building building = new Building( // creates building instance, sets attribute values with constructor
                        Integer.parseInt(details[1]),
                        Double.parseDouble(details[2]),
                        Double.parseDouble(details[3]),
                        details[4]
                );

                buildings.add(building); //adds building to buildings

            } else if (details[0].equals("Tree")) { //if the first element is a "Tree", it enters
                Tree tree = new Tree(Double.parseDouble(details[1])); //creates building instance, sends second element

                trees.add(tree); // adds tree to trees
            }
        }
        scanner.close();


    }
}
