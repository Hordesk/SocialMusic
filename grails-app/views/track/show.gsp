
<%@ page import="socialmusic.Track" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'track.label', default: 'Track')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-track" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-track" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list track">
			
				<g:if test="${trackInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="track.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${trackInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trackInstance?.artist}">
				<li class="fieldcontain">
					<span id="artist-label" class="property-label"><g:message code="track.artist.label" default="Artist" /></span>
					
						<span class="property-value" aria-labelledby="artist-label"><g:fieldValue bean="${trackInstance}" field="artist"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trackInstance?.album}">
				<li class="fieldcontain">
					<span id="album-label" class="property-label"><g:message code="track.album.label" default="Album" /></span>
					
						<span class="property-value" aria-labelledby="album-label"><g:fieldValue bean="${trackInstance}" field="album"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trackInstance?.grades}">
				<li class="fieldcontain">
					<span id="grades-label" class="property-label"><g:message code="track.grades.label" default="Grades" /></span>
					
						<g:each in="${trackInstance.grades}" var="g">
						<span class="property-value" aria-labelledby="grades-label"><g:link controller="grade" action="show" id="${g.id}">${g?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:trackInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${trackInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
