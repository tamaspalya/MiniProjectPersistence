use WesternStyle

create table Supplier
	(
		id int identity (1, 1) not null,
		name nvarchar(50) not null,
		address nvarchar(100) not null,
		country varchar(50) not null,
		phone_no varchar(25) not null,
		email varchar(50) not null,

		constraint pk_supplier primary key (id)
	)

create table Product
	(
		id int identity (1, 1) not null,
		name nvarchar(50) not null,
		purchase_price money not null,
		sales_price money not null,
		rent_price money not null,
		country_of_origin varchar(50) not null,
		minimum_stock int not null,
		stock int not null,
		supplier_id int not null,

		constraint pk_product primary key (id),
		constraint fk_product_supplier foreign key (supplier_id) references Supplier(id)
	)

create table Invoice
	(
		invoice_number int identity (1, 1) not null,
		payment_date datetime not null,
		amount money not null,

		constraint pk_invoice primary key (invoice_number)
	)

create table SaleOrder
	(
		id int identity (1, 1) not null,
		date datetime not null,
		amount money not null,
		delivery_status varchar(25) not null,
		delivery_date datetime not null,
		invoice_number int not null,

		constraint pk_sale_order primary key (id),
		constraint fk_sale_order_invoice foreign key (invoice_number) references Invoice(invoice_number)
	)

create table ProductSaleOrder
	(
		product_id int not null,
		sale_order_id int not null,
		amount int not null,

		constraint pk_product_sale_order primary key (product_id, sale_order_id),
		constraint fk_product_sale_order_product foreign key (product_id) references Product(id),
		constraint fk_product_sale_order_sale_order foreign key (sale_order_id) references SaleOrder(id)
	)

create table Customer
	(
		id int identity (1, 1) not null,
		first_name nvarchar(25) not null,
		last_name nvarchar(25) not null,
		address nvarchar(100) not null,
		zipcode varchar(25) not null,
		city nvarchar(50) not null,
		phone_no varchar(25) not null,

		constraint pk_customer primary key (id)
	)