package com.chao.week03;

import src.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author wangwenchao
 * @Date 2020/11/22 22:10
 * @Description
 * @Version 1.0
    给定一个二叉树，找出其最小深度。
    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    说明：叶子节点是指没有子节点的节点。
 *
 * 最直接的办法就是使用DFS ( 深度优先搜索 ) 策略计算树的高度. 具体算法流程如下:
 *
    标签：DFS
    终止条件、返回值和递归过程：
        当前节点 root 为空时，说明此处树的高度为 0，0 也是最小值
        当前节点 root 的左子树和右子树都为空时，说明此处树的高度为 1，1 也是最小值
        如果为其他情况，则说明当前节点有值，且需要分别计算其左右子树的最小深度，返回最小深度 +1，+1 表示当前节点存在有 1 个深度
    时间复杂度：O(n)O(n)，nn为树的节点数量
https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/
 *
 */
public class F_BinaryDeepMinLength {

    /**
     * 快
     * @param root
     * @return
     */
    public int minDepth3 (src.TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int result = 0;
        return helper(queue, result);
    }
    public int helper(Queue<TreeNode> queue, int result){
        int n = queue.size();
        for(int i = 0; i < n; i++){
            TreeNode node = queue.poll();
            if(node.left == null && node.right == null) {
                return result + 1;
            }
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        result ++;
        return helper(queue, result);
    }

    /**
     * minDepth1 minDepth2 逻辑简单  执行时间稍慢
     * @param root
     * @return
     */
    public int minDepth1 (src.TreeNode root) {
        if(root == null) return 0;
        //这道题递归条件里分为三种情况
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if(root.left == null && root.right == null) return 1;
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth1(root.left);
        int m2 = minDepth1(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if(root.left == null || root.right == null) return m1 + m2 + 1;

        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1,m2) + 1;
    }

    /**
     * 代码可以进行简化，当左右孩子为空时 m1m1 和 m2m2 都为 00
     *
     * 可以和情况 22 进行合并，即返回 m1+m2+1m1+m2+1
     * @param root
     * @return
     */
    public int minDepth2 (src.TreeNode root) {
        if(root == null) return 0;
        int m1 = minDepth2(root.left);
        int m2 = minDepth2(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;
    }


    public static void main(String[] args) {
        //    5
        //   / \
        //  1   4
        //     / \
        //    3   6
        TreeNode root = new src.TreeNode(5);
        TreeNode left = new src.TreeNode(1);
        TreeNode right = new src.TreeNode(4);
        TreeNode right_left = new src.TreeNode(3);
        TreeNode right_right = new src.TreeNode(6);
        root.left =left;
        root.right =right;
        root.right.left =right_left;
        root.right.right =right_right;

        System.out.println(new F_BinaryDeepMinLength().minDepth2(root));
        System.out.println(root);
    }

}
