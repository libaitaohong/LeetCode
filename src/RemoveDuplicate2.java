/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: RemoveDuplicate2
 * 作者: zhanghe
 * 时间: 2016/12/6 16:24
 * 题目:80. Remove Duplicates from Sorted Array II
 * 内容:Follow up for "Remove Duplicates":What if duplicates are allowed at most twice?
 * For example,Given sorted array nums = [1,1,1,2,2,3], Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 * 版本:1
 * 运行时间:Runtime: 1 ms。Your runtime beats 31.85% of java submissions.
 * 备注:不再用sign记录有几个重复值，而使用k来管理下标
 */
public class RemoveDuplicate2 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int k = 1;
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] == nums[i]){
                count += 1;
            }else{
                count = 0;
            }
            if(count <= 1)
                nums[k++] = nums[i];
        }
        return k;
    }
}
