# JavaStudyMaven
1、2016-10-18 

   增加了mybatis操作Mysql的例子，参考了http://blog.csdn.net/h3c4lenovo/article/details/8453542
   其中数据表SQL为
   CREATE TABLE `info_user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`user_name` VARCHAR(50) NULL DEFAULT NULL,
	`password` VARCHAR(50) NULL DEFAULT NULL,
	`comment` VARCHAR(500) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `user_name` (`user_name`)
);
