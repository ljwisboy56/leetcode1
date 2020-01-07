package com.example.jzof2;

import com.example.letcodeeasy.TreeNode;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2019-12-22 18:17
 */
public class 重建二叉树 {

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,3,5,6};
        int[] in = new int[]{4,2,1,5,3,6};
        TreeNode node = new 重建二叉树().doReConstructBinaryTree(0,pre.length-1,pre,in);
        System.out.println(node);
    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre.length == 0||in.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for(int i = 0; i < in.length; i++){
            if(pre[0] == in[i]){
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1,in.length));
            }
        }
        return node;
    }

    private TreeNode doReConstructBinaryTree(int start, int end, int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[start]);

        //基于前序遍历找到根节点
        //找到前序遍历数组的左子树的最后一个终止节点
        int newStart = start+1;
        if(newStart > end){
            return root;
        }
        int newEnd = find(start,end,pre,in);
        if(newEnd == -1){
            return root;
        }

        //构建左子树
        root.left = doReConstructBinaryTree(newStart,newEnd,pre,in);
        //构建右子树
        root.right = doReConstructBinaryTree(newEnd+1,end,pre,in);
        return root;

    }

    private int find(int start,int end ,int[] pre, int[] in) {
        int tmp = pre[start];
        int res = -1;
        //看根节点的值在右子树的出现的前一个值
        for(int i = 0;i < end;i++){
            if(tmp == in[i]){
                 res = in[i-1];
            }
        }
        //然后找到这个值在左子树的坐标位置
        for(int i = 0;i < end;i++){
            if(res == pre[i]){
                return i;
            }
        }
        return -1;
    }

}
