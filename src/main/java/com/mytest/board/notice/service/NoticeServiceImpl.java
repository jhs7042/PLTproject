package com.mytest.board.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytest.board.notice.dao.NoticeDAO;
import com.mytest.board.notice.vo.NoticePageVO;
import com.mytest.board.notice.vo.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeVO> getNoticeList(NoticePageVO pageVO) throws Exception{
		return noticeDAO.getNoticeList(pageVO);
	}
	
	public int writeNotice(NoticeVO notice) throws Exception{
		return noticeDAO.writeNotice(notice);
	}
	
	public NoticeVO selectNotice(int no) throws Exception{
		return noticeDAO.selectNotice(no);
	}
	
	public int updateNotice(NoticeVO notice) throws Exception{
		return noticeDAO.updateNotice(notice);
	}
	
	public void cntPlus(int no) throws Exception{
		noticeDAO.cntPlus(no);
	}
	
	public int deleteNotice(int no) throws Exception{
		return noticeDAO.deleteNotice(no);
	}
	
	public int listCount() throws Exception{
		return noticeDAO.listCount();
	}

}
