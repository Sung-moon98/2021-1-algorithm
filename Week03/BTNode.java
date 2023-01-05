package Algo21_2;

public class BTNode {
	Object data;
    BTNode Lchild;
    BTNode Rchild;

    public BTNode() {
    	data = null;
        Lchild = null;
        Rchild = null;
    }

    public BTNode(Object dt) {
        data = dt;
        Lchild = null;
        Rchild = null;
    }

    public BTNode(BTNode lc, Object dt, BTNode rc) {
        data = dt;
        Lchild = lc;
        Rchild = rc;
    }
}
