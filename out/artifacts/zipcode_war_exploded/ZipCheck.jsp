<%@ page import="dao.ZipcodeDTO" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: yuhyuna
  Date: 2019-06-20
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:useBean id="zip" class="dao.ZipcodeDAO" />
<%
    request.setCharacterEncoding("utf-8");

    String check=request.getParameter("check");
    String dong=request.getParameter("dong");
    System.out.println("check=>"+check+",area3=>"+dong);//y,null
    //MemberDAO memMgr=new MemberDAO();
    List<ZipcodeDTO> zipcodeList=zip.getZipcodeList(dong);
    int totalList=zipcodeList.size();
    System.out.println("검색된 총레코드수(totalList)=>"+totalList);
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

        function sendAddress(zipcode,si,gugun,dong,building){
            var address=si+" "+gugun+" "+dong+" "+building
            opener.document.regForm.mem_zipcode.value=zipcode;
            opener.document.regForm.mem_address.value=address;
            self.close();
        }
    </script>
</head>
<body>
<b>우편번호 찾기</b>
<table>
    <form name="zipForm" method="post" action="ZipCheck.jsp">
        <tr>
            <td><br>
                동이름 입력:<input type="text"  name="dong">
                <input type="button" value="검색"  onclick="dongCheck()">
            </td>
        </tr>
        <input type="hidden" name="check"  value="n">
    </form>

<%
    //검색어를 입력하고 검색버튼을 눌렀다면
    if(check.equals("n")){
        if(zipcodeList.isEmpty()){  //검색된 레코드가 없다면 if(zipcodeList.size()==0) {
%>
<tr><td align="center">
    <br>검색된 레코드가 없습니다.
</td>
</tr>
<% }else { %>
<tr><td align="center"><br>
    *검색후 ,아래 우편번호를 클릭하면 자동으로
    입력됩니다</td></tr>
<%
    for(int i=0;i<totalList;i++){
        ZipcodeDTO zipBean=zipcodeList.get(i);//zipcodeList.get(i);
        String tempZipcode=zipBean.getZipcode();//우편번호
        String tempSi=zipBean.getSi().trim();//시 ->"서울       "->"서울"
        String tempGugun=zipBean.getGugun().trim();//구
        String tempDong=zipBean.getDong().trim();//동
        String tempBuilding=zipBean.getBuilding().trim();//나머지
%>
<tr><td>
    <a href="JavaScript:sendAddress('<%=tempZipcode %>',  '<%=tempSi%>',  '<%=tempGugun%>',  '<%=tempDong%>',   '<%=tempBuilding%>')">
        <%=tempZipcode %>&nbsp;<%=tempSi%>&nbsp;<%=tempGugun%>&nbsp; <%=tempDong%>&nbsp;<%=tempBuilding%>
    </a><br>

    <%
                }//for
            }//else if(inner if)
        }//outer if
    %>
</td></tr>
<tr><td align="center"><br>
    <a href="JavaScript:this.close()">닫기</a>
</body>
</html>
