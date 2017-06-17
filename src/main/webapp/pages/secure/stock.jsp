<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html style="font-family: Arial, sans-serif; margin: 0; padding: 0;">
<head>
    <title>Stock</title>

    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/sha512.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../css/layout.css" />

    <script type="text/javascript">
        function showPopup(title, text)
        {
            //hidePopup(0, 0);
            $('#myPopup #pTitle').html(title);
            $('#myPopup #pText').html(text);
            $('#myPopup').fadeIn(350);
            //document.getElementById('topNavBar').disabled = true;

            var popupOKButton = document.getElementById('popupOKButton');
            if (popupOKButton != null)
            {
                popupOKButton.focus();
            }
        }

        function hidePopup(delayTime, fadeoutTime)
        {
            $('#myPopup').delay(delayTime).fadeOut(fadeoutTime);
            //document.getElementById('topNavBar').disabled = false;
        }
    </script>
</head>
<body style="font-family: Arial, sans-serif; margin: 0; padding: 0;">

<div id="myPopup" class="popup" data-popup="popup-1">
    <div class="popup-inner">
        <div id="pTitle" style="text-align: center;"></div>
        <div id="pText" style="text-align: center;">
        </div>
        <a id="popupClose" onclick="hidePopup(0,0);" class="popup-close" data-popup-close="popup-1" href="#">x</a>
    </div>
</div>

<div class="row" style="margin-top: 50px; position: relative; overflow: auto;">
    <div class="col-xs-4"></div>
    <div class="col-xs-4">
        <h2>Stock Page</h2>
        <hr />

    </div>
    <div class="col-xs-4"></div>
</div>

<br /><br />
<footer>
    <div class="col-xs-12 text-center">
        <b>RestTech</b>
    </div>
</footer>

</body>
</html>