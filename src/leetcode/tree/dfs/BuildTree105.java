package leetcode.tree.dfs;

import leetcode.tree.TreeNode;

/*
根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class BuildTree105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int p_start, int p_end, int i_start, int i_end) {
        if (p_start <= p_end && i_start <= i_end) {
            int val = preorder[p_start];
            int len = 0;
            for (int i = i_start; i <= i_end; i++) {
                if (inorder[i] == val) {
                    len++;
                } else {
                    break;
                }
            }
            TreeNode node = new TreeNode(val);
            node.left = build(preorder, inorder, p_start + 1, p_start + len, i_start, i_start + len - 1);
            node.right = build(preorder, inorder, p_start + len + 1, p_end, i_start + len + 1, i_end);
            return node;
        } else {
            return null;
        }
    }
}
