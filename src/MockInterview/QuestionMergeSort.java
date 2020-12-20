package MockInterview;

public class QuestionMergeSort {
    public static void main(String[] args) {
        int arr[] = new int[]{51,2,33,54,5,12};
        merge(arr, 0, arr.length - 1);
        for (int ele: arr) {
            System.out.println(ele);
        }
    }

    private static void merge(int[] arr, int l, int r) {
        if (l < r){
            int mid = l + (r - l)/2 ;
            merge(arr, l, mid);
            merge(arr, mid + 1, r);
            mergeSort(arr, l, r, mid);
        }
    }

    private static void mergeSort(int[] arr, int l, int r, int mid) {
        int n1 = mid - l + 1;
        int n2  = r - mid;
        int larr[] = new int[n1];
        int rarr[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            larr[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            rarr[i] = arr[mid + 1 + i];
        }
        int lp = 0, rp = 0, p = l;
        while (lp < n1 &&  rp < n2){
            if(larr[lp] <= rarr[rp]){
                arr[p] = larr[lp];
                ++lp;
            }else{
                arr[p] = rarr[rp];
                ++rp;
            }
            ++p;
        }
        while(lp < n1){
            arr[p++] = larr[lp++];
        }
        while (rp < n2){
            arr[p++] = rarr[rp++];
        }
    }
}

/*
Prev Q
Must do coding Q gfg
Don't see the solution - after 3,4 attempts, think on ur own
Understand the mindset, don't remember the Q
Go through basic of dbms and os - distributed sys, processes, threads.
Multi threading in java, DI, Design Patterns, OOPS.
Make a service on ur own with java, some API's , use a DBMS, (use all the OOPS concept here).
Design interview Q. design netflix, amazon, etc. Search the components used there and read about them.
 */
