

// switch (today.getDay()) {
//     case 1:
//         document.write("월욜");
//         break;
//     case 2:
//         document.write("화");
//         break;
//     case 3:
//         document.write("수욜");
//         break;
//     case 4:
//         document.write("목");
//         break;
//     case 5:
//         document.write("금");
//         break;
//     case 6:
//         document.write("토");
//         break;
//     case 0:
//         document.write("일");
//         break;

//     default:
//         break;
// }

var today = new Date();
var past = new Date(2017, 10, 25);

//한 달의 차가 있으므로 구하고자 하는 날짜보다 한 달 전으로
past.setMonth(past.getMonth()-1);

var a = parseInt((today.getTime()-past.getTime())/86400000);

var yy = 0;
var mm = 0;
var dd = 0;

document.write("오늘부터 "+a+"일 째 되는 날은 "+yy+"년 "+mm+"월 "+dd+"일 입니다.");


// if (today.getFullYear() - past.getFullYear() > 0) {
//     for (var i = 0 ; i <(today.getFullYear() - past.getFullYear());i++)
//     {
//         yeartemp = today.getFullYear() - past.getFullYear();
        
//             if (a % 4 != 0 || (a % 400 != 0 && a % 100 == 0)) {
//                 yeartemp += 0;
//             } else {
//                 yeartemp += 1;
//             }
//     }
// }


// if ((today.getMonth() - past.getMonth()) % 2 == 0) {
//     if ((today.getMonth() - past.getMonth()) == 0) {

//     }
//     mnttmp = ((today.getMonth() - past.getMonth()) / 2) * 61;
//     document.write(mnttmp);
// } else if ((today.getMonth() - past.getMonth()) % 2 == 1) {

//     document.write(today.getMonth());
// }

// temp += (today.getDate() - past.getDate());


// document.write("오늘은 " + past.getFullYear() + "년 " + past.getMonth() + "월 " + past.getDate() + "일로부터" + temp + "일 째 입니다");