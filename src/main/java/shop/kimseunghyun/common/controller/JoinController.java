
package shop.kimseunghyun.common.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shop.kimseunghyun.common.servlet.ModelAndView;
import shop.kimseunghyun.common.servlet.mvc.Controller;
import shop.kimseunghyun.member.dto.MemberDTO;
import shop.kimseunghyun.member.service.MemberServiceFacade;
import shop.kimseunghyun.member.service.MemberServiceFacadeImpl;

import java.util.HashMap;

public class JoinController implements Controller {


	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
									  HttpServletResponse response){
		// TODO Auto-generated method stub

		System.out.println("됩니다");
		 HashMap<String,Object> map=new HashMap<String,Object>();
		ModelAndView mav=null;
	 	try {		
			MemberServiceFacade sf= MemberServiceFacadeImpl.getInstance();
			MemberDTO bean=new MemberDTO();
			bean.setId(request.getParameter("id"));
			bean.setPw(request.getParameter("pw"));
			bean.setAddr(request.getParameter("addr"));
			bean.setTel(request.getParameter("tel"));
			sf.addMember(bean);
	 		 
	 		 mav=new ModelAndView("redirect:member/list.do",null);
	 		 map.put("errorCode", 0);
	 		map.put("errorMsg", "success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
	 		 map.put("errorCode", -1);
	 		 map.put("errorMsg", e.getMessage());
	 		 mav=new ModelAndView("error",map);
		}	
		return mav;
	}
}
