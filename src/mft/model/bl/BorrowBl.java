package mft.model.bl;

import mft.model.da.BorrowDa;
import mft.model.entity.Borrow;

import java.util.List;

public class BorrowBl {
    public static void save(Borrow borrow) throws Exception {
        try(BorrowDa borrowDa = new BorrowDa()){
            borrowDa.save(borrow);
        }
    }
    public static List<Borrow> getBorrowed() throws Exception {
        try(BorrowDa borrowDa = new BorrowDa()){
            return borrowDa.getBorrowed();
        }
    }
}
