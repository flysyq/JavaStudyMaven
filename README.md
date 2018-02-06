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


2、2016-2-6
    增加了disruptor的例子
    增加了唯一序列号生成算法，用于生成短链接
    增加了netty文件上传，存在问题，需要改正
    测试了mysql和postgresql的插入效率，开二十个线程，插入在每秒1万上下，postgresql略快一些
