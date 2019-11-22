<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>    

<div class="collapse navbar-collapse">
    <p id="header-nav" class="navbar-text"> Producciones Fotograficas

    </p>
    <c:url value="/logout" var="logoutUrl" />
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}"
        value="${_csrf.token}" />
    </form>
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <ul class="nav navbar-right top-nav" style="padding-right: 25px">
            <h4>
                <p style="color: greenyellow"><a
                        href=./login> Log In</a> <span> || </span><a
                href=./register> Register</a></p>
                
            </h4>
        </ul>
    </c:if>
    

    <c:if test="${pageContext.request.userPrincipal.name != null}">

            <ul class="nav navbar-right top-nav" style="padding-right: 25px">
                <h4 >
                    <p style="color: greenyellow"> Welcome : ${pageContext.request.userPrincipal.name} | <a
                    href="javascript:formSubmit()"> Logout</a></p>
                </h4>
            </ul>

    </c:if>
</div>



            

