import java.util.*;
public class Leetcode_42_TrappingRainWater {
    public static int trap(int[] height) {

    	int n = height.length;
    	int sum = 0;

    	int max = Arrays.stream(height).max().getAsInt();
    	int max_idx = 0;
    	for(int i = 0 ; i < n ; i++) {
    		if(max == height[i]) max_idx = i;
    	}
    	int left = 0;
    	
    	for(int i = 0 ; i < max_idx ; i++) {
    		if(height[i] > left) left = height[i];
    		else sum += left - height[i];
    	}
    	int right = 0;
    	for(int i = n-1 ; i > max_idx ; i--) {
    		if(height[i] > right) right = height[i];
    		else sum += right - height[i];
    	}
    	return sum;

    }
    public static int trap_TP(int[] height) {
    	 int len = height.length;
         
       int l = 0;
       int r = len-1;  
       
       int l_max = Integer.MIN_VALUE;
       int r_max = Integer.MIN_VALUE;
       
       int sum = 0;      
       
       while(l < r){
           l_max = Math.max(l_max, height[l]);
           r_max = Math.max(r_max, height[r]);
           System.out.println(l + " = " + l_max + " , "+ r + " = " + r_max);
           if(l_max < r_max){
               sum += l_max - height[l];
               l++;
           }
           else{
               sum += r_max - height[r];
               r--;
           }
           System.out.println(sum);
       }
       return sum;
    }
}
