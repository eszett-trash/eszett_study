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
}
