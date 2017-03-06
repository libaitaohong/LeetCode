/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: SingleNumber
 * 作者: zhanghe
 * 时间: 2017/3/6 15:20
 * 题目:136. Single Number
 * 内容:Given an array of integers, every element appears twice except for one. Find that single one.
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 版本:
 * 运行时间:
 * 备注:使用异或，相同为0，不同为1.从头到尾异或一遍，剩下的就是唯一的一个单身狗
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int i = 0; i < nums.length; i++){
            a = a^nums[i];
        }
        return a;
    }
}
