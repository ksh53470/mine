package shop.kimseunghyun.member.dao;

import shop.kimseunghyun.common.dao.DataAccessException;
import shop.kimseunghyun.member.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
    public List<MemberDTO> selectMemberList() throws DataAccessException;
    public MemberDTO selectMember(String id) throws DataAccessException ;
    public void insertMember(MemberDTO member) throws DataAccessException ;

    //연습--------------------------
    public MemberDTO updatetMember(MemberDTO member) throws DataAccessException ;

    public void deletetMember(String id) throws DataAccessException ;
}
