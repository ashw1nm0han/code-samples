import java.security.InvalidAlgorithmParameterException;

/**
 * Created by AshwinMohan on 24/04/14.
 */
public class DutchFlagAlgorithm {

    /*Assume 3 number flag problem, using n1,n2,n3 generalizes to sort based on given order (T:o(n), S:o(1))
    * Test cases:
    * 1. 4112
    * 2. 111222333
    * 3. 123123123 - equal spacing
    * 4. 11112222- only two numbers
    * 5. 11111- only one number
    * 6. ""
    * 7. 1
    * 8. numbers in different orders
    *
    * note:
    * 1. careful on what low, mid, high signify(indexes).mid is the one that moves towards high. ranges are n1- 0 to low-1,
     * n2 - low to mid -1, n3 - high to size - 1, unknown is mid to high. iNitially that is total array size, at the end, when
      * both are equal that becomes zero
      *
      * improvements: start by moving low and mid if the initial numbers are n1 or moving high if ending numbers are n3.will reduce the number of swaps
      *
    * */
    public static void Sort(Integer []numbers, Integer n1, Integer n2, Integer n3) throws InvalidAlgorithmParameterException{
        if(numbers.length <= 1 ) System.out.println(numbers[0]);
        Integer low = 0, mid =0, high = numbers.length -1; // start, mid at first location, end at end of array

        while(mid <= high){
            if(numbers[mid] == n1){swap(numbers, mid++, low++);}
            else if(numbers[mid] == n2){mid++;}
            else if(numbers[mid] == n3){swap(numbers, mid, high--);}
            else{throw new InvalidAlgorithmParameterException(String.format("Unsupported Integer in the array"));}
        }

        for(int i =0; i < numbers.length; ++i){
            System.out.print(numbers[i] + " ");
        }

    }

    private static void swap(Integer [] numbers, Integer x, Integer y){
        if(numbers[x] == numbers[y]) return;
        Integer temp =  numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }

    public static void call() throws InvalidAlgorithmParameterException {
        Integer [] sample = {1,1,1,2,2,1,1,2,1,2};
        Sort(sample,4,1,2);
    }
}
