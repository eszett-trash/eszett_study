// var 배열변수 = new Array();
// var 배열변수 = new Array(갯수);
// var 배열변수 = new Array(값1, 값2.......값n);
// var 배열변수 = [값1, 값2, 값3, 값4...값n];

var a = new Array();
a[0] = 1;
a[1] = 2;
a[2] = 3;
a[3] = 4;
a[4] = "홍길동";
a[5] = 3.154;
a[6] = true;
a[7] = 1;
a[8] = 1;

for (let index = 0; index < a.length; index++) {
   document.write(a[index]+"<br>");
    
}