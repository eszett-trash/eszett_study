// var a = prompt("몇 평입니까?");
// function PtoSq(a) {return a*3.305784;}
// document.write(PtoSq());

// //윤년 판별코드

// var year = prompt("몇년입니까?");

// function aa(a) {
//     a = parseInt(a);

//     if (a % 4 != 0 || (a % 400 != 0 && a % 100 == 0)) {
//         return document.write("윤년이 아닙니다");
//     } else {
//         return document.write("윤년입니다");
//     }
// }
// aa(year);



//함수 우선순위

var MyFunc = function () {
    document.write("함수");
} //우선순위가 제일 높음

function MyFunc() {
    document.write("함수A");
}

function MyFunc() {
    document.write("함수B");
} //제일 아래에잇는쪽이 우선순위가 일반적으로는 높음

MyFunc();


// //객체
//     -사용자 정의 객체
//     1)객체 정의 (자바에서 클래스 구성과 동일)
//     function 클래스명(파라메터변수)
//     {
//         this.속성1;
//         this.속성2;
//         this.메서드명 = function name(params) {
//             처리할내용들
//         }
//     }
//     2)객체 생성
//     객체변수 = new 클래스명(값들..);
//     객체변수.속성 = 값;
//     객체변수['속성'] = 값;

//     객체변수.메서드명(값들...); // 메서드 호출
//     객체변수['메서드명'](값들);//

// function Human() {
//     //속성
//     this.name;
//     this.age;

//     //메서드
//     this.getAge = function () {
//         return this.age;
//     }
//     this.setAge = function (newAge) {
//         this.age = newAge;
//     }
//     this.toString = function()
//         {
//             return "<br>" + "이름  : " + this.name + "<br>" + "나이 : " +this.age;
//         }
// }

// var lee = new Human(); //객체화

// lee.name = "이씨";
// lee.setAge(30);
// lee['setAge'](50);
// document.write(lee.toString());

// var kim = new Human();

// kim.name = "김씨";
// kim.setAge(30);
// kim['setAge'](200);
// document.write(kim.toString());

// var kim2 = new Human();

// kim2.name = "김씨";
// kim2.setAge(10);
// document.write(kim2.toString());


function MyCar() {
    this.color;
    this.number;
    this.speed;

    this.toString = function () {
        return "<br>" + "색  : " + this.color + "<br>" + "번호 : " + this.number;
    }
}

function MyCar(color, number, speed) {
    this.color = color;
    this.number = number;
    this.speed = speed;

    this.toString = function () {
        return "<br>" + "색  : " + this.color + "<br>" + "번호 : " + this.number + "<br>" + "속도 : " + this.speed+ "<br>";
    }

    this.speedUp = function () {
        this.speed += 10;
    }

    this.speedDown = function () {
        this.speed -= 10;
    }
}

var bmw = new MyCar("검정", "번호", 450);
// bmw.color = "빨강";
// bmw.number = "12수1234";
// bmw.speed=30;
document.write(bmw.toString());
bmw.speedDown();
bmw.speedDown();
bmw.speedDown();
bmw.speedDown();
bmw.speedDown();
bmw.speedDown();
bmw.speedDown();
bmw.speedDown();
bmw.speedDown();
bmw.speedDown();
bmw.speedDown();
bmw.speedDown();

document.write(bmw.toString());

bmw.speedUp();
bmw.speedUp();
bmw.speedUp();
bmw.speedUp();
bmw.speedUp();
bmw.speedUp();

document.write(bmw.toString());
// var temp = new MyCar();
// document.write(temp.toString());