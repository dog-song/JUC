package com.domi.dameng.controller;

import com.domi.dameng.model.MessageStatus;
import com.domi.dameng.model.ResultModel;
import com.domi.dameng.service.impl.TestDMServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2020/11/13.
 */
@RestController
@Slf4j
public class TestDMController {

    @Autowired
    TestDMServiceImpl testDMService;

    /**
     * 通过ID查询
     **/
    @RequestMapping(value = "/getDimAppById",method = RequestMethod.POST)
    public ResultModel getRes(@RequestBody Map<String, Object> params){
        ResultModel resultModel = new ResultModel();
        int id = Integer.parseInt(params.get("id").toString());
        try{
            List<Map<String,Object>> dataList = testDMService.getList(id);
            resultModel.setCode(200);
            resultModel.setMsg(MessageStatus.Success);
            resultModel.setData(dataList);
        }catch (Exception e){
            resultModel.setCode(404);
            resultModel.setMsg(MessageStatus.Fail);
            resultModel.setData(e.getCause());
        }

        return resultModel;
    }

    /**
     *  获取全部
     * @Param []
     * @return com.domi.dameng.model.ResultModel
     **/
    @RequestMapping(value = "/listDimAppAll",method = RequestMethod.POST)
    public ResultModel listRes(){
        ResultModel resultModel = new ResultModel();
        try{
            List<Map<String,Object>> dataList = testDMService.listAll();
            resultModel.setCode(200);
            resultModel.setMsg(MessageStatus.Success);
            resultModel.setData(dataList);
        }catch (Exception e){
            resultModel.setCode(404);
            resultModel.setMsg(MessageStatus.Fail);
            resultModel.setData(e.getCause());
        }

        return resultModel;
    }

    /**
     *  插入
     * @Param [params]
     * @return com.domi.dameng.model.ResultModel
     **/
    @RequestMapping(value = "/insertDimApp",method = RequestMethod.POST)
    public ResultModel insert(@RequestBody Map<String, Object> params){
        ResultModel resultModel = new ResultModel();
        String name = params.get("name").toString();
        int age = Integer.parseInt(params.get("age").toString());
        try{
            int res = testDMService.insert(name,age);
            resultModel.setCode(200);
            resultModel.setMsg(MessageStatus.Success);
            resultModel.setData("插入成功");
        }catch (Exception e){
            resultModel.setCode(404);
            resultModel.setMsg(MessageStatus.Fail);
            resultModel.setData(e.getCause());
        }
        return resultModel;
    }

    /**
     *  通过ID删除
     * @Param [params]
     * @return com.domi.dameng.model.ResultModel
     **/
    @RequestMapping(value = "/deleteDimAppById",method = RequestMethod.POST)
    public ResultModel delete(@RequestBody Map<String, Object> params){
        ResultModel resultModel = new ResultModel();
        int id = Integer.parseInt(params.get("id").toString());
        try{
            int res = testDMService.delete(id);
            resultModel.setCode(200);
            resultModel.setMsg(MessageStatus.Success);
            resultModel.setData("删除成功");
        }catch (Exception e){
            resultModel.setCode(404);
            resultModel.setMsg(MessageStatus.Fail);
            resultModel.setData(e.getCause());
        }
        return resultModel;
    }

    /**
     *  通过ID更新
     * @Param [params]
     * @return com.domi.dameng.model.ResultModel
     **/
    @RequestMapping(value = "/updateDimAppById",method = RequestMethod.POST)
    public ResultModel update(@RequestBody Map<String, Object> params){
        ResultModel resultModel = new ResultModel();
        int id = Integer.parseInt(params.get("id").toString());
        String name = params.get("name").toString();
        int age = Integer.parseInt(params.get("age").toString());
        try{
            int res = testDMService.update(id,name,age);
            resultModel.setCode(200);
            resultModel.setMsg(MessageStatus.Success);
            resultModel.setData("更新成功");
        }catch (Exception e){
            resultModel.setCode(404);
            resultModel.setMsg(MessageStatus.Fail);
            resultModel.setData(e.getCause());
        }
        return resultModel;
    }
}
