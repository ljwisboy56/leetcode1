package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2019-12-21 15:37
 */



public class GetNext {

    public static void main(String[] args) {




    }


    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }

        if(pNode.right != null){
            TreeLinkNode right = pNode.right;
            while (right != null){
                if(right.left != null){
                    right = right.left;
                }
                return right;
            }
        }

        while (pNode.next !=null){
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;

        }
        return null;

    }

}
