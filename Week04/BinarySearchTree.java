package Algo21_2;

import Kim.Node;

public class BinarySearchTree {
	public TreeNode rootNode;

	public BinarySearchTree() {
		rootNode = null;
	}
    
    public TreeNode BSTsearch(String K) {				// 원소 검색
    	return search(rootNode, K);
    }
    private TreeNode search(TreeNode p, String K) {
    	if(p == null)	return null;
    	int n = p.key.compareTo(K);
    	
    	if(n == 0)	return p;
    	
    	if(n < 0)
    		return search(p.Rchild, K);
    	return search(p.Lchild, K);
    }

    public void BSTinsert(String K) {					// 원소 삽입
    	rootNode = insert(rootNode, K);
    }
    private TreeNode insert(TreeNode p, String K) {
    	if(p == null) {
    		TreeNode newNode = new TreeNode();
    		newNode.key = K;
    		return newNode;
    	}
    	int n = p.key.compareTo(K);
    	if(n > 0) {
    		p.Lchild = insert(p.Lchild, K);
    		return p;
    	}
    	else if(n < 0) {
    		p.Rchild = insert(p.Rchild, K);
    		return p;
    	}
    	else
    		return p;
    	
    }
    
	public String max() {				// 트리의 최대값 찾기
		if(rootNode == null) return null;
		return max(rootNode).key;
	}
	private TreeNode max(TreeNode n) {
		if(n.Rchild == null) return n;
		return max(n.Rchild);
	}
    
    public void BSTdelete(String K) {	// 원소 삭제
        rootNode = delete(rootNode, K);
    }
    private TreeNode delete(TreeNode n, String K) {	
    	if(n == null)	return null;
    	int t = n.key.compareTo(K);
    	if(t > 0)		n.Lchild = delete(n.Lchild, K);
    	else if(t <0)	n.Rchild = delete(n.Rchild, K);
    	else {
    		if(n.Lchild == null)	return n.Rchild;		// 자식노드가 없는 경우, 자식 노드가 오른쪽만 있는 경우
    		if(n.Rchild == null)	return n.Lchild;		// 자식노드가 왼쪽만 있는 경우
    		else {											// 자식노드가 둘 다 있는 경우
    			TreeNode q = max(n.Lchild);					// 삭제할 노드의 왼쪽 서브트리의 최대키값
    			n.key = q.key;								// n의 키값을 왼쪽 서브트리의 최대키값으로 갱신
    			n.Lchild = delete(n.Lchild, q.key);			// 왼쪽 서브트리에서 최대값을 삭제
    		}
    	}
    	return n;
    }

    public boolean BSTsplit(String x, BinarySearchTree SmallTree, BinarySearchTree LargeTree) {
    	if(this.rootNode == null)	return false;			// 트리가 비어있는 경우
    	
    	TreeNode small = new TreeNode();
    	TreeNode s = small;
    	
    	TreeNode large = new TreeNode();
    	TreeNode l = large;
    	
    	TreeNode p = this.rootNode;			// x를 찾아가는 포인터

    	while(p != null) {
    		int t = p.key.compareTo(x);
    		if(t == 0) {
    			s.Rchild = p.Lchild;
    			l.Lchild = p.Rchild;
    			SmallTree.rootNode = small.Rchild;
    			LargeTree.rootNode = large.Lchild;
    			return true;
    		}
    		else if(t > 0) {
    			l.Lchild = p;
    			l = p;
    			p = p.Lchild;
    		}
    		else {
    			s.Rchild = p;
    			s = p;
    			p = p.Rchild;			
    		}
    	}
    	s.Rchild = null;
    	l.Lchild = null;
    	SmallTree.rootNode = small.Rchild;
		LargeTree.rootNode = large.Lchild;
		return false;
    }

    private void printNode(TreeNode n) {
        if (n != null) {
            System.out.print("(");
            printNode(n.Lchild);
            System.out.print(" " + n.key + " ");
            printNode(n.Rchild);
            System.out.print(")");
        }
    }
    
    public void print() {
        printNode(rootNode);
        System.out.println();
    }
}
