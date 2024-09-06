package mft.Model.bl;

import mft.Model.da.MemberDa;
import mft.Model.entity.Member;

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


}
