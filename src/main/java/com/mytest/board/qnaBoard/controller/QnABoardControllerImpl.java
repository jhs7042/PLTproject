package com.mytest.board.qnaBoard.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.mytest.board.qnaBoard.service.QnABoardService;
import com.mytest.board.qnaBoard.vo.ImageVO;
import com.mytest.board.qnaBoard.vo.QnABoardVO;

@Controller("qnaBoardController")
public class QnABoardControllerImpl implements QnABoardController{
	private static String IMAGE_PATH = "C:/myJSP/pltImage";
	@Autowired
	private QnABoardService qnaBoardService;
	@Autowired
	private QnABoardVO qnaBoardVO;
	
	@RequestMapping(value="/qnaBoard/listArticles.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List<QnABoardVO> articlesList = qnaBoardService.listArticles();
//		System.out.println("controller: "+articlesList);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		return mav;
	}
	
	@RequestMapping(value="/qnaBoard/*Form.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Form(@ModelAttribute("qnaBoard") QnABoardVO qnaBoard, HttpServletRequest request, HttpServletResponse response) throws Exception{
//		System.out.println(qnaBoard);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/qnaBoard/insertArticle.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewArticle(@ModelAttribute QnABoardVO qnaBoard, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("COntent-Type", "text/html; charset=utf-8");
		try {
			qnaBoardService.addNewArticle(qnaBoard);
			message = "<script>";
			message += " alert('글이 등록되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/qnaBoard/listArticles.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = " <script>";
			message += " alert('오류가 발생했습니다.');";
			message += " location.href='"+request.getContextPath()+"/qnaBoard/articleForm.do';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="/qnaBoard/viewArticle.do", method=RequestMethod.GET)
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("viewName : "+viewName);
		qnaBoardVO = qnaBoardService.viewArticle(articleNO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("article", qnaBoardVO);
		System.out.println(mav);
		return mav;
	}
	
	@RequestMapping(value="/qnaBoard/imageUpload.do", method=RequestMethod.POST)
	public void imageUpload(@RequestParam MultipartFile upload,
							@RequestParam("id") String id,
			MultipartHttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest multiFile) throws Exception{
		UUID uid = UUID.randomUUID();
		
		OutputStream out = null;
		PrintWriter writer = null;
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			
			String path = IMAGE_PATH + "/" + id+"/";
			String ckUploadPath = path + uid + "_" + fileName;
			String name = uid + "_" + fileName;
			File folder = new File(path);
			
			if(!folder.exists()) {
				try {
					folder.mkdirs();
				}catch(Exception e) {
					e.getStackTrace();
				}
			}
			
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush();
			
//			String callback = request.getParameter("CKEditorFuncNum");
			writer = response.getWriter();
			String fileUrl = request.getContextPath()+"/download.do?id="+id+"&imageFileName="+name;
//			String fileUrl = ckUploadPath;
			
			JsonObject json = new JsonObject();
			json.addProperty("uploaded", 1);
			json.addProperty("fileName", fileName);
			json.addProperty("url", fileUrl);
			writer.println(json);
//			writer.println("{\"fileName\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
			writer.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(out != null) out.close();
				if(writer != null) writer.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return;
	}
	
}
