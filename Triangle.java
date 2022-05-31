import java.util.ArrayList;
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

public class Triangle {
    /**
     * Property for _sideA.
     */
    private _sideA;
    /**
     * Property for _sideB.
     */
    private _sideB;
    /**
     * Property for _sideC.
     */
    private _sideC;

    /**
     * Insert comment
     */
    public Triangle(double sideA, double sideB, double sideC) {
        this._sideA = sideA;
        this._sideB = sideB;
        this._sideC = sideC
    }

    /**
     * Method that determines if triangle is valid.
     */
    protected boolean isTriangleValid() {
        
    }

    /**
     * Method to calculate area
     */
    public double calcArea() {
        
    }

    /**
     * Method to calculate perimeter.
     */
    public double calcPer() {
        
    }

    /**
     * Method that determines the type of triangle inputted, using side lengths.
     */
    public String typeBySide() {
        // declaring variables
        List<Integer> listOfSides = new ArrayList<Integer>();
        
        listOfSides.add(sideA);
        listOfSides.add(sideB);
        listOfSides.add(sideC);
        
        double longestSide = -1;
        String anglesType = "";
        

        // checks which side is the longest
        if (sideA > sideB && sideA > sideC) {
            listOfSides.remove(sideA);
            longestSide = sideA;
        } else if (sideB > sideA && sideB > sideC) {
            listOfSides.remove(sideB);
            longestSide = sideB;
        } else if (sideC > sideA && sideC > sideB) {
            listOfSides.remove(sideC);
            longestSide = sideC;
        }

        if (Math.pow(longestSide, 2) == (Math.pow(listOfSides.get(0), 2) + Math.pow(listOfSides.get(1), 2))) {
            anglesType = "right";
        }
    }

    /**
     * Method that determines the type of triangle inputted, using the angles.
     */
    public String typeByAngle() {
        String sidesType = "";

        // checks if side lengths are equal
        if (sideA == sideB && sideA == sideC) {
            sidesType = "equilateral";
        } else if ((sideA == sideB && sideA != sideC) || (sideA == sideC && sideA != sideB) || (sideB == sideC && sideB != sideA)) {
            sidesType = "isosceles";
        } else {
            sidesType = "scalene";
        }
    }
}
