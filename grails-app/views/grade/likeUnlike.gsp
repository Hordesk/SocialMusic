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
    <h1>Voila votre bibliotheque</h1>


    <div id="user-list">
<table class="table">
    <caption>Lise des Musique</caption>
    <thead>
    <tr>
        <th>Artist</th>
        <th>album</th>
        <th>grade Total</th>
        <th>Like</th>
        <th>Unlike</th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${tracks}"  var="track">
        <tr class="success">
            <td>${track.artist}</td>
            <td>${track.album}</td>
            <td>${track.totalGrade}</td>
            <td> <g:link controller="grade" action="like" id="${track.id}">like</g:link></td>
            <td> <g:link controller="grade" action="unlike" id="${track.id}">UnLike</g:link></td>
        </tr>
    </g:each>


    <!--  <tr class="active">
        <td>Product1</td>
        <td>23/11/2013</td>
        <td>Pending</td>
     </tr> -->


</tbody>

    </tbody>
</table>
</div>
    </div>
</body>
</html>