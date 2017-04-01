/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.TagHandler;

import com.neu.DAO.SaleOrderDAO;
import com.neu.POJO.SaleOrder;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Alex
 */
public class MyTagHandler extends SimpleTagSupport {

    private String filename;
    List<SaleOrder> saleOrderList = new ArrayList();

    public MyTagHandler() {

    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void ReadFile(String filename) throws ClassNotFoundException, SQLException {
        //List<SaleOrder> saleOrderList = new ArrayList();
        SaleOrderDAO saleOrderDAO = new SaleOrderDAO();
        Class.forName("org.relique.jdbc.csv.CsvDriver");
        Connection conn = DriverManager.getConnection("jdbc:relique:csv:C:\\Users\\Alex\\Desktop\\webtool4");
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery("SELECT * FROM " + filename);

        while (results.next()) {
            SaleOrder saleOrder = new SaleOrder();

            saleOrder.setAccountNumber(results.getString("AccountNumber"));
            saleOrder.setBillToAddressID(results.getString("BillToAddressID"));
            saleOrder.setComment(results.getString("Comment"));
            saleOrder.setCreditCardApprovalCode(results.getString("CreditCardApprovalCode"));

            saleOrder.setCreditCardID(results.getString("CreditCardID"));
            saleOrder.setCurrencyRateID(results.getString("CurrencyRateID"));
            saleOrder.setCustomerID(results.getString("CustomerID"));
            saleOrder.setDueDate(results.getString("DueDate"));

            saleOrder.setFreight(results.getString("Freight"));
            saleOrder.setModifiedDate(results.getString("ModifiedDate"));
            saleOrder.setOnlineOrderFlag(results.getString("OnlineOrderFlag"));
            saleOrder.setOrderDate(results.getString("OrderDate"));

            saleOrder.setPurchaseOrderNumber(results.getString("PurchaseOrderNumber"));
            saleOrder.setRevisionNumber(results.getString("RevisionNumber"));
            saleOrder.setSalesOrderID(results.getString("SalesOrderID"));
            saleOrder.setSalesOrderNumber(results.getString("SalesOrderNumber"));

            saleOrder.setSalesPersonID(results.getString("SalesPersonID"));
            saleOrder.setShipDate(results.getString("ShipDate"));
            saleOrder.setShipMethodID(results.getString("ShipMethodID"));
            saleOrder.setShipToAddressID(results.getString("ShipToAddressID"));

            saleOrder.setStatus(results.getString("Status"));
            saleOrder.setSubTotal(results.getString("SubTotal"));
            saleOrder.setTaxAmt(results.getString("TaxAmt"));
            saleOrder.setTerritoryID(results.getString("TerritoryID"));

            saleOrder.setTotalDue(results.getString("TotalDue"));

            saleOrderList.add(saleOrder);
        }
        conn.close();
        saleOrderDAO.addOrder(saleOrderList);
    }

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        try {
            ReadFile(filename);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.print("<table id='table1'><td id='head'>salesOrderID</td><td>revisionNumber</td><td>orderDate</td>"
                + "<td>dueDate</td><td>shipDate</td><td>status</td><td>onlineOrderFlag</td><td>salesOrderNumber</td>"
                + "<td>purchaseOrderNumber</td><td>accountNumber</td><td>customerID></td><td>salesPersonID</td>"
                + "<td>territoryID</td><td>billToAddressID</td><td>shipToAddressID</td><td>shipMethodID</td>"
                + "<td>creditCardID</td><td>creditCardApprovalCode</td><td>currencyRateID</td><td>subTotal</td>"
                + "<td>taxAmt</td><td>freight</td><td>totalDue</td><td>comment</td><td>modifiedDate</td></tr>");

        for (SaleOrder saleOrder : saleOrderList) {

            out.print("<tr><td>" + saleOrder.getSalesOrderID() + "</td><td>" + saleOrder.getRevisionNumber() + "</td>"
                    + "<td>" + saleOrder.getOrderDate() + "</td><td>" + saleOrder.getDueDate() + "</td>"
                    + "<td>" + saleOrder.getStatus() + "</td><td>" + saleOrder.getOnlineOrderFlag() + "</td>"
                    + "<td>" + saleOrder.getSalesOrderNumber() + "</td><td>" + saleOrder.getPurchaseOrderNumber() + "</td>"
                    + "<td>" + saleOrder.getAccountNumber() + "</td><td>" + saleOrder.getCustomerID() + "</td>"
                    + "<td>" + saleOrder.getSalesPersonID() + "</td><td>" + saleOrder.getTerritoryID() + "</td>"
                    + "<td>" + saleOrder.getBillToAddressID() + "</td><td>" + saleOrder.getShipToAddressID() + "</td>"
                    + "<td>" + saleOrder.getShipMethodID() + "</td><td>" + saleOrder.getCreditCardID() + "</td>"
                    + "<td>" + saleOrder.getCreditCardApprovalCode() + "</td><td>" + saleOrder.getCurrencyRateID() + "</td>"
                    + "<td>" + saleOrder.getSubTotal() + "</td><td>" + saleOrder.getTaxAmt() + "</td>"
                    + "<td>" + saleOrder.getFreight() + "</td><td>" + saleOrder.getTotalDue() + "</td>"
                    + "<td>" + saleOrder.getShipDate() + "</td><td>" + saleOrder.getComment() + "</td>"
                    + "<td>" + saleOrder.getModifiedDate() + "</td></tr>");
        }
        out.print("</table>");

    }
}
