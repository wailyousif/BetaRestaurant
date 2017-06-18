<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html style="font-family: Arial, sans-serif; margin: 0; padding: 0;">
<head>
    <title>Login</title>

    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/sha512.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../css/layout.css" />

    <script type="text/javascript">
        function checkPasswordComplexity(pass)
        {
            var anUpperCase = /[A-Z]/;
            var aLowerCase = /[a-z]/;
            var aNumber = /[0-9]/;
            var aSpecial = /[!|@|#|$|%|^|&|*|(|)|-|_]/;

            if (pass.length < 8)
            {
                return false;
            }

            var numUpper = 0;
            var numLower = 0;
            var numNums = 0;
            var numSpecials = 0;
            for(var i=0; i < pass.length; i++)
            {
                if (anUpperCase.test(pass[i]))
                    numUpper++;
                else if (aLowerCase.test(pass[i]))
                    numLower++;
                else if (aNumber.test(pass[i]))
                    numNums++;
                else if (aSpecial.test(pass[i]))
                    numSpecials++;
            }

            if (numUpper < 2 || numLower < 2 || numNums < 2 || numSpecials < 2)
            {
                return false;
            }

            return true;
        }
    </script>

    <script type="text/javascript">
        $(document).ready
        (
            function()
            {
                $("#frmSignIn").submit
                (
                    function(ev)
                    {
                        ev.preventDefault();

                        var okMsgBoxHtml = '<br /><br /><button id="popupOKButton" type="button" class="btn btn-warning" onclick="hidePopup(0,0);">OK</button>';

                        var usernameReg = /^[a-zA-Z0-9._-]+$/;
                        var username = document.getElementById('username').value;
                        var validUsername = usernameReg.test(username);
                        if (validUsername == false)
                        {
                            showPopup('', 'Invalid username' + okMsgBoxHtml);
                            return;
                        }

                        var pass = document.getElementById('pass').value;
                        if (!checkPasswordComplexity(pass))
                        {
                            showPopup('', 'Password does not meet the minimum complexity requirements.' + okMsgBoxHtml);
                            return;
                        }
                        var shaObj = new jsSHA("SHA-512", "TEXT");
                        shaObj.update(pass);
                        var passHash = shaObj.getHash("B64");

                        var restbranch = document.getElementById('restbranch').value;

                        var objFormData = new FormData();

                        objFormData.append('username', username.trim());
                        objFormData.append('pass', passHash);

                        $.ajax
                        (
                            {
                                cache: false,
                                type: "POST",
                                contentType: false,
                                url: "/mvc/method/user/login",
                                headers: { 'x-tenantid': restbranch },
                                data: objFormData,
                                processData: false,
                                success: function(data, textStatus, xhr)
                                {
                                    //alert('data=' + data);
                                    //alert('data.success=' + data.success);
                                    //alert('data.responseCode=' + data.responseCode);
                                    //alert('data.responseString=' + data.responseString);

                                    if (data.success == true)
                                    {
                                        window.location.replace(data.responseString);
                                    }
                                    else
                                    {
                                        showPopup('', data.responseString + okMsgBoxHtml);
                                    }
                                },
                                error: function(data, textStatus, xhr)
                                {
                                    showPopup('', 'Could not login. Contact system administrator.' + okMsgBoxHtml);
                                }
                            }
                        )
                    }
                );
            }
        );
    </script>
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
    <script type="text/javascript">
        $(document).ready(function() {
            $("#username").focus();
        });
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
        <h2>Login</h2>
        <hr />

        <form id="frmSignIn">
            <div class="row">
                <div class="col-xs-12">
                    <label for="username">اسم المستخدم:</label>
                    <input type="text" id="username" name="username" placeholder="" class="form-control" value="" maxlength="128" />
                </div>
            </div>
            <br />
            <div class="row">
                <div class="col-xs-12">
                    <label for="pass">كلمة المرور:</label>
                    <input type="password" id="pass" name="pass" class="form-control" value="" maxlength="16" />
                </div>
            </div>
            <br />
            <input type="hidden" id="restbranch" name="restbranch" value="<c:out value="${restBranch}"/>" />
            <hr />
            <div class="row">
                <div class="col-xs-12">
                    <input type="submit" class="btn btn-info" value="دخول" />
                </div>
            </div>
            <br />
        </form>
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