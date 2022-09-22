package shop.kimseunghyun.member.service;

import shop.kimseunghyun.member.dto.MemberDTO;

import java.util.List;

public interface MemberServiceFacade {
    public List<MemberDTO> getMemberList();
    public MemberDTO getMember(String id);
    public void addMember(MemberDTO member);

    public void removeMember(String id) ;

    public void updateMember(MemberDTO member);
}
