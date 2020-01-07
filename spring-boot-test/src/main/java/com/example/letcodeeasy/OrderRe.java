package com.example.letcodeeasy;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2019-11-20 23:14
 */
public class OrderRe {

    public static void main(String[] args) {

        TreeNode[] treeNodes = buildTree();

    }

    /**
     * 首先构建一科完全二叉树
     * @return
     */
    public static TreeNode[] buildTree(){

        TreeNode[] nodes = new TreeNode[10];
        for(int i = 0;i < 10;i++){
            nodes[i] = new TreeNode(i);
        }

        for (int i = 0;i < 10;i++){
            if(i*2 +1 <10){
                nodes[i].left = nodes[i*2+1];
                nodes[i].right = nodes[i*2+2];
            }
        }
        return nodes;

    }

    /**
     * 前序遍历：根-》左-》右，递归实现
     * @param treeNode 完美二叉树的根节点
     */
    public static void preOrder(TreeNode treeNode){
        System.out.println(treeNode.val);

        if(treeNode.left !=null){
            preOrder(treeNode.left);
        }

        if(treeNode.right !=null){
            preOrder(treeNode.right);
        }
    }

    /**
     * 不断往左子树深入并不断先打印值再入栈直到左叶子的空左孩子
     * 弹出栈顶，将指针指向它的右孩子
     * 循环1,2步骤直至栈为空且指针也为空（意思是当栈为空但指针不为空时，
     * 继续。比如当栈顶元素是二叉树的根节点时，就会出现这种情况，此时指针指向根结点的右孩子，但是栈为空）
     *
     * 前序遍历：根-》左-》右，非递归实现
     * @param root 完美二叉树的根节点
     */
    public static void preOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        //为什么这个地方要加2个条件，
        //1,首先栈可能等于空，
        //第一次进来栈就是空，且当最左边的节点全部弹出的时候，栈也是空
        //但是此时根root不是空，因为root可能是右节点，如果没有，那说明就是一条左线节点，完成目标了
        //2，其次root可能等于=null，因为当根节点没有右子节点的时候，root就变成了空
        //如果root是右节点，则把右当成根节点重复刚才的动作即可
        while (!stack.isEmpty() || root != null){
            //一定会遍历出来
            //如果当前节点不等于空
            while (root != null){
                //先打出左根节点
                System.out.println(root.val);
                //然后一直把左跟节点压入栈，其中栈里面的节点，要么就是左节点，要么就是左根节点
                //所以打出来的值已经满足： 根-》左；
                stack.push(root);
                root = root.left;
            }

            //当左子节点全部压完之后，那么root一定是最后一个左边的节点，并且在栈中
            //弹出栈中的节点，那么一定是最左边节，那么他的
            //右节点不一定存在，此时root=null
            //不会遍历出值，然后继续弹栈，此时弹出的一定是左边第二个节点，那么看她有没有右节点
            //把右弹出来，如果右不等于空，那么会在上面的循环中首先打出右这个节点
            //此时就满足了根-》-》左-》右
            //以这个右节点为根节点，从新走一遍：根-左-右-根-左-右
            if(!stack.isEmpty()){

                TreeNode t = stack.pop();
                root = t.right;
            }
        }
    }

    /**
     * 中序遍历是：左-》根--》右 (递归)
     * @param root 当前子树的根节点
     */
    public void midOrder(TreeNode root){
        if(root.left != null){
            midOrder(root.left);
        }

        System.out.println(root.val);

        if(root.right != null){
            midOrder(root.right);
        }

    }

    public void midOrder2(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){

            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                //因为弹出来的一定是左节点，或左根节点，因为上面压入的都是左、左根节点
                //为什么放在这里，和前序遍历就不同了，因为中序遍历是左在前，
                //如果把打印放压栈前面，那么就是先打根，如果把打印放在出战后，
                //就是先打左后打根了，对右都没影响
                TreeNode t = stack.pop();
                System.out.println(t.val);
                root = t.right;
            }
        }
    }

}