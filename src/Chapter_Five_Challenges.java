import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.Random;
import java.time.Instant;

public class Chapter_Five_Challenges {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        Instant time = Instant.now();

        // Pass or Fail Program

        passOrFail pass_fail_program = new passOrFail();
        pass_fail_program.testScore(input);

        // Multiplication quiz

        multiplicationQuiz multiplication_program = new multiplicationQuiz();
        multiplication_program.runQuiz(input, random, time);

    }
}

class passOrFail{

    public void testScore(Scanner input){

        System.out.print("Pass or Fail Program!");

        // pass is score >= 60
        int pass = 60;

        System.out.print("\nEnter your score: ");
        int student_score = input.nextInt();

        while(student_score != -1){
            if(student_score >= pass){
                System.out.print("You pass the exam!");
            }
            else{
                System.out.print("You failed the exam!");
            }
            System.out.print("\nEnter your score: ");
            student_score = input.nextInt();
        }
    }
}

class multiplicationQuiz {

    public void runQuiz(Scanner input, Random random, Instant time) {

        System.out.print("\n\nMultiplication Quiz: ");

        System.out.print("\nHow many questions do you want to do? ");
        int number_of_questions = input.nextInt();

        int user_score = 0;

        Instant start = time.now();

        for (int i = 1; i <= number_of_questions; i++) {
            int random_one = (int) (random.nextInt(12) + 1);
            int random_two = (int) (random.nextInt(12) + 1);
            int correct_result = random_one * random_two;
            System.out.printf("\nQuestion %d: %d * %d = ", i, random_one, random_two);
            int user_answer = input.nextInt();

            if (user_answer == correct_result) {
                System.out.print("Correct!");
                user_score++;
            } else {
                System.out.print("Incorrect!");
            }
        }

        Instant end = time.now();

        long total_time = Duration.between(start, end).toSeconds();

        System.out.printf("\nYou scored %d/%d in %d seconds!", user_score, number_of_questions, total_time);
    }
}

class centimeterConversion{

    public void createTable{

    }
}