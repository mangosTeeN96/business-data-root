-- 创建数据库
DROP DATABASE IF EXISTS business_data;
CREATE DATABASE business_data;

-- 使用数据库
USE business_data;

-- 用于数据测试
-- 创建用户信息测试表
CREATE TABLE user (
  `user_id`     BIGINT        NOT NULL AUTO_INCREMENT
  COMMENT '用户ID',
  `user_name`   VARCHAR(120)  NOT NULL
  COMMENT '用户名称',
  `age`         INT           NOT NULL
  COMMENT '用户年龄',
  `address`     VARCHAR(1024) NOT NULL
  COMMENT '地址',
  `user_phone`  VARCHAR(64)   NOT NULL
  COMMENT '用户电话',
  `create_time` TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP()
  COMMENT '创建的时间',
  PRIMARY KEY (user_id)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '用户信息-测试表';

-- 插入初始化数据
INSERT INTO
  `user` (user_name, age, address, user_phone)
VALUES
  ('小明', 21, '北京', '13712345678'),
  ('小张', 22, '上海', '13212345678');




-- 创建用户信息表
CREATE TABLE user_info (
  `user_id`     BIGINT       NOT NULL AUTO_INCREMENT
  COMMENT '用户ID',
  `user_name`   VARCHAR(120) NOT NULL
  COMMENT '用户名称',
  `account`     VARCHAR(120) NOT NULL
  COMMENT '账户名',
  `password`    VARCHAR(64)  NOT NULL
  COMMENT '账户密码',
  `user_phone`  VARCHAR(64)  NOT NULL
  COMMENT '用户电话',
  `position`    VARCHAR(64)  NOT NULL
  COMMENT '用户职位',
  `user_right`  INT          NOT NULL
  COMMENT '用户权限',
  `create_time` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP()
  COMMENT '创建的时间',
  PRIMARY KEY (user_id)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '用户信息表';




-- 创建人员信息表
CREATE TABLE member_info (
  `member_id`   BIGINT       NOT NULL AUTO_INCREMENT
  COMMENT '成员ID',
  `member_name` VARCHAR(120) NOT NULL
  COMMENT '成员姓名',
  `position`    VARCHAR(120) NOT NULL
  COMMENT '成员职位',
  `violation`   VARCHAR(32)  NOT NULL
  COMMENT '违规情况',
  `location`    VARCHAR(300) NOT NULL
  COMMENT '位置',
  `create_time` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP()
  COMMENT '创建的时间',
  PRIMARY KEY (member_id)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '人员信息表';

-- 插入数据
INSERT INTO
  `member_info` (member_name, position, violation, location)
VALUES
  ("xiaoming", "工人", "无违规情况", "上面"),
  ("xiaohou", "工人", "无违规情况", "厂区"),
  ("xiaohong", "工人", "无违规情况", "上面"),
  ("liming", "工人", "无违规情况", "大厅"),
  ("bob", "工人", "无违规情况", "上面");





--  用户权限表
DROP TABLE IF EXISTS user_right;
CREATE TABLE user_right
(
  right_id   INT(11)     NOT NULL
  COMMENT '用户权限表',
  right_flag TINYINT(16) NOT NULL
  COMMENT '权限ID',
  right_name VARCHAR(16) NOT NULL
  COMMENT '权限标记',
  PRIMARY KEY clustered (right_id)
);

