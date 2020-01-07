package com.example.jzof;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2019-11-27 00:39
 */
public class HasSubtree {

    /**
     * 这个方法是判断一棵树有没有另一棵树的子树
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        boolean flag = false;
        if(root2 != null || root1 != null){
            if(root1.val == root2.val){
                flag = isSubTree(root1,root2);
            }
            if(!flag){
               flag = HasSubtree(root1.left,root2);
            }

            if(!flag){
                flag =HasSubtree(root1.right,root2);
            }

        }
        return flag;

    }

    /**
     * 这段代码很重要：可以用来记住用来判断两棵树是否相等
     * 这个方法是用来实际判断两个数是不是子树的
     * 逻辑就是先比较根节点，
     * 然后分别判断左子树的所有节点和右子树的所有节点是不是完全相等
     * @param root
     * @param root2
     * @return
     */
    private boolean isSubTree(TreeNode root, TreeNode root2) {
        //如果roo2等于空，则说明已经判断到底了，还没有发现不一样的
        //则肯定是子树
        if(root2 == null){
            return true;
        }

        //如果root等于空，说明左边已经没了，但是右边还有，那肯定不是子树
        if(root == null){
            return false;
        }

        //只要有一个节点两棵树不相等就失败
        if(root.val != root2.val){
            return false;
        }else {
            return isSubTree(root.left,root2.right)&&isSubTree(root.right,root2.right);
        }



    }

}
