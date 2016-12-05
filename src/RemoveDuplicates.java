/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: RemoveDuplicates
 * 作者: zhanghe
 * 时间: 2016/12/5 16:29
 * 题目:26 Remove Duplicates from Sorted Array
 * 内容:Given a sorted array, remove the duplicates in place such that each element appear only
 * once and return the new length.Do not allocate extra space for another array,
 * you must do this in place with constant memory.
 * For example,Given input array nums = [1,1,2],Your function should return length = 2,
 * with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 * 版本:
 * Runtime: 13 ms
 * 备注:删除排序数组里的重复数字
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int sign = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] == nums[i]){
                sign += 1;
            }else if(sign != 0){
                nums[i-sign] = nums[i];
            }
        }
        return nums.length-sign;
    }
}
