/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: SingleNumbeIII
 * 作者: zhanghe
 * 时间: 2017/3/6 20:14
 * 题目:260. Single Number III
 * 内容:Given an array of numbers nums, in which exactly two elements appear only once and all
 * the other elements appear exactly twice. Find the two elements that appear only once.
 * For example: Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 版本:
 * 运行时间:
 * 备注:首先所有数组异或，得到的数是单独的两个数的异或结果
 * 然后找到这个结果的最后一个1的位置，在这个位置，这两个数的值不同。
 * 根据这个值把数组分为两类，这一位为1和0，同时这两个单独的数也分别在这两组中
 * 把这两组中的数分别异或，每一组得到的结果就是所求的数
 */
public class SingleNumbeIII {
    public int[] singleNumber(int[] nums) {
        int a = 0;
        for(int i = 0; i < nums.length; i++){
            a = a^nums[i];
        }
        int b = a &(~a + 1);
        int c = 0;
        int d = 0;
        for(int i = 0; i < nums.length; i++){
            if((b & nums[i]) == 0)
                c = c^nums[i];
            else
                d = d^nums[i];
        }
        int[] res = new int[2];
        res[0] = c;
        res[1] = d;
        return res;
    }
}
