package shop.kimseunghyun.member.dao;

import shop.kimseunghyun.common.dao.DataAccessException;
import shop.kimseunghyun.common.sl.ServiceLocator;
import shop.kimseunghyun.member.dto.MemberDTO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO{
    private static MemberDAOImpl instance;

    private MemberDAOImpl() {
    }

    public static MemberDAO getInstance() {
        if (instance == null) instance = new MemberDAOImpl();
        return instance;
    }

    public List<MemberDTO> selectMemberList() {
        // TODO Auto-generated method stub
        List<MemberDTO> v = new ArrayList<MemberDTO>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            StringBuffer query = new StringBuffer();
            query.append("select * from member");

            DataSource dataSource = ServiceLocator.getInstance().getDataSource("jdbc/myoracle");
            con = dataSource.getConnection();
            pstmt = con.prepareStatement(query.toString());

            rs = pstmt.executeQuery();
            while (rs.next()) {
                MemberDTO member = new MemberDTO();
                member.setId(rs.getString("id"));
                member.setPw(rs.getString("pw"));
                member.setAddr(rs.getString("addr"));
                member.setTel(rs.getString("tel"));
                v.add(member);
            }
            return v;
        } catch (Exception sqle) {
            throw new DataAccessException(sqle.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (pstmt != null) {
                    pstmt.close();
                    pstmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void insertMember(MemberDTO member) throws DataAccessException {
        // TODO Auto-generated method stub

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            StringBuffer query = new StringBuffer();
            query.append("insert into member values(?,?,?,?)");

            DataSource dataSource = ServiceLocator.getInstance().getDataSource("jdbc/myoracle");
            con = dataSource.getConnection();
            pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPw());
            pstmt.setString(3, member.getAddr());
            pstmt.setString(4, member.getTel());
            pstmt.executeUpdate();

        } catch (Exception sqle) {
            throw new DataAccessException(sqle.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                    pstmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (Exception e) {
            }
        }
    }


    @Override
    public MemberDTO selectMember(String id) throws DataAccessException {
        // TODO Auto-generated method stub

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            StringBuffer query = new StringBuffer();
            query.append("select * from member where id=?");

            DataSource dataSource = ServiceLocator.getInstance().getDataSource("jdbc/myoracle");
            con = dataSource.getConnection();
            pstmt = con.prepareStatement(query.toString());
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            MemberDTO member = null;
            while (rs.next()) {
                member = new MemberDTO();
                member.setId(rs.getString("id"));
                member.setPw(rs.getString("pw"));
                member.setAddr(rs.getString("addr"));
                member.setTel(rs.getString("tel"));
            }
            return member;
        } catch (Exception sqle) {
            throw new DataAccessException(sqle.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (pstmt != null) {
                    pstmt.close();
                    pstmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (Exception e) {
            }
        }
    }

    @Override
    public MemberDTO updatetMember(MemberDTO member) throws DataAccessException {
        return null;
    }

    @Override
    public void deletetMember(String id) {
// TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            StringBuffer query = new StringBuffer();
            query.append("delete from member where id=?");

            DataSource dataSource=ServiceLocator.getInstance().getDataSource("jdbc/myoracle");
            con = dataSource.getConnection();
            pstmt = con.prepareStatement(query.toString());

            pstmt.setString(1, id);
            pstmt.executeUpdate();

        } catch(Exception sqle) {
            throw new DataAccessException(sqle.getMessage());
        } finally {
            try{
                if(pstmt!=null){pstmt.close(); pstmt=null; }
                if(con!=null){con.close(); con=null; }
            }catch(Exception e){}
        }
    }
}
