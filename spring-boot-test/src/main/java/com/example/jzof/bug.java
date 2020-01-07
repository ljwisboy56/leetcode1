package com.example.jzof;

import com.example.letcodeeasy.ListNode;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yingru.ljw
 * @date 2019-12-09 13:18
 */
public class bug {

    public static void main(String[] args) {

        String bug = "ERROR HANDLER-DETAIL - 系统异常,[1,202,242,445],[19001][null,null,null,0]";

        String[] strings = bug.split("系统异常");
        String step1 = strings[1];
        String finalStr = step1.replace(",","");
        String[] str2 = finalStr.split("]");
        String key = str2[0].replace("[","");
        String value = str2[1].replace("[","");

        System.out.println(strings);

        List<String> aa =  readCsv("/tmp/yingru.csv");


    }

    private static void test(){
        Map<String,String> map = new HashMap<>();
        map.put("123","dd");
        map.put("123","ee");

        System.out.println(map);


    }


    private static List<String> readCsv(String path){

        List<String> allString = new ArrayList<>();

        File csv = new File(path);  // CSV文件路径
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        try {
            //读取到的内容给line变量
            while ((line = br.readLine()) != null)
            {
                everyLine = line;
                allString.add(everyLine);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return allString;
    }


    private static void parseSlsDownld(String str){

        String str1 = str.split(",")[0];

        String str1Filter = replaceBlank(str1);

        String key  = str1Filter.replace("[","").replace("]","");

        String str2 = str.split(",")[1];

        String[] str2Filter = str2.split("]");

        String value = str2Filter[0].replace("[","");

//        map.put(key,val);

    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

}
