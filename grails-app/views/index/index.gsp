<%@ page import="socialmusic.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>

	</head>
	<body>
		<div id="page-body" role="main">
			<h1>Bienvenue! Voici les utilisateurs inscrits sur le réseau</h1>


            <div id="user-list">

            <table class="table">
                <thead>
                <tr>

                   <b>
                       <g:sortableColumn property="${User.name}" title="Nom" />
                   </b>

                </tr>
                </thead>
                <tbody>
                <g:each in="${userInstanceList}" status="i" var="userInstance">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                        <td><g:link controller="user" action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "username")}</g:link></td>
                        %{--<td><g:link controller="user" action="collectionForUser" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "username")}</g:link></td>--}%
                    </tr>
                </g:each>
                </tbody>
            </table>


            </div>


		</div>
	</body>
</html>
