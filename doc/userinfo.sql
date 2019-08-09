DROP TABLE IF EXISTS `UserInfo`;
CREATE TABLE `UserInfo` (
  `articleId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userName`varchar(30) NOT NULL COMMENT '用户名',
  `age` int(10) NOT NULL COMMENT '年龄',
  `sex` varchar(10) DEFAULT 'SECRET' COMMENT '性别',
	`salary` float(7,2) NOT NULL DEFAULT 0.00 COMMENT '工资',
	`regTime` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
	`completed` boolean DEFAULT FALSE COMMENT '是否完成任务',
	`remark` text default NULL COMMENT '备注',
  PRIMARY KEY (`userInfoid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 初始化
INSERT INTO UserInfo(userName,age,sex,salary,completed,remark) VALUES("aa",18,"MAN",5000.00,1,"初始备注1");
INSERT INTO UserInfo(userName,age,sex,salary,completed,remark) VALUES("bb",19,"WOMAN",4000.00,1,"初始备注2");
INSERT INTO UserInfo(userName,age,sex,salary,completed,remark) VALUES("cc",20,"MAN",3000.00,1,"初始备注3");
INSERT INTO UserInfo(userName,age,sex,salary,completed,remark) VALUES("dd",21,"MAN",2000.00,1,"初始备注4");
INSERT INTO UserInfo(userName,age,sex,salary,completed,remark) VALUES("ee",22,"MAN",1000.00,1,"初始备注5")