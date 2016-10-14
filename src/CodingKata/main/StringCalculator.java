package CodingKata;

import java.util.ArrayList;
import java.util.List;


public class StringCalculator {

    public static final int MAX_VALUE = 1000;

    public static int add(String numbers) {
    	if(numbers.equals("")){
			return 0;
		}
        List<Integer> list = fromStringToInt(numbers);
        noNegatives(list);
        List<Integer> correctList = noTooBigNumbers(list);
        return sumOf(correctList);
    }

    private static List<Integer> fromStringToInt(String input) {
    	List<Integer> list =new ArrayList<Integer>();
    	 String[] ss=input.split(",|\n");
    	 if(ss.length > 2)
    	 {
    		 throw new IllegalArgumentException("The list cannot contain more than 2 numbers");
    	 }
    	 else{
    		 for(int i=0;i<ss.length;i++)
    		 {
    			 list.add(Integer.parseInt(ss[i]));
    		 }
    	 }
    	 return list;
    }
    
    private static List<Integer> noTooBigNumbers(List<Integer> numbers) {
        List<Integer> newList = new ArrayList<Integer>();
        for (Integer number : numbers) {
            if (number <= MAX_VALUE) {
                newList.add(number);
            }
        }
        return newList;
    }

    private static void noNegatives(List<Integer> numbers) {
        List<Integer> negative = new ArrayList<Integer>();

        for (Integer number : numbers) {
            if (number < 0) {
                negative.add(number);
            }
        }
        if (!negative.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negative);
        }
    }

    private static int sumOf(List<Integer> terms) {
        int sum = 0;
        for (Integer term : terms) {
            sum += term;
        }
        return sum;
    }
   
}