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
public class Leetcode_226_Invert_Binary_Tree {
    public static TreeNode dfs(TreeNode root){
        if(root == null) return null;

        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);

        root.left = right;
        root.right = left;
        
        return root;

    }
    public static TreeNode invertTree(TreeNode root) {
        TreeNode answer = dfs(root);
        return answer;
        // if(root == null) return null;
		
		// TreeNode temp = invertTree(root.left);
		// root.left = invertTree(root.right);
		// root.right = temp;
		
		
		// return root;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(4);

        TreeNode left =  new TreeNode(2);
        TreeNode right = new TreeNode(7);

        TreeNode left_left = new TreeNode(1);
        TreeNode left_right = new TreeNode(3);
        
        TreeNode right_left = new TreeNode(6);
        TreeNode right_right = new TreeNode(9);

        left.left = left_left;
        left.right = left_right;
        right.right = right_right;
        right.left = right_left;

        root.left = left;
        root.right = right;

        TreeNode result = invertTree(root);
    }
}
