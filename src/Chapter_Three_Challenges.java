import java.util.Scanner;
import java.util.Random;

public class Chapter_Three_Challenges {

    public static void main(String[] args){

        Scanner three_scanner = new Scanner(System.in);

        Random three_random = new Random();

        // Run Quadratic Equation

        quadraticEquation quadratic_equation_program = new quadraticEquation();
        quadratic_equation_program.runEquation(three_scanner);

        // Run random rainbow colour
        randomRainbowColour random_colour_program = new randomRainbowColour();
        random_colour_program.generateColour(three_random);

    }
}

class quadraticEquation{

    public void runEquation(Scanner three_scanner){

        System.out.print("This is a quadratic equation program!");

        // Solve quadratic equation
        // ax^2 + bx + c
        // root_one = (-b + sqrt(b^2 - 4ac)) / 2a
        // root_two = (-b - sqrt(b^2 - 4ac)) / 2a
        // b^2 is the discriminant of the equation. If it positive, the equation has two roots. If its zero the equation has one root. If it is negative it has zero roots

        // user enter values a, b, c
        System.out.print("\nEnter values a, b, c: ");
        double a = three_scanner.nextDouble();
        double b = three_scanner.nextDouble();
        double c = three_scanner.nextDouble();

        // test discriminant
        double discriminant = (Math.pow(b, 2)) - (4.0 * a * c);
        int roots;
        double discriminant_checker = Math.signum(discriminant);

        if (discriminant_checker > 0){
            roots = 2;
        }
        else if (discriminant_checker == 0){
            roots = 1;
        }
        else{
            roots = 0;
        }

        double root_one = (-b + Math.sqrt(Math.pow(b, 2) - (4.0 * a * c))) / (2.0 * a);
        double root_two = (-b - Math.sqrt(Math.pow(b, 2) - (4.0 * a * c))) / (2.0 * a);

        if (roots == 2){

            System.out.printf("The equation has two roots %.4f and %.4f", root_one, root_two);
        }
        else if (roots == 1){

            System.out.printf("The equation has one root %.4f", root_one);
        }
        else{
            System.out.print("The equation has no roots!");
        }
    }

}

class randomRainbowColour{

    public void generateColour(Random three_random){

        System.out.print("\nRandom colour from the rainbow is about to be chosen!");

        // Generate random num

        int random_num = three_random.nextInt(1, 8);
        String chosen_colour = "No Colour";

        switch (random_num){
            case 1:
                chosen_colour = "Violet";
                break;
            case 2:
                chosen_colour = "Indigo";
                break;
            case 3:
                chosen_colour = "Blue";
                break;
            case 4:
                chosen_colour = "Green";
                break;
            case 5:
                chosen_colour = "Yellow";
                break;
            case 6:
                chosen_colour = "Orange";
                break;
            case 7:
                chosen_colour = "Red";
                break;
        }

        System.out.printf("\nThe random colour of the rainbow is %s!", chosen_colour);

    }
}




