/**
 * Created by AshwinMohan on 24/04/14.
 */
public class MaximumSubArray {

    // kadanes algorithm(T: O(n), S: O(1), dynamic programming)
    // both functions can have positive or negative numbers or even zeros
    // get corresponding start and end locations for the sub-array
    // test cases:
    // all negative, multiple zeros, mix of positives and negatives
    // empty array, single number
    public static void Sum(Integer [] numbers){
        Integer maxSum = Integer.MIN_VALUE;
        Integer currSum = 0;
        Integer start = 0, count = 0, maxCount = Integer.MIN_VALUE, maxStart = Integer.MIN_VALUE;

        for(int i = 0 ; i < numbers.length; ++i){
            currSum += numbers[i]; ++count;
            if(currSum > maxSum){maxSum = currSum;maxCount = count; maxStart = start;}
            if(currSum <= 0){currSum = 0;count = 0;start = i+1;}
        }

        System.out.println("max subarray sum: " + maxSum);
        System.out.println("subarray is located at: " + maxStart + "," + (maxStart + maxCount - 1));
    }


    // look for max and min subarray product at each step.
    // new currentmaxprod = (currentmaxprod * i; // when i is positive
    // new currentmaxprod = max(currentminprod * i,1); // when i is negative
    // new currentminprod = (old/currentmaxprod * i; // when i is negative
    // new currentminprod = min(currentminprod * i,1); // when i is positive
    // test cases: all negs, all pos, alternate negs and pos,all 1s, max value as 1, other negatives.
    // empty array, single element array
    // be careful not to use index in place of array value..
    public static void Product(Integer [] numbers){

        Integer currentmaxprod = 1, currentminprod = 1, maxprod = 1, minprod = 1;

        for(int i = 0; i < numbers.length ; ++i){
            if(numbers[i] > 0){
                currentmaxprod = currentmaxprod * numbers[i];
                currentminprod = Math.min(currentminprod * numbers[i],1);

            }
            else if(numbers[i] < 0){
                Integer temp = currentmaxprod;
                currentmaxprod = Math.max(currentminprod * numbers[i], 1);
                currentminprod = temp * numbers[i];

            }

            else{
                currentminprod = 1;
                currentmaxprod = 1;
            }

            if(currentmaxprod > maxprod){maxprod = currentmaxprod;}
            if(currentminprod < minprod){minprod = currentminprod;}
        }

        System.out.println("Max product: " + maxprod);
        System.out.println("Min product: " + minprod);
    }

    public static void Call(){
        Integer [] sample = {1, -2, -3, 0, 7, -8, -2};;
        Sum(sample);
        Product(sample);
    }
}
