import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Leetcode_543_Diameter_of_Binary_Tree {
    static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
       if(root == null) return 0;
       dfs(root);
       return diameter;
    }
    public static int dfs(TreeNode root){
        if(root == null) return 0;
        System.out.println("dfs :"+root.val);
        int left = dfs(root.left);
        int right = dfs(root.right);
   
        diameter = Math.max(diameter, left+right);
        System.out.println("left : "+left + "  right : "+right + " diameter : " + diameter + " return : "+ (1+Math.max(left,right)));

        return 1 + Math.max(left, right);
    }
    public static void main(String[] args){
   
        TreeNode root = new TreeNode(1);
        TreeNode left =  new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left_left = new TreeNode(4);
        TreeNode left_right = new TreeNode(5);
        
       left.left = left_left;
       left.right = left_right;

        root.left = left;
        root.right = right;

        System.out.println(diameterOfBinaryTree(root));

    }
}
