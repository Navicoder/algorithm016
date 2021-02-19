package com.chao.week02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangwenchao
 * @Date 2020/9/20 1:32 下午
 * @Description 给定一个 N 叉树，返回其节点值的后序遍历。
 * 后序遍历： 先子后父。从左到右【脚标 先小后大】
 * @Version 1.0
 */
public class D_n_postorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        deal(list,root);
        System.out.println(list);

        return list;
    }

    /**
     * 迭代：
     * 执行用时：
     *       1 ms , 在所有 Java 提交中击败了 96.64% 的用户
     * 内存消耗：
     *      39.3 MB , 在所有 Java 提交中击败了 92.19% 的用户
     * @param list
     * @param root
     */
    private void deal(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        //前序遍历
        //list.add(root.val);

        List<Node> children = root.children;
        if (children != null) {
            for (int i = 0; i < children.size() ; i++) {
                deal(list,children.get(i));
            }
        }
        //后序遍历
        list.add(root.val);
    }


    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public static void main(String[] args) {
        Node node = new Node(2);
        Node node1 = new Node(244);
        Node node2 = new Node(332);
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        node.children = nodes;
        new D_n_postorderTraversal().postorder(node);
    }
}
