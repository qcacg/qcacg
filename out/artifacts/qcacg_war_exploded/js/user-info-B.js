/*
 保存或修改作品（信息）
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
 保存或修改作品（内容）
 */
$(function() {
    $('#btn-content-post').on('click', function() {
        var contentId = 9;
        var formatText = editor.$txt.formatText();
        var html = editor.$txt.html();
        var contentTitle = $('#ipt-chapter-post').val();
        var volumeId = 3;
        var url = "/content/saveOrUpdateContent.shtml";

        $.ajax({url:url,
            type: "POST",
            data: {"contentId":contentId,"html":html,"contentTitle":contentTitle,"formatText":formatText,"volumeId":volumeId},
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

        var volumeName = "第三卷";
        var bookId = 2;
        var volumeId = 3;
        var url = "/volume/saveOrUpdateVolume.shtml";
        $.ajax({url:url,
            type: "POST",
            data: {"volumeName":volumeName,"bookId":bookId,"volumeId":volumeId},
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
    $(' ').on('click', function() {

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
    $(' ').on('click', function() {
        var bookId = 1;
        var url = "/bookCollect/saveOrDeleteBookCollect.shtml";
        $.ajax({
            url:url,
            type: "POST",
            data: {"bookId":bookId},
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
 修改个人信息
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
    $('#btn-book-check').on('click', function() {
        var contentId = 1;
        var url = "/content/findContent.shtml";
        $.ajax({
            url:url,
            type: "POST",
            data: {"contentId":contentId},
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
    $('').on('click', function() {
        var contentId = 7;
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
    $('').on('click', function() {
        var contentId = 1;
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
/*
 设置文本展示状态
 */
$(function() {
    $('  ').on('click', function() {
        var contentId = 1;
        var url = "/content/updateContentStatus.shtml";
        $.ajax({
            url:url,
            type: "POST",
            data: {"contentId":contentId},
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function (data) {
                console.log('error');
            }
        });
    });
})
/*
 作者提交审核
 */
$(function() {
    $(' ').on('click', function() {
        var bookId = 2;
        var url = "/book/userUpdateBookStatus.shtml";
        $.ajax({
            url:url,
            type: "POST",
            data: {"bookId":bookId},
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function (data) {
                console.log('error');
            }
        });
    });
})
/*
 管理员审核审核
 */
$(function() {
    $('').on('click', function() {

        var url = "/book/adminUpdateBookStatus.shtml";
        $.ajax({
            url:url,
            type: "POST",
            data: {bookId:1},
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function (data) {
                console.log('error');
            }
        });
    });
})
/*
 展示提交审核的小说
 */
$(function() {
    $(' ').on('click', function() {

        var url = "/book/queryBookForCheck.shtml";
        $.ajax({
            url:url,
            type: "GET",
            data: {},
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function (data) {
                console.log('error');
            }
        });
    });
})
/*
 获取作品信息
 */
$(function() {
    $('#btn-book-check').on('click', function() {
        var bookId = 1;
        var url = "/book/queryBook.shtml";
        $.ajax({
            url:url,
            type: "GET",
            data: {"bookId":bookId},
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function (data) {
                console.log('error');
            }
        });
    });
})
/*
 添加浏览记录
 */
$(function() {
    $('#btn-book-check').on('click', function() {
        var bookId = 1;
        var url = "/bookHit/saveBookHit.shtml";
        $.ajax({
            url:url,
            type: "GET",
            data: {"bookId":bookId},
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function (data) {
                console.log('error');
            }
        });
    });
})
/*
 按字数获取作品列表（总榜）
 */
$(function() {
    $(' ').on('click', function() {

        var url = "/book/findBookByBookWordCount.shtml";
        $.ajax({
            url:url,
            type: "GET",
            data: {},
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function (data) {
                console.log('error');
            }
        });
    });
})
