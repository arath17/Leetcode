/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        String result = root.val+",";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return result+left+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        String[] dataAsArray = data.split(",");
        int[] intData = new int[dataAsArray.length];
        for(int i=0;i<dataAsArray.length;i++){
            intData[i] = Integer.parseInt(dataAsArray[i]);
        }
        TreeNode root = buildTree(intData,0,dataAsArray.length);
        return root;
    }
    TreeNode buildTree(int[] data,int start,int end){
        if(start==end){
            return null;
        }
        if(end-start==1){
            return new TreeNode(data[start]);
        }
        TreeNode root = new TreeNode(data[start]);
        int i=start;
        for(;i<end;i++){
            if(data[i]>data[start])
                break;
        }
        root.left = buildTree(data, start+1, i);
        root.right = buildTree(data, i, end);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end
