package com.tdzx.user.utils;

public class Dictionary {
	
    /**
     * '系统账户id' 1
     */
    public static final Integer kValueSystemAccountId = 1;
    
	/**
	 * '运营帐户'	2	运营帐户'
	 */
	public static final Integer kValueBusinessAccountId = 2;
	
	/**
	 * '扣费帐户'	1101	系统帐户'
	 */
	public static final Integer kValueSystemAccount = 1101;
	

	
	
	/**
	 * '扣费帐户'	1102	'微信'
	 */
	public static final Integer kValuePayTypeWX = 1102;
	
	/**
	 * '扣费帐户'	1103	'支付宝'
	 */
	public static final Integer kValuePayTypeAli = 1103;

	/**
	 * '消息类型'	1201	'系统消息'
	 */
	public static final Integer kMsgValueSystemNotification = 1201;
	
	/**
	 * '消息类型'	1202	'好友申请'
	 */
	public static final Integer kMsgValueFriendApply = 1202;
	
	/**
	 * '消息类型'	1203	'好友退出'
	 */
	public static final Integer kMsgValueFriendSignOut = 1203; 
	
	/**
	 * '消息类型'	1204	'活动报名'
	 */
	public static final Integer kMsgValueAcctivityEnrol = 1204;
	
	/**
	 * '消息类型'	1205	'活动缴费'
	 */
	public static final Integer kMsgValueAcctivityPay = 1205;
	
	/**
	 * '消息类型'	1206	'活动提醒'
	 */
	public static final Integer kMsgValueActivityRemind = 1206;
	
	/**
	 * '消息类型'	1207	'活动取消'
	 */
	public static final Integer kMsgValueActivityCancel = 1207;  
	
	/**
     * '消息类型'   120801    '分享预定-借书方'
     */
    public static final Integer kMsgValueShareBook01 = 120801;
    
	/**
	 * '消息类型'	1208	'分享预定-发布方'
	 */
	public static final Integer kMsgValueShareBook = 1208; 
	
	/**
	 * '消息类型'	1209	'归还通知'
	 */
	public static final Integer kMsgValueSharePay = 1209;  
	
	/**
     * '消息类型'   120901    '归还通知-借书方'
     */
    public static final Integer kMsgValueSharePay01 = 120901;  
	
	/**
	 * '消息类型'	1210	'分享到期'
	 */
	public static final Integer kMsgValueShareExpire = 1210; 
	
	/**
	 * '消息类型'	1211	'分享催还'
	 */
	public static final Integer kMsgValueShareRecalled = 1211;  
	
	/**
	 * '消息类型'	1212	'评论通知'
	 */
	public static final Integer kMsgValueCommentNotification = 1212; 
	
	/**
	 * '消息类型'	1213	'打赏通知'
	 */
	public static final Integer kMsgValueRewardNotification = 1213; 
	
	/**
	 * '消息类型'	1214	'点赞通知'
	 */
	public static final Integer kMsgValueZanNotification = 1214;   
	
	
	/**
     * '消息类型'   1214    新书审核通过通知
     */
    public static final Integer kMsgValueAuditedNotification = 1214;  
    
    
	/**
	 * '消息类型'	1215	审核通知
	 */
	public static final Integer kMsgValueExamineNotification = 1215;  
	
	/**
     * '消息类型'   1216    新书发布通知-发布人
     */
    public static final Integer kMsgValuePubliserNotification = 1216;  
    
    /**
     * '消息类型'   1217    新书发布通知-同学接收
     */
    //public static final Integer kMsgValueAuditorNotification = 1217;  
     public static final Integer kMsgValueClassMateNotification = 1217;  
     
     /**
      * '消息类型'   1221    需求发布通知-同学接收
      */
      public static final Integer kMsgValueClassMateReqNotification = 1221;  
      
      
     
    

	/**
	 * '取消预订通知'	1218	'取消预订-发布方'
	 */
	public static final Integer kMsgValuecancelReservation = 1218;  
	
	/**
     * '取消预订通知' 121801    '取消预订-借书方'
     */
    public static final Integer kMsgValuecancelReservation01 = 121801;  
	
	/**
	 * '业务类型'	1301	活动业务
	 */
	public static final Integer kValueBusinessActivity = 1301;    

	/**
	 * '业务类型'	1302	分享业务
	 */
	public static final Integer kValueBusinessShare1 = 1302;    
	
	
	/**
	 * '业务类型'	1303	圈子业务
	 */
	public static final Integer kValueBusinessCircle = 1303;    
	
	/**
	 * '业务类型'	1304	帐户业务
	 */
	public static final Integer kValueBusinessAccount1 = 1304;  
	
	/**
	 * '凭证科目类型'	1305	凭证科目类型
	 */
	public static final Integer kValueVoucherAccount = 1305;  
	
	

	/**订单类型
	 * '租赁消费类型'	130201
	 */
	public static final Integer kValueShareLease = 130201;   

	/**订单类型
	 * '租赁退还业务类型'	130202
	 */
	public static final Integer kValueShareLeaseReturn = 130202;   

	/**订单类型
	 * '租赁取消业务类型'	130202
	 */
	public static final Integer kValueShareLeaseCancel = 130203;   

	/**订单类型
	 * '消费类型'	130205	'购物'
	 */
	public static final Integer kValueShareShoping = 130205;
	
	/**订单类型
	 * '消费类型'	130206	'续租'
	 */
	public static final Integer kValueShareRenewal = 130206;
	
	/**订单类型
	 * '消费类型'	130207	'分享打赏'
	 */
	public static final Integer kValueShareReward = 130207;
	
	/**订单类型
	 * '消费类型'	130208	'圈子打赏'
	 */
	public static final Integer kValueGroReward = 130208; 

	/**
	 * '消费类型'	130209	'充值'
	 */
	public static final Integer kValueAccountRecharge = 130209;     

	/**
	 * '消费类型'	130210	'提现'
	 */
	public static final Integer kValueAccountWithdrawals = 130210;   
	
	/**
	 * '消费类型'	130211	'购买课程'
	 */
	public static final Integer kValueAccountSalesLesson = 130211;   
	

	
	/**
	 * '凭证科目类型'	130501	'押金'
	 */
	public static final Integer kValueVoucherAccount_Deposit = 130501;   
	
	/**
	 * '凭证科目类型'	130501	'服务费'
	 */
	public static final Integer kValueVoucherAccount_Service = 130518;   
	
	
	/**
	 * '凭证科目类型'	130502	'租金'
	 */
	public static final Integer kValueVoucherAccount_Rent = 130502; 
	
	/**
	 * '凭证科目类型'	130503	'滞纳金'
	 */
	public static final Integer kValueVoucherAccount_LateFee = 130503; 
	
	/**
	 * '凭证科目类型'	130504	'兑换积分'
	 */
	public static final Integer kValueVouch1erAccount_ExchangeFee = 130504; 
	
	/**
	 * '凭证科目类型'	130514	'积分折现'
	 */
	public static final Integer kValueVouch1erAccount_ExchangeDiscounting = 130514; 
	
	
	/**
     * '消费类型'   130505  '赔偿金'
     */
    public static final Integer kValueVoucherAccount_DeductFee = 130505;

	/**
	 * '消费类型'	130506	'押金退费'
	 */
	public static final Integer kValueVoucherAccount_RefundDeposit = 130506;  
	
	/**
	 * '消费类型'	130507	'租金退费'
	 */
	public static final Integer kValueVoucherAccount_RefundRent = 130507;  
	
	/**
     * '消费类型'   130508    '运费退费'
     */
    public static final Integer kValueVoucherAccount_RefundTransFee = 130508;  
	

	/**
	 * '消费类型'	130509	'报名费'
	 */
	public static final Integer kValueVoucherAccount_ActEnrolPay = 130509;   
	
	/**
	 * '消费类型'	130510	'保险费'
	 */
	public static final Integer kValueVoucherAccount_ActInsurancePay = 130510;   

	/**
	 * '消费类型'	130511	'活动打赏'
	 */
	public static final Integer kValueVoucherAccount_ActReward = 130511; 
	/**
	 * '消费类型'	130512	'活动退费'
	 */
	public static final Integer kValueVoucherAccount_ActRefund = 130512;  

	/**
	 * '消费类型'	130513	'分享打赏'
	 */
	public static final Integer kValueVoucherAccount_Reward = 130513;
	
	/**
	 * '消费类型'	130514	'支付宝充值'
	 */
	public static final Integer kValueAccRechargeByAliPay = 130514;     

	/**
	 * '消费类型'	130515	'微信充值'
	 */
	public static final Integer kValueAccRechargeByWXPay = 130515;  
	
	/**
	 * '消费类型'	130516	'支付宝提现'
	 */
	public static final Integer kValueAccWithdrawalsByAliPay = 130516;   
	
	/**
	 * '消费类型'	130517	'微信提现'
	 */
	public static final Integer kValueAccWithdrawalsByWXPay = 130517;  
	
	/**
     * '消费类型'   130405  '会员充值'
     */
    public static final Integer kValueAccAddMember = 130405;  
	
   public static final Integer kValueClassMember =350103;
	
	
	//public static final Integer kValueShaReturn = 130401;     
	
	//public static final Integer kValueShaTake = 130401;     
	
	
	/**
	 * '活动类型'	1401	亲子'
	 */
	public static final Integer kValueFamilyActivity = 1401; 
	
	/**
	 * '活动类型'	1402	体验'
	 */
	public static final Integer kValueTasteActivity = 1402;  
	
	/**
	 * '活动类型'	1403	公益'
	 */
	public static final Integer kValuePublicActivity = 1403; 
	
	/**
	 * '活动类型'	1404	培训'
	 */
	public static final Integer kValueTrainActivity = 1404;           

	/**
	 * '活动模式'	1501	'AA制'
	 */
	public static final Integer kValueAA = 1501;  
	
	/**
	 * '活动模式'	1502	'免费'
	 */
	public static final Integer kValueFree = 1502;         


	/**
	 * '活动发布状态'	1602	报名中'
	 */
	public static final Integer kValueEnroling = 1602;  
	
	/**
	 * '活动发布状态'	1603	进行中'
	 */
	public static final Integer kValueHanding = 1603;  
	
	/**
	 * '活动发布状态'	1604	已结束'
	 */
	public static final Integer kValueActivityReleaseEnd = 1604; 
	
	/**
	 * '活动发布状态'	1605	已取消'
	 */
	public static final Integer kValueCancel = 1605;         

	/**
	 * '活动报名状态'	1701	未缴费'
	 */
	public static final Integer kValueNoPay = 1701;  
	
	/**
	 * '活动报名状态'	1702	已报名'
	 */
	public static final Integer kValueEnroled = 1702;   
	
	/**
	 * '活动报名状态'	1703	已结束'
	 */
	public static final Integer kValueEnrolEnd = 1703; 
	
	/**
	 * '活动报名状态'	1704	已取消'
	 */
	public static final Integer kValueEnrolCancel = 1704;           

	/**
	 * '分享模式'	1801	租用'
	 */
	public static final Integer kValueShareModelRent = 1801;  
	
	/**
	 * '分享模式'	1802	'出售'
	 */
	public static final Integer kValueShareSell = 1802;    
	
	/**
	 * '分享模式'	1803	订阅'
	 */
	public static final Integer kValueShareSubscribe = 1803; 
	

	/**	  
	 * '分享发布状态'	1900	取消订阅
	 */
	public static final Integer kValueCancelBookSubscription = 1900;   
	
	/**
	 * '分享发布状态'	1901	抢订中
	 */
	public static final Integer kValueShareBooking = 1901;     
	
	/**
	 * '分享发布状态'	1902	已预订
	 */
	public static final Integer kValueShareBooked = 1902;  
	
	/**
	 * 分享发布状态'	1903	已借出
	 */
	public static final Integer kValueShareRented = 1903;     
	
	/**
	 * '分享发布状态'	1904	已订阅
	 */
	public static final Integer kValueShareGived = 1904; 
	
	/**
	 * 分享发布状态'	1905	已转让
	 */
	public static final Integer kValueShareTransfered = 1905;  
	
	/**
	 * '分享发布状态'	1906	已下架
	 */
	public static final Integer kValueShareOffSaled = 1906;         

	/**
	 * '分享发布状态'	1907	审核中'
	 */
	public static final Integer kValueAudit = 1907;  

	
	/**
	 * '分享发布状态'	1908	审核失败'
	 */
	public static final Integer kValueFAILAudit = 1908;  
	
	/**
	 * '分享发布状态'	1909	数据被锁定（已被其它用户放入书包）'
	 */
	public static final Integer kValueShareLock = 1909;  
	
	
	
	/**
     *  分享领取状态' 2000    可借阅
     */
    public static final Integer kValueShareGetCanBook = 2000;
    
	/**
	 *  分享领取状态'	2001	已预订
	 */
	public static final Integer kValueShareGetBooked = 2001;
	
	/**
	 * 分享领取状态'	2002	已领取
	 */
	public static final Integer kValueShareGetd = 2002;  
	
	/**
	 * 分享领取状态'	2003	已归还
	 */
	public static final Integer kValueShareGetBacked = 2003; 
	
	/**
	 * 分享领取状态'	2004	已取消
	 */
	public static final Integer kValueShareGetCancel = 2004;          

	/**
	 * 分享领取状态'	2005	预约退书
	 */
	public static final Integer kValueShareGetReservation = 2005;  
	
	/**
     *  分享领取状态' 2006    订书锁定
     */
    public static final Integer kValueShareGetLocked = 2006;
	
    /**
     *  分享领取状态' 2007    订阅的书
     */
    public static final Integer kValueShareGetDelivery = 2007;
	
    
	/**
	 * 物品类型'	2101	'玩具'
	 */
	public static final Integer kValueToy = 2101;  
	
	/**
	 * '物品类型'	2102	'书籍'
	 */
	public static final Integer kValueBooks = 2102;    
	
	/**
	 * '物品类型'	2103	'服饰'
	 */
	public static final Integer kValueClother = 2103; 
	
	/**
	 * '物品类型'	2104	'用品'
	 */
	public static final Integer kValueLifeTool = 2104;          

	
	/**
	 * '积分类型'	2201	'签到'
	 */
	public static final Integer kValueIntegralSign = 2201;    
	
	/**
	 * '积分类型'	2202	发布活动'
	 */
	public static final Integer kValueIntegralReleaseAct = 2202; 
	
	/**
	 * '积分类型'	2203	参与活动'
	 */
	public static final Integer kValueIntegralJoinAct = 2203;
	
	
	/**
	 * '积分类型'	2204	分享图书'   发布并审核成功后加积分
	 */
	public static final Integer kValueIntegralShareBook = 2204;  
	
	/**
	 * '积分类型'	2204	发布分享'   发布的时候不添加积分，完成一批交易后统一加积分
	 */
	public static final Integer kValueIntegralReleaseShare = 220401;   

	/**
	 * '积分类型'	2204	发布分享'   借阅者预订（领取）时，发布者加添分享积分所用类型
	 */
	public static final Integer kValueIntegralReleaseToJoinShare = 220402;   
	
	/**
	 * '积分类型'	2205	参与分享'   借用的时候不添加积分，完成一批交易后统一加积分
	 */
	public static final Integer kValueIntegralJoinShare = 2205;    
	
	/**
	 * '积分类型'	2206	'评论'
	 */
	public static final Integer kValueIntegralComment = 2206;  
	
	/**
	 * '积分类型'	2207	'点赞'
	 */
	public static final Integer kValueIntegralZan = 2207;  
	
	/**
	 * '积分类型'	2208	'打赏'
	 */
	public static final Integer kValueIntegralReward = 2208;
	
	/**
	 * '积分类型'	2209	'发布历程'
	 */
	public static final Integer kValueIntegralReleaseHistory = 2209;  
	
	/**
	 * '积分类型'	2210	'推荐好友'    --测试
	 */
	public static final Integer kValueIntegralRecommenFriends = 2210;  
	
	/**
	 * '积分类型'	2211	注册'     --测试 
	 */
	public static final Integer kValueIntegralRegister = 2211;    
	
	/**
	 * '积分类型'	2212	'发布读后感'       --未实现
	 */
	public static final Integer kValueIntegralReadFeel = 2212;  
	
	/**
	 * '积分类型'	2213	分享到第三方'      --未实现
	 */
	public static final Integer kValueIntegralThirdShare = 2213;   
	
	/**
	 * '积分类型'	2214	'充值'
	 */
	public static final Integer kValueIntegralRechargePoint = 2214;
	
	/**
	 * '积分类型'	2215	'帐号关联'  --暂未启用
	 */
	//public static final Integer kValueAccountAssociation = 2215;
	
	/**
	 * '积分类型'	2216	'评价'
	 */
	public static final Integer kValueIntegralEvaluation = 2216;
	
	/**
	 * '积分类型'	2217	'兑换租金' --暂未启用
	 */
	//public static final Integer kValueIntegralExchange = 2217;
	
	/**
	 * '积分类型'	2218	'配送抵扣'
	 */
	public static final Integer kValueIntegrallogis = 2218;	
	
	/**
	 * '积分类型', '2219', '意见反馈'
	 */
	public static final Integer kValueIntegralAdvice = 2219;	
	
	/**
     * '积分类型', '2220', '积分兑换'
     */
    public static final Integer kValueIntegralBuyGoods = 2220;    

	/**
     * '积分类型', '2220', '借书'
     */
    public static final Integer kValueIntegralBorrowBook = 2221;   
    
    /**
     * '积分类型', '2220', '取消借书'
     */
    public static final Integer kValueCancelBorrowBook = 2222;   
    
    


	/**
	 * '可见性'	2301	'私密'
	 */
	public static final Integer kValuePrivateSee = 2301;  
	
	/**
	 * '可见性'	2302	'朋友可见'
	 */
	public static final Integer kValueFriendSee = 2302;  
	
	/**
	 * '可见性'	2303	'公开'
	 */
	public static final Integer kValuePublicSee = 2303;
	
	/**
	 * '标签类型'	2401	'系统'
	 */
	public static final Integer kValueSystemLabel = 2401;  
	
	
	/**
     * '标签类型'   241001    '全部年龄标签'
     */
    public static final Integer kValueAllAgeLabel = 241001; 
    
    /**
     * '标签类型'   241002    '年龄段标签'
     */
    public static final Integer kValueAgeLabel = 241002; 
    
    /**
     * '标签类型'   241003    '年龄段筛选标签'
     */
    public static final Integer kValueFilterAgeLabel = 241003; 
    
    
    /**
     * '标签类型'   2411    '科普类别标签'
     */
    public static final Integer kValueScienceLabelType = 2411; 
    

	/**
	 * '标签类型'	2402	'活动'
	 */
	public static final Integer kValueActivityLabel = 2402;    
	
	/**
	 * '标签类型'	2403	'分享'
	 */
	public static final Integer kValueShareLabel = 2403; 
	
	/**
	 * '标签类型'	2404	'成长'
	 */
	public static final Integer kValueGroLabel = 2404;
	
	/**
	 * '标签类型'	2405	'玩伴'
	 */
	public static final Integer kValuePlaymateLabel = 2405;   
	
	/**
	 * '标签类型'	2406	'其他'
	 */
	public static final Integer kValueOtherLabel = 2406;    
	

	/**
	 * '帐号类型'	250101	'系统帐户(资金管理)'
	 */
	public static final Integer kValueSystemAcc = 250101;  
	
	/**
	 * '帐号类型'	250102	'内部登陆帐户'
	 */
	public static final Integer kValueInsideAcc = 250102;  
	
	/**
	 * '帐号类型'	250103	'内部审核帐户'
	 */
	public static final Integer kValueAuditingAcc = 250103;  
	
	/**
	 * '帐号类型'	250104	'内部服务帐户'
	 */
	public static final Integer kValueServiceAcc = 250104;  
	
	/**
	 * '帐号类型'	250104	'平台运营帐户'
	 */
	public static final Integer kValueOpearatorAcc = 250105;  

	/**
	 * '平台运营帐户ID'
	 */
	public static final Integer kValueOpearatorAcctID = 2;  
	
	

	/**
	 * '帐号类型'	2501-->2502	'注册帐户'
	 */
	public static final Integer kValueregisterAcc = 2502;
	
	
	/**
	 * '帐号类型'	2501-->250201	'学生注册帐户'
	 */
	public static final Integer kValuestudentAcc = 250201;
	
	
	/**
	 * '帐号类型'	2502-->250202	'教师注册帐户'
	 */
	public static final Integer kValueteacherAcc = 250202;  
	
	/**
	 * '帐号类型'	2503-->250203	'QQ'
	 */
	public static final Integer kValueThirdPartyQQ = 250203; 

	/**
	 * '帐号类型'	2504-->250304	'支付宝'
	 */
	public static final Integer kValueThirdPartyAlipay = 250204;

	/**
	 * '帐号类型'	'运营帐户'
	 */
	public static final Integer kValueThirdPartyOpearator = 250205;
	
	
	/**
	 * '订单状态'	2601	'未支付'
	 */
	public static final Integer kValueOrderUnpaid = 2601;  
	
	/**
	 * '订单状态'	2602	'已支付'
	 */
	public static final Integer kValueOrderPaid = 2602;  
	
	/**
	 * '订单状态'	2603	'已取消'
	 */
	public static final Integer kValueOrderCancelled = 2603;

	/**
	 * ''	2701	'成长类型-成长'
	 */
	public static final Integer kValueGroTypeGrown = 2701;  
	
	/**
	 * ''	2702	'成长类型-阅读'
	 */
	public static final Integer kValueGroTypeShare = 2702;  
	
	/**
	 * ''	2703	'成长类型-活动'
	 */
	public static final Integer kValueGroTypeAct = 2703;
	
	/**
	 * ''	2704	'成长类型-发现英语'
	 */
	public static final Integer kValueEngTypeAct = 2704;
	
	/**
	 * ''	2705	'成长类型-加入班级'
	 */
	public static final Integer kValueJoinTypeAct = 2705;

	/**
	 * ''	2705	'成长类型-阅读计划'
	 */
	public static final Integer kValueReadPlan = 2706;
	
	
	public static final int SLIDE_TYPE_HOME = 280101;
	public static final int SLIDE_TYPE_STUDY = 280102;
	public static final int SLIDE_TYPE_BENEFITS = 280103;
	
	
	
	/**
	 * '默认送货天数'	2901
	 */
	public static final Integer kValueDefDevBookDay = 2901;
	
	/**
	 * '默认取书天数'	2902
	 */
	public static final Integer kValueDefGetBookDay = 2902;
	
	/**
	 * '默认服务地址'	2903
	 */
	public static final Integer kValueDefDevaddress = 2903;
	

	/**
	 * 'TXY编码字符'	2904
	 */
	public static final Integer kValueTXYBookNumber = 2904;

	/**
	 * '书包有效时间'	2905
	 */
	public static final Integer kValueDefBagEffectiveTimer = 2905;
	
	/**
	 * '物流信息'	2906
	 */
	public static final Integer kValueLogisticsInfo= 2906;
	
	
	/**
	 * '等待派送'	3000
	 */
	public static final Integer kValueWaitDeliver = 3000;
	
	
	/**
	 * '已送货'	3001
	 */
	public static final Integer kValueDeliverComplete = 3001;
	
	/**
	 * '已签收'	3002
	 */
	public static final Integer kValueDeliverSign = 3002;
	
	/**
	 * '已回寄'	3003
	 */
	public static final Integer kValueDeliverRecovered = 3003;
	
	/**
	 * '已入库'	3004
	 */
	public static final Integer kValueDeliverStored = 3004;

	/**
	 * '充值业务-充值面额配置'	3101
	 */
	public static final Integer kValueRechargeConfigure = 3101;

	/**
	 * '充值业务-充值规则配置'	3102
	 */
	public static final Integer kValueRechargeRuleConfigure = 3102;
	
	/**
	 * '资金控制开关-授权规则配置'	310301
	 */
	public static final Integer kValueMchPayRuleConfigure = 310301;
	
	/**
     * '业务控制开关-授权规则配置'  310302
     */
    public static final Integer kValueBusinessRuleConfigure = 310302;
    
    /**
     * '扫一扫控制开关-授权规则配置'  310303
     */
    public static final Integer kValueScanRuleConfigure = 310303;

	/**
	 * '查询类型-书名查询'	3201
	 */
	public static final Integer kValueShasearByBookName = 3201;

	/**
	 * '查询类型-条码查询'	3202
	 */
	public static final Integer kValueShasearByISBN = 3202;
	
	
	/**
     * 消息类型：提现 1212
     */
    public static final Integer kValuePay1212 = 1212;
    
    /**
     * 消息类型：充值 1213
     */
    public static final Integer kValuePay1213 = 1213;
    
    /**
     * 消息类型：到期通知 1210
     */
    public static final Integer kValuePay1210 = 1210;
    
    /**
     * 消息类型：催还通知 1211
     */
    public static final Integer kValuePay1211 = 1211;
    
    /**
     * 消息类型：借阅人预约还书通知-发布方 1219
     */
    public static final Integer kValuePay1219 = 1219;
    
    /**
     * 消息类型：借阅人预约还书通知-借书方 121901
     */
    public static final Integer kValuePay121901 = 121901;
    
    /**
     * 消息类型：借阅人取消预约还书通知-发布方 1220
     */
    public static final Integer kValueCancelReturn = 1220;
    
    
    
    /**
     * redis key prefix:children_msg
     */
    public static final String redis_key_prefix = "children_msg";
    
    /**
     * redis_key_sufix_09
     */
    public static final String redis_key_sufix_09 = "09";
    
    /**
     * redis_key_sufix_12
     */
    public static final String redis_key_sufix_12 = "12";
    
    /**
     * redis_key_sufix_15
     */
    public static final String redis_key_sufix_15 = "15";
    
    /**
     * redis_key_sufix_18
     */
    public static final String redis_key_sufix_18 = "18";
    
    /**
     * redis_key_sufix_21
     */
    public static final String redis_key_sufix_21 = "21";
    
    /**
     * redis_key_sufix_10
     */
    public static final String redis_key_sufix_10 = "10";
    
    /**
     * redis_key_sufix_14
     */
    public static final String redis_key_sufix_14 = "14";
    
    /**
     * redis_key_sufix_19
     */
    public static final String redis_key_sufix_19 = "19";
    
    
    /**
     * day_upper_amt:当日充值上限
     */
    public static final int day_upper_amt = 510101;
    
    /**
     * month_upper_amt:当月充值上限
     */
    public static final int month_upper_amt = 510102;
    
    /**
     * 收书时间段:TIME_AREA
     */
    public static final int TIME_AREA = 4001;

    /**
     * 图书运营模式:自营
     */
    public static final int BOOK_OPERATE_TYPE_SELF = 4101;
 
    /**
     * 图书运营模式:书友
     */
    public static final int BOOK_OPERATE_TYPE_CIRCLE = 4102;
    
    
    
    
    /**
     * 图书上架:SHA_BOOK_SHELVES
     */
    public static final int SHA_BOOK_SHELVES = 0;
     
    /**
     * 图书下架:SHA_BOOK_OFF
     */
    public static final int SHA_BOOK_OFFSHELF = 1;
     
    
    
    public static final String AUTO_TOKEN =  "auto_token";
    
    public static final String MACHINE_NAME =  "machine_name";
    
    public static final String MACHINE_CODE =  "machine_code";
    
    public static final String APP_VERSION =  "app_version";
    
    public static final String MACHINE_PLATFORM =  "machine_platform";
    
    
    public static final String COUNT_MYBAG = "countMyBag";
    
    public static final String ACCT_AMT = "acctAmt";
    
    public static final String ACCT_ID = "acctId";
    
//    public static final int scale = 2;
    
    public static final int MSG_TYPE_MULT_LOGIN = 600101;
    
    public static final int MSG_TYPE_BROADCAST = 600102;
    
    
    public static final int ENABLE_TRANS_RULE = 320101;//是否启用快递费控制规则
    
    public static final int RENT_TOTAL_AMOUNT = 32010101;//控制租金总额
    
    public static final int DEPOSIT_TOTAL_AMOUNT = 32010102;//控制押金总额

    public static final Integer ENABLE_ADVANCE_DEDUCTIBLE=32010103;   //是否启用预收抵扣租金
    
    public static final Integer ENABLE_DEPOSIT_DEDUCTIBLE=32010104;   //是否启用提现时零钱扣预借
    
    
    public static final Integer ENABLE_BOOK_SUBSCRIBE=7101;   //是否启用选书活动

    public static final Integer ENABLE_MEMBER_SERVICE=35;   //是否启用会员
    public static final Integer PESON_MEMBER_CHECK_BOOK_NUM=350201;   //个人会员选书数量
    public static final Integer CLASS_MEMBER_CHECK_BOOK_NUM=350202;   //班级会员选书数量
    
    
    
//    public static final int TRANS_FEE_REBACK = 320102;//快递退费
    
    public static final int TRANS_FEE = 320103;//快递费
    
    public static final int COUNT_DOWN_NUMBER = 3401;//充值倒计时
    
    public static final int BOOK_TYPE_2409 = 2409;//图书类别
    
    public static final int RANK_TYPE_241101 = 241101;//榜单
    
    public static final int FIRSTPAGE_PRIVATE_340101 = 340101;//首页大图-热门
    public static final int FIRSTPAGE_PRIVATE_340102 = 340102;//首页大图-新书上架
    public static final int FIRSTPAGE_PRIVATE_340103 = 340103;//首页大图-私人定制
    public static final int FIRSTPAGE_PRIVATE_340104 = 340104;//首页大图-猜你想读
    
    public static final int ROLLING_PIC_TYPE_340201 = 340201;//首页二级页面-热门轮播图
    public static final int ROLLING_PIC_TYPE_340202 = 340202;//首页二级页面-猜你想读轮播图
    
//    public static final int HOME_PAGE_280801 = 280801;//首页
//    public static final int HOME_PAGE_280802 = 280802;//首页
    
    //图书详情页面
    public static final int RESPONSIBILITIES_DESCRIPTION = 420101;//权责声明
    public static final int SHA_QUESTIONS = 420201;//咨询问题
    
    //活动参数设置
    public static final int ACTIVE_ACCT_CHECK_BOOK_NUM = 710101;//选书活动：单用户选书数量
    public static final int ACTIVE_CLASS_CHECK_SAMEBOOK_NUM = 710102;//选书活动：单本图书在班级的可选数量
    public static final int ACTIVE_CLASS_ACTIVEPAGE = 710103;//活动页
    public static final int ACTIVE_CLASS_LIBRARY_REMARK = 710104;//班级移动图书馆介绍页    
    public static final int ACTIVE_ACCT_EN_SHAREBOOK_ADD = 710105;//选书活动：是否启用分享即可多选模式
    
    //合作方案
    public static final int SYNERGISM=8000;
    
    //启动活动页
    public static final int Load_Active_Page=8001;
    
    public static final int USER_SHARE_STATUS_SAVE = 4000;//保存
    public static final int USER_SHARE_STATUS_AUDITING = 4001;//审核中
    public static final int USER_SHARE_STATUS_AUDITED = 4002;//审核通过
    public static final int USER_SHARE_STATUS_NOPASS = 4003;//未通过
    
    //新用户注册首次送5这押金券，老用户分享图书送5-8折随机券
    public static final int DEPOSIT_TICKET_TYPE1 = 360101;//押金券5折
    public static final int DEPOSIT_TICKET_TYPE2 = 360102;//押金券7折
    public static final int DEPOSIT_TICKET_TYPE3 = 360103;//押金券8折
    
    /**
     * '充值业务-充值面额配置=自定义
     */
    public static final Integer kValueRechargeCustom = 310107;
    
    public static final Integer kValueShare2Frieds = 2350;//好友分享
    
    public static final Integer kValueShareBook = 2351;//分享图书
    
    public static final Integer kValueUserRegister = 2352;//用户注册
    
    
    public static final Integer kValueMyBagLimitCnt = 3701;//放入书包上限
    
    public static final Integer BOOK_SUM = 370101;
    public static final Integer BORROW_SUM = 370102;
    public static final Integer ONE_WORD = 370103;
    public static final Integer ONE_WORD_BY_CK = 370104;
    
    
    
    public static final Integer BASE_TRANS_FEE = 370301;//运费基数
    public static final Integer TRANS_FEE_BOOK_BASE_CNT = 370302;//运费借书起步数量
    public static final Integer TRANS_FEE_BY_BASE_MONNEY = 370303;//运费数量递增单价
    
    
    public static final Integer DISTINCT_PRICE = 370201;//用户分享书折旧比率
    
    public static final Integer RENT_PRICE = 370202;//租金费率
    
    public static final Integer ORDER_PROC_DATA_TYPE_AMOUNT = 1;//订单支付成功后数据金额处理 
    
    public static final Integer ORDER_PROC_DATA_TYPE_POINT = 2;//订单支付成功后数据积分处理 
    public static final Integer ORDER_PROC_ACCT_TYPE_SHARE = 1;//订单支付成功后处理分享方数据 
    public static final Integer ORDER_PROC_ACCT_TYPE_RENT = 2;//订单支付成功后处理借用方数据 
    public static final Integer CURR_SEMESTER = 400001;		  //当前学期
    public static final Integer CURR_DISTANCE_LIMIT = 400101; //设置附近查询距离长度（KM）
    public static final Integer CURR_RATE_EXCHANGE=380301;   //积分兑换率设置
    
    public static final Integer MemberBenefits=40000;

	/**
	 * '帐号类型'	2501-->2502	'注册帐户'
	 */

	public static final Integer kValueStudent = 250201;
	public static final Integer kValueTeacher = 250202;
	public static final Integer kValueSchool = 250203;
	public static final Integer kValueEdu = 250204;

	/**
	 * 评论类型：评论图书
	 */
	public static final Integer COMMENT_BOOK = 7201;

	/**
	 * 教学资源类型根id
	 */
	public static final String TEACHING_RESOURCE_ROOT_ID = "xsc13";

	/**
	 * 热门
	 */
	public static final String HOT = "hot";
	/**
	 * 历史
	 */
	public static final String HISTORY = "history";
}
