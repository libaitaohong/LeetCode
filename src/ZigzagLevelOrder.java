import java.util.LinkedList;
import java.util.List;

/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: ZigzagLevelOrder
 * 作者: zhanghe
 * 时间: 2016/12/14 21:22
 * 题目:103. Binary Tree Zigzag Level Order Traversal
 * 内容:Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * 版本:2
 * 运行时间:
 * 备注:更喜欢版本一，非常简单，实现起来也不需要如此多的辅助变量
 * 左程云讲的，每次while遍历一个节点，有些麻烦
 * 要设置每一行的最后一个节点就是第一个加入的节点，从左向右行的孩子按顺序加入队列
 * 从右向左行的孩子，先遍历右孩子从队列头加入，再遍历左孩子从队列头加入
 * 每次都要判断nlast是不是=null，若是则设置nlast为第一个节点。
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> allNode = new LinkedList<>();
        if(root == null) return allNode;
        LinkedList<TreeNode> order = new LinkedList<>();
        LinkedList<Integer> node = new LinkedList<>();
        order.add(root);
        TreeNode last = root;
        TreeNode nlast = null;
        TreeNode cur = null;
        boolean lr = true;
        while(!order.isEmpty()){
            if(lr){
                cur = order.remove(0);
                node.add(cur.val);
                if(cur.left != null){
                    nlast = nlast == null ? cur.left : nlast;
                    order.add(cur.left);
                }
                if(cur.right != null){
                    nlast = nlast == null ? cur.right : nlast;
                    order.add(cur.right);
                }
            }else{
                cur = order.remove(order.size()-1);
                node.add(cur.val);
                if(cur.right != null){
                    nlast = nlast == null ? cur.right : nlast;
                    order.add(0, cur.right);
                }
                if(cur.left != null){
                    nlast = nlast == null ? cur.left : nlast;
                    order.add(0, cur.left);
                }
            }
            if(cur == last){
                allNode.add(new LinkedList<>(node));
                lr = lr? false : true;
                last = nlast;
                nlast = null;
                node.clear();
            }
        }
        return allNode;
    }
}
