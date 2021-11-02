create table coupon
(
    id       serial PRIMARY KEY,
    code     varchar(20),
    discount decimal(8, 3),
    exp_date varchar(100)
)