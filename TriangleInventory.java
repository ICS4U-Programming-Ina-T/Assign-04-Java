import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Triangle program implements an application that
 * uses a recursive function to print an hourglass pattern
 * of asterisks based on the number entered by the user.
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
    private static final String CAR_RETURN = "\n";

    /**
     * Main entry into the program.
     *
     * @param args nothing passed in
     */
    public static void main(String[] args) {
        // declaring variables
        List<String> listOfSides = new ArrayList<String>();
        String[] lengthsArrayFile;
        BufferedWriter writer;
        StringBuilder builder = new StringBuilder();

        // reads contents of file into list
        try {
            listOfSides = Files.readAllLines(Paths.get("input.txt"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        lengthsArrayFile = listOfSides.toArray(new String[0]);

        try {
            // calls function and passes each element in the array
            for (int loopCounter = 0; loopCounter
                < lengthsArrayFile.length; loopCounter++) {
                List<String> tempList = new ArrayList<String>(Arrays.asList(
                    lengthsArrayFile[loopCounter].split(" ")));

                for (int i = 0; i < tempList.size(); i++) {
                    Double.parseDouble(tempList.toArray(new String[0])[i]);
                }

                Triangle myTriangle =
                    new Triangle(Double.parseDouble(
                        tempList.get(0)), Double.parseDouble(
                            tempList.get(1)), Double.parseDouble(
                                tempList.get(2)));

                // check if triangle is valid
                if (myTriangle.isTriangleValid()) {
                    // declaring triangle number
                    int triangleNum = loopCounter + 1;

                    // adds triangle information to the output file
                    builder.append("Triangle " + triangleNum + ":\n");
                    builder.append("The side lengths of this triangle are "
                        + tempList.get(0) + "ft, "
                        + tempList.get(1) + "ft, and "
                        + tempList.get(2) + "ft.\n" + "The height is "
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
                        new BufferedWriter(new FileWriter(
                            "/home/ubuntu/environment"
                            + "/Assign/Assign-04/Assign-04"
                            + "-Java/output.txt"));
                    writer.write(builder.toString());

                    builder.append("\n\n");
                    writer.close();
                } else {
                    // declaring triangle number
                    int triangleNum = loopCounter + 1;

                    // adds triangle information to the output file
                    builder.append("Triangle " + triangleNum + ":\n");
                    builder.append("The side lengths of this triangle are "
                        + tempList.get(0) + "ft, "
                        + tempList.get(1) + "ft, and "
                        + tempList.get(2) + "ft");
                    builder.append("\nIt is not valid.");

                    writer =
                        new BufferedWriter(new FileWriter(
                            "/home/ubuntu/environment"
                            + "/Assign/Assign-04/Assign-04"
                            + "-Java/output.txt"));
                    writer.write(builder.toString());

                    builder.append(CAR_RETURN + CAR_RETURN);
                    writer.close();
                }
            }

            // alerts user triangle info is done being calculated
            System.out.println("Done triangle calaculations."
                + " Look below and check the output file.");
            System.out.println(CONSOLE_SEPARATOR);

            System.out.println(CONSOLE_SEPARATOR);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
