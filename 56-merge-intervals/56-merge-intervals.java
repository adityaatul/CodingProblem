class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = intervals[i];
            if (temp[0] <= res.get(res.size() - 1)[1]) {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], temp[1]);
            }else {
                res.add(temp);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}