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
public class Leetcode_938_Range_Sum_of_BST {
    public static int dfs(TreeNode root, int low, int high, int sum){
        

        if(root == null) return sum;
        System.out.println();
        System.out.println("root : "+root.val + "  sum : "+sum);

        if(root.val >= low && root.val <= high)
            sum += root.val;

        if(root.val < low){
            sum = dfs(root.right , low, high, sum);
        }
        if(root.val > high){
            sum = dfs(root.left, low, high, sum);
        }


        System.out.println("sum => "+sum);
        return dfs(root.left, low, high, sum) + dfs(root.right, low, high, sum);
    }
    public static int rangeSumBST(TreeNode root, int low, int high) {
        //BST 는 자신의 왼쪽 트리는 자기 값보다 작고, 오른쪽 트리는 자기 값보다 크다
        //low 가 주어지면 그 노드의 부모의 부모 값부터
        //hight가 주어지면 그 노드의 부모 값까지
        
        
        // int sum = dfs(root, low, high, 0);

        if(root == null) return 0;
        System.out.println();
        System.out.println("root : "+root.val);

        // if(root.val >= low && root.val <= high) return root.val;

        if(root.val < low) return rangeSumBST(root.right, low, high);

        if(root.val > high) return rangeSumBST(root.left, low, high);

           System.out.println("왼쪽과 오른쪽 돌기");
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        // return sum;

        
        
    }
    public static void main(String[] args){
        // TreeNode root = new TreeNode(
        //     10, 
        //     new TreeNode(5,  new TreeNode(3), new TreeNode(7)), 
        //     new TreeNode(15, null, new TreeNode(18)));
        TreeNode root = new TreeNode(
            10,
            new TreeNode(5, 
                new TreeNode(3, new TreeNode(1), null ),
                new TreeNode(7, new TreeNode(6), null)),
            new TreeNode(15, new TreeNode(13), new TreeNode(18))
        );
        System.out.println(rangeSumBST(root, 6, 10));

    }

}