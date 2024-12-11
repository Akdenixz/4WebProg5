
package com.example.dao;

import java.util.List;
import com.example.entity.Member;

public interface MemberDao {

    public List<Member> list(); // Tüm üyeleri listelemek için

    public boolean delete(Member member); // Üyeyi silmek için

    public Member getMember(int id); // ID ile üye bilgisi almak için

    public void removeMember(int id); // Üyeyi ID ile silmek için

    public boolean saveMember(Member member); // Yeni üye eklemek için

    public boolean updateMember(Member member); // Üye güncellemek için
}
