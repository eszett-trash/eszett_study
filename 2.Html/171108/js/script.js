// for (var i = 0; i <10; i++) {
//   document.write(i%2==1?"안녕하세요 " + i + "<br>":"");
// }
// var a = 1;

// document.write("<table border = 1 style ='text-align:center; border-collapse:collapse'>");
// document.write("<tr><td colspan = '3'>구구단표</tr>");
// for (var i = 1; i < 10; i++) {
//   if (i % 3 == 1) {
//     document.write("<tr>")
//   }
//   document.write("<td>"+i+"단<br>");
//   for (var j = 1; j < 10; j++) {
//     document.write(i + "*" + j + "=" + i * j + "<br>")
//   }
//   document.write("</td>")
// }
// document.write("</tr>")
// document.write("</table>");

// var a = 0;
// var temp = 0;
// var sum = 0;

// while (a < 100) {
//   a++;
//   sum += a;
//   document.write(a);
//   if (a % 10 != 0) {
//     temp += a;
//     document.write("+");
//   } else if (a % 10 == 0) {
//     temp += a;
//     document.write("=" + temp + "<br>");
//     temp = 0;
// //   }

// }

//프롬프트로 가위바위보를 받음

let input = prompt("가위 바위 보?");
let input2 = prompt("가위 바위 보?");

switch (input) {
  case "가위":
    document.write(input2=="가위"?"비겼습니다.":input2=="바위"?"먼저 낸 사람이 졌습니다":"먼저 낸 사람이 이겼습니다");
    break;

    case "바위":
    document.write(input2=="바위"?"비겼습니다.":input2=="보"?"먼저 낸 사람이 졌습니다":"먼저 낸 사람이 이겼습니다");
    break;

    case "보":
    document.write(input2=="보"?"비겼습니다.":input2=="가위"?"먼저 낸 사람이 졌습니다":"먼저 낸 사람이 이겼습니다");
    break;

  default:
    break;
}

if((input == "가위"||input == "바위"||input == "보")&&(input2 == "가위"||inpu2t == "바위"||input2 == "보"))
{
  if (input == input2) {
    document.write("비겼습니다");
  } else if((input == "가위" && input2 == "보")||(input == "바위" && input2 == "가위")||(input == "보" && input2 == "바위")){
    document.write("첫번쨰 낸 사람이 이겼습니다.");
  }else{
    document.write("첫번쨰 낸 사람이 졌습니다.");
  }
}
else
{

}

