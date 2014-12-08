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
    <title>Welcome to Grails</title>

</head>
<body>
<div id="page-body" role="main">
    <h1>Voila votre bibliotheque</h1>


    <div id="user-list">

        <table class="table">
   <caption>Bibliotheque</caption>
   <thead>
      <tr>
         <th>Artist</th>
         <th>album</th>

      </tr>
   </thead>
   <tbody>
   <g:each in="${grades}"  var="grade">
   <tr class="success">

       <td>${grade.track.artist}</td>
       <td>${grade.track.album}</td>

   </tr>
   </g:each>
   </tbody>
</table>


    </div>


</div>

</body>
</html>
