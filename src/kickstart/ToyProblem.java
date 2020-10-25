package kickstart;

import java.util.Scanner;

public class ToyProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int c = 0; c <= cases; c++) {
            int n = scanner.nextInt();
            int[] err = new int[n];
            int[] rrr = new int[n];
            int[] rCurr = new int[n];
            int[] rPrev = new int[n];
            int errVal = 0,idx=0;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                int e = scanner.nextInt(), r = scanner.nextInt();
                err[i] = e;
                rrr[i] = r;
            }
            while (flag){
                if(idx==0){
                    rPrev[idx]=rrr[idx];
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    
                }
                ++idx;
            }
        }

    }
}
