import java.util.Stack;

public class Leetcode_42_Trapping_Rain_Water {
    public static int trap(int[] height) {
        // int rain = 0;
        // Stack<Integer> stack = new Stack<>();
       
        // for(int i = 0 ; i < height.length ; i++){
        //     //peek 보다 높을 값이 들어오기 전까지 == 작은 값들이 들어오면 , 
        //     while(!stack.isEmpty() && stack.peek() > height[i]){
        //         System.out.println("뺄 값 "+ stack.peek());
        //         System.out.println("추가할 rain 값 "+ (stack.peek()-height[i]));
        //         rain += stack.peek()-height[i];
        //         // rain += height[i]-stack.peek();
        //         // stack.pop();
        //     }
          
            
           
        //     stack.push(height[i]);
        // }
        // StringBuilder sb = new StringBuilder();
        // for(int n : stack){
        //     sb.append(n);
        // }
        // System.out.println(sb.toString());
        // return rain;

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0; i<height.length; i++){
            System.out.println(" height["+i+"] = "+height[i]);

            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                
                if(stack.isEmpty()){
                    break;
                }
                int width = i - stack.peek() - 1;
                int h = Math.min(height[i], height[stack.peek()]) - height[top];
                System.out.println("  top : "+top + " width : "+width + " h : " + h + " => 넓이 : "+(width*h));
                ans += h * width;

            }
            System.out.println();
            stack.push(i);
        }
        return ans;

      
    }
    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        // int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}
