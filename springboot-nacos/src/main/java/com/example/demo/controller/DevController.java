package com.example.demo.controller;

import com.example.demo.model.MessageStatus;
import com.example.demo.model.ResultModel;
import com.example.demo.service.IDevService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Domi on 2021/01/27.
 */
@Api(tags = "开发API")
@Configuration
@RestController
@Slf4j
public class DevController {

    @Autowired(required = false)
    IDevService service;

    /**
     * 通过ID查询
     **/
    @ApiOperation(value = "开发使用",notes = "dev")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id",required = true,paramType = "body")
    })
    @RequestMapping(value = "/getDimAppById",method = RequestMethod.POST)
    @ResponseBody
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数错误",response = DevController.class)
    })
    public ResultModel getRes(@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true) Map<String, Object> params){
        ResultModel resultModel = new ResultModel();
        int id = Integer.parseInt(params.get("id").toString());
        try{
            List<Map<String,Object>> dataList = service.getList(id);
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
}
