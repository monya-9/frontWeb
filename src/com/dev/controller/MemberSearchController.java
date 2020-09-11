package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVo;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원검색");
		//job에 따라 포워드 페이지 지정
		String path = "memberSearch.jsp";
		String job = request.getParameter("job");
		if(job.equals("delete")) {
			path = "memberDelete.jsp";
		} else if(job.equals("update")) {
			path = "memberUpdate.jsp";
		}
		//파라미터 변수에 저장
		String id = request.getParameter("id");
		
		//유효성 체크
		if(id.isEmpty()) {
			request.setAttribute("error",  "id를 입력");
				
			request.getRequestDispatcher("/member/"+path).forward(request, response);
				return;
		}
		//Vo에 담기
		MemberVo member = new MemberVo();
		member.setId(id);
		//서비스
		MemberVo resultVo = MemberDAO.getinstance().selectOne(member);
		
		//조회결과를 저장 후에 결과 페이지로 포워드
		request.setAttribute("member", resultVo);
		if(job.equals("search")) {
			request.getRequestDispatcher("/member/memberSearchOutput.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/member/"+path).include(request, response);
	}

}
