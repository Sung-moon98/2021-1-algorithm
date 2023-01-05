package Algo21_2;

public class BinaryTree {
	BTNode root;
    
    public BinaryTree() {
        root = null;
    }
    
    public BinaryTree(BinaryTree ltree, Object data, BinaryTree rtree) {
        root = new BTNode(ltree.root, data, rtree.root);
    }
    
    public boolean isEmpty() {
        if(this.root == null)
        	return true;
        else
        	return false;
    }
    
    public BinaryTree leftSubTree(){
    	if(isEmpty())
    		return null;
    	else {
    		BinaryTree ltree = new BinaryTree();
    		ltree.root = root.Lchild;
    		return ltree;
    	}
    }

    public BinaryTree rightSubTree(){
    	if(isEmpty())
    		return null;
    	else {
    		BinaryTree rtree = new BinaryTree();
    		rtree.root = root.Rchild;
    		return rtree;
    	}
    }

    public Object rootData(){
        return root.data;
    }
    
    public void inorder() {
    	theinorder(this.root);
    }
    private void theinorder(BTNode n) {
    	if(n != null) {
    		theinorder(n.Lchild);
    		System.out.print(n.data+" ");
    		theinorder(n.Rchild);
    	}
    }

    public void preorder() {
    	thepreorder(this.root);
    }
    private void thepreorder(BTNode n) {
    	if(n != null) {
    		System.out.print(n.data+" ");
    		thepreorder(n.Lchild);
    		thepreorder(n.Rchild);
    	}
    }

    public void postorder() {
    	thepostorder(this.root);
    }
    private void thepostorder(BTNode n) {
    	if(n != null) {
    		thepreorder(n.Lchild);
    		thepreorder(n.Rchild);
    		System.out.print(n.data+" ");
    	}
    }	
    
    public BinaryTree copy() {
    	BinaryTree newTree = new BinaryTree();
    	newTree.root = thecopy(this.root);
    	return newTree;
    }
    private BTNode thecopy(BTNode t) {
    	if(t == null)	return null;
    	BTNode l = thecopy(t.Lchild);
    	BTNode r = thecopy(t.Rchild);
    	BTNode newNode = new BTNode();
    	newNode.data = t.data;
    	newNode.Lchild = l;
    	newNode.Rchild = r;
    	return newNode;
    }

    public boolean equals(BinaryTree tr) {
    	return theEqual(this.root, tr.root);
    }
    private boolean theEqual(BTNode s, BTNode t) {
    	if(s == null && t == null)	return true;
    	
    	else if(s != null && t != null) {
    		if(s.data == t.data) {
    			if(theEqual(s.Lchild, t.Lchild))
    				return theEqual(s.Rchild, t.Rchild);
    		}
    		else
    			return false;
    	}
    	
    	
		return false;
    }
    
}
