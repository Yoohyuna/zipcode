<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="dao.ZipcodeDTO" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
  Created by IntelliJ IDEA.
  User: yuhyuna
  Date: 2019-06-20
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>

<head>
    <title>Title</title>
    <script>
        function dongCheck(){
            if(document.zipForm.dong.value==""){
                alert("동이름을 먼저 입력하세요!");
                document.zipForm.dong.focus();
                return;
            }
            document.zipForm.submit();
        }

    </script>
</head>
<body>
<b>우편번호 찾기</b>
<table>
    <form name="zipForm" method="post" action="ZipcodeAction">
        <tr>
            <td><br>
                동이름 입력:<input type="text"  name="dong">
                <input type="button" value="검색"  onclick="dongCheck()">
            </td>
        </tr>
        <input type="hidden" name="check"  value="n">
    </form>

<tr><td align="center">
    <br>검색된 레코드가 없습니다.
</td>
</tr>

<tr><td align="center"><br>
    *검색후 ,아래 우편번호를 클릭하면 자동으로 입력됩니다.</td></tr>
    <%--
   <tr><td>
      <a href="JavaScript:sendAddress('<%=tempZipcode %>',  '<%=tempSi%>',  '<%=tempGugun%>',  '<%=tempDong%>',   '<%=tempBuilding%>')">

    /a>


    <br>
</td></tr>--%>

    <c:forEach items="${lists}">
    <tr>

        <th>${zipcode}</th>
        <td>${si}</td>
        <td>${gugun}</td>
        <td>${dong}</td>
        <td>${building}</td>

    </tr>

    </c:forEach>

<tr><td align="center"><br>
    <a href="JavaScript:this.close()">닫기</a>
</body>
</html>
