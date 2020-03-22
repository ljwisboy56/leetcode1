package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-23 00:40
 */
public class 第113题路径总和2 {

    List<List<Integer>> allList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return allList;
        dfs(root,0,sum);
        return allList;
    }

    private void dfs(TreeNode root, int count, int sum) {
        if(root != null && root.left == null && root.right == null){
            count += root.val;
            list.add(root.val);
            if(count == sum){
                allList.add(new ArrayList<>(list));
            }
            count -= root.val;
            list.remove(list.size()-1);
        }else {
            if(root.left != null){
                count += root.val;
                list.add(root.val);
                dfs(root.left,count,sum);
                list.remove(list.size()-1);
                count -= root.val;
            }
            if(root.right != null){
                count += root.val;
                list.add(root.val);
                dfs(root.right,count,sum);
                list.remove(list.size()-1);
                count -= root.val;
            }
        }
    }

}
