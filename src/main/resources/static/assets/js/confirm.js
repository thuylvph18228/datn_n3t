let app = angular.module("myApp", []);
app.controller("myCtrl", function($scope, $http) {
    $scope.checkByNV = {
        id: null,
        trangThai: 2,
        confirm(){
            getValueTable();
            let order = angular.copy(this);
            order.id = data;
            // Thực hiện xác nhận đơn đặt xe
            $http.post("/rest/dat_xe/update", order).then(resp => {
                alert("Đã xác nhận đơn đặt xe!")
                location.href = "/admin/list_book_car_wait";
            }).catch(error => {
                alert("Lỗi xác nhận!")
                console.log(error )
            })
        },
        received(){
            getValueTable();
            let order = angular.copy(this);
            order.id = data;
            order.trangThai = 3;
            // Thực hiện huỷ đặt xe
            $http.post("/rest/dat_xe/update", order).then(resp => {
                alert("Xác nhận khách hàng đã nhận xe!")
                location.href = "/admin/list_book_car_doing";
            }).catch(error => {
                alert("Lỗi xác nhận!")
                console.log(error )
            })
        },
        traXe(){
            getValueTable();
            let order = angular.copy(this);
            order.id = data;
            order.trangThai = 4;
            // Thực hiện xác nhận đơn đặt xe hoàn thành
            $http.post("/rest/dat_xe/update", order).then(resp => {
                alert("Trả xe thành công")
                $scope.giveCarBack.confirm()
                location.href = "/admin/list_book_car_done";
            }).catch(error => {
                alert("Lỗi trả xe!")
                console.log(error )
            })
        },
        cancelOrder(){
            getValueTable();
            let order = angular.copy(this);
            order.id = data;
            order.trangThai = 5;
            // Thực hiện huỷ đặt xe
            $http.post("/rest/dat_xe/update", order).then(resp => {
                alert("Đơn đã bị huỷ!")
                $scope.sendMail.confirm();
                $scope.giveCarBack.confirm();
                location.href = "/admin/list_book_car";
            }).catch(error => {
                alert("Lỗi xác nhận!")
                console.log(error )
            })
        }
    }
    $scope.sendMail = {
        id: null,
        ly_do: null,
        confirm(){
            getValueTable();
            let order = angular.copy(this);
            order.id = data;
            order.ly_do = ly_do.value;
            console.log(order)
            $http.post("/admin/send-mail-cancel", order).then(resp => {
                alert("Gửi mail thành công")
            }).catch(error => {
                alert("Lỗi gửi mail!")
                console.log(error)
            })
        }
    }
    $scope.doiXe = {
        id: null,
        maX: {id: 0},
        tongTien: 0,
        confirm(){
            getValueTable();
            let order = angular.copy(this);
            order.id = data;
            order.maX.id = idDoiXe;
            order.tongTien = tongTien;
            // Thực hiện đổi xe
            $http.post("/rest/dat_xe/doi_xe", order).then(resp => {
                alert("Đổi xe thành công!")
                location.href = "/admin/list_book_car";
            }).catch(error => {
                alert("Lỗi đổi xe!")
                console.log(error )
            })
        }
    }
    $scope.giveCarBack = {
        id: null,
        trangThai: 0,
        confirm(){
            let car = angular.copy(this);
            car.id = document.getElementById("maXeTra").innerHTML;
            console.log(car)
            // Thực hiện trả xe
            $http.post("/rest/xe/update", car).then(resp => {
            }).catch(error => {
                alert("Lỗi trả xe!")
                console.log(error )
            })
        }
    }
});

let ly_do = document.getElementById("ly_do");
let table = document.getElementsByTagName("table")[0];
let data, hThuc, pdvu, tgianBD, tgianKT, id;
function getValueTable(e) {
    e = e || window.event;
    let target = e.srcElement || e.target;
    while (target && target.nodeName !== "TR") {
        target = target.parentNode;
    }
    if (target) {
        let cells = target.getElementsByTagName("td");
        data = (cells[0].innerHTML);
        hThuc = (cells[1].innerHTML);
        pdvu = (cells[2].innerHTML);
        tgianBD = (cells[5].innerHTML);
        tgianKT = (cells[6].innerHTML);
    }
};

let tongTien, tongphi, idDoiXe;
function chonXe(){
    getValueTable();
    let x = document.getElementById("idXeDoi").value;
    let ary = x.split(",");
    idDoiXe = ary[0];
    let giah = ary[1];
    let giangay = ary[2];
    let star = new Date(tgianBD);
    let end = new Date(tgianKT);
    let diff = end - star;
    let diffHours = diff / (60 * 60 * 1000);
    let diffDay = diff / (24 * 60 * 60 * 1000);

    if (hThuc == 1) {
        tongTien = giah * diffHours;
        tongphi = parseInt(pdvu) + parseInt(tongTien);
    }
    if (hThuc == 2) {
        tongTien = giangay * diffDay;
        tongphi = parseInt(pdvu) + parseInt(tongTien);
    }
    if (hThuc == 3) {
        tongTien = giangay * diffDay;
        tongphi = parseInt(pdvu) + parseInt(tongTien);
    }
    document.getElementById("maCar").innerHTML = idDoiXe;
    document.getElementById("giaHCar").innerHTML = formatMN(giah);
    document.getElementById("giaNgayCar").innerHTML = formatMN(giangay);
    document.getElementById("pdvModal").innerHTML = formatMN(pdvu);
    document.getElementById("tongTienModal").innerHTML = formatMN(tongTien);
    document.getElementById("tongCongModal").innerHTML = formatMN(tongphi);
}

function formatMN(money) {
    const config = {style: 'currency', currency: 'VND', maximumFractionDigits: 9}
    const formated = new Intl.NumberFormat('vi-VN', config).format(money);
    return formated;
}