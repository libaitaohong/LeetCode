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
 * 备注:i为有效值当前下标，j遍历数组
 * nums[i]不是有效值，nums[i-1]才是最后添加的有效值
 * 因为可以最多放两个一样的，所以前两个肯定有效，所以条件i<2时有效
 * 当前遍历的值nums[j]，比有效值的倒数第二个就是nums[i-2]大的话，说明没有连续三个一样，
 * 这时不管是不是当前值与nums[i-1]相同，都把当前值插入到有效值中。
 */
public class RemoveDuplicate2 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(i < 2 || nums[j] > nums[i-2])
                nums[i++] = nums[j];
        }
        return i;
    }
}
