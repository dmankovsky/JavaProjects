package mapper;

import model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("select * from messages")
    List<ChatMessage> getAllMessages();

    @Insert("insert into messages (username, messagetext) values(#{username}, #{messageText})")
    @Options(useGeneratedKeys=true, keyProperty="messageId")
    int addMessage(ChatMessage chatMessage);
}

