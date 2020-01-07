package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2019-12-08 20:37
 */
public class Exchange {


    /**
     * https://www.cnblogs.com/cstanx/p/8215691.html （01背包）
     * https://www.cnblogs.com/chihaoyuIsnotHere/p/10138087.html （硬币）
     * <p>
     * 有数组penny，penny中所有的值都为正数且不重复。
     * 每个值代表一种面值的货币，每种面值的货币可以使用任意张，
     * 再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
     * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
     * <p>
     * 测试样例：
     * penny=[1,2,4]
     * <p>
     * penny_size=3
     * <p>
     * aim = 3
     * 返回：2
     * 即：方案为{1，1，1}和{1，2}两种
     * <p>
     * v(i,j):表示当前用了i种货币（0、1背包问题的货品），当前子问题的剩余j金额（0、1背包问题的当前剩余容量）时的子问题的最优解
     * <p>
     * 当penny[i] > j：即再拿一个币种则超过剩余金额时，v(i,j)=v(i-1,j)
     * 当penny[i] <= j：可以再往里面装一个币种， v(i,j)=v(i-1,j)+v(i,j-penny[i])
     * <p>
     * 边界条件：当i=0的时候，v(0,j)边界条件理解：即剩余j容量的时候，用前0种商品的组合个数，
     *
     * @param penny
     * @param n
     * @param aim
     * @return
     */
    public int countWays(int[] penny, int n, int aim) {


        return 0;


    }

    /**
     *  {2,2,4}
     *
     *  i/j 0  1  2  3
     *
     *  0   1  1  1  1
     *
     *  1   1  0  1  2
     *
     *  2   1  0  0  0
     *
     *
     *
     *
     *
     * @param penny
     * @param n
     * @param aim
     * @return
     */
    public static int countWays2(int[] penny, int n, int aim) {
        // write code here
        if (n == 0 || penny == null || aim < 0) {
            return 0;
        }
        int[][] pd = new int[n][aim + 1];
        for (int i = 0; i < n; i++) {
            pd[i][0] = 1;
        }
        for (int i = 1; penny[0] * i <= aim; i++) {
            pd[0][penny[0] * i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= aim; j++) {
                if (j >= penny[i]) {
                    pd[i][j] = pd[i - 1][j] + pd[i][j - penny[i]];
                } else {
                    pd[i][j] = pd[i - 1][j];
                }
            }
        }
        return pd[n - 1][aim];
    }


    public static void main(String[] args) {
        int[] penny = new int[]{2,2,4};
        int res = countWays2(penny,3,3);
        System.out.println(res);

    }

    /**
     * 尝试接一下背包问题：
     * 背包总容量：W=8；对应金矿问题的总人数people
     * 物品总数：J=20；对应金矿
     * 每个物品的价值：val(J)；
     * 每个物品的体积：Weight(J);
     *
     * 限制条件：N1+N2+N3+....<= 8;
     * max(val(N1)+val(N2).....);
     *
     * 定义W(j)=第几个物品的容量；ps:这里面w(j)就是金矿问题中的每个金矿需要的人数
     * 定义V(j)=第几个物品的价值；这个v(j)就是金矿问题中的每个金矿的金矿价值
     *
     * 模仿金矿问题：我要找到第8个背包容量都用完的最大价值，模拟金矿问题，国外问大臣的两种情况来写；
     * 转移方程有：
     * 物品和容量的关系能获得的最大价值；
     * f(W,j)=max(f(W-W(j),j-1)+v(j),f(w,j-1));
     * f(W,j)=f(j-1,W);
     * 边界条件：最底层的劳动人民
     * j=1,
     *
     *
     *
     *
     */


    /**
     * 1 2 3
     * 1 1 1
     *
     * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
     * 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
     * 测试样例：
     * [[1,2,3],[1,1,1]],2,3
     * 返回：4
     *
     * 分析：先找出、金矿最大价值（目标）和人（容量）以及每个金矿的价值（每个格子的权重）
     * 金矿=路径和 v（i，j）
     * 人=步数一定是4步，为（行+列的长度-1） 设为i
     * 金矿价值=每个格子的权重
     * v(i)其中v为走到第i步的最小路径和
     * v(i)=
     *
     *
     *
     */
    public int getMin(int[][] map, int n, int m) {
        // write code here
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                dp[i][0]+=map[j][0];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<=i;j++){
                dp[0][i]+=map[0][j];
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j] = min(dp[i][j-1]+map[i][j],dp[i-1][j]+map[i][j]);
            }
        }
        return dp[n-1][m-1];
    }
    public int min(int a,int b){
        if(a>b){
            return b;
        }else{
            return a;
        }
    }
}