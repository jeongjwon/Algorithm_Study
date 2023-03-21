import java.util.*;

class Programmers_2023_Lv1_personalInformation {
    public static int[] solution(String today, String[] terms, String[] privacies) {
       
        int[] infos = new int[privacies.length];
        int idx = 0;

        HashMap<String, Integer> hm = new HashMap<>();
        for(String term : terms){
            String[] str = term.split(" ");
            hm.put(str[0], Integer.parseInt(str[1]));
        }
        //map을 이용해 기간을 가져오기 쉽게 만든다


        for(String privacy : privacies){
            String[] temp = privacy.split(" ");
            
            
            String day = temp[0].replace(".","");
            int y = Integer.parseInt(day.substring(0, 4));
            int m = Integer.parseInt(day.substring(4, 6));
            int d = Integer.parseInt(day.substring(6, 8));
           
            String type = temp[1];
            int term = hm.get(temp[1]);
            
            m = m+term;
            d -= 1;
            if(d == 0){
                d = 28;
                m -= 1;
            }
            if(m > 12){
                m -= 12;
                y += 1;
            }
            
            infos[idx++] = y * 12 * 28 + m * 28 + d;
            //날짜 계산을 쉽게 하기 위함

            
        }

        today = today.replace(".", "");
        int y = Integer.parseInt(today.substring(0, 4));
        int m = Integer.parseInt(today.substring(4, 6));
        int d = Integer.parseInt(today.substring(6, 8));
       
        int cur = y * 12 * 28 + m * 28 + d;

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < infos.length ; i++){
            if(cur > infos[i]){ list.add(i+1); }
        }

       
        int[] answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
    public static void main(String[] args) {
        String today = "2020.01.01";
        //"2022.05.19";
        String[] terms = {"Z 3", "D 5"};
        //{"A 6", "B 12", "C 3"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        //{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        
        int[] res = solution(today,terms, privacies);
        for(int r : res) System.out.println(r);
        }
}