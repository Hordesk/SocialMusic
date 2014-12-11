<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-theme.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'full.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
        <link rel="script" href="${resource(dir: 'js', file: 'bootstrap.js')}">
		<g:layoutHead/>
		<g:javascript library="application"/>
        <g:javascript library="jquery" plugin="jquery"/>

        <r:layoutResources />
	</head>


<body>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">

                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>

                </button>
                <a style="background-image: url('${resource(dir: 'images', file: 'mus.jpg')}')" class="navbar-brand" href="${createLink(controller:'index', action:'index')}">Social Music</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    %{--<li><a href="${createLink(controller:'index', action:'index')}">Membres</a></li>--}%
<sec:ifLoggedIn>
                    <li><a  style="background-image: url('${resource(dir: 'images', file: 'mus.jpg')}')" href="${createLink(controller:'grade', action: 'likeUnlike')}">Noter une musique</a></li>
    </sec:ifLoggedIn>
                    <sec:ifNotLoggedIn>
                        <li><a  style="background-image: url('${resource(dir: 'images', file: 'mus.jpg')}')" href="${createLink(controller:'user', action: 'register')}">${message(code: 'user.register.label', default: 'S\'enregistrer')}</a></li>
                        <li><a  style="background-image: url('${resource(dir: 'images', file: 'mus.jpg')}')" href="${createLink(controller:'login')}">${message(code: 'user.login.label', default: 'Connexion')}</a></li>

                    </sec:ifNotLoggedIn>
                %{--blok de l'utilisateur courrent--}%
                    <sec:ifLoggedIn>

                        <li><a  style="background-image: url('${resource(dir: 'images', file: 'mus.jpg')}')"  href="${createLink(controller:'Track', action: 'create')}">${message(code: 'track.add', default: 'Ajouter une musique')}</a></li>
                        <li><a  style="background-image: url('${resource(dir: 'images', file: 'mus.jpg')}')"  href="${createLink(controller:'user', action: 'bibliotheque')}">${message(code: 'track.showList', default: 'Ma bibliothèque')}</a></li>

                        <li> <a style="background-image: url('${resource(dir: 'images', file: 'mus.jpg')}')" id="currentUser" href="${createLink(controller:'user', action: 'edit', id : userInstance.id)}"><sec:username /> </a> </li>
                        <li> <a  style="background-image: url('${resource(dir: 'images', file: 'mus.jpg')}')" id="logout"  href="${createLink(controller:'myLogout')}">${message(code: 'user.logout.label', default: 'Deconnexion')}</a></li>

                    </sec:ifLoggedIn>
                %{--blok de l'utilisateur courrent--}%
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>

    <div class="container" >

            <br>
        <br>
        <br><center>
            <g:layoutBody/>
            <r:layoutResources />
    </center>
        <div class="hero-unit" ></div>

    </div><!-- /.container -->

</body>



</html>


%{--<a class="img-circle" href="#"><img src="${resource(dir: 'images', file: 'socialMusicLogo.jpg')}" alt="SocialMusic" width="40"/></a>--}%