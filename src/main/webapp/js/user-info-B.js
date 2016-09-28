/*
 保存作品（信息）
 */
$(function() {
    $('#btn-info-book').on('click', function() {
        var bookEntity = new Object();
        bookEntity.bookId = 6;
        bookEntity.bookName = $('#ipt-title-post-info').val();
        bookEntity.bookIntroduction = $('#ipt-intro-post-info').val();
        bookEntity.bookCoverImage = $('#ipt-cover-post-info').val();
        bookEntity.sort = "少年";
        bookEntity.bookTypeList = [1,2,3,4,5];

        $.ajax('/book/saveOrUpdateBook.shtml', {
            type: "POST",
            contentType:"application/json",
            data: JSON.stringify(bookEntity),
            dataType: "json",
            success: function (data) {
                console.log(data.msg);
            },
            error: function (data) {
                console.log(data.msg);
            }
        });
    });
})

/*
 保存作品（文本）
 */
$(function() {
    $('#btn-content-post').on('click', function() {
        var html = editor.$txt.html();
        var contentTitle = $('#ipt-chapter-post').val();
        var volumeId = 1;
        var url = "/content/saveOrUpdateContent/"+volumeId+".shtml";

        $.ajax({url:url,
            type: "POST",
            data: {"html":html,"contentTitle":contentTitle},
            dataType: "text",
            success: function () {
                console.log('save success');
            },
            error: function () {
                console.log('save error');
            }
        });
    });
})
/*
 新增卷或修改卷名
 */

$(function() {
    $('#btn-add-vol-submit').on('click', function() {

        var volumeName = $('#ipt-title-volume').val();
        var bookId = 1;
        var url = "/volume/saveOrUpdateVolume/"+bookId+".shtml";
        $.ajax({url:url,
            type: "POST",
            data: {"volumeName":volumeName},
            dataType: "text",
            success: function () {
                console.log('save success');
            },
            error: function () {
                console.log('save error');
            }
        });
    });
})
/*
 获取作品卷章详情
 */
$(function() {
    $('#item-thumb').on('click', function() {
        var bookId = 1;
        var url = "/volume/findVolumeAndContentByBookId/"+bookId+".shtml";
        $.ajax({url:url,
            type: "GET",
            data: {},
            dataType: "json",
            success: function () {
                console.log('findVolumeAndContentByBookId success');
            },
            error: function () {
                console.log('findVolumeAndContentByBookId error');
            }
        });
    });
})

/*
 获取分类
 */
$(function() {
    $('#btn-choose-cat').on('click', function() {

        $.ajax('/bookType/queryBookType.shtml', {
            type: "GET",
            data: {},
            dataType: "json",
            success: function () {
                console.log('save success');
            },
            error: function () {
                console.log('save error');
            }
        });
    });
})
/*
 添加或删除收藏
 */
$(function() {
    $('#btn-choose-cat').on('click', function() {
        var bookId = 1;
        var url = "/bookCollect/saveOrDeleteBookCollect/"+bookId+".shtml";
        $.ajax({
            url:url,
            type: "POST",
            data: {},
            dataType: "json",
            success: function () {
                console.log('saveOrDeleteBookCollect success');
            },
            error: function () {
                console.log('saveOrDeleteBookCollect error');
            }
        });
    });
})
/*
 修改或保存个人信息
 */
$(function() {
    $('#btn-save-profile').on('click', function() {
        var userName = "qcacg";
        var birthday = "2016-01-01";
        var sex = "男生";
        var information = "我就是传说中的小说高手！！";
        var url = "/user/updateUser.shtml";
        $.ajax({
            url:url,
            type: "POST",
            data: {"userName":userName,"birthday":birthday,"sex":sex,"information":information},
            dataType: "json",
            success: function (data) {
                console.log('updateUser success');
            },
            error: function (data) {
                console.log('updateUser error');
            }
        });
    });
})

/*
 添加作品封面
 */
$(function() {
    $(' ').on('click', function() {
        var url = "/book/upload.shtml";
        $.ajax({
            url:url,
            type: "POST",
            data: {},
            dataType: "json",
            success: function (data) {
                console.log('save success');
            },
            error: function (data) {
                console.log('save error');
            }
        });
    });
})
/*
 读者读取作品正文（或者作者获取草稿）
 */
$(function() {
    $(' ').on('click', function() {
        var contentId = 1;
        var url = "/content/findContent/"+contentId+".shtml";
        $.ajax({
            url:url,
            type: "POST",
            data: {},
            dataType: "json",
            success: function (data) {
                console.log('findContent success');
            },
            error: function (data) {
                console.log('findContent error');
            }
        });
    });
})
/*
 下一章节
 */
$(function() {
    $(' ').on('click', function() {
        var contentId = 18;
        var bookId = 1;
        var url = "/content/nextContent.shtml";
        $.ajax({
            url:url,
            type: "GET",
            data: {"contentId":contentId,"bookId":bookId},
            dataType: "json",
            success: function (data) {
                if(data.success){
                    console.log(data);
                }else {
                    alert(data.msg);
                }
            },
            error: function (data) {
                console.log('error');
            }
        });
    });
})
/*
 上一章节
 */
$(function() {
    $('#btn-choose-cat ').on('click', function() {
        var contentId = 2;
        var bookId = 1;
        var url = "/content/previousContent.shtml";
        $.ajax({
            url:url,
            type: "GET",
            data: {"contentId":contentId,"bookId":bookId},
            dataType: "json",
            success: function (data) {
                if(data.success){
                    console.log(data);
                }else {
                    alert(data.msg);
                }
            },
            error: function (data) {
                console.log('error');
            }
        });
    });
})