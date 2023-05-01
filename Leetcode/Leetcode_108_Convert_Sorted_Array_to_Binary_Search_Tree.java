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

public class Leetcode_108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public static TreeNode insertTree(int[] nums, int left, int right){
        System.out.println("left : " +left + "  right : "+right);
        if(left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        System.out.println("현재 => "+mid + " " +root.val);
        System.out.println();
        root.left = insertTree(nums, left, mid-1);
        root.right = insertTree(nums, mid+1, right);
        return root;
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return insertTree(nums, 0, nums.length-1);
    }
    public static void main(String[] args){
        int[] nums = { -10, -3, 0, 9, 5};//정렬된 배열
        TreeNode result = sortedArrayToBST(nums);


    }
}
