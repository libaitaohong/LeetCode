/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: RemoveDuplicate2
 * 作者: zhanghe
 * 时间: 2016/12/5 17:13
 * 题目:Remove Duplicates from Sorted Array II
 * 内容:Follow up for "Remove Duplicates":What if duplicates are allowed at most twice?
 * For example,Given sorted array nums = [1,1,1,2,2,3], Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 * 版本:1
 * 运行时间:Runtime: 2 ms。Your runtime beats 7.73% of java submissions.
 * 备注:
 */
public class RemoveDuplicate2 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1 || nums.length == 2) return nums.length;
        int sign = 0;
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] == nums[i]){
                count += 1;
                if(count > 1)
                    sign += 1;
            }else {
                count = 0;
            }
            if(sign != 0 && count <=1 )
                nums[i-sign] = nums[i];
        }
        return nums.length-sign;
    }
}
