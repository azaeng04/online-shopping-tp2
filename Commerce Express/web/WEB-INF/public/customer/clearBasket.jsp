<%@page import="java.util.Enumeration"%>
<%
    Enumeration<String>  enuma = session.getAttributeNames();
    while(enuma.hasMoreElements()){
        session.removeAttribute(enuma.nextElement());        
    }
    session.invalidate();
    response.sendRedirect("logout");
%>
