package mft.model.bl;

import mft.model.da.MemberDa;
import mft.model.entity.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberBl{

    public static void save(Member member) throws Exception {
        try(MemberDa memberDa = new MemberDa()){
            memberDa.save(member);
        }
    }

    public static void delete(Integer NationalID) throws Exception {
        try(MemberDa memberDa = new MemberDa()){
            memberDa.delete(NationalID);
        }
    }

    public static void update(Member member) throws Exception {
        try(MemberDa memberDa = new MemberDa()){
            memberDa.update(member);
        }
    }

    public static Member getMember(Integer NationalID) throws Exception {
        Member member = new Member();
        try(MemberDa memberDa = new MemberDa()){
            member = memberDa.getMember(NationalID).get();
        }
        return member;
    }

    public static List<Member> getAllMembers(int nationalId) throws Exception {
        List<Member> members = new ArrayList<>();

        try(MemberDa memberDa = new MemberDa()){
            members = memberDa.getAllMembers(nationalId);
        }
        return members;
    }

    public static List<Member> getAllMembers() throws Exception {
        List<Member> members = new ArrayList<>();

        try(MemberDa memberDa = new MemberDa()){
            members = memberDa.getAllMembers();
        }
        return members;
    }



}
