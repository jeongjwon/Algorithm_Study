
public class SkillCheck3 {
    // 우선순위 큐 이용
    // static class cpu {
    // int index, time;

    // public cpu(int index, int time) {
    // this.index = index;
    // this.time = time;
    // }
    // }

    // public static int solution(int n, int[] cores) {
    // int answer = 0;
    // if (n <= cores.length) {
    // return n;
    // }
    // n -= cores.length;
    // System.out.println("n : " + n);
    // PriorityQueue<cpu> pq = new PriorityQueue<>((o1, o2) -> {
    // if (o1.time == o2.time) {
    // return o1.index - o2.index;
    // }
    // return o1.time - o2.time;
    // // 우선순위 큐를 이용하여
    // // 처리시간 순으로 정렬하되,
    // // 그 시간이 같다면 index가 작은 순으로
    // });
    // for (int i = 0; i < cores.length; i++) {
    // pq.add(new cpu(i, cores[i]));
    // }

    // int time = 1;
    // while (n > 0) {
    // //작업물을 모두 처리할 때 까지

    // cpu cur = pq.poll();
    // System.out.println("cur : " + cur.index + " , " + cur.time + " , time : " +
    // time);

    // if (cur.time == time) {
    // // 현재 시간과 다음 처리 시간이 같은 경우 작업물 완료
    // n--;
    // } else if (cur.time > time) {
    // //현재시간보다 다음처리가 더 큰 경우는 현재시간을 다음으로
    // time = cur.time;
    // n--;
    // }

    // if (n == 0) {
    // // 작업이 모두 완료가 되면 인덱스 +1 로 리턴
    // answer = cur.index + 1;
    // } else {
    // // 작업이 남을 경우
    // // 사용한 cpu 의 다음 시간을 추가
    // System.out.println("추가할 값 : " + cur.index + " / " + time + " +" +
    // cores[cur.index]);
    // pq.add(new cpu(cur.index, time + cores[cur.index]));
    // }
    // }

    // return answer;
    // }
    public static int solution(int n, int[] cores) {
        int answer = 0;

        int min = 0;
        int max = cores[0] * n;

        int time = 0;
        int rest = 0;

        while (min <= max) {
            int mid = (min + max) / 2;

            int count = countWork(mid, cores);

            System.out.println("mid : " + mid + "  , max : " + max + " , count : " + count);

            if (count >= n) {
                max = mid - 1;
                time = mid;
                rest = count;
            } else {
                min = mid + 1;
            }
        }

        rest -= n;
        System.out.println("rest : " + rest);
        for (int i = cores.length - 1; i >= 0; i--) {
            if (time % cores[i] == 0) {
                if (rest == 0) {
                    answer = i + 1;
                    break;
                    // 남은 작업량이 없을 때 다음 인덱스값을 전달하고 종료
                }
                // 시간이 0일 때 남은 작업량을 줄여줌
                rest--;
            }
        }

        return answer;
    }

    public static int countWork(int time, int[] cores) {
        if (time == 0) {
            return cores.length;
        }

        int count = cores.length;

        for (int i = 0; i < cores.length; i++) {
            count += (time / cores[i]);
        } // time 까지 처리할 수 있는 작업량 합산
        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] cores = { 1, 2, 3 };
        System.out.println(solution(n, cores));
    }
}
