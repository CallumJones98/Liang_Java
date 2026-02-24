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

        // Run BMI program
        bmiSystem bmi_system_program = new bmiSystem();
        bmi_system_program.calculateBmi(three_scanner);

        // ISBN system program
        isbnSystem isbn_program = new isbnSystem();
        isbn_program.calculateISBN(three_scanner);

        // Rock paper scissors game
        rockPaperScissors rock_paper_scissors = new rockPaperScissors();
        rock_paper_scissors.playGame(three_scanner, three_random);

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


class bmiSystem{

    public void calculateBmi(Scanner three_scanner){
        // BMI = weight(kg) / height (metres^2);
        // Allow user to enter weight in pounds and height in feet and inches
        // kg_weight = lbs * 0.45359237
        // metres_height = (feet * 0.3048) + (inches * 0.0254)

        System.out.println("\nBMI Program:");

        System.out.print("Enter your weight (lbs): ");
        double weight_lbs = three_scanner.nextDouble();
        double weight_kg = weight_lbs * 0.45359237;

        System.out.print("Enter your height in feet: ");
        double height_feet = three_scanner.nextDouble();
        System.out.print("Enter inches: ");
        double height_inches = three_scanner.nextDouble();
        double height_metres = (height_feet * 0.3048) + (height_inches * 0.0254);

        double BMI = weight_kg / Math.pow(height_metres, 2);

        String weight_classification;

        if (BMI <= 18.5){
            weight_classification = "Underweight";
        }
        else if (BMI <= 24.9){
            weight_classification = "Normal weight";
        }
        else if (BMI <= 29.9){
            weight_classification = "Overweight";
        }
        else{
            weight_classification = "Obese";
        }

        System.out.printf("Your BMI is %.2f, your classification is that you are %s", BMI, weight_classification);

    }
}

class isbnSystem{

    public void calculateISBN(Scanner three_scanner){

        // Check ISBN
        // Take first 12 digits

        System.out.print("\nCheck ISBN:");

        System.out.print("\nEnter the ISBN: ");
        long isbn = three_scanner.nextLong();

        int[] digits = new int [13];

        for (int i = 12; i >= 0; i--) {
            digits[i] = (int) (isbn % 10);
            isbn /= 10;
        }

        // digits[0] to digits[11] are the data digits to check
        // digits[12] is the checksum to check against

        int check_sum_part_one = (digits[0]) + (digits[1] * 3) + (digits[2]) + (digits[3] * 3) + (digits[4]) + (digits[5] * 3) + (digits[6]) + (digits[7] * 3) + (digits[8]) + (digits[9] * 3) + (digits[10]) + (digits[11] * 3);
        int check_sum_part_two = check_sum_part_one % 10;
        int check_sum_final = 10 - check_sum_part_two;

        if (check_sum_final == 10){
            check_sum_final = 0;
        }

        boolean check_sum_status = false;

        if (check_sum_final == digits[12]){
            check_sum_status = true;
        }

        System.out.printf("The check sum is %b", check_sum_status);

    }

}


class rockPaperScissors{

    public void playGame(Scanner three_scanner, Random three_random){

        // Game that counts the score
        // Play until user enters 0

        System.out.print("\nRock Paper Scissors game!");

        System.out.print("\nEnter 0 (quit), 1 (play), 2 (display score): ");
        int user_control = three_scanner.nextInt();

        int user_score = 0;
        int computer_score = 0;

        String winner_statement = "you win this round!";
        String loser_statement = "you lose this round!";


        while (user_control != 0){

            if (user_control == 1){

                // Game choice
                char[] game_letters = {'R', 'P', 'S'};
                int idx = three_random.nextInt(game_letters.length);
                char computer_attempt = game_letters[idx];

                // User choice
                System.out.print("Rock (R), Paper(P), Scissors(S): ");
                char user_game_attempt = three_scanner.next().charAt(0);

                if (computer_attempt == 'R' && user_game_attempt != 'R'){
                    if (user_game_attempt == 'S'){
                        computer_score += 1;
                        System.out.printf("The computer chose %c, %s \n", computer_attempt, loser_statement);
                    }
                    else if (user_game_attempt == 'P'){
                        user_score += 1;
                        System.out.printf("The computer chose %c, %s \n", computer_attempt, winner_statement);
                    }
                }
                else if (computer_attempt == 'P' && user_game_attempt != 'P'){
                    if (user_game_attempt == 'S'){
                        user_score += 1;
                        System.out.printf("The computer chose %c, %s \n", computer_attempt, winner_statement);
                    }
                    else if (user_game_attempt == 'R'){
                        computer_score += 1;
                        System.out.printf("The computer chose %c, %s \n", computer_attempt, loser_statement);
                    }
                }
                else if (computer_attempt == 'S' && user_game_attempt != 'S') {
                    if (user_game_attempt == 'R') {
                        user_score += 1;
                        System.out.printf("The computer chose %c, %s \n", computer_attempt, winner_statement);

                    }
                    else if (user_game_attempt == 'P') {
                        computer_score += 1;
                        System.out.printf("The computer chose %c, %s \n", computer_attempt, loser_statement);
                    }
                }
                else {
                    System.out.printf("You both chose %c \n", user_game_attempt);
                }
            }
            else if (user_control == 2){
                System.out.printf("Your score is %d \n", user_score);
                System.out.printf("Computer score is %d \n", computer_score);
            }

            System.out.print("Enter 0 (quit), 1 (play), 2 (display score): ");
            user_control = three_scanner.nextInt();

        }

    }
}

