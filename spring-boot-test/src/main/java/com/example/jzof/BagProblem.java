package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2019-12-14 19:09
 */
public class BagProblem {

    //5件商品每件的重量
    int[] w = new int[]{1,2,3,4,5};
    //每件商品的价值
    int[] v= new int[]{2,3,4,5,6};

    //背包的最大容量
    int weightAim = 12;

    //结果数组我们要求的是最大价值的子集
    int[] x = new int[5];

    int res = 0;

    //t表示第几件商品
    private void bagProblem(int t,int curWeight){
        //表示遍历到最后一层叶子节点了，就符合条件则输出
        if(t >= w.length){
            int num = 0;
            for(int xs : x){
                res += xs;
                System.out.println(res);
                System.out.println(num+"-"+xs);
            }
        }else {
            //因为是子集树
            for(int i = 0;i < 1;i++){
                x[t] = i;
                //如果当前物品选择
                if(x[t] == 1){
                    curWeight = curWeight - w[t];
                }
                //这个节点选择或不选
                if(constraint(t,curWeight)){
                    bagProblem(t+1,curWeight);
                }
                curWeight = curWeight + w[t];
            }

        }
    }

    //约束函数
    private boolean constraint(int t,int curWeight) {
        //拿到当前物品重量
        int weight = w[t];
        //拿到当前物品价值
        return weight <= curWeight;

    }



}
