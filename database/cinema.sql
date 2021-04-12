drop schema if exists cinema;
create schema if not exists cinema default character set UTF8MB4;
use cinema;

DROP TABLE IF EXISTS PHIM;
CREATE TABLE Phim( 
ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
TEN_PHIM VARCHAR(60) NOT NULL, 
THOI_LUONG INT,
THE_LOAI VARCHAR(50) NOT NULL,
DAO_DIEN VARCHAR(50) NOT NULL, 
NGAY date);

-- insert into PHIM(TEN_PHIM, THOI_LUONG, THE_LOAI, DAO_DIEN, NGAY) values
-- ('Bố Già', 128, 'Gia đình, Hài' ,'Vũ Ngọc Đãng & Trấn Thành', date('2021-03-12')),
-- ('SONG SONG', 105, 'Bí ẩn, Hồi hộp, Tâm Lý','Nguyễn Hữu Hoàng',date('2021-04-03'));

DROP TABLE IF EXISTS TKNHANVIEN;
CREATE TABLE TKNHANVIEN( 
EMAIL VARCHAR(60) NOT NULL, 
PASS VARCHAR(20) NOT NULL,
ID_NHANVIEN int,
PRIMARY KEY (EMAIL));

-- insert into TKNHANVIEN(EMAIL, PASS) values
-- ('admin', 123),
-- ('kien233@gmail.com', 123),
-- ('hung4561@gmail.com', 123),
-- ('nguyenthuytien213@gmail.com', 123);

DROP TABLE IF EXISTS NHAN_VIEN;
CREATE TABLE NHAN_VIEN ( 
ID INT NOT NULL AUTO_INCREMENT,
HOTEN VARCHAR(64), 
EMAIL VARCHAR(64),
ADDRESS VARCHAR(64),
Phone int,
DateofBirth date,
CHUC_VU VARCHAR(20),
PRIMARY KEY (ID),
foreign key (EMAIL) references TKNHANVIEN(EMAIL));

-- insert into NHAN_VIEN(HOTEN, EMAIL, CHUC_VU) values
-- ('Trần thị thủy', 'nguyethuy@gmail.com','quản lí'),
-- ('Nguyễn Minh Chiến', 'chienvt@gmail.com','nhân viên'),
-- ('Trần thanh hoàng', 'hoangct@gmail.com','nhân viên');





