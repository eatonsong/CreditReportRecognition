
create table XA_ACCFUND
(
  reportno     VARCHAR2(32) not null,
  ref_id       VARCHAR2(32) not null,
  area         VARCHAR2(1000),
  registerdate VARCHAR2(10),
  firstmonth   VARCHAR2(10),
  tomonth      VARCHAR2(10),
  state        VARCHAR2(300),
  pay          NUMBER(24,6),
  ownpercent   NUMBER(24,6),
  compercent   NUMBER(24,6),
  organname    VARCHAR2(300),
  gettime      VARCHAR2(10),
  sortno       NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_ACCFUND
  is '住房公积金参缴记录';
comment on column XA_ACCFUND.reportno
  is '报告编号';
comment on column XA_ACCFUND.ref_id
  is '查询关联编号';
comment on column XA_ACCFUND.area
  is '参缴地';
comment on column XA_ACCFUND.registerdate
  is '参缴日期';
comment on column XA_ACCFUND.firstmonth
  is '初缴月份';
comment on column XA_ACCFUND.tomonth
  is '缴至月份';
comment on column XA_ACCFUND.state
  is '缴费状态';
comment on column XA_ACCFUND.pay
  is '月缴存额';
comment on column XA_ACCFUND.ownpercent
  is '个人缴存比例';
comment on column XA_ACCFUND.compercent
  is '单位缴存比例';
comment on column XA_ACCFUND.organname
  is '缴费单位';
comment on column XA_ACCFUND.gettime
  is '信息更新日期';
comment on column XA_ACCFUND.sortno
  is '编号';
create index IDX_XA_ACCFUND_001 on XA_ACCFUND (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_ACCFUND_002 on XA_ACCFUND (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_ACCFUND to LIBRA;

prompt Creating XA_ADMINAWARD...
create table XA_ADMINAWARD
(
  reportno  VARCHAR2(32) not null,
  ref_id    VARCHAR2(32) not null,
  organname VARCHAR2(300),
  content   VARCHAR2(1000),
  begindate VARCHAR2(10),
  enddate   VARCHAR2(10),
  sortno    NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_ADMINAWARD
  is '行政奖励记录';
comment on column XA_ADMINAWARD.reportno
  is '报告编号';
comment on column XA_ADMINAWARD.ref_id
  is '查询关联编号';
comment on column XA_ADMINAWARD.organname
  is '奖励机构';
comment on column XA_ADMINAWARD.content
  is '奖励内容';
comment on column XA_ADMINAWARD.begindate
  is '生效日期';
comment on column XA_ADMINAWARD.enddate
  is '截止日期';
comment on column XA_ADMINAWARD.sortno
  is '编号';
create index DX_XA_ADMINAWARD_002 on XA_ADMINAWARD (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_ADMINAWARD_001 on XA_ADMINAWARD (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_ADMINAWARD to LIBRA;

prompt Creating XA_ADMINPUNISHMENT...
create table XA_ADMINPUNISHMENT
(
  reportno  VARCHAR2(32) not null,
  ref_id    VARCHAR2(32) not null,
  organname VARCHAR2(1000),
  content   VARCHAR2(1000),
  money     NUMBER(24,6),
  begindate VARCHAR2(10),
  enddate   VARCHAR2(10),
  result    VARCHAR2(1000),
  sortno    NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_ADMINPUNISHMENT
  is '行政处罚记录';
comment on column XA_ADMINPUNISHMENT.reportno
  is '报告编号';
comment on column XA_ADMINPUNISHMENT.ref_id
  is '查询关联编号';
comment on column XA_ADMINPUNISHMENT.organname
  is '处罚机构';
comment on column XA_ADMINPUNISHMENT.content
  is '处罚内容';
comment on column XA_ADMINPUNISHMENT.money
  is '处罚金额';
comment on column XA_ADMINPUNISHMENT.begindate
  is '生效日期';
comment on column XA_ADMINPUNISHMENT.enddate
  is '截止日期';
comment on column XA_ADMINPUNISHMENT.result
  is '行政复议结果';
comment on column XA_ADMINPUNISHMENT.sortno
  is '编号';
create index IDX_XA_ADMINPUNISHMENT_001 on XA_ADMINPUNISHMENT (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_ADMINPUNISHMENT_002 on XA_ADMINPUNISHMENT (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_ADMINPUNISHMENT to LIBRA;

prompt Creating XA_AHEADBILL...
create table XA_AHEADBILL
(
  id                      VARCHAR2(64) not null,
  trans_no                VARCHAR2(64),
  apply_no                VARCHAR2(40),
  trans_date              VARCHAR2(10),
  full_name               VARCHAR2(120),
  cert_id                 VARCHAR2(48),
  actualpay_corpus_amt    NUMBER(24,6),
  actualpay_inte_amt      NUMBER(24,6),
  actualpay_fine_amt      NUMBER(24,6),
  actualpay_compdinte_amt NUMBER(24,6),
  actualpay_fee_amt       NUMBER(24,6),
  actualpay_fee1_amt      NUMBER(24,6),
  trans_type              VARCHAR2(10),
  file_id                 VARCHAR2(64) not null,
  status                  VARCHAR2(10),
  inputdate               VARCHAR2(10),
  partner_code            VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_AHEADBILL
  is '提前还款、代偿信息';
comment on column XA_AHEADBILL.id
  is '主键';
comment on column XA_AHEADBILL.trans_no
  is '交易流水号';
comment on column XA_AHEADBILL.apply_no
  is '小安申请编号';
comment on column XA_AHEADBILL.trans_date
  is '交易日期';
comment on column XA_AHEADBILL.full_name
  is '客户名称';
comment on column XA_AHEADBILL.cert_id
  is '证件号码';
comment on column XA_AHEADBILL.actualpay_corpus_amt
  is '实还本金';
comment on column XA_AHEADBILL.actualpay_inte_amt
  is '实还利息';
comment on column XA_AHEADBILL.actualpay_fine_amt
  is '实还罚息';
comment on column XA_AHEADBILL.actualpay_compdinte_amt
  is '实还复利';
comment on column XA_AHEADBILL.actualpay_fee_amt
  is '实还费用';
comment on column XA_AHEADBILL.actualpay_fee1_amt
  is '实还费用1';
comment on column XA_AHEADBILL.trans_type
  is '交易类型(10提前还款,20代偿还款)';
comment on column XA_AHEADBILL.file_id
  is '文件ID';
comment on column XA_AHEADBILL.status
  is '处理状态(0:未处理、1:已处理、2:处理失败)';
comment on column XA_AHEADBILL.inputdate
  is '录入日期';
comment on column XA_AHEADBILL.partner_code
  is '资金方';
create index IDX_XA_AHEADBILL_APPLY_NO on XA_AHEADBILL (APPLY_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index IDX_XA_AHEADBILL_ID on XA_AHEADBILL (ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_AHEADBILL_TRANS_NO on XA_AHEADBILL (TRANS_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table XA_AHEADBILL
  add constraint PK_XA_AHEADBILL primary key (ID);
grant select on XA_AHEADBILL to LIBRA;

prompt Creating XA_ANNOUNCEINFO...
create table XA_ANNOUNCEINFO
(
  reportno VARCHAR2(32) not null,
  account  VARCHAR2(50),
  ref_id   VARCHAR2(32) not null,
  content  VARCHAR2(1000),
  gettime  VARCHAR2(10),
  type     VARCHAR2(100),
  sortno   NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_ANNOUNCEINFO
  is '本人声明';
comment on column XA_ANNOUNCEINFO.reportno
  is '报告编号';
comment on column XA_ANNOUNCEINFO.account
  is '业务号';
comment on column XA_ANNOUNCEINFO.ref_id
  is '查询关联编号';
comment on column XA_ANNOUNCEINFO.content
  is '本人声明';
comment on column XA_ANNOUNCEINFO.gettime
  is '添加日期';
comment on column XA_ANNOUNCEINFO.type
  is '声明类型';
comment on column XA_ANNOUNCEINFO.sortno
  is '编号';
create index IDX_XA_ANNOUNCEINFO_001 on XA_ANNOUNCEINFO (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_ANNOUNCEINFO_002 on XA_ANNOUNCEINFO (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_ANNOUNCEINFO to LIBRA;

prompt Creating XA_APPROVAL...
create table XA_APPROVAL
(
  id              VARCHAR2(64) not null,
  trans_no        VARCHAR2(64),
  apply_no        VARCHAR2(40),
  full_name       VARCHAR2(120),
  approval_status VARCHAR2(10),
  putout_date     VARCHAR2(10),
  loan_amt        NUMBER(24,6),
  loan_term       INTEGER,
  file_id         VARCHAR2(64) not null,
  status          VARCHAR2(10),
  inputdate       VARCHAR2(10),
  partner_code    VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_APPROVAL
  is '贷款审批回执信息';
comment on column XA_APPROVAL.id
  is '主键';
comment on column XA_APPROVAL.trans_no
  is '交易流水号';
comment on column XA_APPROVAL.apply_no
  is '小安申请编号';
comment on column XA_APPROVAL.full_name
  is '客户名称';
comment on column XA_APPROVAL.approval_status
  is '审批类型(01表示放款通过,02表示放款否决)';
comment on column XA_APPROVAL.putout_date
  is '放款日期';
comment on column XA_APPROVAL.loan_amt
  is '放款金额';
comment on column XA_APPROVAL.loan_term
  is '放款期限';
comment on column XA_APPROVAL.file_id
  is '文件ID';
comment on column XA_APPROVAL.status
  is '处理状态(0:未处理、1:已处理、2:处理失败)';
comment on column XA_APPROVAL.inputdate
  is '录入日期';
comment on column XA_APPROVAL.partner_code
  is '资金方';
create index IDX_XA_APPROVAL_APPLY_NO on XA_APPROVAL (APPLY_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_APPROVAL_FILE_ID on XA_APPROVAL (FILE_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index IDX_XA_APPROVAL_ID on XA_APPROVAL (ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_APPROVAL_TRANS_NO on XA_APPROVAL (TRANS_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table XA_APPROVAL
  add constraint PK_XA_APPROVAL primary key (ID);
grant select on XA_APPROVAL to LIBRA;

prompt Creating XA_APP_ECM_IMAGE_TYPE...
create table XA_APP_ECM_IMAGE_TYPE
(
  objectno   VARCHAR2(40) not null,
  typeno     VARCHAR2(40) not null,
  typename   VARCHAR2(200) not null,
  remark     VARCHAR2(200),
  inputuser  VARCHAR2(40),
  inputtdate VARCHAR2(40),
  updateuser VARCHAR2(40),
  updatedate VARCHAR2(40),
  verifyflag VARCHAR2(2),
  id         VARCHAR2(40) default sys_guid() not null,
  ref_id     VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_APP_ECM_IMAGE_TYPE
  is '申请资料清单核对信息表';
comment on column XA_APP_ECM_IMAGE_TYPE.verifyflag
  is '1-已核对 0-未核对';
comment on column XA_APP_ECM_IMAGE_TYPE.ref_id
  is '查询关联编号';
alter table XA_APP_ECM_IMAGE_TYPE
  add primary key (OBJECTNO, TYPENO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_APP_ECM_IMAGE_TYPE to LIBRA;

prompt Creating XA_ASSETDISPOSITION...
create table XA_ASSETDISPOSITION
(
  reportno        VARCHAR2(32) not null,
  ref_id          VARCHAR2(32) not null,
  organname       VARCHAR2(300),
  gettime         VARCHAR2(10),
  money           NUMBER(24,6),
  latestrepaydate VARCHAR2(10),
  balance         NUMBER(24,6),
  sortno          NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_ASSETDISPOSITION
  is '资产处置信息';
comment on column XA_ASSETDISPOSITION.reportno
  is '报告编号';
comment on column XA_ASSETDISPOSITION.ref_id
  is '查询关联编号';
comment on column XA_ASSETDISPOSITION.organname
  is '资产管理公司';
comment on column XA_ASSETDISPOSITION.gettime
  is '债务接收日期';
comment on column XA_ASSETDISPOSITION.money
  is '接收的债权金额';
comment on column XA_ASSETDISPOSITION.latestrepaydate
  is '最近一次还款日期';
comment on column XA_ASSETDISPOSITION.balance
  is '余额';
comment on column XA_ASSETDISPOSITION.sortno
  is '编号';
create index IDX_XA_ASSETDISPOSITION_001 on XA_ASSETDISPOSITION (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_ASSETDISPOSITION_002 on XA_ASSETDISPOSITION (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_ASSETDISPOSITION to LIBRA;

prompt Creating XA_ASSURERREPAY...
create table XA_ASSURERREPAY
(
  reportno               VARCHAR2(32) not null,
  ref_id                 VARCHAR2(32) not null,
  organname              VARCHAR2(300),
  latestassurerrepaydate VARCHAR2(10),
  money                  NUMBER(24,6),
  latestrepaydate        VARCHAR2(10),
  balance                NUMBER(24,6),
  sortno                 NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_ASSURERREPAY
  is '保证人代偿信息';
comment on column XA_ASSURERREPAY.reportno
  is '报告编号';
comment on column XA_ASSURERREPAY.ref_id
  is '查询关联编号';
comment on column XA_ASSURERREPAY.organname
  is '代偿机构';
comment on column XA_ASSURERREPAY.latestassurerrepaydate
  is '最近一次代偿日期';
comment on column XA_ASSURERREPAY.money
  is '累计代偿金额';
comment on column XA_ASSURERREPAY.latestrepaydate
  is '最近一次还款日期';
comment on column XA_ASSURERREPAY.balance
  is '余额';
comment on column XA_ASSURERREPAY.sortno
  is '编号';
create index IDX_XA_ASSURERREPAY_001 on XA_ASSURERREPAY (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_ASSURERREPAY_002 on XA_ASSURERREPAY (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_ASSURERREPAY to LIBRA;

prompt Creating XA_BANKILLUMINATE...
create table XA_BANKILLUMINATE
(
  reportno VARCHAR2(32) not null,
  account  VARCHAR2(50),
  ref_id   VARCHAR2(32) not null,
  content  VARCHAR2(1000),
  gettime  VARCHAR2(10),
  type     VARCHAR2(100) not null,
  sortno   NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_BANKILLUMINATE
  is '贷款机构说明';
comment on column XA_BANKILLUMINATE.reportno
  is '报告编号';
comment on column XA_BANKILLUMINATE.account
  is '业务号';
comment on column XA_BANKILLUMINATE.ref_id
  is '查询关联编号';
comment on column XA_BANKILLUMINATE.content
  is '贷款机构说明';
comment on column XA_BANKILLUMINATE.gettime
  is '添加日期';
comment on column XA_BANKILLUMINATE.type
  is '说明类型';
comment on column XA_BANKILLUMINATE.sortno
  is '编号';
create index IDX_XA_BANKILLUMINATE_001 on XA_BANKILLUMINATE (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_BANKILLUMINATE_002 on XA_BANKILLUMINATE (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_BANKILLUMINATE to LIBRA;

prompt Creating XA_BUSINESS_ACCEPTED_CITY...
create table XA_BUSINESS_ACCEPTED_CITY
(
  id               VARCHAR2(100) not null,
  businesscityname VARCHAR2(100) not null,
  create_time      DATE not null,
  author           VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column XA_BUSINESS_ACCEPTED_CITY.id
  is '������������id';
comment on column XA_BUSINESS_ACCEPTED_CITY.businesscityname
  is '����������������';
comment on column XA_BUSINESS_ACCEPTED_CITY.create_time
  is '��������';
comment on column XA_BUSINESS_ACCEPTED_CITY.author
  is '������';
alter table XA_BUSINESS_ACCEPTED_CITY
  add constraint PK_ACCEPTED_CITY primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_BUSINESS_ACCEPTED_CITY to LIBRA;

prompt Creating XA_CIVILJUDGEMENT...
create table XA_CIVILJUDGEMENT
(
  reportno         VARCHAR2(32) not null,
  ref_id           VARCHAR2(32) not null,
  court            VARCHAR2(300),
  casereason       VARCHAR2(1000),
  registerdate     VARCHAR2(10),
  closedtype       VARCHAR2(300),
  caseresult       VARCHAR2(1000),
  casevalidatedate VARCHAR2(10),
  suitobject       VARCHAR2(1000),
  suitobjectmoney  NUMBER(24,6),
  sortno           NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_CIVILJUDGEMENT
  is '民事判决记录';
comment on column XA_CIVILJUDGEMENT.reportno
  is '报告编号';
comment on column XA_CIVILJUDGEMENT.ref_id
  is '查询关联编号';
comment on column XA_CIVILJUDGEMENT.court
  is '立案法院';
comment on column XA_CIVILJUDGEMENT.casereason
  is '案由';
comment on column XA_CIVILJUDGEMENT.registerdate
  is '立案日期';
comment on column XA_CIVILJUDGEMENT.closedtype
  is '结案方式';
comment on column XA_CIVILJUDGEMENT.caseresult
  is '判决/调解结果';
comment on column XA_CIVILJUDGEMENT.casevalidatedate
  is '判决/调解生效日期';
comment on column XA_CIVILJUDGEMENT.suitobject
  is '诉讼标的';
comment on column XA_CIVILJUDGEMENT.suitobjectmoney
  is '诉讼标的金额';
comment on column XA_CIVILJUDGEMENT.sortno
  is '编号';
create index IDX_XA_CIVILJUDGEMENT_001 on XA_CIVILJUDGEMENT (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_CIVILJUDGEMENT_002 on XA_CIVILJUDGEMENT (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_CIVILJUDGEMENT to LIBRA;

prompt Creating XA_COMPANY_BLACK_LIST...
create table XA_COMPANY_BLACK_LIST
(
  id              VARCHAR2(100) not null,
  company         VARCHAR2(1000),
  create_time     DATE,
  author          VARCHAR2(100),
  descr           VARCHAR2(500),
  leveltype       VARCHAR2(40),
  company_address VARCHAR2(200),
  company_phone   VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column XA_COMPANY_BLACK_LIST.id
  is '主键id';
comment on column XA_COMPANY_BLACK_LIST.company
  is '公司名称';
comment on column XA_COMPANY_BLACK_LIST.create_time
  is '创建时间';
comment on column XA_COMPANY_BLACK_LIST.author
  is '作者';
comment on column XA_COMPANY_BLACK_LIST.descr
  is '添加理由';
comment on column XA_COMPANY_BLACK_LIST.leveltype
  is '级别';
comment on column XA_COMPANY_BLACK_LIST.company_address
  is '企业地址';
comment on column XA_COMPANY_BLACK_LIST.company_phone
  is '企业电话';
grant select on XA_COMPANY_BLACK_LIST to LIBRA;

prompt Creating XA_COMPANY_WHITE_LIST...
create table XA_COMPANY_WHITE_LIST
(
  id          VARCHAR2(100) not null,
  company     VARCHAR2(100) not null,
  create_time DATE not null,
  author      VARCHAR2(100) not null,
  descr       VARCHAR2(500) not null,
  leveltype   VARCHAR2(40)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column XA_COMPANY_WHITE_LIST.id
  is '主键id';
comment on column XA_COMPANY_WHITE_LIST.company
  is '公司名称';
comment on column XA_COMPANY_WHITE_LIST.create_time
  is '创建时间';
comment on column XA_COMPANY_WHITE_LIST.author
  is '作者';
comment on column XA_COMPANY_WHITE_LIST.descr
  is '添加理由';
comment on column XA_COMPANY_WHITE_LIST.leveltype
  is '����';
alter table XA_COMPANY_WHITE_LIST
  add constraint PK_WHITE_LIST primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_COMPANY_WHITE_LIST to LIBRA;

prompt Creating XA_COMPETENCE...
create table XA_COMPETENCE
(
  reportno       VARCHAR2(32) not null,
  ref_id         VARCHAR2(32) not null,
  competencyname VARCHAR2(300),
  grade          VARCHAR2(300),
  awarddate      VARCHAR2(10),
  enddate        VARCHAR2(10),
  revokedate     VARCHAR2(10),
  organname      VARCHAR2(300),
  area           VARCHAR2(1000),
  sortno         NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_COMPETENCE
  is '执业资格记录';
comment on column XA_COMPETENCE.reportno
  is '报告编号';
comment on column XA_COMPETENCE.ref_id
  is '查询关联编号';
comment on column XA_COMPETENCE.competencyname
  is '执业资格名称';
comment on column XA_COMPETENCE.grade
  is '等级';
comment on column XA_COMPETENCE.awarddate
  is '获得日期';
comment on column XA_COMPETENCE.enddate
  is '到期日期';
comment on column XA_COMPETENCE.revokedate
  is '吊销日期';
comment on column XA_COMPETENCE.organname
  is '颁发机构';
comment on column XA_COMPETENCE.area
  is '机构所在地';
comment on column XA_COMPETENCE.sortno
  is '编号';
create index IDX_XA_COMPETENCE_001 on XA_COMPETENCE (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_COMPETENCE_002 on XA_COMPETENCE (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_COMPETENCE to LIBRA;

prompt Creating XA_CREDITCUE...
create table XA_CREDITCUE
(
  reportno                       VARCHAR2(32) not null,
  houseloancount                 NUMBER(20),
  otherloancount                 NUMBER(20),
  firstloanopenmonth             VARCHAR2(10),
  loancardcount                  NUMBER(20),
  firstloancardopenmonth         VARCHAR2(10),
  standardloancardcount          NUMBER(20),
  firststandardloancardopenmonth VARCHAR2(10),
  announcecount                  NUMBER(20),
  dissentcount                   NUMBER(20),
  score                          VARCHAR2(100),
  month                          VARCHAR2(10),
  houseloan2count                NUMBER(20),
  ref_id                         VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_CREDITCUE
  is '信用提示';
comment on column XA_CREDITCUE.reportno
  is '报告编号';
comment on column XA_CREDITCUE.houseloancount
  is '住房贷款笔数';
comment on column XA_CREDITCUE.otherloancount
  is '其他贷款笔数';
comment on column XA_CREDITCUE.firstloanopenmonth
  is '首笔贷款发放月份';
comment on column XA_CREDITCUE.loancardcount
  is '贷记卡账户数';
comment on column XA_CREDITCUE.firstloancardopenmonth
  is '首张贷记卡发卡月份';
comment on column XA_CREDITCUE.standardloancardcount
  is '准贷记卡账户数';
comment on column XA_CREDITCUE.firststandardloancardopenmonth
  is '首张准贷记卡发卡月份';
comment on column XA_CREDITCUE.announcecount
  is '本人声明数目';
comment on column XA_CREDITCUE.dissentcount
  is '异议标注数目';
comment on column XA_CREDITCUE.score
  is '中征信评分';
comment on column XA_CREDITCUE.month
  is '评分月份';
comment on column XA_CREDITCUE.houseloan2count
  is '个人商用房（包括商住两用）贷款笔数';
comment on column XA_CREDITCUE.ref_id
  is '查询关联编号';
create index IDX_XA_CREDITCUE_001 on XA_CREDITCUE (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_CREDITCUE_002 on XA_CREDITCUE (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_CREDITCUE to LIBRA;

prompt Creating XA_DISSENTINFO...
create table XA_DISSENTINFO
(
  reportno VARCHAR2(32) not null,
  account  VARCHAR2(50),
  ref_id   VARCHAR2(32) not null,
  content  VARCHAR2(1000),
  gettime  VARCHAR2(10),
  type     VARCHAR2(100),
  sortno   NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_DISSENTINFO
  is '异议标注';
comment on column XA_DISSENTINFO.reportno
  is '报告编号';
comment on column XA_DISSENTINFO.account
  is '业务号';
comment on column XA_DISSENTINFO.ref_id
  is '查询关联编号';
comment on column XA_DISSENTINFO.content
  is '异议标注';
comment on column XA_DISSENTINFO.gettime
  is '添加日期';
comment on column XA_DISSENTINFO.type
  is '异议类型';
comment on column XA_DISSENTINFO.sortno
  is '编号';
create index IDX_XA_DISSENTINFO_001 on XA_DISSENTINFO (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_DISSENTINFO_002 on XA_DISSENTINFO (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_DISSENTINFO to LIBRA;

prompt Creating XA_ENDOWMENTINSURANCEDELIVER...
create table XA_ENDOWMENTINSURANCEDELIVER
(
  reportno    VARCHAR2(32) not null,
  ref_id      VARCHAR2(32) not null,
  area        VARCHAR2(1000),
  retiretype  VARCHAR2(300),
  retireddate VARCHAR2(10),
  workdate    VARCHAR2(10),
  money       NUMBER(24,6),
  pausereason VARCHAR2(300),
  organname   VARCHAR2(300),
  gettime     VARCHAR2(10),
  sortno      NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_ENDOWMENTINSURANCEDELIVER
  is '养老保险金发放记录';
comment on column XA_ENDOWMENTINSURANCEDELIVER.reportno
  is '报告编号';
comment on column XA_ENDOWMENTINSURANCEDELIVER.ref_id
  is '查询关联编号';
comment on column XA_ENDOWMENTINSURANCEDELIVER.area
  is '发放地';
comment on column XA_ENDOWMENTINSURANCEDELIVER.retiretype
  is '离退休类别';
comment on column XA_ENDOWMENTINSURANCEDELIVER.retireddate
  is '离退休月份';
comment on column XA_ENDOWMENTINSURANCEDELIVER.workdate
  is '参加工作月份';
comment on column XA_ENDOWMENTINSURANCEDELIVER.money
  is '本月实发养老金';
comment on column XA_ENDOWMENTINSURANCEDELIVER.pausereason
  is '停发原因';
comment on column XA_ENDOWMENTINSURANCEDELIVER.organname
  is '原单位名称';
comment on column XA_ENDOWMENTINSURANCEDELIVER.gettime
  is '信息更新日期';
comment on column XA_ENDOWMENTINSURANCEDELIVER.sortno
  is '编号';
create index IDX_XA_EICEDELIVER_001 on XA_ENDOWMENTINSURANCEDELIVER (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_EICEDELIVER_002 on XA_ENDOWMENTINSURANCEDELIVER (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_ENDOWMENTINSURANCEDELIVER to LIBRA;

prompt Creating XA_ENDOWMENTINSURANCEDEPOSIT...
create table XA_ENDOWMENTINSURANCEDEPOSIT
(
  reportno      VARCHAR2(32) not null,
  ref_id        VARCHAR2(32) not null,
  area          VARCHAR2(1000),
  registerdate  VARCHAR2(10),
  monthduration NUMBER(20),
  workdate      VARCHAR2(10),
  state         VARCHAR2(300),
  ownbasicmoney NUMBER(24,6),
  money         NUMBER(24,6),
  organname     VARCHAR2(1000),
  pausereason   VARCHAR2(1000),
  gettime       VARCHAR2(10),
  sortno        NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_ENDOWMENTINSURANCEDEPOSIT
  is '养老保险金缴存记录';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.reportno
  is '报告编号';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.ref_id
  is '查询关联编号';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.area
  is '参保地';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.registerdate
  is '参保日期';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.monthduration
  is '累计缴费月数';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.workdate
  is '参加工作月份';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.state
  is '缴费状态';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.ownbasicmoney
  is '个人缴费基数';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.money
  is '本月缴费金额';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.organname
  is '缴费单位';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.pausereason
  is '中断或终止缴费原因';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.gettime
  is '信息更新日期';
comment on column XA_ENDOWMENTINSURANCEDEPOSIT.sortno
  is '编号';
create index IDX_XA_EICEDEPOSIT_001 on XA_ENDOWMENTINSURANCEDEPOSIT (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_EICEDEPOSIT_002 on XA_ENDOWMENTINSURANCEDEPOSIT (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_ENDOWMENTINSURANCEDEPOSIT to LIBRA;

prompt Creating XA_FEEBILL...
create table XA_FEEBILL
(
  id                VARCHAR2(64) not null,
  trans_no          VARCHAR2(64),
  apply_no          VARCHAR2(40),
  pay_date          VARCHAR2(10),
  seq_id            INTEGER,
  fee_type          VARCHAR2(10),
  actualpay_fee_amt NUMBER(24,6),
  file_id           VARCHAR2(64) not null,
  status            VARCHAR2(10),
  inputdate         VARCHAR2(10),
  partner_code      VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_FEEBILL
  is '费用收取明细';
comment on column XA_FEEBILL.id
  is '主键';
comment on column XA_FEEBILL.trans_no
  is '交易流水号';
comment on column XA_FEEBILL.apply_no
  is '小安申请编号';
comment on column XA_FEEBILL.pay_date
  is '还款日期';
comment on column XA_FEEBILL.seq_id
  is '还款期次';
comment on column XA_FEEBILL.fee_type
  is '费用类型';
comment on column XA_FEEBILL.actualpay_fee_amt
  is '实还费用';
comment on column XA_FEEBILL.file_id
  is '文件ID';
comment on column XA_FEEBILL.status
  is '处理状态(0:未处理、1:已处理、2:处理失败)';
comment on column XA_FEEBILL.inputdate
  is '录入日期';
comment on column XA_FEEBILL.partner_code
  is '资金方';
create index IDX_XA_FEEBILL_APPLY_NO on XA_FEEBILL (APPLY_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_FEEBILL_FILE_ID on XA_FEEBILL (FILE_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index IDX_XA_FEEBILL_ID on XA_FEEBILL (ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_FEEBILL_TRANS_NO on XA_FEEBILL (TRANS_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table XA_FEEBILL
  add constraint PK_XA_FEEBILL primary key (ID);
grant select on XA_FEEBILL to LIBRA;

prompt Creating XA_FEEPAYPLAN...
create table XA_FEEPAYPLAN
(
  id           VARCHAR2(64) not null,
  trans_no     VARCHAR2(64),
  apply_no     VARCHAR2(40),
  seq_id       INTEGER,
  pay_date     VARCHAR2(10),
  fee_type     VARCHAR2(10),
  pay_fee_amt  NUMBER(24,6),
  file_id      VARCHAR2(64) not null,
  status       VARCHAR2(10),
  inputdate    VARCHAR2(10),
  partner_code VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_FEEPAYPLAN
  is '费用计划信息';
comment on column XA_FEEPAYPLAN.id
  is '主键';
comment on column XA_FEEPAYPLAN.trans_no
  is '交易流水号';
comment on column XA_FEEPAYPLAN.apply_no
  is '小安申请编号';
comment on column XA_FEEPAYPLAN.seq_id
  is '期次';
comment on column XA_FEEPAYPLAN.pay_date
  is '应还日期';
comment on column XA_FEEPAYPLAN.fee_type
  is '费用类型';
comment on column XA_FEEPAYPLAN.pay_fee_amt
  is '应还费用';
comment on column XA_FEEPAYPLAN.file_id
  is '文件ID';
comment on column XA_FEEPAYPLAN.status
  is '处理状态(0:未处理、1:已处理、2:处理失败)';
comment on column XA_FEEPAYPLAN.inputdate
  is '录入日期';
comment on column XA_FEEPAYPLAN.partner_code
  is '资金方';
create index IDX_XA_FEEPAYPLAN_APPLY_NO on XA_FEEPAYPLAN (APPLY_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_FEEPAYPLAN_FILE_ID on XA_FEEPAYPLAN (FILE_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index IDX_XA_FEEPAYPLAN_ID on XA_FEEPAYPLAN (ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_FEEPAYPLAN_TRANS_NO on XA_FEEPAYPLAN (TRANS_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table XA_FEEPAYPLAN
  add constraint PK_XA_FEEPAYPLAN primary key (ID);
grant select on XA_FEEPAYPLAN to LIBRA;

prompt Creating XA_FELLBACKSUMMARY...
create table XA_FELLBACKSUMMARY
(
  reportno VARCHAR2(32) not null,
  count    NUMBER(20),
  balance  NUMBER(24,6),
  count2   NUMBER(20),
  balance2 NUMBER(24,6),
  count3   NUMBER(20),
  balance3 NUMBER(24,6),
  ref_id   VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_FELLBACKSUMMARY
  is '呆账、资产处置、保证人代偿信息概要';
comment on column XA_FELLBACKSUMMARY.reportno
  is '报告编号';
comment on column XA_FELLBACKSUMMARY.count
  is '呆账信息笔数';
comment on column XA_FELLBACKSUMMARY.balance
  is '呆账信息余额';
comment on column XA_FELLBACKSUMMARY.count2
  is '资产处置信息笔数';
comment on column XA_FELLBACKSUMMARY.balance2
  is '资产处置信息余额';
comment on column XA_FELLBACKSUMMARY.count3
  is '保证人代偿信息笔数';
comment on column XA_FELLBACKSUMMARY.balance3
  is '保证人代偿信息余额';
comment on column XA_FELLBACKSUMMARY.ref_id
  is '查询关联编号';
create index IDX_XA_FELLBACKSUMMARY_001 on XA_FELLBACKSUMMARY (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_FELLBACKSUMMARY_002 on XA_FELLBACKSUMMARY (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_FELLBACKSUMMARY to LIBRA;

prompt Creating XA_FIELD_SURVEY_CITY...
create table XA_FIELD_SURVEY_CITY
(
  id          VARCHAR2(100) not null,
  cityname    VARCHAR2(100) not null,
  create_time DATE not null,
  author      VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column XA_FIELD_SURVEY_CITY.id
  is '��������������id';
comment on column XA_FIELD_SURVEY_CITY.cityname
  is '������������������';
comment on column XA_FIELD_SURVEY_CITY.create_time
  is '��������';
comment on column XA_FIELD_SURVEY_CITY.author
  is '������';
alter table XA_FIELD_SURVEY_CITY
  add constraint PK_SURVEY_CITY primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_FIELD_SURVEY_CITY to LIBRA;

prompt Creating XA_FORCEEXECUTION...
create table XA_FORCEEXECUTION
(
  reportno                  VARCHAR2(32) not null,
  ref_id                    VARCHAR2(32) not null,
  court                     VARCHAR2(300),
  casereason                VARCHAR2(1000),
  registerdate              VARCHAR2(10),
  closedtype                VARCHAR2(300),
  casestate                 VARCHAR2(300),
  closeddate                VARCHAR2(10),
  enforceobject             VARCHAR2(1000),
  enforceobjectmoney        NUMBER(24,6),
  alreadyenforceobject      VARCHAR2(1000),
  alreadyenforceobjectmoney NUMBER(24,6),
  sortno                    NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_FORCEEXECUTION
  is '强制执行记录';
comment on column XA_FORCEEXECUTION.reportno
  is '报告编号';
comment on column XA_FORCEEXECUTION.ref_id
  is '查询关联编号';
comment on column XA_FORCEEXECUTION.court
  is '执行法院';
comment on column XA_FORCEEXECUTION.casereason
  is '执行案由';
comment on column XA_FORCEEXECUTION.registerdate
  is '立案日期';
comment on column XA_FORCEEXECUTION.closedtype
  is '结案方式';
comment on column XA_FORCEEXECUTION.casestate
  is '案件状态';
comment on column XA_FORCEEXECUTION.closeddate
  is '结案日期';
comment on column XA_FORCEEXECUTION.enforceobject
  is '申请执行标的';
comment on column XA_FORCEEXECUTION.enforceobjectmoney
  is '申请执行标的价值';
comment on column XA_FORCEEXECUTION.alreadyenforceobject
  is '已执行标的';
comment on column XA_FORCEEXECUTION.alreadyenforceobjectmoney
  is '已执行标的金额';
comment on column XA_FORCEEXECUTION.sortno
  is '编号';
create index IDX_XA_FORCEEXECUTION_001 on XA_FORCEEXECUTION (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_FORCEEXECUTION_002 on XA_FORCEEXECUTION (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_FORCEEXECUTION to LIBRA;

prompt Creating XA_GUARANTEE...
create table XA_GUARANTEE
(
  reportno         VARCHAR2(32) not null,
  ref_id           VARCHAR2(32) not null,
  organname        VARCHAR2(300),
  contractmoney    NUMBER(24,6),
  begindate        VARCHAR2(10),
  enddate          VARCHAR2(10),
  guananteemoney   NUMBER(24,6),
  guaranteebalance NUMBER(24,6),
  class5state      VARCHAR2(100),
  billingdate      VARCHAR2(10),
  guarantee_type   VARCHAR2(10),
  sortno           NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_GUARANTEE
  is '对外担保信息';
comment on column XA_GUARANTEE.reportno
  is '报告编号';
comment on column XA_GUARANTEE.ref_id
  is '查询关联编号';
comment on column XA_GUARANTEE.organname
  is '担保贷款发放机构/担保信用卡发放机构';
comment on column XA_GUARANTEE.contractmoney
  is '担保贷款合同金额/担保信用卡授信额度';
comment on column XA_GUARANTEE.begindate
  is '担保贷款发放日期/担保信用卡发卡日期';
comment on column XA_GUARANTEE.enddate
  is '担保贷款到期日期';
comment on column XA_GUARANTEE.guananteemoney
  is '担保金额';
comment on column XA_GUARANTEE.guaranteebalance
  is '担保贷款本金余额/担保信用卡已用额度';
comment on column XA_GUARANTEE.class5state
  is '担保贷款五级分类';
comment on column XA_GUARANTEE.billingdate
  is '应还款日/账单日
';
comment on column XA_GUARANTEE.guarantee_type
  is '类型(1.贷款、2.贷记卡)';
comment on column XA_GUARANTEE.sortno
  is '编号';
create index IDX_XA_GUARANTEE_001 on XA_GUARANTEE (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_GUARANTEE_002 on XA_GUARANTEE (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_GUARANTEE to LIBRA;

prompt Creating XA_GUARANTEESUMMARY...
create table XA_GUARANTEESUMMARY
(
  reportno VARCHAR2(32) not null,
  count    NUMBER(20),
  amount   NUMBER(24,6),
  balance  NUMBER(24,6),
  ref_id   VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_GUARANTEESUMMARY
  is '对外担保信息汇总';
comment on column XA_GUARANTEESUMMARY.reportno
  is '报告编号';
comment on column XA_GUARANTEESUMMARY.count
  is '担保笔数';
comment on column XA_GUARANTEESUMMARY.amount
  is '担保金额';
comment on column XA_GUARANTEESUMMARY.balance
  is '担保本金余额';
comment on column XA_GUARANTEESUMMARY.ref_id
  is '查询关联编号';
create index IDX_XA_GUARANTEESUMMARY_001 on XA_GUARANTEESUMMARY (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_GUARANTEESUMMARY_002 on XA_GUARANTEESUMMARY (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_GUARANTEESUMMARY to LIBRA;

prompt Creating XA_HEADER...
create table XA_HEADER
(
  reportno         VARCHAR2(32) not null,
  querytime        VARCHAR2(20),
  reportcreatetime VARCHAR2(20),
  name             VARCHAR2(300),
  certtype         VARCHAR2(300),
  certno           VARCHAR2(300),
  queryreason      VARCHAR2(300),
  queryformat      VARCHAR2(300),
  queryorg         VARCHAR2(300),
  usercode         VARCHAR2(300),
  queryresultcue   VARCHAR2(1000),
  ref_id           VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_HEADER
  is '报告头';
comment on column XA_HEADER.reportno
  is '报告编号';
comment on column XA_HEADER.querytime
  is '查询请求时间';
comment on column XA_HEADER.reportcreatetime
  is '报告生成时间';
comment on column XA_HEADER.name
  is '被查询者姓名';
comment on column XA_HEADER.certtype
  is '被查询者证件类型';
comment on column XA_HEADER.certno
  is '被查询者证件号码';
comment on column XA_HEADER.queryreason
  is '查询原因';
comment on column XA_HEADER.queryformat
  is '查询请求参数';
comment on column XA_HEADER.queryorg
  is '查询机构';
comment on column XA_HEADER.usercode
  is '查询操作员';
comment on column XA_HEADER.queryresultcue
  is '查询结果提示';
comment on column XA_HEADER.ref_id
  is '查询关联编号';
create index IDX_XA_HEADER_001 on XA_HEADER (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_HEADER to LIBRA;

prompt Creating XA_HOUSE_VERIFY_AREA...
create table XA_HOUSE_VERIFY_AREA
(
  id          VARCHAR2(32),
  cityid      VARCHAR2(32),
  areatype    VARCHAR2(32),
  create_date DATE,
  create_by   VARCHAR2(32),
  update_by   VARCHAR2(32),
  update_date DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_HOUSE_VERIFY_AREA
  is '可验证房产地区表';
comment on column XA_HOUSE_VERIFY_AREA.id
  is '主键ID';
comment on column XA_HOUSE_VERIFY_AREA.cityid
  is '地区编号';
comment on column XA_HOUSE_VERIFY_AREA.areatype
  is '类型（1：验证房产证，2：档案）';
comment on column XA_HOUSE_VERIFY_AREA.create_date
  is '创建时间';
comment on column XA_HOUSE_VERIFY_AREA.create_by
  is '作者';
grant select on XA_HOUSE_VERIFY_AREA to LIBRA;

prompt Creating XA_IDENTITY...
create table XA_IDENTITY
(
  reportno          VARCHAR2(32) not null,
  gender            VARCHAR2(80),
  birthday          VARCHAR2(10),
  maritalstate      VARCHAR2(80),
  mobile            VARCHAR2(20),
  officetelephoneno VARCHAR2(100),
  hometelephoneno   VARCHAR2(100),
  edulevel          VARCHAR2(80),
  edudegree         VARCHAR2(80),
  postaddress       VARCHAR2(200),
  registeredaddress VARCHAR2(200),
  ref_id            VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_IDENTITY
  is '身份信息';
comment on column XA_IDENTITY.reportno
  is '报告编号';
comment on column XA_IDENTITY.gender
  is '性别';
comment on column XA_IDENTITY.birthday
  is '出生日期';
comment on column XA_IDENTITY.maritalstate
  is '婚姻状况';
comment on column XA_IDENTITY.mobile
  is '手机号码';
comment on column XA_IDENTITY.officetelephoneno
  is '单位电话';
comment on column XA_IDENTITY.hometelephoneno
  is '住宅电话';
comment on column XA_IDENTITY.edulevel
  is '学历';
comment on column XA_IDENTITY.edudegree
  is '学位';
comment on column XA_IDENTITY.postaddress
  is '通讯地址';
comment on column XA_IDENTITY.registeredaddress
  is '户籍地址';
comment on column XA_IDENTITY.ref_id
  is '查询关联编号';
create index IDX_XA_IDENTITY_001 on XA_IDENTITY (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_IDENTITY_002 on XA_IDENTITY (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_IDENTITY to LIBRA;

prompt Creating XA_J_COMPULSORY_EXECUTION_RECO...
create table XA_J_COMPULSORY_EXECUTION_RECO
(
  id           VARCHAR2(50),
  reportno     VARCHAR2(50),
  exe_court    VARCHAR2(50),
  case_no      VARCHAR2(50),
  exe_reason   VARCHAR2(100),
  closed_way   VARCHAR2(50),
  filing_time  VARCHAR2(50),
  case_status  VARCHAR2(50),
  app_exe      VARCHAR2(50),
  executed     VARCHAR2(50),
  app_exe_amt  VARCHAR2(50),
  executed_amt VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_J_COMPULSORY_EXECUTION_RECO
  is '简版征信强制执行记录明细';
comment on column XA_J_COMPULSORY_EXECUTION_RECO.id
  is '流水号';
comment on column XA_J_COMPULSORY_EXECUTION_RECO.reportno
  is '关联查询编号';
comment on column XA_J_COMPULSORY_EXECUTION_RECO.exe_court
  is '执行法院';
comment on column XA_J_COMPULSORY_EXECUTION_RECO.case_no
  is '案号';
comment on column XA_J_COMPULSORY_EXECUTION_RECO.exe_reason
  is '执行案由';
comment on column XA_J_COMPULSORY_EXECUTION_RECO.closed_way
  is '结案方式';
comment on column XA_J_COMPULSORY_EXECUTION_RECO.filing_time
  is '立案时间';
comment on column XA_J_COMPULSORY_EXECUTION_RECO.case_status
  is '案件状态';
comment on column XA_J_COMPULSORY_EXECUTION_RECO.app_exe
  is '申请执行标的';
comment on column XA_J_COMPULSORY_EXECUTION_RECO.executed
  is '已执行标的';
comment on column XA_J_COMPULSORY_EXECUTION_RECO.app_exe_amt
  is '申请执行标的金额';
comment on column XA_J_COMPULSORY_EXECUTION_RECO.executed_amt
  is '已执行标的金额';

prompt Creating XA_J_CREDIT_ACCOUNTS...
create table XA_J_CREDIT_ACCOUNTS
(
  id                        VARCHAR2(50) not null,
  reportno                  VARCHAR2(50),
  visa_account              VARCHAR2(10),
  house_account             VARCHAR2(10),
  rest_account              VARCHAR2(10),
  visa_no_overdue_account   VARCHAR2(10),
  house_no_overdue_account  VARCHAR2(10),
  rest_no_overdue_account   VARCHAR2(10),
  visa_yes_overdue_account  VARCHAR2(10),
  house_yes_overdue_account VARCHAR2(10),
  rest_yes_overdue_account  VARCHAR2(10),
  visa_90_overdue_account   VARCHAR2(10),
  house_90_overdue_account  VARCHAR2(10),
  rest_90_overdue_account   VARCHAR2(10),
  visa_guarantee_account    VARCHAR2(10),
  house_guarantee_account   VARCHAR2(10),
  rest_auarantee_account    VARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_J_CREDIT_ACCOUNTS
  is '简版征信信用账户数';
comment on column XA_J_CREDIT_ACCOUNTS.id
  is '流水号';
comment on column XA_J_CREDIT_ACCOUNTS.reportno
  is '关联查询流水号';
comment on column XA_J_CREDIT_ACCOUNTS.visa_account
  is '信用卡账户数';
comment on column XA_J_CREDIT_ACCOUNTS.house_account
  is '购房贷款账户数';
comment on column XA_J_CREDIT_ACCOUNTS.rest_account
  is '其他贷款账户数';
comment on column XA_J_CREDIT_ACCOUNTS.visa_no_overdue_account
  is '信用卡未结清/未销户账户数';
comment on column XA_J_CREDIT_ACCOUNTS.house_no_overdue_account
  is '购房贷款未结清/未销户账户数';
comment on column XA_J_CREDIT_ACCOUNTS.rest_no_overdue_account
  is '其他贷款未结清/未销户账户数';
comment on column XA_J_CREDIT_ACCOUNTS.visa_yes_overdue_account
  is '信用卡发生过逾期的账户数';
comment on column XA_J_CREDIT_ACCOUNTS.house_yes_overdue_account
  is '购房贷款发生过逾期的账户数';
comment on column XA_J_CREDIT_ACCOUNTS.rest_yes_overdue_account
  is '其他贷款发生过逾期的账户数';
comment on column XA_J_CREDIT_ACCOUNTS.visa_90_overdue_account
  is '信用卡发生过90天以上逾期的账户数';
comment on column XA_J_CREDIT_ACCOUNTS.house_90_overdue_account
  is '购房贷款发生过90天以上逾期的账户数';
comment on column XA_J_CREDIT_ACCOUNTS.rest_90_overdue_account
  is '其他贷款发生过90天以上逾期的账户数';
comment on column XA_J_CREDIT_ACCOUNTS.visa_guarantee_account
  is '信用卡为他人担保笔数';
comment on column XA_J_CREDIT_ACCOUNTS.house_guarantee_account
  is '购房贷款为他人担保笔数';
comment on column XA_J_CREDIT_ACCOUNTS.rest_auarantee_account
  is '其他贷款为他人担保笔数';
alter table XA_J_CREDIT_ACCOUNTS
  add constraint PK_XA_J_CREDIT_ACCOUNTS primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating XA_J_GUARANTEE_OTHERS...
create table XA_J_GUARANTEE_OTHERS
(
  id              VARCHAR2(50),
  reportno        VARCHAR2(50),
  guarantor       VARCHAR2(50),
  guarantee_date  DATE,
  guarantee_place VARCHAR2(100),
  card_type       VARCHAR2(50),
  card_num        VARCHAR2(50),
  loan_type       VARCHAR2(50),
  loan_count      VARCHAR2(50),
  guarantee_count VARCHAR2(50),
  due_date        DATE,
  balance         VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_J_GUARANTEE_OTHERS
  is '简版征信为他人担保记录明细';
comment on column XA_J_GUARANTEE_OTHERS.id
  is '流水号';
comment on column XA_J_GUARANTEE_OTHERS.reportno
  is '关联查询编号';
comment on column XA_J_GUARANTEE_OTHERS.guarantor
  is '为谁担保';
comment on column XA_J_GUARANTEE_OTHERS.guarantee_date
  is '担保日期';
comment on column XA_J_GUARANTEE_OTHERS.guarantee_place
  is '担保地址';
comment on column XA_J_GUARANTEE_OTHERS.card_type
  is '证件类型 ';
comment on column XA_J_GUARANTEE_OTHERS.card_num
  is '证件号';
comment on column XA_J_GUARANTEE_OTHERS.loan_type
  is '贷款类型';
comment on column XA_J_GUARANTEE_OTHERS.loan_count
  is '贷款额';
comment on column XA_J_GUARANTEE_OTHERS.guarantee_count
  is '担保额 ';
comment on column XA_J_GUARANTEE_OTHERS.due_date
  is '截至日期 ';
comment on column XA_J_GUARANTEE_OTHERS.balance
  is '余额 ';

prompt Creating XA_J_HEADER...
create table XA_J_HEADER
(
  reportno         VARCHAR2(50) not null,
  name             VARCHAR2(50),
  certtype         VARCHAR2(50),
  certno           VARCHAR2(50),
  querytime        VARCHAR2(50),
  reportcreatetime VARCHAR2(50),
  marriage         VARCHAR2(50),
  cardid           VARCHAR2(50),
  apply_no         VARCHAR2(50),
  create_date      DATE,
  create_by        VARCHAR2(50),
  update_date      VARCHAR2(50),
  update_by        DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_J_HEADER
  is '征信简版报告头';
comment on column XA_J_HEADER.reportno
  is '报告编号';
comment on column XA_J_HEADER.name
  is '被查询者姓名';
comment on column XA_J_HEADER.certtype
  is '被查询者证件类型';
comment on column XA_J_HEADER.certno
  is '被查询者证件号码';
comment on column XA_J_HEADER.querytime
  is '查询请求时间';
comment on column XA_J_HEADER.reportcreatetime
  is '报告生成时间';
comment on column XA_J_HEADER.marriage
  is '婚姻状况';
comment on column XA_J_HEADER.cardid
  is '身份证号码';
comment on column XA_J_HEADER.apply_no
  is '申请号';
comment on column XA_J_HEADER.create_date
  is '创建时间';
comment on column XA_J_HEADER.create_by
  is '创建人';
comment on column XA_J_HEADER.update_date
  is '更新时间';
comment on column XA_J_HEADER.update_by
  is '更新人';
alter table XA_J_HEADER
  add constraint PK_XA_J_HEADER primary key (REPORTNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating XA_J_HOUSE_INFO...
create table XA_J_HOUSE_INFO
(
  id                 VARCHAR2(50) not null,
  reportno           VARCHAR2(50),
  bank               VARCHAR2(100),
  release_date       DATE,
  release_count      VARCHAR2(50),
  account_type       VARCHAR2(50),
  loan_type          VARCHAR2(50),
  deadline           DATE,
  due_date           DATE,
  is_delq            VARCHAR2(50),
  balance            VARCHAR2(50),
  overdue_amount     VARCHAR2(50),
  delq_l5y_amt       VARCHAR2(50),
  delq_l5y_90day_amt VARCHAR2(50),
  settle_date        VARCHAR2(50),
  status             VARCHAR2(50),
  sts_happen_date    DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_J_HOUSE_INFO
  is '简版征信购房贷款信息';
comment on column XA_J_HOUSE_INFO.id
  is '流水号';
comment on column XA_J_HOUSE_INFO.reportno
  is '关联查询编号';
comment on column XA_J_HOUSE_INFO.bank
  is '放贷银行';
comment on column XA_J_HOUSE_INFO.release_date
  is '放贷日期';
comment on column XA_J_HOUSE_INFO.release_count
  is '发放金额，默认 0 ';
comment on column XA_J_HOUSE_INFO.account_type
  is '账户类型 ';
comment on column XA_J_HOUSE_INFO.loan_type
  is '贷款类型 ';
comment on column XA_J_HOUSE_INFO.deadline
  is '到期日期';
comment on column XA_J_HOUSE_INFO.due_date
  is '截至日期';
comment on column XA_J_HOUSE_INFO.is_delq
  is '是否逾期，Y：逾期，N：
未逾期，默认 N';
comment on column XA_J_HOUSE_INFO.balance
  is '余额 ';
comment on column XA_J_HOUSE_INFO.overdue_amount
  is '逾期金额，默认 0';
comment on column XA_J_HOUSE_INFO.delq_l5y_amt
  is '近五年内逾期数 ';
comment on column XA_J_HOUSE_INFO.delq_l5y_90day_amt
  is '近五年内逾期超过90天数 ';
comment on column XA_J_HOUSE_INFO.settle_date
  is '结清日期';
comment on column XA_J_HOUSE_INFO.status
  is '状态：呆账，止付，冻结';
comment on column XA_J_HOUSE_INFO.sts_happen_date
  is '状态发生时间 ';
alter table XA_J_HOUSE_INFO
  add constraint PK_XA_J_HOUSE_INFO primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating XA_J_OTHERLOAN...
create table XA_J_OTHERLOAN
(
  id                 VARCHAR2(50) not null,
  reportno           VARCHAR2(50),
  releaser           VARCHAR2(100),
  release_date       DATE,
  release_count      VARCHAR2(50),
  account_type       VARCHAR2(50),
  loan_type          VARCHAR2(50),
  deadline           DATE,
  due_date           DATE,
  is_delq            VARCHAR2(50),
  balance            VARCHAR2(50),
  delq_l5y_amt       VARCHAR2(50),
  delq_l5y_90day_amt VARCHAR2(50),
  settle_date        VARCHAR2(50),
  overdue_amount     VARCHAR2(50),
  status             VARCHAR2(50),
  sts_happen_date    DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_J_OTHERLOAN
  is '简版征信其他贷款信息';
comment on column XA_J_OTHERLOAN.id
  is '流水号';
comment on column XA_J_OTHERLOAN.reportno
  is '关联查询编号';
comment on column XA_J_OTHERLOAN.releaser
  is '发放机构';
comment on column XA_J_OTHERLOAN.release_date
  is '发放日期';
comment on column XA_J_OTHERLOAN.release_count
  is '发放金额';
comment on column XA_J_OTHERLOAN.account_type
  is '账户类型';
comment on column XA_J_OTHERLOAN.loan_type
  is '贷款类型';
comment on column XA_J_OTHERLOAN.deadline
  is '到期日期';
comment on column XA_J_OTHERLOAN.due_date
  is '截至日期';
comment on column XA_J_OTHERLOAN.is_delq
  is '是否逾期，Y：逾期，N：
未逾期，默认未逾期';
comment on column XA_J_OTHERLOAN.balance
  is '余额';
comment on column XA_J_OTHERLOAN.delq_l5y_amt
  is '近五年内逾期数';
comment on column XA_J_OTHERLOAN.delq_l5y_90day_amt
  is '近五年内逾期超过90天数';
comment on column XA_J_OTHERLOAN.settle_date
  is '结清日期';
comment on column XA_J_OTHERLOAN.overdue_amount
  is '逾期金额';
comment on column XA_J_OTHERLOAN.status
  is '状态：止付，呆账，冻结';
comment on column XA_J_OTHERLOAN.sts_happen_date
  is '状态发生时间';
alter table XA_J_OTHERLOAN
  add constraint PK_XA_J_OTHERLOAN primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating XA_J_QUERYRECORD...
create table XA_J_QUERYRECORD
(
  id             VARCHAR2(50) not null,
  reportno       VARCHAR2(50),
  type           VARCHAR2(50),
  query_time     VARCHAR2(50),
  query_id       VARCHAR2(50),
  query_operator VARCHAR2(200),
  query_reason   VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_J_QUERYRECORD
  is '简版征信查询记录';
comment on column XA_J_QUERYRECORD.id
  is '流水号';
comment on column XA_J_QUERYRECORD.reportno
  is '关联查询编号';
comment on column XA_J_QUERYRECORD.type
  is '类型：0：个人查询，1：机
构查询';
comment on column XA_J_QUERYRECORD.query_time
  is '查询时间';
comment on column XA_J_QUERYRECORD.query_id
  is '查询编号 ';
comment on column XA_J_QUERYRECORD.query_operator
  is '查询操作员';
comment on column XA_J_QUERYRECORD.query_reason
  is '查询原因 ';
alter table XA_J_QUERYRECORD
  add constraint PK_XA_J_QUERYRECORD primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating XA_J_VISA_INFO...
create table XA_J_VISA_INFO
(
  id                      VARCHAR2(50) not null,
  reportno                VARCHAR2(50),
  bank                    VARCHAR2(50),
  release_date            DATE,
  card_type               VARCHAR2(50),
  account_type            VARCHAR2(50),
  due_date                DATE,
  credit_amt              VARCHAR2(50),
  used_amt                VARCHAR2(50),
  over_due_amount         VARCHAR2(50),
  is_delq                 VARCHAR2(50),
  delq_l5y_amt            VARCHAR2(50),
  delq_l5y_90day_amt      VARCHAR2(50),
  cancell_date            DATE,
  is_active               VARCHAR2(50),
  status                  VARCHAR2(50),
  sts_happen_date         DATE,
  balance                 VARCHAR2(50),
  is_overdraft            VARCHAR2(50),
  overdraft_balance       VARCHAR2(50),
  overdraft_l5y_60day_amt VARCHAR2(50),
  overdraft_l5y_90day_amt VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_J_VISA_INFO
  is '简版征信信用卡信息';
comment on column XA_J_VISA_INFO.id
  is '流水号';
comment on column XA_J_VISA_INFO.reportno
  is '关联查询编号';
comment on column XA_J_VISA_INFO.bank
  is '发行银行';
comment on column XA_J_VISA_INFO.release_date
  is '发行日期  ';
comment on column XA_J_VISA_INFO.card_type
  is '卡类型 ';
comment on column XA_J_VISA_INFO.account_type
  is '账户类型';
comment on column XA_J_VISA_INFO.due_date
  is '截止日期';
comment on column XA_J_VISA_INFO.credit_amt
  is '信用额度，默认 0';
comment on column XA_J_VISA_INFO.used_amt
  is '已使用额度，默认 0 ';
comment on column XA_J_VISA_INFO.over_due_amount
  is '逾期额度，默认 0 ';
comment on column XA_J_VISA_INFO.is_delq
  is '是否逾期，Y：逾期，N：未
逾期，默认 N';
comment on column XA_J_VISA_INFO.delq_l5y_amt
  is '近五年内逾期数';
comment on column XA_J_VISA_INFO.delq_l5y_90day_amt
  is '近五年内逾期超过 90 天数';
comment on column XA_J_VISA_INFO.cancell_date
  is '注销日期';
comment on column XA_J_VISA_INFO.is_active
  is '是否激活，Y：激活，N：未
激活，默认 Y';
comment on column XA_J_VISA_INFO.status
  is '状态：呆账，冻结，止付 ';
comment on column XA_J_VISA_INFO.sts_happen_date
  is '状态发生时间 ';
comment on column XA_J_VISA_INFO.balance
  is '余额 ';
comment on column XA_J_VISA_INFO.is_overdraft
  is '是否透支，Y：透支；N 未透支';
comment on column XA_J_VISA_INFO.overdraft_balance
  is '透支余额';
comment on column XA_J_VISA_INFO.overdraft_l5y_60day_amt
  is '发生透支超过 60 天的次数';
comment on column XA_J_VISA_INFO.overdraft_l5y_90day_amt
  is '透支超过 90 天次数';
alter table XA_J_VISA_INFO
  add constraint PK_XA_J_VISA_INFO primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating XA_LATEST5YEAROVERDUEDETAIL...
create table XA_LATEST5YEAROVERDUEDETAIL
(
  reportno   VARCHAR2(32) not null,
  account    VARCHAR2(50),
  ref_id     VARCHAR2(32) not null,
  month      VARCHAR2(10),
  lastmonths NUMBER(20),
  amount     NUMBER(24,6),
  biztype    VARCHAR2(30),
  sortno     NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_LATEST5YEAROVERDUEDETAIL
  is '逾期记录明细';
comment on column XA_LATEST5YEAROVERDUEDETAIL.reportno
  is '报告编号';
comment on column XA_LATEST5YEAROVERDUEDETAIL.account
  is '业务号';
comment on column XA_LATEST5YEAROVERDUEDETAIL.ref_id
  is '查询关联编号';
comment on column XA_LATEST5YEAROVERDUEDETAIL.month
  is '逾期月份';
comment on column XA_LATEST5YEAROVERDUEDETAIL.lastmonths
  is '逾期持续月数';
comment on column XA_LATEST5YEAROVERDUEDETAIL.amount
  is '逾期金额';
comment on column XA_LATEST5YEAROVERDUEDETAIL.biztype
  is '信用类型';
comment on column XA_LATEST5YEAROVERDUEDETAIL.sortno
  is '编号';
create index IDX_XA_L5YODUEDETAIL_001 on XA_LATEST5YEAROVERDUEDETAIL (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_L5YODUEDETAIL_002 on XA_LATEST5YEAROVERDUEDETAIL (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_LATEST5YEAROVERDUEDETAIL to LIBRA;

prompt Creating XA_LATEST5YEAROVERDUERECORD...
create table XA_LATEST5YEAROVERDUERECORD
(
  reportno   VARCHAR2(32) not null,
  account    VARCHAR2(50) not null,
  beginmonth VARCHAR2(10),
  endmonth   VARCHAR2(10),
  ref_id     VARCHAR2(32),
  biztype    VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_LATEST5YEAROVERDUERECORD
  is '逾期记录';
comment on column XA_LATEST5YEAROVERDUERECORD.reportno
  is '报告编号';
comment on column XA_LATEST5YEAROVERDUERECORD.account
  is '业务号';
comment on column XA_LATEST5YEAROVERDUERECORD.beginmonth
  is '起始月';
comment on column XA_LATEST5YEAROVERDUERECORD.endmonth
  is '截止月';
comment on column XA_LATEST5YEAROVERDUERECORD.ref_id
  is '查询关联编号';
comment on column XA_LATEST5YEAROVERDUERECORD.biztype
  is '信用类型';
create index IDX_XA_L5YODUERECORD_001 on XA_LATEST5YEAROVERDUERECORD (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_L5YODUERECORD_002 on XA_LATEST5YEAROVERDUERECORD (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_LATEST5YEAROVERDUERECORD to LIBRA;

prompt Creating XA_LOANCARDINFO...
create table XA_LOANCARDINFO
(
  sharecreditlimitamount    NUMBER(24,6),
  usedcreditlimitamount     NUMBER(24,6),
  latest6monthusedavgamount NUMBER(24,6),
  usedhighestamount         NUMBER(24,6),
  scheduledpaymentamount    NUMBER(24,6),
  scheduledpaymentdate      VARCHAR2(10),
  actualpaymentamount       NUMBER(24,6),
  recentpaydate             VARCHAR2(10),
  curroverduecyc            NUMBER(20),
  curroverdueamount         NUMBER(24,6),
  reportno                  VARCHAR2(32) not null,
  ref_id                    VARCHAR2(32) not null,
  biztype                   VARCHAR2(30) not null,
  account                   VARCHAR2(50) not null,
  cue                       VARCHAR2(1000),
  financeorg                VARCHAR2(100),
  currency                  VARCHAR2(50),
  opendate                  VARCHAR2(20),
  creditlimitamount         NUMBER(24,6),
  guaranteetype             VARCHAR2(100),
  state                     VARCHAR2(100),
  stateenddate              VARCHAR2(10),
  beginmonth                VARCHAR2(10),
  endmonth                  VARCHAR2(10),
  balance                   NUMBER(24,6),
  badbalance                NUMBER(24),
  loanacctstate             VARCHAR2(32),
  sortno                    NUMBER,
  repaymentstatus24         VARCHAR2(10),
  repaymentstatus23         VARCHAR2(10),
  repaymentstatus22         VARCHAR2(10),
  repaymentstatus21         VARCHAR2(10),
  repaymentstatus20         VARCHAR2(10),
  repaymentstatus19         VARCHAR2(10),
  repaymentstatus18         VARCHAR2(10),
  repaymentstatus17         VARCHAR2(10),
  repaymentstatus16         VARCHAR2(10),
  repaymentstatus15         VARCHAR2(10),
  repaymentstatus14         VARCHAR2(10),
  repaymentstatus13         VARCHAR2(10),
  repaymentstatus12         VARCHAR2(10),
  repaymentstatus11         VARCHAR2(10),
  repaymentstatus10         VARCHAR2(10),
  repaymentstatus9          VARCHAR2(10),
  repaymentstatus8          VARCHAR2(10),
  repaymentstatus7          VARCHAR2(10),
  repaymentstatus6          VARCHAR2(10),
  repaymentstatus5          VARCHAR2(10),
  repaymentstatus4          VARCHAR2(10),
  repaymentstatus3          VARCHAR2(10),
  repaymentstatus2          VARCHAR2(10),
  repaymentstatus1          VARCHAR2(10),
  latest24state             VARCHAR2(24)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_LOANCARDINFO
  is '贷记卡信息';
comment on column XA_LOANCARDINFO.sharecreditlimitamount
  is '共享额度';
comment on column XA_LOANCARDINFO.usedcreditlimitamount
  is '已用额度';
comment on column XA_LOANCARDINFO.latest6monthusedavgamount
  is '最近6个月平均使用额度';
comment on column XA_LOANCARDINFO.usedhighestamount
  is '最大使用额度';
comment on column XA_LOANCARDINFO.scheduledpaymentamount
  is '本月应还款';
comment on column XA_LOANCARDINFO.scheduledpaymentdate
  is '账单日';
comment on column XA_LOANCARDINFO.actualpaymentamount
  is '本月实还款';
comment on column XA_LOANCARDINFO.recentpaydate
  is '最近一次还款日期';
comment on column XA_LOANCARDINFO.curroverduecyc
  is '当前逾期期数';
comment on column XA_LOANCARDINFO.curroverdueamount
  is '当前逾期金额';
comment on column XA_LOANCARDINFO.reportno
  is '报告编号';
comment on column XA_LOANCARDINFO.ref_id
  is '查询关联编号';
comment on column XA_LOANCARDINFO.biztype
  is '类型';
comment on column XA_LOANCARDINFO.account
  is '业务号';
comment on column XA_LOANCARDINFO.cue
  is '描述';
comment on column XA_LOANCARDINFO.financeorg
  is '发卡机构';
comment on column XA_LOANCARDINFO.currency
  is '币种';
comment on column XA_LOANCARDINFO.opendate
  is '发卡日期';
comment on column XA_LOANCARDINFO.creditlimitamount
  is '授信额度';
comment on column XA_LOANCARDINFO.guaranteetype
  is '担保方式';
comment on column XA_LOANCARDINFO.state
  is '贷款状态';
comment on column XA_LOANCARDINFO.stateenddate
  is '状态截止日';
comment on column XA_LOANCARDINFO.beginmonth
  is '还款起始月';
comment on column XA_LOANCARDINFO.endmonth
  is '还款截止月';
comment on column XA_LOANCARDINFO.balance
  is '余额';
comment on column XA_LOANCARDINFO.loanacctstate
  is '帐户状态';
comment on column XA_LOANCARDINFO.sortno
  is '编号';
comment on column XA_LOANCARDINFO.repaymentstatus24
  is '24还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus23
  is '23还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus22
  is '22还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus21
  is '21还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus20
  is '20还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus19
  is '19还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus18
  is '18还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus17
  is '17还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus16
  is '16还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus15
  is '15还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus14
  is '14还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus13
  is '13还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus12
  is '12还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus11
  is '11还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus10
  is '10还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus9
  is '9还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus8
  is '8还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus7
  is '7还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus6
  is '6还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus5
  is '5还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus4
  is '4还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus3
  is '3还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus2
  is '2还款状态';
comment on column XA_LOANCARDINFO.repaymentstatus1
  is '1还款状态';
create index IDX_XA_LOANCARDINFO_001 on XA_LOANCARDINFO (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_LOANCARDINFO_002 on XA_LOANCARDINFO (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_LOANCARDINFO to LIBRA;

prompt Creating XA_LOANDETAIL...
create table XA_LOANDETAIL
(
  id                    VARCHAR2(64) not null,
  trans_no              VARCHAR2(64),
  apply_no              VARCHAR2(40),
  loan_amt              NUMBER(24,6),
  loan_term             INTEGER,
  overdue_amt           NUMBER(24,6),
  overdue_inte_amt      NUMBER(24,6),
  overdue_fine_amt      NUMBER(24,6),
  overdue_compdinte_amt NUMBER(24,6),
  overdue_date          VARCHAR2(10),
  overdue_days          INTEGER,
  loan_status           VARCHAR2(10),
  loan_finish_date      VARCHAR2(10),
  file_id               VARCHAR2(64) not null,
  status                VARCHAR2(10),
  normalbalance         NUMBER(24,6),
  executerate           NUMBER(24,6),
  inputdate             VARCHAR2(10),
  partner_code          VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_LOANDETAIL
  is '借据明细信息';
comment on column XA_LOANDETAIL.id
  is '主键';
comment on column XA_LOANDETAIL.trans_no
  is '交易流水号';
comment on column XA_LOANDETAIL.apply_no
  is '小安申请编号';
comment on column XA_LOANDETAIL.loan_amt
  is '贷款金额';
comment on column XA_LOANDETAIL.loan_term
  is '期限';
comment on column XA_LOANDETAIL.overdue_amt
  is '当前逾期本金';
comment on column XA_LOANDETAIL.overdue_inte_amt
  is '逾期利息';
comment on column XA_LOANDETAIL.overdue_fine_amt
  is '逾期罚息';
comment on column XA_LOANDETAIL.overdue_compdinte_amt
  is '逾期复利';
comment on column XA_LOANDETAIL.overdue_date
  is '当前逾期日期';
comment on column XA_LOANDETAIL.overdue_days
  is '逾期天数';
comment on column XA_LOANDETAIL.loan_status
  is '贷款状态(10表示正常,20表示逾期,30表示提前结清,40表示代偿结清)';
comment on column XA_LOANDETAIL.loan_finish_date
  is '贷款结清日期';
comment on column XA_LOANDETAIL.file_id
  is '文件ID';
comment on column XA_LOANDETAIL.status
  is '处理状态(0:未处理、1:已处理、2:处理失败)';
comment on column XA_LOANDETAIL.normalbalance
  is '正常本金余额';
comment on column XA_LOANDETAIL.executerate
  is '执行利率';
comment on column XA_LOANDETAIL.inputdate
  is '录入日期';
comment on column XA_LOANDETAIL.partner_code
  is '资金方';
create index IDX_XA_LOANDETAIL_APPLY_NO on XA_LOANDETAIL (APPLY_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_LOANDETAIL_FILE_ID on XA_LOANDETAIL (FILE_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index IDX_XA_LOANDETAIL_ID on XA_LOANDETAIL (ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_LOANDETAIL_TRANS_NO on XA_LOANDETAIL (TRANS_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table XA_LOANDETAIL
  add constraint PK_XA_LOANDETAIL primary key (ID);
grant select on XA_LOANDETAIL to LIBRA;

prompt Creating XA_LOANINFO...
create table XA_LOANINFO
(
  class5state            VARCHAR2(32),
  balance                NUMBER(24,6),
  remainpaymentcyc       NUMBER(20),
  scheduledpaymentamount NUMBER(24,6),
  scheduledpaymentdate   VARCHAR2(10),
  actualpaymentamount    NUMBER(24,6),
  recentpaydate          VARCHAR2(10),
  curroverduecyc         NUMBER(20),
  curroverdueamount      NUMBER(24,6),
  overdue31to60amount    NUMBER(24,6),
  overdue61to90amount    NUMBER(24,6),
  overdue91to180amount   NUMBER(24,6),
  overdueover180amount   NUMBER(24,6),
  reportno               VARCHAR2(32) not null,
  ref_id                 VARCHAR2(32) not null,
  biztype                VARCHAR2(10) not null,
  cue                    VARCHAR2(1000),
  financeorg             VARCHAR2(100),
  account                VARCHAR2(50) not null,
  type                   VARCHAR2(100),
  currency               VARCHAR2(50),
  opendate               VARCHAR2(40),
  enddate                VARCHAR2(40),
  creditlimitamount      NUMBER(24,6),
  guaranteetype          VARCHAR2(100),
  paymentrating          VARCHAR2(100),
  paymentcyc             VARCHAR2(100),
  state                  VARCHAR2(100),
  stateenddate           VARCHAR2(10),
  stateendmonth          VARCHAR2(40),
  beginmonth             VARCHAR2(40),
  endmonth               VARCHAR2(40),
  badbalance             NUMBER(24),
  loanacctstate          VARCHAR2(32),
  sortno                 NUMBER,
  repaymentstatus24      VARCHAR2(10),
  repaymentstatus23      VARCHAR2(10),
  repaymentstatus22      VARCHAR2(10),
  repaymentstatus21      VARCHAR2(10),
  repaymentstatus20      VARCHAR2(10),
  repaymentstatus19      VARCHAR2(10),
  repaymentstatus18      VARCHAR2(10),
  repaymentstatus17      VARCHAR2(10),
  repaymentstatus16      VARCHAR2(10),
  repaymentstatus15      VARCHAR2(10),
  repaymentstatus14      VARCHAR2(10),
  repaymentstatus13      VARCHAR2(10),
  repaymentstatus12      VARCHAR2(10),
  repaymentstatus11      VARCHAR2(10),
  repaymentstatus10      VARCHAR2(10),
  repaymentstatus9       VARCHAR2(10),
  repaymentstatus8       VARCHAR2(10),
  repaymentstatus7       VARCHAR2(10),
  repaymentstatus6       VARCHAR2(10),
  repaymentstatus5       VARCHAR2(10),
  repaymentstatus4       VARCHAR2(10),
  repaymentstatus3       VARCHAR2(10),
  repaymentstatus2       VARCHAR2(10),
  repaymentstatus1       VARCHAR2(10),
  latest24state          VARCHAR2(24)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_LOANINFO
  is '贷款信息';
comment on column XA_LOANINFO.class5state
  is '五级分类';
comment on column XA_LOANINFO.balance
  is '本金余额';
comment on column XA_LOANINFO.remainpaymentcyc
  is '剩余还款期数';
comment on column XA_LOANINFO.scheduledpaymentamount
  is '本月应还款';
comment on column XA_LOANINFO.scheduledpaymentdate
  is '应还款日';
comment on column XA_LOANINFO.actualpaymentamount
  is '本月实还款';
comment on column XA_LOANINFO.recentpaydate
  is '最近一次还款日期';
comment on column XA_LOANINFO.curroverduecyc
  is '当前逾期期数';
comment on column XA_LOANINFO.curroverdueamount
  is '当前逾期金额';
comment on column XA_LOANINFO.overdue31to60amount
  is '逾期31—60天未还本金';
comment on column XA_LOANINFO.overdue61to90amount
  is '逾期61－90天未还本金';
comment on column XA_LOANINFO.overdue91to180amount
  is '逾期91－180天未还本金';
comment on column XA_LOANINFO.overdueover180amount
  is '逾期180天以上未还本金';
comment on column XA_LOANINFO.reportno
  is '报告编号';
comment on column XA_LOANINFO.ref_id
  is '查询关联编号';
comment on column XA_LOANINFO.biztype
  is '类型';
comment on column XA_LOANINFO.cue
  is '描述信息';
comment on column XA_LOANINFO.financeorg
  is '贷款机构';
comment on column XA_LOANINFO.account
  is '业务号';
comment on column XA_LOANINFO.type
  is '贷款种类细分';
comment on column XA_LOANINFO.currency
  is '币种';
comment on column XA_LOANINFO.opendate
  is '发放日期';
comment on column XA_LOANINFO.enddate
  is '到期日期';
comment on column XA_LOANINFO.creditlimitamount
  is '合同金额';
comment on column XA_LOANINFO.guaranteetype
  is '担保方式';
comment on column XA_LOANINFO.paymentrating
  is '还款频率';
comment on column XA_LOANINFO.paymentcyc
  is '还款期数';
comment on column XA_LOANINFO.state
  is '贷款状态';
comment on column XA_LOANINFO.stateenddate
  is '状态截止日';
comment on column XA_LOANINFO.stateendmonth
  is '状态截止月';
comment on column XA_LOANINFO.beginmonth
  is '还款起始月';
comment on column XA_LOANINFO.endmonth
  is '还款截止月';
comment on column XA_LOANINFO.badbalance
  is '呆账余额';
comment on column XA_LOANINFO.loanacctstate
  is '帐户状态';
comment on column XA_LOANINFO.sortno
  is '编号';
comment on column XA_LOANINFO.repaymentstatus24
  is '24还款状态';
comment on column XA_LOANINFO.repaymentstatus23
  is '23还款状态';
comment on column XA_LOANINFO.repaymentstatus22
  is '22还款状态';
comment on column XA_LOANINFO.repaymentstatus21
  is '21还款状态';
comment on column XA_LOANINFO.repaymentstatus20
  is '20还款状态';
comment on column XA_LOANINFO.repaymentstatus19
  is '19还款状态';
comment on column XA_LOANINFO.repaymentstatus18
  is '18还款状态';
comment on column XA_LOANINFO.repaymentstatus17
  is '17还款状态';
comment on column XA_LOANINFO.repaymentstatus16
  is '16还款状态';
comment on column XA_LOANINFO.repaymentstatus15
  is '15还款状态';
comment on column XA_LOANINFO.repaymentstatus14
  is '14还款状态';
comment on column XA_LOANINFO.repaymentstatus13
  is '13还款状态';
comment on column XA_LOANINFO.repaymentstatus12
  is '12还款状态';
comment on column XA_LOANINFO.repaymentstatus11
  is '11还款状态';
comment on column XA_LOANINFO.repaymentstatus10
  is '10还款状态';
comment on column XA_LOANINFO.repaymentstatus9
  is '9还款状态';
comment on column XA_LOANINFO.repaymentstatus8
  is '8还款状态';
comment on column XA_LOANINFO.repaymentstatus7
  is '7还款状态';
comment on column XA_LOANINFO.repaymentstatus6
  is '6还款状态';
comment on column XA_LOANINFO.repaymentstatus5
  is '5还款状态';
comment on column XA_LOANINFO.repaymentstatus4
  is '4还款状态';
comment on column XA_LOANINFO.repaymentstatus3
  is '3还款状态';
comment on column XA_LOANINFO.repaymentstatus2
  is '2还款状态';
comment on column XA_LOANINFO.repaymentstatus1
  is '1还款状态';
create index IDX_XA_LOANINFO_001 on XA_LOANINFO (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_LOANINFO_002 on XA_LOANINFO (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_LOANINFO to LIBRA;

prompt Creating XA_LOANINFO_OVERDUE...
create table XA_LOANINFO_OVERDUE
(
  reportno          VARCHAR2(32) not null,
  ref_id            VARCHAR2(32) not null,
  biztype           VARCHAR2(10),
  beginmonth        VARCHAR2(40),
  endmonth          VARCHAR2(40),
  repaymentstatus60 VARCHAR2(10),
  repaymentstatus59 VARCHAR2(10),
  repaymentstatus58 VARCHAR2(10),
  repaymentstatus57 VARCHAR2(10),
  repaymentstatus56 VARCHAR2(10),
  repaymentstatus55 VARCHAR2(10),
  repaymentstatus54 VARCHAR2(10),
  repaymentstatus53 VARCHAR2(10),
  repaymentstatus52 VARCHAR2(10),
  repaymentstatus51 VARCHAR2(10),
  repaymentstatus50 VARCHAR2(10),
  repaymentstatus49 VARCHAR2(10),
  repaymentstatus48 VARCHAR2(10),
  repaymentstatus47 VARCHAR2(10),
  repaymentstatus46 VARCHAR2(10),
  repaymentstatus45 VARCHAR2(10),
  repaymentstatus44 VARCHAR2(10),
  repaymentstatus43 VARCHAR2(10),
  repaymentstatus42 VARCHAR2(10),
  repaymentstatus41 VARCHAR2(10),
  repaymentstatus40 VARCHAR2(10),
  repaymentstatus39 VARCHAR2(10),
  repaymentstatus38 VARCHAR2(10),
  repaymentstatus37 VARCHAR2(10),
  repaymentstatus36 VARCHAR2(10),
  repaymentstatus35 VARCHAR2(10),
  repaymentstatus34 VARCHAR2(10),
  repaymentstatus33 VARCHAR2(10),
  repaymentstatus32 VARCHAR2(10),
  repaymentstatus31 VARCHAR2(10),
  repaymentstatus30 VARCHAR2(10),
  repaymentstatus29 VARCHAR2(10),
  repaymentstatus28 VARCHAR2(10),
  repaymentstatus27 VARCHAR2(10),
  repaymentstatus26 VARCHAR2(10),
  repaymentstatus25 VARCHAR2(10),
  repaymentstatus24 VARCHAR2(10),
  repaymentstatus23 VARCHAR2(10),
  repaymentstatus22 VARCHAR2(10),
  repaymentstatus21 VARCHAR2(10),
  repaymentstatus20 VARCHAR2(10),
  repaymentstatus19 VARCHAR2(10),
  repaymentstatus18 VARCHAR2(10),
  repaymentstatus17 VARCHAR2(10),
  repaymentstatus16 VARCHAR2(10),
  repaymentstatus15 VARCHAR2(10),
  repaymentstatus14 VARCHAR2(10),
  repaymentstatus13 VARCHAR2(10),
  repaymentstatus12 VARCHAR2(10),
  repaymentstatus11 VARCHAR2(10),
  repaymentstatus10 VARCHAR2(10),
  repaymentstatus9  VARCHAR2(10),
  repaymentstatus8  VARCHAR2(10),
  repaymentstatus7  VARCHAR2(10),
  repaymentstatus6  VARCHAR2(10),
  repaymentstatus5  VARCHAR2(10),
  repaymentstatus4  VARCHAR2(10),
  repaymentstatus3  VARCHAR2(10),
  repaymentstatus2  VARCHAR2(10),
  repaymentstatus1  VARCHAR2(10),
  create_by         VARCHAR2(100),
  create_date       DATE,
  update_by         VARCHAR2(100),
  update_date       DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_LOANINFO_OVERDUE
  is '征信贷款贷记卡24期逾期汇总表';
comment on column XA_LOANINFO_OVERDUE.reportno
  is '报告编号';
comment on column XA_LOANINFO_OVERDUE.ref_id
  is '查询关联编号';
comment on column XA_LOANINFO_OVERDUE.biztype
  is '类型';
comment on column XA_LOANINFO_OVERDUE.beginmonth
  is '还款起始月';
comment on column XA_LOANINFO_OVERDUE.endmonth
  is '还款截止月';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus60
  is '60还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus59
  is '59还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus58
  is '58还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus57
  is '57还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus56
  is '56还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus55
  is '55还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus54
  is '54还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus53
  is '53还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus52
  is '52还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus51
  is '51还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus50
  is '50还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus49
  is '49还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus48
  is '48还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus47
  is '47还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus46
  is '46还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus45
  is '45还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus44
  is '44还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus43
  is '43还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus42
  is '42还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus41
  is '41还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus40
  is '40还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus39
  is '39还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus38
  is '38还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus37
  is '37还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus36
  is '36还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus35
  is '35还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus34
  is '34还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus33
  is '33还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus32
  is '32还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus31
  is '31还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus30
  is '30还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus29
  is '29还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus28
  is '28还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus27
  is '27还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus26
  is '26还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus25
  is '25还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus24
  is '24还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus23
  is '23还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus22
  is '22还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus21
  is '21还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus20
  is '20还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus19
  is '19还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus18
  is '18还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus17
  is '17还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus16
  is '16还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus15
  is '15还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus14
  is '14还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus13
  is '13还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus12
  is '12还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus11
  is '11还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus10
  is '10还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus9
  is '9还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus8
  is '8还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus7
  is '7还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus6
  is '6还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus5
  is '5还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus4
  is '4还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus3
  is '3还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus2
  is '2还款状态';
comment on column XA_LOANINFO_OVERDUE.repaymentstatus1
  is '1还款状态';
comment on column XA_LOANINFO_OVERDUE.create_by
  is '创建人';
comment on column XA_LOANINFO_OVERDUE.create_date
  is '创建日期';
comment on column XA_LOANINFO_OVERDUE.update_by
  is '更新人';
comment on column XA_LOANINFO_OVERDUE.update_date
  is '更新日期';
create index IX_XA_LOANINFO_OVERDUE_01 on XA_LOANINFO_OVERDUE (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IX_XA_LOANINFO_OVERDUE_02 on XA_LOANINFO_OVERDUE (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_LOANINFO_OVERDUE to LIBRA;

prompt Creating XA_LOANINFO_OVERDUE_COUNT...
create table XA_LOANINFO_OVERDUE_COUNT
(
  reportno         VARCHAR2(32) not null,
  ref_id           VARCHAR2(32) not null,
  biztype          VARCHAR2(10),
  repaymentcount60 VARCHAR2(10),
  repaymentcount59 VARCHAR2(10),
  repaymentcount58 VARCHAR2(10),
  repaymentcount57 VARCHAR2(10),
  repaymentcount56 VARCHAR2(10),
  repaymentcount55 VARCHAR2(10),
  repaymentcount54 VARCHAR2(10),
  repaymentcount53 VARCHAR2(10),
  repaymentcount52 VARCHAR2(10),
  repaymentcount51 VARCHAR2(10),
  repaymentcount50 VARCHAR2(10),
  repaymentcount49 VARCHAR2(10),
  repaymentcount48 VARCHAR2(10),
  repaymentcount47 VARCHAR2(10),
  repaymentcount46 VARCHAR2(10),
  repaymentcount45 VARCHAR2(10),
  repaymentcount44 VARCHAR2(10),
  repaymentcount43 VARCHAR2(10),
  repaymentcount42 VARCHAR2(10),
  repaymentcount41 VARCHAR2(10),
  repaymentcount40 VARCHAR2(10),
  repaymentcount39 VARCHAR2(10),
  repaymentcount38 VARCHAR2(10),
  repaymentcount37 VARCHAR2(10),
  repaymentcount36 VARCHAR2(10),
  repaymentcount35 VARCHAR2(10),
  repaymentcount34 VARCHAR2(10),
  repaymentcount33 VARCHAR2(10),
  repaymentcount32 VARCHAR2(10),
  repaymentcount31 VARCHAR2(10),
  repaymentcount30 VARCHAR2(10),
  repaymentcount29 VARCHAR2(10),
  repaymentcount28 VARCHAR2(10),
  repaymentcount27 VARCHAR2(10),
  repaymentcount26 VARCHAR2(10),
  repaymentcount25 VARCHAR2(10),
  repaymentcount24 VARCHAR2(10),
  repaymentcount23 VARCHAR2(10),
  repaymentcount22 VARCHAR2(10),
  repaymentcount21 VARCHAR2(10),
  repaymentcount20 VARCHAR2(10),
  repaymentcount19 VARCHAR2(10),
  repaymentcount18 VARCHAR2(10),
  repaymentcount17 VARCHAR2(10),
  repaymentcount16 VARCHAR2(10),
  repaymentcount15 VARCHAR2(10),
  repaymentcount14 VARCHAR2(10),
  repaymentcount13 VARCHAR2(10),
  repaymentcount12 VARCHAR2(10),
  repaymentcount11 VARCHAR2(10),
  repaymentcount10 VARCHAR2(10),
  repaymentcount9  VARCHAR2(10),
  repaymentcount8  VARCHAR2(10),
  repaymentcount7  VARCHAR2(10),
  repaymentcount6  VARCHAR2(10),
  repaymentcount5  VARCHAR2(10),
  repaymentcount4  VARCHAR2(10),
  repaymentcount3  VARCHAR2(10),
  repaymentcount2  VARCHAR2(10),
  repaymentcount1  VARCHAR2(10),
  create_by        VARCHAR2(100),
  create_date      DATE,
  update_by        VARCHAR2(100),
  update_date      DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_LOANINFO_OVERDUE_COUNT
  is '征信贷款贷记卡24期逾期次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.reportno
  is '报告编号';
comment on column XA_LOANINFO_OVERDUE_COUNT.ref_id
  is '查询关联编号';
comment on column XA_LOANINFO_OVERDUE_COUNT.biztype
  is '类型';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount60
  is '60还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount59
  is '59还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount58
  is '58还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount57
  is '57还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount56
  is '56还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount55
  is '55还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount54
  is '54还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount53
  is '53还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount52
  is '52还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount51
  is '51还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount50
  is '50还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount49
  is '49还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount48
  is '48还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount47
  is '47还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount46
  is '46还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount45
  is '45还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount44
  is '44还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount43
  is '43还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount42
  is '42还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount41
  is '41还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount40
  is '40还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount39
  is '39还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount38
  is '38还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount37
  is '37还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount36
  is '36还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount35
  is '35还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount34
  is '34还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount33
  is '33还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount32
  is '32还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount31
  is '31还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount30
  is '30还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount29
  is '29还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount28
  is '28还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount27
  is '27还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount26
  is '26还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount25
  is '25还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount24
  is '24还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount23
  is '23还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount22
  is '22还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount21
  is '21还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount20
  is '20还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount19
  is '19还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount18
  is '18还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount17
  is '17还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount16
  is '16还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount15
  is '15还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount14
  is '14还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount13
  is '13还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount12
  is '12还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount11
  is '11还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount10
  is '10还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount9
  is '9还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount8
  is '8还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount7
  is '7还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount6
  is '6还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount5
  is '5还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount4
  is '4还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount3
  is '3还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount2
  is '2还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.repaymentcount1
  is '1还款次数';
comment on column XA_LOANINFO_OVERDUE_COUNT.create_by
  is '创建人';
comment on column XA_LOANINFO_OVERDUE_COUNT.create_date
  is '创建日期';
comment on column XA_LOANINFO_OVERDUE_COUNT.update_by
  is '更新人';
comment on column XA_LOANINFO_OVERDUE_COUNT.update_date
  is '更新日期';
create index IX_XA_LOANINFO_COUNT_01 on XA_LOANINFO_OVERDUE_COUNT (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IX_XA_LOANINFO_COUNT_02 on XA_LOANINFO_OVERDUE_COUNT (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_LOANINFO_OVERDUE_COUNT to LIBRA;

prompt Creating XA_NC_LOAN_CARD_INFO...
create table XA_NC_LOAN_CARD_INFO
(
  id          VARCHAR2(100) not null,
  fullname    VARCHAR2(100),
  cert_id     VARCHAR2(100),
  card_no     VARCHAR2(100),
  bank_name   VARCHAR2(100),
  create_time DATE,
  channel     VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column XA_NC_LOAN_CARD_INFO.id
  is '主键';
comment on column XA_NC_LOAN_CARD_INFO.fullname
  is '持卡人全名';
comment on column XA_NC_LOAN_CARD_INFO.cert_id
  is '身份证号码';
comment on column XA_NC_LOAN_CARD_INFO.card_no
  is '卡号';
comment on column XA_NC_LOAN_CARD_INFO.bank_name
  is '发卡行';
comment on column XA_NC_LOAN_CARD_INFO.create_time
  is '创建时间';
comment on column XA_NC_LOAN_CARD_INFO.channel
  is '渠道';
alter table XA_NC_LOAN_CARD_INFO
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_NC_LOAN_CARD_INFO to LIBRA;

prompt Creating XA_OVERDUESUMMARY...
create table XA_OVERDUESUMMARY
(
  reportno                    VARCHAR2(32) not null,
  count                       NUMBER(20),
  months                      NUMBER(20),
  highestoverdueamountpermon  NUMBER(24,6),
  maxduration                 NUMBER(20),
  count2                      NUMBER(20),
  months2                     NUMBER(20),
  highestoverdueamountpermon2 NUMBER(24,6),
  maxduration2                NUMBER(20),
  count3                      NUMBER(20),
  months3                     NUMBER(20),
  highestoverdueamountpermon3 NUMBER(24,6),
  maxduration3                NUMBER(20),
  ref_id                      VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_OVERDUESUMMARY
  is '逾期(透支)信息汇总';
comment on column XA_OVERDUESUMMARY.reportno
  is '报告编号';
comment on column XA_OVERDUESUMMARY.count
  is '贷款逾期笔数';
comment on column XA_OVERDUESUMMARY.months
  is '贷款逾期月份数';
comment on column XA_OVERDUESUMMARY.highestoverdueamountpermon
  is '贷款逾期单月最高逾期总额';
comment on column XA_OVERDUESUMMARY.maxduration
  is '贷款逾期最长逾期月数';
comment on column XA_OVERDUESUMMARY.count2
  is '贷记卡逾期笔数';
comment on column XA_OVERDUESUMMARY.months2
  is '贷记卡逾期月份数';
comment on column XA_OVERDUESUMMARY.highestoverdueamountpermon2
  is '贷记卡逾期单月最高逾期总额';
comment on column XA_OVERDUESUMMARY.maxduration2
  is '贷记卡逾期最长逾期月数';
comment on column XA_OVERDUESUMMARY.count3
  is '准贷记卡60天以上透支笔数';
comment on column XA_OVERDUESUMMARY.months3
  is '准贷记卡60天以上透支月份数';
comment on column XA_OVERDUESUMMARY.highestoverdueamountpermon3
  is '准贷记卡60天以上透支单月最高逾期总额';
comment on column XA_OVERDUESUMMARY.maxduration3
  is '准贷记卡60天以上透支最长逾期月数';
comment on column XA_OVERDUESUMMARY.ref_id
  is '查询关联编号';
create index IDX_XA_OVERDUESUMMARY_001 on XA_OVERDUESUMMARY (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_OVERDUESUMMARY_002 on XA_OVERDUESUMMARY (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_OVERDUESUMMARY to LIBRA;

prompt Creating XA_PROFESSIONAL...
create table XA_PROFESSIONAL
(
  reportno        VARCHAR2(32) not null,
  ref_id          VARCHAR2(32) not null,
  employer        VARCHAR2(300),
  employeraddress VARCHAR2(300),
  occupation      VARCHAR2(100),
  industry        VARCHAR2(100),
  duty            VARCHAR2(100),
  title           VARCHAR2(100),
  startyear       VARCHAR2(10),
  gettime         VARCHAR2(10),
  sortno          NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_PROFESSIONAL
  is '职业信息';
comment on column XA_PROFESSIONAL.reportno
  is '报告编号';
comment on column XA_PROFESSIONAL.ref_id
  is '查询关联编号';
comment on column XA_PROFESSIONAL.employer
  is '工作单位';
comment on column XA_PROFESSIONAL.employeraddress
  is '单位地址';
comment on column XA_PROFESSIONAL.occupation
  is '职业';
comment on column XA_PROFESSIONAL.industry
  is '行业';
comment on column XA_PROFESSIONAL.duty
  is '职务';
comment on column XA_PROFESSIONAL.title
  is '职称';
comment on column XA_PROFESSIONAL.startyear
  is '进入本单位年份';
comment on column XA_PROFESSIONAL.gettime
  is '信息更新日期';
comment on column XA_PROFESSIONAL.sortno
  is '编号';
create index IDX_XA_PROFESSIONAL_001 on XA_PROFESSIONAL (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_PROFESSIONAL_002 on XA_PROFESSIONAL (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_PROFESSIONAL to LIBRA;

prompt Creating XA_RECORDDETAIL...
create table XA_RECORDDETAIL
(
  reportno    VARCHAR2(32) not null,
  ref_id      VARCHAR2(32) not null,
  querydate   VARCHAR2(10),
  querier     VARCHAR2(100),
  queryreason VARCHAR2(200),
  sortno      NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_RECORDDETAIL
  is '信贷审批查询记录明细';
comment on column XA_RECORDDETAIL.reportno
  is '报告编号';
comment on column XA_RECORDDETAIL.ref_id
  is '查询关联编号';
comment on column XA_RECORDDETAIL.querydate
  is '查询日期';
comment on column XA_RECORDDETAIL.querier
  is '查询操作员';
comment on column XA_RECORDDETAIL.queryreason
  is '查询原因';
comment on column XA_RECORDDETAIL.sortno
  is '编号';
create index IDX_XA_RECORDDETAIL_001 on XA_RECORDDETAIL (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_RECORDDETAIL_002 on XA_RECORDDETAIL (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_RECORDDETAIL to LIBRA;

prompt Creating XA_RECORDSUMMARY...
create table XA_RECORDSUMMARY
(
  reportno          VARCHAR2(32) not null,
  orgsum1           NUMBER(20),
  orgsum2           NUMBER(20),
  recordsum1        NUMBER(20),
  recordsum2        NUMBER(20),
  towyearrecordsum1 NUMBER(20),
  towyearrecordsum2 NUMBER(20),
  towyearrecordsum3 NUMBER(20),
  recordsumself     NUMBER(20),
  ref_id            VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_RECORDSUMMARY
  is '查询记录汇总';
comment on column XA_RECORDSUMMARY.reportno
  is '报告编号';
comment on column XA_RECORDSUMMARY.orgsum1
  is '最近1个月内的查询机构数(贷款审批)';
comment on column XA_RECORDSUMMARY.orgsum2
  is '最近1个月内的查询机构数(信用卡审批)';
comment on column XA_RECORDSUMMARY.recordsum1
  is '最近1个月内的查询次数(贷款审批)';
comment on column XA_RECORDSUMMARY.recordsum2
  is '最近1个月内的查询次数(信用卡审批)';
comment on column XA_RECORDSUMMARY.towyearrecordsum1
  is '最近2年内的查询次数(贷后管理)';
comment on column XA_RECORDSUMMARY.towyearrecordsum2
  is '最近2年内的查询次数(担保资格审查)';
comment on column XA_RECORDSUMMARY.towyearrecordsum3
  is '最近2年内的查询次数(特约商户实名审查)';
comment on column XA_RECORDSUMMARY.recordsumself
  is '最近1个月内的查询次数(本人查询次数)';
comment on column XA_RECORDSUMMARY.ref_id
  is '查询关联编号';
create index IDX_XA_RECORDSUMMARY_001 on XA_RECORDSUMMARY (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_RECORDSUMMARY_002 on XA_RECORDSUMMARY (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_RECORDSUMMARY to LIBRA;

prompt Creating XA_REPAYBILL...
create table XA_REPAYBILL
(
  id                      VARCHAR2(64) not null,
  trans_no                VARCHAR2(64),
  apply_no                VARCHAR2(40),
  pay_date                VARCHAR2(10),
  seq_id                  INTEGER,
  actualpay_corpus_amt    NUMBER(24,6),
  actualpay_inte_amt      NUMBER(24,6),
  actualpay_fine_amt      NUMBER(24,6),
  actualpay_compdinte_amt NUMBER(24,6),
  file_id                 VARCHAR2(64) not null,
  status                  VARCHAR2(10),
  inputdate               VARCHAR2(10),
  trans_type              VARCHAR2(10),
  partner_code            VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_REPAYBILL
  is '一般还款信息';
comment on column XA_REPAYBILL.id
  is '主键';
comment on column XA_REPAYBILL.trans_no
  is '交易流水号';
comment on column XA_REPAYBILL.apply_no
  is '小安申请编号';
comment on column XA_REPAYBILL.pay_date
  is '还款日期';
comment on column XA_REPAYBILL.seq_id
  is '还款期次';
comment on column XA_REPAYBILL.actualpay_corpus_amt
  is '实还本金';
comment on column XA_REPAYBILL.actualpay_inte_amt
  is '实还利息';
comment on column XA_REPAYBILL.actualpay_fine_amt
  is '实还罚息';
comment on column XA_REPAYBILL.actualpay_compdinte_amt
  is '实还复利';
comment on column XA_REPAYBILL.file_id
  is '文件ID';
comment on column XA_REPAYBILL.status
  is '处理状态(0:未处理、1:已处理、2:处理失败)';
comment on column XA_REPAYBILL.inputdate
  is '录入日期';
comment on column XA_REPAYBILL.trans_type
  is '交易类型';
comment on column XA_REPAYBILL.partner_code
  is '资金方';
create index IDX_XA_REPAYBILL_APPLY_NO on XA_REPAYBILL (APPLY_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_REPAYBILL_FILE_ID on XA_REPAYBILL (FILE_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index IDX_XA_REPAYBILL_ID on XA_REPAYBILL (ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_REPAYBILL_TRANS_NO on XA_REPAYBILL (TRANS_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table XA_REPAYBILL
  add constraint PK_XA_REPAYBILL primary key (ID);
grant select on XA_REPAYBILL to LIBRA;

prompt Creating XA_REPAYFEE_BILL...
create table XA_REPAYFEE_BILL
(
  id                      VARCHAR2(30) not null,
  file_id                 VARCHAR2(30) not null,
  trans_no                VARCHAR2(64),
  trans_type              VARCHAR2(10),
  apply_no                VARCHAR2(30),
  pay_date                VARCHAR2(10),
  seq_id                  INTEGER,
  actualpay_corpus_amt    NUMBER(24,6),
  actualpay_inte_amt      NUMBER(24,6),
  actualpay_fine_amt      NUMBER(24,6),
  actualpay_compdinte_amt NUMBER(24,6),
  actualpay_fee_amt       NUMBER(24,6),
  status                  VARCHAR2(10),
  inputdate               VARCHAR2(10),
  partner_code            VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_REPAYFEE_BILL
  is '一般还款信息（含费用）';
comment on column XA_REPAYFEE_BILL.id
  is '主键';
comment on column XA_REPAYFEE_BILL.file_id
  is '文件ID';
comment on column XA_REPAYFEE_BILL.trans_no
  is '交易流水号';
comment on column XA_REPAYFEE_BILL.trans_type
  is '交易类型';
comment on column XA_REPAYFEE_BILL.apply_no
  is '小安申请编号';
comment on column XA_REPAYFEE_BILL.pay_date
  is '还款日期';
comment on column XA_REPAYFEE_BILL.seq_id
  is '还款期次';
comment on column XA_REPAYFEE_BILL.actualpay_corpus_amt
  is '实还本金';
comment on column XA_REPAYFEE_BILL.actualpay_inte_amt
  is '实还利息';
comment on column XA_REPAYFEE_BILL.actualpay_fine_amt
  is '实还罚息';
comment on column XA_REPAYFEE_BILL.actualpay_compdinte_amt
  is '实还复利';
comment on column XA_REPAYFEE_BILL.actualpay_fee_amt
  is '实还费用';
comment on column XA_REPAYFEE_BILL.status
  is '处理状态(0:未处理、1:已处理、2:处理失败)';
comment on column XA_REPAYFEE_BILL.inputdate
  is '录入日期';
comment on column XA_REPAYFEE_BILL.partner_code
  is '资金方';
create index IDX_XA_REPAYFEE_BILL_APPLY_NO on XA_REPAYFEE_BILL (APPLY_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_REPAYFEE_BILL_FILE_ID on XA_REPAYFEE_BILL (FILE_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_REPAYFEE_BILL_TRANS_NO on XA_REPAYFEE_BILL (TRANS_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table XA_REPAYFEE_BILL
  add constraint PK_XA_REPAYFEE_BILL primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating XA_REPAYFEE_PLAN...
create table XA_REPAYFEE_PLAN
(
  id                 VARCHAR2(30) not null,
  file_id            VARCHAR2(30) not null,
  trans_no           VARCHAR2(64),
  apply_no           VARCHAR2(30),
  seq_id             INTEGER,
  pay_date           VARCHAR2(10),
  pay_corpus_amt     NUMBER(24,6),
  pay_inte_amt       NUMBER(24,6),
  principal_balance  NUMBER(24,6),
  pay_fine_amt       NUMBER(24,6),
  pay_compd_inte_amt NUMBER(24,6),
  pay_amt            NUMBER(24,6),
  pay_fee_amt        NUMBER(24,6),
  status             VARCHAR2(10),
  inputdate          VARCHAR2(10),
  partner_code       VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_REPAYFEE_PLAN
  is '还款计划信息（含费用）';
comment on column XA_REPAYFEE_PLAN.id
  is '主键';
comment on column XA_REPAYFEE_PLAN.file_id
  is '文件ID';
comment on column XA_REPAYFEE_PLAN.trans_no
  is '交易流水号';
comment on column XA_REPAYFEE_PLAN.apply_no
  is '小安申请编号';
comment on column XA_REPAYFEE_PLAN.seq_id
  is '期次';
comment on column XA_REPAYFEE_PLAN.pay_date
  is '应还日期';
comment on column XA_REPAYFEE_PLAN.pay_corpus_amt
  is '应还本金';
comment on column XA_REPAYFEE_PLAN.pay_inte_amt
  is '应还利息';
comment on column XA_REPAYFEE_PLAN.principal_balance
  is '剩余贷款金额';
comment on column XA_REPAYFEE_PLAN.pay_fine_amt
  is '应还罚息';
comment on column XA_REPAYFEE_PLAN.pay_compd_inte_amt
  is '应还复利';
comment on column XA_REPAYFEE_PLAN.pay_amt
  is '应还金额';
comment on column XA_REPAYFEE_PLAN.pay_fee_amt
  is '应还费用';
comment on column XA_REPAYFEE_PLAN.status
  is '处理状态(0:未处理、1:已处理、2:处理失败)';
comment on column XA_REPAYFEE_PLAN.inputdate
  is '录入日期';
comment on column XA_REPAYFEE_PLAN.partner_code
  is '资金方';
create index IDX_XA_REPAYFEE_PLAN_APPLY_NO on XA_REPAYFEE_PLAN (APPLY_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_REPAYFEE_PLAN_FILE_ID on XA_REPAYFEE_PLAN (FILE_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_REPAYFEE_PLAN_TRANS_NO on XA_REPAYFEE_PLAN (TRANS_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table XA_REPAYFEE_PLAN
  add constraint PK_XA_REPAYFEE_PLAN primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating XA_REPAYPLAN...
create table XA_REPAYPLAN
(
  id               VARCHAR2(64) not null,
  trans_no         VARCHAR2(64),
  apply_no         VARCHAR2(40),
  seq_id           INTEGER,
  pay_date         VARCHAR2(10),
  pay_corpus_amt   NUMBER(24,6),
  pay_inte_amt     NUMBER(24,6),
  file_id          VARCHAR2(64) not null,
  status           VARCHAR2(10),
  principalbalance NUMBER(20,2),
  payfineamt       NUMBER(24,6),
  paycompdinteamt  NUMBER(24,6),
  payamt           NUMBER(20,2),
  inputdate        VARCHAR2(10),
  partner_code     VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_REPAYPLAN
  is '还款计划信息';
comment on column XA_REPAYPLAN.id
  is '主键';
comment on column XA_REPAYPLAN.trans_no
  is '交易流水号';
comment on column XA_REPAYPLAN.apply_no
  is '小安申请编号';
comment on column XA_REPAYPLAN.seq_id
  is '期次';
comment on column XA_REPAYPLAN.pay_date
  is '应还日期';
comment on column XA_REPAYPLAN.pay_corpus_amt
  is '应还本金';
comment on column XA_REPAYPLAN.pay_inte_amt
  is '应还利息';
comment on column XA_REPAYPLAN.file_id
  is '文件ID';
comment on column XA_REPAYPLAN.status
  is '处理状态(0:未处理、1:已处理、2:处理失败)';
comment on column XA_REPAYPLAN.principalbalance
  is '剩余贷款金额';
comment on column XA_REPAYPLAN.payfineamt
  is '应还罚息';
comment on column XA_REPAYPLAN.paycompdinteamt
  is '应还复利';
comment on column XA_REPAYPLAN.payamt
  is '应还金额';
comment on column XA_REPAYPLAN.inputdate
  is '录入日期';
comment on column XA_REPAYPLAN.partner_code
  is '资金方';
create index IDX_XA_REPAYPLAN_APPLY_NO on XA_REPAYPLAN (APPLY_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_REPAYPLAN_FILE_ID on XA_REPAYPLAN (FILE_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index IDX_XA_REPAYPLAN_ID on XA_REPAYPLAN (ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_REPAYPLAN_TRANS_NO on XA_REPAYPLAN (TRANS_NO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table XA_REPAYPLAN
  add constraint PK_XA_REPAYPLAN primary key (ID);
grant select on XA_REPAYPLAN to LIBRA;

prompt Creating XA_RESIDENCE...
create table XA_RESIDENCE
(
  reportno      VARCHAR2(32) not null,
  ref_id        VARCHAR2(32) not null,
  address       VARCHAR2(200),
  residencetype VARCHAR2(100),
  gettime       VARCHAR2(10),
  sortno        NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_RESIDENCE
  is '居住信息';
comment on column XA_RESIDENCE.reportno
  is '报告编号';
comment on column XA_RESIDENCE.ref_id
  is '查询关联编号';
comment on column XA_RESIDENCE.address
  is '居住地址';
comment on column XA_RESIDENCE.residencetype
  is '居住状况';
comment on column XA_RESIDENCE.gettime
  is '信息更新日期';
comment on column XA_RESIDENCE.sortno
  is '编号';
create index IDX_XA_RESIDENCE_001 on XA_RESIDENCE (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_RESIDENCE_002 on XA_RESIDENCE (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_RESIDENCE to LIBRA;

prompt Creating XA_SALVATION...
create table XA_SALVATION
(
  reportno      VARCHAR2(32) not null,
  ref_id        VARCHAR2(32) not null,
  personneltype VARCHAR2(300),
  area          VARCHAR2(1000),
  organname     VARCHAR2(1000),
  money         NUMBER(24,6),
  registerdate  VARCHAR2(10),
  passdate      VARCHAR2(10),
  gettime       VARCHAR2(10),
  sortno        NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_SALVATION
  is '低保救助记录';
comment on column XA_SALVATION.reportno
  is '报告编号';
comment on column XA_SALVATION.ref_id
  is '查询关联编号';
comment on column XA_SALVATION.personneltype
  is '人员类别';
comment on column XA_SALVATION.area
  is '所在地';
comment on column XA_SALVATION.organname
  is '工作单位';
comment on column XA_SALVATION.money
  is '家庭月收入';
comment on column XA_SALVATION.registerdate
  is '申请日期';
comment on column XA_SALVATION.passdate
  is '批准日期';
comment on column XA_SALVATION.gettime
  is '信息更新日期';
comment on column XA_SALVATION.sortno
  is '编号';
create index IDX_XA_SALVATION_001 on XA_SALVATION (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_SALVATION_002 on XA_SALVATION (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_SALVATION to LIBRA;

prompt Creating XA_SPECIALTRADE...
create table XA_SPECIALTRADE
(
  reportno       VARCHAR2(32) not null,
  account        VARCHAR2(50),
  ref_id         VARCHAR2(32) not null,
  type           VARCHAR2(100),
  gettime        VARCHAR2(10),
  changingmonths NUMBER(20),
  changingamount NUMBER(24,6),
  content        VARCHAR2(1000),
  account_type   VARCHAR2(10),
  sortno         NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_SPECIALTRADE
  is '特殊交易信息';
comment on column XA_SPECIALTRADE.reportno
  is '报告编号';
comment on column XA_SPECIALTRADE.account
  is '业务号';
comment on column XA_SPECIALTRADE.ref_id
  is '查询关联编号';
comment on column XA_SPECIALTRADE.type
  is '特殊交易类型';
comment on column XA_SPECIALTRADE.gettime
  is '发生日期';
comment on column XA_SPECIALTRADE.changingmonths
  is '变更月数';
comment on column XA_SPECIALTRADE.changingamount
  is '发生金额';
comment on column XA_SPECIALTRADE.content
  is '明细记录';
comment on column XA_SPECIALTRADE.account_type
  is '类型(1.贷款、2.贷记卡、3.准贷记卡)';
comment on column XA_SPECIALTRADE.sortno
  is '编号';
create index IDX_XA_SPECIALTRADE_001 on XA_SPECIALTRADE (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_SPECIALTRADE_002 on XA_SPECIALTRADE (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_SPECIALTRADE to LIBRA;

prompt Creating XA_SPOUSE...
create table XA_SPOUSE
(
  reportno    VARCHAR2(32) not null,
  name        VARCHAR2(80),
  certtype    VARCHAR2(80),
  certno      VARCHAR2(80),
  employer    VARCHAR2(100),
  telephoneno VARCHAR2(30),
  ref_id      VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_SPOUSE
  is '配偶信息';
comment on column XA_SPOUSE.reportno
  is '报告编号';
comment on column XA_SPOUSE.name
  is '姓名';
comment on column XA_SPOUSE.certtype
  is '证件类型';
comment on column XA_SPOUSE.certno
  is '证件号码';
comment on column XA_SPOUSE.employer
  is '工作单位';
comment on column XA_SPOUSE.telephoneno
  is '联系电话';
comment on column XA_SPOUSE.ref_id
  is '查询关联编号';
create index IDX_XA_SPOUSE_001 on XA_SPOUSE (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_SPOUSE_002 on XA_SPOUSE (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_SPOUSE to LIBRA;

prompt Creating XA_STDLOANCARDINFO...
create table XA_STDLOANCARDINFO
(
  sharecreditlimitamount    NUMBER(24,6),
  usedcreditlimitamount     NUMBER(24,6),
  latest6monthusedavgamount NUMBER(24,6),
  usedhighestamount         NUMBER(24,6),
  scheduledpaymentdate      VARCHAR2(10),
  actualpaymentamount       NUMBER(24,6),
  recentpaydate             VARCHAR2(10),
  curroverdueamount         NUMBER(24,6),
  reportno                  VARCHAR2(32) not null,
  ref_id                    VARCHAR2(32) not null,
  biztype                   VARCHAR2(12),
  account                   VARCHAR2(50),
  cue                       VARCHAR2(1000),
  financeorg                VARCHAR2(100),
  currency                  VARCHAR2(50),
  opendate                  VARCHAR2(10),
  creditlimitamount         NUMBER(24,6),
  guaranteetype             VARCHAR2(100),
  state                     VARCHAR2(100),
  badbalance                NUMBER(24,6),
  stateenddate              VARCHAR2(10),
  beginmonth                VARCHAR2(10),
  endmonth                  VARCHAR2(10),
  sortno                    NUMBER,
  repaymentstatus24         VARCHAR2(10),
  repaymentstatus23         VARCHAR2(10),
  repaymentstatus22         VARCHAR2(10),
  repaymentstatus21         VARCHAR2(10),
  repaymentstatus20         VARCHAR2(10),
  repaymentstatus19         VARCHAR2(10),
  repaymentstatus18         VARCHAR2(10),
  repaymentstatus17         VARCHAR2(10),
  repaymentstatus16         VARCHAR2(10),
  repaymentstatus15         VARCHAR2(10),
  repaymentstatus14         VARCHAR2(10),
  repaymentstatus13         VARCHAR2(10),
  repaymentstatus12         VARCHAR2(10),
  repaymentstatus11         VARCHAR2(10),
  repaymentstatus10         VARCHAR2(10),
  repaymentstatus9          VARCHAR2(10),
  repaymentstatus8          VARCHAR2(10),
  repaymentstatus7          VARCHAR2(10),
  repaymentstatus6          VARCHAR2(10),
  repaymentstatus5          VARCHAR2(10),
  repaymentstatus4          VARCHAR2(10),
  repaymentstatus3          VARCHAR2(10),
  repaymentstatus2          VARCHAR2(10),
  repaymentstatus1          VARCHAR2(10),
  loanacctstate             VARCHAR2(100),
  latest24state             VARCHAR2(24)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_STDLOANCARDINFO
  is '准贷记卡信息';
comment on column XA_STDLOANCARDINFO.sharecreditlimitamount
  is '共享额度';
comment on column XA_STDLOANCARDINFO.usedcreditlimitamount
  is '透支额度';
comment on column XA_STDLOANCARDINFO.latest6monthusedavgamount
  is '最近6个月平均透支额度';
comment on column XA_STDLOANCARDINFO.usedhighestamount
  is '最大透支余额';
comment on column XA_STDLOANCARDINFO.scheduledpaymentdate
  is '账单日';
comment on column XA_STDLOANCARDINFO.actualpaymentamount
  is '本月实还款';
comment on column XA_STDLOANCARDINFO.recentpaydate
  is '最近一次还款日期';
comment on column XA_STDLOANCARDINFO.curroverdueamount
  is '透支180天以上未付余额';
comment on column XA_STDLOANCARDINFO.reportno
  is '报告编号';
comment on column XA_STDLOANCARDINFO.ref_id
  is '查询关联编号';
comment on column XA_STDLOANCARDINFO.biztype
  is '类型';
comment on column XA_STDLOANCARDINFO.account
  is '业务号';
comment on column XA_STDLOANCARDINFO.cue
  is '描述';
comment on column XA_STDLOANCARDINFO.financeorg
  is '发卡机构';
comment on column XA_STDLOANCARDINFO.currency
  is '币种';
comment on column XA_STDLOANCARDINFO.opendate
  is '发卡日期';
comment on column XA_STDLOANCARDINFO.creditlimitamount
  is '授信额度';
comment on column XA_STDLOANCARDINFO.guaranteetype
  is '担保方式';
comment on column XA_STDLOANCARDINFO.state
  is '帐户状态';
comment on column XA_STDLOANCARDINFO.badbalance
  is '呆帐余额';
comment on column XA_STDLOANCARDINFO.stateenddate
  is '状态截止日';
comment on column XA_STDLOANCARDINFO.beginmonth
  is '还款起始月';
comment on column XA_STDLOANCARDINFO.endmonth
  is '还款截止月';
comment on column XA_STDLOANCARDINFO.sortno
  is '编号';
comment on column XA_STDLOANCARDINFO.repaymentstatus24
  is '24还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus23
  is '23还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus22
  is '22还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus21
  is '21还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus20
  is '20还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus19
  is '19还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus18
  is '18还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus17
  is '17还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus16
  is '16还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus15
  is '15还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus14
  is '14还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus13
  is '13还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus12
  is '12还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus11
  is '11还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus10
  is '10还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus9
  is '9还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus8
  is '8还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus7
  is '7还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus6
  is '6还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus5
  is '5还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus4
  is '4还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus3
  is '3还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus2
  is '2还款状态';
comment on column XA_STDLOANCARDINFO.repaymentstatus1
  is '1还款状态';
comment on column XA_STDLOANCARDINFO.loanacctstate
  is '帐户状态';
create index IDX_XA_STDLOANCARDINFO_001 on XA_STDLOANCARDINFO (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_STDLOANCARDINFO to LIBRA;

prompt Creating XA_TAXARREAR...
create table XA_TAXARREAR
(
  reportno       VARCHAR2(32) not null,
  ref_id         VARCHAR2(32) not null,
  organname      VARCHAR2(300),
  taxarreaamount NUMBER(24,6),
  revenuedate    VARCHAR2(10),
  sortno         NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_TAXARREAR
  is '欠税记录';
comment on column XA_TAXARREAR.reportno
  is '报告编号';
comment on column XA_TAXARREAR.ref_id
  is '查询关联编号';
comment on column XA_TAXARREAR.organname
  is '主管税务机关';
comment on column XA_TAXARREAR.taxarreaamount
  is '欠税总额';
comment on column XA_TAXARREAR.revenuedate
  is '欠税统计日期';
comment on column XA_TAXARREAR.sortno
  is '编号';
create index IDX_XA_TAXARREAR_001 on XA_TAXARREAR (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_TAXARREAR_002 on XA_TAXARREAR (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_TAXARREAR to LIBRA;

prompt Creating XA_TELPAYMENT...
create table XA_TELPAYMENT
(
  reportno          VARCHAR2(32) not null,
  ref_id            VARCHAR2(32) not null,
  organname         VARCHAR2(300),
  type              VARCHAR2(300),
  registerdate      VARCHAR2(10),
  state             VARCHAR2(100),
  arrearmoney       NUMBER(24,6),
  arrearmonths      VARCHAR2(100),
  gettime           VARCHAR2(10),
  repaymentstatus24 VARCHAR2(10),
  repaymentstatus23 VARCHAR2(10),
  repaymentstatus22 VARCHAR2(10),
  repaymentstatus21 VARCHAR2(10),
  repaymentstatus20 VARCHAR2(10),
  repaymentstatus19 VARCHAR2(10),
  repaymentstatus18 VARCHAR2(10),
  repaymentstatus17 VARCHAR2(10),
  repaymentstatus16 VARCHAR2(10),
  repaymentstatus15 VARCHAR2(10),
  repaymentstatus14 VARCHAR2(10),
  repaymentstatus13 VARCHAR2(10),
  repaymentstatus12 VARCHAR2(10),
  repaymentstatus11 VARCHAR2(10),
  repaymentstatus10 VARCHAR2(10),
  repaymentstatus9  VARCHAR2(10),
  repaymentstatus8  VARCHAR2(10),
  repaymentstatus7  VARCHAR2(10),
  repaymentstatus6  VARCHAR2(10),
  repaymentstatus5  VARCHAR2(10),
  repaymentstatus4  VARCHAR2(10),
  repaymentstatus3  VARCHAR2(10),
  repaymentstatus2  VARCHAR2(10),
  repaymentstatus1  VARCHAR2(10),
  sortno            NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table XA_TELPAYMENT
  is '电信缴费记录';
comment on column XA_TELPAYMENT.reportno
  is '报告编号';
comment on column XA_TELPAYMENT.ref_id
  is '查询关联编号';
comment on column XA_TELPAYMENT.organname
  is '电信运营商';
comment on column XA_TELPAYMENT.type
  is '业务类型';
comment on column XA_TELPAYMENT.registerdate
  is '业务开通日期';
comment on column XA_TELPAYMENT.state
  is '当前缴费状态';
comment on column XA_TELPAYMENT.arrearmoney
  is '当前欠费金额';
comment on column XA_TELPAYMENT.arrearmonths
  is '当前欠费月数';
comment on column XA_TELPAYMENT.gettime
  is '记账年月';
comment on column XA_TELPAYMENT.repaymentstatus24
  is '24还款状态';
comment on column XA_TELPAYMENT.repaymentstatus23
  is '23还款状态';
comment on column XA_TELPAYMENT.repaymentstatus22
  is '22还款状态';
comment on column XA_TELPAYMENT.repaymentstatus21
  is '21还款状态';
comment on column XA_TELPAYMENT.repaymentstatus20
  is '20还款状态';
comment on column XA_TELPAYMENT.repaymentstatus19
  is '19还款状态';
comment on column XA_TELPAYMENT.repaymentstatus18
  is '18还款状态';
comment on column XA_TELPAYMENT.repaymentstatus17
  is '17还款状态';
comment on column XA_TELPAYMENT.repaymentstatus16
  is '16还款状态';
comment on column XA_TELPAYMENT.repaymentstatus15
  is '15还款状态';
comment on column XA_TELPAYMENT.repaymentstatus14
  is '14还款状态';
comment on column XA_TELPAYMENT.repaymentstatus13
  is '13还款状态';
comment on column XA_TELPAYMENT.repaymentstatus12
  is '12还款状态';
comment on column XA_TELPAYMENT.repaymentstatus11
  is '11还款状态';
comment on column XA_TELPAYMENT.repaymentstatus10
  is '10还款状态';
comment on column XA_TELPAYMENT.repaymentstatus9
  is '9还款状态';
comment on column XA_TELPAYMENT.repaymentstatus8
  is '8还款状态';
comment on column XA_TELPAYMENT.repaymentstatus7
  is '7还款状态';
comment on column XA_TELPAYMENT.repaymentstatus6
  is '6还款状态';
comment on column XA_TELPAYMENT.repaymentstatus5
  is '5还款状态';
comment on column XA_TELPAYMENT.repaymentstatus4
  is '4还款状态';
comment on column XA_TELPAYMENT.repaymentstatus3
  is '3还款状态';
comment on column XA_TELPAYMENT.repaymentstatus2
  is '2还款状态';
comment on column XA_TELPAYMENT.repaymentstatus1
  is '1还款状态';
comment on column XA_TELPAYMENT.sortno
  is '编号';
create index IDX_XA_TELPAYMENT_001 on XA_TELPAYMENT (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_TELPAYMENT_002 on XA_TELPAYMENT (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_TELPAYMENT to LIBRA;

prompt Creating XA_UNDESTORYLOANCARD...
create table XA_UNDESTORYLOANCARD
(
  reportno                  VARCHAR2(32) not null,
  financecorpcount          NUMBER(20),
  financeorgcount           NUMBER(20),
  accountcount              NUMBER(20),
  creditlimit               NUMBER(24,6),
  maxcreditlimitperorg      NUMBER(24,6),
  mincreditlimitperorg      NUMBER(24,6),
  usedcreditlimit           NUMBER(24,6),
  latest6monthusedavgamount NUMBER(24,6),
  ref_id                    VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_UNDESTORYLOANCARD
  is '未销户贷记卡信息汇总';
comment on column XA_UNDESTORYLOANCARD.reportno
  is '报告编号';
comment on column XA_UNDESTORYLOANCARD.financecorpcount
  is '发卡法人机构数';
comment on column XA_UNDESTORYLOANCARD.financeorgcount
  is '发卡机构数';
comment on column XA_UNDESTORYLOANCARD.accountcount
  is '账户数';
comment on column XA_UNDESTORYLOANCARD.creditlimit
  is '授信总额';
comment on column XA_UNDESTORYLOANCARD.maxcreditlimitperorg
  is '单家行最高授信额';
comment on column XA_UNDESTORYLOANCARD.mincreditlimitperorg
  is '单家行最低授信额';
comment on column XA_UNDESTORYLOANCARD.usedcreditlimit
  is '已用额度';
comment on column XA_UNDESTORYLOANCARD.latest6monthusedavgamount
  is '最近6个月平均使用额度';
comment on column XA_UNDESTORYLOANCARD.ref_id
  is '查询关联编号';
create index IDX_XA_UNDESTORYLOANCARD_001 on XA_UNDESTORYLOANCARD (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_UNDESTORYLOANCARD_002 on XA_UNDESTORYLOANCARD (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_UNDESTORYLOANCARD to LIBRA;

prompt Creating XA_UNDESTORYSTANDARDLOANCARD...
create table XA_UNDESTORYSTANDARDLOANCARD
(
  reportno                  VARCHAR2(32) not null,
  financecorpcount          NUMBER(20),
  financeorgcount           NUMBER(20),
  accountcount              NUMBER(20),
  creditlimit               NUMBER(24,6),
  maxcreditlimitperorg      NUMBER(24,6),
  mincreditlimitperorg      NUMBER(24,6),
  usedcreditlimit           NUMBER(24,6),
  latest6monthusedavgamount NUMBER(24,6),
  ref_id                    VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_UNDESTORYSTANDARDLOANCARD
  is '未销户准贷记卡信息汇总';
comment on column XA_UNDESTORYSTANDARDLOANCARD.reportno
  is '报告编号';
comment on column XA_UNDESTORYSTANDARDLOANCARD.financecorpcount
  is '发卡法人机构数';
comment on column XA_UNDESTORYSTANDARDLOANCARD.financeorgcount
  is '发卡机构数';
comment on column XA_UNDESTORYSTANDARDLOANCARD.accountcount
  is '账户数';
comment on column XA_UNDESTORYSTANDARDLOANCARD.creditlimit
  is '授信总额';
comment on column XA_UNDESTORYSTANDARDLOANCARD.maxcreditlimitperorg
  is '单家行最高授信额';
comment on column XA_UNDESTORYSTANDARDLOANCARD.mincreditlimitperorg
  is '单家行最低授信额';
comment on column XA_UNDESTORYSTANDARDLOANCARD.usedcreditlimit
  is '透支余额';
comment on column XA_UNDESTORYSTANDARDLOANCARD.latest6monthusedavgamount
  is '最近6个月平均使用额度';
comment on column XA_UNDESTORYSTANDARDLOANCARD.ref_id
  is '查询关联编号';
create index IDX_XA_UOSARDLOANCARD_001 on XA_UNDESTORYSTANDARDLOANCARD (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_UOSARDLOANCARD_002 on XA_UNDESTORYSTANDARDLOANCARD (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_UNDESTORYSTANDARDLOANCARD to LIBRA;

prompt Creating XA_UNPAIDLOAN...
create table XA_UNPAIDLOAN
(
  reportno                  VARCHAR2(32) not null,
  financecorpcount          NUMBER(20),
  financeorgcount           NUMBER(20),
  accountcount              NUMBER(20),
  creditlimit               NUMBER(24,6),
  balance                   NUMBER(24,6),
  latest6monthusedavgamount NUMBER(24,6),
  ref_id                    VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_UNPAIDLOAN
  is '未结清贷款信息汇总';
comment on column XA_UNPAIDLOAN.reportno
  is '报告编号';
comment on column XA_UNPAIDLOAN.financecorpcount
  is '贷款法人机构数';
comment on column XA_UNPAIDLOAN.financeorgcount
  is '贷款机构数';
comment on column XA_UNPAIDLOAN.accountcount
  is '笔数';
comment on column XA_UNPAIDLOAN.creditlimit
  is '合同总额';
comment on column XA_UNPAIDLOAN.balance
  is '余额';
comment on column XA_UNPAIDLOAN.latest6monthusedavgamount
  is '最近6个月平均应还款';
comment on column XA_UNPAIDLOAN.ref_id
  is '查询关联编号';
create index IDX_XA_UNPAIDLOAN_001 on XA_UNPAIDLOAN (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_UNPAIDLOAN_002 on XA_UNPAIDLOAN (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
grant select on XA_UNPAIDLOAN to LIBRA;

prompt Creating XA_VEHICLE...
create table XA_VEHICLE
(
  reportno     VARCHAR2(32) not null,
  ref_id       VARCHAR2(32) not null,
  enginecode   VARCHAR2(300),
  licensecode  VARCHAR2(300),
  brand        VARCHAR2(300),
  cartype      VARCHAR2(300),
  usecharacter VARCHAR2(300),
  state        VARCHAR2(300),
  pledgeflag   VARCHAR2(300),
  gettime      VARCHAR2(10),
  sortno       NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table XA_VEHICLE
  is '车辆交易和抵押记录';
comment on column XA_VEHICLE.reportno
  is '报告编号';
comment on column XA_VEHICLE.ref_id
  is '查询关联编号';
comment on column XA_VEHICLE.enginecode
  is '发动机号';
comment on column XA_VEHICLE.licensecode
  is '车牌号码';
comment on column XA_VEHICLE.brand
  is '品牌';
comment on column XA_VEHICLE.cartype
  is '车辆类型';
comment on column XA_VEHICLE.usecharacter
  is '使用性质';
comment on column XA_VEHICLE.state
  is '车辆状态';
comment on column XA_VEHICLE.pledgeflag
  is '抵押标记';
comment on column XA_VEHICLE.gettime
  is '信息更新日期';
comment on column XA_VEHICLE.sortno
  is '编号';
create index IDX_XA_VEHICLE_001 on XA_VEHICLE (REPORTNO)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_XA_VEHICLE_002 on XA_VEHICLE (REF_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

