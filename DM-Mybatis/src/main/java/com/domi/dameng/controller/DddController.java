package com.domi.dameng.controller;

import com.domi.dameng.model.MessageStatus;
import com.domi.dameng.model.ResultModel;
import com.domi.dameng.util.DmUtil;
import com.domi.dameng.util.KbUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Domi on 2021/02/04.
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class DddController {

    @Autowired(required = false)
    DmUtil dmUtil;
    @Autowired(required = false)
    KbUtil kbUtil;

    @GetMapping("/createOrder")
    public ResultModel createOrder(){
        ResultModel resultModel = new ResultModel();
        try {
            kbUtil.createDb();
            resultModel.setCode(200);
            resultModel.setMsg(MessageStatus.Success);
            resultModel.setData("createOrder---ok");
        } catch (Exception e) {
            resultModel.setCode(404);
            resultModel.setMsg(MessageStatus.Fail);
            resultModel.setData(e.getCause());
        }
        return resultModel;
    }

    @GetMapping("/createMember")
    public ResultModel createMember(){
        ResultModel resultModel = new ResultModel();
        try {
            dmUtil.createDb();
            resultModel.setCode(200);
            resultModel.setMsg(MessageStatus.Success);
            resultModel.setData("createMember---ok");
        } catch (Exception e) {
            resultModel.setCode(404);
            resultModel.setMsg(MessageStatus.Fail);
            resultModel.setData(e.getCause());
        }
        return resultModel;
    }


    @GetMapping("/orderOperate")
    public ResultModel orderOperate111(){
        ResultModel resultModel = new ResultModel();
        try {
            kbUtil.runCRUD();
            resultModel.setCode(200);
            resultModel.setMsg(MessageStatus.Success);
            resultModel.setData("orderOperate---ok");
        } catch (Exception e) {
            resultModel.setCode(404);
            resultModel.setMsg(MessageStatus.Fail);
            resultModel.setData(e.getCause());
        }
        return resultModel;
    }

    @GetMapping("/memberOperate")
    public ResultModel memberOperate(){
        ResultModel resultModel = new ResultModel();
        try {
            dmUtil.runCRUD();
            resultModel.setCode(200);
            resultModel.setMsg(MessageStatus.Success);
            resultModel.setData("memberOperate---ok");
        } catch (Exception e) {
            resultModel.setCode(404);
            resultModel.setMsg(MessageStatus.Fail);
            resultModel.setData(e.getCause());
        }
        return resultModel;
    }

    public static void main(String[] args) {
        try{
            int aaa = 1/0;
            System.out.println(aaa);
        } catch (Exception e){
            log.error(String.valueOf(e.getCause()));
            System.out.println("---------------------");
            log.error(e.getMessage());
        }

    }
}
