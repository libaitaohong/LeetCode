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
 * Runtime: 14 ms. Your runtime beats 55.48% of java submissions.
 * 备注:删除排序数组里的重复数字
 * 不再用sign记录有几个重复值，而使用k来管理下标。当前值与下一个值比较，不等则添加新值
 * 最后将数组最后一个值添加进去，因为循环时没有便利到最后一个值，而无论前面有没有重复，最后一个值
 * 都是要加进数组的。
 * 表示下标，所以最后返回k+1代表数组中有效值的个数
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int k = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i+1]){
                nums[k++] = nums[i];
            }
        }
        nums[k] = nums[nums.length-1];
        return k+1;
    }
}
