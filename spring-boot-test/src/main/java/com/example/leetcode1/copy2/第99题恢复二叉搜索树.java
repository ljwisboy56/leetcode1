package com.example.leetcode1.copy2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-22 20:18
 */
public class 第99题恢复二叉搜索树 {

    public void recoverTree(TreeNode root) {

        List<Integer> nums = new ArrayList<>();
        //中序遍历
        inorder(root, nums);
        //找出那两个节点
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    /**
     *
     * 1 2 3 4 5
     * 4 2 3 1 5
     * 找出那两个错的节点
     * @param nums
     * @return
     */
    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for(int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                // first swap occurence
                if (x == -1) x = nums.get(i);
                    // second swap occurence
                else break;
            }
        }
        return new int[]{x, y};
    }

    public void recover(TreeNode r, int count, int x, int y) {
        if (r == null) {
           return;
        }
        if (r.val == x || r.val == y) {
            r.val = (r.val == x ? y : x);
            count--;
            if (count == 0) {
                return;
            }
        }
        recover(r.left, count, x, y);
        recover(r.right, count, x, y);
    }



}
