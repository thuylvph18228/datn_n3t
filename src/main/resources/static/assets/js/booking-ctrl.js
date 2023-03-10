const cccd = document.getElementById("cccd").value;
const bangLai = document.getElementById("bangLai").value;

app.controller("booking-ctrl", function ($scope, $http) {
    $scope.order = {
        maX: {id: parseInt(maX.value)},
        maND: {id: parseInt(document.getElementById("maND").value)},
        maNV: {id: 1},
        thoiGianBD: null,
        thoiGianKT: null,
        tongTien: 0,
        hinhThuc: 0,
        trangThai: 0,
        purchase() {
            if (this.thoiGianBD == null || this.thoiGianKT == null || hinhThucThanhToan == null) {
                alert("Vui lòng nhập đầy đủ thông tin!")
            } else if (cccd.trim().length === 0 || bangLai.trim().length === 0) {
                alert("Vui lòng cập nhật bằng lài và cccd trước khi đặt xe!")
                location.href = "/user/information";
            } else {
                if (hinhThucThanhToan.value == 1) {
                    //thanh toán tiền mặt
                    let order = angular.copy(this);
                    order.tongTien = document.getElementById("amount").value;
                    order.hinhThuc = hinhThucTinhTien;
                    order.trangThai = 0;
                    // Thực hiện đặt xe
                    $http.post("/rest/dat_xe", order).then(resp => {
                        alert("Đặt xe thành công!");
                        $scope.builds.createBuild();
                        $scope.cars.updateTT();
                        $scope.buildDetail.createBuildDetail();
                        location.href = "/user/booking_schedule";
                    }).catch(error => {
                        alert("Đặt xe lỗi!")
                        console.log(error)
                    })
                } else if (hinhThucThanhToan.value==2) {
                    //thanh toán onl
                    let order = angular.copy(this);
                    order.tongTien = document.getElementById("amount").value;
                    order.hinhThuc = hinhThucTinhTien;
                    order.trangThai = 2;
                    // Thực hiện đặt xe
                    $http.post("/rest/dat_xe", order).then(resp => {
                        alert("Đặt xe thành công!");
                        $scope.builds.createBuild()
                        $scope.cars.updateTT()
                        $scope.buildDetail.createBuildDetail()
                        location.href = "/user/thanhtoan";
                    }).catch(error => {
                        alert("Đặt xe lỗi!")
                        console.log(error)
                    })
                } else {
                    //đặt cọc
                    let order = angular.copy(this);
                    order.tongTien = document.getElementById("amount").value/2;
                    order.hinhThuc = 3;
                    order.trangThai = 1;
                    // Thực hiện đặt xe
                    $http.post("/rest/dat_xe", order).then(resp => {
                        alert("Đặt xe thành công!");
                        $scope.builds.createBuild()
                        $scope.cars.updateTT()
                        $scope.buildDetail.createBuildDetail()
                        location.href = "/user/thanhtoan";
                    }).catch(error => {
                        alert("Đặt xe lỗi!")
                        console.log(error)
                    })
                }
            }
        }
    }

    $scope.builds = {
        maTT: {id: 0},
        tongTien: 0,
        trangThai: 0,
        ngaythanhtoan: null,
        createBuild() {
            let build = angular.copy(this);
            build.maTT.id = parseInt(hinhThucThanhToan.value);
            build.tongTien = document.getElementById("amount").value;
            build.trangThai = hinhThucThanhToan.value;
            build.ngaythanhtoan = today;
            // Thực hiện tạo hoá đơn
            $http.post("/rest/hoa_don", build).then(resp => {
            }).catch(error => {
                alert("Tạo hoá đơn lỗi!")
                console.log(error)
            })
        }
    }

    $scope.buildDetail = {
        thoiGianBD: $scope.order.thoiGianBD,
        thoiGianKT: $scope.order.thoiGianKT,
        createBuildDetail() {
            let orderDetail = angular.copy(this);
            // Thực hiện tạo chi tiết hoá đơn
            $http.post("/rest/chi_tiet_hoa_don", orderDetail).then(resp => {
            }).catch(error => {
                alert("Tạo chi tiết hoá đơn lỗi!")
                console.log(error)
            })
        }
    }

    $scope.cars = {
        id: parseInt(maX.value),
        trangThai: 0,
        updateTT() {
            let car = angular.copy(this);
            car.trangThai = trangThaiXe;
            // Thực hiện update trạng thái cho xe
            $http.post("/rest/xe/update", car).then(resp => {
            }).catch(error => {
                alert("update trạng thái xe lỗi!")
                console.log(error)
            })
        }
    }
})

let maX = document.getElementById("maX");
let trangThaiXe = 0;
let hinhThucTinhTien;

function myFunction(hthuc) {
    hinhThucTinhTien = hthuc;
    let x = hthuc;
    let giah = document.getElementById("giatheogio").value;
    let pdvu = parseInt(document.getElementById("pdvu").value);
    let giangay = document.getElementById("giatheongay").value;
    let tgianBD = document.getElementById("thoiGianBD").value;
    let tgianKT = document.getElementById("thoiGianKT").value;
    let star = new Date(tgianBD);
    let end = new Date(tgianKT);
    let diff = end - star;
    let diffHours = diff / (60 * 60 * 1000);
    let diffDay = diff / (24 * 60 * 60 * 1000);
    let tongtien = 0, tongphi = pdvu;

    if (x == 1) {
        tongtien = giah * diffHours;
        tongphi = pdvu + tongtien;
    }
    if (x == 2) {
        tongtien = giangay * diffDay;
        tongphi = pdvu + tongtien;
    }

    document.getElementById("tongtien").innerHTML = formatMoney(tongtien);
    document.getElementById("tongphithuexe").innerHTML = formatMoney(tongphi);
    document.getElementById("tongcong").innerHTML = formatMoney(tongphi);
    document.getElementById("amount").value = tongphi;
}

function formatMoney(money) {
    const config = {style: 'currency', currency: 'VND', maximumFractionDigits: 9}
    const formated = new Intl.NumberFormat('vi-VN', config).format(money);
    return formated;
}

let hinhThucThanhToan;

function thanhtoan() {
    hinhThucThanhToan = document.getElementById("mySelectHTTT");
    if (parseInt(hinhThucThanhToan.value) == 2) {
        trangThaiXe = 1;
    } else {
        trangThaiXe = 0;
    }
}

let today = new Date();
let start = today.toISOString().slice(0, 16);
document.getElementsByName("thoiGianBD")[0].min = start;
let timeBD = new Date(document.getElementById("thoiGianBD").value);
document.getElementById("thoiGianKT").disabled = true;

function checkTime(){
    document.getElementById("thoiGianKT").disabled = false;
    let timeBD = new Date(document.getElementById("thoiGianBD").value);
    let tomrrow = new Date();
    tomrrow.setDate(timeBD.getDate() + 1);
    let end = tomrrow.toISOString().slice(0, 16);
    document.getElementsByName("thoiGianKT")[0].min = end;
}

var slider = document.getElementById("sort_price");
var output = document.getElementById("showV");
output.innerHTML = slider.value;

slider.oninput = function() {
    output.innerHTML = this.value;
}

let maU = document.getElementById("maU");
let tenU = document.getElementById("tenUU");
let nsU = document.getElementById("nsU");
let sdtU = document.getElementById("sdtU");
let ccU = document.getElementById("ccU");
let blU = document.getElementById("blU");
let dcU = document.getElementById("dcU");
let gtU = document.getElementsByName("gtU");
