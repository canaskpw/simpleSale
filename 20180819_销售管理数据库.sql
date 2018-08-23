--商品表
create table t_product2(
  p_id number(6) primary key,
  p_name varchar2(20),
  --售价
  p_salePrice number(5,2),
  --单位
  p_unit varchar2(5),
  --类型外键
  t_id number (6),
  constraint fk_t_id foreign key(t_id) references t_type2(t_id)
);

--插入商品
insert into t_product2 values(1,'卫龙',100.0,'包',1);
insert into t_product2 values(2,'李小鹏',200.0,'根',1);
insert into t_product2 values(3,'香油条',500.5,'包',1);
insert into t_product2 values(4,'北瑅麻辣肉',300.5,'片',1);
insert into t_product2 values(5,'安慕希',102.0,'瓶',2);
insert into t_product2 values(6,'优益C',103.0,'瓶',2);
insert into t_product2 values(7,'袋装奶',100.0,'袋',2);
insert into t_product2 values(8,'苹果',100.0,'个',3);
insert into t_product2 values(9,'葡萄',200.0,'颗',3);
insert into t_product2 values(10,'桃子',300.0,'个',3);
insert into t_product2 values(11,'香蕉',100.0,'根',3);
insert into t_product2 values(12,'大白兔',100.0,'包',4);
insert into t_product2 values(13,'金丝猴',200.0,'粒',4);
insert into t_product2 values(14,'阿尔卑斯',100.0,'条',4);
insert into t_product2 values(15,'软糖',120.0,'粒',4);

select * from t_product2

--商品类型表 
create table t_type2(
  t_id number(6)  primary key,
  t_name varchar(20) 
);

--插入商品类型
insert into t_type2 values(1,'辣条');
insert into t_type2 values(2,'牛奶');
insert into t_type2 values(3,'水果');
insert into t_type2 values(4,'糖果');

--进货表
create table t_purchasegood2(
  --进货编号，商品编号联合主键
  pur_id number(6)primary key,
  --商品编号（外键）
  p_id number(6),
  --进货价格
  pur_price number(5,2),
  --进货数量
  pur_num number(5),
  --供货商（外键）
  s_id number(5),
  --状态
  pur_status number(2),
  --时间
  pur_time varchar2(30),
  --员工编号（外键）
  e_id number(6),

  constraint fk_p_id2 foreign key(p_id) references t_product2(p_id),
  constraint fk_s_id foreign key(s_id) references t_supplier2(s_id),
  constraint fk_e_id foreign key(e_id) references t_empl2(e_id)
);

--员工表
create table t_empl2(
  e_id number(6) primary key,
  --员工名字
  e_name varchar2(10)
);

--角色表
create table t_role2(
  r_id number(6) primary key,
  --角色名字
  r_name varchar2(10)
);

--菜单表
create table t_menu2(
  m_id number(6) primary key,
  --菜单名
  m_name varchar2(20),
  --菜单路径
  m_path varchar2(100)
);

--员工角色表
create table t_emplrole2(
  --员工编号
  e_id number(6),
  --角色编号
  r_id number(6),
  --外键约束
  constraint fk_r_id2 foreign key(r_id) references t_role2(r_id),
  constraint fk_e_id2 foreign key(e_id) references t_empl2(e_id)
);

--角色菜单表
create table t_rolemenu2(
  --角色编号
  e_id number(6),
  --菜单编号
  m_id number(6),
  --外键约束
  constraint fk_m_id3 foreign key(m_id) references t_menu2(m_id),
  constraint fk_e_id3 foreign key(e_id) references t_empl2(e_id)
);

--供货商
create table t_supplier2(
  s_id number(6) primary key,
  s_name varchar2(10)
);

--订单表（销售表）
create table t_order2(
  --订单编号（主键）
  o_id number(6) primary key,
  --商品编号（外键）
  p_id number(6),
  --商品数量
  o_num number(6),
  --小计（商品数量*单价）
  o_tips number(10),
  --订单时间
  o_time varchar2(30),
  --客户编号(外键)
  cus_id number(6),
  --员工编号
   e_id number(6),
  constraint fk_e_id4 foreign key(e_id) references t_empl2(e_id),
  constraint fk_p_id3 foreign key(p_id) references t_product2(p_id),
  constraint fk_cus_id foreign key(cus_id) references t_customer2(cus_id)
);

drop table t_order2
--客户表
create table t_customer2(
  cus_id number(6) primary key,
  cus_name varchar2(10),
  --客户类型（1为普通客户，2为vip客户商品打8折）
  cus_type number(2),
  --联系人
  cus_contacts varchar2(30),
  --联系电话
  cus_tel varchar2(40),
  --所属地区
  cus_area varchar2(40)
);

select * from t_customer2

--客户序列
create sequence seq_customer2
  increment by 1
  start with 1000
  nomaxvalue
  nocycle;

--插入客户数据
insert into t_customer2 values(seq_customer2.nextval,'张三',1,'张三的爸爸','18773504905','长沙');
insert into t_customer2 values(seq_customer2.nextval,'李四',2,'李四的爸爸','18573504905','北京');

--库存表
create table t_inventory(
  --主键
  i_id number(6) primary key,
  --商品外键
  p_id number(6),
  --数量
  i_num number(6),
  constraint fk_tp_id4 foreign key(p_id) references t_product2(p_id)
);

--库存序列
create sequence seq_inventory2
  increment by 1
  start with 1
  nomaxvalue
  nocycle;
  
  select * from t_customer2

insert into t_inventory values(seq_inventory2.nextval,1,20);
insert into t_inventory values(seq_inventory2.nextval,2,30);
insert into t_inventory values(seq_inventory2.nextval,3,30);
insert into t_inventory values(seq_inventory2.nextval,4,40);
insert into t_inventory values(seq_inventory2.nextval,5,50);
insert into t_inventory values(seq_inventory2.nextval,6,60);
insert into t_inventory values(seq_inventory2.nextval,7,70);
commit