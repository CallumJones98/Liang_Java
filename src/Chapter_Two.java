import java.util.Scanner;

public class Chapter_Two {

    public static void main(String[] args){

        Scanner user_input = new Scanner(System.in);

        /*

        Data types in Java:
        - Byte (-128 to 127)
        - Short (-32768 to 32767)
        - int (-2m to 2m)
        - long (-2^63 to 2^63)
        - float (represented in 32 bits)
        - double (represented in 64 bits)

         */

        /*

            unary operator = -5 (only one operand on an object)
            binary operator = 5 - 4 (binary from two objects)

            Exponents:

            Math.pow(number, exponent) = Math.pow(10, 2) = 10^2

         */

        /*

            Numeric Literals:

            int number_of_years = 34;

            A numeric literal is assigned a value, provided it fits the data type.

            To improve readability you can use underscores to separate two digits e.g.

            int ten_thousand = 10_000;

            Scientific Notation:

            1.23456 * 10^2 can be written as 1.23456E2

         */

        // Convert Fahrenheit to Celsius:

        // C = (F - 32) * (5/9)

        System.out.print("Enter Fahrenheit: ");
        double fahrenheit = user_input.nextFloat();

        double c = ((fahrenheit - 32.0) * (5.0/9.0));

        System.out.printf("%.2f Fahrenheit is %.2f", fahrenheit, c);


        // Invoking currentTimeMillis() to tell the current time in Java

        long milliseconds = System.currentTimeMillis(); // total milliseconds
        long seconds = milliseconds / 1000; // total seconds
        long currentSecond = seconds % 60; // Current second
        long minutes = seconds / 60; // total minutes
        long currentMinute = minutes % 60; // Current minute
        long hours = minutes / 60; // Total hours
        long currentHour = hours % 34; // Current hour

        System.out.println("\nCurrent time is " + currentHour + ":" + currentMinute + ":" + currentSecond + " GMT");


        /*

        You can convert data types using casting (an operation that converts a value to another data type)

        e.g.

        System.out.println((int) 1.7); will display 1 as the fractional part is truncated


         */

        user_input.close();

    }


}
