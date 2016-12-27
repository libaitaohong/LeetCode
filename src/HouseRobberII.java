/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: HouseRobberII
 * 作者: zhanghe
 * 时间: 2016/12/27 15:26
 * 题目:213. House Robber II
 * 内容:小偷偷东西，房子呈环形，相邻不能偷，求最多偷多少
 * 版本:
 * 运行时间:
 * 备注:分成两种情况，一种是偷第一家，一种是偷最后一家
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int cur1 = robW(nums, 0, nums.length-2);
        int cur2 = robW(nums, 1, nums.length-1);
        return Math.max(cur1, cur2);
    }
    public int robW(int[] nums, int l, int r){
        int pre = 0;
        int cur = 0;
        for(int i = l; i <= r; i++){
            int temp = pre;
            pre = cur;
            if(temp+nums[i] > cur){
                cur = temp+nums[i];
            }
        }
        return cur;
    }
}
