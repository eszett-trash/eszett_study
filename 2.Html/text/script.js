// //1.
// var a;
// a = 2;
// //2.
// var inputNum = prompt("숫자를 입력 해 주세요..");
// inputNum = parseInt(inputNum);
// //3.
// var a;
// var b = null;
// //4.
// var a = 1;
// var b = 2;
// var c = a+b;
// var d = a-b;
// var e = a*b;
// //5
//
// function sum(num1, num2){
//   return num1*1+num2*1;
// }
// var num1 = prompt("숫자를 입력 해 주세요.");
// var num2 = prompt("두번째 숫자입력");
//
// document.write(sum(num1,num2));
//6
// var date = new Date();
// var temp;
// switch (prompt("오늘 무슨요일?")) {
//   case "월요일":
//     temp = 1;
//     break;
//   case "화요일":
//     temp = 2;
//     break;
//   case "수요일":
//     temp = 3;
//     break;
//   case "목요일":
//     temp =4;
//     break;
//   case "금요일":
//     temp = 5;
//     break;
//   case "토요일":
//     temp = 6;
//     break;
//   case "일요일":
//     temp = 0;
//     break;
//   default:
//
// }
// document.write(date.getDay()==temp?"true":"false");
//7
// function sumFrom1ToN(n){
//   var temp = 1;
//   var sum = 0;
//   while(temp <= n){
//     sum+=temp;
//     temp++;
//   }
//   return sum;
// }
// document.write(sumFrom1ToN(2));
//8
// var cost = [85,42,37,10,22,8,15];
// var total_cost = 0;
// for (var i = 0; i < cost.length; i++) {
//   total_cost+=cost[i];
// }
//10
// var arr = new Array(1,2,3,4,5);
// for (var i = 0; i < arr.length; i++) {
//   document.write(arr[i])
//   if(i!=arr.length-1)
//   {
//     document.write("->");
//   }
// }
//11
// var arr=[1,2,3];
// arr.push("end");
// arr.unshift("begin");
//12
// function firstLetter(str) {
//   return str.charAt(0).toUpperCase();
// }
