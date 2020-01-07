package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2019-11-30 21:43
 */
public class Mirror {

    public class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 首先对于树的一些操作的通常基本思路：
     * 1，首先要对根节点做实际处理，
     * 2，然后对左子树做（递归）处理
     * 3，然后对右子树做（递归）处理
     * 以上是基本流程3步，那么一般我是需要2个函数来完成这个操作
     * 一个函数是实际的操作函数：比如说对数做镜像，那么就需要一个实际的操作镜像函数
     * 比如说对判断有没有子树，那么就需要一个实际的判断函数
     * 至于说这个实际操作函数是需要递归还是不需要，那是他内部的事情
     * 另一个外部函数就是我们要定的这个函数，他负责处理整个业务流程的定义
     * 不负责实际操作如何执行，比如说我们镜像一颗树，我们要如何做，先镜像左子树
     * 再镜像右子树，然后什么时候停止镜像，这是这个流程定义函数的功能，而实际如何镜像
     * 则是上一个实际操作函数的功能，同样递归的终止判定条件也在这个流程定义函数里定义。
     *
     * @param root
     */
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        //先把根节点的左右子树换位子
        swap(root);

        //然后分别处理左子树和右子树
        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }

    private void swap(TreeNode head){
        TreeNode tmp = head.left;
        head.left = head.right;
        head.right = tmp;

    }
}
