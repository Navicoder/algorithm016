import java.util.LinkedList;

/**
 * @Author wangwenchao
 * @Date 2020/11/22 21:44
 * @Description
 * @Version 1.0
 * https://leetcode-cn.com/problems/invert-binary-tree/solution/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/
 */

public class D_BinaryReverse {

    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if(root==null) {
            return null;
        }
        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        //递归交换当前节点的 左子树
        invertTree(root.left);
        //递归交换当前节点的 右子树
        invertTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if(root==null) {
            return null;
        }
        //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            //每次都从队列中拿一个节点，并交换这个节点的左右子树
            TreeNode tmp = queue.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            //如果当前节点的左子树不为空，则放入队列等待后续处理
            if(tmp.left!=null) {
                queue.add(tmp.left);
            }
            //如果当前节点的右子树不为空，则放入队列等待后续处理
            if(tmp.right!=null) {
                queue.add(tmp.right);
            }

        }
        //返回处理完的根节点
        return root;
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

        System.out.println(new D_BinaryReverse().invertTree2(root));
        System.out.println(root);
    }


}
