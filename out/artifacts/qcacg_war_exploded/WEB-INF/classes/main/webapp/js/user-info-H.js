// alert('111');

$(function(){
 
 
 
 
 
 // DOM 基础DOM加载完毕后执行
 $('#qianbao-H').click(function(){
  // $(this) = $('#user-info-A')
  // $(this) = function(this)
  $(this).addClass('active');
  $('#qianBaoView-H').addClass('active');
  $('#zhangdan-H').removeClass('active');
  $('#zhangDanView-H').removeClass('active');
 });
 $('#zhangdan-H').click(function(){
  // $(this) = $('#user-info-A')
  // $(this) = function(this)
  $(this).addClass('active');
  $('#zhangDanView-H').addClass('active');
  $('#qianbao-H').removeClass('active');
  $('#qianBaoView-H').removeClass('active');
 });
// $('#user-info-A').on('click',function(){
// });





})