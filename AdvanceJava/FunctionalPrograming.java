package AdvanceJava;
import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalPrograming {
      
// functional interface:- is an interface that contains exactly one abstract method. These interfaces are used to represent functional concepts, similar to what lambda expressions can express.

    public static void main(String[] args) {
        
    List <String> fruits = List.of("apple","banana","grapes","peach","orange","date");   // this list.of() method makes the immutable list!!!

    // for(String fruit: fruits){                   //traditional way
    //     System.out.println(fruit);
    // }


System.out.println("printing using the Streams,and redefining accept method:--");

    fruits.stream().forEach(new Consumer<String>(){    //forEach is a Terminal operation it includes consumer ...here we defined the anonymous inner class of Consumer interface and overriding the accept method
        @Override
        public void accept(String fruit){       // accept method is used to perform any operation on the given input
            System.out.println(fruit);
        }
    });           // forEach expects the object of the consumer interface which has method called {accept()} which is a generic method



    //ALTERNATIVELY----------------------------------------------------- using lambda expression
   
    //the above accept() method can be used as lambda expression for simplicity
    
    System.out.println("\n printing using lambda expression :");

    fruits.stream().forEach(fruit->System.out.println(fruit));     // here forEach is a terminal operation,Without a terminal operation, intermediate operations will not be executed, and the stream will not perform any processing. 
    
    
    System.out.println("\n printing uppercase using lambda expression :");

    fruits.stream().forEach(fruit->System.out.println(fruit.toUpperCase()));


    System.out.println("\n filtering the fruits:");
    fruits.stream().filter(fruit->fruit.endsWith("a")).forEach(fruit->System.out.println(fruit));







    List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));      // this list.of() method under the ArrayList() makes the list mutable because ArrayList() produces mutable list

    
    List<Integer> sqNumbers = numbers.stream()
                                       .map(num -> num * num)
                                       .collect(Collectors.toList());   //collect is terminal method,Accumulates the elements of this stream into a List
    
    // for (Integer num : evenNumbers) {   
    //     System.out.println(num);
    // }

    System.out.println(sqNumbers);

    // -----------------------------OR-----------------------

    System.out.println( numbers.stream()
                                    .map(num -> num * num).collect(Collectors.toList()));  

    System.out.println("\n using only forEach:");
    numbers.stream().forEach(number->System.out.println(number*2));

    
    ////////////////////////Sorting the list///////////////////
    List <Integer> numberList = List.of(21,35,466,353,65,23,7,9,5336);
    List<Integer> sortedNumlist = numberList.stream().sorted().collect(Collectors.toList());
    System.out.println(sortedNumlist);

    ///////////Distinct-ensures that no duplicates available //////
    List <Integer> DistinctList = numberList.stream().distinct().collect(Collectors.toList());
    System.out.println(DistinctList);






    }}
    