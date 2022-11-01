import java.util.*;

class Programmers_keepDistanceCheck {
    public static boolean bfs(int x, int y , String[] place){
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x,y});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int d = 0 ;d < 4; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(nx < 0 || ny < 0 || nx >=5 || ny >= 5 || (nx == x && ny == y)) continue;
                

                int dis = Math.abs(x - nx) + Math.abs(y-ny);
                //맨허튼 거리 

                if(dis <= 2 && place[nx].charAt(ny)=='P'){
                    return false;
                }else if(dis < 2 && place[nx].charAt(ny) == 'O'){
                    queue.add(new int[] {nx,ny});
                }
            }
        }
        return true;

    }
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        // for(int t = 0 ; t < places.length ; t++){
        //     String[] place = places[t];
        //     boolean flag=true;
        //     for(int i = 0 ; i < 5 && flag; i++){
        //         for(int j = 0 ;j < 5 && flag; j++){
        //             if(place[i].charAt(j) == 'P'){
        //                 if(!bfs(i,j,place)){
        //                     flag = false;
        //                 }
        //             }
        //         }
        //     }
        //     answer[t] = flag ? 1 : 0;
        // }
        
       
        for(int t = 0 ;t < places.length ; t++){
            String[] map = places[t];
            boolean flag = true;
            for(int i = 0 ; i < 5 && flag ; i++){
                for(int j = 0 ; j < 5 && flag; j++){
                    if(map[i].charAt(j) =='P'){
                        if(check(i,j,map)){//ture일경우 지키지 않음 0
                            flag = false;
                            break;
                        }
                    }
                }
                
                
            }
           
           
            answer[t] = flag ?  1: 0;
            
                
        }
        
        
        return answer;
    }
    public static boolean check(int x, int y, String[] map){
//  true -> 지키지 않음 
        //맨해튼 거리 기준
        //1 상하좌우에 파티션이나 빈자리에 있어야만 거리두기를 지킨 것 
        int[] dx1 = {0,0,-1,1};
        int[] dy1 = {1,-1,0,0};

        for(int i = 0 ; i < 4; i++){
            int nx = x + dx1[i];
            int ny = y + dy1[i];

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            if(map[nx].charAt(ny) == 'P'){
                return true;
            }
        }

        //2 길게 상하좌우 그 사이에 파티션만이 존재해야 거리두기를 지킨 것
        int[] dx2 = {0,0,-2,2};
        int[] dy2 = {2,-2,0,0};

        for(int i = 0 ; i < 4; i++){
            int nx = x + dx2[i];
            int ny = y + dy2[i];

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
          
            if(map[nx].charAt(ny) =='P'){
                if(map[(nx+x)/2].charAt((ny+y)/2) != 'X'){
                    return true;
                }
            }
            
        }

        //2 대각선 오상 오하 왼상 왼하 그 사이사이에 파티션이 있는 경우 거리두기를 지킨 것
        int[] dx3 = {1,1,-1,-1};
        int[] dy3 = {1,-1,1,-1};

        for(int i = 0 ; i < 4; i++){
            int nx = x + dx3[i];
            int ny = y + dy3[i];

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            if(map[nx].charAt(ny) == 'P'){
                if(!(map[nx].charAt(y) =='X' && map[x].charAt(ny)=='X')){
                    return true;
                }
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        String[][] places = 
        {
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] res = solution(places);

        for(int r : res){
            System.out.println(r);
        }
    }
}
