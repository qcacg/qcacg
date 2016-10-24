// alert('222');
// $(document).ready(function(){}) = $(function()())
$(function(){


    $("#btn-avatar-profile").on('click', function() {
        var img = $('#cropper-img').cropper('getCroppedCanvas',{ width: 100 });
         //$('#canvas').html(img);
        //alert($('#cropper-img').cropper('getCroppedCanvas').toBlob)
        $('#cropper-img').cropper('getCroppedCanvas').toBlob(function (blob) {
            var formData = new FormData();
            formData.append('Image', blob);
            formData.append('name', 'BLOB');
            console.log(formData.get('name'));
            console.log(formData.get('Image'));
            $.ajax('/user/upload.shtml', {
                method: "POST",
                data: formData,
                processData: false,
                contentType: false,
                success: function () {
                    console.log('Upload success');
                },
                error: function () {
                    console.log('Upload error');
                }
            });
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
        document.getElementById('modal-avatar-profile').style.display = 'block';
        document.getElementById('modal-avatar-profile').style.paddingRight = '17px';
        $('#modal-avatar-profile').addClass('in');
        document.getElementById('heimu').style.display = 'block';

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


    //jQuery框架
    // $ JQuery
    //  var object = {};
    // aspectRation: 16 / 9,  比例  16:9 4:3 1:1 2:3 默认为 NaN 是自由拖动的,前面的是比例拖动




















    $('#I-follow').click(function(){
        $(this).addClass('active');
        $('#I-followView').addClass('active');
        $('#follow-I').removeClass('active');
        $('#follow-Iview').removeClass('active');
    });

    $('#follow-I').click(function(){
        $(this).addClass('active');
        $('#follow-Iview').addClass('active');
        $('#I-follow').removeClass('active');
        $('#I-followView').removeClass('active');
    })




    // DOM 基础DOM加载完毕后执行
    $('#user-info-A').click(function(){
        // $(this) = $('#user-info-A')
        // $(this) = function(this)
        $(this).addClass('active');
        $('#userInfo-A').addClass('active');
        $('#user-passUpdata-A').removeClass('active');
        $('#userPassUpdata-A').removeClass('active');
    });
    $('#user-passUpdata-A').click(function(){
        // $(this) = $('#user-info-A')
        // $(this) = function(this)
        $(this).addClass('active');
        $('#userPassUpdata-A').addClass('active');
        $('#user-info-A').removeClass('active');
        $('#userInfo-A').removeClass('active');
    });
//	$('#user-info-A').on('click',function(){
//	});

    $('#Collection-A').click(function(){
        $(this).addClass('active');
        $('#CollectionViewA').addClass('active');
        $('#History-A').removeClass('active');
        $('#HistoryViewA').removeClass('active');
    })

    $('#History-A').click(function(){
        $(this).addClass('active');
        $('#HistoryViewA').addClass('active');
        $('#CollectionViewA').removeClass('active');
        $('#Collection-A').removeClass('active');
    })






})

//$(function(){
//	// DOM 基础DOM加载完毕后执行
//	alert('222');
//})

// window.onload = function() {
// 	alert('11')  //js 是不支持this
// }

// window.onload = function() {
// 	alert('114')
// }


