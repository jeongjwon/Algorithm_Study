import java.util.*;

public class Programmers_fileNameSorting {
    static class File {
        String name;
        String head;
        int number;

        public File(String name, String head, int number) {
            this.name = name;
            this.head = head;
            this.number = number;
        }

    }

    public static String[] solution(String[] files) {
        String[] answer = {};
        // head number tail

        File[] f = new File[files.length];

        for (int i = 0; i < files.length; i++) {
            String h = ""; // 숫자 전 앞 문자만
            String n = ""; // 숫자만
            for (char c : files[i].toCharArray()) {
                if (c >= '0' && c <= '9') {
                    n += c;
                } else {
                    if (!n.equals("")) {
                        break;
                    } else {
                        h += c;
                    }
                }
            }
            //File 에 본 문자, 대문자로 변형된 h, 숫자로 변형된 n
            f[i] = new File(files[i], h.toUpperCase(), Integer.parseInt(n));
        }

        
        Arrays.sort(f, new Comparator<File>() {
            public int compare(File f1, File f2) {
                if ((f1.head).equals(f2.head)) {
                    //두번째 기준 - 머리 부분이 같다면 숫자로 오름차순
                    return f1.number - f2.number;
                } else {
                    //첫번째 기준 - 머리 부분 사전순
                    return (f1.head).compareTo(f2.head);
                }
            }
        });

        answer = new String[files.length];
        for (int i = 0; i < f.length; i++) {
            answer[i] = f[i].name;
        }

        return answer;
    }

    public static void main(String[] args) {

        // String[] files = { "img12.png", "img10.png", "img02.png", "img1.png",
        // "IMG01.GIF", "img2.JPG" };
        String[] files = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" };
        String[] res = solution(files);
        for (String r : res) {
            System.out.println(r);
        }
    }

}
