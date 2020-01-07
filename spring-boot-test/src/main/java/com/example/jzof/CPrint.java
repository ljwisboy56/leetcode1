package com.example.jzof;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author yingru.ljw
 * @date 2019-12-21 17:35
 */
public class CPrint {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(pRoot == null){
            return arrayLists;
        }

        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        int start = 0;
        int end = 1;

        queue.add(pRoot);


        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){

            TreeNode tmp = queue.remove();
            start++;
            list.add(tmp.val);
            if(tmp.left != null){
                queue.add(tmp.left);
            }
            if(tmp.right != null){
                queue.add(tmp.right);
            }
            if(start == end){
                start =0;
                end = queue.size();
                arrayLists.add(list);
                list = new ArrayList<>();
            }
        }
        return arrayLists;


    }

}
