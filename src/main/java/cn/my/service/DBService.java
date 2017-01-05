package cn.my.service;

import cn.my.domain.TUser;
import cn.my.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by caoyang on 17/1/3.
 */

@Service
public class DBService {

    @Autowired
    private TUserMapper tUserMapper;

    public String lockdb() {
        System.out.println("a ---------->   lock");

        TUser user = tUserMapper.lockdb("4");
        int count = Integer.parseInt(user.getPic());
        count = count + 100000;
        user.setPic(count + "");
        try {
            Thread.currentThread().sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tUserMapper.updateByPrimaryKey(user);

        System.out.println("a ---------->   unlock");
//        int k = 0/0;
        return "index.jsp";
    }





    public String lockdb2() {
        try {
            TUser user = tUserMapper.lockdb2("4");
            System.out.println("lock - 2   pic = " + user.getPic());
            int count = Integer.parseInt(user.getPic());
            count = count + 2;
            user.setPic(count + "");
            tUserMapper.updateByPrimaryKey(user);
            System.out.println("c ---------->   update end");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "index.jsp";
    }


    public String lockdb3() {

        TUser user = tUserMapper.selectByPrimaryKey("4");
        int count = Integer.parseInt(user.getPic());
        System.out.println("c ---------->   count = " + count);
        count = count + 100000;
        user.setPic(count + "");
//        try {
//            Thread.currentThread().sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        tUserMapper.updateByPrimaryKey(user);
        System.out.println("c ---------->   update end");
//        int k = 0/0;
        return "index.jsp";
    }
}
