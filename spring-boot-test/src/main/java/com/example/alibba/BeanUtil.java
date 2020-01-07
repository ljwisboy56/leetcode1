package com.example.alibba;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.BeanUtils;

/**
 * @author yingru.ljw
 * @date 2019-09-11 14:49
 */
public class BeanUtil {

    public static class SSS{

        private String no;
        public String getNo() {
            return no;
        }

        public void setNo(String no){
            this.no = no;
        }

    }

    public static class AS{

        private String no;
        public String getNo() {
            return no;
        }

        public void setNo(String no){
            this.no = no;
        }

    }



    public static class SKU extends SSS{

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getFox() {
            return fox;
        }

        public void setFox(String fox) {
            this.fox = fox;
        }

        private String name;

        private String id;

        private String price;

        private String fox;

    }

    public static class SIU extends AS{

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getBox() {
            return box;
        }

        public void setBox(String box) {
            this.box = box;
        }

        private String nick;

        private String id;

        private String price;

        private String box;

    }





    public static void main(String[] args) {

        SKU sku = new SKU();
        sku.setFox("a");
        sku.setId("b");
        sku.setName("c");
        sku.setPrice("d");
        sku.setNo("e");

        SIU siu = new SIU();

        BeanUtils.copyProperties(sku,siu);

        System.out.println(siu);

        String.valueOf(null);


    }
}
