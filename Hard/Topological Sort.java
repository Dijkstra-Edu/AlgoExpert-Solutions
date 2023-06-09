//Attempt #1 - 35mins
//Link: 

import java.util.*;

class Program {
  public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
    // Create Graph for given jobs and dependencies
    
    HashMap<Integer, ArrayList<Integer>> graph = createGraph(jobs, deps);

    //Topo Sort begins
    Stack<Integer> stk = new Stack<Integer>();
    boolean[] visited = new boolean[jobs.size()+1];
    ArrayList<Integer> ans = new ArrayList<Integer>();

    for (int i : jobs) {
      if (visited[i] == false) {
        topologicalSortUtil(i, visited, stk, graph);
      }
    }
			
	while (stk.empty()==false) {
      ans.add(stk.pop());
    }  

    System.out.println(Arrays.toString(visited));

    if(isValidTopologicalOrder(graph)) return ans;
    else return new ArrayList<Integer>();
  }

  public static boolean isValidTopologicalOrder(HashMap<Integer, ArrayList<Integer>> graph) {
    System.out.println(graph);
    return true;
  }

  public static void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stack, HashMap<Integer, ArrayList<Integer>> graph) {
    visited[i] = true;
    ArrayList<Integer> temp = graph.get(Integer.valueOf(i));
    if(temp==null) {
       return; 
    }
    //System.out.println(i + " " + temp);
    for(int x:temp) {
      if(visited[x] == false) {
        topologicalSortUtil(x, visited, stack, graph);
      }
    }
    stack.push(i);
  }

  public static HashMap<Integer, ArrayList<Integer>> createGraph(List<Integer> jobs, List<Integer[]> deps) {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

    for(int x: jobs) {
      graph.put(x, new ArrayList<Integer>());
    }

    for(Integer[] x : deps) {
      ArrayList<Integer> temp = graph.get(x[0]);
      temp.add(x[1]);
      graph.put(x[0], temp);
    }

    //System.out.println(graph);
    
    return graph;
  }
}

/*

 */

//Optimal Solution:

class Program2 {
  public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
    Map<Integer, Integer> counter = new HashMap<>();
    Map<Integer, List<Integer>> relation = new HashMap<>();


    for(int job: jobs) {
      counter.put(job, 0);
      relation.put(job, new ArrayList<>());
    }

    for(Integer[] dep: deps) {
      counter.put(dep[1], counter.get(dep[1]) + 1);
      relation.get(dep[0]).add(dep[1]);
    }

    List<Integer> temp = new ArrayList<>(jobs);
    List<Integer> result = new ArrayList<>();

    while(!temp.isEmpty()) {
      Set<Integer> freeJobs = new HashSet<>();

      for(int job: temp) {
        if(counter.get(job) == 0) {
          freeJobs.add(job);
        }
      }

      if(freeJobs.isEmpty()) return new ArrayList<>();

      for(int job: freeJobs) {
        result.add(job);
        temp.remove(Integer.valueOf(job));

        for(int post : relation.get(job)) {
          counter.put(post, counter.get(post) - 1);
        }
      }
    }
    
    return result;
  }
}
