 // var temp = ["http://img1.daumcdn.net/thumb/R960x0/?fname=http%3A%2F%2Fcfile23.uf.tistory.com%2Fimage%2F2657B9505809B4B634FF66", "http://img1.daumcdn.net/thumb/R960x0/?fname=http%3A%2F%2Fcfile25.uf.tistory.com%2Fimage%2F270564505809B4B70AA6CD", "http://img1.daumcdn.net/thumb/R960x0/?fname=http%3A%2F%2Fcfile4.uf.tistory.com%2Fimage%2F23683B505809B4B8240464", "http://img1.daumcdn.net/thumb/R960x0/?fname=http%3A%2F%2Fcfile5.uf.tistory.com%2Fimage%2F267DC3505809B4B90FE649"];
 //
 // var i = 1;
 //
 //
 // function swap() {
 //
 //   document.img.src = temp[i++];
 //   if (i == 4) { i = 0; }
 //
 // }
 /////////////////////////////////////////////////////////////////

 function view() {
   // alert(document.testForm.txtName.value);
   // alert(document.testForm.txtPass.value);
   // alert(document.testForm.content.value);
   document.testForm.txtName.value = "김우식";

   document.testForm.txtPass.focus();
   document.testForm.content.select(); //텍스트 전부 선택
 }

 function gugu() {
   var a = document.gu.dan.value;
   document.gu.tstform.value += a + "단\n";
   for (var i = 1; i <= 9; i++) {
     document.gu.tstform.value += a + "*" + i + "=" + a * i + "\n";
   }
 }

 function qwer() {
   var a = document.opop.op1.value;
   var b = document.opop.op2.value;
   var c = document.opop.opopop.value;
   switch (c) {
     case "+":
       document.opop.op3.value = a * 1 + b * 1;
       break;
     case "-":
       document.opop.op3.value = a * 1 - b * 1;
       break;
     case "*":
       document.opop.op3.value = a * 1 * b * 1;
       break;
     case "/":
       document.opop.op3.value = (a * 1) / (b * 1);
       break;
     default:
       document.opop.op3.value = "떙";

   }
 }
