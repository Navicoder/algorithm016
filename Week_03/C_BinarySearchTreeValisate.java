/**
 * @Author wangwenchao
 * @Date 2020/11/22 19:27
 * @Description
 * @Version 1.0
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class C_BinarySearchTreeValisate {

    //中序遍历
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

    /**
     * left < val && val< right
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }

    /**
     * 以val 作为 left的 upper right的lower 递归
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(2);
//        TreeNode left = new TreeNode(1);
//        TreeNode right = new TreeNode(7);
//        root.left =left;
//        root.right =right;
//        System.out.println(new C_BinarySearchTreeValisate().isValidBST(root));
        //  5
        //   / \
        //  1   4
        //     / \
        //    3   6
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode right_left = new TreeNode(3);
        TreeNode right_right = new TreeNode(6);
        root.left =left;
        root.right =right;
        root.right.left =right_left;
        root.right.right =right_right;

        System.out.println(new C_BinarySearchTreeValisate().isValidBST2(root));
        System.out.println(root);
    }
}
