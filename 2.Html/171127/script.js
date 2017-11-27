function test() {
  try {
    allert("hello world");
  } catch (e) {
    alert(e.message);
  }
}
var solution = Math.floor(Math.random() * 100 + 1);
//alert(solution);

function test2() {

  try {
    var x = document.getElementById("number").value;
    if (x == solution) throw "성공";
    if (x == "") throw "입력 없음";
    if (x > solution) throw "너무 큼";
    if (x < solution) throw "너무 작음";
    if(isNaN(x)) throw "숫자가 아님";
  } catch (e) {
    var y = document.getElementById("message");
    y.innerHTML = "힌트 : " + e;
  } finally {

  }
}
/*
  screen 객체 : 모니터를 객체화 (해상도, 색상정보)
    -속성
      screen.width : 모니터의 가로해상도 (너비)
      screen.height : 모니터의 세로해상도(높이)

      screen.availWidth : 실제 사용 할 수 있는 영역의 너비
      screen.availHeight : 실제 사용 할 수 있는 영역의 높이

      screen.colorDepth
      screen.pixelDepth : 색상을 나타내는 크기 (비트수로 나타냄)
*/
var myWin = null;
function test3()
{
  myWin = window.open("http://naver.com","naver","width = 400, height = 300, left ="+(screen.width-400)/2 + ", top =" + (screen.height-300)/2);
}
