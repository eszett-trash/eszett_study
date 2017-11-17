// //String 객체 : 문자열을 나타내는 객체

// //-객체 생성
// //  var 변수 = "문자열";
// //  var 변수 = new String("문자열");   // 이쪽은 뉴스트링 객체를 만들어서 넣어주는 것

// //-속성
// //  length : 문자열의 길이 (글자 수)

// //-메서드
// //  1.문자열.toLowerCase();
// //    -문자열중 영문자들을 모두 소문자로 변환한다.
// //  2.문자열.toUpperCase();
// //    -문자열 줄 영문자들을 모두 대문자로 변환한다.
// //  3. 문자열.indexOf(찾는문자열, 시작위치); (시작부터)
// //  4. 문자열.lastIndexOf(찾는문자열, 시작위치);(마지막부터)
// //  5. 문자열.substring(시작위치, 종료위치);
// //    -문자열의 시작위치부터 종료위치 이전까지의 문자열을 추출한다.
// //  6. 문자열.charAt(위치);
// //    -문자열의 위치번째의 1개의 문자를 추출한다.
// //  7. 문자열.slice(시작위치, 종료위치);
// //    -종료위치가 양수이면 substring()메서드와 같이 작동한다.
// //    -종료위치가 음수이면 시작위치부터 끝까지 중에서 뒤에서부터 생략할 개수로 사용된다.
// //  8. 문자열.substr(시작위치, 글자수);
// //    -시작위치부터 글자수 만큼을 추출한다.
// //  9. 문자열1.concat(문자열2);
// //    -문자열 1 뒤에 문자열2를 연결하여 새로운 문자열로 반환한다.,
// // 10. 문자열.split("구분문자");
// //    -문자열을 구분문자를 기준으로 분리하고, 분리된 데이터들을 배열에 담아 반환한다.



// // var str = "                                       임은정&정              지윤&이로         운&성혜린                                   ";
// //
// // var names = str.split("&");
// //
// // // document.write(names);
// // //
// //
// // for (var i = 0; i < names.length; i++) {
// //   document.write(names[i]+"<br>")
// // }
// //
// //
// // //11. 문자열.replace(찾는문자열,바뀔문자열);
// // //  -문자열중에서 찾는 문자열을 찾아 바뀔문자열로 바꿔준다.
// // //12. 문자열.charCodeAt(위치);
// // //  -문자열 중 위치번째 문자의 코드값을 반환한다.
// // //13. 문자열.trim();
// // //  -문자열 앞 뒤의 공백을 보두 없앤다
// //
// // document.write(str.trim());


// var date = new Date();


// var a = prompt("주민번호입력");
// var pa = a.split("-");
// var sex = parseInt(pa[1].substr(0, 1));
// var temp;

// if (sex == 3 || sex == 4) {
//   document.write("20" + pa[0].substr(0, 2) + "년" + pa[0].substr(2, 2) + "월" + pa[0].substr(4, 2) + "일" + "<br>");
//   temp = parseInt(pa[0].substr(0, 2)) + 2000;


// } else if (sex == 1 || sex == 2) {
//   document.write("19" + pa[0].substr(0, 2) + "년" + pa[0].substr(2, 2) + "월" + pa[0].substr(4, 2) + "일" + "<br>");
//   temp = parseInt(pa[0].substr(0, 2)) + 1900;
// }

// document.write(sex % 2 == 1 ? "남자" : "여자" + " " + (date.getFullYear() - temp + 1) + "세" + "<br>");

// var mul =
//   pa[0].substr(0, 1) * 2 +
//   pa[0].substr(1, 1) * 3 +
//   pa[0].substr(2, 1) * 4 +
//   pa[0].substr(3, 1) * 5 +
//   pa[0].substr(4, 1) * 6 +
//   pa[0].substr(5, 1) * 7 +
//   pa[1].substr(0, 1) * 8 +
//   pa[1].substr(1, 1) * 9 +
//   pa[1].substr(2, 1) * 2 +
//   pa[1].substr(3, 1) * 3 +
//   pa[1].substr(4, 1) * 4 +
//   pa[1].substr(5, 1) * 5;

// var sumsum = 0;

// for (let index = 0; index < a.length; index++) {
//   document.write(a.charAt(index));
//   if (index < 9) {
//     if (index == 6) {
//       continue;
//     }
//     sumsum += (a.charAt(index) * (index + 2));
//   } else if (index >= 9) {
//     sumsum += (a.charAt(index) * (index - 7));
//   }
// }


// var sub = mul % 11;

// var aaa = 11 - sub;
// var tmptmp = aaa < "10" ? parseInt(aaa) : aaa - 10;


// document.write(tmptmp == pa[1].substr(6, 1) ? "맞는 번호입니다" : "유효성 ㄴ" + "<br>");



// document.write(pa[0].charAt(0) * 3);





var temp = "welcome to my homepage";
var a = temp.toUpperCase();
var b = a.toLowerCase();
document.write(a);
document.write(b);

