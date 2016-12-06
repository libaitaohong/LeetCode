/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: deleteDuplicates
 * 作者: zhanghe
 * 时间: 2016/12/5 19:05
 * 题目:82. Remove Duplicates from Sorted List
 * 内容:Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 版本:
 * 运行时间:Runtime: 1 ms. Your runtime beats 15.20% of java submissions.
 * 备注:跟上一个版本相比，只是去掉了next节点
 */
public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else
                cur = cur.next;
        }
        return head;
    }
}
