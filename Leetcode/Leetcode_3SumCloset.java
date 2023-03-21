import java.util.*;

public class Leetcode_3SumCloset {
    public static int threeSumCloset(int[] nums, int target) {
        int sum = 0;
        Arrays.sort(nums);
        // -4 -1 1 2 0

        for (int num : nums) {
            sum += num;
        }

        if (sum > target) {
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;
        System.out.println(threeSumCloset(nums, target));
    }
}