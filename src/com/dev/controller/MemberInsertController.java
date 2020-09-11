package com.dev.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVo;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원등록");
		//파라미터를 Vo에 담기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String reason = request.getParameter("reason");
		String maileyn = request.getParameter("maileyn");
		String[] hobby = request.getParameterValues("hobby");
		
		//유효성체크
		
		
		
		
		MemberVo member = new MemberVo();
		member.setId(id);
		member.setPw(pw);
		member.setGender(gender);
		member.setJob(job);
		member.setReason(reason);
		member.setMailyn(maileyn);
		member.setHobby(Arrays.deepToString(hobby));
		
		//서비스처리
		int r = MemberDAO.getinstance().insert(member);
		
		//결과저장
		request.setAttribute("cnt", r);
		
		//뷰페이지로 이동
		request.getRequestDispatcher("/member/memberInsertOutput.jsp").forward(request, response);
	}

}
