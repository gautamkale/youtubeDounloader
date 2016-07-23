<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/video-js.css" rel="stylesheet" type="text/css" />
<link href="./css/video-js.min.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<video id="example_video_1" class="video-js vjs-default-skin"
  controls preload="auto" width="640" height="264"
  poster="http://video-js.zencoder.com/oceans-clip.png"
  data-setup='{"example_option":true}'>
 <source src="http://video-js.zencoder.com/oceans-clip.mp4" type='video/mp4' />
 <source src="http://video-js.zencoder.com/oceans-clip.webm" type='video/webm' />
 <source src="http://video-js.zencoder.com/oceans-clip.ogv" type='video/ogg' />
 <p class="vjs-no-js">To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a></p>
</video>
</body>
</html>