package DSA450;

public class KadanesAlgo {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{-1,-2,-3,-4,-15}, 5));
    }
    static int maxSubarraySum(int arr[], int n){
        int maxSoFar= Integer.MIN_VALUE, maxEndingHere = 0;
        for (int i = 0; i < n; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
            }
            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }

}
