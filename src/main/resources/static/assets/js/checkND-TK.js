let appp = angular.module("myApp", []);
appp.controller("booking-ctrl", function ($scope, $http) {
    $scope.change = {
        id: idU.value,
        trangThai: 0,
        changeTT() {
            getValueTable();
            let order = angular.copy(this);
            order.id = data;
            $http.post("/admin/list_user", order).then(resp => {
                alert("Đã vô hiệu hóa tài khoản")
                location.href = "/admin/list_nguoidung";
            }).catch(error => {
                alert("Đã vô hiệu hóa tài khoản")
                location.href = "/admin/list_nguoidung";
            })
        }
    }
    // $scope.updateCar = {
    //     id: idx.value,
    //     maLX: {id: malx.value},
    //     ten: tenxe.value,
    //     anh: anhxe.value,
    //     hangXe: hangxe.value,
    //     giaH: gio.value,
    //     giaNgay: ngay.value,
    //     trangThai: trangthaixe.value,
    //     saveCar() {
    //         let car = angular.copy(this);
    //         $http.post("/admin/update_car", car).then(resp => {
    //             alert("Update thành công")
    //             location.href = "/admin/list_car"
    //         }).catch(error => {
    //             alert("Update lỗi")
    //             console.log(error)
    //         })
    //     }
    // }

});

let table = document.getElementsByTagName("table")[0];
let data, hThuc, pdvu, pbh, tgianBD, tgianKT, id;

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
        pbh = (cells[3].innerHTML);
        tgianBD = (cells[6].innerHTML);
        tgianKT = (cells[7].innerHTML);
    }
};

let hangxe = document.getElementById("hangxe");
let malx = document.getElementById("malx");
let tenxe = document.getElementById("ten");
let anhxe = document.getElementById("anh");
let gio = document.getElementById("giah");
let ngay = document.getElementById("giangay");
let trangthaixe = document.getElementById("trangthai");
let idx = document.getElementById("idXe");

let trangthaiU = document.getElementById("trangthaiU");
let idU = document.getElementById("idU");

// let maND = document.getElementById("maND");
// let tenU = document.getElementById("tenUU");
// let nsU = document.getElementById("nsU");
// let sdtU = document.getElementById("sdtU");
// let ccU = document.getElementById("ccU");
// let blU = document.getElementById("blU");
// let dcU = document.getElementById("dcU");
// let gtU = document.getElementsByName("gtU");

// let tenn = document.getElementById("ten").value;
// let emaill = document.getElementById("email").value;
// let pass = document.getElementById("pass").value;
// let pass2 = document.getElementById("pass2").value;
// let ngaysinh = document.getElementById("ngaySinh").value;
// let sdt = document.getElementById("sdt").value;
// let cccd = document.getElementById("cccd").value;
// let bangLai = document.getElementById("bangLai").value;

// function checknull() {
//     if (tenn.trim().length === 0 || emaill.trim().length === 0 || pass.trim().length === 0 || pass2.trim().length === 0
//         || ngaysinh.trim().length === 0 || sdt.trim().length === 0 || cccd.trim().length === 0 || bangLai.trim().length === 0) {
//         alert("Vui lòng nhập đầy đủ thông tin")
//     } else {
//         alert("OK")
//     }
// }
