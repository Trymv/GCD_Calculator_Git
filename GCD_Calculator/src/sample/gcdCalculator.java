package sample;

/**
 * This class will do math to find the greatest common divisor between two numbers where number a >= b.
 *
 * @author TrymV
 * @version 0.1
 */
public class gcdCalculator {
    private StringBuilder lastMathCalculation;

    /**
     * Constructor for the object of the lass gcdCalculator.
     */
    public gcdCalculator() {
        this.lastMathCalculation = new StringBuilder();
    }

    /**
     * This method will do the math A=(am*B+X) -> X=A-(am*B) to find the greatest common divisor between A and B
     * where am = amountOfTimesAGoesUpInB.
     * @param numberA the highest number to find greatest common divisor.
     * @param numberB the lowest number to find greatest common divisor.
     * @return the greatest common divisor between A and B where A >= B.
     */
    public int findGCD(int numberA, int numberB) {
        int numberX;

        //Deletes the last math calculations then making a new.
        this.lastMathCalculation.delete(0, lastMathCalculation.length());
        this.lastMathCalculation.append("gcd(").append(numberA).append(", ").append(numberB).append(")=\n");

        do {
            numberX = numberA-(amountOfTimesAGoesUpInB(numberA, numberB)*numberB);
            this.lastMathCalculation.append(numberA).append("=").append(amountOfTimesAGoesUpInB(numberA, numberB)).append("*")
                    .append(numberB).append("+").append(numberX).append("\n");
            numberA = numberB;
            numberB = numberX;
        } while(numberX != 0);

        return numberA;
    }

    /**
     * Return the last calculations from findGCD function as a string.
     * @return the last calculations from findGCD as a string.
     */
    public String getMathCalculationAsString() {
        return this.lastMathCalculation.toString();
    }

    /**
     * Takes in number A and number B and checks how many times B goes up in A.
     * @param numberA Highest number
     * @param numberB Lowest number to check how many times goes up in A
     * @return Amount of times B goes up in A
     */
    private int amountOfTimesAGoesUpInB(int numberA, int numberB) {
        int amountOfTimes = 0;
        int newNumberB = 0;

        if(numberA >= numberB) {
            while (numberA >= newNumberB) {
                newNumberB = newNumberB + numberB;
                amountOfTimes++;
            }
            amountOfTimes--;
        }
        return amountOfTimes;
    }
}
