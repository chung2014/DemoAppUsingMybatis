
### SQL

```roomsql
CREATE DATABASE mybatis_3;

DROP TABLE IF EXISTS mybatis_3.student;

CREATE TABLE  mybatis_3.ststudentudent(
ID int(10) NOT NULL AUTO_INCREMENT,  
NAME varchar(100) NOT NULL,
BRANCH varchar(255) NOT NULL,
PERCENTAGE int(3) NOT NULL,  
PHONE int(10) NOT NULL,
EMAIL varchar(255) NOT NULL,
PRIMARY KEY ( ID )
);

select *
from student;

DELIMITER //
create procedure my_read_recordById (in emp_id int)
begin
SELECT * FROM STUDENT WHERE ID = emp_id;
END//

DELIMITER ;

select 100;

call my_read_recordById(9999);


SELECT * FROM STUDENT WHERE name LIKE concat('%', 'rity', '%');
```