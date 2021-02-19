package src;

import com.chao.week03.C_BinarySearchTreeValisate;

/**
 @Author wangwenchao
 @Date 2020/11/22 19:29
 @Description
 @Version 1.0
 二叉树
 */
public class TreeNode {
    public int val;
     public TreeNode left;
    public TreeNode right;
     public TreeNode(int x) { val = x; }


//     //中序遍历
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        toString(sb,this);
        sb.append("]");
        if (sb.toString().startsWith("[,")) {
            sb.replace(0,2,"[");
        }
        return sb.toString();

    }

    private void toString(StringBuffer sb, TreeNode node) {
        if (node == null) {
            return;
        }
        toString(sb,node.left);
        sb.append(",");
        sb.append(node.val);
        toString(sb,node.right);
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft (src.TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight (src.TreeNode right) {
        this.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(7);
        root.left =left;
        root.right =right;
        System.out.println(new C_BinarySearchTreeValisate().isValidBST(root));
        //  5
        //   / \
        //  1   4
        //     / \
        //    3   6
//        src.TreeNode root = new src.TreeNode(5);
//        src.TreeNode left = new src.TreeNode(1);
//        src.TreeNode right = new src.TreeNode(4);
//        src.TreeNode right_left = new src.TreeNode(3);
//        src.TreeNode right_right = new src.TreeNode(6);
//        root.left =left;
//        root.right =right;
//        root.right.left =right_left;
//        root.right.right =right_right;

        System.out.println(root.toString());
        System.out.println(root);
    }
}
