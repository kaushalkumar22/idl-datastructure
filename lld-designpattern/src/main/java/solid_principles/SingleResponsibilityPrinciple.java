package solid_principles;

import java.util.Scanner;

class SRPViolation {
    public static void main(String[] args) {
        //responsibility 1 : reading input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Num");
        String first = scanner.nextLine();
        System.out.println("Enter Second Num");
        String second = scanner.nextLine();

        //responsibility 2 :parsing input
         int num1 =   Integer.parseInt(first);
         int num2 =   Integer.parseInt(first);
        //responsibility 3 : performing operation
         int res = num1 +num2 ;
        System.out.println("Result: "+res);
    }
}
public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        String[] inputs = InputProcessor.process();
        int first  = InputParser.parse(inputs[0]);
        int second = InputParser.parse(inputs[1]);
        int result = Opration.execute(first,second);
        System.out.println("Result: "+result);
    }
}
//Responsibility 1 : reading input
class InputProcessor{
    public static String[] process(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Num");
        String first = scanner.nextLine();
        System.out.println("Enter Second Num");
        String second = scanner.nextLine();
        return new String[]{first,second};
    }
}
//Responsibility 2 :parsing input
class InputParser{
    public static int parse(String input){
        validate( input);
        return Integer.parseInt(input);
    }
    public static void validate(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException ex){
            System.out.println("One of Input is invalid: "+input);
        }
    }
}
//Responsibility 3 : performing operation
class Opration{
    public static int execute(int num1,int num2){
        return num1+num2;
    }
}