var today = new Date();
//年・月・日・曜日を取得
var month = today.getMonth() + 1;
var week = today.getDay();
var day = today.getDate();

var week_ja = new Array("日", "月", "火", "水", "木", "金", "土");
//年・月・日・曜日を書き出す
document.getElementById("day").value = month + "月" + day + "日 " + "(" + week_ja[week] + ")";