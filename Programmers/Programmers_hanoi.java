import java.util.ArrayList;

public class Programmers_hanoi{
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

    public static int[][] solution(int n){
       
        int start = 1;
        int to = 3;
        int mid = (start+to)/2;
        hanoi(n, start, to, mid);
        
        int[][] answer = new int[list.size()][2];
        // System.out.println(list);

        for(int i = 0 ; i < list.size() ; i++){
            answer[i][0] = list.get(i).get(0);
            answer[i][1] = list.get(i).get(1);
        }
       
        return answer;

    }
    static void hanoi(int n, int start, int to, int mid){
        if(n==0) return;
        
       hanoi(n-1, start, mid, to);
    //    System.out.println("원반 "+ n + "개를 " + start +"에서 " + to +  "로 옮김");
    
       ArrayList<Integer> l = new ArrayList<Integer>();
       l.add(start);
       l.add(to);
       list.add(l);
    //    System.out.println(l);
       hanoi(n-1, mid, to, start);
    }
    public static void main(String[] args){
        int n = 2;
        int[][] result = solution(n);
        for(int i = 0 ; i < result.length ; i++){
            System.out.println(result[i][0] + " "+ result[i][1]);

        }
        
    }
}
