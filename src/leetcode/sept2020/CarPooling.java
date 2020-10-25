package leetcode.sept2020;

import java.util.*;

public class CarPooling {
    public static void main(String[] args) {
        System.out.println(new Solution22().carPooling(new int[][]{{3,2,7},{3,7,9},{8,3,9}},11));
    }
}
class Trip{
    int start;
    int end;
    public Trip(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class Solution22{
    public boolean carPooling(int[][] trips, int capacity) {
        int totalTrips = trips.length;
        Map<Trip,Integer> hash = new HashMap<>();
        List<Trip> arr = new ArrayList<>();
        for (int []trip:trips) {
            int c = trip[0];
            int s = trip[1];
            int e = trip[2];
            Trip t = new Trip(s,e);
            arr.add(t);
            hash.put(t,c);
        }
        arr.sort((t0, t1) -> Integer.compare(t0.start, t1.start));
        //arr.forEach((t)->System.out.println(t.start+" "+t.end));
        int cap=0,ps=0,pe=0,pc=0;
        for (Trip t:arr) {
            if(cap>capacity)
                return false;
            if(cap==0){
                pc=hash.get(t);
                ps=t.start;
                pe=t.end;
                cap=pc;
                continue;
            }
            if(t.start>=pe)
                cap = (cap>pc)?cap-pc:0;
            pc=hash.get(t);
            ps=t.start;
            pe=t.end;
            cap+=pc;
        }
        return (cap>capacity)?false :true;
    }
}

/*
>>Best solution

 public boolean carPooling(int[][] trips, int capacity) {
     int stops[] = new int[1001];
  for (int t[] : trips) {
      stops[t[1]] += t[0];
      stops[t[2]] -= t[0];
  }
  for (int i = 0; capacity >= 0 && i < 1001; ++i) capacity -= stops[i];
  return capacity >= 0;
    }
 */