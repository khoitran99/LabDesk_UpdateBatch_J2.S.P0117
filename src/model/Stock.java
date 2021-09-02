/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class Stock {

    private int stockID;
    private String stockName;
    private String address;
    private Date dateAvailable;
    private String note;

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(Date dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Stock() {
    }

    public Stock(int stockID, String stockName, String address, Date dateAvailable, String note) {
        this.stockID = stockID;
        this.stockName = stockName;
        this.address = address;
        this.dateAvailable = dateAvailable;
        this.note = note;
    }

    public List<Stock> getStockData() {
        List<Stock> listStock = new ArrayList<>();
        listStock.add(new Stock(1, "Stock one", "No1-Washington", Date.valueOf("2010-05-11"), ""));
        listStock.add(new Stock(2, "Stock two", "372 Cave Town", Date.valueOf("2011-07-09"), ""));
        listStock.add(new Stock(3, "Stock three", "Nary angel-890", Date.valueOf("2010-05-13"), ""));
        listStock.add(new Stock(4, "Stock four", "Twin tower-01", Date.valueOf("2015-07-04"), ""));
        listStock.add(new Stock(5, "Stock five", "Victory anniversary", Date.valueOf("2014-12-07"), ""));
        return listStock;
    }

}
