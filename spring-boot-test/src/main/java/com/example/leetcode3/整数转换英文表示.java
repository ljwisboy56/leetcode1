package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-03-01 15:34
 */
public class 整数转换英文表示 {

    public static void main(String[] args) {
        String rew = new 整数转换英文表示().numberToWords(114);
        System.out.println(rew);
    }


    String[] low = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String[] mid = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] high = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        //先求出千位以下的部分
        int part1 = num%1000;
        //然后缩小1000
        num = num/1000;
        //再求出百万位以下的部分
        int part2 = num%1000;
        num = num/1000;
        //再求出10亿位以下的部分
        int part3 = num%1000;
        num = num/1000;
        //最后是十亿以上的部分
        int part4 = num;
        String ans = "";
        //然后分别处理每部分
        if(part4!=0){
            ans = buildNumber(part4) + "Billion ";
        }
        if(part3!=0){
            ans = ans + buildNumber(part3) + "Million ";
        }
        if(part2!=0){
            ans = ans + buildNumber(part2) + "Thousand ";
        }
        if(part1!=0){
            ans = ans + buildNumber(part1);
        }
        return ans.trim();
    }

    /**
     * 处理三位数的读法
     * @param num
     * @return
     */
    public String buildNumber(int num){
        //先求出个位
        int a = num%10;
        num = num/10;
        //再求出十位
        int b = num%10;
        //再求出百位
        num = num/10;
        int c = num;
        String ans = "";
        //如果百位有就直接从百位的数组里面取出来拼接
        if(c!=0){
            ans = low[c] + " " + "Hundred ";
        }
        //十位比较特殊，当不超过20的时候需要特殊处理
        if(b==1){
            ans +=  mid[a];
        }else if(b==0){
            //当等于0的时候说明视为没有，那么直接加上各位就好
            ans += low[a];
        }else {
            //其余情况处理10位和个位
            ans += high[b] + " " + low[a];
        }
        return ans.trim() + " ";
    }

}
