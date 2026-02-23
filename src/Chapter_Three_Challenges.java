import java.util.Scanner;

public class Chapter_Three_Challenges {

    public static void main(String[] args){

        Scanner three_scanner = new Scanner(System.in);

        quadraticEquation quadratic_equation_program = new quadraticEquation();
        quadratic_equation_program.runEquation(three_scanner);

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
        System.out.print("Enter values a, b, c: ");
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
