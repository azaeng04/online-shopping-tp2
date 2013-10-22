<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>${title}</title>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <link href="resources/threeRegion.css" rel="stylesheet" type="text/css"/>
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        <link href="resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myStyles.css" rel="stylesheet">     
        <script src="resources/bootstrap/js/jquery.js"></script>
        <script src="resources/bootstrap/js/bootstrap.js"></script>
        <script>
            $(function() {
//                var url = document.getElementById(id).value;
            <%
                String url = request.getRequestURL().toString();
                String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
//                    String catID = baseURL.
//                    if(){
//                        
//                    } else{
//                        
//                    }
//                    out.println("var availableTags = [");
//
//                    out.println("");
//                    out.println("];");
%>
//                $("#tags").autocomplete({
//                    source: availableTags
//                });
            });

            function goToPage(id) {
                var url = document.getElementById(id).value;
                if (url != "") {
                    window.location = url;
                }
                return window.location;
            }
        </script>
    </head>