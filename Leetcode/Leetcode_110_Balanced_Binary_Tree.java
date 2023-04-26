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
public class Leetcode_110_Balanced_Binary_Tree {
    int depth = 0;
    public static int height(TreeNode root){
        if(root == null) return 0;
        System.out.println("현재 : "+root.val);
        int left = height(root.left);
        if(left == -1){
            System.out.println("왼쪽 높이차 존재");
            return -1;
        }
        int right = height(root.right);
        if(right == -1) {
            System.out.println("오른쪽 높이차 존재 ");
            return -1;
        }
        // 좌우 subtree 의 높이 차가 1 초과일 경우 false
        if(left - right > 1 || right - left > 1){
            System.out.println("높이 차");
            return -1;
        }
        System.out.println("높이 : "+(1+Math.max(left, right)));
        System.out.println();

        //높이를 리턴하나
        return 1+Math.max(left, right);
    }
    public static boolean isBalanced(TreeNode root) {
        return height(root) == -1 ? false : true;

    }

    public static void main(String[] args){
        // TreeNode leaf1 = new TreeNode(4);
        // TreeNode leaf2 = new TreeNode(4);
        // TreeNode three1 = new TreeNode(3, leaf1, leaf2);
        // TreeNode three2 = new TreeNode(3);
        // TreeNode two1 = new TreeNode(2, three1, three2);
        // TreeNode two2 = new TreeNode(2);
        // TreeNode root = new TreeNode(1, two1, two2);

        // TreeNode leaf1 = new TreeNode(15);
        // TreeNode leaf2 = new TreeNode(7);
        // TreeNode middle2= new TreeNode(20, leaf1, leaf2);
        // TreeNode middle1 = new TreeNode(9);
        // TreeNode root = new TreeNode(3, middle1, middle2);

        TreeNode leaf1 = new TreeNode(4);
        TreeNode leaf2 = new TreeNode(4);
        TreeNode three1 = new TreeNode(3, leaf1, null);
        TreeNode three2 = new TreeNode(3, null, leaf2);
        TreeNode two1 = new TreeNode(2, three1, null);
        TreeNode two2 = new TreeNode(2, null, three2);
        TreeNode root = new TreeNode(1, two1, two2);
        System.out.println(isBalanced(root));

    }
}
