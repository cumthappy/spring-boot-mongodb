package com.example.demo.ctrl;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserExtendInfo;
import com.example.demo.service.MongoDbService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="mongo")
public class MongoDbCtrl {
	@Resource 
	private MongoDbService mongoDbService;
	
	@ApiOperation(value="插入用户扩展信息",response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="insertExtendInfo", method=RequestMethod.POST)
	public void insertExtendInfo(@RequestBody UserExtendInfo userInfo){
		try {
			mongoDbService.insertUserExtendInfo(userInfo);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("insertExtendInfo error");
		}
	}

}
