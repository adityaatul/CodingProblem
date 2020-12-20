package AmazonMicrosoftQuestions;

import java.util.ArrayList;
import java.util.Collections;
/*
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
 */
public class AllSubSet {
    public static void main(String[] args) {
        System.out.println(new Solution15().subsets(new ArrayList<>()));
    }
}
class Solution15 {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        if(A.size() == 0){
            return res;
        }
        Collections.sort(A);
        allSubSet(res, A, new ArrayList(), 0, A.size());
        // for (ArrayList<Integer> l : res) {
        //     Collections.sort(l);
        // }
        // Collections.reverse(res);
        return res;
    }
    void allSubSet(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> A, ArrayList<Integer> temp, int j, int size){
        // if(size == i){
        //     res.add(new ArrayList(temp));
        //     return;
        // }

        for(int i = j;i < size; i++){
            temp.add(A.get(i));
            res.add(new ArrayList(temp));
            allSubSet(res, A, temp, i + 1, size);
            temp.remove(temp.size() - 1);
        }

    }
}
