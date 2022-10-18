import java.util.*;

public class Programmers_skillTree {

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        

        for (String str : skill_trees) {
            String temp = "";
            for (int i = 0; i < str.length(); i++) {
                String s = str.substring(i, i + 1);
                if (skill.contains(s)) {
                    temp += s;
                }
            }
            //문자를 skill에 있는 문자만 뽑음
           
            if (skill.indexOf(temp) == 0) {
                //그 문자가 무조건적으로 제일 첫문자를 습득해야지만 가능하기 때문에
                //indexOf() == 0 이어야 가능함!
                answer++;
            }
        }

        return answer;
    }



    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
        System.out.println(solution(skill, skill_trees));
    }

}
