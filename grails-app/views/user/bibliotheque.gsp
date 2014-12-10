<%--
  Created by IntelliJ IDEA.
  User: mehdi
  Date: 11/11/2014
  Time: 23:40
--%>

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
