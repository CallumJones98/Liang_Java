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


        // If statement that increases pay by 3% if score is greater than 90, otherwise increases pay by 1%

        System.out.print("\nEnter pay: ");
        double total_pay = user_input.nextDouble();
        System.out.print("Enter score: ");
        int user_score = user_input.nextInt();

        if (user_score >= 90){
            total_pay += (total_pay * 0.03);
            System.out.printf("New total pay is: £%.2f", total_pay);
        }
        else{
            total_pay += (total_pay * 0.01);
            System.out.printf("New total pay is: £%.2f", total_pay);
        }


        /*

        Common issues:

        1. if (even == true) is equivalent to if (even)

        2. Equality test between two floating point values
            0.5 is 0.5000000000000000000001 for example

        3. if (number % 2 == 0){
                even = True;
                }
           else{
                even = False;
                }


           a better version is:

           boolean even = number % 2 == 0;


         4. Avoiding duplicate code:

         if (inState){
            tuition = 5000;
         else{
            tuition = 15000;
            }
         System.out.println("The tuition is " + Tuition);


         */

        // Subtraction quiz

        int n_one = random.nextInt(1,101);
        int n_two = random.nextInt(1, 101);

        int max_num;
        int min_num;

        if (n_one >= n_two){
            max_num = n_one;
            min_num = n_two;
        }
        else{
            max_num = n_two;
            min_num = n_one;
        }

        System.out.printf("\nWhat is %d - %d? ", max_num, min_num);
        int user_minus_ans = user_input.nextInt();
        int confirmed_ans = max_num - min_num;

        if (user_minus_ans == confirmed_ans){
            System.out.println("Correct!");
        }
        else{
            System.out.println("Incorrect!");
        }

        // BMI Program
        System.out.println("\nThis is the BMI program: ");

        System.out.print("Enter your weight (kg): ");
        double user_weight = user_input.nextDouble();

        System.out.print("Enter your height (metres): ");
        double user_height = user_input.nextDouble();

        double bmi = user_weight / Math.pow(user_height, 2);

        String bmi_classification;

        if (bmi < 18.5){
            bmi_classification = "underweight";
        }
        else if (bmi < 25.0){
            bmi_classification = "Normal";
        }
        else if (bmi < 30.0){
            bmi_classification = "Overweight";
        }
        else{
            bmi_classification = "Obese";
        }

        System.out.printf("Your BMI is %.2f and you are %s", bmi, bmi_classification);

        // Fed tax program

        federalTax fed_tax_program = new federalTax();
        fed_tax_program.calcualteTax(user_input);

        // Leap year program

        isLeapYear leap_year_program = new isLeapYear();
        leap_year_program.calculateLeapYear(user_input);

        // Lottery program

        lotteryNumbers lottery_numbers_program = new lotteryNumbers();
        lottery_numbers_program.calculateLottery(user_input, random);

        user_input.close();

    }

}

class federalTax {

    public void calcualteTax(Scanner user_input){

            // Federal Taxes Program
            System.out.println("\nThis is the Federal Taxes program: ");
            // tax_due = total_income *= tax_rate

            // User enter status (0 = single, 1 = married jointly / Widower, 2 = married, filing separately, 3 = head of household

            System.out.print("Enter income: ");
            double total_income = user_input.nextDouble();
            System.out.print("Enter status: ");
            int tax_status = user_input.nextInt();

            // template rates set
            double tier_1_rate = 0.10, tier_2_rate = 0.15, tier_3_rate = 0.25, tier_4_rate = 0.28, tier_5_rate = 0.33, tier_6_rate = 0.35;
            double tax_due = 0.0;

            if (tax_status == 0) {
                if (total_income <= 8350){
                    tax_due += total_income * tier_1_rate;
                }
                else if (total_income <= 33950){
                    tax_due += 8350 * tier_1_rate;
                    tax_due += (total_income - 8350) * tier_2_rate;
                }
                else if (total_income <= 82250){
                    tax_due += 8350 * tier_1_rate;
                    tax_due += (33950 - 8350) * tier_2_rate;
                    tax_due += (total_income - 33950) * tier_3_rate;
                }
                else if (total_income <= 171550){
                    tax_due += 8350 * tier_1_rate;
                    tax_due += (33950 - 8350) * tier_2_rate;
                    tax_due += (82250 - 33950) * tier_3_rate;
                    tax_due += (total_income - 82250) * tier_4_rate;
                }
                else if (total_income <= 372950){
                    tax_due += 8350 * tier_1_rate;
                    tax_due += (33950 - 8350) * tier_2_rate;
                    tax_due += (82250 - 33950) * tier_3_rate;
                    tax_due += (171550 - 82250) * tier_4_rate;
                    tax_due += (total_income - 171550) * tier_5_rate;
                }
                else {
                    tax_due += 8350 * tier_1_rate;
                    tax_due += (33950 - 8350) * tier_2_rate;
                    tax_due += (82250 - 33950) * tier_3_rate;
                    tax_due += (171550 - 82250) * tier_4_rate;
                    tax_due += (372951 - 171550) * tier_5_rate;
                    tax_due += (total_income - 372950) * tier_6_rate;
                }
            }
            else if (tax_status == 1){
                if (total_income <= 16700){
                    tax_due += total_income * tier_1_rate;
                }
                else if (total_income <= 67900){
                    tax_due += 16700 * tier_1_rate;
                    tax_due += (total_income - 16700) * tier_2_rate;
                }
                else if (total_income <= 137050){
                    tax_due += 16700 * tier_1_rate;
                    tax_due += (67900 - 16700) * tier_2_rate;
                    tax_due += (total_income - 67900) * tier_3_rate;
                }
                else if (total_income <= 208850){
                    tax_due += 16700 * tier_1_rate;
                    tax_due += (67900 - 16700) * tier_2_rate;
                    tax_due += (137050 - 67900) * tier_3_rate;
                    tax_due += (total_income - 137050) * tier_4_rate;
                }
                else if (total_income <= 372950){
                    tax_due += 16700 * tier_1_rate;
                    tax_due += (67900 - 16700) * tier_2_rate;
                    tax_due += (137050 - 67900) * tier_3_rate;
                    tax_due += (208850 - 137050) * tier_4_rate;
                    tax_due += (total_income - 208850) * tier_5_rate;
                }
                else {
                    tax_due += 16700 * tier_1_rate;
                    tax_due += (67900 - 16700) * tier_2_rate;
                    tax_due += (137050 - 67900) * tier_3_rate;
                    tax_due += (208850 - 137050) * tier_4_rate;
                    tax_due += (372950 - 208850) * tier_5_rate;
                    tax_due += (total_income - 372950) * tier_6_rate;
                }
            }
            else if (tax_status == 2){
                if (total_income <= 8350){
                    tax_due += total_income * tier_1_rate;
                }
                else if (total_income <= 33950){
                    tax_due += 8350 * tier_1_rate;
                    tax_due += (total_income - 8350) * tier_2_rate;
                }
                else if (total_income <= 68525){
                    tax_due += 8250 * tier_1_rate;
                    tax_due += (33950 - 8350) * tier_2_rate;
                    tax_due += (total_income - 33950) * tier_3_rate;
                }
                else if (total_income <= 104425){
                    tax_due += 8350 * tier_1_rate;
                    tax_due += (33950 - 8350) * tier_2_rate;
                    tax_due += (68525 - 33950) * tier_3_rate;
                    tax_due += (total_income - 68525) * tier_4_rate;
                }
                else if (total_income <= 186475){
                    tax_due += 8350 * tier_1_rate;
                    tax_due += (33950 - 8350) * tier_2_rate;
                    tax_due += (68525 - 33950) * tier_3_rate;
                    tax_due += (104425 - 68525) * tier_4_rate;
                    tax_due += (total_income - 104425) * tier_5_rate;
                }
                else {
                    tax_due += 8350 * tier_1_rate;
                    tax_due += (33950 - 8350) * tier_2_rate;
                    tax_due += (68525 - 33950) * tier_3_rate;
                    tax_due += (104425 - 68525) * tier_4_rate;
                    tax_due += (186475 - 104425) * tier_5_rate;
                    tax_due += (total_income - 186475) * tier_6_rate;
                }
            }
            else if (tax_status == 3){
                if (total_income <= 11950){
                    tax_due += total_income * tier_1_rate;
                }
                else if (total_income <= 45500){
                    tax_due += 11950 * tier_1_rate;
                    tax_due += (total_income - 11950) * tier_2_rate;
                }
                else if (total_income <= 117450){
                    tax_due += 11950 * tier_1_rate;
                    tax_due += (45500 - 11950) * tier_2_rate;
                    tax_due += (total_income - 45500) * tier_3_rate;
                }
                else if (total_income <= 190200){
                    tax_due += 11950 * tier_1_rate;
                    tax_due += (45500 - 11950) * tier_2_rate;
                    tax_due += (117450 - 45500) * tier_3_rate;
                    tax_due += (total_income - 117450) * tier_4_rate;
                }
                else if (total_income <= 372950){
                    tax_due += 11950 * tier_1_rate;
                    tax_due += (45500 - 11950) * tier_2_rate;
                    tax_due += (117450 - 45500) * tier_3_rate;
                    tax_due += (190200 - 117450) * tier_4_rate;
                    tax_due += (total_income - 190200) * tier_5_rate;
                }
                else {
                    tax_due += 11950 * tier_1_rate;
                    tax_due += (45500 - 11950) * tier_2_rate;
                    tax_due += (117450 - 45500) * tier_3_rate;
                    tax_due += (190200 - 117450) * tier_4_rate;
                    tax_due += (372950 - 190200) * tier_5_rate;
                    tax_due += (total_income - 372950) * tier_6_rate;
                }
            }
            else {
                System.out.print("Invalid tax status entered!");
                System.exit(1); // exit program if status is incorrect
            }

        System.out.printf("As status %d you owe $%.2f in tax this fiscal year.", tax_status, tax_due);

        }
    }

class isLeapYear {
    public void calculateLeapYear(Scanner user_input){

        System.out.print("\nLeap year calculation class: ");

        System.out.print("\nEnter year (YYYY): ");
        int year_input = user_input.nextInt();
        boolean leap_year = false;
        // leap year calculation

        if ((year_input % 4 == 0 && year_input % 100 != 0) || (year_input % 400 == 0)){
            leap_year = true;
        }

        if(leap_year){
            System.out.printf("The year %d is a leap year!", year_input);
        }
        else{
            System.out.printf("The year %d is not a leap year!", year_input);
        }
    }
}


// randomly generate two numbers
// prompts user to enter a two-digit number and checks if it is correct or not
// if the user input matches the exact order the award is $10,000, if the digits are correct but not in the right order, return of $3,000, if one digit matches returns $1,000

class lotteryNumbers {
    public void calculateLottery(Scanner user_input, Random random){

        System.out.print("\nLottery numbers!");

        int lottery_num_one = random.nextInt(1, 60);
        int lottery_num_two = random.nextInt(1, 60);

        // user input nums
        System.out.print("\nEnter lottery number one (1 - 59): ");
        int user_lottery_one = user_input.nextInt();
        System.out.print("\nEnter lottery number two (1 - 59): ");
        int user_lottery_two = user_input.nextInt();

        int money_output;

        if (user_lottery_one == lottery_num_one && user_lottery_two == lottery_num_two) {
            money_output = 10000;
        }
        else if (user_lottery_one == lottery_num_two && user_lottery_two == lottery_num_one) {
            money_output = 3000;
        }
        else if (user_lottery_one == lottery_num_one || user_lottery_one == lottery_num_two ||
                user_lottery_two == lottery_num_one || user_lottery_two == lottery_num_two) {
            money_output = 1000;
        }
        else {
            money_output = 0;
        }

        System.out.printf("Your winnings are: £%d\n", money_output);
        System.out.printf("The Lottery numbers were: %d and %d\n", lottery_num_one, lottery_num_two);

    }

}
