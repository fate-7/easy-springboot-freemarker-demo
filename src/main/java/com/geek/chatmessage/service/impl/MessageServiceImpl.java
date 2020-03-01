package com.geek.chatmessage.service.impl;

import com.geek.chatmessage.mapper.MessageMapper;
import com.geek.chatmessage.pojo.Message;
import com.geek.chatmessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MessageServiceImpl
 * @Description //消息服务实现类
 * @Author fate7
 * @Date 2020/2/29 8:38 下午
 * @Vsersion 1.0
 **/
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> queryMessages(String command, String description) {
        Message message = Message.builder().command(command).description(description).build();
        return messageMapper.selectMessageList(message);
    }

    @Override
    public void delete(Integer id) {
        messageMapper.deleteOne(id);
    }

    @Override
    @Transactional
    public void deleteBatch(String[] ids) {
        List<Integer> idList = new ArrayList<>();
        for (String id : ids) {
            idList.add(Integer.valueOf(id));
        }
        messageMapper.deleteBatch(idList);
    }


    @Override
    public Message findOne(Integer id) {
        return messageMapper.selectById(id);
    }

    @Override
    public void update(Message message) {
        messageMapper.update(message);
    }

    @Override
    public void insert(Message message) {
        messageMapper.insert(message);
    }
}
