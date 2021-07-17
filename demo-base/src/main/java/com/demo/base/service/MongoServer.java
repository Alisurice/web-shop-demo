package com.demo.base.service;

import com.demo.mbg.model.UmsGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class MongoServer {
    private MongoTemplate mongoTemplate;

    @Autowired
    public MongoServer(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public void create(UmsGuest umsGuest){
        //create id重复会报错
        //不指定数据集，根据实体类的类名获取数据集。
        System.out.println("create:"+mongoTemplate.insert(umsGuest));
        //指定数据集test
        //mongoTemplate.insert(umsGuest,"test")；

        Query query = new Query(Criteria.where("id").is(umsGuest.getId()));
        System.out.println("find:"+mongoTemplate.find(query,UmsGuest.class));

        
    }
}
