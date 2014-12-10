<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Bibliothèque</title>

</head>
<body>
<div id="page-body" role="main">
    <h1>Ma Bibliothèque</h1>


    <div id="collection-list">

        <table class="table">
            <thead>
            <tr>
                <g:sortableColumn property="Titre" title="${message(code: 'track.title.label', default: 'Titre')}" />
                <g:sortableColumn property="Titre" title="${message(code: 'track.album.label', default: 'Album')}" />
                <g:sortableColumn property="Titre" title="${message(code: 'track.artist.label', default: 'Artiste')}" />

         <th>Grade</th>
         <th>Like</th>
         <th>Unlike</th>

            </tr>
            </thead>
            <tbody>
            <g:each in="${grades}"  var="grade">
                <tr class="success">
                    <td><g:link controller="track" action="show" id="${grade.track.title}">${fieldValue(bean: grade, field: "track.title")}</g:link></td>
                    <td><g:link controller="track" action="show" id="${grade.track.album}">${fieldValue(bean: grade, field: "track.album")}</g:link></td>
                    <td><g:link controller="track" action="show" id="${grade.track.artist}">${fieldValue(bean: grade, field: "track.artist")}</g:link></td>
                    <td>${grade.grade}</td>
                    <td> <g:link controller="user" action="like" id="${grade.track.id}"><img src="../images/like.png" alt="" border=3 height=25 width=25/></g:link></td>
                    <td> <g:link controller="user" action="unlike" id="${grade.track.id}"><img src="../images/dislike.png" alt="" border=3 height=25 width=25/></g:link></td>

                </tr>
            </g:each>
            </tbody>
        </table>


    </div>


</div>

</body>
</html>
