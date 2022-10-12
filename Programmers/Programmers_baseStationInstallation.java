import java.util.*;

public class Programmers_baseStationInstallation {

    public static int binarySearch(int start, int end, int w) {
        int res = (end - start + 1) / (w * 2 + 1);
        if ((end - start + 1) % (w * 2 + 1) > 0)
            res++;
        return res;
        // return (end-start +1) / (w*2+1) + (end-start+1) % (w*2+1);
        // 몫과 나머지를 합한 값을 return 하려고 했는데 실패
        // -> 나머지를 다 더한 값이 하니라 1씩만 올려주기
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;

        //이분탐색
        int start = 1;
        int end = n;

        for (int i = 0; i < stations.length; i++) {
            // start와 전파되는 앞까지
            if (start < stations[i] - w) {
                answer += binarySearch(start, stations[i] - w - 1, w);
            }
            start = stations[i] + w + 1; // start 땡겨주고

        }
        // 나머지 끝 부분
        if (stations[stations.length - 1] + w < end) {
            answer += binarySearch(stations[stations.length - 1] + w + 1, end, w);
        }
        
      
      //이분탐색 x -> location으로 선형 쭉
        int idx = 0;
        int location = 1;
        while (location <= n) {
            if (idx < stations.length && location >= stations[idx] - w) {
                //기지국 안의 범위에 들어왔을 때는 location을 다음으로 넘겨줌
                location = stations[idx] + w + 1;
                idx++;
            } else {
                //기지국 밖의 범위에 들어왔을 때는 location을 2w+1 만큼 거리를 벌어주고 
                //기지국을 설치함 (==answer++)
                location += w * 2 + 1;
                answer++;
            }
        }
      
      
      
        return answer;
    }

    public static void main(String[] args) {
        // int n = 11;
        // int[] stations = { 4, 11 };
        // int w = 1;
        int n = 16;
        int[] stations = { 9 };
        int w = 2;
        System.out.println(solution(n, stations, w));

    }

}
