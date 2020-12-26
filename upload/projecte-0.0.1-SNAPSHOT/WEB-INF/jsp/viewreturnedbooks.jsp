<%-- 
    Document   : ShowBooks
    Created on : Nov 28, 2018, 12:01:28 AM
    Author     : saiv0001
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="newcss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="nav1" align="center">
                <ul >
                    <li class="active"><a href="#">Home</a></li>
                    <li class="dropdown"><a href="#">Author</a>
                        <div class="dropdown-content">
                    <a href="viewauthor">View Author</a>
                    <a href="addauthor">Add New Author</a>
                    <a href="modifyauthor_1">Modify Author</a>
                    <a href="deleteauthor">Delete Author</a>
                </div></li>
                
                    <li class="dropdown"><a href="#">Genres</a>
                        <div class="dropdown-content">
                    <a href="viewgenre">View Genres</a>
                    <a href="addgenre">Add New Genre</a>
                    <a href="modifygenre_1">Modify Genre</a>
                    <a href="deletegenre">Delete Genre</a>
                </div></li>
                    <li class="dropdown"><a href="#">Books</a>
                        <div class="dropdown-content">
                    <a href="viewbook">View Books</a>
                    <a href="addbook">Add New Book</a>
                    <a href="modifybook">Modify Book</a>
                    <a href="deletebook">Delete Book</a>
              </div></li>
                    <li class="dropdown"><a href="#">Issuers</a>
                <div class="dropdown-content">
                    <a href="viewissuer">View Issuers</a>
                    <a href="addissuer">Add New Issuer</a>
                    <a href="modifyissuer">Modify Issuer</a>
                    <a href="deleteissuer">Delete Issuer</a>
                </div></li>
                    <li class="dropdown"><a href="#">Reports</a>
                <div class="dropdown-content">
                    <a href="issuebook">Issue book</a>
                    <a href="returnbook">Return book</a>
                    <a href="issuersandbooks">Issuers and Books list</a>
                    <a href="search">Search</a>
                    </div></li>
                </ul>
            </div>
        <h1>List of issuers</h1>
        <div id="course-table">
        <table border="1">
            <tr>
                <th>Id</th>
                <td><b>Book name</b></td>
                <td><b>Issuer name</b></td>
            </tr>
            <c:forEach var="row" items="${list}">
                <tr>
               <td>${row.rb_id}</td>
                <td>${row.issuedbookdetails.bookdetails.book_name}</td>
                <td>${row.issuedbookdetails.issuerdetails.name}</td>
              
                </tr>
            </c:forEach>
            
            
        </table><br>
        </div>
      
    </body>
</html>
