package shop.kimseunghyun.common.servlet.mvc;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shop.kimseunghyun.common.servlet.ModelAndView;

import java.io.IOException;

public interface Controller {
	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws IOException;
}
