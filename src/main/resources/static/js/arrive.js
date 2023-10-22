var calendar = document.getElementById('endTime');
var fp = flatpickr(calendar, {
	enableTime: true,
	showMonthAfterYear: true,
	locale: 'ja',
	dateFormat: "Y/m/d H:i",
	allowInput: true,
});
