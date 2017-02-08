package cn.javass.chapter2.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

public class HelloWorldController implements Controller {
	@Override
	
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//1銆佹敹闆嗗弬鏁�
		//2銆佺粦瀹氬弬鏁板埌鍛戒护瀵硅薄
		//3銆佽皟鐢ㄤ笟鍔″璞�
		//4銆侀�夋嫨涓嬩竴涓〉闈�
		ModelAndView mv = new ModelAndView();
		//娣诲姞妯″瀷鏁版嵁 鍙互鏄换鎰忕殑POJO瀵硅薄
		mv.addObject("message", "Hello Wor!");
		//璁剧疆閫昏緫瑙嗗浘鍚嶏紝瑙嗗浘瑙ｆ瀽鍣ㄤ細鏍规嵁璇ュ悕瀛楄В鏋愬埌鍏蜂綋鐨勮鍥鹃〉闈�
		mv.setViewName("message");
		
		//String test = req.getParameter("test");
		//System.out.println(test);
		//req.getRequestDispatcher("address").forward(req,resp );
		//req.getRequestDispatcher("test?test=111").forward(req, resp);
		
	    //test = test.replace("<", "&#60;");
	    //test = test.replace(">", "&#62;");
	   // File[] paths;
	    //try{
	    //	paths = File.listRoots();
	    //	for(File path:paths){
	    //		System.out.println(path);
	    //	}
	   // }catch(Exception e){
	   // 	e.printStackTrace();
	    //}
		
	   //ServletInputStream in = req.getInputStream();
		 /* req.setCharacterEncoding("UTF-8");
		  DiskFileItemFactory factory = new DiskFileItemFactory();
		  ServletFileUpload upload = new ServletFileUpload(factory);
		  try {
		   List items = (List) upload.parseRequest(req);
		   Iterator itr = ((java.util.List) items).iterator();
		   while (itr.hasNext()) {
		    FileItem item = (FileItem) itr.next();
		    if (item.isFormField()) {
		     System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
		    } else {
		     if (item.getName() != null && !item.getName().equals("")) {
		      System.out.println("上传文件的大小:" + item.getSize());
		      System.out.println("上传文件的类型:" + item.getContentType());
		      // item.getName()返回上传文件在客户端的完整路径名称
		      System.out.println("上传文件的名称:" + item.getName());

		      File tempFile = new File(item.getName());

		      ServletContext sc = null;
			String savePath = "/WEB-INF";
			File file = new File(sc.getRealPath("/") + savePath, tempFile.getName());
		      item.write(file);
		      req.setAttribute("upload.message", "上传文件成功！");
		     }else{
		      req.setAttribute("upload.message", "没有选择上传文件！");
		     }
		    }
		   }
		  }catch(FileUploadException e){
		   e.printStackTrace();
		  } catch (Exception e) {
		   e.printStackTrace();
		   
		   req.setAttribute("upload.message", "上传文件失败！");
		  }
		 // req.getRequestDispatcher("/message.jsp").forward(req, resp);
		*/
		long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
       CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
               req.getSession().getServletContext());
       //检查form中是否有enctype="multipart/form-data"
       if(multipartResolver.isMultipart(req))
       {
           //将request变成多部分request
           MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)req;
          //获取multiRequest 中所有的文件名
           Iterator iter=multiRequest.getFileNames();
            
           while(iter.hasNext())
           {
               //一次遍历所有文件
               MultipartFile file=multiRequest.getFile(iter.next().toString());
               if(file!=null)
               {
                   String path="E:/springUpload"+file.getOriginalFilename();
                   //上传
                   file.transferTo(new File(path));
               }
                
           }
          
       }
       long  endTime=System.currentTimeMillis();
       System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
		return mv;
	}
}
