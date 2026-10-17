class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

       Queue<TreeNode>q=new LinkedList<>();
       q.add(root);
       List<List<Integer>>ans=new ArrayList<>();
       if(root==null){
         return ans;
       }
       int count=0;
       
       while(!q.isEmpty()){
          count++;
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
          if(count%2==0){
            Collections.reverse(list);
          }
          ans.add(list);
       }

       return ans;
        
    }
}