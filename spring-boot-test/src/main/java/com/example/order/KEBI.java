package com.example.order;

import org.mockito.Mockito;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author yingru.ljw
 * @date 2019-09-02 22:22
 */
public class KEBI {


    String b = null;
    static Boolean a ;
    private String getB(){
        return this.b;
    }

    public static void main(String[] args) {

        KEBI c = Mockito.mock(KEBI.class);

        System.out.println(c.getB());

        HashMap hashMap = new HashMap();

        hashMap.put("1", "2");
        hashMap.put("3", "4");

        HashMap hashMap1 = new HashMap();
        hashMap1.put("2", "5");

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.hashCode()==1283928880);

        System.out.println(getUUID());
        System.out.println(hashMap1);

        new KEBI().setA(null);

        System.out.println(a);
    }

    public void setA(Boolean a1){
        a = a1;
    }


    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.replace("-", "");
    }
}
