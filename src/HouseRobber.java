/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: HouseRobber
 * 作者: zhanghe
 * 时间: 2016/12/26 18:51
 * 题目:198. House Robber
 * 内容:就是强盗偷房子，每个房子有自己的钱，不能偷相邻的房子，如何偷才能偷得最多
 * 版本:
 * 运行时间:
 * 备注:用动态规划，思想就是若当前房子是最后一个房子，最多能偷多少。
 * 用当前房子的价值+第i-2个房子位置的最大价值
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length <= 0) return 0;
        if(nums.length == 1) return nums[0];
        int premax = nums[0]; // 以i-2位置为结尾的最大价值
        int curmax = (nums[0] > nums[1]) ? nums[0] : nums[1]; // 以i-1位置为结尾的最大价值
        for(int i = 2; i < nums.length; i++){
            if(nums[i]+premax > curmax){
                int temp = premax;
                premax = curmax;
                curmax = nums[i] + temp;
            }else {
                premax = curmax;
            }
        }
        return curmax;
    }
}
