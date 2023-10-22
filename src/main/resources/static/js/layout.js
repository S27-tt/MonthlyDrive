var time = document.getElementById('time');
var fp = flatpickr(time, {
  enableTime: true,
  locale: 'ja',
    dateFormat: "Y/m/d H:i",
    allowInput: true,
});
