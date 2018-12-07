package leetcode.tree;

/**
 * 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * 解释：前序遍历先打印节点值，再用()将左侧括起来，再用()将右侧括起来，如果遇到右子树为空，无需用空括号，但左子树为空需要空括号
 */
public class Tree2Bracket606 {

    public String tree2str(TreeNode t) {
        if (t != null) {
            String res = "";
            res += t.val;
            if (t.left != null) {
                res += "(" + tree2str(t.left) + ")";
            } else if (t.right != null) {
                res += "()";
            }
            if (t.right != null) {
                res += "(" + tree2str(t.right) + ")";
            }
            return res;
        }
        return "";
    }
}
