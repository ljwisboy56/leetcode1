package com.example.jzof.jzof2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2019-12-28 16:58
 */
public class 二叉搜索树与双向链表 {

    TreeNode head = null;

    TreeNode realHead = null;


    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null){
            return null;
        }

        Convert(pRootOfTree.left);

        doConvert(pRootOfTree);

        Convert(pRootOfTree.right);

        return pRootOfTree;

    }

    private void doConvert(TreeNode pRootOfTree) {
        if(head == null){
            head = pRootOfTree;
            realHead = pRootOfTree;
        }else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
    }


}
