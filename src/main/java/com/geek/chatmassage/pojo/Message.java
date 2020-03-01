package com.geek.chatmassage.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Message
 * @Description //消息实体类
 * @Author fate7
 * @Date 2020/2/29 8:17 下午
 * @Vsersion 1.0
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    private Integer id;

    private String command;

    private String description;

    private String content;
}
