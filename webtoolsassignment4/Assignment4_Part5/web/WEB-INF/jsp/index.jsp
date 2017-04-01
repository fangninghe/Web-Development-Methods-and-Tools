<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The SaleOrder List</title>
        <style type = 'text/css'>
            #table1,th{
                border: 1px solid black;
                text-align:center;

            }
            td{
                border: 1px solid black;
                text-align:center;
                width: 40;
            }

            #head{
                height: 40px;
            }



        </style>
    </head>

    <body>
        <c:set var="task" value="${requestScope.task}"/>
        <c:choose>
            <c:when test="${task==null}">
                <form action="showform.htm" method="post">
                    <h3>Please Enter the name of Profile: </h3>
                    <input type="text" name="formname"/>
                    <input type="submit" value="submit"/>
                    <input type="hidden" name="action" value="showform"/>
                </form>   
            </c:when>
            <c:when test="${task=='showform'}">
                
                <form action="adddata.htm" method="post">
                    <input type="submit" value="Save Data"/>
                    <input type="hidden" name="action" value="save"/>

                    <table id="table1">
                        <tr id="head">
                            <td>salesOrderID</td>
                            <td>revisionNumber</td>
                            <td>orderDate</td>
                            <td>dueDate</td>

                            <td>shipDate</td>
                            <td>status</td>
                            <td>onlineOrderFlag</td>
                            <td>salesOrderNumber</td>

                            <td>purchaseOrderNumber</td>
                            <td>accountNumber</td>
                            <td>customerID></td>
                            <td>salesPersonID</td>

                            <td>territoryID</td>
                            <td>billToAddressID</td>
                            <td>shipToAddressID</td>
                            <td>shipMethodID</td>

                            <td>creditCardID</td>
                            <td>creditCardApprovalCode</td>
                            <td>currencyRateID</td>
                            <td>subTotal</td>

                            <td>taxAmt</td>
                            <td>freight</td>
                            <td>totalDue</td>
                            <td>comment</td>
                            <td>modifiedDate</td>

                        </tr>

                        <c:forEach var="saleorder" items="${requestScope.saleOrderList}">
                            <tr>
                                <td><c:out value="${saleorder.salesOrderID}"></c:out></td>
                                <td><c:out value="${saleorder.revisionNumber}"></c:out></td>
                                <td><c:out value="${saleorder.orderDate}"></c:out></td>
                                <td><c:out value="${saleorder.dueDate}"></c:out></td>

                                    <td><c:out value="${saleorder.shipDate}"></c:out></td>
                                <td><c:out value="${saleorder.status}"></c:out></td>
                                <td><c:out value="${saleorder.onlineOrderFlag}"></c:out></td>
                                <td><c:out value="${saleorder.salesOrderNumber}"></c:out></td>

                                    <td><c:out value="${saleorder.purchaseOrderNumber}"></c:out></td>
                                <td><c:out value="${saleorder.accountNumber}"></c:out></td>
                                <td><c:out value="${saleorder.customerID}"></c:out></td>
                                <td><c:out value="${saleorder.salesPersonID}"></c:out></td>

                                    <td><c:out value="${saleorder.territoryID}"></c:out></td>
                                <td><c:out value="${saleorder.billToAddressID}"></c:out></td>
                                <td><c:out value="${saleorder.shipToAddressID}"></c:out></td>
                                <td><c:out value="${saleorder.shipMethodID}"></c:out></td>

                                    <td><c:out value="${saleorder.creditCardID}"></c:out></td>
                                <td><c:out value="${saleorder.creditCardApprovalCode}"></c:out></td>
                                <td><c:out value="${saleorder.currencyRateID}"></c:out></td>
                                <td><c:out value="${saleorder.subTotal}"></c:out></td>

                                    <td><c:out value="${saleorder.taxAmt}"></c:out></td>
                                <td><c:out value="${saleorder.freight}"></c:out></td>
                                <td><c:out value="${saleorder.totalDue}"></c:out></td>
                                <td><c:out value="${saleorder.comment}"></c:out></td>
                                <td><c:out value="${saleorder.modifiedDate}"></c:out></td>

                                </tr>
                        </c:forEach>
                    </table>
                </form>
            </c:when>
            <c:when test="${task=='showresult'}">
                <c:out value="${requestScope.size}" ></c:out> Orders are added to the DB
            </c:when>
            <c:when test="${task=='wrongstatus'}">
                <h3>Sorry, you have no right to access the form</h3>
                <a href ="index.htm">Click Here to Go Back the Home Page</a>
            </c:when>
        </c:choose>
    </body>
</html>
