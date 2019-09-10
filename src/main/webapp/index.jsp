<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link href="./css/style.css" rel="stylesheet"/> -->
<script src="./js/jquery.min.js" type="text/javascript"></script>

</head>
<body>
	<h1>测试spring整合</h1>
	<button id="query" onclick="query()" type="button">查询</button>
	
</body>
<script type="text/javascript">
	function query(){
		$.ajax({
			url: "./stu/queryAll.ds",
			async:false,
			data: {},
			dataType: "json", 
			success: function(result){
				console.log(result)
			},
			error:function(){
				console.log("查询出现错误。");
			}
			
		});
	}
	
</script>
</html>