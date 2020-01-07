package com.example.jzof;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-01 20:59
 */
public class FindPath {

    //由于要进行递归，所以两个arraylist还是在函数外面创建一下比较好
    ArrayList<ArrayList<Integer>> out=new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> in=new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        //递归到输入根节点为空，则此条路径的深度遍历结束
        if(root==null)
        {
            return out;
        }
        //用list来记录路径
        in.add(root.val);
        //每次选取一个节点后，就减去那个节点的值
        target=target-root.val;
        //因为定义的是根到叶子节点才算一条路径，所以不仅和得满足条件，还得都为null
        //这样才会将这条路径加入到out当中
        if(target==0&&root.left==null&root.right==null)
        {
            out.add(new ArrayList<Integer>(in));
        }
        //递归左节点
        FindPath(root.left,target);
        //递归右节点
        FindPath(root.right,target);
        //每次删除list的最后一个元素，将路径退回来，在思路图中讲解
        in.remove(in.size()-1);
        //每次都把目前的out返回给上一次递归
        return out;
    }

}
