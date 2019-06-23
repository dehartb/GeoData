LOAD DATA INFILE "/Users/brandondehart/MySqlData/blsdata/ap.data.0.current.csv"
INTO TABLE bls.tblCurrentData
COLUMNS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"'
ESCAPED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;



SHOW VARIABLES LIKE "secure_file_priv";

SHOW VARIABLES LIKE 'secure%';

SELECT @@secure_file_priv;

SELECT @@GLOBAL.secure_file_priv;

SHOW VARIABLES WHERE 'variable_name' = 'base_dir';

TRUNCATE TABLE bls.tblArea WHERE AreaCode LIKE '%'