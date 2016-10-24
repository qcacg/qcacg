<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jquery-1.9.1.min.js" ></script>
		<style>
			/* 内联 */
		</style>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/cropper.min.css" />
		<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/cropper.js" ></script>
		<style>
			img {
  				max-width: 100%; /* This rule is very important, please do not ignore this! */
  				
			}	
			img {
    vertical-align: middle;
}
		</style>
	</head>

	<body style="">
	  <div id="canvas"></div>
		<div style="width: 300px;height: 300px;">
			<img id="cropper-img" src="${pageContext.servletContext.contextPath }/img/headportrait1.jpg"></img>
		</div>
		<input id="inputImage" type="file" />
	  <button id="button">上传</button>
	</body>
	<script>
		
		window.onload = function () {
		$("#button").on('click', function() {
		  var img = $('#cropper-img').cropper('getCroppedCanvas',{ width: 100 });
		  $('#canvas').html(img);
		  $('#cropper-img').cropper('getCroppedCanvas').toBlob(function (blob) {
		    var formData = new FormData();
		    formData.append('croppedImage', blob);
		    console.log(formData.getAll());
//		    $.ajax('url', {
//        method: "POST",
//        data: formData,
//        processData: false,
//        contentType: false,
//        success: function () {
//          console.log('Upload success');
//        },
//        error: function () {
//          console.log('Upload error');
//        }
//      });
		  })
	  })
		$('#cropper-img').cropper({
			aspectRatio:1 / 1.4,
			viewMode:0,
			preview: ".img-preview",
			build: function (e) {
	          console.log(e.type);
	        },
	        built: function (e) {
	          console.log(e.type);
	        },
	        cropstart: function (e) {
	          console.log(e.type);
	        },
	        cropmove: function (e) {
	          console.log(e.type);
	        },
	        cropend: function (e) {
	          console.log(e.type);
	        },
			crop: function(e) {
				$('#dataX').val(Math.round(e.x));
				$('#dataY').val(Math.round(e.y));
				$('#dataHeight').val(Math.round(e.height));
				$('#dataWidth').val(Math.round(e.width));
				$('#dataRotate').val(Math.round(e.rtate));
				$('#dataScaleX').val(Math.round(e.scaleX));
				$('#dataScaleY').val(Math.round(e.scaleY));
			}
		});
		var inputImage = document.getElementById('inputImage');
		$('#cropper-img').cropper('setDragMode', 'move');
		inputImage.onchange = function () {
		      var files = this.files;
		      var file;
		      var cropper = $('#cropper-img').cropper
			  if (cropper && files && files.length) {
		        file = files[0];
				if (/^image\/\w+/.test(file.type)) {
		          blobURL = URL.createObjectURL(file);
		          $('#cropper-img').cropper('reset').cropper('replace', blobURL);
		          inputImage.value = null;
		        } else {
		          window.alert('Please choose an image file.');
		        }
		      }
    		};
			
			
			
		}
		
		//jQuery框架
		// $ JQuery 
		//  var object = {};
		// aspectRation: 16 / 9,  比例  16:9 4:3 1:1 2:3 默认为 NaN 是自由拖动的,前面的是比例拖动
		
  
  
  
		
	</script>
</html>
