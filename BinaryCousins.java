/*Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Return the root of the modified tree.

Note that the depth of a node is the number of edges in the path from the root node to it.

 */


class Pair {
    public TreeNode node;
    public int p;
    public Pair(TreeNode node, int p) {
        this.node = node;
        this.p = p;
    }
}
class BinaryCousins {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<Pair>();
        int sum=0;
        int prevSum=0;
        q.add(new Pair(root,0));
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0;i<n;i++) {
                int s = 0;
                Pair nn = q.poll();
                nn.node.val = prevSum - nn.p;
                if(nn.node.left!=null) s+=nn.node.left.val;
                if(nn.node.right!=null) {
                    s+=nn.node.right.val;
                    q.add(new Pair(nn.node.right,s));
                }
                if(nn.node.left!=null) q.add(new Pair(nn.node.left,s));
                sum+=s;
            }
            prevSum = sum;
            sum=0;
        }
        return root;
    }
}
