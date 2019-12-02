package com.tdzx.user.utils;

import java.util.HashMap;
import java.util.Map;

public class Constant<main> {

	/**
	 * 应用ID
	 */
	public static final String APPLICATION_ID = "32c15d1c9ed44ff686d1eeb5cf39f630";
	/**
	 * 应用ID
	 */
	public static final String PLATFORM_ADMIN_NUMBER = "123";
	/**
	 * 充值类型
	 */
	public static final Map<Integer, String> PAY_TYPE = new HashMap<Integer, String>();
	static {
		PAY_TYPE.put(Dictionary.kValueAccRechargeByAliPay, "支付宝充值");
		PAY_TYPE.put(Dictionary.kValueAccRechargeByWXPay, "微信充值");
		PAY_TYPE.put(Dictionary.kValueAccWithdrawalsByAliPay, "支付宝提现");
		PAY_TYPE.put(Dictionary.kValueAccWithdrawalsByWXPay, "微信提现");

		PAY_TYPE.put(Dictionary.kValueGroReward, "打赏");
		PAY_TYPE.put(Dictionary.kValueShareRenewal, "续租");
	};

	public static final Map<String, String> PERIODS_TYPE = new HashMap<String, String>();
	static {
		PERIODS_TYPE.put("1", "一期绘本");
		PERIODS_TYPE.put("2", "二期绘本");
		PERIODS_TYPE.put("3", "三期绘本");
		PERIODS_TYPE.put("4", "四期绘本");
		PERIODS_TYPE.put("5", "五期绘本");
		PERIODS_TYPE.put("6", "六期绘本");
		PERIODS_TYPE.put("7", "七期绘本");
		PERIODS_TYPE.put("8", "八期绘本");
	};

    /**
	 * 随机
	 */
	public static String IS_SUER = "12345646";
	
	/**
	 * 密钥
	 */
	public static String str = "$#dsfsd&%RGDE^7*gdfe#$dsfs%##gfd";
	
	
	/**
	 * 登陆失效时间
	 */
	public static Long ExpirationDate = 1000 * 60 * 60 * 24 * 365 * 5l;

	/**
	 * 19位时间格式化
	 */
	public static final String DATE_FORMAT_19 = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 22位时间格式化
	 */
	public static final String DATE_FORMAT_22 = "yyyy-MM-dd HH:mm:ss.SSS";
	
	/**
	 * 10位时间格式化
	 */
	public static final String DATE_FORMAT_10 = "yyyy-MM-dd";

	/**
	 * 数字一百
	 */
	public static final Integer NUM_HUNDRED = 100;
	
	/**
     * 数字101
     */
    public static final Integer NUM_101 = 101;
	
	/**
	 * 数字零
	 */
	public static final Integer NUM_ZERO = 0;

	/**
	 * 数字一
	 */
	public static final Integer NUM_ONE = 1;
	
	/**
	 * 数字二
	 */
	public static final Integer NUM_TWO = 2;

	/**
	 * 数字三
	 */
	public static final Integer NUM_THREE = 3;
	
	/**
	 * 数字四
	 */
	public static final Integer NUM_FOUR = 4;
	
	/**
	 * 数字五
	 */
	public static final Integer NUM_FIVE = 5;
	
	/**
	 * 数字六
	 */
	public static final Integer NUM_SIX = 6;
	
	/**
	 * 数字七
	 */
	public static final Integer NUM_SEVEN = 7;
	
	/**
	 * 数字八
	 */
	public static final Integer NUM_EIGHT = 8;

	/**
	 * 历程
	 */
	public static final String LABEL_TYPE_GRO = "GRO";

	/**
	 * 活动
	 */
	public static final String LABEL_TYPE_ACT = "ACT";

	/**
	 * 分享
	 */
	public static final String LABEL_TYPE_TOY = "TOY";

	/**
	 * 其他
	 */
	public static final String LABEL_TYPE_OTHER = "OTHER";

	/**
	 * 每页记录条数
	 */
	public static final Integer PAGE_SIZE = 10;

	public static final Integer PAGE_SIZE_12 = 12;

	public static final Integer PAGE_SIZE_15 = 15;

	public static final Integer PAGE_SIZE_18 = 18;

	public static final Integer PAGE_SIZE_150 = 150;
	
	/**
	 * 详情页面评论，点赞，打赏记录条数
	 */
	public static final Integer DETAIL_SIZE = 10;
	
	/**
	 * 金额默认值
	 */
	public static final Double MONEY_DUFAULT = 0.0;

	/**
	 * 金额与积分兑换比例
	 */
	public static final Integer MONEY_INTEG_CONVERT  = 100;

	
	/**
	 * UTF-8编码
	 */
	public static final String UTF8 = "utf-8";
	
	/**
	 * cookie失效时间
	 */
	public static final Integer COOKIE_TIME = 60*60*24*7;
	
	/**
	 * 积分添加方式：固定值
	 */
	public static final String POINT_ADDTYPE_FIXED = "固定值";
	
	/**
	 * 积分添加方式：百分比
	 */
	public static final String POINT_ADDTYPE_PERCENT  = "百分比";
	
	
	/**
	 * 登陆失败
	 */
	public static final String LOGIN_FAIL = "登陆失败，请重新登陆";
	
	/**
	 * 验证签名失败
	 */
	public static final String SIGN_FAIL = "验证签名失败";
	
	/**
	 * 验证是否来自支付宝的通知失败
	 */
	public static final String RESPONSE_FAIL = "验证是否来自支付宝的通知失败";
	
	/**
	 * 订单已发货，无法取消预订
	 */
	public static final String ORDER_DELIVERY = "订单已发货无法取消所预订的图书";
	
	
	/**
	 * 没有通知消息
	 */
	public static final String NO_NOTIFY_MESSAGE = "没有通知消息";

	/**
	 * 成长打赏
	 */
	public static final String GRO_REWARD = "groReward";
	
	/**
	 * 分享打赏
	 */
	public static final String SHA_REWARD = "shaReward";
	
	/**
	 * 分享我要取/还
	 */
	public static final String SHA_TAKE = "shaTake";
	
	/**
	 * 充值
	 */
	public static final String ACC_RECHARGE = "accRecharge";
	
	/**
	 * 订单失效时间
	 */
	public static final String ORDER_FAILURE_TIME = "30m";
	
	/**
	 * 字符串连接符
	 */
	public static final String JOIN_SYMBOL = ",";
	
	/**
	 * 接收者名称
	 */
	public static final String RECEIVE_NAME = "#fReceiveAcctName#";
	
	/**
     * 发布者名称
     */
    public static final String SHAREA_CCT_NAME = "#shareAcctName#";
	
	/**
	 * 预定时间
	 */
	public static final String RESERVE_DATE = "#fReserveDate#";
	
	/**
     * 当前系统时间
     */
    public static final String CURRENTTIME = "#currentTime#";
	
	/**
	 * 分享主题
	 */
	public static final String SUBJECT = "#fSubject#";
	
	/**
     * 上门取书时间
     */
    public static final String GETBOOKTIME = "#getBookTime#";
	
	/**
	 * 分享押金
	 */
	public static final String DEPOSIT = "#fDeposit#";
	
	/**
	 * 归还时间
	 */
	public static final String RETURN_DATE = "#fReturnDate#";
	
	/**
	 * 消费金额
	 */
	public static final String AMOUNT_FEE = "#fAmountFee#";
	
	/**
	 * 发送者昵称
	 */
	public static final String SEND_NAME = "#fSendAcctName#";
	
	/**
     * 金额
     */
    public static final String AMOUNT = "#amount#";
    
    /**
     * 支付方式
     */
    public static final String PAYTYPE = "#payType#";
    
    /**
     * 时间
     */
    public static final String TIME = "#time#";
    
    /**
     * 到期时间BORROWDATE
     */
    public static final String BORROWDATE = "#borrowDate#";
    
    /**
     * 书名 bookName
     */
    public static final String BOOKNAME = "#bookName#";
    
    /**
     * 剩余天数 leftDay
     */
    public static final String LEFTDAY = "#leftDay#";
    
	
	public static final String GRO_CONTENTINFO = "我今天阅读了一本书，书名是：";
	
	public static final String GRO_SHARETOLABLEINFO = "阅读";
	
	/**
	 * 订单主题
	 */
	public static final String ORDER_SUBJECT = "借书订单";
	
	/**
     * 订单主题-还书订单
     */
	public static final String ORDER_SUBJECT_RETURN_BOOK =  "还书订单";
	
	/**
     * 订单主题-取消预订
     */
	public static final String ORDER_SUBJECT_CANCEL_BOOK =  "取消预订";

	/**
	 * 同学名 classmate
	 */
	public static final String CLASSMATE = "#classmate#";
	/**
     * 个人账户提现
     */
    public static final String ORDER_SUBJECT_GET_MONEY = "个人账户提现";

    /**
     * 课程购买
     */
    public static final String COURSE_BUY = "课程购买";

	/**
	 * 用户已存在
	 */
	public static final String USER_EXIT = "用户已存在";
	/**
	 * 用户已存在
	 */
	public static final String WEB_USER_EXIT = "手机号码已注册，请直接登录。";
	/**
	 * 用户已存在
	 */
	public static final String NOT_USER_EXIT = "用户不存在";

    /**
     * 个人账户充值
     */
    public static final String ORDER_SUBJECT_SET_MONEY = "个人账户充值";
    
    /**
     * 生成凭证时，如果没有项目id，则传参用这个888888
     */
    public static final Integer PRJ_888888 = 888888;
    
    /**
     * 付款方显示姓名（最长支持100个英文/50个汉字）。如：上海交通卡退款
     */
    public static final String PAYER_SHOW_NAME = "童心缘";
    
    /**
     * 转账备注（支持200个英文/100个汉字）。如：转账备注
     */
    public static final String ALIPAY_REMARK = "童心缘账户-个人提现";
    
    public static final String STATUS = "status";
    
    public static final String DATA = "data";
    
    public static final String STATUS_SUCCESS = "SUCCESS";
    
    public static final String STATUS_FAILED = "FAILED";
    
    public static final String MORE_FAILED = "MOREFAILED";
    
    public static final String MSG = "msg";
    
    /**
     * 第三方的订单id
     */
    public static final String THIRD_ORDER_ID = "third_order_id";
    
    public static final String ALIPAY_CHIESE_NAME = "支付宝";
    
    public static final String RTN_AMOUNT = "amount";
    
    /**
     * 可提现金额
     */
    public static final String ENABLE_AMT = "enableAmt";
    
    /**
     * 币种
     */
    public static final String CURRENCY_TXB = "币";
    
    /**
     * 金额显示小数位数:AMT_SCALE_DISPLAY:1
     */
    public static int AMT_SCALE_DISPLAY = 1;
    
    /**
     * 童心币不需要小数
     */
    public static int TXB_SCALE_DISPLAY = 0;
    
    /**
     * 金额存储小数位数:AMT_SCALE_SAVE:2
     */
    public static int AMT_SCALE_SAVE = 2;
    
    /**
     * 平台
     */
    public static final Map<String, String> PLATFORM_MAP = new HashMap<>();
    static {
        PLATFORM_MAP.put("0", "All");
        PLATFORM_MAP.put("1", "Android");
        PLATFORM_MAP.put("2", "IOS");
    };

	/**
	 * 手机号正则
	 */
	public static final String MOBILE_PATTERN  = "0?(13|14|15|17|18|19|16)[0-9]{9}";

	/**
	 * 是否是条码  如果大于等于10：isbn  否则barcode
	 */
	public static final String BARCODE = "\\d{10}";
	
	
	public static final int SEND_CODE_TIMES_ERROR_CODE = -10003;
	 
	public static final String SEND_CODE_TIMES_ERROR_MSG = "获取验证码的次数过多,请半个小时后再来";
	 
	public static final int SEND_CODE_FAIL_CODE = -1;
	 
	public static final int SEND_CODE_SUCCESS_CODE = 1;
	 
	public static final String SEND_CODE_FAIL_CODE_MSG ="短信发送失败";
	 
	public static final String SEND_CODE_SUCCESS_CODE_MSG ="短信发送成功";
	 
	public static final String SEND_CODE_FAIL_CODEMORE_MSG ="发送失败,短信发送频繁";

	/**
	 * 题目数量
	 */
	public static final Integer LEYU_QUESTION_NUMBER = 5;

	/**
	 * 试题总时长
	 */
	public static final String LEYU_TEST_PAPERS_TIME ="10";

	//年级
	public static final String LABELINFO_AGE = "241002";
	//书籍类型
	public static final String LABELINFO_BOOK_TYPE = "2409";
	//书籍标签
	public static final String LABELINFO_BOOK_TAG = "2412";


	public static void main(String[] args) {
		for (int i=0; i<10; i++){
			System.out.println((int)(Math.random()*4));
		}
	}

	
}
