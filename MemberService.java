
package com.example.service;

import java.util.List;
import com.example.entity.Member;

public interface MemberService {
    public List<Member> list(); // Tüm üyeleri listelemek için

    public boolean delete(Member member); // Üyeyi silmek için

    public boolean saveMember(Member member); // Yeni üye eklemek için

    public boolean updateMember(Member member); // Üye güncellemek için

    public Member getMember(int id); // ID ile üye bilgisi almak için

    public void removeMember(int id); // Üyeyi ID ile silmek için
}
