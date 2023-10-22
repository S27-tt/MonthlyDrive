DROP TABLE IF EXISTS record;

CREATE TABLE IF NOT EXISTS record (
    id varchar(255) NOT NULL,
    date varchar(20) NULL,
    start_time varchar(40) NULL,  
    end_time varchar(40) NULL, 
    correct_st varchar(40) NULL,
    correct_et varchar(40) NULL,
    time_lag varchar(40) NULL,
    car varchar(20) NULL,
    driver varchar(20) NULL,
    purpose varchar(20) NULL,
    destination varchar(20) NULL,
    start_meter varchar(20) NULL,
    end_meter varchar(20) NULL,
    meter_diff varchar(20) NULL,
    privatefee varchar(20) NULL,
    deleted bool NOT NULL,
    created_date timestamp NULL,
    updated_date timestamp NULL,
    PRIMARY KEY (id)
);
