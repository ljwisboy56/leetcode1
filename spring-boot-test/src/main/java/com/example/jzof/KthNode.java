package com.example.jzof;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author yingru.ljw
 * @date 2019-12-21 18:39
 */
public class KthNode {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    ArrayList<TreeNode> list = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        doKthNoe(pRoot);
        if (k == 0) {
            return null;
        }
        if (k > list.size()) {
            return null;
        }

        return list.get(k - 1);
    }

    private void doKthNoe(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        doKthNoe(pRoot.left);
        list.add(pRoot);
        doKthNoe(pRoot.right);

    }

}
