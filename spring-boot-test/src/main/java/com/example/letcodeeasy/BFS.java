package com.example.letcodeeasy;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author yingru.ljw
 * @date 2019-11-21 01:11
 */
public class BFS {


    /**
     * bfs广度优先遍历，借用队列来实现，为什么要借用队列来实现：
     * 因为队列的是先进先出，广度优先，可以理解为一层一层遍历；
     * 比如 ：以下一颗数
     *          1
     *        2   3
     *      4  5 6  7
     * 我们先把1入队列，然后把1的左右子节点压入，然后弹出1，此时队列的
     * 最前面就是2了，然后在把2的，左右子节点压入，弹出2，依次类推；
     * @param root 根节点
     */
    public void bfs(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedBlockingDeque<>();

        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode head = queue.poll();
            //打印遍历
            System.out.println(head.val);
            if(head.left != null){
                queue.add(head.left);
            }
            if(head.right != null){
                queue.add(head.right);
            }
        }

    }

    /**
     * 深度优先遍历，靠栈来实现，大体实现与广度一样
     *
     * 先从根节点出发，沿着左子树进行纵向遍历直到找到叶子节点为止。
     * 然后回溯到前一个节点，进行右子树节点的遍历，直到遍历完所有可达节点为止。
     *
     *
     * @param root
     */
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()){

            TreeNode head = stack.pop();

            System.out.println(head.val);

            //这块注意是先压入右子节点的
            if(head.right != null){
                stack.push(head.right);
            }

            if(head.left != null){
                stack.push(head.left);
            }


        }


    }

}
