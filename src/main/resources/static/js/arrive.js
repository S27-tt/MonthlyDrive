var time2 = document.getElementById('time2');
var fp = flatpickr(time2, {
	enableTime: true,
	showMonthAfterYear: true,
	locale: 'ja',
	dateFormat: "Y/m/d H:i",
	allowInput: true,
});
