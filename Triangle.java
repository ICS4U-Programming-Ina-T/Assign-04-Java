import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
        boolean valid;

        if ((_sideA + _sideB > _sideC) 
            && (_sideB + _sideC > _sideA)
            && (_sideC + _sideA > _sideB)) {
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
        double semiP = (_sideA + _sideB + _sideC) / 2;

        double area =
            Math.sqrt(semiP * (semiP - _sideA)
                * (semiP - _sideB) * (semiP - _sideC));

        // rounds area to two decimals
        /* https://mkyong.com/java/how-to
        -round-double-float-value-to-2-decimal-points-in-java/*/
        BigDecimal roundedArea =
            new BigDecimal(area).setScale(2, RoundingMode.HALF_UP);

        double finalArea = roundedArea.doubleValue();

        return finalArea;
    }

    /**
     * Method to calculate perimeter.
     *
     * @return finalPer to main function
     */
    public double calcPer() {
        double perimeter = _sideA + _sideB + _sideC;

        // rounds perimeter to two decimals
        BigDecimal roundedPer =
            new BigDecimal(perimeter).setScale(2, RoundingMode.HALF_UP);

        double finalPer = roundedPer.doubleValue();

        return finalPer;
    }

    /**
     * Method that determines the type of angle.
     *
     * @return anglesType to main function
     */
    public String typeBySide() {
        // declaring variables
        List<Double> listOfSides = new ArrayList<Double>();
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
        } else if ((_sideA == _sideB && _sideA != _sideC)
            || (_sideA == _sideC && _sideA != _sideB)
            || (_sideB == _sideC && _sideB != _sideA)) {
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
        List<Double> listOfAngles = new ArrayList<Double>();
        double angleAStepOne;
        double angleBStepOne;
        double angleCStepOne;
        double angleAStepTwo;
        double angleBStepTwo;
        double angleA;
        double angleB;
        double angleC;

        // calculating angle A
        angleAStepOne = ((Math.pow(_sideB, 2)
            + Math.pow(_sideC, 2))
            - Math.pow(_sideA, 2)) / (2 * (_sideB * _sideC));
        angleAStepTwo = Math.toDegrees(Math.acos(angleAStepOne));
        BigDecimal angleAStepThree =
            new BigDecimal(angleAStepTwo).setScale(2, RoundingMode.HALF_UP);
        angleA = angleAStepThree.doubleValue();

        // calculating angle B
        angleBStepOne = ((Math.pow(_sideC, 2)
            + Math.pow(_sideA, 2))
            - Math.pow(_sideB, 2)) / (2 * (_sideC * _sideA));
        angleBStepTwo = Math.toDegrees(Math.acos(angleBStepOne));
        BigDecimal angleBStepThree =
            new BigDecimal(angleBStepTwo).setScale(2, RoundingMode.HALF_UP);
        angleB = angleBStepThree.doubleValue();

        // calculating angle C
        angleCStepOne = 180 - (angleA + angleB);
        BigDecimal angleCStepTwo =
            new BigDecimal(angleCStepOne).setScale(2, RoundingMode.HALF_UP);
        angleC = angleCStepTwo.doubleValue();

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
        double semiP = (_sideA + _sideB + _sideC) / 2;

        double area =
            Math.sqrt(semiP * (semiP - _sideA)
                * (semiP - _sideB) * (semiP - _sideC));

        // rounds area to two decimals
        /* https://mkyong.com/java/how-to-round
        -double-float-value-to-2-decimal-points-in-java/*/
        BigDecimal roundedArea =
            new BigDecimal(area).setScale(2, RoundingMode.HALF_UP);

        double finalArea = roundedArea.doubleValue();

        double height = 2 * (finalArea / _sideA);

        BigDecimal roundedHeight =
            new BigDecimal(height).setScale(2, RoundingMode.HALF_UP);

        double finalHeight = roundedHeight.doubleValue();

        return finalHeight;
    }
}
