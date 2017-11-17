/*
Math()
정적 객체 ( 객체를 생성하지 않고 사용하는 객체 )

Math.E ->오일러상수
Math.PI->원주율
Math.LN19 -> 10의 자연로그
Math.LN2 -> 2의 자연로그
Math.LOG10E ->log10e(0.434)
Math.SQRT1_2 -> 1/2의 제곱근(0.707)

-메서드
삼각함수 : sin, cos, tan, asin, acos, atan
Math.삼각함수명(radian dgree);
라디안각도 : 디그리각 * Math.PI/180;

Math.abs(value); ->absolute value
Math.log(value); ->logue value
Math.sqrt(value); ->root value
Math.pow(x value, y value); -> x^y
Math.max(x value, y value); ->bigger than
Math.min(x value, y value); ->smaller than

Math.round(value);
Math.floor(value); 값보다 같거나 작은 정수중 제일 큰 값
(소숫점 이하의 값이 있으면 내림함)

Math.ceil(value); 값보다 같거나 큰 정수중에서 제일 작은 값 (소수점 이하으 ㅣ값이 있으면 올림하다.)
*/


// var temp = Math.floor(Math.random() * 10 + 1);
// document.write(temp);

// var cnt = 0;


// function bbb(input) {

//     return parseInt(input);
// }

// while (1) {
//     cnt++;
//     var input = prompt("숫자입력");
//     if (bbb(input)== temp) {
//         alert("맞았습니다!");
//         break;
//     }
//     alert("맞았습니다!");
// }
// document.write("<br>" + cnt + "번 만에 맞추셨습니다");


 var temp = ["http://img1.daumcdn.net/thumb/R960x0/?fname=http%3A%2F%2Fcfile23.uf.tistory.com%2Fimage%2F2657B9505809B4B634FF66","http://img1.daumcdn.net/thumb/R960x0/?fname=http%3A%2F%2Fcfile25.uf.tistory.com%2Fimage%2F270564505809B4B70AA6CD","http://img1.daumcdn.net/thumb/R960x0/?fname=http%3A%2F%2Fcfile4.uf.tistory.com%2Fimage%2F23683B505809B4B8240464","http://img1.daumcdn.net/thumb/R960x0/?fname=http%3A%2F%2Fcfile5.uf.tistory.com%2Fimage%2F267DC3505809B4B90FE649"];

 var rand = Math.floor(Math.random()*temp.length);
 var intnum = parseInt(rand);

 document.write("<img src = \""+temp[intnum]+"\">");


// var temp = ["가위_좌.PNG", "바위_좌.PNG", "보_좌.PNG"];
// var enemy = ["가위_우.PNG", "바위_우.PNG", "보_우.PNG"];



// while (1) {
//     var input = prompt("가위 바위 보?");
//     var en = Math.floor(Math.random() * 3);
//     if (input == "가위") {
//         document.write("<img src = \"../images/" + temp[0] + "\">");
//         if (en == 0) {
//             document.write("<img src = \"../images/" + enemy[0] + "\">");
//             continue;
//         } else if (en == 1) {
//             document.write("<img src = \"../images/" + enemy[1] + "\">");
//             document.write("패!");
//             break;
//         } else {
//             document.write("<img src = \"../images/" + enemy[2] + "\">");
//             document.write("승!");
//             break;
//         }

//     } else if (input == "바위") {
//         document.write("<img src = \"../images/" + temp[1] + "\">");
//         if (en == 0) {
//             document.write("<img src = \"../images/" + enemy[0] + "\">");
//             break;
//         } else if (en == 1) {
//             document.write("<img src = \"../images/" + enemy[1] + "\">");
//             continue;
//         } else {
//             document.write("<img src = \"../images/" + enemy[2] + "\">");
//             break;
//         }
//     } else if (input == "보") {
//         document.write("<img src = \"../images/" + temp[2] + "\">");
//         if (en == 0) {
//             document.write("<img src = \"../images/" + enemy[0] + "\">");
//             break;
//         } else if (en == 1) {
//             document.write("<img src = \"../images/" + enemy[1] + "\">");
//             break;
//         } else {
//             document.write("<img src = \"../images/" + enemy[2] + "\">");
//             continue;
//         }
//     } else {
//         alert(잘못입력하셨습니다);
//     }
// }



/*
 이미지 객체 : 이미지 객체는 document객체의 하위객체이고 <img>태그를 사용하면 자동으로 image라는 배여ㅑㄹ 생성 -> 이미지 자동할당 

 자바스크립트로 이미지 객체를 선택하는 방법
 1.document.images[첨자].속성
 2.document.이미지이름.속성
 3.DOM API 이용하는 방법
 
 -속성
 src
 width
 height
 alt
 title
 
 
 */

// function swap() {
//     var a;
//     a = document.images[0].src;
//     document.images[0].src = document.images[1].src;
//     document.images[1].src = a;
//     document.images[1].style = "display:none";
// }

// function swap2() {
//     var a;
//     a = document.images[2].src;
//     document.images[2].src = document.images[3].src;
//     document.images[3].src = a;
//     document.images[3].style = "display:none";
// }


// swap();

//function sw_image() {
//    var element = document.getElementById('swImg');
//    // if (element.src.match("switch1_off")) {
//    //     element.src = "../images/switch1_on.png";
//    // } else {
//    //     element.src = "../images/switch1_off.png";
//    // }
//
//    element.src = element.src.match("switch1_off") ? "../images/switch1_on.png" : "../images/switch1_off.png";
//}