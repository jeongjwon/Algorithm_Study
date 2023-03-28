public class Leetcode_121_Best_Time_to_Buy_and_Sell_Stock {
    public static int maxProfit(int[] prices) {
        //사고팔기 좋은 시점
        //낮은 데서 높은 곳 
        // int result = 0;
        // int max = Integer.MIN_VALUE;

        // for(int i = 0 ; i < prices.length ; i++){
        //     int sum = 0;
            
        //     for(int j = i+1 ; j < prices.length ; j++){
        //         sum = -1 * prices[i] + prices[j];
        //         if(max < sum){
        //             max = sum;
        //         }

        //     }
        // }
        
        // return result > max ? result : max;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int price : prices){

            min = Math.min(price,min);//살 시점 => 가장 작은 값
            max = Math.max(price - min, max); //현재 -min + price =  수익 => 가장 큰 값
            System.out.println(min +" "+ max);
        }
        return max;
    
    }
    public static void main(String[] args){
        // int[] prices = { 7,1,5,3,6,4 };
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
