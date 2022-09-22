package shop.kimseunghyun.common.servlet;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shop.kimseunghyun.common.servlet.context.ApplicationContext;
import shop.kimseunghyun.common.servlet.mapper.SimpleUrlHandlerMapping;
import shop.kimseunghyun.common.servlet.mvc.Controller;
import shop.kimseunghyun.common.servlet.view.InternalResourceViewResolver;

import java.io.IOException;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private ApplicationContext applicationContext;
	private SimpleUrlHandlerMapping simpleUrlHandlerMapping;
	private InternalResourceViewResolver internalResourceViewResolver;
    /**
     * Default constructor. 
     */
    public DispatcherServlet() {
        // TODO Auto-generated constructor stub
    }

    
    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("1111111");
		ServletContext application=this.getServletContext();
		applicationContext=new ApplicationContext(config,application);
		simpleUrlHandlerMapping=SimpleUrlHandlerMapping.getInstance(application);
		internalResourceViewResolver=InternalResourceViewResolver.getInstance(application);
	}




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");

/*		Controller controller=simpleUrlHandlerMapping.getController(applicationContext, request);
		ModelAndView mv =controller.handleRequest(request, response);
		internalResourceViewResolver.resolveView(mv, request, response);
		연습
		*/


		Controller controller=simpleUrlHandlerMapping.getController(applicationContext,request);
		ModelAndView modelAndView=controller.handleRequest(request,response);
		if(modelAndView!=null){
			ServletContext application=this.getServletContext();
			internalResourceViewResolver.resolveView(modelAndView,request,response);
		}
	}
}
