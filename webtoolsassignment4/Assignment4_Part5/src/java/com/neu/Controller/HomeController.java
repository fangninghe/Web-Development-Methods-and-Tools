/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.Controller;

import com.neu.DAO.SaleOrderDAO;
import com.neu.POJO.SaleOrder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Alex
 */
public class HomeController implements Controller {

    SaleOrderDAO saleOrderDAO;
    List<SaleOrder> saleOrderList = new ArrayList();

    public HomeController(SaleOrderDAO saleOrderDAO) {
        this.saleOrderDAO = saleOrderDAO;
//         saleOrderList = new ArrayList();
    }

    public HomeController() {

    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView();
        String action = hsr.getParameter("action");
        if (action.equalsIgnoreCase("showform")) {

            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection conn = DriverManager.getConnection("jdbc:relique:csv:C:\\Users\\Alex\\Desktop\\webtool4");
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM " + hsr.getParameter("formname"));

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

            mv.addObject("saleOrderList", saleOrderList); 
            mv.addObject("task", "showform");
            mv.setViewName("index");
           

        } else if (action.equalsIgnoreCase("save")) {
           
            if (hsr.isUserInRole("admin")) {
                saleOrderDAO.addOrder(saleOrderList);
                mv.addObject("size", saleOrderList.size());
                mv.addObject("task", "showresult");
                mv.setViewName("index");
                
            } else {
                mv.addObject("task", "wrongstatus");
                mv.setViewName("index");
            }

        }

        return mv;
    }

}
