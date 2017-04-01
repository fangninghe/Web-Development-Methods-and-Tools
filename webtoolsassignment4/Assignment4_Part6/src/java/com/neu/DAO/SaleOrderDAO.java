/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.DAO;

import com.neu.POJO.SaleOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class SaleOrderDAO extends DAO {

    Connection conn;
    PreparedStatement ps;

    public void addOrder(List<SaleOrder> list) {
        conn = getConnection();
        try {
            for (SaleOrder saleOrder : list) {

                String query = "insert into sorder values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(query);
                ps.setString(1, saleOrder.getAccountNumber());
                ps.setString(2, saleOrder.getBillToAddressID());
                ps.setString(3, saleOrder.getComment());
                ps.setString(4, saleOrder.getCreditCardApprovalCode());
                ps.setString(5, saleOrder.getCreditCardID());

                ps.setString(6, saleOrder.getCurrencyRateID());
                ps.setString(7, saleOrder.getCustomerID());
                ps.setString(8, saleOrder.getDueDate());
                ps.setString(9, saleOrder.getFreight());
                ps.setString(10, saleOrder.getModifiedDate());

                ps.setString(11, saleOrder.getOnlineOrderFlag());
                ps.setString(12, saleOrder.getOrderDate());
                ps.setString(13, saleOrder.getPurchaseOrderNumber());
                ps.setString(14, saleOrder.getRevisionNumber());
                ps.setString(15, saleOrder.getSalesOrderID());

                ps.setString(16, saleOrder.getSalesOrderNumber());
                ps.setString(17, saleOrder.getSalesPersonID());
                ps.setString(18, saleOrder.getShipDate());
                ps.setString(19, saleOrder.getShipMethodID());
                ps.setString(20, saleOrder.getShipToAddressID());

                ps.setString(21, saleOrder.getStatus());
                ps.setString(22, saleOrder.getSubTotal());
                ps.setString(23, saleOrder.getTaxAmt());
                ps.setString(24, saleOrder.getTerritoryID());
                ps.setString(25, saleOrder.getTotalDue());

                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaleOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);

        }
    }
}
