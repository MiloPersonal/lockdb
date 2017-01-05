package cn.my.controller;

import cn.my.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

/**
 * Created by caoyang on 17/1/3.
 */

@Controller
public class DBDemo {



    @Autowired
    private DBService dbService;

    @RequestMapping("a")
    public String lockdb(){
        return dbService.lockdb();
    }

}
