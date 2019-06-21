<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="models.ZipcodeDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="dao.ZipcodeDAO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
  Created by IntelliJ IDEA.
  User: yuhyuna
  Date: 2019-06-20
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%
    String list = request.getParameter("list");
%>

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

        function checkPostClose(zipcode,si,gugun,dong,building){
            var address=si+" "+gugun+" "+dong+" "+building
            opener.regForm.mem_zipcode.value = zipcode;
            opener.regForm.mem_address.value = address;
            self.close();
        }


    </script>
</head>
<body>
<b align="center">우편번호 찾기</b>
<table>
    <form name="zipForm" method="post" action="/ZipcodeAction">
        <tr>
            <td><br>
                동이름 입력:<input type="text"  name="dong">
                <input type="button" value="검색"  onclick="dongCheck()">
            </td>
        </tr>
        <input type="hidden" name="check"  value="n">
    </form>


</tr>
<tr>
    <td colspan="2">
    *검색후 ,아래 우편번호를 클릭하면 자동으로 입력됩니다.</td>
</tr>

        <tr align="center">
            <td align="center">우편번호</td>
            <td align="center">주소</td>
        </tr>

        <c:forEach var="list" items="${list}">
        <tr>
        <td>
        <a href="#" onclick="checkPostClose('${list.zipcode}','${list.si}', '${list.gugun}', '${list.dong}', '${list.building}')">
                ${list.zipcode}</a>
        </td>
        <td><a href="#" onclick="checkPostClose('${list.zipcode}','${list.si}', '${list.gugun}', '${list.dong}', '${list.building}')">
                ${list.si}시 ${list.gugun} ${list.dong} ${list.building}
            </a>
        </td>

    </tr>

    </c:forEach>




<tr><td align="center"><br>
    <a href="JavaScript:this.close()">닫기</a>
</td>
</tr>
</table>
</body>
</html>
