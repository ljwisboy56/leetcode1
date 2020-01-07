package com.example.jzof;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2019-12-17 19:29
 */
public class Doubule {

    static  List<String> list = new ArrayList<>();

    static  List<String> doubleList = new ArrayList<>();

    static Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) {

        list = readTxtFileIntoStringArrList("mall.csv");

        for(String tmp :list){

            if(map.get(tmp) == null){
                map.put(tmp,1);
            }else {
                Integer v = map.get(tmp);
                map.put(tmp,++v);
            }
        }

        for(Map.Entry<String,Integer> tmap : map.entrySet()){
            if(tmap.getValue() != 1){
                doubleList.add(tmap.getKey());
            }
        }

        System.out.println(doubleList);



    }

    public static List<String> readTxtFileIntoStringArrList(String fileName) {
        List<String> list = new ArrayList<String>();
        try {
            String encoding = "UTF-8";
            InputStream inputStream =  new ClassPathResource(fileName).getInputStream();

            InputStreamReader read = new InputStreamReader(
                    // 考虑到编码格式
                    inputStream, encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;

            while ((lineTxt = bufferedReader.readLine()) != null) {
                list.add(lineTxt);
            }
            bufferedReader.close();
            read.close();
        } catch (Exception e) {
        }
        return list;
    }

}
