package shop.kimseunghyun.member.service;

import shop.kimseunghyun.member.dao.MemberDAOImpl;
import shop.kimseunghyun.member.dto.MemberDTO;

import java.util.List;

public class MemberServiceFacadeImpl implements MemberServiceFacade{

    private static MemberServiceFacade instance=new MemberServiceFacadeImpl();
    public static MemberServiceFacade getInstance(){
        return instance;
    }
    @Override
    public List<MemberDTO> getMemberList() {
        // TODO Auto-generated method stub
        return MemberDAOImpl.getInstance().selectMemberList();
    }
    @Override
    public void addMember(MemberDTO member) {
        // TODO Auto-generated method stub
        MemberDAOImpl.getInstance().insertMember(member);
    }

    @Override
    public void removeMember(String id) {
// TODO Auto-generated method stub
        MemberDAOImpl.getInstance().deletetMember(id);
    }


    @Override
    public void updateMember(MemberDTO member) {
        MemberDAOImpl.getInstance().updatetMember(member);
    }

    @Override
    public MemberDTO getMember(String id) {
        // TODO Auto-generated method stub
        return MemberDAOImpl.getInstance().selectMember(id);
    }
}