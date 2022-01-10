package models;

import java.util.Date;

/* Klasser med gettere og settere for OrderTableModel - velger å behold ubrukte metoder. */
public class OrderTableModel {
    private int orderTableID;
    private Date orderTable_date;
    private UserModel userID;
    private ToolModel toolID;

    public OrderTableModel(int orderTableID, Date orderTable_date, UserModel userID, ToolModel toolID) {
        this.orderTableID = orderTableID;
        this.orderTable_date = orderTable_date;
        this.userID = userID;
        this.toolID = toolID;
    }

    public OrderTableModel() {
    }

    public int getOrderTableID() {
        return orderTableID;
    }

    public void setOrderTableID(int orderTableID) {
        this.orderTableID = orderTableID;
    }

    public Date getOrderTable_date() {
        return orderTable_date;
    }

    public void setOrderTable_date(Date orderTable_date) {
        this.orderTable_date = orderTable_date;
    }

    public UserModel getUserID() {
        return userID;
    }

    public void setUserID(UserModel userID) {
        this.userID = userID;
    }

    public ToolModel getToolID() {
        return toolID;
    }

    public void setToolID(ToolModel toolID) {
        this.toolID = toolID;
    }
}
