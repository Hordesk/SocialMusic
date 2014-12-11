<%--
  Created by IntelliJ IDEA.
  User: mehdi
  Date: 07/12/2014
  Time: 03:33
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>

<body>
<div id="page-body" role="main">
    <h1>Toute la musique</h1>


    <div id="tracks-list">
<table class="table">
    <thead>
    <tr>
        <th>Titre</th>
        <th>Artiste</th>
        <th>Album</th>
        <th>Note</th>
        <th>Like</th>
        <th>Dislike</th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${tracks}"  var="track">
        <tr class="success">
            <td>${track.title}</td>
            <td>${track.artist}</td>
            <td>${track.album}</td>
            <td>${track.totalGrade}</td>
            <td> <g:link controller="grade" action="like" id="${track.id}"><img src="../images/like.png" alt="" border=3 height=25 width=25/></g:link></td>
            <td> <g:link controller="grade" action="unlike" id="${track.id}"><img src="../images/dislike.png" alt="" border=3 height=25 width=25/></g:link></td>
        </tr>
    </g:each>

</tbody>

    </tbody>
</table>
</div>
    </div>
</body>
</html>