package com.example.jzof;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2019-12-03 01:24
 */
public class Convert {


    TreeNode head = null;

    TreeNode realHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {


        doConvert(pRootOfTree);

        return realHead;

    }

    private void doConvert(TreeNode curNode) {

        if(curNode == null){
            return;
        }

        doConvert(curNode.left);

        if(head == null){
            head = curNode;
            realHead = curNode;
        }else {
            head.right = curNode;
            curNode.left = head;
            head = curNode;
        }

        doConvert(curNode.right);

    }

}
