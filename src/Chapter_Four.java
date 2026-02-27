import java.util.Scanner;

public class Chapter_Four {

    public static void main(String[] args){

        Scanner user_input = new Scanner(System.in);

        // triangles program
        triangleAngles triangle_angle_program = new triangleAngles();
        triangle_angle_program.computeAngles(user_input);

        // removes last entry for string entry for string length
        user_input.nextLine();

        // string length
        stringLength string_length_program = new stringLength();
        string_length_program.get_length(user_input);

    }

}

// Mathematics functions Math.

/*

Math.ceil(x) = x is rounded up to its nearest integer (returns a double)
Math.floor(x) = x is rounded down to its nearest integer (returns a double)
Math.rint(x) = x is rounded to its nearest integer, if it's equally as close it's rounded to the even integer
Math.round(x) = returns (int)Math.floor(x + 0.5)

min, max, and abs methods

Math.max(10,2,3,99,40) = returns 99
Math.min(10,2,3,99,40) = returns 2
Math.abs(-2) = returns 2

Random method

(int) (Math.random() * 10); = return a random integer between 0 and 9 (10 - 1)
a + (int) (Math.random() * b); = return a random integer between a and a+b-1

 */

class triangleAngles{

    public void computeAngles(Scanner user_input){

        // A = (acos(a * a - b * b - c * c)) / (-2 * b * c)
        // B = (acos(b * b - a * a - c * c)) / (-2 * a * c)
        // C = (acos(c * c - a * a - b * b)) / (-2 * a * b)

        System.out.print("Enter three points: ");
        double x1 = user_input.nextDouble();
        double y1 = user_input.nextDouble();
        double x2 = user_input.nextDouble();
        double y2 = user_input.nextDouble();
        double x3 = user_input.nextDouble();
        double y3 = user_input.nextDouble();

        // Compute Sides

        double a = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        double b = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
        double c = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

        // Compute Angles

        double angle_a = Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
        double angle_b = Math.toDegrees(Math.acos((b * b - a * a - c * c) / (-2 * a * c)));
        double angle_c = Math.toDegrees(Math.acos((c * c - a * a - b * b) / (-2 * a * b)));

        // Display Results

        System.out.println("The three angles are " + Math.round(angle_a * 100) / 100.0 + " " + Math.round(angle_b * 100) / 100.0 + " " + Math.round(angle_c * 100) / 100.0);

    }

}


// Character data types and operations

/*

    char letter = 'A';
    char numChar = '4';

    'a' is a char whereas "a" is a string

    '' for char literal and "" for a string literal

    Mapping a character to its binary representation is called encoding

    Java supports unicode

    A 16 bit Unicode takes two bytes preceded by a \ u expressed in hexadecimal digits

    Unicode includes ASCII code with \u0000 to \u007F corresponding to the 128 ASCII characters

    e.g.

    'A' to 'Z' in decimal is 65 to 90, in unicode the value is \u0041 to \u005A

    e.g.

    char letter = '\u0041' will return the char 'A'

    e.g.

    char ch = 'a';

    System.out.println(++ch); will return b as ch is changed before the execution of the print statement

    char ch = 'a';

    System.out.printkn(ch++); will return a as ch is changed after the execution of the print statement


    Escape sequences:

    \b = backspace
    \t = tab
    \n = linefeed
    \f = formfeed
    \r = carriage return
    \\ = backslash
    \" = double quote

    e.g.

    System.out.println("He said \"Java is fun\"");

    return He said "Java is fun"

    Comparison:

    'a' < 'b' is true because the Unicode for 'a' (97) is less than the Unicode for 'b' (98)
    'a' < 'A' is false because the Unicode for 'a'(97) is greater than the Unicode for 'A' (65)

    e.g.

    if (ch >= 'A' && ch <= 'Z'){
        System.out.println(ch + " is uppercase");


    Methods in character class:

    isDigit(ch) = returns true if ch is a digit
    isLetter(ch) = returns true if ch is a letter
    isLetterOrDigit(ch) = returns true if ch is a letter or a digit
    isLowerCase(ch) = returns true if ch is lowercase
    isUpperCase(ch) = returns true if ch is uppercase
    toLowerCase(ch) = returns the lowercase of the ch
    toUpperCase(ch) = returns the uppercase of the ch



    String type:

    To represent a string of characters the data type is String

    String message = "Welcome to Java";

    String is a predefined class in the Java library, like System and Scanner.

    String methods:

    length() = returns the number of characters in the string
    charAt(index) = returns the character at the specified index from the string
    concat(s1) = returns a new string that concatenates this string with string s1
    toUpperCase() = returns a new string with all letters in uppercase
    toLowerCase() = returns a new string with all letters in lowercase
    trim() = returns a new string with whitespace characters trimmed on both sides

*/

class stringLength{

    public void get_length(Scanner user_input){

        // user enters a string
        System.out.print("Enter sentence: ");
        String message = user_input.nextLine();
        int sentence_len = message.length();

        System.out.println("The length of the message is " + sentence_len);

    }
}


/*

    You can concatenate strings

    String s3 = s1.concat(s2) is the same as String s3 = s1 + s2;

    Converting strings:

    "WelCOME".toLowerCase(); returns a new string welcome

    "\t Good Night \n".trim() returns a new string Good Night

    Reading a string from console:

    System.out.print("Enter three words separated by spaces");
    String s1 = input.next();
    String s2 = input.next();
    String s3 = input.next();

    The .next() method reads a string that ends with a whitespace character

    You can use the .nextLine() method to read an entire line of text that ends with an enter key pressed

    Reading a character from the console:

    System.out.print("Enter a character: ");
    String s = input.nextLine();
    char ch = s.charAt(0); This will return the char at index 0 from s

    Comparison methods of string objects:

    equals(s1) = returns true if this string is equal to string s1
    equalsIgnoreCase(s1) = returns true if this string is equal to string s1 but it is case insensitive
    startsWith(prefix) = returns true if this string starts with the specified prefix
    endsWith(prefic) = returns true if the string ends with the specified prefix
    contains(s1) = returns true if s1 is a substring in this string

    To compare two strings use:

    if (string1 == string2) only checks to whether string1 and string2 refer to the same object

    whereas string1.equals(string2) checks to see if the strings contain the same content

    Getting substrings:

    String message = "Welcome to Java";
    message = message.substring(0,11) + "HTML";
    System.out.print(message);
    Welcome to HTML

    substring works like:
    substring(beginIndex, endIndex) or substring(beginIndex:);

    Finding a character or a substring in a string:

    indexOf(Ch) = will return the index of the first occurrence of ch in string
    indexOf(ch, fromIndex) = will return the index of the first occurrence of ch in a string from the index of inputted index
    indexOf(s) = returns the index of the first occurrence of string s in the string
    lastIndex(ch) = returns the index of the last occurrence of ch in the string

    Conversion between Strings and Numbers:

    To convert a string into an int value you can use the Integer.parseInt method e.g.

    intString = "123";
    int int_value = Integer.parseInt(intString);

*/

// Formatting console output

/*

    You can use System.out.printf method to display the formatted output on the console

    e.g.

    double amount = 12618.98;
    double interest_rate = 0.0013;
    double interest = amount * interest_rate;
    System.out.printf("Interest is %4.2f", interest);

    %4.2f works in that 4 represents the field width (how many nums), 2 (precision after the decimal), f(conversion code)

    %b = boolean
    %c = char
    %d = int
    %f = floating point num
    %e = standard scientific notation number
    %s = string

*/












