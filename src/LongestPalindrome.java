/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: LongestPalindrome
 * 作者: zhanghe
 * 时间: 2017/1/5 21:06
 * 题目:5. Longest Palindromic Substring
 * 内容:最长回文
 * 版本:1
 * 运行时间:
 * 备注:利用回文结构。回文有奇数和偶数两种类型，所以找到中间那两个或一个，向外展开
 * 注意下标，max实际比最长回文的长度要小一个
 * left是最长回文子串的第一个字符
 */
public class LongestPalindrome {
    private int left = 0;
    private int max = 0;
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        for(int i = 0; i < s.length()-1; i++){
            getLongest(i, i, s);
            getLongest(i, i+1, s);
        }
        return s.substring(left, left + max);
    }
    public void getLongest(int l, int r, String s){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        if(max < r-l-1){
            max = r-l-1;
            left = l+1;
        }
    }
}
