package com.geek.chatmassage.controller;

import com.geek.chatmassage.pojo.Message;
import com.geek.chatmassage.service.MessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @ClassName MessageController
 * @Description //TODO
 * @Author fate7
 * @Date 2020/2/29 8:41 下午
 * @Vsersion 1.0
 **/

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;


    @RequestMapping("/list")
    public String list(Message message,
                             Map<String, Object> map,
                             @RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
                             @RequestParam(value="pageSize",defaultValue="5")Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Message> messages = messageService.queryMessages(message.getCommand(), message.getDescription());
        PageInfo<Message> pageInfo = new PageInfo<>(messages);
        map.put("pageInfo", pageInfo);
        return "/list";
    }


    @RequestMapping("/index")
    public String index(@RequestParam(value = "id", required = false) Integer id,
                       Map<String, Object> map) {
        if (id != null) {
            Message message = messageService.findOne(id);
            map.put("message", message);
        }
        return "/index";
    }

    @RequestMapping("/save")
    public String save(Message message, Map<String, Object> map) {
        if (message.getId()!= null) {
            Message ms = messageService.findOne(message.getId());
            BeanUtils.copyProperties(message, ms);
            messageService.update(ms);
        } else {
            messageService.insert(message);
        }
        return "redirect:/message/list";
    }

    @RequestMapping("/delete")
    public String delete(@Param("id") Integer id) {
        messageService.delete(id);
        return "redirect:/message/list";
    }

    @RequestMapping("/deleteBatch")
    public String deleteBatch(@RequestBody String data) {
        Gson gson = new Gson();
        String[] ids = gson.fromJson(data, String[].class);
        messageService.deleteBatch(ids);
        return "redirect:/message/list";
    }
}
