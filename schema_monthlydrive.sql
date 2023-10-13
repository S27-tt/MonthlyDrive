DROP TABLE IF EXISTS record;

CREATE TABLE IF NOT EXISTS record (
    id varchar(255) NOT NULL,
    date varchar(20) NULL,
    time varchar(40) NULL,  
    time_2 varchar(40) NULL, 
    time_3 varchar(40) NULL,
    time_4 varchar(40) NULL,
    car varchar(20) NULL,
    driver varchar(20) NULL,
    purpose varchar(20) NULL,
    destination varchar(20) NULL,
    meter varchar(20) NULL,
    meter_2 varchar(20) NULL,
    meter_3 varchar(20) NULL,
    privatefee varchar(20) NULL,
    deleted bool NOT NULL,
    created_date timestamp NULL,
    updated_date timestamp NULL,
    PRIMARY KEY (id)
);
