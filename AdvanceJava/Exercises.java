package AdvanceJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Exercises {

        @FunctionalInterface // functional interface is an interface that contains exactly one abstract
        // method. These interfaces are used to represent functional concepts, similar
        // to what lambda expressions can express.
        interface MultiplierLambda {
                int nums(int a, int b); // one abstracted method
        }


        public static void main(String[] args) {

                // Que:- Write lambda expression that takes two integers and returns there
                // multiplication.Then,apply this lambda to a pair of numbers.

                // method 1
                BinaryOperator<Integer> prod = (a, b) -> a * b; // generally we dont do these kind of programs and
                                                                // storing the
                                                                // function in variable
                int answer = prod.apply(22, 2); // .apply() method should be remembered
                System.out.println("\nthe product of 22,2 is : " + answer);



                // ---------------------------OR-----------------------------------
                // method 2 by using functional interfaces

                MultiplierLambda multiplier = (a, b) -> a * b;   //storing a lambda function to a variable
                MultiplierLambda adder = (a, b) -> a + b;   //storing a lambda function to a variable

                int result = multiplier.nums(4, 6); // variable.builtinMethods() <is a by default notion> ,,,here we are doing the same using interfaces ==>Interface'sVariable.InterfaceMethod()==>result
                int result2 = adder.nums(4, 6); 
                System.out.println("The result of 4 * 6 is: " + result);
                System.out.println("The result of 4 + 6 is: " + result2);
                System.out.println();





                // Que2: Convert an array of Strings into a Stream.Then,use the stream to print
                // each string have length greater than 3 to the console

                List<String> lis = new ArrayList<>(
                                List.of("dog", "cow", "monkey", "goat", "deer", "donkey", "lion", "tiger", "leopard",
                                                "cat", "rabbit"));

                lis.stream().filter(li -> li.length() > 3).forEach(li -> System.out.println(li));

                // Que:- Given a list of string of string,use stream operation to filter out
                // strings that have length of 10 or more and then concatinate to remaining
                // strings

                List<String> list = Arrays.asList("game", "gully cricket", "marval universe", "ironman", "technology",
                                "computer system", "motorcycle", "airplane mode", "Quaintumphysics", "conspiracy");
                System.out.println("the list of string is : " + list + "\n");

                String agg = list.stream().filter(li -> li.length() > 10).reduce("", (a, b) -> a + " " + b);
                System.out.println("reduced string is : " + agg);

                // method 2:

                StringBuilder sb = list.stream()
                                .filter(str -> str.length() > 10)
                                .reduce(new StringBuilder(), (stringBuilder, str) -> stringBuilder.append(str),
                                                StringBuilder::append);

                System.out.println(sb.toString());

                StringBuilder sol = list.stream().filter(str -> str.length() > 10)
                                .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append);

                System.out.println("\nusing method 3 : " + sol.toString());

        }

}