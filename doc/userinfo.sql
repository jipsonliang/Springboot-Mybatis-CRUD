DROP TABLE IF EXISTS `UserInfo`;
CREATE TABLE IF NOT EXISTS `UserInfo` (
  `userInfoId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userName`varchar(30) NOT NULL COMMENT '用户名',
  `age` int(10) NOT NULL COMMENT '年龄',
  `sex` enum('男','女','保密') DEFAULT '保密' COMMENT '性别',
	`salary` float(7,2) NOT NULL DEFAULT 0.00 COMMENT '工资',
	`regTime` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
	`completed` boolean DEFAULT FALSE COMMENT '是否完成任务',
	`remark` text default NULL COMMENT '备注',
  PRIMARY KEY (`userInfoid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;