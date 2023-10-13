var tableElem = document.getElementById('table_01');
var rowElems = tableElem.rows;
var price = 0;
for (i = 0, len = rowElems.length - 2; i < len; i++) {
	price += parseInt(rowElems[i + 1].cells[11].innerText);
}
document.getElementById('goukei').innerText = price;


var tableElem = document.getElementById('table_01');
var rowElems = tableElem.rows;
var time1 = 0;
for (i = 0, len = rowElems.length - 2; i < len; i++) {
	time1 += parseInt(rowElems[i + 1].cells[7].innerText);
}
var time2 = Math.floor(time1 / 60);
var time2_1 = ('00' + time2).slice(-2);
var time3 = time1 % 60;
var time3_1 = ('00' + time3).slice(-2);
document.getElementById('goukei1').innerText = time2_1
	+ ":" + time3_1;

var tableElem = document.getElementById('table_01');
var rowElems = tableElem.rows;
var price1 = 0;
for (i = 0, len = rowElems.length - 2; i < len; i++) {
	price1 += parseInt(rowElems[i + 1].cells[8].innerText);
}
document.getElementById('goukei2').innerText = price1;


