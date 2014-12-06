<%@ page import="socialmusic.Grade" %>



<div class="fieldcontain ${hasErrors(bean: gradeInstance, field: 'grade', 'error')} required">
	<label for="grade">
		<g:message code="grade.grade.label" default="Grade" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="grade" type="number" value="${gradeInstance.grade}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: gradeInstance, field: 'track', 'error')} required">
	<label for="track">
		<g:message code="grade.track.label" default="Track" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="track" name="track.id" from="${socialmusic.Track.list()}" optionKey="id" required="" value="${gradeInstance?.track?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: gradeInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="grade.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${socialmusic.User.list()}" optionKey="id" required="" value="${gradeInstance?.user?.id}" class="many-to-one"/>

</div>

