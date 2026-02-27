import java.util.Scanner;

public class Chapter_Four_Challenges {

    public static void main(String[] args){

        // Scanner class
        Scanner input = new Scanner(System.in);

        // Fill in exercises

        // Pentagon Area Program
        pentagonGeometry pentagon_area_program = new pentagonGeometry();
        pentagon_area_program.computeArea(input);

        // Great Circle Distance Program
        greatCircle great_circle_distance_program = new greatCircle();
        great_circle_distance_program.calculateDistance(input);

        // Area Star Program
        areaOfStar area_of_star_program = new areaOfStar();
        area_of_star_program.calculateArea(input);

        // Unicode Char Program
        findUnicodeChar ascii_char_program = new findUnicodeChar();
        ascii_char_program.findUnicode(input);

        // Hard reset before binary program
        input.nextLine();

        // Binary to Decimal Program
        binaryToDecimal binary_to_decimal_program = new binaryToDecimal();
        binary_to_decimal_program.convertBinary(input);

        // Consonant or Vowel Program
        consonantOrVowel consonant_or_vowel_program = new consonantOrVowel();
        consonant_or_vowel_program.checkChar(input);

        // Hard reset before string contains program
        input.nextLine();

        // Substring Program
        testSubstring test_substring_program = new testSubstring();
        test_substring_program.checkSubstring(input);

        // Loyalty Card Program
        loyaltyCardDiscount loyalty_discount_program = new loyaltyCardDiscount();
        loyalty_discount_program.calculateDiscount(input);

    }
}

class pentagonGeometry{

    public void computeArea(Scanner input){

        System.out.print("Pentagon Area Program: ");

        // User enters the length from the center of the pentagon to a vertex
        System.out.print("\nEnter the length from the center to a vertex: ");
        double r = input.nextDouble();

        // Calculate side of pentagon
        double side = (2 * r * Math.sin(Math.PI / 5));

        // Calculate area
        double area = (5 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 5));

        // Output
        System.out.printf("The area of the pentagon is: %.2f", area);
    }
}

// Geometry: great circle distance

class greatCircle{

    public void calculateDistance(Scanner input){

        System.out.print("\n\nGreat Circle Distance Program: ");
        // Distance is the distance between two points on the surface of a sphere
        // (x1, y1) and (x2, y2) be the geographical latitude and longitude of two points
        // d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))

        // Point 1:
        System.out.print("\nEnter point 1 (latitude and longitude) in degrees: ");
        double x1_val = input.nextDouble();
        double y1_val = input.nextDouble();

        // Point 2:
        System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
        double x2_val = input.nextDouble();
        double y2_val = input.nextDouble();

        // Convert all points to radians
        double x1 = Math.toRadians(x1_val);
        double y1 = Math.toRadians(y1_val);
        double x2 = Math.toRadians(x2_val);
        double y2 = Math.toRadians(y2_val);

        // Earth radius
        double radius = 6371.01;

        // calculate distance
        double d = radius * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

        System.out.printf("The distance between the two points is %.5f km", d);

    }
}

class areaOfStar{
    public void calculateArea(Scanner input){

        System.out.print("\n\nArea of Five-pointed Star Program: ");
        // Calculate the area of a five-pointed star
        // area = 10 * ((tan(pi / 10)) / (3 - tan(pi/10) * tan(pi/10))) * pow(r,2)

        // Enter radius
        System.out.print("\nEnter the radius of the circle inscribing the star: ");
        double star_radius = input.nextDouble();

        // calculate area
        double star_area = 10.0 * ((Math.tan(Math.PI/10)) / (3 - Math.tan(Math.PI/10) * Math.tan(Math.PI/10))) * Math.pow(star_radius, 2);

        System.out.printf("The area of the star is %.5f", star_area);

    }

}

class findUnicodeChar{
    public void findUnicode(Scanner input){

        System.out.print("\n\nReturn ASCII Code Character Program: ");

        // Enter char
        System.out.print("\nEnter a character: ");
        char ch = input.next().charAt(0);

        // Unicode
        int unicode_ch = (int)ch;

        System.out.printf("The ASCII code for character %c is %d", ch, unicode_ch);

    }
}

class binaryToDecimal{
    public void convertBinary(Scanner input){

        System.out.print("\n\nConvert Binary Number to Decimal Number Program: ");

        // Enter binary number:
        System.out.print("\nEnter binary digits (0000 to 1111): ");
        String binary_string = input.nextLine();

        // Convert binary to decimal
        int decimal_value = Integer.parseInt(binary_string, 2);

        System.out.print("\nThe decimal value is " + decimal_value);

    }

}

class consonantOrVowel{
    public void checkChar(Scanner input){

        System.out.print("\n\nCheck Character Program: ");

        // get char
        System.out.print("\nEnter a letter: ");
        char input_letter = input.next().charAt(0);

        // return_val
        String char_return = "invalid input";

        if (Character.isLetter(input_letter)){
            // Pass if true - check vowel else consonant
            if (input_letter == 'A' || input_letter == 'a'
            || input_letter == 'E' || input_letter == 'e'
            || input_letter == 'I' || input_letter == 'i'
            || input_letter == 'O' || input_letter == 'o'
            || input_letter == 'U' || input_letter == 'u'){
                char_return = "Vowel";
            }
            else{
                char_return = "Consonant";
            }
        }
        System.out.printf("%c is a %s", input_letter, char_return);
    }
}

class testSubstring{
    public void checkSubstring(Scanner input){

        System.out.print("\n\nCheck Substring Program: ");

        // Enter string 1
        System.out.print("\nEnter String 1: ");
        String string_one = input.nextLine();
        // Enter string 2
        System.out.print("Enter String 2: ");
        String string_two = input.nextLine();

        // Default val
        String string_checked = "is not";

        if (string_one.contains(string_two)){
            string_checked = "is";
        }

        System.out.printf("%s %s prefix of %s", string_two, string_checked, string_one);
    }

}

class loyaltyCardDiscount{
    public void calculateDiscount(Scanner input){

        System.out.print("\n\nLoyalty Program: ");

        // Enter Customer's Name
        System.out.print("\nEnter Customer's Name: ");
        String customer_name = input.nextLine();
        // Number of coffees bought
        System.out.print("Enter the number of coffees bought in total: ");
        double total_coffees_bought = input.nextInt();
        // average coffee price
        System.out.print("Enter average coffee price: ");
        double avg_coffee_price = input.nextDouble();
        // Standard discount rate
        System.out.print("Enter standard discount rate: ");
        double standard_discount_rate = input.nextDouble();
        // Mailing list discount rate
        System.out.print("Enter mailing-list member discount rate: ");
        double mailing_discount_rate = input.nextDouble();

        // Base
        double total_spend = total_coffees_bought * avg_coffee_price;
        double standard_discount_savings = total_spend * standard_discount_rate;
        double mailing_discount_savings = total_spend * mailing_discount_rate;
        double total_saved = standard_discount_savings + mailing_discount_savings;
        double total_spend_after_discount = total_spend - total_saved;


                // return statements
        System.out.printf("\nCustomer Name: %s", customer_name);
        System.out.printf("\nCoffees Bought: %.0f", total_coffees_bought);
        System.out.printf("\nAverage Coffee Price: $%.0f", avg_coffee_price);
        System.out.printf("\nTotal Spending on Coffee: $%.2f", total_spend);
        System.out.print("\nDiscounts: ");
        System.out.printf("\n\tStandard discount (%.2f%%): $%.2f", standard_discount_rate, standard_discount_savings);
        System.out.printf("\n\tMailing list membership discount (%.2f%%): $%.2f", mailing_discount_rate, mailing_discount_savings);
        System.out.printf("\n\tTotal Saved: $%.2f", total_saved);
        System.out.printf("\nTotal spending after discount: $%.2f", total_spend_after_discount);

    }
}