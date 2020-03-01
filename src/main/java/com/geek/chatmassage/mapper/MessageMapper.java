package com.geek.chatmassage.mapper;

import com.geek.chatmassage.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName messageMapper
 * @Description //消息mapper
 * @Author fate7
 * @Date 2020/2/29 8:21 下午
 * @Vsersion 1.0
 **/
@Mapper
public interface MessageMapper {

    List<Message> selectMessageList(Message message);

    void deleteOne(Integer id);

    void deleteBatch(List<Integer> ids);

    Message selectById(Integer id);

    int update(Message message);

    int insert(Message message);
}
