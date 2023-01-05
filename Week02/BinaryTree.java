package Algo21_2;

public class BinaryTree {
	BTNode root;
    
    public BinaryTree() {
        root = null;
    }
    
    public BinaryTree(BinaryTree ltree, String data, BinaryTree rtree) {
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

    public String rootData(){
        return root.data;
    }
}
