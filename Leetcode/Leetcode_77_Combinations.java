import java.util.*;
public class Leetcode_77_Combinations {
    static List<List<Integer>> answer = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
       int[] arr = new int[n];
       for(int i = 0; i < n ; i++) arr[i] = i+1;

       boolean[] visited = new boolean[n];
      
       combination(arr,visited, 0,  0, k);
       

        return answer;
    }
    public static void combination(int[] arr, boolean[] visited, int start, int depth, int k){
        System.out.println();
        System.out.println("combination(arr,"+start + " , "+depth + " , " + k+ ")");
        if(depth == k){
            for(int i = 0 ; i <arr.length ; i++){
                if(visited[i]) list.add(arr[i]);
            }
            System.out.println(list);
            answer.add(list);
            list = new ArrayList<>();
            return ;
        }
        for(int i = start ; i < arr.length ; i++){
            System.out.println("i  : "+i);
            if(!visited[i]){
                visited[i] = true;
                combination(arr, visited, i+1, depth+1, k);
                visited[i] = false;
                
                for(int j = 0 ; j < arr.length ; j++) System.out.print(visited[j] + " ");
            }
            System.out.println();
        }
       
        
    }
    public static void main(String[] args){
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combine(n, k);
        for(List<Integer> res : result){
            // for(int num : res){
            //     System.out.print(num + " ");
            // }
            // System.out.println();
            System.out.println(res);
        }
    }
}
