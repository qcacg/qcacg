/*
 按时间获取作品列表
 */
$(function() {
    $(' ').on('click', function() {

        $.ajax('/book/findBookByBookUpDate.shtml', {
            type: "GET",
            data: {},
            dataType: "json",
            success: function () {
                console.log(' success');
            },
            error: function () {
                console.log(' error');
            }
        });
    });
})