package leetcode.tree.bst;

import leetcode.tree.TreeNode;

/**
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。

 示例 1:

 输入:
   1
  / \
 0   2

 L = 1
 R = 2

 输出:
 1
  \
   2
 * Created by zhaiyi on 2018/9/20.
 */
public class TrimBST {
    public static void main(String[] args) {
        TrimBST trimBST = new TrimBST();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        trimBST.trimBST(root, 1, 2);
    }

    TreeNode resultTree = null;

    public TreeNode trimBST(TreeNode root, int L, int R) {
        traverse(root, L, R);
        return resultTree;
    }

    public void traverse(TreeNode node , int L, int R) {
        if (node != null) {
            int val = node.val;
            if (val >= L && val <= R) {
                build(val);
                traverse(node.left, L, R);
                traverse(node.right, L, R);
            } else if (val > R) {
                traverse(node.left, L, R);
                traverse(node.right, L, R);
            } else {
                traverse(node.right, L, R);
            }
        }
    }

    public void build(int val) {
        TreeNode tmp = resultTree;
        if (tmp == null) {
            tmp = new TreeNode(val);
            resultTree = tmp;
        } else {
            add(tmp, val);
        }
    }

    public void add(TreeNode node, int val) {
        if (node != null) {
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                } else {
                    add(node.left, val);
                }
            } else if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                } else {
                    add(node.right, val);
                }
            }
        }
    }
}
