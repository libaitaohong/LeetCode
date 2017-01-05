import java.util.HashSet;
import java.util.LinkedList;

/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: LengthOfLongestSubstring
 * 作者: zhanghe
 * 时间: 2016/12/30 16:29
 * 题目:3. Longest Substring Without Repeating Characters
 * 内容:求一个串的最长无重复子串
 * 版本:1
 * 运行时间:
 * 备注:使用set。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        int max = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return max;

    }
}
