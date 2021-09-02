/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package dao;

import dbcontext.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Stock;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class StockDAO {

    /* update batch function . Insert many rows to table in database*/
    public int updateBatch(List<Stock> stocks) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Stock(stockID,stockName,[address],dateAvailable,note) "
                + "VALUES (?,?,?,?,?)";
        try {
            db = new DBContext();
            con = db.getConnection();
            /* Transaction start here */
            con.setAutoCommit(false);   
            ps = con.prepareStatement(sql);
            for (Stock stock : stocks) {
                ps.setInt(1, stock.getStockID());
                ps.setString(2, stock.getStockName());
                ps.setString(3, stock.getAddress());
                ps.setDate(4, stock.getDateAvailable());
                ps.setString(5, stock.getNote());
                ps.addBatch();
            }
            int[] result = ps.executeBatch();
            con.commit();   // if there is no error in transaction ,  commit will be called to store data from connection object into db
            /* Transaction end here */
            return result.length;
        } catch (Exception e) {
            con.rollback(); // if there is an error in transaction , rollback will be called and all data in batch will never commit to db
            throw e;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }
}
