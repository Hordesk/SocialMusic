<%@ page import="socialmusic.Artist" %>



<div class="fieldcontain ${hasErrors(bean: artisteInstance, field: 'title', 'error')} required">
    <label for="nom">
        <g:message code="artiste.nom.label" default="Nom"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="nom" required="" value="${artisteInstance?.nom}"/>

</div>

