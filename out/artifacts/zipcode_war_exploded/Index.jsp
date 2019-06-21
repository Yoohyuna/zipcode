<%--
  Created by IntelliJ IDEA.
  User: yuhyuna
  Date: 2019-06-20
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="java.util.*"%>
<%@ page import="models.ZipcodeDTO" %>
<%@ page import="dao.ZipcodeDAO" %>

<html>
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
<center>
    <b>우편번호 찾기</b>
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

        <tr><td align="center">
            <br>검색된 레코드가 없습니다.
        </td>
        </tr>

        <tr><td align="center"><br>
            *검색후 ,아래 우편번호를 클릭하면 자동으로 입력됩니다</td></tr>

        <tr><td>

        </td></tr>
        <tr><td align="center"><br>
            <a href="JavaScript:this.close()">닫기</a>
    </table>
</center>
</body>
</html>