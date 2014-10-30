<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>

	</head>
	<body>
		<div id="page-body" role="main">
			<h1>Bienvenue sur le réseau social de la musique!!</h1>

            <div id="user-list">

            <table>
                <thead>
                <tr>

                    <g:sortableColumn property="name" title="${message(code: 'user.name.label', default: 'Name')}" />

                </tr>
                </thead>
                <tbody>
                <g:each in="${userInstanceList}" status="i" var="userInstance">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                        <td><g:link controller="user" action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "username")}</g:link></td>
                    </tr>
                </g:each>
                </tbody>
            </table>


            </div>


		</div>
	</body>
</html>
