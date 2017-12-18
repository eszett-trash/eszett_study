function handleDrop(e) {
  e.preventDefault();
  var src = e.dataTransfer.getData("Text");

  if (e.target.tagName == "IMG") {
    e.target.parentNode.appendChild(document.getElementById(src));
  } else {
    e.target.appendChild(document.getElementById(src));
  }
}

function allowDrop(e) {
  e.preventDefault();
}

function handleDragStart(e) {
  e.dataTransfer.effectAllowed = 'move';
  e.dataTransfer.setData("Text", e.target.id);
}

function boardAdd()
{
  var f = document.boardForm;

  var writer = f.writer.value;
  if(writer.length ==0)
  {
    alert("작성자를 입력 해 주세요");
    f.writer.focus();
    return;
  }
  var title = f.title.value;
  if(title.length ==0)
  {
    alert("작성자를 입력 해 주세요");
    f.title.focus();
    return;
  }
  var content = f.content.value;

  var today = new Date();
  var y = today.getFullYear();
  var m = today.getMonth()+1;
  var d = today.getDate();

  var date = y + "-" + m + "-"+d;
  var content10 = content;

  var newTr = document.createElement("tr");
  newTr.setAttribute("onclick","view(this)");
  newTr.setAttribute("title",content);

  var tempTd = "<td>"+writer+"</td>";
  tempTd += "<td>"+title+"</td>";
  tempTd += "<td>"+content10+"</td>";
  tempTd += "<td>"+date+"</td>";
  newTr.innerHTML = tempTd;

  var tbody = document.getElementById("boTbody");
  tbody.appendChild(newTr);

  f.writer.value = "";
  f.title.value = "";
  f.content.value = "";

}
