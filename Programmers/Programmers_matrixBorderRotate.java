import java.util.*;

class Programmers_matrixBorderRotate {
    static int[][] map ;
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        map = new int[rows][columns];
        int value = 1;
        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j <columns ; j++){
                map[i][j] = value++;
            }
        }
        
        answer = new int[queries.length];

        for(int i = 0 ; i < queries.length ; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int c = queries[i][2];
            int d = queries[i][3];
            answer[i] = refresh(a-1,b-1,c-1,d-1);

        }
        return answer;
    }
    public static int refresh(int a, int b, int c, int d){
        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        int temp = map[a][b];

        for(int i = a; i < c ; i++){
            map[i][b] = map[i+1][c];
            min = Math.min(map[i][b], min);
        }
        for(int i = b ; i < d ; i++){
            map[c][i] = map[c][i+1];
            min = Math.min(map[c][i], min);
        }
        for(int i = c; i > a; i--){
            map[i][d] = map[i-1][d];
            min = Math.min(map[i][d], min);
        }
        for(int i = d ; i > b ; i--){
            
            map[a][i] = map[a][i-1];
            min = Math.min(map[a][i], min);
            
            
        }
        
        map[a][b+1] = temp;
        min = Math.min(min, temp);
        
       return min;


    }
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = { {2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
        int[] res = solution(rows, columns, queries);
        for(int r : res){
            System.out.println(r);
        }
    }
}
