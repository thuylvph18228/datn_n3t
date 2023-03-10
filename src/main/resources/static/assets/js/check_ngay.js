let nowTemp = new Date();
let now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(),
    nowTemp.getHours(), nowTemp.getMinutes(), nowTemp.getSeconds(), nowTemp.getMilliseconds());
function checkNgay () {
    'use strict';
    let nowTemp = new Date();
    let now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(),
        nowTemp.getHours(), nowTemp.getMinutes(), nowTemp.getSeconds(), nowTemp.getMilliseconds());

    let checkin = $('#thoiGianBD').datepicker({
        onRender: function (date) {
            return date.valueOf() < now.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        if (ev.date.valueOf() > checkout.date.valueOf()) {
            let newDate = new Date(ev.date)
            newDate.setDate(newDate.getDate() + 1);
            checkout.setValue(newDate);
        }
        checkin.hide();
        $('#thoiGianKT')[0].focus();
    }).data('datepicker');
    let checkout = $('#thoiGianKT').datepicker({
        onRender: function (date) {
            return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        checkout.hide();
    }).data('datepicker');
}