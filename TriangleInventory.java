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
     * Constant for invalid string.
     */
    private static final String INVALID_STRING = "Value cannot be accepted.\n";
    /**
     * Constant for negative numbers.
     */
    private static final String NEGATIVE_NUM = "Number must be greater than 0.\n";
    
    /**
     * Empty constructor.
     */
    public TriangleInventory() { }
    
    /**
     * Main entry into the program.
     *
     * @param args nothings passed in
     */
    public static void main(String[] args) {
        // create a triangle
        Triangle myTriangle;
        
        // declaring variables
        final Scanner sc = new Scanner(System.in);
        String sideAString;
        String sideBString;
        String sideCString;
        int sideAInt = 0;
        int sideBInt = 0;
        int sideCInt = 0;
        
        while (sideAInt <= 0) {
            // asks user for first side length
            System.out.println("Enter a number for side length A: ");
            sideAString = sc.nextLine();
            
            try {
                sideAInt = Integer.parseInt(sideAString);
                
                if (sideAInt <= 0) {
                    System.out.println(NEGATIVE_NUM);
                    continue;
                }

                while (sideBInt <= 0) {
                    // asks user for second side length
                    System.out.println("Enter a number for side length B: ");
                    sideBString = sc.nextLine();
                    
                    try {
                        sideBInt = Integer.parseInt(sideBString);
                        
                        if (sideBInt <= 0) {
                            System.out.println(NEGATIVE_NUM);
                            continue;
                        }

                        while (sideCInt <= 0) {
                            // asks user for third side length
                            System.out.println("Enter a number for side length C: ");
                            sideCString = sc.nextLine();

                            try {
                                sideCInt = Integer.parseInt(sideCString);
                                
                                if (sideCInt <= 0) {
                                    System.out.println(NEGATIVE_NUM);
                                    continue;
                                }

                                // INSERT REMAINING CODE HERE!!
                                myTriangle = new Triangle(sideA, sideB, sideC);
                                
                                // check if triangle is valid
                                myTriangle.isTriangleValid();

                                if (myTriangle.isTriangleValid == true) {
                                    myTriangle.calcArea();
                                    myTriangle.calcPer();
                                } else {
                                    System.out.print("Triangle is not valid.");
                                }

                            } catch (IllegalArgumentException exception) {
                                System.out.print(INVALID_STRING);
                            }
                        }

                    } catch (IllegalArgumentException exception) {
                        System.out.print(INVALID_STRING);
                    }
                }

            } catch (IllegalArgumentException exception) {
                System.out.print(INVALID_STRING);
            }
        }
    }
}