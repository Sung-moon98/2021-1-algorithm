package Algo21_2;

public class Heap {
	private int count;				// item의 수
    private int size;				// 배열의 크기
    private int[] itemArray;		// 배열
    
	public Heap() {
		count = 0;
		size = 64;
		itemArray = new int[size];
	}
	
	public Heap(int[] origArray) {
		count = 0;
		size = 64;
		itemArray = new int[size];
		for(int i = 1; i < origArray.length; i++) {
			this.insert(origArray[i]);
		}
		
    }
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public int[] newsize(int[] e) {			// 배열의 크기 두배로 늘리기
		e = new int[itemArray.length*2];
		for(int i = 1; i < itemArray.length; i++) {
			e[i] = itemArray[i];
		}
		return e;
	}
	
	public void insert(int n) {			// 히프 삽입
		if(count == itemArray.length-1) 
			itemArray = newsize(itemArray);
		
		count++;
		for(int i = count; i >= 1; i /= 2) {
			if(i == 1) {
				itemArray[i] = n;
				break;
			}
			if(n <= itemArray[i/2]) {
				itemArray[i] = n;
				break;
			}
				
			itemArray[i] = itemArray[i/2];
		}
	}
	
	public int delete() {
		if(isEmpty())	return 0;
		
		int item = itemArray[1];		// 삭제할 원소
		int temp = itemArray[count];		// 이동시킬 원소
		count--;
		int i = 1;					// 부모
		int j = 2;					// i의 왼쪽자식
		
		while(j <= count) {
			if(itemArray[j] < itemArray[j+1])
				j++;
			if(temp >= itemArray[j])	// 이동시킬 원소의 값이 자식보다 크다면
				break;
			itemArray[i] = itemArray[j];	// 자식을 한 레벨위로 이동
			i = j;
			j = j*2;
		}
		itemArray[i] = temp;
		return item;
	}
	
	public void printHeap() {
        int i;
        for (i = 1; i <= count; i++)
            System.out.print(itemArray[i] + " ");
        System.out.println();
    }
	
}
