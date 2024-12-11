
package com.example.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Member;
import com.example.dao.MemberDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public List<Member> list() {
        return sessionFactory.getCurrentSession().createCriteria(Member.class).list();
    }

    @Override
    public boolean delete(Member member) {
        try {
            sessionFactory.getCurrentSession().delete(member);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean saveMember(Member member) {
        sessionFactory.getCurrentSession().save(member);
        return true;
    }

    @Override
    public Member getMember(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Member member = (Member) session.get(Member.class, id);
        return member;
    }

    @Override
    public void removeMember(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Member member = session.load(Member.class, id);
        if (member != null) {
            session.delete(member);
        }
        logger.info("Member deleted successfully, Member details=" + member);
    }

    @Override
    public boolean updateMember(Member member) {
        sessionFactory.getCurrentSession().update(member);
        return true;
    }
}
