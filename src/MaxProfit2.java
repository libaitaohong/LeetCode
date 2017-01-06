/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: MaxProfit2
 * 作者: zhanghe
 * 时间: 2017/1/6 22:02
 * 题目:122. Best Time to Buy and Sell Stock II
 * 内容:买卖股票，这次可以买卖多次，但是同一时间手里只能有一只股票，求最大利润，不计算成本
 * 版本:
 * 运行时间:
 * 备注:就是找到所有递增的一段，计算差值和
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int max = 0;
        int temp = 0;
        int b = 0;
        for(int s = 1; s < prices.length; s++){
            if(prices[s-1] > prices[s]){
                max += temp;
                temp = 0;
                b = s;
            }
            if(prices[s] < prices[b])
                b = s;
            else{
                temp = Math.max(temp,(prices[s] - prices[b]));
            }
        }
        if(temp!=0)
            max += temp;
        return max;
    }
}
