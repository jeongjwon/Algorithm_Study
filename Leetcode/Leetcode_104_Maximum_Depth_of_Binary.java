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
public class Leetcode_104_Maximum_Depth_of_Binary {
    public static int maxDepth(TreeNode root) {
       
       if(root == null) return 0;
       return 1 +Math.max(maxDepth(root.left), maxDepth(root.right));

        

    }
    public static void main(String[] args){
   
        TreeNode root = new TreeNode(3);
        TreeNode left =  new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode right_left = new TreeNode(15);
        TreeNode rigth_right = new TreeNode(7);
        
        right.left = right_left;
        right.right = rigth_right;

        root.left = left;
        root.right = right;

        System.out.println(maxDepth(root));

    }
}
