package com.geek.chatmassage.service;

import com.geek.chatmassage.pojo.Message;

import java.util.List;

/**
 * @ClassName MessageService
 * @Description //message的服务接口
 * @Author fate7
 * @Date 2020/2/29 8:36 下午
 * @Vsersion 1.0
 **/
public interface MessageService {

    List<Message> queryMessages(String command, String description);

    void delete(Integer id);

    void deleteBatch(String[] ids);

    Message findOne(Integer id);

    void update(Message message);

    void insert(Message message);

}
