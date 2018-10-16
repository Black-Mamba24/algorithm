package leetcode.tree.binary.resursion;

import leetcode.tree.binary.TreeNode;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。
 只有没有重复元素才能用此方法构建

 思路：从后序遍历尾部找到当前子树头结点，再在中序遍历中找到头部，头部左侧为左子树、右侧为右子树。
 做题时递归的参数和方法和inorder的左右边界计算都是对的。但postorder算错了.
 最好的方法是根据左子树长度在后序遍历中找左子树区间和右子树区间，如果只依靠一个案例，会得出postorder错误的左右边界
 * Created by zhaiyi on 2018/10/16.
 */
public class MiddleBackwardBuildTree106 {
    public static void main(String[] args) {
        MiddleBackwardBuildTree106 main = new MiddleBackwardBuildTree106();
        main.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length - 1;
        return build(inorder, 0, len, postorder, 0, len);
    }

    public TreeNode build(int[] inorder, int i_l, int i_r, int[] postorder, int p_l, int p_r) {
        if (i_l > i_r || p_l > p_r) {
            return null;
        } else {
            TreeNode root = new TreeNode(postorder[p_r]);
            int index = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == postorder[p_r]) {
                    index = i;
                    break;
                }
            }
            int left_num = index - i_l;
            root.left = build(inorder, i_l, index - 1, postorder, p_l, p_l + left_num - 1);
            root.right = build(inorder, index + 1, i_r, postorder, p_l + left_num, p_r - 1);
            return root;
        }
    }
}
