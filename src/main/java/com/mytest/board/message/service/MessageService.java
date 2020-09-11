package com.mytest.board.message.service;

import java.util.List;
import java.util.Map;

import com.mytest.board.message.vo.MessageVO;

public interface MessageService {
	
	public int sendMessage(MessageVO message) throws Exception;
	public List<MessageVO> messageList(String id) throws Exception;
	public int deleteSendMessage(int messageNO) throws Exception;
	public int deleteReceiveMessage(int messageNO) throws Exception;
	public MessageVO readSendMessage(int messageNO) throws Exception;
	public MessageVO readReceiveMessage(int messageNO) throws Exception;
	public List<MessageVO> searchMessage(Map<String, String> searchMap) throws Exception;
	public int unReadCount(String id) throws Exception;
}
