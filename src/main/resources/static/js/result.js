var tableElem = document.getElementById('table_01');
var rowElems = tableElem.rows;
var price1 = 0;
for (i = 0, len = rowElems.length - 2; i < len; i++) {
	document.getElementsByClassName('delete')[i].onclick=function(){return confirm("入力内容を削除しても良いですか？")};
}


