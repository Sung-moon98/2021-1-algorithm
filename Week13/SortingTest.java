package Algo21_2;

class Sorting { 	
	public static void swap(int[] a, int j, int k) {
		int temp = a[j];
		a[j] = a[k];
		a[k] = temp;
	}
	
    public static void selectionSort(int [] a) {		// 선택 정렬
    	int i, j, min = 0;
		
		for(i = 0; i < a.length-1; i++) {
			min = i;
			for(j = i+1; j < a.length; j++) {
				if(a[j] < a[min])
					min = j;
			}
			swap(a, min, i);
		}
    }

    public static void bubbleSort(int [] a) {			// 버블 정렬
    	int i, j;
		for(i = a.length-1; i > 0; i--) {
			for(j = 0; j < i; j++) {
				if(a[j] > a[j+1])
					swap(a, j, j+1);
			}
		}
    }

    public static void insertionSort(int [] a) {		// 삽입 정렬
    	int k, j;
		for(int i = 1; i < a.length; i++) {
			k = a[i];			// k는 임시 저장소
			j = i;				// 원소들을 옮기기 위해
			
			while(j > 0 && a[j-1] > k) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = k;
			
		}
    }

    public static void quickSort(int [] a) {		// 퀵 정렬
        theQuickSort(a, 0, a.length-1);
    }
    private static void theQuickSort(int [] a, int left, int right) {
    	if(left < right) {
    		int p = partition(a, left, right);
    		theQuickSort(a, left, p-1);
    		theQuickSort(a, p+1, right);
    	}
    	else return;
    }
    private static int partition(int[] a, int i, int j) {
    	int middle = (i+j)/2;	
    	int pivot = a[middle];			// pivot을 중앙값으로 설정
    	a[middle] = a[i];				// a[i]와 a[middle]을 교환
    	a[i] = pivot;					// a[i]는 pivot 값을 보관
    	int p = i;						// p는 경계선
    	
    	for(int k = i+1; k <= j; k++) {
    		if(a[k] < pivot) {
    			p++;
    			swap(a, p, k);
    		}
    	}
    	swap(a, i, p);		// 보관되어있던 pivot과 경계선 p를 교환
    	return p;
    }

 
    public static void heapSort(int [] a) { 		// 힙 정렬(0번 인덱스는 없다고 가정)
    	int n = a.length-1;		// 힙의 크기(원소수)
    	
    	for(int i = n/2; i > 0; i--) {		// 힙 구조로 변환
    		heapify(a, i, n);
    	}
    	for(int i = n-1; i > 0; i--) {
    		swap(a, 1, i+1);			// 제일 큰 값인 루트 값을 배열의 맨 뒤로 보냄
    		heapify(a, 1, i);			// 힙의 크기를 줄이고 다시 힙 변환
    	}
    }
    private static void heapify(int[] a, int h, int m) {	// 배열을 힙 구조로 변환
    	int ah = a[h];
    	int j;
    	for(j = h*2; j <= m; j *= 2) {
    		if(j < m) {		// 자식이 둘 다 존재하면
    			if(a[j] < a[j+1])
    				j++;
    		}
    		
    		if(ah >= a[j])	continue;
    		else	a[j/2] = a[j];
    	}
    	
    	a[j/2] = ah;
    }

    public static void mergeSort(int[] a) {			// 합병 정렬
        int[] temp = new int[a.length];
        theMergeSort(a, temp, 0, a.length-1);
    }
    private static void theMergeSort(int[] a, int[] temp, int left, int right) {
    	if(left < right) {			// 정렬할 원소가 2개 이상인 경우
			int middle = (left+right)/2;
			theMergeSort(a, temp, left, middle);				// 정렬할 원소가 남지 않을 때까지 분할
			theMergeSort(a, temp, middle+1, right);				// 정렬할 원소가 남지 않을 때까지 분할
			merge(a, temp, left, middle, middle+1, right);		// 분할된 배열을 순서에 맞게 합병정렬
		}	
    }
    private static void merge(int[] a, int[] temp, int m, int p, int q, int n) {		// 합병메소드
		int t = m;
		int numElements = n-m+1;		// 원소수
		
		while(m <= p && q <= n) {		// 합병정렬
			if(a[m] < a[q]) {
				temp[t++] = a[m++];
			}
			else
				temp[t++] = a[q++];
		}
		
		while(m <= p)		// 왼쪽 부분 배열에 원소가 남아있는 경우
			temp[t++] = a[m++];
		while(q <= n)		// 오른쪽 부분 배열에 원소가 남아있는 경우
			temp[t++] = a[q++];
		
		for(int i = 0; i < numElements; i++) {		// temp를 a로 복사
			a[n] = temp[n];
			n--;
		}
	}
	
}

public class SortingTest {
	public static void main(String args[]) {
		int test1[] = {0, 2, 4, 5, 7, 3, 10, 8, 1, 9, 6};
        Sorting.selectionSort(test1);

        for (int i = 0; i < test1.length; i++) { 
            System.out.print(test1[i] + " ");
        }

        System.out.println();

        int test2[] = {0, 2, 4, 5, 7, 3, 10, 8, 1, 9, 6};
        Sorting.bubbleSort(test2);

        for (int i = 0; i < test2.length; i++) { 
            System.out.print(test2[i] + " ");
        }

        System.out.println();

        int test3[] = {0, 2, 4, 5, 7, 3, 10, 8, 1, 9, 6};
        Sorting.insertionSort(test3);

        for (int i = 0; i < test3.length; i++) { 
            System.out.print(test3[i] + " ");
        }

        System.out.println();

        int test4[] = {0, 2, 4, 5, 7, 3, 10, 8, 1, 9, 6};
        Sorting.quickSort(test4);

        for (int i = 0; i < test4.length; i++) { 
            System.out.print(test4[i] + " ");
        }

        System.out.println();

        int test5[] = {0, 2, 4, 5, 7, 3, 10, 8, 1, 9, 6};
        Sorting.heapSort(test5);

        for (int i = 0; i < test5.length; i++) { 
            System.out.print(test5[i] + " ");
        }
        
        System.out.println();
        
        int test6[] = {0, 2, 4, 5, 7, 3, 10, 8, 1, 9, 6};
        Sorting.mergeSort(test6);

        for (int i = 0; i < test6.length; i++) { 
            System.out.print(test6[i] + " ");
        }
	}
}
