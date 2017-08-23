
<% 
session.invalidate();

response.sendRedirect("login.jsp"); 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
response.setHeader("Pragma", "no-cache"); 
response.setDateHeader("Expires", 0);
%>

<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.location.href="login.jsp"; }
</SCRIPT>