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
        System.out.println(111111111);
        System.out.println(111111111);
        System.out.println(111111111);
        System.out.println(111111111);
        System.out.println(111111111);
        System.out.println(111111111);
        TUser user = tUserMapper.lockdb("2");
        user.setName("0000");
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tUserMapper.updateByPrimaryKey(user);
//        int k = 0/0;
        return "index.jsp";
    }
}
