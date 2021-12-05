/*
 *  Assignment, BMI Calculator
 *  Description: Calculate BMI based on lowest weight, highest weight and height.
 *  Name: Rick
 *  Semester: Fall 2021
 */

import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {

        // Declare variables and Scanner object
        double poundsLow;
        double poundsHigh;
        double heightInches;
        double heightFeet;
        double expandedInches;
        Scanner input = new Scanner(System.in);

        // Display prompts and process input of weight and height
        System.out.print("Enter the low weight in pounds: ");
        poundsLow = input.nextDouble();
        System.out.print("Enter the high weight in pounds: ");
        poundsHigh = input.nextDouble();
        System.out.print("Enter height in feet and inches: ");
        heightFeet = input.nextDouble();
        heightInches = input.nextDouble();
        System.out.println();

        // Convert feet to inches to get total inches
        expandedInches = heightFeet * 12;
        heightInches = heightInches + expandedInches;


        // Call calculateBMI() method to display BMI results
        calculateBMI(poundsLow, poundsHigh, heightInches);

    }

    // Method to display BMI results based on minPounds, maxPounds and inches
    public static void calculateBMI(double minPounds, double maxPounds, double inches) {


        // Declare variables
        double inchessquared;
        double minBMI = 0;
        double maxBMI = 0;

        // Initialize part of BMI calculation
        inchessquared = inches * inches;

        // Display top of chart
        System.out.println("Weight        BMI       Category");

        // Loop through the minPounds and maxPounds by 5, calculating BMI for each
        for(int count = (int) minPounds; count <= maxPounds; count+=5) {

            double bmiAmount;

            // Calculate BMI for current weight in for loop
            bmiAmount = count/inchessquared;
            bmiAmount = bmiAmount * 703;
            // Set result to 1 decimal place
            bmiAmount = Math.round(bmiAmount * 10.0) / 10.0;

            // Save values of minBMI and maxBMI for method : averageBMI()
            if (count == (int) minPounds)
                minBMI = bmiAmount;
            if (count == (int) maxPounds)
                maxBMI = bmiAmount;

            // Display calculated BMI
            System.out.print(count + "           " + bmiAmount + "      ");

            // Based on BMI, display text for "Category" column by calling textBMI()
            if(bmiAmount <= 18.5 ) {
                System.out.println(textBMI(18.5));
            }
            else if(bmiAmount <= 24.9 ) {
                System.out.println(textBMI(24.9));
            }
            else if(bmiAmount <= 29.9 ) {
                System.out.println(textBMI(29.9));
            }
            else if(bmiAmount >= 30 ) {
                System.out.println(textBMI(30));
            }

        }

        // Call averageBMI() method to get the average
        double resultAvg = averageBMI(minBMI, maxBMI);
        System.out.println();

        // Set results to 1 decimal place
        resultAvg = Math.round(resultAvg * 10.0) / 10.0;
        // Display the result of averageBMI() and call method textBMI() to covert it to category
        System.out.println("** The average BMI is " + resultAvg + " - " + textBMI(resultAvg) + ".");
    }

    // Method to calculate average BMI and return it
    public static double averageBMI(double low, double high){
        // Declare variables
        double avg;
        double total = low + high;

        // Calculate average
        avg = total / 2;

        // Return average
        return avg;

    }

    // Method to convert numeric BMI to its text category and return it
    public static String textBMI(double digitBMI){

        // Declare variable
        String resultBMI = "";

        // Convert numeric BMI into text category
        if(digitBMI <= 18.5 ) {
            resultBMI = "Under Weight";
        }
        else if(digitBMI <= 24.9 ) {
            resultBMI = "Normal Weight";
        }
        else if(digitBMI <= 29.9 ) {
            resultBMI = "Over Weight";
        }
        else if(digitBMI >= 30 ) {
            resultBMI = "Obesity";
        }

        // Return text result
        return resultBMI;
    }
}
