create table menu_item (id NUMBER, 
item_name varchar2(100), 
item_price number,
is_active varchar2(3),
CONSTRAINT menu_item_pk primary key (id));

create table staff(id number,
first_name varchar2(100),
last_name varchar2(100),
mobile varchar2(100),
email varchar2(100),
role varchar2(100),
constraint staff_id_pk primary key (id));

create table customer(id number,
mobile varchar2(15),
emain varchar2(100),
first_name varchar2(100),
last_name varchar2(100),
dob date,
constraint customer_id_pk primary key (id));

create table order_header (id number,
name varchar2(100),
created_date date,
completed_date date,
staff_id number,
constraint order_id_pk primary key (id),
constraint staff_id_fk FOREIGN key (staff_id) REFERENCES staff(id));

create table order_detail (id number,
order_id number,
item_id number,
qty number,
status varchar2(10),
created_date date,
comments varchar2(100),
CONSTRAINT order_det_id_pk primary key (id),
constraint order_id_fk FOREIGN key (order_id) REFERENCES order_header(id),
constraint order_menu_item_fk FOREIGN key (item_id) REFERENCES menu_item(id));

create table cost_type(id number,
cost_type varchar2(50),
cost_type_name varchar2(50),
description varchar2(512),
constraint cost_type_pk primary key (id));

create table invoice(id number,
order_id number,
customer_id number,
created_date date,
payment_date date,
mode_of_payment varchar2(50),
constraint invoice_id_pk primary key (id),
constraint invocie_order_id_fk FOREIGN key (order_id) references order_header(id),
CONSTRAINT invoice_cust_id_fk FOREIGN key (customer_id) references customer(id));

create table invoice_breakup(id number,
invoice_id number,  
cost_id number,
cost_value varchar2(50),
constraint invoice_id_fk foreign key (invoice_id) references invoice(id),
constraint invoice_cost_type_fk FOREIGN key(cost_id) references cost_type(id));