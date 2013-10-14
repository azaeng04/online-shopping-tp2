<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">
        <title>${title}</title>
        <link href="resources/threeRegion.css" rel="stylesheet" type="text/css"/>
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        <link href="resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
        <link href="resources/bootstrap/css/myStyles.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" src="jquery.dropdown.css" />
        <script type="text/javascript" src="jquery.dropdown.js"></script>        
        <script>
            function qty(name)
            { 
                var qty = document.getElementById(name).value;
                if(isNaN(qty))
                    {
                        alert("Invalid Idiot");
                        document.getElementById(name).value=0;
                    }
                
            }
            
        </script>
    </head>