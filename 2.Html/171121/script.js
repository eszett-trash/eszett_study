// function view() {
//   //select객체 콤보박스, 리스트박스
//   // 1.콤보박스 -size속성이 생략되거나 1일경우
//   // 2. 리스트박수 - size속성이 2 이상일경우
//   // length : select한 객체의 항목 수를 나타낸다
//   // selectIndex : 선택한 항목의 index번호를 나타낸다.
//   //              만약 선택한 항목이 없으면 -1이 된다.
//   // value :현재 선택한 항목의 value값을 나타낸다
//   // document.폼이름.객체이름.options[첨자].value
//   // ->첨자번쨰의value속성의 값을 나타낸다.
//
//
//   //document.testForm.cel.selectedIndex = 3;
//
//   alert(document.testForm.gugudan.options[2].value);
// }
//
// function temp() {
//
//   var a = document.testForm.gugudan.selectedIndex + 1;
//   var b = "";
//   for (var i = 0; i < 10; i++) {
//     b += (a + "*" + i + "=" + a * i + "\n");
//   }
//   $('#mondai').text(b);
// }
//
// function moveright() {
//
// }
function add() {
  var data = document.form_big.aa.value;
  if (data == "") {
    alert("추가 사항을 입력");
    document.form_big.aa.focus();
    return;
  }

  var myOp = new Option(data, data); // text값, text값
  var len = document.form_big.left.length;
  document.form_big.left.options[len] = myOp;

  document.form_big.aa.value = "";
}

function first_a() {
  var temp = document.form_big.left.selectedIndex;
  var data = document.form_big.left.options[temp].value;
  var len = document.form_big.right.length;

  var myOp = new Option(data, data);
  document.form_big.right.options[len] = myOp;
  document.form_big.left.options[temp] = null;
}

function first_b() {

  for (var a = 0; a < document.form_big.left.length; a++) {
    var data = document.form_big.left.options[0].value;
    var myOp = new Option(data, data);
    var len = document.form_big.right.length;
    document.form_big.right.options[len] = myOp;
    document.form_big.left.options[0] = null;
  }
}


function second_a() {
  var temp = document.form_big.right.selectedIndex;
  var data = document.form_big.right.options[temp].value;
  var len = document.form_big.left.length;

  var myOp = new Option(data, data);
  document.form_big.left.options[len] = myOp;
  document.form_big.right.options[temp] = null;
}

function second_b() {

  for (var a = 0; a <= document.form_big.right.length; a++) {
    var data = document.form_big.right.options[a].value;
    var len = document.form_big.left.length;

    var myOp = new Option(data, data);
    document.form_big.left.options[len] = myOp;
    document.form_big.right.options[a] = null;
  }

}
