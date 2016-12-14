import java.util.LinkedList;
import java.util.List;

/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: LevelOrder
 * 作者: zhanghe
 * 时间: 2016/12/14 15:22
 * 题目:102. Binary Tree Level Order Traversal
 * 内容:Given a binary tree, return the level order traversal of its nodes' values.
 * 版本:1
 * 运行时间:
 * 备注:按行打印，按行输出
 * 左程云讲的版本
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allNode = new LinkedList<>();
        List<Integer> lineNode = new LinkedList<>();
        LinkedList<TreeNode> order = new LinkedList<>();
        if(root == null) return allNode;
        TreeNode lineLast = root;
        TreeNode curLast = root;
        order.add(root);
        while(order.size() != 0){
            TreeNode cur = order.remove();
            lineNode.add(cur.val);
            if(cur.left != null){
                order.add(cur.left);
                curLast = cur.left;
            }
            if(cur.right != null){
                order.add(cur.right);
                curLast = cur.right;
            }
            if(cur == lineLast){
                allNode.add(new LinkedList<>(lineNode));
                lineNode.clear();
                lineLast = curLast;
            }
        }
        return allNode;
    }
}
