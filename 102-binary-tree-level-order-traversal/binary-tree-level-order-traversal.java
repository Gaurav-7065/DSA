
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       Queue<TreeNode>q=new LinkedList<>();
       q.add(root);
       List<List<Integer>>ans=new ArrayList<>();
       if(root==null){
         return ans;
       }
       while(!q.isEmpty()){
          int levelSize=q.size();
          List<Integer>list=new ArrayList<>();
          while(levelSize>0){
            TreeNode t=q.poll();
            if(t==null)break;
           
              list.add(t.val);
            
            if(t.left!=null){
                q.add(t.left);
            }
            if(t.right!=null){
                q.add(t.right);
            }
            levelSize--;
          }
          ans.add(list);
       }
       return ans;
    }
}