class Solution {
    TreeNode startNode = null;

    public int amountOfTime(TreeNode root, int start) {
        TreeNode temp = root;
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        findStart(temp, map, start);
        HashSet<TreeNode> affected = new HashSet<>();

        affected.add(startNode);
        q.add(startNode);

        map.put(root, null);
        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && !affected.contains(node.left)) {
                    
                    q.add(node.left);
                    affected.add(node.left);
                }
                if (node.right != null && !affected.contains(node.right)) {
                    
                    q.add(node.right);
                    affected.add(node.right);
                }
                TreeNode parent = map.get(node);
                if (parent != null && !affected.contains(parent)) {
                    
                    q.add(parent);
                    affected.add(parent);
                }
                
            }
        }
        return time;
    }

    public void findStart(TreeNode root, HashMap<TreeNode, TreeNode> map, int target) {
        if (root == null)
            return;
        if (root.val == target)
            startNode = root;
        map.put(root.left, root);
        map.put(root.right, root);
        findStart(root.left, map, target);
        findStart(root.right, map, target);
        return;
    }
}