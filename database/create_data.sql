Insert INTO account(user_name, password)
VALUES ('hovanhoai', '123'),
	   ('thaitangluc', '123'),
       ('nguyenmanhviet', '123'),
       ('tranvantri', '123'),
       ('nguyenanhvu', '123');

INSERT INTO customer(account_id, email, customer_name, citizen_id, birthday, nationality, phone_number)
VALUES (1, 'hovanhoai@gmail', 'ho van hoai', '123123123123', '2022-12-12', 'Viet Nam', '123123123'),
	   (2, 'thaitangluc@gmail', 'thai tang luc', '123123123123', '2022-12-12', 'Viet Nam', '123123123'),
       (3, 'nguyenmanhviet@gmail', 'nguyen manh viet', '123123123123', '2022-12-12', 'Viet Nam', '123123123'),
       (4, 'tranvantri@gmail', 'tran van tri', '123123123123', '2022-12-12', 'Viet Nam', '123123123'),
       (5, 'nguyenanhvu@gmail', 'nguyen anh vu', '123123123123', '2022-12-12', 'Viet Nam', '123123123');

Insert INTO property_type(property_type_name, image)
VALUES ('Nha nghi', 'https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2019/05/8-3.jpg'),
	   ('Phong hop', 'https://www.deco-crystal.com/wp-content/uploads/2021/11/thiet-ke-noi-that-phong-hop.jpg'),
	   ('Khach san', 'https://kenhhomestay.com/wp-content/uploads/2018/06/khach-san-sai-gon-15.jpg');


INSERT INTO property(customer_id, property_type_id, property_name,
					 address, city, create_date, room_quantity, description, rating, lat, lon, image)
VALUES (1, 1, 'Tommaso da Cazzaniga - Milano', '775 Ton Duc Thang, Lien Chieu', 'Da Nang', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://wolverineair.com/wp-content/uploads/2020/05/nha-nghi-da-nang-avt.jpg'),
	   (2, 1, 'Tommaso da Cazzaniga - Milano', '775 Ton Duc Thang, Lien Chieu', 'Quang Tri', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://images.foody.vn/res/g14/134072/prof/s576x330/foody-mobile-c2-jpg-560-636113515152627801.jpg'),
        (3, 1, 'Tommaso da Cazzaniga - Milano', '775 Ton Duc Thang, Lien Chieu', 'Quang Tri', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://images.foody.vn/res/g11/108834/prof/s576x330/foody-mobile-m-sao-dem-m-jpg-309-635572639534201402.jpg'),
        (4, 1, 'Tommaso da Cazzaniga - Milano', '775 Ton Duc Thang, Lien Chieu', 'Hue', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://images.foody.vn/res/g28/279570/prof/s576x330/foody-mobile-710-jpg-726-636105094361238469.jpg'),
        (5, 1, 'Tommaso da Cazzaniga - Milano', '775 Ton Duc Thang, Lien Chieu', 'Quang Binh', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://vntraveller.com/wp-content/uploads/2019/05/10-nha-nghi-thai-nguyen-1.jpg'),
        (1, 1, 'Tommaso da Cazzaniga - Milano', '775 Ton Duc Thang, Lien Chieu', 'Ha Noi', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://vntraveller.com/wp-content/uploads/2020/04/khach-s%E1%BA%A1n-quan-3-46.jpg'),
        (3, 1, 'Tommaso da Cazzaniga - Milano', '775 Ton Duc Thang, Lien Chieu', 'Ho Chi Minh', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://vntraveller.com/wp-content/uploads/2020/04/khach-s%E1%BA%A1n-quan-3-19.jpg'),
        (5, 1, 'Tommaso da Cazzaniga - Milano', '775 Ton Duc Thang, Lien Chieu', 'Da Nang', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://i.vntrip.vn/800x550/smart/https://statics.vntrip.vn/data-v2/hotels/15115/img_max/15115_1531190686_2018-01-30-17-01-10-vip-double.jpg'),
        (4, 1, 'Tommaso da Cazzaniga - Milano', '775 Ton Duc Thang, Lien Chieu', 'Da Nang', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://cdn2.vietnambooking.com/wp-content/uploads/hotel_pro/hotel_345596/5320fad52aeb9253d66574346b06b7b8.jpg'),
	   (1, 1, 'Tommaso da Cazzaniga - Milano', '775 Ton Duc Thang, Lien Chieu', 'Hue', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://q-xx.bstatic.com/xdata/images/hotel/max500/275061465.jpg?k=30f5bf79bacbfa16479602e3603e276363ddd506adb7442219a546bc277dd3eb&o='),
	   (5, 2, 'Quadrilocale Deluxe - Torre Galfa Milano', '124 Nguyen Van Linh, Thanh Khe', 'Quang Tri', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		4, 15.12512, 115.12121, 'https://phonghoinghi.com/wp-content/uploads/2019/04/lua-chon-noi-that-phong-hop-toi-uu.jpg'),
	   (2, 2, 'Splendido Appartamento nel cuore di Roma', '775 Ton Duc Thang, Lien Chieu', 'Quang Binh', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://www.deco-crystal.com/wp-content/uploads/2021/11/thiet-ke-noi-that-phong-hop.jpg'),
	   (3, 2, 'Appartamento via di Porta Tenaglia, Milano', '775 Ton Duc Thang, Lien Chieu', 'Ho Chi Minh', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://cdcvietnamgroup.vn/wp-content/uploads/2020/09/11.jpg'),
	   (4, 2, 'VIA TORINO LOFT', '775 Ton Duc Thang, Lien Chieu', 'Da Nang', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtvM4GZkFbh_F1L3ZCyLz-3faOOMILXS_BKQ&usqp=CAU'),
	   (1, 2, 'Bilocale Superior - Torre Galfa Milano Luxury Apartments', '775 Ton Duc Thang, Lien Chieu', 'Ho Chi Minh', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://noithatcnc.com/wp-content/uploads/2020/03/ban-hop-21-4-1200x799.jpg'),
	   (5, 2, 'Trilocale - Porta genova', '775 Ton Duc Thang, Lien Chieu', 'Hue', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://noithathoaphatsomot.com.vn/uploads/images/bai-viet/6736510679-d692e9177f-z.jpg'),
	   (2, 2, 'Piazza Duomo - Pattari Attico', '775 Ton Duc Thang, Lien Chieu', 'Da Nang', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://noithatcnc.com/wp-content/uploads/2020/03/ban-hop-21-4-1200x799.jpg'),
	   (3, 2, 'Trilocale Deluxe - Torre Galfa Milano Luxury Apartments', '775 Ton Duc Thang, Lien Chieu', 'Ha Noi', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://noithathoaphat.info.vn/wp-content/uploads/2019/07/phong-hop-chu-u-01.jpg'),
	   (3, 2, 'Appartamento in Affitto in zona Centrale', '775 Ton Duc Thang, Lien Chieu', 'Ho Chi Minh', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://noithatduckhang.com.vn/img/uploads/phong-hop-1-view-1.jpg'),
       (4, 2, 'CIMATORI 10', '775 Ton Duc Thang, Lien Chieu', 'Quang Tri', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://aruna.com.vn/wp-content/uploads/2020/09/phong-hop-Aruna-Offices-1-Licogi-13.jpg'),
	   (3, 2, 'UR NEST Novelli', '775 Ton Duc Thang, Lien Chieu', 'Da Nang', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://zodiac.com.vn/wp-content/uploads/2021/04/T5-Phong-hop-truc-tuyen-.png'),
        (4, 3, 'CIMATORI 10', '775 Ton Duc Thang, Lien Chieu', 'Ho Chi Minh', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://www.vietnambooking.com/wp-content/uploads/2020/01/khach-san-2-sao-la-gi-7-1-2019-e1578366200494.jpg'),
        (5, 3, 'CIMATORI 10', '775 Ton Duc Thang, Lien Chieu', 'Da Nang', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://cafefcdn.com/thumb_w/650/2020/6/5/phc3b2ng-nge1bba7-khc3a1ch-se1baa1n-suite2027-1507935855634-15912903114211366661120-crop-1591290317518639862958.jpg'),
        (1, 3, 'CIMATORI 10', '775 Ton Duc Thang, Lien Chieu', 'Ha Noi', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://www.hoteljob.vn/uploads/images/18-01-02-12/Phongkhachs%E1%BA%A1ndatnhatthegioi2.jpg'),
        (4, 3, 'CIMATORI 10', '775 Ton Duc Thang, Lien Chieu', 'Hue', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://media.travelmag.vn/center/960x576/files/news/2021/05/11/hang-loat-combo-nghi-duong-voucher-khach-san-cao-cap-thanh-ly-gia-re-van-e-am-170430.jpg'),
        (2, 3, 'CIMATORI 10', '775 Ton Duc Thang, Lien Chieu', 'Ha Noi', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://vesnahotel.com/uploads/1/dsc05136-edit.jpg'),
        (3, 3, 'CIMATORI 10', '775 Ton Duc Thang, Lien Chieu', 'Da Nang', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://beehotel.vn/wp-content/uploads/2020/06/tieu-chuan-khach-san-5-sao-2.jpg'),
        (1, 3, 'CIMATORI 10', '775 Ton Duc Thang, Lien Chieu', 'Quang Tri', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://beehotel.vn/wp-content/uploads/2020/06/tieu-chuan-khach-san-5-sao-7.jpg'),
        (5, 3, 'CIMATORI 10', '775 Ton Duc Thang, Lien Chieu', 'Hue', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://cafefcdn.com/2019/2/25/photo-1-15510852999281162067324.jpg'),
        (2, 3, 'CIMATORI 10', '775 Ton Duc Thang, Lien Chieu', 'Ha Noi', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://media.vneconomy.vn/images/upload/2021/04/21/presidentbedroom2-15510687199461893035392.jpg'),
        (4, 3, 'CIMATORI 10', '775 Ton Duc Thang, Lien Chieu', 'Hue', '2202-12-12', 10, 'Dep - Sach - Thoang mat',
		5, 12.12512, 106.12121, 'https://media.vov.vn/uploaded/cizotokek8ly8uzveukg/2016_05_21/4_mpfe.jpg');

INSERT INTO price(hour_price, day_price, week_price, month_price)
VALUES (123.12412, 123123.123123, 123.12312, 12312.12312),
	   (1326.12412, 2323.123123, 216.12312, 347.12312),
       (458.12412, 3833.123123, 34573.12312, 34734.12312);

INSERT INTO reservation_status(reservation_status_name)
VALUES ('ACTIVED'),
	   ('INACTIVED');

INSERT INTO room_status(room_status_name)
VALUES ('ACTIVED'),
	   ('INACTIVED');

INSERT INTO room(property_id, price_id, room_status_id, room_name, size, capacity, image, description)
VALUES (3, 2, 1, 'Hello', 'size test', 'Capacity', 'https://www.hoteljob.vn/uploads/images/18-01-02-12/Phongkhachs%E1%BA%A1ndatnhatthegioi2.jpg', 'description'),
	   (3, 2, 1, 'Hello', 'size test', 'Capacity', 'https://media.vov.vn/uploaded/cizotokek8ly8uzveukg/2016_05_21/4_mpfe.jpg', 'description');

INSERT INTO reservation(room_id, customer_id, reservation_status_id, create_date, start_date, end_date, quantity, total, deposit)
VALUES (1, 1, 1, '2022-12-12', '2022-12-12', '2022-12-12', 10, 12.1241, 12.123),
	   (2, 2, 2, '2022-12-12', '2022-12-12', '2022-12-12', 10, 12.1241, 12.123);

INSERT INTO review(customer_id, property_id, rating, content, create_date)
VALUES (1, 1, 3.5, 'ks vip v??? l???', '2022-04-22'),
       (2, 1, 1.5, 'ks nhu cec', '2022-04-22');