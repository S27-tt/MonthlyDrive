var time2 = document.getElementById('time2');
var fp = flatpickr(time2, {

	enableTime: true,
	dateFormat: "Y/m/d H:i",
});

var textForm = document.getElementById('time2');
  textForm.value = '';