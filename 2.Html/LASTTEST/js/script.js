var imgs = 5;
var now =0;
function slide()
{
  now = now ==imgs?0:now+=1;
  $(".imgs>img").eq(now-1).css({"margin-left":"-2000px"});
  $(".imgs>img").eq(now).css({"margin-left":"0px"});
}

function slidestarter(){
  $(".imgs>img").eq(0).siblings()
  .css({"margin-left":"-2000px"});
  setInterval(function(){slide();},2000);
}

function start() {
  $("#main_menu>li").mouseover(
    function() {
      $(this).children("#submenu1").stop().slideDown();
      $(this).children("#submenu2").stop().slideDown();
    }
  );
  $("#main_menu>li").mouseleave(
    function() {
      $(this).children("#submenu1").stop().slideUp();
      $(this).children("#submenu2").stop().slideUp();
    }
  );
  slidestarter();
}
