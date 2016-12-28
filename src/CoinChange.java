/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: CoinChange
 * 作者: zhanghe
 * 时间: 2016/12/28 9:58
 * 题目:322. Coin Change
 * 内容:给定数组里面是几种硬币面额，amount是需要的钱数，找到组成这个钱数使用硬币最小的个数
 * 版本:
 * 运行时间:
 * 备注:这是典型的动态规划，背包问题
 * 设置dp[i][j]是使用前i个硬币，组成钱数j需要的硬币数。
 * 分成两种情况来计算，
 * 一种是不使用硬币i，这时需要的硬币数是dp[i-1][j]，就是前i-1个硬币组成j的最小硬币数
 * 一种是至少使用一次硬币，需要的硬币数是dp[i][j-coins[i]]+1，dp[i][j-coins[i]]就是使用前i个硬币，
 * 组成的价值是j减当前硬币的价值，因为当前要求的价值是j，又要加上硬币i，才达到价值j。
 * 所以要到达价值j，必须至少使用一次硬币i，所以硬币数还需要dp[i][j-coins[i]]加上1个，表示这个价值为i的硬币。
 * 因为要求最少硬币数，所以dp[i][j] = min(dp[i-1][j] , dp[i][j-coins[i]]+1)
 *
 * 在本题中，没有使用二维数组，仅使用一维数组就可以了。
 * 设置数组dp[j],dp代表组成价值j需要的最少硬币数
 * 设置dp[0] = 0，其余值设置为最大。因为需要找数组中两个值较小的那个，若不初始化设置为最大，就会出错
 * 在遍历时，使用两个for，相当于二维数组中的按行遍历数组。
 * 在dp中，下标j前面的数已经更新成新的一行，相当于dp[i][];j及后面的数还是上一行的数据，即dp[i-1][]
 * 在更新dp[j]时需要主要一些细节：
 *   1. 由于将数组初始化为整形最大值，在有时硬币不能组成目标价值时，dp[j-coins[i]]的值为Integer.MAX_VALUE;
 *      可以这么理解，dp[j-coins[i]]的值为Integer.MAX_VALUE，说明前i个硬币不能组成价值j-coins[i]，那么再加上
 *      当前硬币也同样不能组成价值j，所以这种情况就不需要更新dp[j]。若最后结果也为最大值，返回-1.
 *   2. 在硬币i的面值小于价值j时，这是就是属于dp[i][j] = dp[i-1][j]的情况，所以不更新dp[j];
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || amount < 0) return -1;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i] <= j){
                    if(dp[j-coins[i]] != Integer.MAX_VALUE)
                        dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
}
