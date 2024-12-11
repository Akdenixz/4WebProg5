
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDao;
import com.example.entity.Member;
import com.example.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<Member> list() {
        return memberDao.list();
    }

    @Override
    public boolean delete(Member member) {
        return memberDao.delete(member);
    }

    @Override
    public boolean saveMember(Member member) {
        return memberDao.saveMember(member);
    }

    @Override
    public Member getMember(int id) {
        return memberDao.getMember(id);
    }

    @Override
    public void removeMember(int id) {
        memberDao.removeMember(id);
    }

    @Override
    public boolean updateMember(Member member) {
        return memberDao.updateMember(member);
    }
}
