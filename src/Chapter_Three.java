import java.util.Scanner;
import java.util.Random;

public class Chapter_Three {

    public static void main(String[] args){

        // Create addition quiz

        Scanner user_input = new Scanner(System.in);

        // Create an instance of Random Jav Class
        Random random = new Random();

        int num_one = random.nextInt(1,100);
        int num_two = random.nextInt(1, 100);

        System.out.printf("What is %d + %d? ", num_one, num_two);
        int user_answer = user_input.nextInt();

        System.out.printf("%d + %d = %d is %b", num_one, num_two, user_answer, (num_one + num_two == user_answer));


        // Seeing if number is even or odd

        System.out.print("\nEnter a number: ");
        int user_number = user_input.nextInt();

        if(user_number % 2 == 0){
            System.out.printf("%d is even!", user_number);
        }
        else{
            System.out.printf("%d is odd!", user_number);
        }

        user_input.close();

    }


}
