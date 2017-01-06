/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: MaxProfit
 * 作者: zhanghe
 * 时间: 2017/1/6 20:12
 * 题目:121. Best Time to Buy and Sell Stock
 * 内容:数组代表股票每天的价值，找到买入和卖出后获得的最大价值
 * 版本:
 * 运行时间:
 * 备注:设置两个变量b买入和s卖出，s从第二个数遍历数组
 * 如果s比b小，设置b=s，否则记录max = s-b和max的较大值
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int max = 0;
        int b = 0;
        for(int s = 1; s < prices.length; s++){
            if(prices[s] < prices[b]){
                b = s;
            }else{
                max = Math.max((prices[s] - prices[b]), max);
            }
        }
        return max;
    }
}
