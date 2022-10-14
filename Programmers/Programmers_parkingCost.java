import java.util.*;

public class Programmers_parkingCost {
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        ArrayList<String> cars = new ArrayList<>();// 차량 list
        HashMap<String, Integer> parking = new HashMap<>();// 주차장
        HashMap<String, Integer> times = new HashMap<>();// 누적 시간

        for (String record : records) {
            String[] rc = record.split(" ");
            String hm = rc[0];
            String car = rc[1];
            String state = rc[2];
            int time = Integer.parseInt(hm.split(":")[0]) * 60 + Integer.parseInt(hm.split(":")[1]);

            if (state.equals("IN")) {

                if (!times.containsKey(car)) {
                    // 처음 들어온 차라면
                    times.put(car, 0);
                }
                parking.put(car, time);

            } else if (state.equals("OUT")) {
                // 출차라면 누적시간이 계산 된 times에 이번 주차장에 parking 된 시간을 누적 합으로 저장
                // 주차장에서 아웃
                times.put(car, times.get(car) + (time - parking.get(car)));
                parking.remove(car);

            }
            if (!cars.contains(car))
                cars.add(car);
        }

        if (!parking.isEmpty()) {
            // 주차장에 아직 차가 남아있다면
            for (String car : parking.keySet()) {
                times.put(car, times.get(car) + (23 * 60 + 59) - parking.get(car));
            }
        }

        // System.out.println(cars);
        // System.out.println(parking);
        // System.out.println(times);

        Collections.sort(cars);
        answer = new int[cars.size()];
        int idx = 0;

        for (String car : cars) {
            for (String key : times.keySet()) {

                int price = 0;
                if (car.equals(key)) {
                    if (times.get(key) <= fees[0]) {
                        price = fees[1];
                    } else {
                        price = (fees[1]
                                + (int) Math.ceil((double) (times.get(key) - fees[0]) / (double) fees[2]) * fees[3]);
                    }
                    answer[idx++] = price;
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] fees = { 180, 5000, 10, 600 };
        String[] records = {
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT" };
        // int[] fees = {
        // 120,
        // 0,
        // 60,
        // 591
        // };
        // String[] records = {
        // "16:00 3961 IN",
        // "16:00 0202 IN",
        // "18:00 3961 OUT",
        // "18:00 0202 OUT",
        // "23:58 3961 IN"
        // };
        // int[] fees = { 1, 461, 1, 10 };
        // String[] records = {
        // "00:00 1234 IN"
        // };

        int[] res = solution(fees, records);
        for (int r : res)
            System.out
                    .println(r);
    }

}
