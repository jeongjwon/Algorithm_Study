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
public class Leetcode_617_Merge_Two_Binary_Trees {
    TreeNode answer = new TreeNode();
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        System.out.println("현재 root1 : "+(root1 == null ? "null" : root1.val) + " root2 : "+(root2 == null ? "null" : root2.val));
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
     
        return root1;
    }
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);

        TreeNode left1 =  new TreeNode(3);
        TreeNode right1 = new TreeNode(2);

        TreeNode left1_left = new TreeNode(5);

        left1.left = left1_left;
        root1.left = left1;
        root1.right = right1;


        TreeNode root2 = new TreeNode(2);

        TreeNode left2 =  new TreeNode(1);
        TreeNode right2 = new TreeNode(3);

        TreeNode left2_right = new TreeNode(4);
        TreeNode right2_right = new TreeNode(7);

       
        left2.right = left2_right;
        right2.right = right2_right;
        root2.left = left2;
        root2.right = right2;

        TreeNode result = mergeTrees(root1, root2);
    }
}
