package cn.javass.chapter2.web.controller;


import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
public class TestController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//1銆佹敹闆嗗弬鏁�
		//2銆佺粦瀹氬弬鏁板埌鍛戒护瀵硅薄
		//3銆佽皟鐢ㄤ笟鍔″璞�
		//4銆侀�夋嫨涓嬩竴涓〉闈�
		ModelAndView mvi = new ModelAndView();
		//娣诲姞妯″瀷鏁版嵁 鍙互鏄换鎰忕殑POJO瀵硅薄
		mvi.addObject("message", "Hello Wor!");
		//璁剧疆閫昏緫瑙嗗浘鍚嶏紝瑙嗗浘瑙ｆ瀽鍣ㄤ細鏍规嵁璇ュ悕瀛楄В鏋愬埌鍏蜂綋鐨勮鍥鹃〉闈�
		mvi.setViewName("test");
		
		//String test = req.getParameter("test");
		//System.out.println(test);
		//resp.getWriter().write(test);
		
		return mvi;
		
	}
	
}

