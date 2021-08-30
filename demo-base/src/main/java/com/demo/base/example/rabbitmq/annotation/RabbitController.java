package com.demo.base.example.rabbitmq.annotation;

import cn.hutool.core.thread.ThreadUtil;
import com.demo.base.example.rabbitmq.annotation.competition.WorkSender;
import com.demo.base.example.rabbitmq.annotation.direct.DirectSender;
import com.demo.base.example.rabbitmq.annotation.fanout.FanoutSender;
import com.demo.base.example.rabbitmq.annotation.topic.TopicSender;
import com.demo.security.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "RabbitController", description = "RabbitMQ功能测试")
@RequestMapping("/rabbit")
@Controller
public class RabbitController {
    @Autowired
    private SimpleSender simpleSender;

    @ApiOperation("简单模式")
    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult simpleTestRabbitMQ(){
        for(int i=0;i<10;i++){
            simpleSender.send();
            ThreadUtil.sleep(1000);
        }
        return CommonResult.success("test rabbitmq finished");
    }

    @Autowired
    private WorkSender workSender;
    @ApiOperation("竞争模式")
    @RequestMapping(value = "/work", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult workTest(){
        for(int i=0;i<10;i++){
            workSender.send(i);
            ThreadUtil.sleep(1000);
        }
        return CommonResult.success(null);

    }

    @Autowired
    private FanoutSender fanoutSender;

    @ApiOperation("发布/订阅模式")
    @RequestMapping(value = "/fanout", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult fanoutTest() {
        for(int i=0;i<10;i++){
            fanoutSender.send(i);
            ThreadUtil.sleep(1000);
        }
        return CommonResult.success(null);
    }


    @Autowired
    private DirectSender directSender;

    @ApiOperation("路由模式")
    @RequestMapping(value = "/direct", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult directTest() {
        for(int i=0;i<10;i++){
            directSender.send(i);
            ThreadUtil.sleep(1000);
        }
        return CommonResult.success(null);
    }

    @Autowired
    private TopicSender topicSender;

    @ApiOperation("通配符模式")
    @RequestMapping(value = "/topic", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult topicTest() {
        for(int i=0;i<10;i++){
            topicSender.send(i);
            ThreadUtil.sleep(1000);
        }
        return CommonResult.success(null);
    }
}
