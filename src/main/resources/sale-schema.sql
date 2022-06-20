-- Delete tx_sale table if exist
DROP TABLE IF EXISTS tx_sale;

-- Create tx_sale table
CREATE TABLE tx_sale (
	id VARCHAR(10) PRIMARY KEY NOT NULL,
	product_id INT4 NOT NULL,
	quantity INT4 NOT NULL,
    price NUMERIC(10,2),
    total_price NUMERIC(12,2),
	created_date TIMESTAMP NOT NULL
)
WITH (
	OIDS=FALSE
) ;

-- Query All data in tx_sale table
SELECT * FROM tx_sale;

