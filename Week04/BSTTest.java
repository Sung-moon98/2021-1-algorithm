package Algo21_2;

public class BSTTest {
	public static void main(String[] args) {
		BinarySearchTree t = new BinarySearchTree();
        t.BSTinsert("S");
        t.BSTinsert("J");
        t.BSTinsert("B");
        t.BSTinsert("D");
        t.BSTinsert("U");
        t.BSTinsert("M");
        t.BSTinsert("R");
        t.BSTinsert("Q");
        t.BSTinsert("A");
        t.BSTinsert("G");
        t.BSTinsert("E");
    
        t.print();
        
        TreeNode n = t.BSTsearch("R");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }

        t.BSTdelete("R");

        n = t.BSTsearch("R");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }

        t.print();

        n = t.BSTsearch("E");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }

        t.BSTdelete("E");

        n = t.BSTsearch("E");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }

        t.print();

        n = t.BSTsearch("J");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }

        t.BSTdelete("J");

        n = t.BSTsearch("J");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }

        t.print();

        n = t.BSTsearch("S");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }

        t.BSTdelete("S");

        n = t.BSTsearch("S");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }

        t.print();

        n = t.BSTsearch("B");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }

        t.BSTdelete("B");

        n = t.BSTsearch("B");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }
       
        t.print();

        n = t.BSTsearch("C");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }


        BinarySearchTree t1 = new BinarySearchTree();
        t1.BSTinsert("S");
        t1.BSTinsert("J");
        t1.BSTinsert("B");
        t1.BSTinsert("D");
        t1.BSTinsert("U");
        t1.BSTinsert("M");
        t1.BSTinsert("R");
        t1.BSTinsert("Q");
        t1.BSTinsert("A");
        t1.BSTinsert("G");
        t1.BSTinsert("E");
    
        t1.print();
        
        n = t1.BSTsearch("R");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }

        n = t1.BSTsearch("C");
        if (n==null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }

        BinarySearchTree Small = new BinarySearchTree();
        BinarySearchTree Large = new BinarySearchTree();
       
        t.BSTsplit("D", Small, Large);
       
        Small.print();
        Large.print();
        t1.print();
        
        t1.BSTsplit("C", Small, Large);
        
        Small.print();
        Large.print();

        t1 = new BinarySearchTree();
        t1.BSTinsert("T");
        t1.BSTinsert("U");
        t1.BSTinsert("S");
        t1.BSTinsert("R");
        t1.BSTinsert("O");
        t1.BSTinsert("M");
        t1.BSTinsert("W");
        t1.BSTinsert("X");
        t1.BSTinsert("C");
        t1.BSTinsert("B");
        t1.BSTinsert("A");
    
        t1.print();

        t1.BSTdelete("T");

        t1.print();

        t1 = new BinarySearchTree();
        t1.BSTinsert("T");
        t1.BSTinsert("U");
        t1.BSTinsert("R");
        t1.BSTinsert("S");
        t1.BSTinsert("O");
        t1.BSTinsert("M");
        t1.BSTinsert("X");
        t1.BSTinsert("W");
        t1.BSTinsert("C");
        t1.BSTinsert("B");
        t1.BSTinsert("Y");
    
        t1.print();

        t1.BSTdelete("X");

        t1.print();

        t1.BSTdelete("R");

        t1.print();

	}

}
