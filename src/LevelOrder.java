import java.util.LinkedList;
import java.util.List;

/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: LevelOrder
 * 作者: zhanghe
 * 时间: 2016/12/14 15:22
 * 题目:102. Binary Tree Level Order Traversal
 * 内容:Given a binary tree, return the level order traversal of its nodes' values.
 * 版本:2
 * 运行时间:
 * 备注:按行打印，按行输出
 * 每次遍历一层，不需要记录每层最后一个节点。但是时间复杂度一样的
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allNode = new LinkedList<>();
        LinkedList<TreeNode> order = new LinkedList<>();
        if(root == null) return allNode;
        order.add(root);
        while(order.size() != 0){
            List<Integer> lineNode = new LinkedList<>();
            int size = order.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = order.remove();
                lineNode.add(cur.val);
                if(cur.left != null)
                    order.add(cur.left);
                if(cur.right != null)
                    order.add(cur.right);
            }
            allNode.add(lineNode);
        }
        return allNode;
    }
}
