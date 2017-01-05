import java.util.HashSet;
import java.util.LinkedList;

/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: LengthOfLongestSubstring
 * 作者: zhanghe
 * 时间: 2016/12/30 16:29
 * 题目:3. Longest Substring Without Repeating Characters
 * 内容:求一个串的最长无重复子串
 * 版本:2
 * 运行时间:
 * 备注:建立一个数组长度256，用来存放所有字符
 * 首先设置开始为start=-1，数组里面的值也全是-1
 * 便利字符串，将字符串在数组中对应的位置设置为字符串下标
 * 如果发现数组中对应位置的字符串下标比start大，说明目前维护的字符串已经出现了该字符了
 * 所以让start等于这个字符串的位置，这时新的字符串的第一字符为start的下一个位置字符
 * 就相当于把重复字符去掉了，在重复字符的下一个字符处重新计算最长子串
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        int max = 0;
        int start = -1;
        int[] ss = new int[256];
        for(int i = 0; i < 256; i++)
            ss[i] = -1;
        for(int i = 0; i < s.length(); i++){
            if(ss[s.charAt(i)] > start)
                start = ss[s.charAt(i)];
            ss[s.charAt(i)] = i;
            max = Math.max(max, i-start);
        }
        return max;
    }
}
