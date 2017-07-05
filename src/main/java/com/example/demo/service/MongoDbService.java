package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserExtendInfo;
import com.mongodb.WriteResult;

@Service
public class MongoDbService {
	@Resource
	MongoTemplate mongoTemplate;
	
	
	/**
	 * 插入信息用户扩展信息
	 * @param userInfo
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public void insertUserExtendInfo(UserExtendInfo userInfo) {
		mongoTemplate.insert(userInfo);
	}
	
	/**
	 * 根据用户ID删除信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public void deleteUserExtendInfo(Long userId) throws Exception {
		Query query = Query.query(Criteria.where("user_id").is(userId));
		WriteResult result = mongoTemplate.remove(query,UserExtendInfo.class);
		if(result.getN() != 1){
			throw new RuntimeException("delete userExtendInfo error!");
		}
	}
	
	/**
	 * 根据用户获取信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserExtendInfo getUserExtendInfoByUserId(Long userId) throws Exception {
		Query query=new Query(Criteria.where("user_id").is(userId));
		return mongoTemplate.findOne(query, UserExtendInfo.class);
	}
	

}
