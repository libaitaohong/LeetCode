import java.util.LinkedList;
import java.util.List;

/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: ZigzagLevelOrder
 * 作者: zhanghe
 * 时间: 2016/12/14 21:22
 * 题目:103. Binary Tree Zigzag Level Order Traversal
 * 内容:Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * 版本:1
 * 运行时间:
 * 备注:这个还是使用每次遍历一行的思想，只不过设置一个变量判定是从左向右还是从右向左
 * 在order链表里面，所有的数按顺序加入
 * 在node链表里，正序从队尾加入，反序从队头加入
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> allNode = new LinkedList<>();
        if(root == null) return allNode;
        LinkedList<TreeNode> order = new LinkedList<>();
        order.add(root);
        boolean lr = true;
        while(!order.isEmpty()){
            LinkedList<Integer> node = new LinkedList<>();
            int size = order.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = order.pop();
                if(lr)
                    node.add(cur.val);
                else
                    node.add(0, cur.val);
                if(cur.left != null)
                    order.add(cur.left);
                if(cur.right != null)
                    order.add(cur.right);
            }
            allNode.add(node);
            lr = lr? false : true;
        }
        return allNode;
    }
}
