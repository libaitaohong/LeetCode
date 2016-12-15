import java.util.LinkedList;
import java.util.List;

/**
 * 工程: LeetCode 包名: PACKAGE_NAME 类名: PathSum
 * 作者: zhanghe
 * 时间: 2016/12/15 19:40
 * 题目:113. Path Sum II
 * 内容:Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 版本: 1
 * 运行时间:
 * 备注:前序遍历，进入递归函数首先判断是不是叶子节点，若是则是否totle==sum。
 * 跳出当前节点需要将链表里最后一位删掉
 * 注意往allPath里面添加数据时，新建一个链表，而不是直接把path链表加入进去
 * 因为随着函数的执行，path链表里面的值不断变化，allPath里面的值也不断变化。
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allPath = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        if(root == null) return allPath;
        getPath(allPath, path,root, sum, 0);
        return allPath;
    }
    public void getPath(List<List<Integer>> allPath,  List<Integer> path, TreeNode root, int sum, int totle){
        if(root == null) return;
        path.add(root.val);
        totle += root.val;
        if(root.left == null && root.right == null){
            if(totle == sum)
                allPath.add(new LinkedList<Integer>(path));
        }
        if(root.left != null)
            getPath(allPath, path, root.left, sum, totle);
        if(root.right != null)
            getPath(allPath, path, root.right, sum, totle);
        path.remove(path.size()-1);
    }
}
