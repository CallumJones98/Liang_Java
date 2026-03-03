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

        // reset input
        input.nextLine();

        // Do While loop program
        guessRandomLetter guess_random_letter_program = new guessRandomLetter();
        guess_random_letter_program.runRandomLetter(input);

        // Palindrome Program
        checkPalindrome palindrome_program = new checkPalindrome();
        palindrome_program.runPalindrome(input);

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

class guessRandomLetter{

    public void runRandomLetter(Scanner input){

        System.out.print("\n\nGuess a Random Letter Program!");

        int min_letter = 97; // represent 'a'
        int max_letter = 122; // represent 'z'

        // Random Char
        int random_int = (int)(Math.random() * (max_letter - min_letter + 1)) + min_letter;
        char target_char = (char)(random_int);

        //Guess count
        int number_of_guesses = 0;
        char user_guess; // Declare it here so the 'while' condition can see it

        // The loop starts here
        do {
            System.out.print("\nEnter a letter (a-z): ");
            String line = input.nextLine();

            user_guess = line.charAt(0);
            number_of_guesses++;

            if (user_guess != target_char) {
                if (user_guess < target_char) {
                    System.out.println("The letter is later in the alphabet.");
                } else {
                    System.out.println("The letter is earlier in the alphabet.");
                }
            }

        } while (user_guess != target_char);

        System.out.printf("Well done! You guessed the letter %c in %d guesses!", target_char, number_of_guesses);

    }
}

class checkPalindrome{

    public void runPalindrome(Scanner input){

        System.out.print("\n\nPalindrome program!");

        System.out.print("\nEnter a string: ");
        String word = input.nextLine();

        int first_char = 0; // index = 0
        int last_char = word.length() - 1;

        boolean is_palindrome = true;

        while(first_char < last_char){
            if (word.charAt(first_char) != word.charAt(last_char)){
                is_palindrome = false;
                break;
            }

            first_char++;
            last_char--;
        }

        if(is_palindrome){
            System.out.printf("\n%s is a palindrome!", word);
        }
        else{
            System.out.printf("\n%s is not a palindrome!", word);
        }
    }
}


