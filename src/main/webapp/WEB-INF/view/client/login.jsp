<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 8/13/20
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Follow the money login</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/client/login.css">
    </head>
    <body>
        <header>
            <div class="menu-wrapper">
                <div class="menu-header">
                    <a href="#home" class="logo"><img src="${pageContext.request.contextPath}/assets/icons/logo.svg"></a>
                    <input class="menu-btn" type="checkbox" id="menu-btn" />
                    <label class="menu-icon" for="menu-btn"><span class="navicon"></span></label>
                    <ul class="menu">
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Blog</a></li>
                        <li><a href="#contact">FAQ</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <h1>Log in:</h1>
        <form>
            <div>
                <img src="${pageContext.request.contextPath}/assets/icons/login-email.svg">
                <input placeholder="Your email">
            </div>
            <div>
                <img src="${pageContext.request.contextPath}/assets/icons/login-password.svg">
                <input placeholder="Your password">
            </div>

            <p>forgot your password?</p>

            <button type="submit">Ready to go</button>
        </form>
        <button onclick="location.href='#'">No account? Sign up!</button>
    </body>
</html>
