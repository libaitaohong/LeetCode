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
 * Runtime: 13 ms. Your runtime beats 75.00% of java submissions.
 * 备注:删除排序数组里的重复数字
 * 利用排好序的数组，后面的数不是比前面大就是相等来添加元素
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >nums[k])
                nums[++k] = nums[i];
        }
        return k + 1;
    }
}
