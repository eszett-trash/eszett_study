var prm = prompt("원하는 달을 입력 해 주세요");

var _Month = parseInt(prm)-1;

var date = new Date();

var ima = date.getDate();

var i = 1;

var temp = "";
var str = "";

var cnt =0;

function sett() {
  ima = 1;
  var left_btn = document.getElementById("left_btn");
  var right_btn = document.getElementById("right_btn");
  var monthly = document.getElementById("getsu");
  var mmm = document.getElementById("taa");

  date.setMonth(_Month);
  date.setDate(1);
  date.setFullYear(2017);

  str = "<table border=\"1\" id=\"taa\"><tr><td><input type=\"button\" id = \"left_btn\" onclick=\"btn_click_l();\" value=" + (_Month) + "월\></td><td colspan=\"5\" id = \"getsu\">" + (_Month * 1 + 1) + "월" + "</td><td><input type=\"button\" id = \"right_btn\" onclick=\"btn_click_r();\" value=\"" + (_Month * 1 + 2 + "월") + "\"></td></tr><tr><td>일</td><td>월</td><td>화</td><td>수</td><td>목</td><td>금</td><td>토</td></tr>"

  var endDay = new Date(2017, _Month+1, 0);
  temp += "<tr>";
  for (var i = 0; i < date.getDay(); i++) {
    temp += "<td>"
    temp += "</td>";
    cnt++;
  }
  for (var i = date.getDay(); i < 7; i++) {
    temp += "<td>"
    date.setDate(ima++);
    temp += date.getDate();
    temp += "</td>";
  }
  temp += "</tr>";

//2주차부터
  for (var j = 7; j < endDay.getDate()+cnt-1; j++ ) {
    if (date.getDay() == 0) {
      temp += "<tr>";
    }
    temp += "<td>"
    date.setDate(++ima);
    temp += date.getDate();
    temp += "</td>";
  }
  document.getElementById("taa").innerHTML = str + temp;
  temp = "";
  cnt = 0;
}

function btn_click_l() {

  if (_Month == 0) {
    alert("2017년의 첫 달입니다.");
  } else {
    _Month--;
    sett();
  }
}

function btn_click_r() {
  if (_Month == 11) {
    alert("2017년의 마지막 달입니다.");
  } else {
    _Month++;
    sett();
  }
}
