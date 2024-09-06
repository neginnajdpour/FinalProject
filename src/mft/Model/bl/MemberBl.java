package mft.Model.bl;

import mft.Model.da.BookDa;
import mft.Model.da.MemberDa;
import mft.Model.entity.Book;
import mft.Model.entity.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberBl{

    public static void save(Member member) throws Exception {
        try(MemberDa memberDa = new MemberDa()){
            memberDa.save(member);
        }
    }

    public static void delete(Member member) throws Exception {
        try(MemberDa memberDa = new MemberDa()){
            memberDa.delete(member);
        }
    }

    public static void update(Member member) throws Exception {
        try(MemberDa memberDa = new MemberDa()){
            memberDa.edit(member);
        }
    }

    public static Member getMember(int memberId) throws Exception {
        Member member = new Member();
        try(MemberDa memberDa = new MemberDa()){
            member = memberDa.getMember(memberId).get();
        }
        return member;
    }

    public static List<Member> getAllMembers() throws Exception {
        List<Member> members = new ArrayList<>();

        try(MemberDa memberDa = new MemberDa()){
            members = memberDa.getAllMembers();
        }
        return members;
    }



}
