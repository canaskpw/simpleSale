--��Ʒ��
create table t_product2(
  p_id number(6) primary key,
  p_name varchar2(20),
  --�ۼ�
  p_salePrice number(5,2),
  --��λ
  p_unit varchar2(5),
  --�������
  t_id number (6),
  constraint fk_t_id foreign key(t_id) references t_type2(t_id)
);

--������Ʒ
insert into t_product2 values(1,'����',100.0,'��',1);
insert into t_product2 values(2,'��С��',200.0,'��',1);
insert into t_product2 values(3,'������',500.5,'��',1);
insert into t_product2 values(4,'���v������',300.5,'Ƭ',1);
insert into t_product2 values(5,'��Ľϣ',102.0,'ƿ',2);
insert into t_product2 values(6,'����C',103.0,'ƿ',2);
insert into t_product2 values(7,'��װ��',100.0,'��',2);
insert into t_product2 values(8,'ƻ��',100.0,'��',3);
insert into t_product2 values(9,'����',200.0,'��',3);
insert into t_product2 values(10,'����',300.0,'��',3);
insert into t_product2 values(11,'�㽶',100.0,'��',3);
insert into t_product2 values(12,'�����',100.0,'��',4);
insert into t_product2 values(13,'��˿��',200.0,'��',4);
insert into t_product2 values(14,'������˹',100.0,'��',4);
insert into t_product2 values(15,'����',120.0,'��',4);

select * from t_product2

--��Ʒ���ͱ� 
create table t_type2(
  t_id number(6)  primary key,
  t_name varchar(20) 
);

--������Ʒ����
insert into t_type2 values(1,'����');
insert into t_type2 values(2,'ţ��');
insert into t_type2 values(3,'ˮ��');
insert into t_type2 values(4,'�ǹ�');

--������
create table t_purchasegood2(
  --������ţ���Ʒ�����������
  pur_id number(6)primary key,
  --��Ʒ��ţ������
  p_id number(6),
  --�����۸�
  pur_price number(5,2),
  --��������
  pur_num number(5),
  --�����̣������
  s_id number(5),
  --״̬
  pur_status number(2),
  --ʱ��
  pur_time varchar2(30),
  --Ա����ţ������
  e_id number(6),

  constraint fk_p_id2 foreign key(p_id) references t_product2(p_id),
  constraint fk_s_id foreign key(s_id) references t_supplier2(s_id),
  constraint fk_e_id foreign key(e_id) references t_empl2(e_id)
);

--Ա����
create table t_empl2(
  e_id number(6) primary key,
  --Ա������
  e_name varchar2(10)
);

--��ɫ��
create table t_role2(
  r_id number(6) primary key,
  --��ɫ����
  r_name varchar2(10)
);

--�˵���
create table t_menu2(
  m_id number(6) primary key,
  --�˵���
  m_name varchar2(20),
  --�˵�·��
  m_path varchar2(100)
);

--Ա����ɫ��
create table t_emplrole2(
  --Ա�����
  e_id number(6),
  --��ɫ���
  r_id number(6),
  --���Լ��
  constraint fk_r_id2 foreign key(r_id) references t_role2(r_id),
  constraint fk_e_id2 foreign key(e_id) references t_empl2(e_id)
);

--��ɫ�˵���
create table t_rolemenu2(
  --��ɫ���
  e_id number(6),
  --�˵����
  m_id number(6),
  --���Լ��
  constraint fk_m_id3 foreign key(m_id) references t_menu2(m_id),
  constraint fk_e_id3 foreign key(e_id) references t_empl2(e_id)
);

--������
create table t_supplier2(
  s_id number(6) primary key,
  s_name varchar2(10)
);

--���������۱�
create table t_order2(
  --������ţ�������
  o_id number(6) primary key,
  --��Ʒ��ţ������
  p_id number(6),
  --��Ʒ����
  o_num number(6),
  --С�ƣ���Ʒ����*���ۣ�
  o_tips number(10),
  --����ʱ��
  o_time varchar2(30),
  --�ͻ����(���)
  cus_id number(6),
  --Ա�����
   e_id number(6),
  constraint fk_e_id4 foreign key(e_id) references t_empl2(e_id),
  constraint fk_p_id3 foreign key(p_id) references t_product2(p_id),
  constraint fk_cus_id foreign key(cus_id) references t_customer2(cus_id)
);

drop table t_order2
--�ͻ���
create table t_customer2(
  cus_id number(6) primary key,
  cus_name varchar2(10),
  --�ͻ����ͣ�1Ϊ��ͨ�ͻ���2Ϊvip�ͻ���Ʒ��8�ۣ�
  cus_type number(2),
  --��ϵ��
  cus_contacts varchar2(30),
  --��ϵ�绰
  cus_tel varchar2(40),
  --��������
  cus_area varchar2(40)
);

select * from t_customer2

--�ͻ�����
create sequence seq_customer2
  increment by 1
  start with 1000
  nomaxvalue
  nocycle;

--����ͻ�����
insert into t_customer2 values(seq_customer2.nextval,'����',1,'�����İְ�','18773504905','��ɳ');
insert into t_customer2 values(seq_customer2.nextval,'����',2,'���ĵİְ�','18573504905','����');

--����
create table t_inventory(
  --����
  i_id number(6) primary key,
  --��Ʒ���
  p_id number(6),
  --����
  i_num number(6),
  constraint fk_tp_id4 foreign key(p_id) references t_product2(p_id)
);

--�������
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