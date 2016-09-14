
$(function() {
    $('#btn-info-book').on('click', function() {
        var bookName = $('#ipt-title-post-info').val();
        var bookIntroduction = $('#ipt-intro-post-info').val();
        var bookCoverImage = $('#ipt-cover-post-info').val();
        $.ajax('/book/saveOrUpdateBook.shtml', {
            type: "POST",
            data: {"bookName":bookName,"bookIntroduction":bookIntroduction,"bookCoverImage":bookCoverImage},
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

$(function() {
    $('#btn-content-post').on('click', function() {
        var html = editor.$txt.html();
        var chapterName = $('#ipt-chapter-post').val();


        $.ajax('/content/save.shtml', {
            type: "POST",
            data: {"html":html,"chapterName":chapterName},
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


$(function() {
    $('#btn-add-vol-submit').on('click', function() {

        var volumeName = $('#ipt-title-volume').val();

        $.ajax('/volume/saveVolume.shtml', {
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

$(function() {
    $('#item-thumb').on('click', function() {

        $.ajax('/volume/findVolumeAndContentByBookId.shtml', {
            type: "POST",
            data: {"bookId":1},
            dataType: "text",
            success: function () {
                console.log('findVolumeAndContentByBookId success');
            },
            error: function () {
                console.log('findVolumeAndContentByBookId error');
            }
        });
    });
})
