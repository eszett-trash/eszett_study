function test() {
  //document.getElementById("test").innerHTML = "aa";

  document.body.style.backgroundColor = "pink";
}

function change() {
  if (document.body.style.backgroundColor == "green") {
    document.body.style.backgroundColor = "pink";
  } else {
    document.body.style.backgroundColor = "green";
  }

}

function onDown(btn) {
  btn.style.color = "#ff0000";
}

function onUp(btn) {
  btn.style.color = "#000000";
}

function onCLK(btn) {
  btn.style.width = "300px";
}

function onCLKb(btn) {
  btn.style.width = "83px";
}

function onMV(btn) {
  btn.style.backgroundColor = "black";
}

function onOut(btn) {
  btn.style.backgroundColor = "";

}
var myWin = null;

function WindowOpn() {
  myWin = window.open("http://www.naver.com", "네이버", "width=300,height=300,top=200");
}

function WindowCls() {
  myWin.close();
}

function testLocation() {
  //alert(location.href);
  //location.replace("doc_01.html");
  // location.href = "doc_01.html";
  // location.reload();
}

function changeColor() {
  setInterval(changeText, 200);
}

function changeText() {
  // var e = document.getElementById("target");
  // document.body.style.backgroundColor = (document.body.style.backgroundColor == "red") ? "blue" : "red";
  // e.style.backgroundColor =(e.style.backgroundColor == "yellow") ? "green" : "yellow";
  var a = Math.floor(Math.random() * 255);
  var b = Math.floor(Math.random() * 255);
  var c = Math.floor(Math.random() * 255);
  var color = "rgb(" + a + "," + b + "," + c + ")";

  document.body.style.backgroundColor = color;
}

function stopChange() {
  // clearInterval("target");
  location.reload();
}
