package com.dev.service;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVo;

public class MemberService {
	private static final MemberVo MemberDAO = null;
	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getinstance();
	
	private MemberService() {}
	public static MemberService getInstance() {
		return service;
	}
	
	public void memberInsert(MemberDAO member) {
		dao.insert(MemberDAO);
	}
	
	public MemberVo memberSearch(MemberVo id) {
		MemberVo member = dao.selectOne(id);
		return member;
	}
	
	public void memberDelete(MemberVo id) {
		dao.delete(id);
	}
}
