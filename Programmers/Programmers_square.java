public class Programmers_square {
    public static long solution(int w, int h) {
        long answer = 1;
        
        //int  -> long: int -> String -> long  : Long.parseLong(String.valueOf())
        long wl = Long.parseLong(String.valueOf(w));
        long hl = Long.parseLong(String.valueOf(h));
        //최소공배수 -> LCM = 두 자연수의 곱 / 최대공약수 GCD
        //최대공약수 -> GCD 
        long n1 = (wl > hl) ? wl : hl;
        long n2 = (n1 == wl) ? hl : wl;

        long gcd = gcd(n1,n2); // 반복적으로 나타나는 갯수
        long cannot = gcd * (wl/gcd + hl/gcd -1); 
        // = w + h - gcd
        // 세트 수 * 한 세트에서 쓸 수 없는 사각형의 갯수(가로 세수를 각각 최대 공약수로 나눠준 값의 합 - 1 ) 
        
        answer = wl * hl - cannot;
        return answer;

        //return wl*hl - (wl+hl - gcd(n1,n2));
    }
    public static long gcd(long n1, long n2){
        if(n2 == 0 ) return n1;
        else return gcd(n2, n1%n2);
    }
    public static void main(String[] args){
        int w = 8;
        int h = 12;
        System.out.println(solution(w,h));
    }
}
