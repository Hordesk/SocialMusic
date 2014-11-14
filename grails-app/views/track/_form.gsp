<%@ page import="socialmusic.Track" %>



<div class="fieldcontain ${hasErrors(bean: trackInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="track.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${trackInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trackInstance, field: 'artist', 'error')} required">
	<label for="artist">
		<g:message code="track.artist.label" default="Artist" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="artist" required="" value="${trackInstance?.artist}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trackInstance, field: 'album', 'error')} required">
	<label for="album">
		<g:message code="track.album.label" default="Album" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="album" required="" value="${trackInstance?.album}"/>

</div>

%{--
<div class="fieldcontain ${hasErrors(bean: trackInstance, field: 'grades', 'error')} ">
	<label for="grades">
		<g:message code="track.grades.label" default="Grades" />

	</label>

<ul class="one-to-many">
<g:each in="${trackInstance?.grades?}" var="g">
    <li><g:link controller="grade" action="show" id="${g.id}">${g?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="grade" action="create" params="['track.id': trackInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'grade.label', default: 'Grade')])}</g:link>
</li>
</ul>


</div>
--}%

