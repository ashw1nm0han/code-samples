/**
 * Created by Ashwin Mohan on 24/04/14.
 */
public class MajorityElement {

    /*find majority element in an array: (voting algorithm solution, T: o(n), S o(1))
    * Generalize for all types, use enumerable in cases where length field is not available for collection
    * Test cases:
    * 1) empty array
    * 2) array of size int max(out of memory possible)
    * 3) array with two majority elements,
    * 4) array where all elements are different
    * 5) array with single majority element
    * notes:
    * 1. be careful of the count increment, new number count is reinitialized
    * 2. Majority over half, not equal to (ask anyway)
    * 3. first run tells survivor, second round confirms majority.
    * */

    public static Integer find(Integer [] numbers){
        // no elements in the array, return negative infinity
        if(numbers.length == 0) return Integer.MIN_VALUE;

        // if single element return number.
        if(numbers.length == 1) return numbers[0];

        //for all other cases
        Integer currentMajor = Integer.MIN_VALUE;
        Integer currentMajorCount = 0;


        for(int i = 0; i< numbers.length; ++i){
            // check if current number is equal to majority number, add to its count
            if(numbers[i] == currentMajor){
                ++currentMajorCount;
            }

            else{
                // if it is not and majority count is zero, change the majority number
                if(currentMajorCount == 0){
                    currentMajor = numbers[i];
                    currentMajorCount = 1;
                }
                // reduce the count of the current majority element by one.
                else{
                    --currentMajorCount;
                }
            }
        }

        System.out.println("current major: " + currentMajor);
        System.out.println("major count: " + currentMajorCount);
        System.out.println("threshold: "+ numbers.length/2); 
        int equalCount = 0;
        for(int i=0; i< numbers.length; ++i){
            if(numbers[i] == currentMajor){
                ++equalCount;
            }
        }

        // if the majority count is more than half
        System.out.println("major count: "+ equalCount);
        if(equalCount > (numbers.length/2)){
            return currentMajor;
        }

        // else return negative infinity
        else{
            return Integer.MIN_VALUE;
        }
    }

    public static void Call()
    {
        Integer [] sample = {1,1,3,1,1,6};
        System.out.println("Majority Element is: " + find(sample));
    }
}
