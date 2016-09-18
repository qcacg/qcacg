<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>轻创文学网</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/main.css" />
	</head>
	<body>
	  <iframe id="qcacg-header" style="height: 56px;width: 100%;min-width:1200px;border: 0px;overflow: hidden;" src="public/public-header.html"></iframe>
	  <iframe style="height: 240px;width: 100%;min-width:1200px;border: 0px;overflow: hidden;" src="public/public-footer.html"></iframe>
	</body>
	<script>
	  window.onload = function () {
      var x = document.getElementById("qcacg-header");
      var y = (x.contentWindow || x.contentDocument);
      if (y.document) {
        y = y.document;
      }
      y.getElementById('qcacg-header-parent').style.backgroundColor = "rgba(255,255,255,0.3)";
    }
    </script>
</html>
