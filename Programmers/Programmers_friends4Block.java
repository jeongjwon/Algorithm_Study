import java.util.*;
class Solution {
    
    
    static boolean[][] visited;
    
    public boolean check(int x, int y, char[][] map){
        
        if (map[x][y] == (map[x + 1][y]) && map[x][y] == (map[x + 1][y + 1]) && map[x][y] == (map[x][y + 1])) {
            return true;
        }

        return false;
    }
    
    public int relocate(char[][] map, int m, int n){
        int cnt = 0;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ;j++){
                //방문했다면 #으로 바꾸어줌
                if(visited[i][j]){
                    map[i][j] = '#';
                }
            }
        }
        
        
        
        Queue<Character> queue = new LinkedList<>();
        
        for(int j = 0; j < n  ; j++){
            for(int i = m-1 ; i >= 0 ; i--){
                if(map[i][j] == '#'){
                    //없어졌다면 지워진 수 증가
                    cnt++;
                }else{
                    //문자가 그대로 가면 queue에 저장
                    queue.add(map[i][j]);
                }
            }
            int idx = m-1;         
            
            while(!queue.isEmpty()){
                map[idx--][j] = queue.poll();
                //선입선출방식으로 다시 map 에 재배치

            }
            for(int i = idx ; i >= 0 ; i--){
                map[i][j] = '.';
                //비워진 부분은 . 으로 채우기
            }
        }
        return cnt;
    }
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] map = new char[m][n];
        
        //map에 재배치 시키기
        // for(int i = 0 ; i < m ; i++){
        //     for(int j = 0 ; j < n ; j++){
        //         map[i][j] = board[i].substring(j,j+1);
        //     }
        // }
        for(int i = 0 ; i < board.length ; i++){
            map[i] = board[i].toCharArray();
        }
        
        boolean flag = true;
        
        while(flag){
            visited = new boolean[m][n];
            flag = false;
            
            for(int i = 0 ; i < m-1 ; i++){
               
                for(int j = 0 ; j < n-1; j++){
                   
                    if(map[i][j] == '.') continue;
                    
                    if(check(i,j,map)){
                    //네 블록이 다 맞다면
                        
                        visited[i][j] = true;
                        visited[i+1][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j+1] = true;
                        flag = true;
                        
                    }
                }
                
            }
            answer += relocate(map,m,n);
            visited = new boolean[m][n];
            //재배치 되었으므로 다시 초기화
        }
        
        return answer;
    }
}
