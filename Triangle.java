import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * The Triangle program implements an application that
 * uses calculates various characteristics of a triangle
 * including the area, perimeter, height, etc.
 *
 * @author  Ina Tolo
 * @version 1.0
 * @since   2022-5-27
 */

public class Triangle {
    /**
     * Declaring constant for ANGLE_SUM.
     */
    private static final double ANGLE_SUM = 180;
    /**
     * Property for _sideA.
     */
    private double _sideA;
    /**
     * Property for _sideB.
     */
    private double _sideB;
    /**
     * Property for _sideC.
     */
    private double _sideC;

    /**
     * Default constructor for class.
     *
     * @param sideA passed in
     * @param sideB passed in
     * @param sideC passed in
     */
    public Triangle(double sideA, double sideB, double sideC) {
        // referencing values in triangle object
        this._sideA = sideA;
        this._sideB = sideB;
        this._sideC = sideC;
    }

    /**
     * Method that determines if triangle is valid.
     *
     * @return valid to main function
     */
    protected boolean isTriangleValid() {
        // declaring valid variable
        final boolean valid;

        // checks if sums of side lengths can create a triangle
        if (_sideA + _sideB > _sideC
            && _sideB + _sideC > _sideA
            && _sideC + _sideA > _sideB) {
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }

    /**
     * Method to calculate area.
     *
     * @return finalArea to main function
     */
    public double calcArea() {
        // calculates the semiperimeter
        final double semiP = (_sideA + _sideB + _sideC) / 2;

        final double area =
            Math.sqrt(semiP * (semiP - _sideA)
                * (semiP - _sideB) * (semiP - _sideC));

        // rounds area to two decimals
        /* Code from: https://mkyong.com/java/how-to
        -round-double-float-value-to-2-decimal-points-in-java/*/
        final BigDecimal roundedArea =
            new BigDecimal(area).setScale(2, RoundingMode.HALF_UP);

        final double finalArea = roundedArea.doubleValue();

        return finalArea;
    }

    /**
     * Method to calculate perimeter.
     *
     * @return finalPer to main function
     */
    public double calcPer() {
        // adds up all sides
        final double perimeter = _sideA + _sideB + _sideC;

        // rounds perimeter to two decimals
        final BigDecimal roundedPer =
            new BigDecimal(perimeter).setScale(2, RoundingMode.HALF_UP);

        final double finalPer = roundedPer.doubleValue();

        return finalPer;
    }

    /**
     * Method that determines the type of angle.
     *
     * @return anglesType to main function
     */
    public String typeBySide() {
        // declaring variables
        final List<Double> listOfSides = new ArrayList<Double>();
        double longestSide = -1;
        String anglesType = "";

        // adds each side length to list
        listOfSides.add(_sideA);
        listOfSides.add(_sideB);
        listOfSides.add(_sideC);

        // checks which side is the longest
        if (_sideA > _sideB && _sideA > _sideC) {
            listOfSides.remove(_sideA);
            longestSide = _sideA;
        } else if (_sideB > _sideA && _sideB > _sideC) {
            listOfSides.remove(_sideB);
            longestSide = _sideB;
        } else if (_sideC > _sideA && _sideC > _sideB) {
            listOfSides.remove(_sideC);
            longestSide = _sideC;
        }

        // checks angle type
        if (Math.pow(longestSide, 2) == (Math.pow(listOfSides.get(0), 2)
            + Math.pow(listOfSides.get(1), 2))) {
            anglesType = "right";
        } else if (Math.pow(longestSide, 2) < (Math.pow(listOfSides.get(0), 2)
            + Math.pow(listOfSides.get(1), 2))) {
            anglesType = "acute";
        } else if (Math.pow(longestSide, 2) > (Math.pow(listOfSides.get(0), 2)
            + Math.pow(listOfSides.get(1), 2))) {
            anglesType = "obtuse";
        }

        return anglesType;
    }

    /**
     * Method that determines the type of triangle inputted, using the angles.
     *
     * @return sidesType to main function
     */
    public String typeByAngle() {
        String sidesType = "";

        // checks if side lengths are equal
        if (_sideA == _sideB && _sideA == _sideC) {
            sidesType = "equilateral";
        } else if (_sideA == _sideB && _sideA != _sideC
            || _sideA == _sideC && _sideA != _sideB
            || _sideB == _sideC && _sideB != _sideA) {
            sidesType = "isosceles";
        } else {
            sidesType = "scalene";
        }

        return sidesType;
    }

    /**
     * Method that determines each angle in triangle.
     *
     * @return listOfAngles to main function
     */
    public List<Double> triangleAngle() {
        // declaring variables
        final List<Double> listOfAngles = new ArrayList<Double>();
        final double aStepOne;
        final double bStepOne;
        final double cStepOne;
        final double aStepTwo;
        final double bStepTwo;
        final double angleA;
        final double angleB;
        final double angleC;

        // calculating angle A
        aStepOne = ((Math.pow(_sideB, 2)
            + Math.pow(_sideC, 2))
            - Math.pow(_sideA, 2)) / (2 * (_sideB * _sideC));
        aStepTwo = Math.toDegrees(Math.acos(aStepOne));
        final BigDecimal aStepThree =
            new BigDecimal(aStepTwo).setScale(2, RoundingMode.HALF_UP);
        angleA = aStepThree.doubleValue();

        // calculating angle B
        bStepOne = ((Math.pow(_sideC, 2)
            + Math.pow(_sideA, 2))
            - Math.pow(_sideB, 2)) / (2 * (_sideC * _sideA));
        bStepTwo = Math.toDegrees(Math.acos(bStepOne));
        final BigDecimal bStepThree =
            new BigDecimal(bStepTwo).setScale(2, RoundingMode.HALF_UP);
        angleB = bStepThree.doubleValue();

        // calculating angle C
        cStepOne = ANGLE_SUM - (angleA + angleB);
        final BigDecimal cStepTwo =
            new BigDecimal(cStepOne).setScale(2, RoundingMode.HALF_UP);
        angleC = cStepTwo.doubleValue();

        // adds each angle to a list
        listOfAngles.add(angleA);
        listOfAngles.add(angleB);
        listOfAngles.add(angleC);

        return listOfAngles;
    }

    /**
     * Method that calculates the height of a triangle.
     *
     * @return finalHeight to main function
     */
    public double calcHeight() {
        // calculates semiperimeter
        final double semiP = (_sideA + _sideB + _sideC) / 2;

        // calculates area
        final double area =
            Math.sqrt(semiP * (semiP - _sideA)
                * (semiP - _sideB) * (semiP - _sideC));

        // rounds area to two decimals
        /* https://mkyong.com/java/how-to-round
        -double-float-value-to-2-decimal-points-in-java/*/
        final BigDecimal roundedArea =
            new BigDecimal(area).setScale(2, RoundingMode.HALF_UP);

        final double finalArea = roundedArea.doubleValue();

        // calculates height
        final double height = 2 * (finalArea / _sideA);

        // rounds height to two decimal places
        final BigDecimal roundedHeight =
            new BigDecimal(height).setScale(2, RoundingMode.HALF_UP);

        final double finalHeight = roundedHeight.doubleValue();

        return finalHeight;
    }
}
