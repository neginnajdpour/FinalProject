package mft.model.bl;

import mft.model.da.BorrowDa;
import mft.model.entity.Borrow;

public class BorrowBl {
    public static void save(Borrow borrow) throws Exception {
        try(BorrowDa borrowDa = new BorrowDa()){
            borrowDa.save(borrow);
        }
    }
}
