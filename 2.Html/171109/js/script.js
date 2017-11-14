// var temp = "전역변수";
// var temp_2 = "전역변수_2";

// function test() {
//     var temp = "지역변수";
//     document.write(temp+"<br>");
//     document.write(temp_2);
// }

// test();
// ///////////////////////////////////////////////////////
// var num = new Array(5);

// for (var i = 0;1;i++) {
//     var a = prompt("이름을 입력 해 주세요");
//     num[i]=a;
//     if(a == "" || a== null)
//     {
//         break;
//     }

// }
// document.write(num);
// document.write("<br>");

// var a = prompt("숫자 다섯개를 입력하세요");

// var score = 0;

// for (let index = 0; index < 5; index++) {
//   var input = prompt("숫자를 입력하시오");

//   if (score.indexOf(input) >= 0) {
//     alert("중복입니다");
//     index--;
//   } else if (score.indexOf(input) == -1) {
//     score[i] = input * 1;
//     //숫자로 변환
//   }
// }
// document.write(score + "<br>");

// function comp(a, b) {
//   if (a < b) {
//     return 1;
//   } else {
//     return -1;
//   }
// }
// document.write(score.sort(comp));


//array 사용
/*
var arrs = new Array();
var tempInput;

for (let index = 0; ; index++) {
  tempInput = prompt("숫자를 입력 해 주세요");
  arrs[index]=tempInput;
  if(tempInput == "" || tempInput == null)
  {
      break;
  }
}

for (let index = 0; index < arrs.length; index++) {
  for (let j = 0; j < arrs[index]; j++) {
    document.write("*");
  }
  document.write("<br>");
  
}
*/
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//숫자뒤집기해서 출력 ㅅㅂ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
var number = prompt("정수를 입력 해 주세요");
var tmp = number - 0;
var result = 0; // 변수 number를 거꾸로 변환해서 담을 변수
var cnt = 0;
var temp = 0;

//document.write(typeof(tmp)); //들어온 문자열의 자료형을 판단 할 수 있다. 리턴값은 string이기 때문에 스트링으로 체크해야한다.
//num = parseInt(num) //이렇게 하면 문자열인 num이 숫자가된다
if (typeof (tmp) == "number") {
  while (tmp != 0) {
    result = tmp % 10;
    tmp = (tmp - result) / 10;
    cnt = cnt * 10 + result;
  }
  for (let index = 0; cnt!=0; index++) {
    temp = cnt % 10;
    for (var i = 0; i < temp; i++) {
      document.write("*");
    }
    cnt = (cnt - temp) / 10;
    document.write("<br>");
  }
} else {
  document.write("숫자가 아닙니다");
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//계속 그냥 찍어버리면 ..,,,,