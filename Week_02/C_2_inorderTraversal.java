import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author wangwenchao
 * @Date 2020/9/20 11:08 上午
 * @Description
 * 给定一个二叉树，返回它的中序 遍历。
 * 二叉树的操作基本都是遍历
 *
 * @Version 1.0
 */
public class C_2_inorderTraversal {
    public class TreeNode {
      Integer val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    /**
     * 迭代 很简单
     * 执行用时：
     * 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：
     * 37.2 MB , 在所有 Java 提交中击败了 23.82% 的用户
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)，h 是树的高度
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        deal(list,root);

        return list;
    }
    private void deal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        deal(list,root.left);
        list.add(root.val);
        deal(list,root.right);
    }

    /**
     * 不用迭代，用 辅助栈
     * 执行用时：
     *      1 ms , 在所有 Java 提交中击败了 46.28% 的用户
     * 内存消耗：
     *      37.3 MB , 在所有 Java 提交中击败了 13.22% 的用户
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || root !=null){

            //不断往左子树方向走，每走一次就将当前节点保存到栈中
            //这是模拟递归的调用
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else{
                //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
                //然后转向右边节点，继续上面整个过程
                TreeNode pop = stack.pop();
                list.add(pop.val);
                root = pop.right;
            }
        }
        return list;
    }



    //莫里斯遍历

    /**
     * 用递归和迭代的方式都使用了辅助的空间，而莫里斯遍历的优点是没有使用任何辅助空间。
     * 缺点是改变了整个树的结构，强行把一棵二叉树改成一段链表结构。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode pre = null;
        while (root != null){
            //如果左节点不为空，就将当前节点连带右子树全部挂到
            //左节点的最右子树下面
            if (root.left != null) {
                pre = root.left;
                //找到root左节点pre的右子树的根节点
                while(pre.right !=null){
                    pre = pre.right;
                }
                pre.right = root;
                TreeNode temp = root;
                //root的左子树所谓新的root的节点 开始遍历
                root = root.left;
                //挪到pre右根子树的节点，把其left置为null
                temp.left = null;
            }else{
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    }
