package shop.kimseunghyun.member.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shop.kimseunghyun.common.servlet.ModelAndView;
import shop.kimseunghyun.common.servlet.mvc.Controller;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        out.print("asdfasdf");
        return null;
    }
}
