import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        // program to calculate the area of a circle
        // Area = pi * radius^2

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the radius: ");
        double radius = input.nextDouble();

        double area = Math.PI * (Math.pow(radius, 2));

        System.out.printf("The area of the circle is: %.2f", area);


        /*

        You can use names constants, which represents data that never changes by calling final

        final double PI_VALUE = 3.14159;

         */

        final double PI_VALUE = 3.14159; // final is a constant (always all capitals)

        input.close();
    }

}
