package Algo21_2;

public class HeapTest {
	public static void main(String args[]) {
        Heap h = new Heap();
        h.insert(30);
        h.insert(40);
        h.insert(20);
        h.insert(10);
        h.insert(35);
        h.insert(45);
        h.insert(50);
        h.insert(25);
        h.insert(70);
        h.insert(48);
        h.insert(64);
        h.printHeap();
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        System.out.println(h.delete());
        
        
        System.out.println("************************");
        
        // -10은 의미없는 숫자임
        int[] origArray = {-10, 50, 55, 60, 30, 70, 90, 25, 80, 40, 45};
        h = new Heap(origArray);
        h.printHeap();

/*
        // -10은 의미없는 숫자임
        int[] origArray1 = {-10, 50, 55, 60, 30, 70, 90, 25, 80, 40, 45};
        Heap h1 = Heap.makeHeap(origArray1);
        h.printHeap();
*/
        System.out.println(h.delete());
        System.out.println(h.delete());

        h.printHeap();

    }
}
