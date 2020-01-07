package com.example.letcodeeasy;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2019-11-24 14:53
 */
public class Heap2 {


    public static void main(String[] args) {

        heapSort(ArrayConstans.arr);

        Arrays.stream(ArrayConstans.arr).forEach(System.out::println);

    }

    /**
     * 堆拍的思路：
     * 1，首先用全量数据构建一个最大堆；
     *  1.1，分别以数组中的每个子节点构建以他为堆顶的最大堆数组；
     *  1.2，当数组中所有的元素都构建一便后，就是最大堆，因为每次构建，都会保证
     *      以他为堆顶的元素的下面的所有左右子节点都递归的保证最大堆成立
     * 2，然后找到最大堆的堆顶元素；
     * 3，把他和最后一个元素替换；
     * 4，重复上面的一二三步
     *
     *
      * @param arr
     * @return
     */
    public static void heapSort(int[] arr){

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
        for(int i= 0;i <= size-1;i++){
            heapfiy(arr,i,size);
        }

    }

    private static void heapfiy(int[] arr, int currentNode,int size) {

        int left = 2 * currentNode +1;
        int right =2 * currentNode +2;

//        //左子树数组坐标
//        int left = 2 * currentNode +1;
//        //右子数位置坐标
//        int right = 2 * currentNode +2;

        int max = currentNode;

        if (left < size && right < size){
            if(arr[left] > arr[max]){
                max = left;
            }
            if(arr[right] > arr[max]){
                max = right;
            }

            if(max != currentNode){
                swap(arr,max,currentNode);
                heapfiy(arr,max,size);
            }

        }


    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }




}
