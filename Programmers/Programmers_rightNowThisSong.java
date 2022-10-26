import java.util.*;

class Programmers_rightNowThisSong {
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxTime = -1;
        m = change(m);

        for (int i = 0; i < musicinfos.length; i++) {
            String[] split = musicinfos[i].split(",");

            String[] start = split[0].split(":");
            String[] end = split[1].split(":");
            
            String song = split[2];
            String melody = split[3];

            //시간 변환
            int time = takeTime(start, end);

            //멜로디 변환
            melody = change(melody);

            // 플레이 시간 만큼 악보 만들어주기
            if (time > melody.length()) {
                StringBuilder newMelody = new StringBuilder();
                int quotient = time / melody.length();
                int remainder = time % melody.length();

                //몫만큼 반복
                for (int j = 0; j < quotient; j++) {
                    newMelody.append(melody);
                } //while 문 대신 for문 (시간 초과) 
                
                //나머지 만큼 이어주기
                newMelody.append(melody.substring(0, remainder));
                melody = newMelody.toString();
                //+= 대신 append 사용 (메모리 초과)
            } else if (time < melody.length()) {
                melody = melody.substring(0, time);
            }

            // m이 melody에 포함된다면
            if (melody.contains(m) && time > maxTime) {
                answer = song;
                maxTime = time;
            }

        }

        return answer == "" ? "(None)" : answer;
    }

    public static String change(String str) {

        str = str.replaceAll("C#", "H");
        str = str.replaceAll("D#", "I");
        str = str.replaceAll("F#", "J");
        str = str.replaceAll("G#", "K");
        str = str.replaceAll("A#", "L");

        return str;
    }

    public static int takeTime(String[] start, String[] end) {
        int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);

        return endTime - startTime;
    }

    public static void main(String[] args) {
        // String m = "ABCDEFG";
        // String[] musicinfos = { "12:00,12:14,HELLO,CDEFGAB",
        // "13:00,13:05,WORLD,ABCDEF" };
        // String m = "CC#BCC#BCC#BCC#B";
        // String[] musicinfos = { "03:00,03:30,FOO,CC#B",
        // "04:00,04:08,BAR,CC#BCC#BCC#B" };
        String m = "ABC";
        String[] musicinfos = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" };
        System.out.println(solution(m, musicinfos));
    }
}
