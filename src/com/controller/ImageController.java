package com.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.entity.Album;
import com.entity.Image;
import com.entity.Page;
import com.entity.dynamic;
import com.entity.news;
import com.dao.*;
import com.service.*;
/*
 * �ϴ�ͼƬ
 */
@Controller
public class ImageController {
	@Resource
	private ImageService imageservice;
	
	@Resource
	private ImageDao imagedao;
	
	/**
	 * ͼƬ�ϴ�
	 * @param files
	 * @param request
	 * @param image
	 * @return
	 */
	@RequestMapping("/upload.do")
	public ModelAndView uploade(
			@RequestParam(value="file",required=false)MultipartFile[] files,
			HttpServletRequest request,Image image,HttpSession session){
		ModelAndView mav = new ModelAndView();
		//��ȡ·���������ϴ�ͼƬ·��
		String path=request.getSession().getServletContext().getRealPath("upload");
		path = path.replaceAll("\\\\", "/");
		for(MultipartFile file:files){        //����ÿһ��
			//��ȡ�ļ���
			String fileName = file.getOriginalFilename();
			
			//����Ŀ���ļ�����ָ��·��
			File targetFile = new File(path,fileName);
			if(file.isEmpty()){
				request.setAttribute("error","�ļ�δ�ϴ�!");
			}
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			try{
				//���ϴ��ļ�д����������ָ�����ļ�
				file.transferTo(targetFile);
				String name=request.getParameter("name");
				String url = "upload/"+fileName;
				String user_id=(String)session.getAttribute("user_id");
				String album_name=request.getParameter("album_name");
				
				image.setName(name);
				image.setUrl(url);
				image.setAlbumName(album_name);
				image.setUserId(user_id);
				//����dao�㷽����ִ��ͼƬ�ϴ�����
				imageservice.save(image);	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		mav.setViewName("redirect:/findPage.do");//�����ض���ķ�ʽ			
		return mav;
	}
	/*
	 * ���Ĵ���
	 *
	 */
	@RequestMapping("/createAlbum.do")
	public ModelAndView createAlbum(
			@RequestParam(value="file",required=false) MultipartFile[] files,
			HttpServletRequest request,Album album,HttpSession session){
		ModelAndView mav = new ModelAndView();
		//��ȡ·���������ϴ�ͼƬ·��
		String path=request.getSession().getServletContext().getRealPath("upload");
		path = path.replaceAll("\\\\", "/");
		for(MultipartFile file:files){        //����ÿһ��
			//��ȡ�ļ���
			String fileName = file.getOriginalFilename();
			
			//����Ŀ���ļ�����ָ��·��
			File targetFile = new File(path,fileName);
			if(file.isEmpty()){
				request.setAttribute("error","�ļ�δ�ϴ�!");
			}
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			try{
				//���ϴ��ļ�д����������ָ�����ļ�
				file.transferTo(targetFile);
	
				String album_name=request.getParameter("album_name");
				String user_id=(String)session.getAttribute("user_id");
				String type=request.getParameter("type");
				String url = "upload/"+fileName;
				
				
				
				album.setAlbumName(album_name);
				album.setUserId(user_id);
				album.setType(type);
				album.setUrl(url);
				//����dao�㷽����ִ��ͼƬ�ϴ�����
				imageservice.save(album);	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		mav.setViewName("redirect:/findAlbumPage.do");//�����ض���ķ�ʽ			
		return mav;
	}
	/*

	
	
	/**
	 * ��ҳ
	 * @param request
	 * @param image
	 * @param page
	 * @return
	 */
	@RequestMapping(value=("/findPage.do"),method=RequestMethod.GET)
	public ModelAndView fingPage(HttpServletRequest request,Image image,Page page,HttpSession session){
		String album=request.getParameter("album_name");
		if(album==null)
			{}
		else
		{
			session.setAttribute("album_name", album);
		}
		String album_name=(String)session.getAttribute("album_name");
		
		
		String user_id=(String)session.getAttribute("user_id");
		
		ModelAndView mav = new ModelAndView();
		List<Image> list = imagedao.findImg(user_id,album_name);
		int totalpage = 0;//�ܹ���ҳ��
		int rows = imageservice.countImage(user_id,album_name);//�ܼ�¼��
		//�ж��ܼ�¼����ÿҳ��ʾ����ȡ��   �㷨
	    if(rows%page.getPageSize() == 0){
		   totalpage=rows/page.getPageSize();//��ֵ����ҳ��
	    }else{
		   totalpage=rows/page.getPageSize()+1;
	    }
	    mav.addObject("album_name",album_name);
		mav.addObject("totalpage", totalpage);
		mav.addObject("courentpage", page.getPage());//��ǰҳ��
		mav.addObject("list",list);
		mav.setViewName("/result");
		return mav;
	}
	
	/*�������ķ�ҳ*/
	@RequestMapping(value=("/findAlbumPage.do"),method=RequestMethod.GET)
	public ModelAndView findAlbumPage(HttpServletRequest request,Album album,Page page,HttpSession session){
	
		String user_id=(String)session.getAttribute("user_id");
		ModelAndView mav = new ModelAndView();
		List<Album> list = imagedao.findAlbum(user_id);  //�ҳ����е�user_id�û������
		int totalpage = 0;//�ܹ���ҳ��
		int rows = imageservice.countAlbum(user_id);//user_id �ͻ�������ܼ�¼��
		//�ж��ܼ�¼����ÿҳ��ʾ����ȡ��   �㷨
	    if(rows%page.getPageSize() == 0){
		   totalpage=rows/page.getPageSize();//��ֵ����ҳ��
	    }else{
		   totalpage=rows/page.getPageSize()+1;
	    }
	   
		mav.addObject("totalpage", totalpage);
		mav.addObject("courentpage", page.getPage());//��ǰҳ��
		mav.addObject("list",list);
		mav.setViewName("/PhotoManager");
		return mav;
	}
	
	/*
	 * �����ͼƬ��ɾ��
	 */
	@RequestMapping(value=("/photoDelete.do"))
	public ModelAndView photoDelete(HttpServletRequest request,HttpSession session,Image image)
	{
		ModelAndView mav = new ModelAndView();
		String album_name=request.getParameter("album_name");
		String user_id=(String)session.getAttribute("user_id");
		String image_name=request.getParameter("image_name");
		System.out.println("��photoDelete��������֣�"+album_name);
		imagedao.deleteImage(user_id, album_name,image_name);
		mav.setViewName("redirect:/findPage.do");
		return mav;
	}
	
	/*
	 * ����ɾ��
	 * 
	 * 
	 **/
	@RequestMapping(value=("/albumDelete.do"))
	public ModelAndView albumDelete(HttpServletRequest request,HttpSession session,Album album)
	{
		ModelAndView mav = new ModelAndView();
		String album_name=request.getParameter("album_name");
		String user_id=(String)session.getAttribute("user_id");
		
		imagedao.deleteAlbum(user_id, album_name);
		mav.setViewName("redirect:/findAlbumPage.do");
		return mav;
	}
	
	
	/*
	 * 
	 * �����Ϣ���޸�
	 * 
	 
	
	public ModelAndView updateAlbum(HttpServletRequest request,HttpSession session,Album album)
	{
		ModelAndView mav = new ModelAndView();
		String user_id=(String)session.getAttribute("user_id");
		String album_name=request.getParameter("album_name");//�� ����
		String type=request.getParameter("type");
		mav.setViewName("redirect:/findAlbumPage.do");
		return mav;
	}*/
	
	
	@RequestMapping(value=("/updateAlbum.do"))
	public ModelAndView updateAlbum(
			@RequestParam(value="file",required=false) MultipartFile[] files,
			HttpServletRequest request,Album album,HttpSession session){
		ModelAndView mav = new ModelAndView();
		//��ȡ·���������ϴ�ͼƬ·��
		
		
		String path=request.getSession().getServletContext().getRealPath("upload");
		path = path.replaceAll("\\\\", "/");
		for(MultipartFile file:files){        //����ÿһ��
			//��ȡ�ļ���
			String fileName = file.getOriginalFilename();
			String oldname=request.getParameter("oldname");
			String album_name=request.getParameter("album_name");
			String user_id=(String)session.getAttribute("user_id");
			String type=request.getParameter("type");
			
			
			
			//����Ŀ���ļ�����ָ��·��
			File targetFile = new File(path,fileName);
			if(file.isEmpty()){     //����Ͳ��޸���
				
				album.setAlbumName(album_name);
				album.setUserId(user_id);
				album.setType(type);
				album.setUrl(null);
				imagedao.updateAlbum(oldname,album);
				
				mav.setViewName("redirect:/findAlbumPage.do");
				return mav;	
			}
			 if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			try{
				//���ϴ��ļ�д����������ָ�����ļ�
				file.transferTo(targetFile);
				String url = "upload/"+fileName;
				album.setAlbumName(album_name);
				album.setUserId(user_id);
				album.setType(type);
				album.setUrl(url);
				
				imagedao.updateAlbum(oldname,album);	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		mav.setViewName("redirect:/findAlbumPage.do");//�����ض���ķ�ʽ			
		return mav;
	}
	
	@RequestMapping("/createDynamic.do")
	public ModelAndView createDynamic(@RequestParam(value="file",required=false) MultipartFile[] files,
			HttpServletRequest request,dynamic dy,HttpSession session){
		   ModelAndView mav=new ModelAndView();
		 //��ȡ·���������ϴ�ͼƬ·��
			String path=request.getSession().getServletContext().getRealPath("upload");
			path = path.replaceAll("\\\\", "/");
			for(MultipartFile file:files){        //����ÿһ��
				//��ȡ�ļ���
				String fileName = file.getOriginalFilename();
				
				//����Ŀ���ļ�����ָ��·��
				File targetFile = new File(path,fileName);
				if(file.isEmpty()){
					request.setAttribute("error","�ļ�δ�ϴ�!");
				}
				if(!targetFile.exists()){
					targetFile.mkdirs();
				}
				try{
					//���ϴ��ļ�д����������ָ�����ļ�
					file.transferTo(targetFile);
		
					String message=request.getParameter("message");
					String user_id=(String)session.getAttribute("user_id");
					String url = "upload/"+fileName;
					String news_id=request.getParameter("news_id");
					
					dy.setNews_id(news_id);
					dy.setUser_id(user_id);
					dy.setMessage(message);
					dy.setUrl(url);
					
					//����dao�㷽����ִ��ͼƬ�ϴ�����
					imageservice.save(dy);	
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			mav.setViewName("redirect:/findDynamicPage.do");//�����ض���ķ�ʽ	
		
		return mav;
	}
	
	@RequestMapping(value=("/findDynamicPage.do"),method=RequestMethod.GET)
	public ModelAndView findDynamicPage(HttpServletRequest request,dynamic dy,HttpSession session){
	
		String user_id=(String)session.getAttribute("user_id");
		ModelAndView mav = new ModelAndView();
		List<dynamic> list = imagedao.findDynamic();  //�ҳ����еĶ�̬
		mav.addObject("list",list);
		mav.setViewName("/DyCheck");
		return mav;
	}
	
	@RequestMapping(value=("/DynamicComment.do"),method=RequestMethod.GET)
	public ModelAndView DynamicComment(HttpServletRequest request,dynamic dy,HttpSession session)
	{
		ModelAndView mav=new ModelAndView();
		String news_id=request.getParameter("news_id");
		 dy=imagedao.news(news_id);
		 List<news> ns=imagedao.findnews(news_id);
		 mav.addObject("ns",ns);
		 mav.addObject("dy",dy);
		 mav.setViewName("/comment");
		return mav;
		
	}
	
	@RequestMapping("/Comment.do")
	public ModelAndView Comment(String news_id,String news,HttpSession session,news ns)
	{
		
	  ModelAndView mav=new ModelAndView();
	  String user_id=(String)session.getAttribute("user_id");
	  
		  ns.setNews(news);
		  ns.setUser_id(user_id);
		  ns.setNews_id(news_id);
		  imagedao.save(ns);
		  dynamic dy=imagedao.news(news_id);
		  List <news> n=imagedao.findnews(news_id);
		  mav.addObject("n",n);
		  mav.addObject("dy",dy);
		  mav.setViewName("/comment");
		  return mav;
	}
	
}
