import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The TriangleInventory program implements an application
 * that reads side lengths from a file, then calls a
 * separate class to calculate various characteristics.
 *
 * @author  Ina Tolo
 * @version 1.0
 * @since   2022-5-27
 */

public class TriangleInventory {
    /**
     * Declaring constant for console formatting.
     */
    private static final String CONSOLE_SEPARATOR =
        "--------------------------";
    /**
     * Declaring constant for carriage return.
     */
    private static final String CAR_RETURNS = "\n\n";
    /**
     * Declaring constant for OUTPUT_FILE.
     */
    private static final String OUTPUT_FILE = "/home/ubuntu/environment"
        + "/Assign/Assign-04/Assign-04"
        + "-Java/output.txt";
    /**
     * Declaring constant for the word triangle.
     */
    private static final String TRIANGLE = "Triangle ";

    /**
     * Main entry into the program.
     *
     * @param args nothing passed in
     */
    public static void main(String[] args) {
        // declaring variables
        List<String> listOfSides = new ArrayList<String>();
        final String[] lengthsArrayFile;
        BufferedWriter writer;
        final StringBuilder builder = new StringBuilder();

        // reads contents of file into list
        try {
            listOfSides = Files.readAllLines(Paths.get("input.txt"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        lengthsArrayFile = listOfSides.toArray(new String[0]);

        try {
            // alerts user triangle info is done being calculated
            System.out.println("Done triangle calculations."
                + " Look below and check the output file.");
            System.out.println(CONSOLE_SEPARATOR + "\n");

            // calls function and passes each element in the array
            for (int loopCounter = 0; loopCounter
                < lengthsArrayFile.length; loopCounter++) {
                final List<String> tempList =
                    new ArrayList<String>(Arrays.asList(
                    lengthsArrayFile[loopCounter].split(" ")));

                for (int i = 0; i < tempList.size(); i++) {
                    Double.parseDouble(tempList.toArray(new String[0])[i]);
                }

                final Triangle myTriangle =
                    new Triangle(Double.parseDouble(
                        tempList.get(0)), Double.parseDouble(
                            tempList.get(1)), Double.parseDouble(
                                tempList.get(2)));

                // check if triangle is valid
                if (myTriangle.isTriangleValid()) {
                    // declaring triangle number
                    final int triangleNum = loopCounter + 1;

                    // displays results to console
                    System.out.println(TRIANGLE + triangleNum + ":\n"
                        + "The side lengths of this triangle are "
                        + tempList.get(0) + " ft, "
                        + tempList.get(1) + " ft, and "
                        + tempList.get(2) + " ft.\n" + "The height is "
                        + myTriangle.calcHeight() + " ft.\n"
                        + "It has an area of "
                        + myTriangle.calcArea() + " ft^2 and a perimeter of "
                        + myTriangle.calcPer() + " ft.\nIt is "
                        + myTriangle.typeByAngle() + " with a "
                        + myTriangle.typeBySide() + " angle.\nThe angle"
                        + " between sides a and b is "
                        + myTriangle.triangleAngle().get(2) + " degrees.\n"
                        + "The angle between sides a and c is "
                        + myTriangle.triangleAngle().get(1) + " degrees.\n"
                        + "The angle between sides b and c is "
                        + myTriangle.triangleAngle().get(0) + " degrees.\n");

                    // adds triangle information to the output file
                    builder.append(TRIANGLE + triangleNum + ":\n");
                    builder.append("The side lengths of this triangle are "
                        + tempList.get(0) + " ft, "
                        + tempList.get(1) + " ft, and "
                        + tempList.get(2) + " ft.\n" + "The height is "
                        + myTriangle.calcHeight() + " ft.\n"
                        + "It has an area of "
                        + myTriangle.calcArea() + " ft^2 and a perimeter of "
                        + myTriangle.calcPer() + " ft.\nIt is "
                        + myTriangle.typeByAngle() + " with a "
                        + myTriangle.typeBySide() + " angle.\nThe angle"
                        + " between sides a and b is "
                        + myTriangle.triangleAngle().get(2) + " degrees.\n"
                        + "The angle between sides a and c is "
                        + myTriangle.triangleAngle().get(1) + " degrees.\n"
                        + "The angle between sides b and c is "
                        + myTriangle.triangleAngle().get(0) + " degrees.");

                    writer =
                        new BufferedWriter(new FileWriter(OUTPUT_FILE));
                    writer.write(builder.toString());

                    builder.append(CAR_RETURNS);
                    writer.close();
                } else {
                    // declaring triangle number
                    final int triangleNum = loopCounter + 1;

                    // displays results to console
                    System.out.println(TRIANGLE + triangleNum + ":\n"
                        + "The side lengths of this triangle are "
                        + tempList.get(0) + " ft, "
                        + tempList.get(1) + " ft, and "
                        + tempList.get(2) + " ft.\n" + "It is not valid.\n");

                    // adds triangle information to the output file
                    builder.append(TRIANGLE + triangleNum + ":\n");
                    builder.append("The side lengths of this triangle are "
                        + tempList.get(0) + " ft, "
                        + tempList.get(1) + " ft, and "
                        + tempList.get(2) + " ft");
                    builder.append("\nIt is not valid.");

                    writer =
                        new BufferedWriter(new FileWriter(OUTPUT_FILE));
                    writer.write(builder.toString());

                    builder.append(CAR_RETURNS);
                    writer.close();
                }
            }
            System.out.println(CONSOLE_SEPARATOR);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
