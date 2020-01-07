package com.example.letcodeeasy;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2019-12-22 19:47
 */
public class minNumberInRotateArray {

    public static void main(String[] args) {

        int[] arr = new int[]{2,1,4,5,6,7};
        heapSort(arr);
        Arrays.stream(arr).forEach(System.out::println);

    }

    public int minNumberInRotateArray(int [] array) {

        if(array.length == 0){
            return 0;
        }
        //堆排序
        heapSort(array);
        return array[0];
    }

    private static void heapSort(int[] arr) {
        //每次构建完最大堆后，都把最大堆丁元素与第一个元素替换
        for(int i =0;i < arr.length ;i++){
            //构建一个最大堆
            maxHeapSort(arr,arr.length-i);
            //交换最后一个元素与第一个
            swap(arr,0,arr.length-1 -i);
        }
    }

    /**

     * 注意这个size是整个数组的大小，不是数组最大位置索引，所以后面处理的时候要-1
     */
    private static void maxHeapSort(int[] arr, int size) {
        //这个方法从后往前，分别以每个数组中的节点来建立一个以他为根节点的最大堆，
        // 这样就能使整个数组中的每个节点堆都满足最大堆的特性
        for(int i = size-1;i >= 0;i--){
            heapfiy(arr,i,size);
        }

    }

    /**
     * 把数组当作一个完全二叉树
     * 这个函数的能力是创建一个以当前节点为最大根节点的最大堆，
     * 换句话说，他只能保证当前节点及其以下节点维持一个最大堆，且根堆顶是自己
     * @param arr
     * @param currentNode
     * @param size
     */
    private static void heapfiy(int[] arr, int currentNode, int size) {
        //左子树数组坐标
        int left = 2 * currentNode +1;
        //右子数位置坐标
        int right = 2 * currentNode +2;

        int max = currentNode;

        //叶子节点不能大于数组最大值
        if(left < size){
            if(arr[left] > arr[max]){
                max = left;
            }
        }

        if(right < size){
            if(arr[right] > arr[max]){
                max = right;
            }
        }

        //这步非常重要，当我们找到了比当前节点还大的子节点，那么就要把当前
        //节点的值和该节点的值交换，然后以找到的该节点的数组的坐标为
        // 新的当前待考察根节点，看他的左右子节点是否满足最大堆定律
        //为什么要递归，因为你不交换的话那当前节点就是根节点所以也不用动
        //一旦你交换了，那么就可能影响后续已经排序好的，所以需要以交换了的节点再来
        //考察一下是否破坏了原节点的最大堆特性
        if(max != currentNode){
            swap(arr,max,currentNode);
            heapfiy(arr,max,size);
        }
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
