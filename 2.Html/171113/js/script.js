function print_star(star_num) {
    let tmp = star_num - 0;
    let result = 0; // 변수 number를 거꾸로 변환해서 담을 변수
    let cnt = 0;
    let temp = 0;

    if (typeof (tmp) == "number") {
        while (tmp != 0) {
            result = tmp % 10;
            tmp = (tmp - result) / 10;
            cnt = cnt * 10 + result;
        }
        for (let index = 0; cnt != 0; index++) {
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
}

print_star(1234123);

/*
1. 사용자 정의 함수 : 사용자가 직접 작성한 함수
    1-1: 정의방법
        function name(params) {
            처리할 내용들,,,;
            
            return 반환값;
        }

        var 함수명 = function(params)
        {
            처리할 내용들....;

            return 반환값;
        }
    1-2:함수 호출
        1)return x param x
            형식) 함수명();
        2)return x param o
            형식) 함수명(params);
        3)return o param x
            형식) 변수 = 함수명()
        3)return o param o
            형식) 변수 = 함수명(params);

*/
////////////////////////////////////////////////////////////////////////////
// function insa2(x) {
//     var temp = x+"씨 만나서 반갑습니다";

//     return temp;
// }
// var a = prompt("이름을 입력하세요");
// document.write(insa2(a));
////////////////////////////////////////////////////////////////////////////

// function minus(x, y) {
//     if (x > y) {
//         return x - y;
//     } else {
//         return y - x;
//     }
// }

// function add(x, y) {
//     return x + y;
// }

// function multi(x, y) {
//     return x * y;
// }
////////////////////////////////////////////////////////////////////////////
// function divide(x, y) {
//     if (x > y) {
//         return x / y;
//     } else {
//         return y / x;
//     }
// }
// function remine(x, y) {
//     if (x > y) {
//         return x % y;
//     } else {
//         return y % x;
//     }
// }
// document.write(minus(7, 23));
// document.write("<br>");
// document.write(add(7, 23));
// document.write("<br>");
// document.write(multi(7, 23));
// document.write("<br>");
// document.write(divide(7, 23));
// document.write("<br>");
// document.write(remine(7, 23));
////////////////////////////////////////////////////////////////////////////

function f_to_c() {
    var a = prompt("섭->화 섭씨를 입력하세요");
    document.write((parseInt(a) - 32) * (5 / 9));
}

function c_to_f() {
    var b = prompt("화->섭 화씨를 입력하세요");
    document.write(parseInt(b) * (9 / 5) + 32);
}




// document.write(f_to_c(parseInt(a)));
// document.write("<br>");
// document.write(c_to_f(parseInt(b)));

/*

2. 내장함수 : 자바스크립트 내에 내장된 함수 (정의 없이 언제든지 사용 할 수 있다)

*/