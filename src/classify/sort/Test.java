package classify.sort;

public class Test {
    public static void main(String[] args) {

        /*
        冒泡排序
         */
        int[] array1={10,5,4,9,8,3,0};
        String s1="冒泡排序：";
        BubbleSort b=new BubbleSort();
        b.bubbleSort(array1);
        print(array1,s1);

        /*
        选择排序
         */
        int[] array2={10,5,4,9,8,3,0};
        String s2="选择排序：";
        SelectionSort s=new SelectionSort();
        s.selectionSort(array2);
        print(array2,s2);
        /*
        插入排序
         */
        int[] array3={10,5,4,9,8,3,0};
        String s3="插入排序：";
        InsertionSort i=new InsertionSort();
        i.insertionSort(array3);
        print(array3,s3);
        /*
        希尔排序
         */
        int[] array4={10,5,4,9,8,3,0};
        String s4="希尔排序：";
        ShellSort sh=new ShellSort();
        sh.shellSort(array4);
        print(array4,s4);
        /*
        归并排序
         */
        int[] array5={10,5,4,9,8,3,0};
        String s5="归并排序：";
        MergeSort m=new MergeSort();
        array5=m.mergeSort(array5);
        print(array5,s5);
        /*
        快速排序
         */
        int[] array6={10,5,4,9,8,3,0};
        String s6="快速排序：";
        QuickSort q=new QuickSort();
        array6=q.quickSort(array6,0,array6.length-1);
        print(array6,s6);
        /*
        计数排序
         */
        int[] array7={10,5,4,9,8,3,0};
        String s7="计数排序：";
        CountingSort c=new CountingSort();
        array7=c.countingSort(array7);
        print(array7,s7);
        /*
        堆排序
         */
        int[] array8={10,5,4,9,8,3,0};
        String s8="堆排序：";
        HeapSort h=new HeapSort();
        h.heapSort(array8);
        print(array8,s8);
    }
    public static void print(int[] nums,String s){
        System.out.println(s);
        for(int x:nums){
            System.out.print(x);
            System.out.print(' ');
        }
        System.out.println();
    }
}
