import java.util.Scanner;

public class Chapter_Five {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        // Repeat Addition Quiz
        repeatAdditionQuiz repeat_addition_program = new repeatAdditionQuiz();
        repeat_addition_program.createQuiz(input);

        // Guessing Number Game
        guessNumberGame guess_number_program = new guessNumberGame();
        guess_number_program.runGame(input);

        // Sentinel Value Program
        sentinelValue sentinel_value_program = new sentinelValue();
        sentinel_value_program.runClass(input);

    }

}

class repeatAdditionQuiz{

    public void createQuiz(Scanner input){

        System.out.print("Addition Quiz Program!");

        int num_one = (int)(Math.random() * 20) + 1;
        int num_two = (int)(Math.random() * 20) + 1;
        int correct_answer = num_one + num_two;
        int number_of_attempts = 1;

        System.out.printf("\nWhat is %d + %d? ", num_one, num_two);
        int user_answer = input.nextInt();

        while (user_answer != correct_answer){
            number_of_attempts++;
            System.out.printf("Wrong answer. Try again! \nWhat is %d + %d? ", num_one, num_two);
            user_answer = input.nextInt();
        }

        System.out.printf("Correct! You got the answer in %d attempts!", number_of_attempts);

    }
}

class guessNumberGame{

    public void runGame(Scanner input){

        System.out.print("\n\nRandom Number Guessing Game Program!");

        //Random Num
        int random_num = (int)(Math.random() * 100) + 1;

        System.out.print("\nGuess a magic number between 0 and 100");
        System.out.print("\nEnter your guess: ");
        int user_guess = input.nextInt();

        while (user_guess != random_num){

            if(user_guess < random_num){
                System.out.print("Your guess is too low!");
            }
            else{
                System.out.print("Your guess is too high!");
            }

            System.out.print("\nEnter your guess: ");
            user_guess = input.nextInt();
        }

        System.out.printf("Correct! The number is %d", random_num);

    }
}


class sentinelValue{

    public void runClass(Scanner input){

        System.out.print("\n\nContinous Addition Program!");

        System.out.print("\nEnter an integer (0 to exit): "); // 0 is the flag (sentinel value to close the loop)
        int addition_data = input.nextInt();

        long total_sum = 0;

        while(addition_data != 0){

            total_sum += addition_data;
            System.out.printf("Total is: %d", total_sum);
            System.out.print("\nEnter an integer (0 to exit): ");
            addition_data = input.nextInt();

        }

        System.out.printf("The total is: %d", total_sum);
    }
}
