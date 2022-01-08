class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer> >(numCourses);
        
        Stack<Integer> stack = new Stack<>();
        
        int[] completed = new int[numCourses];
 
        for (int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<Integer>());
            completed[i] = 1;
        }
            
        
        for (int[] pre: prerequisites) {
            int node = pre[0];
            int dep = pre[1];
            graph.get(node).add(dep);
            completed[node] = 0;
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (completed[i] == 1) continue; 
            ArrayList<Integer> nodes = graph.get(i); 
            
            for (int node: nodes) {
                if (completed[node] == 0 ) {
                    stack.push(node);
                    Set<Integer> seen = new HashSet<>();
                    seen.add(node);
                    while (!stack.isEmpty() && stack.peek() != i) {
                        int head = stack.pop();
                        seen.add(head);
                        for (int n : graph.get(head)) {
                            if (seen.contains(n)) {
                                return false;
                            }
                            if (completed[n] == 0) {
                                stack.push(n);
                            }
                        }
                    }
                    if (!stack.isEmpty()) {
                        return false;
                    }
                }
            }
            completed[i] = 1;  
        }
        
        return true;
    }


}



/*

0 -> 2 
1 -> 0
2 -> 1


3, [1,0], [1,2] , [2,0], [3, 0]

0 -> {} 
1 -> 0, 2
2 -> 1,
3 -> 0
4 -> {}


*/