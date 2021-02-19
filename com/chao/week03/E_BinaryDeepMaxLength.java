package com.chao.week03;

import src.TreeNode;

/**
 * @Author wangwenchao
 * @Date 2020/11/22 22:10
 * @Description
 * @Version 1.0
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 最直接的办法就是使用DFS ( 深度优先搜索 ) 策略计算树的高度. 具体算法流程如下:
 *
 * 终止条件: 当前节点为空
 * 返回值：
 *      节点为空时，所以返回 0
 *      节点不为空时, 返回左右子树高度的最大值 + 1
 *
 */
public class E_BinaryDeepMaxLength {

    /**
     * DFS
     * @param root
     * @return
     */
    public int maxDepth (src.TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }



    public static void main(String[] args) {
        TreeNode root = new src.TreeNode(5);
        TreeNode left = new src.TreeNode(1);
        TreeNode right = new src.TreeNode(4);
        TreeNode right_left = new src.TreeNode(3);
        TreeNode right_right = new src.TreeNode(6);
        root.left =left;
        root.right =right;
        root.right.left =right_left;
        root.right.right =right_right;

        System.out.println(new E_BinaryDeepMaxLength().maxDepth(root));
        System.out.println(root);
    }

}
