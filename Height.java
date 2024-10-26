/*You are given the root of a binary tree with n nodes. Each node is assigned a unique value from 1 to n. You are also given an array queries of size m.

You have to perform m independent queries on the tree where in the ith query you do the following:

Remove the subtree rooted at the node with the value queries[i] from the tree. It is guaranteed that queries[i] will not be equal to the value of the root.
Return an array answer of size m where answer[i] is the height of the tree after performing the ith query.

Note:

The queries are independent, so the tree returns to its initial state after each query.
The height of a tree is the number of edges in the longest simple path from the root to some node in the tree.*/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Height {
    int[] depth;
    int[] dmax1;
    int[] dmax2;
    int[] larray;


    public int[] treeQueries(TreeNode root, int[] queries) {
        //initializations:
        depth = new int[100001];
        dmax1 = new int[100001];
        dmax2 = new int[100001];
        larray = new int[100001];
        int[] h=new int[queries.length];
        height(root,0);

        for(int i=0;i<queries.length;i++){
            int q=queries[i];
            int level=larray[q];
            h[i]=(dmax1[level]==depth[q]?dmax2[level] : dmax1[level] )  + level - 1; 
        } 

        return h;
    }


    
    int height(TreeNode root, int level){
      
        if(root == null)return 0;

        larray[root.val]=level;
        depth[root.val]=Math.max(height(root.left,level+1),height(root.right,level+1)) + 1;   
        if(dmax1[level]<depth[root.val]){
            dmax2[level]=dmax1[level];
            dmax1[level]=depth[root.val];
        }   
        else if(dmax2[level]<depth[root.val]){
            dmax2[level]=depth[root.val];
        }
        
        return depth[root.val];

    }
}
