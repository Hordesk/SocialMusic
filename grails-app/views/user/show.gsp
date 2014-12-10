<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Bibliothèque</title>

</head>
<body>
<div id="page-body" role="main">
    <h1>Voila votre bibliothèque</h1>


    <div id="collection-list">

        <table class="table">
            <thead>
            <tr>
                <g:sortableColumn property="Titre" title="${message(code: 'track.title.label', default: 'Titre')}" />
                <g:sortableColumn property="Titre" title="${message(code: 'track.album.label', default: 'Album')}" />
                <g:sortableColumn property="Titre" title="${message(code: 'track.artist.label', default: 'Artiste')}" />



            </tr>
            </thead>
            <tbody>

            <g:each in="${grades}"  var="grade">
                <tr class="success">
                    <td><g:link controller="track" action="show" id="${grade.track.title}">${fieldValue(bean: grade, field: "track.title")}</g:link></td>
                    <td><g:link controller="track" action="show" id="${grade.track.album}">${fieldValue(bean: grade, field: "track.album")}</g:link></td>
                    <td><g:link controller="track" action="show" id="${grade.track.artist}">${fieldValue(bean: grade, field: "track.artist")}</g:link></td>


                </tr>
            </g:each>
            </tbody>
        </table>


    </div>


</div>

</body>
</html>



%{--

<%@ page import="socialmusic.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>

		<div id="show-user" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list user">

				<g:if test="${userInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="user.username.label" default="Username" /></span>

						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${userInstance}" field="username"/></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="user.password.label" default="Password" /></span>

						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${userInstance}" field="password"/></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.accountExpired}">
				<li class="fieldcontain">
					<span id="accountExpired-label" class="property-label"><g:message code="user.accountExpired.label" default="Account Expired" /></span>

						<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean boolean="${userInstance?.accountExpired}" /></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.accountLocked}">
				<li class="fieldcontain">
					<span id="accountLocked-label" class="property-label"><g:message code="user.accountLocked.label" default="Account Locked" /></span>

						<span class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean boolean="${userInstance?.accountLocked}" /></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="user.enabled.label" default="Enabled" /></span>

						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${userInstance?.enabled}" /></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.grades}">
				<li class="fieldcontain">
					<span id="grades-label" class="property-label"><g:message code="user.grades.label" default="Grades" /></span>

						<g:each in="${userInstance.grades}" var="g">
						<span class="property-value" aria-labelledby="grades-label"><g:link controller="grade" action="show" id="${g.id}">${g?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

				<g:if test="${userInstance?.passwordExpired}">
				<li class="fieldcontain">
					<span id="passwordExpired-label" class="property-label"><g:message code="user.passwordExpired.label" default="Password Expired" /></span>

						<span class="property-value" aria-labelledby="passwordExpired-label"><g:formatBoolean boolean="${userInstance?.passwordExpired}" /></span>

				</li>
				</g:if>

			</ol>
			<g:form url="[resource:userInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${userInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
--}%
