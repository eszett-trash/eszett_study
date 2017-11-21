
var a = Math.floor(Math.random() * 90 + 10);
var b = Math.floor(Math.random() * 90 + 10);

function qwe() {
  if (a + b == document.third.kotae.value) {
    alert('정답');
  } else {
    alert('오답');
  }
}

function temp() {
  a = Math.floor(Math.random() * 90 + 10);
  b = Math.floor(Math.random() * 90 + 10);
  $('#mondai').text(a + "+" + b + "= ?");
}
