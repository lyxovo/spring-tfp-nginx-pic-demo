<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery.min.js" type="text/javascript"></script>

</head>
<body>
	<h1>上传图片到服务器</h1>
	 <form action="/upload.ds" method="post" enctype="multipart/form-data">
  请选择图片:<input type="file" name="file" accept="image/*" /> <br>
        <input type="submit" value="上传图片">
    </form>
    <hr>
     <a href="/download.ds">下载图片</a>
</body>


</html>