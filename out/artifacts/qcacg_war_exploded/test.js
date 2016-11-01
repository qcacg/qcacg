console.log(1);

$(function(){

    //为分类的查询绑定单击事件
    $("#query").click(queryEvent);
    //为分类的创建绑定单击事件
    $("#create").click(createEvent);
    //为分类的删除绑定单击事件
    $("#delete").click(deleteEvent);
    //为分类的修改绑定单击事件
    $("#update").click(updateEvent);
});

var queryEvent = function() {
    console.log("query");
    var url = "http://www.qcacg.cn/bookType/queryBookType.shtml ";
    var data = {};
    $.ajax({
        url:url,
        type:"get",
        data:data,
        success:function(result) {
            console.log(result);
        }
    });
}

var createEvent = function() {
    alert("create");
}

var deleteEvent = function() {
    alert("delete");
}

var updateEvent = function() {
    alert("update");
}