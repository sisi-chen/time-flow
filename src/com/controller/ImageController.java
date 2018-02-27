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
 * 上传图片
 */
@Controller
public class ImageController {
	@Resource
	private ImageService imageservice;
	
	@Resource
	private ImageDao imagedao;
	
	/**
	 * 图片上传
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
		//获取路径：本地上传图片路径
		String path=request.getSession().getServletContext().getRealPath("upload");
		path = path.replaceAll("\\\\", "/");
		for(MultipartFile file:files){        //遍历每一个
			//获取文件名
			String fileName = file.getOriginalFilename();
			
			//创建目标文件，并指定路径
			File targetFile = new File(path,fileName);
			if(file.isEmpty()){
				request.setAttribute("error","文件未上传!");
			}
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			try{
				//将上传文件写到服务器上指定的文件
				file.transferTo(targetFile);
				String name=request.getParameter("name");
				String url = "upload/"+fileName;
				String user_id=(String)session.getAttribute("user_id");
				String album_name=request.getParameter("album_name");
				
				image.setName(name);
				image.setUrl(url);
				image.setAlbumName(album_name);
				image.setUserId(user_id);
				//调用dao层方法，执行图片上传操作
				imageservice.save(image);	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		mav.setViewName("redirect:/findPage.do");//采用重定向的方式			
		return mav;
	}
	/*
	 * 相册的创建
	 *
	 */
	@RequestMapping("/createAlbum.do")
	public ModelAndView createAlbum(
			@RequestParam(value="file",required=false) MultipartFile[] files,
			HttpServletRequest request,Album album,HttpSession session){
		ModelAndView mav = new ModelAndView();
		//获取路径：本地上传图片路径
		String path=request.getSession().getServletContext().getRealPath("upload");
		path = path.replaceAll("\\\\", "/");
		for(MultipartFile file:files){        //遍历每一个
			//获取文件名
			String fileName = file.getOriginalFilename();
			
			//创建目标文件，并指定路径
			File targetFile = new File(path,fileName);
			if(file.isEmpty()){
				request.setAttribute("error","文件未上传!");
			}
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			try{
				//将上传文件写到服务器上指定的文件
				file.transferTo(targetFile);
	
				String album_name=request.getParameter("album_name");
				String user_id=(String)session.getAttribute("user_id");
				String type=request.getParameter("type");
				String url = "upload/"+fileName;
				
				
				
				album.setAlbumName(album_name);
				album.setUserId(user_id);
				album.setType(type);
				album.setUrl(url);
				//调用dao层方法，执行图片上传操作
				imageservice.save(album);	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		mav.setViewName("redirect:/findAlbumPage.do");//采用重定向的方式			
		return mav;
	}
	/*

	
	
	/**
	 * 分页
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
		int totalpage = 0;//总共的页数
		int rows = imageservice.countImage(user_id,album_name);//总记录数
		//判断总记录数与每页显示的数取余   算法
	    if(rows%page.getPageSize() == 0){
		   totalpage=rows/page.getPageSize();//赋值给总页数
	    }else{
		   totalpage=rows/page.getPageSize()+1;
	    }
	    mav.addObject("album_name",album_name);
		mav.addObject("totalpage", totalpage);
		mav.addObject("courentpage", page.getPage());//当前页数
		mav.addObject("list",list);
		mav.setViewName("/result");
		return mav;
	}
	
	/*相册里面的分页*/
	@RequestMapping(value=("/findAlbumPage.do"),method=RequestMethod.GET)
	public ModelAndView findAlbumPage(HttpServletRequest request,Album album,Page page,HttpSession session){
	
		String user_id=(String)session.getAttribute("user_id");
		ModelAndView mav = new ModelAndView();
		List<Album> list = imagedao.findAlbum(user_id);  //找出所有的user_id用户的相册
		int totalpage = 0;//总共的页数
		int rows = imageservice.countAlbum(user_id);//user_id 客户的相册总记录数
		//判断总记录数与每页显示的数取余   算法
	    if(rows%page.getPageSize() == 0){
		   totalpage=rows/page.getPageSize();//赋值给总页数
	    }else{
		   totalpage=rows/page.getPageSize()+1;
	    }
	   
		mav.addObject("totalpage", totalpage);
		mav.addObject("courentpage", page.getPage());//当前页数
		mav.addObject("list",list);
		mav.setViewName("/PhotoManager");
		return mav;
	}
	
	/*
	 * 相册内图片的删除
	 */
	@RequestMapping(value=("/photoDelete.do"))
	public ModelAndView photoDelete(HttpServletRequest request,HttpSession session,Image image)
	{
		ModelAndView mav = new ModelAndView();
		String album_name=request.getParameter("album_name");
		String user_id=(String)session.getAttribute("user_id");
		String image_name=request.getParameter("image_name");
		System.out.println("在photoDelete中相册名字："+album_name);
		imagedao.deleteImage(user_id, album_name,image_name);
		mav.setViewName("redirect:/findPage.do");
		return mav;
	}
	
	/*
	 * 相册的删除
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
	 * 相册信息的修改
	 * 
	 
	
	public ModelAndView updateAlbum(HttpServletRequest request,HttpSession session,Album album)
	{
		ModelAndView mav = new ModelAndView();
		String user_id=(String)session.getAttribute("user_id");
		String album_name=request.getParameter("album_name");//可 修项
		String type=request.getParameter("type");
		mav.setViewName("redirect:/findAlbumPage.do");
		return mav;
	}*/
	
	
	@RequestMapping(value=("/updateAlbum.do"))
	public ModelAndView updateAlbum(
			@RequestParam(value="file",required=false) MultipartFile[] files,
			HttpServletRequest request,Album album,HttpSession session){
		ModelAndView mav = new ModelAndView();
		//获取路径：本地上传图片路径
		
		
		String path=request.getSession().getServletContext().getRealPath("upload");
		path = path.replaceAll("\\\\", "/");
		for(MultipartFile file:files){        //遍历每一个
			//获取文件名
			String fileName = file.getOriginalFilename();
			String oldname=request.getParameter("oldname");
			String album_name=request.getParameter("album_name");
			String user_id=(String)session.getAttribute("user_id");
			String type=request.getParameter("type");
			
			
			
			//创建目标文件，并指定路径
			File targetFile = new File(path,fileName);
			if(file.isEmpty()){     //封面就不修改了
				
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
				//将上传文件写到服务器上指定的文件
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
		mav.setViewName("redirect:/findAlbumPage.do");//采用重定向的方式			
		return mav;
	}
	
	@RequestMapping("/createDynamic.do")
	public ModelAndView createDynamic(@RequestParam(value="file",required=false) MultipartFile[] files,
			HttpServletRequest request,dynamic dy,HttpSession session){
		   ModelAndView mav=new ModelAndView();
		 //获取路径：本地上传图片路径
			String path=request.getSession().getServletContext().getRealPath("upload");
			path = path.replaceAll("\\\\", "/");
			for(MultipartFile file:files){        //遍历每一个
				//获取文件名
				String fileName = file.getOriginalFilename();
				
				//创建目标文件，并指定路径
				File targetFile = new File(path,fileName);
				if(file.isEmpty()){
					request.setAttribute("error","文件未上传!");
				}
				if(!targetFile.exists()){
					targetFile.mkdirs();
				}
				try{
					//将上传文件写到服务器上指定的文件
					file.transferTo(targetFile);
		
					String message=request.getParameter("message");
					String user_id=(String)session.getAttribute("user_id");
					String url = "upload/"+fileName;
					String news_id=request.getParameter("news_id");
					
					dy.setNews_id(news_id);
					dy.setUser_id(user_id);
					dy.setMessage(message);
					dy.setUrl(url);
					
					//调用dao层方法，执行图片上传操作
					imageservice.save(dy);	
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			mav.setViewName("redirect:/findDynamicPage.do");//采用重定向的方式	
		
		return mav;
	}
	
	@RequestMapping(value=("/findDynamicPage.do"),method=RequestMethod.GET)
	public ModelAndView findDynamicPage(HttpServletRequest request,dynamic dy,HttpSession session){
	
		String user_id=(String)session.getAttribute("user_id");
		ModelAndView mav = new ModelAndView();
		List<dynamic> list = imagedao.findDynamic();  //找出所有的动态
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
