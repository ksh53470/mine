package shop.kimseunghyun.common.servlet.mvc;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shop.kimseunghyun.common.servlet.ModelAndView;

public class UrlFilenameViewController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
									  HttpServletResponse response) {
		// TODO Auto-generated method stub
		String uri=request.getRequestURI();
		String contextPath=request.getContextPath();
		int sIndex=contextPath.length()+1;
		int eIndex=uri.lastIndexOf(".");
		System.out.println(eIndex);
		String viewName=uri.substring(sIndex,eIndex);
/*		System.out.println("qwer");
		System.out.println(viewName);*/
		ModelAndView modelAndView=new ModelAndView(viewName,null);
		return modelAndView;
	}
}
