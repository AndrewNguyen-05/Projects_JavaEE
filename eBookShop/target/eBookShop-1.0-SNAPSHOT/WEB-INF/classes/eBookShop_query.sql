-- Tạo cơ sở dữ liệu nếu chưa tồn tại
CREATE DATABASE IF NOT EXISTS ebookshop;

-- Sử dụng cơ sở dữ liệu
USE ebookshop;

-- Xóa bảng books nếu đã tồn tại
DROP TABLE IF EXISTS books;

-- Tạo bảng books
CREATE TABLE books (
    id INT NOT NULL, -- Khóa chính không thể NULL
    title VARCHAR(50), -- Tiêu đề sách
    author VARCHAR(50), -- Tên tác giả
    price FLOAT, -- Giá sách
    qty INT, -- Số lượng sách
    PRIMARY KEY (id) -- Khóa chính là cột id
);

-- Thêm dữ liệu vào bảng books
INSERT INTO books (id, title, author, price, qty) VALUES 
(1001, 'Java for dummies', 'Tan Ah Teck', 11.11, 11),
(1002, 'More Java for dummies', 'Tan Ah Teck', 22.22, 22),
(1003, 'More Java for more dummies', 'Mohammad Ali', 33.33, 33),
(1004, 'A Cup of Java', 'Kumar', 44.44, 44),
(1005, 'A Teaspoon of Java', 'Kevin Jones', 55.55, 55);
