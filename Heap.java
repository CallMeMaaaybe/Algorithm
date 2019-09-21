

/*
* 对排列算法
* */


public class Heap {
    int arrayLength = 0;
    int []SortArray;
    public Heap(int []arrayA){
        //System.out.println(SortArray[i]);
        arrayLength = arrayA.length;
        SortArray = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++){
            SortArray[i] = arrayA[i];
        }
    }
    //返回父节点索引
    public int Parent(int i ){
        return (int)((double)i/2 + 0.5) - 1;
    }
    //返回左儿子节点索引
    public int LeftChild(int i){
        return 2 * i + 1;
    }
    //返回右儿子节点索引
    public int RightChild(int i){
        return 2 * i + 2;
    }

    public void MaxHeapify(int []arrayA, int i, int length){
        int MaxIndex = i;
        int temp = 0;
        int l = LeftChild(i);
        int r = RightChild(i);
        if(l < length && arrayA[i] < arrayA[l]){
            MaxIndex = l;
        }
        if(r < length && arrayA[MaxIndex] < arrayA[r]){
            MaxIndex = r;
        }
        if(MaxIndex != i){
            temp = arrayA[i];
            arrayA[i] = arrayA[MaxIndex];
            arrayA[MaxIndex] = temp;
            MaxHeapify(arrayA, MaxIndex, length);
        }
    }

    public void HeapUp(){
        for(int i = Parent(arrayLength - 1); i >= 0; i--){
            MaxHeapify(SortArray, i, arrayLength);
        }
    }

    public void Sort(){
        HeapUp();
        int temp = 0;
        for(int i = arrayLength - 1; i > 0; i--){
            temp = SortArray[0];
            SortArray[0] = SortArray[i];
            SortArray[i] = temp;
            MaxHeapify(SortArray, 0, i);
        }
    }

    public void show(){
        for(int i = 0; i < arrayLength; i++){
            System.out.println(SortArray[i]);
        }
    }
}
