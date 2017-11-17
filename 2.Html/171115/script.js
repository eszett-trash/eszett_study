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
var temp = 30;

today.setDate(today.getDate()+temp);
document.write(today.toLocaleString());