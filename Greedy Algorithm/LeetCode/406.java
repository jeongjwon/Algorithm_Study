package Greedy_Algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode406_Queue_Reconstruction_by_Height {
	public static int[][] reconstructQueue(int[][] people) {
		int[][] queue = new int[people.length][2];
		//비교해야할 것은 키와 수 
		// 키를 먼저 비교하고 자신보다 큰 사람의 수를 세고 그 뒤로 넣어줌
		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
		//값이 같으면 뒷값으로 오름차순, 다르면 앞값으로 내림차순
		//(7,0)(7,1)(6,1)(5,0)(5,2)(4,4)
		//(5,0)(7,0)(5,2)(6,1)((4,4)(7,1)
		
		List<int[]> list = new LinkedList<>();
		for(int i = 0 ; i < people.length ; i++) {
			list.add(people[i][1], people[i]);
		}
		
		return list.toArray(new int[list.size()][]);
	}


	public static void main(String[] args) {
		//people[i] = [h,k]
		//i번째 height높이보다 같거나 큰 사람이 k명
		int[][] people = { {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2} };
		int[][] res = reconstructQueue(people);
		for(int i = 0 ; i < res.length ; i++) {
			System.out.println(res[i][0] +","+res[i][1]);
			
		}
		//(5,0)(7,0)(5,2)(6,1)(4,4)(7,1)
	}
  //머리로 생각하는 것은 꽤나 쉬운데 이런 과정을 코드로 옮기는 것이 꽤나 복잡했다
  //특히 정렬 후 재정렬하는 부분에서 인덱스를 이용한다는 점이 핵심이다.
}
