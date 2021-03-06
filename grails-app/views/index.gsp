<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>

	</head>
	<body>
		<div id="page-body" role="main">
			<h1>Bienvenue sur le réseau social de la musique!!</h1>


			%{--<div id="controller-list" role="navigation">--}%
				%{--<h2>Available Controllers:</h2>--}%
				%{--<ul>--}%
					%{--<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">--}%
						%{--<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>--}%
					%{--</g:each>--}%
				%{--</ul>--}%
			%{--</div>--}%

            <div id="user-list">

            <table>
                <thead>
                <tr>

                    <g:sortableColumn property="name" title="${message(code: 'user.name.label', default: 'Name')}" />

                    <g:sortableColumn property="password" title="${message(code: 'user.password.label', default: 'Password')}" />

                </tr>
                </thead>
                <tbody>
                <g:each in="${userInstanceList}" status="i" var="userInstance">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                        <td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "name")}</g:link></td>

                        <td>${fieldValue(bean: userInstance, field: "password")}</td>

                    </tr>
                </g:each>
                </tbody>
            </table>


            </div>


		</div>
	</body>
</html>
