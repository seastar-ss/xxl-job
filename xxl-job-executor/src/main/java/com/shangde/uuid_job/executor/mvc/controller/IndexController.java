package com.shangde.uuid_job.executor.mvc.controller;

import com.shawn.ss.lib.tools.db.impl.DbManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    @Qualifier("common_uuidMaster")
    DbManager db;

    @RequestMapping("/")
    @ResponseBody
    String index() {
        return "xxl job executor running.";
    }


    @RequestMapping("/testdbinject")
    @ResponseBody
    String test() {
        return db.getClass().toString();
    }

}