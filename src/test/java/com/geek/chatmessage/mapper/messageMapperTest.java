package com.geek.chatmessage.mapper;

import com.geek.chatmessage.pojo.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class messageMapperTest {

    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void selectMessageList() {
        Message message = new Message();
        message.setDescription("彩");
        List<Message> messages = messageMapper.selectMessageList(message);
        log.info("messages={}", messages.toString());

    }

    @Test
    public void deleteOne() {
        messageMapper.deleteOne(10);
    }

    @Test
    public void selectById() {
        Message message = messageMapper.selectById(1);
        log.info("messages={}", message.toString());
    }

    @Test
    public void insert() {
        Message message = Message.builder().content("423432").build();
        int insert = messageMapper.insert(message);
        Assert.assertEquals(1, insert);
    }

    @Test
    public void update() {
        Message message = Message.builder().id(21).command("kd").description("32").content("11111111").build();
        int insert = messageMapper.update(message);
        Assert.assertEquals(1, insert);
    }


}