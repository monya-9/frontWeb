package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVo;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원삭제");
		//파라미터 받기
		String id = request.getParameter("id");
		
		//유효성 체크
		
		//Vo에 담기
		MemberVo member = new MemberVo();
		member.setId(id);
		
		//서비스로직
		int r = MemberDAO.getinstance().delete(member);
		
		//결과저장
		
		
		//뷰페이지 이동
		request.getRequestDispatcher("/member/memberDeleteOutput.jsp").forward(request, response);
	}

}
