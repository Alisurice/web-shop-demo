package com.demo.base.service;

import com.demo.mbg.model.UmsGuest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TestMongoRepository extends MongoRepository<UmsGuest,String> {

    /**
     * 符合 JPA 规范命名方法， 不需要再实现该方法也可用
     * @param id
     * @return
     */
    List<UmsGuest> findUmsGuestById(int id);


    @Query("{'password' : 'hwehh'}") //Query注解指定的是find的筛选条件
    List<UmsGuest>findById(int id);


}
