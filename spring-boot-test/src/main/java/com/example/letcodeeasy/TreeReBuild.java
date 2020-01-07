package com.example.letcodeeasy;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2019-11-22 00:05
 */
public class TreeReBuild {


//    先来分析一下前序遍历和中序遍历得到的结果，
//    前序遍历第一位是根节点；
//    中序遍历中，根节点左边的是根节点的左子树，右边是根节点的右子树。
//    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}。
//
//    首先，根节点 是{ 1 }；
//    左子树是：前序{ 2,4,7 } ，中序{ 4,7,2 }；
//    右子树是：前序{ 3,5,6,8 } ，中序{ 5,3,8,6 }；

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] min = new int[]{4,7,2,1,5,3,8,6 };
        Arrays.stream(Arrays.copyOfRange(pre,0,3)).forEach(System.out::println);

        reConstructBinaryTree(pre,min);
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] min) {
        if(pre.length == 0 || min.length == 0){
            return null;
        }

        TreeNode node = new TreeNode(pre[0]);

        for(int i = 0; i < pre.length;i++){
            //首先用前序遍历的根节点在中序遍历里面找到
            //然后分别处理左子树和右子树
            //用数组拷贝方法来拷贝数组，注意左闭右开，注意这里面的from和to是坐标
            //正常数组的下表标识的是数组的后面一个位置的值，因为是从0开始
            //但是copy方法：前面是数组的值，后面是数组值-1，比如copy（1，4）标识从数组下表1开始，到数组下表3；
            //在中序遍历里面找到的根节点的位置就是前序遍历该遍历的位置
            //然后分别生成左子树、和右子树
            if(min[i] == node.val){
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(min,0,i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(min,i+1,min.length));
                break;
            }
        }
        return node;
    }



}
