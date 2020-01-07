package com.example.jzof;
import com.example.jzof.Mirror.TreeNode;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-07 19:23
 */
public class FindPath2 {


    ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
    ArrayList<Integer> tmpList = new ArrayList<>();



    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target){
        doFindPath(root,finalList,tmpList,target);
        return finalList;
    }


//    模板：
//    void backtrack (int t)
//    {
//        if (t>n) output(x);
//        else
//            for (int i=t;i<=n;i++) {
//                swap(x[t], x[i]);
//                if (constraint(t)&&bound(t)) backtrack(t+1);
//                swap(x[t], x[i]);
//            }
//    }


    /**
     * 套用回溯法模板思想解决问题：
     * 1，注意终止条件：里面不要写任何判断逻辑
     * 2，else分支要进行对每个子条件进行遍历，比如是数组就要循环遍历，如果是树就要分别遍历左右子节点
     * 3，考虑限制条件和剪纸条件，限界条件就是看是否终止执行，剪纸就是看是否满足要求
     * 4，如果子排序问题注意回溯，如果是数组则swap即可，如果是二叉树注意别的方式的回溯。
     * 5，字排序问题的回溯逻辑要在递归逻辑之外
     *
     *
     *
     * @param root
     * @param finalList
     * @param list
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> doFindPath(TreeNode root,ArrayList finalList,ArrayList list, int target){

        if(root == null){
            return finalList;
        }else {
            tmpList.add(root.val);

            if(constraint(tmpList,target) && root.right == null && root.left == null){
                 finalList.add(new ArrayList<>(tmpList));
            }else {
                //继续递归
                if(root.left != null){
                    doFindPath(root.left,finalList,list,target);
                }
                if(root.right != null){
                    doFindPath(root.right,finalList,list,target);

                }
            }
            tmpList.remove(tmpList.size()-1);
        }
        return finalList;
    }

    private boolean constraint(ArrayList<Integer> tmpList, int target) {

        int sum = 0;
        for(Integer integer: tmpList){
            sum += integer;
        }
        return target == sum;
    }

}
