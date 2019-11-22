<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><tiles:getAsString name="title" /></title>
   
    <!-- Bootstrap 3.3.7-->
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/style.css">
    
    <link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
           
    <!-- blueimp Gallery styles -->
    <link rel="stylesheet" href="resources/css/blueimp-gallery.css">
    <!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
    <link rel="stylesheet" href="resources/css/jquery.fileupload.css">
    <link rel="stylesheet" href="resources/css/jquery.fileupload-ui.css">
    <!-- CSS adjustments for browsers with JavaScript disabled -->
    <noscript><link rel="stylesheet" href="resources/css/jquery.fileupload-noscript.css"></noscript>
    <noscript><link rel="stylesheet" href="resources/css/jquery.fileupload-ui-noscript.css"></noscript>
</head>
  
<body>
    <div id="wrapper">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <header id="header">
                <tiles:insertAttribute name="header" />
            </header>
        
            <section id="sidemenu">
                <tiles:insertAttribute name="menu" />
            </section>
        
        </nav>
        <div id="page-wrapper" >  
            <section id="site-content">
                <tiles:insertAttribute name="body" />
            </section>
        </div>    
        
    </div>
            
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
        
        
    <!-- JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Bootstrap 3.3.7-->
    <script src="resources/js/bootstrap.js"></script> 
    
   
    <!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
    <script src="resources/js/vendor/jquery.ui.widget.js"></script>
    <!-- The Templates plugin is included to render the upload/download listings 
    <script src="resources/js/tmpl.js"></script> -->
    <!-- The Load Image plugin is included for the preview images and image resizing functionality -->
    <script src="resources/js/load-image.all.min.js"></script>
    <!-- The Canvas to Blob plugin is included for image resizing functionality -->
    <script src="resources/js/canvas-to-blob.js"></script>

    <!-- blueimp Gallery script -->
    <script src="//blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
    <!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
    <script src="resources/js/jquery.iframe-transport.js"></script>
    <!-- The basic File Upload plugin -->
    <script src="resources/js/jquery.fileupload.js"></script>
    <!-- The File Upload processing plugin -->
    <script src="resources/js/jquery.fileupload-process.js"></script>
    <!-- The File Upload image preview & resize plugin -->
    <script src="resources/js/jquery.fileupload-image.js"></script>
    <!-- The File Upload audio preview plugin -->
    <script src="resources/js/jquery.fileupload-audio.js"></script>
    <!-- The File Upload video preview plugin -->
    <script src="resources/js/jquery.fileupload-video.js"></script>
    <!-- The File Upload validation plugin -->
    <script src="resources/js/jquery.fileupload-validate.js"></script>
    <!-- The File Upload user interface plugin -->
    <script src="resources/js/jquery.fileupload-ui.js"></script>
    <!-- The main application script -->
    <script src="resources/js/main.js"></script>
</body>
</html>
