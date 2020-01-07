package com.example.order;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lijiawen
 * @date 2019/5/17 下午2:29
 */
@Component
public class James extends KEBI {

//    @In
//    @Out
    @Transactional(rollbackFor = Exception.class)
    @SwitchTest(tt="a")
    public int slumDunk(Stdudent stdudent){
//        throw new RuntimeException();
        System.out.println("i am james");
        return 1;

    }

    public static class Stdudent{


    }

}
