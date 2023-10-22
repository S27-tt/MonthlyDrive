var calendar = document.getElementById('startTime');
var fp = flatpickr(calendar, {
	enableTime: true,
	locale: 'ja',
	dateFormat: "Y/m/d H:i",
	allowInput: true,
});
