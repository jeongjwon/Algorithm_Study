import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class Leetcode_238_ {

    public static int[] productExceptSelf(int[] nums) {
        // int mul = 1;
        // List<Integer> zeroIdx = new ArrayList<>();

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         // flag = false;
        //         zeroIdx.add(i);
        //         continue;
        //     }
        //     mul *= nums[i];
        // }
        // int[] res = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     if (zeroIdx.size() > 0) {//0이 있는 경우
        //         if(zeroIdx.size() == nums.length){
        //             // 모든 배열이 0인 경우
        //             System.out.println("모든 배열이 0인 경우");
        //             res[i] = 0;
        //         }else{
        //             if(nums[i] == 0){
        //                 //0인 요소만 mul
        //                 res[i] = mul;
        //             }else{
        //                 //나머지 요소는 0
        //                 res[i] = 0;
        //             }

        //         }
        //     } else {
        //         res[i] = mul / nums[i];
        //     }

        // }
        // return res;
        int n = nums.length;
        int[] toRight = new int[n];
        int[] toLeft = new int[n];
        int[] res = new int[n];

        int multiply = 1;

       for(int i = 0 ; i < n ; i++){
       
        multiply*= nums[i];
        toRight[i] = multiply;
       }
       multiply = 1;
       for(int i = n-1 ; i >= 0 ; i--){
       
        multiply *= nums[i];
        toLeft[i] = multiply;
       }

    //    for(int r : toRight) System.out.print(r + " ");
    //    System.out.println();

    //    for(int r : toLeft) System.out.print(r + " ");
    //    System.out.println();
        
        for(int i = 0 ; i < n ; i++){
            if(i==0){
                res[i] = toLeft[i+1];
            }
            else if(i == n-1){
                res[i] = toRight[i-1];
            }else{
                res[i] = toRight[i-1] * toLeft[i+1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] nums = { 0, 4, 0 };
        int[] nums = {1,2,3,4};
        // 1   2   3   4
        // 1   2   6  24
        // 24 24  12   4
        // 24  12  8  6
        int[] res = productExceptSelf(nums);
        for (int r : res)
            System.out.println(r);

    }

}