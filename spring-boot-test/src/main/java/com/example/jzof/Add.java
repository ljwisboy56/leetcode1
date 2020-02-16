package com.example.jzof;


import java.util.HashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2019-12-17 00:20
 */
public class Add {

        static Map<Character,Integer> map = null;
        static {
            map = new HashMap<>();
            map.put('0',0);
            map.put('1',1);
            map.put('2',2);
            map.put('3',3);
            map.put('4',4);
            map.put('6',6);
            map.put('7',7);
            map.put('8',8);
            map.put('9',9);
        }

        public static void main(String[] args) {
            int a = new Add().StrToInt("-2147483649");
            System.out.println(a);

        }


        /**
         * 2147483647
         * +2147483647
         *
         * -2147483648
         * @param str
         * @return
         */
        public int StrToInt(String str) {
            int realSum = 0;

            if(str == null || str.equals("")){
                return 0;
            }

            char[] chars = str.toCharArray();
            long sum = 0;

            if(chars[0] == '-'){
                for(int i= 1;i < chars.length;i++){
                    if(map.get(chars[i]) == null){
                        sum =0;
                        break;
                    }
                    sum += (int) (map.get(chars[i]) * Math.pow(10,chars.length-1-i));
                }
                sum = 0-sum;
            }
            else if(chars[0] == '+'){
                for(int i= 1;i < chars.length;i++){
                    if(map.get(chars[i]) == null){
                        sum =0;
                        break;
                    }
                    Integer m = map.get(chars[i]);
                    double n = Math.pow(10,chars.length-1-i);
                    sum += (int) (m * n);
                }

            }
            //全按正整数处理
            else {
                for(int i= 0;i < chars.length;i++){
                    if(map.get(chars[i]) == null){
                        sum =0;
                        break;
                    }
                    sum += (long) (map.get(chars[i]) * Math.pow(10,chars.length-1-i));
                }
            }


            if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
                return 0;
            }

            realSum = (int) sum;

            return realSum;

        }
}
