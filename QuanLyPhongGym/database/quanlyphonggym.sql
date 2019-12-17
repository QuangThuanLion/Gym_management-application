
USE MASTER
GO

CREATE DATABASE QuanLyPhongGym
ON(
	Name = 'PhongGym_mdf-mdf',
	FileName = 'D:\Homework-java\QuanLyPhongGym\database\PhongGym_mdf.mdf',
	size =5MB,
	maxsize = 200MB,
	filegrowth = 10%
)
LOG ON(
	Name = 'PhongGym_log',
	FileName = 'D:\Homework-java\QuanLyPhongGym\database\PhongGym_long.ldf',
	size = 5MB,
	maxsize = 200MB,
	filegrowth = 10%
);

USE QuanLyPhongGym
GO


-----------------------------------
--tao table cho bang nhan vien
CREATE TABLE NHANVIEN(
	MaNV varchar (10) not null,
	Hoten varchar (50) not null,
	Ngaysinh date not null,
	Gioitinh bit,
	Sodienthoai int not null,
	Diachi varchar(50) not null,
	Email varchar(30) not null,
	Ngayvaolam date not null,
	TenTK varchar(30) not null,
	Matkhau varchar(30) not null,
	ChucVu varchar(20) not null
	CONSTRAINT pk_manhanvien PRIMARY KEY(MaNV),
	CONSTRAINT fk_chucvu FOREIGN KEY (ChucVu) REFERENCES CHUCVU (ChucVu)
)
ALTER table NHANVIEN
ADD CONSTRAINT unique_sdt UNIQUE (Sodienthoai),
		CONSTRAINT uniqe_email UNIQUE (Email),
		CONSTRAINT unique_tentk UNIQUE (TenTK)

INSERT INTO NHANVIEN (MaNV,Hoten,Ngaysinh,Gioitinh,Sodienthoai,Diachi,Email,Ngayvaolam,TenTK,Matkhau,ChucVu)
VALUES  ('NV01','Admin','1994-12-24',1,0383789311,'Nui Thanh - Da Nang','admina@gmail.com','2019-12-02','admina','abcdef','Admin'),
		('NV02','Nguyễn Thị Hoa','1995-12-10',0,1383789311,'Nui Thanh - Da Nang','adminb@gmail.com','2019-08-20','adminb','abcdef','Le Tan'),
		('NV03','Nguyễn Hoàng','1998-03-05',1,383789312,'Nui Thanh - Quảng Bình','adminc@gmail.com','2018-05-15','adminc','abcdef','PT'),
		('NV04','Lê Thanh Hương','1995-02-14',1,312345689,'Nui Thanh - TP.Hồ Chí Minh','admind@gmail.com','2018-04-12','admind','abcdef','Lao cong')
-----------------------------
--tao table cho bang chuc vu
CREATE TABLE CHUCVU(
	MaChucVu varchar(20) not null,
	ChucVu varchar(20) not null
	CONSTRAINT pk_chucvu PRIMARY KEY(ChucVu)
)

INSERT INTO CHUCVU(MaChucVu,ChucVu)
VALUES	('CV01', 'Admin'),
		('CV02','Le Tan'),
		('CV03','PT'),
		('Cv04','Lao cong')
-----------------------------
--tao table cho bang tinh luong nhan vien
CREATE TABLE LUONGNHANVIEN(
	MaNV varchar (10) not null,
	Hoten varchar (50) not null,
	ChucVu varchar(20) not null,
	Tungay date not null,
	Denngay date not null,
	Ngaycongchuan int not null,
	Tongngaycong int not null,
	Luongcoban float not null,
	LuongChinh float not null,
	Luongphucap float,
	Tonggiotangca float,
	Luongtangca float,
	Tongluong float not null,
	Ghichu nvarchar(200),
	CONSTRAINT fk_manhanvien FOREIGN KEY(MaNV) REFERENCES NHANVIEN (MaNV)
)

INSERT INTO LUONGNHANVIEN (MaNV,Hoten,ChucVu,Tungay,Denngay,Ngaycongchuan,Tongngaycong,Luongcoban,LuongChinh,Luongphucap,Tonggiotangca,Luongtangca,Tongluong,Ghichu)
VALUES	('NV01','Admin','Admin','12-11-2019','12-12-2019',26,20,4000000,4000000,500000,5,100000,4600000,'Khong co van de gi')

-----------------------------------------------------------
--Tao table cho bang goi dang ki
CREATE TABLE GOIDANGKY(
	MaGoiDk varchar(20) not null,
	Tengoi varchar(50) not null,
	Dongia int,
	CONSTRAINT pk_magoidangki PRIMARY KEY (MaGoiDk)
)
INSERT INTO GOIDANGKY(MaGoiDk,Tengoi,Dongia)
VALUES	('MG01','Goi dang ki 1 thang',200000),
		('MG02','Goi dang ki 3 thang',500000),
		('MG03','Goi dang ki 6 thang',1000000),
		('MG04','Goi dang ki 1 nam',1800000)
-----------------------------------------
--tao table cho bang khach hang
CREATE TABLE KHACHHANG(
	MaKH varchar (10) not null,
	Hoten varchar(50) not null,
	Ngaysinh date not null,
	Gioitinh bit,
	Diachi varchar(50),
	Sodienthoai int,
	Email varchar(30),
	MaGoiDk varchar(20) not null,
	NgayDK date not null,
	NgayHetHanDk date not null,
	CONSTRAINT pk_makhachhang PRIMARY KEY (MaKH),
	CONSTRAINT fk_magoidangki FOREIGN KEY (MaGoiDk)	REFERENCES GOIDANGKY (MaGoiDk)
)

INSERT INTO KHACHHANG (MaKH,Hoten,Ngaysinh,Gioitinh,Diachi,Sodienthoai,Email,MaGoiDk,NgayDK,NgayHetHanDk)
VALUES	('KH01','Thuan Nguyen','1994-12-24',1,'Nui Thanh - Da Nang',0383789311,'thuannguyen@gmail.com','MG01','12-11-2019','12-12-2019'),
		('KH02','Hong Hanh','2005-12-24',0,'Nui Thanh - Da Nang',0383789311,'thuannguyen@gmail.com','MG02','12-11-2019','12-12-2019'),
		('KH03','Van Thanh','2000-12-24',1,'Nui Thanh - Da Nang',0383789311,'thuannguyen@gmail.com','MG03','12-11-2019','12-12-2019'),
		('KH04','Quang Hai','1995-12-24',0,'Nui Thanh - Da Nang',0383789311,'thuannguyen@gmail.com','MG04','12-11-2019','12-12-2019'),
		('KH05','Dinh Trong','1996-12-24',1,'Nui Thanh - Da Nang',0383789311,'thuannguyen@gmail.com','MG01','12-11-2019','12-12-2019'),
		('KH06','Trong Hoang','1994-12-24',1,'Nui Thanh - Da Nang',0383789311,'thuannguyen@gmail.com','MG03','12-11-2019','12-12-2019'),
		('KH08','Van Dai','1994-12-24',1,'Nui Thanh - Da Nang',0383789311,'thuannguyen@gmail.com','MG04','12-11-2019','12-12-2019'),
		('KH09','Hung Dung','1993-12-24',0,'Nui Thanh - Da Nang',0383789311,'thuannguyen@gmail.com','MG02','12-11-2019','12-12-2019'),
		('KH010','Cong Phuong','1999-12-24',0,'Nui Thanh - Da Nang',0383789311,'thuannguyen@gmail.com','MG03','12-11-2019','12-12-2019')

---------------------------------------------
--tao table cho bang danh muc san pham
CREATE TABLE DANHMUCSANPHAM(
	MaDM varchar(10) not null,
	TenDM varchar(50) not null,
	CONSTRAINT pk_madanhmuc PRIMARY KEY (MaDM)
)

INSERT INTO DANHMUCSANPHAM (MaDM,TenDM)
VALUES	('DM01','San pham chuc nang - bo sung'),
		('DM02','San pham nuoc uong - giai khat'),
		('DM03','San pham bao ve ca nhan')
----------------------
--tao table cho bang chi tiet ten san pham
CREATE TABLE TENSANPHAM(
	MaTenSP varchar(10) not null,
	MaDM varchar(10) not null,
	TenSP varchar(30) not null,
	CONSTRAINT pk_tensanpham PRIMARY KEY (TenSP),
	CONSTRAINT fk_madanhmuc FOREIGN KEY(MaDM) REFERENCES DANHMUCSANPHAM (MaDM)
)

INSERT INTO TENSANPHAM(MaTenSP,MaDM,TenSP)
VALUES	('TSP01','DM01','Whey protein'),
		('TSP02','DM01','ISO HD'),
		('TSP03','DM01','HYDRO Whey'),
		('TSP04','DM01','PRE WROKOUT'),
		('TSP05','DM02','Nuoc khoang'),
		('TSP06','DM02','Nuoc revive'),
		('TSP07','DM02','Nuoc tang luc'),
		('TSP08','DM02','Nuoc sting'),
		('TSP09','DM02','Nuoc dien giai'),
		('TSP10','DM03','gang tay'),
		('TSP11','DM03','bang dau goi'),
		('TSP12','DM03','bot phan'),
		('TSP13','DM03','vong bang co tay')
----------------------------------
--tao table cho bang nha phan phoi - san pham
CREATE TABLE NHAPHANPHOISANPHAM(
	MaNhaPPSS varchar(10) not null,
	MaDM varchar(10) not null,
	TenNhaPPSS varchar(50) not null,
	DiachiPPSS varchar(50) not null,
	CONSTRAINT pk_nhaphanphoisanpham PRIMARY KEY (MaNhaPPSS),
	CONSTRAINT fk_madanhmucNPP FOREIGN KEY(MaDM) REFERENCES DANHMUCSANPHAM (MaDM) 
)

INSERT INTO NHAPHANPHOISANPHAM(MaNhaPPSS,MaDM,TenNhaPPSS,DiachiPPSS)
VALUES	('NPPSS01','DM02','Cong ty TNHH SUNTORY PEPSICO Viet Nam','Hai Ba Trung - Ha Noi'),
		('NPPSS02','DM02','Cong ty TNHH Lavie','Ton Duc Thang - Da Nang'),
		('NPPSS03','DM03','Nha PP SPORT FOOD','Truong Chinh - Thanh Pho Ho Chi Minh'),
		('NPPSS04','DM01','Nha PP BBT Whey Shop','Tu Lien - Ha Noi'),
		('NPPSS05','DM01','Cua hang vat tu the hinh Da Nang','Truong Chinh - Da Nang'),
		('NPPSS06','DM03','Cua hang Si le do bao ho Lieu Chieu - Da Nang','Nguyen Van Linh - Ha Noi')

-------------------------
--tao table cho bang quan ly san pham chi tiet

CREATE TABLE SANPHAM(
	MaSP varchar(10) not null,
	MaDM varchar(10) not null,
	TenSP varchar(30) not null,
	SoLuong int,
	Dongia float not null,
	MaNhaPPSS varchar(10) not null,
	Thoigiannhan date not null,
	Ghichu varchar(200),
	Tonggia float,
	CONSTRAINT pk_masanpham PRIMARY KEY (MaSP),
	CONSTRAINT fk_maloaisanpham FOREIGN KEY (MaDM) REFERENCES DANHMUCSANPHAM(MaDM),
	CONSTRAINT fk_tensanpham FOREIGN KEY (TenSP) REFERENCES TENSANPHAM(TenSP),
	CONSTRAINT fk_nhaphanphoi FOREIGN KEY (MaNhaPPSS) REFERENCES NHAPHANPHOISANPHAM(MaNhaPPSS),
)

INSERT INTO SANPHAM(MaSP,MaDM,TenSP,SoLuong,Dongia,MaNhaPPSS,Thoigiannhan,Ghichu,Tonggia)
VALUES	('SP01','DM01','Whey protein',10,100000,'NPPSS01','2019-11-10','Khong co van de',1000000),
		('SP02','DM02','Nuoc khoang',10,100000,'NPPSS01','2019-11-10','Khong co van de',1000000),
		('SP03','DM03','bang dau goi',10,100000,'NPPSS01','2019-11-10','Khong co van de',1000000),
		('SP04','DM03','bot phan',10,100000,'NPPSS01','2019-11-10','Khong co van de',1000000),

----------------------------------
--tao table cho bang san pham con lai

CREATE TABLE SANPHAMCONLAI(
	
	MaSP varchar(10) not null,
	MaDM varchar(10) not null,
	TenSP varchar(30) not null,
	SoLuong int,
	Dongia float not null,
	MaNhaPPSS varchar(10) not null,
	Thoigiannhan date not null,
	Ghichu varchar(200),
	Tonggia float,

	CONSTRAINT fk_maspcl FOREIGN KEY (MaSP) REFERENCES SANPHAM(MaSP)
)
INSERT INTO SANPHAMCONLAI(MaSP,MaDM,TenSP,SoLuong,Dongia,MaNhaPPSS,Thoigiannhan,Ghichu,Tonggia)
VALUES	('SP01','DM01','Whey protein',10,100000,'NPPSS01','2019-11-10','Khong co van de',1000000),
		('SP02','DM02','Whey protein',10,100000,'NPPSS01','2019-11-10','Khong co van de',1000000),
		('SP03','DM03','bang dau goi',10,100000,'NPPSS01','2019-11-10','Khong co van de',1000000),
		('SP04','DM03','bot phan',10,100000,'NPPSS01','2019-11-10','Khong co van de',1000000)

-----------------------------------
--tao table cho bang ban san pham

CREATE TABLE BANSANPHAM(	
	
	MaSP varchar(10) not null,
	MaDM varchar(10) not null,
	TenSP varchar(30) not null,
	MaNhaPPSS varchar(10) not null,
	Dongia float not null,
	MaHD varchar(10) not null,
	Soluong int,	
	Giaban float not null,
	TongGia float not null,
	Ngayban date not null,
	TinhTrang varchar(20) not null

	CONSTRAINT pk_maHD PRIMARY KEY (MaHD),
	CONSTRAINT fk_masp FOREIGN KEY(MaSP) REFERENCES SANPHAM (MaSP),
	CONSTRAINT fk_maDM FOREIGN KEY(MaDM) REFERENCES DANHMUCSANPHAM (MaDM),
	CONSTRAINT fk_NPP FOREIGN KEY(MaNhaPPSS) REFERENCES NHAPHANPHOISANPHAM (MaNhaPPSS)
)

INSERT INTO BANSANPHAM(MaSP,MaDM,TenSP,MaNhaPPSS,Dongia,MaHD,Soluong,Giaban,TongGia,Ngayban,TinhTrang)
VALUES  ('SP01','DM01','Whey protein','NPPSS01',100000,'HD01',10,110000,999999,'2019-12-10','Da thanh toan'),
		('SP02','DM01','Whey protein','NPPSS01',100000,'HD02',10,110000,999999,'2019-12-10','Da thanh toan')

-----------------------------------

--tao table cho bang danh muc thiet bi

CREATE TABLE DANHMUCTHIETBI(
	MaDMTB varchar(10) not null,
	TenDMTH varchar(50) not null
	CONSTRAINT pk_loaithietbi PRIMARY KEY(MaDMTB)
)

INSERT INTO DANHMUCTHIETBI(MaDMTB,TenDMTH)
VALUES	('TB01','Thiet bi tap tay'),
		('TB02','Thiet bi tap nguc'),
		('TB03','Thiet bi tap chan'),
		('TB04','Thiet bi tap bung')
--------------------------
--tao table cho bang nha phan phoi - thiet bi

CREATE TABLE NHAPHANPHOITHIETBI(
	MaNhaPPTB varchar(10) not null,
	TenNhaPPTB varchar(50) not null,
	DiachiPPTB varchar(50) not null,
	CONSTRAINT pk_nhaphanphoithietbi PRIMARY KEY (MaNhaPPTB)
)
INSERT INTO NHAPHANPHOITHIETBI(MaNhaPPTB,TenNhaPPTB,DiachiPPTB)
VALUES	('NPPTB01','Cong ty thiet bi vat tu phong Gym 365','Ngo Quyen - Da Nang'),
		('NPPTB02','Cong ty thiet bi sport whey TKT','30 Le Huu Trac - Thanh Pho Ho Chi Minh'),
		('NPPTB03','Tong dai ly phan phoi IMPUSLE tai Viet Nam','Le Duan - Ha Noi'),
		('NPPTB04','He thong phan phoi thiet bi Gym NK - SPORT','Tu Lien - Ha Noi')

-----------------------------------
--Tao bang table quan ly thiet bi tap
CREATE TABLE THIETBITAP(
	Mathietbi varchar(10) not null,
	MaDMTB varchar(10) not null,
	Tenthietbi varchar(50) not null,
	Soluong int,
	Dongia int,
	Tonggia int, 
	Tinhtrang varchar(20) not null,
	MaNhaPPTB varchar(10) not null,
	Mota varchar(200),
	CONSTRAINT pk_mathietbi PRIMARY KEY (Mathietbi),
	CONSTRAINT fk_maloaithietbi FOREIGN KEY(MaDMTB) REFERENCES DANHMUCTHIETBI (MaDMTB),
	CONSTRAINT fk_manhaphanphoithietbi FOREIGN KEY (MaNhaPPTB) REFERENCES NHAPHANPHOITHIETBI (MaNhaPPTB)
)

INSERT INTO THIETBITAP(Mathietbi,MaDMTB,Tenthietbi,Soluong,Dongia,Tonggia,Tinhtrang,MaNhaPPTB,Mota)
VALUES	('TB01','TB01','Thanh day ta don ngang',10,100000,20000,'Tot','NPPTB01','Khong co van de gi'),
		('TB02','TB02','Thanh cuon doc',10,100000,500000,'Bi Loi','NPPTB01','Khong co van de gi'),
		('TB03','TB03','Thanh day ta don',10,100000,60000,'Tot','NPPTB01','Khong co van de gi'),
		('TB04','TB04','May chay bo',10,100000,700000,'Bi Loi','NPPTB01','Khong co van de gi')

----------------------------------------------
--Tạo bảng công nợ khách hàng

CREATE TABLE CONGNOKHACHHANG(
	
	MaKH varchar (10) not null,
	Hoten varchar(50) not null,
	MaSP varchar(10) not null,
	Sotienno int not null,
	Ghichu nvarchar(200)

	CONSTRAINT fk_makhcongno FOREIGN KEY(MaKH) REFERENCES KHACHHANG (MaKH),
	CONSTRAINT fk_masanphamcongno FOREIGN KEY(MaSP) REFERENCES SANPHAM (MaSP),
)

INSERT INTO CONGNOKHACHHANG(MaKH,Hoten,MaSP,Sotienno,Ghichu)
VALUES	('KH01','Thuan Nguyen','SP01',20000,'Khong co van de gi')


------VIEW HIEN THI BANG KHACH HANG-----------

CREATE VIEW View_DangKiKhachHang
as
select KHACHHANG.MaKH, KHACHHANG.Hoten,KHACHHANG.Ngaysinh, KHACHHANG.Gioitinh,
GOIDANGKY.MaGoiDk,GOIDANGKY.Tengoi, KHACHHANG.NgayDK, KHACHHANG.NgayHetHanDk, KHACHHANG.Sodienthoai,KHACHHANG.Diachi,KHACHHANG.Email
from KHACHHANG, GOIDANGKY
where KHACHHANG.MaGoiDk = GOIDANGKY.MaGoiDk

select MaKH,Hoten,Ngaysinh,Gioitinh,Tengoi from View_DangKiKhachHang where Hoten like '%thuan%'

------VIEW HIENTHI THONG TIN SAN PHAM---------

CREATE VIEW View_SanPham
as
select SANPHAM.MaSP,DANHMUCSANPHAM.MaDM,DANHMUCSANPHAM.TenDM,
TENSANPHAM.TenSP,NHAPHANPHOISANPHAM.MaNhaPPSS,
NHAPHANPHOISANPHAM.TenNhaPPSS,SANPHAM.SoLuong,SANPHAM.Dongia,
SANPHAM.Thoigiannhan,SANPHAM.Tonggia,SANPHAM.Ghichu
from SANPHAM,DANHMUCSANPHAM,TENSANPHAM,NHAPHANPHOISANPHAM
where SANPHAM.MaDM = DANHMUCSANPHAM.MaDM AND
SANPHAM.TenSP = TENSANPHAM.TenSP AND
SANPHAM.MaNhaPPSS = NHAPHANPHOISANPHAM.MaNhaPPSS

--------VIEW HIEN THI THONG TIN THIET BI-----

CREATE VIEW View_ThietBi
as
select THIETBITAP.Mathietbi, DANHMUCTHIETBI.MaDMTB,DANHMUCTHIETBI.TenDMTH,
THIETBITAP.Tenthietbi, THIETBITAP.Soluong, THIETBITAP.Dongia,THIETBITAP.Tonggia,
THIETBITAP.Tinhtrang,NHAPHANPHOITHIETBI.MaNhaPPTB,NHAPHANPHOITHIETBI.TenNhaPPTB,THIETBITAP.Mota
from THIETBITAP,DANHMUCTHIETBI,NHAPHANPHOITHIETBI
where THIETBITAP.MaDMTB = DANHMUCTHIETBI.MaDMTB
AND THIETBITAP.MaNhaPPTB = NHAPHANPHOITHIETBI.MaNhaPPTB


------VIEW HIEN THI TRANG DOANH THU SAN PHAM-----

CREATE VIEW View_DoanhThuSanPham
as
select	BANSANPHAM.MaHD,BANSANPHAM.MaSP, BANSANPHAM.MaDM, DANHMUCSANPHAM.TenDM, BANSANPHAM.TenSP,
SANPHAM.Dongia,BANSANPHAM.Soluong, BANSANPHAM.Giaban, BANSANPHAM.TongGia,BANSANPHAM.Ngayban,
BANSANPHAM.TinhTrang,NHAPHANPHOISANPHAM.MaNhaPPSS,NHAPHANPHOISANPHAM.TenNhaPPSS
from BANSANPHAM,SANPHAM,DANHMUCSANPHAM, NHAPHANPHOISANPHAM
where	BANSANPHAM.MaDM = DANHMUCSANPHAM.MaDM
AND		BANSANPHAM.MaSP = SANPHAM.MaSP
AND		BANSANPHAM.MaNhaPPSS = NHAPHANPHOISANPHAM.MaNhaPPSS

-----VIEW DOANH THU TU KHACH HANG-------

CREATE VIEW View_DoanhThuKhachHang
as 
select KHACHHANG.Hoten, KHACHHANG.MaGoiDk, GOIDANGKY.Tengoi, GOIDANGKY.Dongia, KHACHHANG.NgayDK, KHACHHANG.NgayHetHanDk
from KHACHHANG,GOIDANGKY
where KHACHHANG.MaGoiDk = GOIDANGKY.MaGoiDk

------VIEW CONG NO KHACH HANG------

CREATE VIEW View_CongNoKhachHang
as
select CONGNOKHACHHANG.MaKH, CONGNOKHACHHANG.Hoten, CONGNOKHACHHANG.MaSP,
SANPHAM.TenSP,CONGNOKHACHHANG.Sotienno, CONGNOKHACHHANG.Ghichu
from CONGNOKHACHHANG, SANPHAM
where CONGNOKHACHHANG.MaSP = SANPHAM.MaSP

----------------------------------


WHERE NgayDK BETWEEN CAST('2019-12-11' AS DATE) AND CAST('2019-12-11' AS DATE)

	SET XACT_ABORT ON
	BEGIN TRAN
	BEGIN TRY
			--cau lennh 1
			--cau lenh 2
			--cau lenh 3
	COMMIT
	END TRY
	BEGIN CATCH
	   ROLLBACK
	   DECLARE @ErrorMessage VARCHAR(2000)
	   SELECT @ErrorMessage = 'Lỗi: ' + ERROR_MESSAGE()
	   RAISERROR(@ErrorMessage, 16, 1)
	END CATCH

