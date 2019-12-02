package com.tdzx.user.utils;

public class PromptMessage {
	/**
	 * 有必填项信息为空
	 */
	public static final String INFO_IS_NULL = "有必填项信息为空";

	/**
	 * 开始时间不能大于结束时间
	 */
	public static final String STARTTIME_GT_ENDTIME = "开始时间不能大于结束时间";
	
	/**
	 * 非指定账户类型;

	 */
	public static final String INFO_IS_NOTALLOCATED= "非指定账户类型";
	/**
	 * 添加成功
	 */
	public static final String  REQU_ADD_SUCCESS = "意见反馈成功！";
	
	/**
     * 信息有误
     */
    public static final String INFO_IS_WRONG = "信息有误";
	
	/**
	 * 服务器异常
	 */
	public static final String SERVER_IS_ERR = "服务器异常";
	
	/**
	 * 金额格式不对
	 */
	public static final String PRICE_IS_ERR = "金额格式不对";
	
	/**
	 * 支付方式有误
	 */
	public static final String PAYTYPE_IS_ERR = "支付方式有误";
	
	/**
     * 累计充值金额超过上限
     */
    public static final String PAY_AMT_UPPER_ERR = "累计充值金额超过上限";
	
	/**
     * 系统资金帐户未指定
     */
    public static final String ACC_SysACCNO_EMPTY= "系统资金帐户未指定";
	
	/**
     * 累计充值金额超过上限
     */
    public static final String ACC_AudiACCNO_EMPTY= "系统审核帐户未指定";
	
    
	/**
	 * 支付金额有误
	 */
	public static final String PAYLEVEL_IS_ERR = "支付金额有误";
	
	
	/**
     * 金额必须大于1元
     */
    public static final String AMOUNT_MUST_ABOVE_ONE = "金额必须大于1元";
    
    /**
     * 金额太小
     */
    public static final String AMOUNT_TOO_SMALL = "金额太小";
	
	/**
	 * 用户ID为空
	 */
	public static final String FACCTID_IS_NULL = "用户主键为空";
	
	/**
	 * 地址未填写
	 */
	public static final String ADDRESS_IS_NULL = "地址未填写";
	
	
	/**
	 * 添加失败
	 */
	public static final String  ADD_FAIL = "添加失败";
	
	/**
	 * 修改失败
	 */
	public static final String  UPD_FAIL = "修改失败";
	
	
	
	/**
	 * 添加失败
	 */
	public static final String  DEL_FAIL = "删除失败";
	
	/**
	 * 添加失败
	 */
	public static final String  DEL_GroFAILByNoMe = "无法删除其他用户数据，删除失败";
	
	
	/**
	 * 主键为空
	 */
	public static final String ID_IS_NULL = "传入主键为空";
	
	/**
	 * 传入参数为空
	 */
	public static final String PRO_IS_NULL = "传入参数为空";
	
	/**
	 * 无此数据
	 */
	public static final String VALUE_IS_NULL = "无此数据";
	
	/**
	 * 用户未登录
	 */
	public static final String LOGIN_IS_NULL = "用户未登录";
	
	/**
	 * 用户不存在
	 */
	public static final String ACC_IS_NULL = "抱歉，该手机号尚未注册，请先注册。";

	/**
	 * 抱歉，账号或密码错误，请重新输入。
	 */
	public static final String ACC_PASS_ERR = "抱歉，账号或密码错误，请重新输入。";
	/**
	 * 用户不存在
	 */
	public static final String ACC_SMS_ERR = "验证码错误";

	/**
	 * 用户不存在
	 */
	public static final String NOT_PASS= "密码为空";
	
	/**
	 * 手机号已存在
	 */
	public static final String ACC_IS_MobileExists = "手机号已存在";
	
	/**
	 * 不能给自己评论
	 */
	public static final String COM_IS_EQUAL = "不能给自己评论";
	
	/**
	 * 不能预定自己的分享
	 */
	public static final String SHARE_IS_EQUAL = "不能预定自己的分享";
	
	/**
	 * 物品已被预订
	 */
	public static final String SHARE_IS_REVER = "物品已被预订";
	
	/**
	 * 已经评论过了
	 */
	public static final String COM_IS_EXIST = "已经评论过了";
	
	/**
	 * 不能给自己点赞
	 */
	public static final String PRA_IS_EQUAL = "不能给自己点赞";
	
	/**
	 * 已经点赞过了
	 */
	public static final String PRA_IS_EXIST = "已经点赞过了";
	
	/**
	 * 不能给自己打赏
	 */
	public static final String PAY_IS_EQUAL = "不能给自己打赏";
	
	/**
	 * 已经打赏过了
	 */
	public static final String PAY_IS_EXIST = "已经打赏过了";
	
	/**
	 * 用户和项目不匹配，不能下架
	 */
	public static final String SHARE_IS_NOT_ACC = "用户和项目不匹配，操作失败";
	
	/**
	 * 预约退还失败
	 */
	public static final String RESERVATIO_FAIL = "预约退还失败";
	
	/**
	 * 下架
	 */
	public static final String SHARE_SHELVES = "下架成功";
	
	/**
	 * 上架
	 */
	public static final String SHARE_REDUCTION = "上架成功";
	
	/**
	 * 订单号不存在
	 */
	public static final String ORDER_IS_NULL = "订单号不存在";
	
	/**
	 * 订单已支付
	 */
	public static final String ORDER_IS_PAY = "订单已支付";
	
	/**
	 * 账户余额不足
	 */
	public static final String MONEY_IS_NOT = "账户余额不足";
	
	/**
	 * 物品已退还
	 */
	public static final String GOODS_RETURN = "物品已退还";
	
	/**
	 * 身份证号码错误
	 */
	public static final String ID_CARD_ERR = "身份证号码错误";
	
	/**
	 * 积分未启用
	 */
	public static final String POINT_NOT_ENABLED = "积分未启用";
	
	/**
	 * 订单未支付成功
	 */
	public static final String ORDER_NOT_ENABLED = "订单未支付成功";
	
	/**
	 * 下单失败
	 */
	public static final String ORDER_FAIL = "下单失败";
	
	/**
	 * 支付成功
	 */
	public static final String ORDER_SUCCESS = "支付成功";
	
	/**
	 * 没有共同分享
	 */
	public static final String NOT_SHARE = "没有共同分享";
	
	/**
	 * 数据加载成功
	 */
	public static final String LOAD_SUCCESS = "数据加载成功";

	/**
	 * 数据加载失败
	 */
	public static final String LOAD_FAIL = "数据加载失败";
	/**
	 * 暂无库存
	 */
	public static final String INVENTORY_LOAD_FAIL = "暂无库存";
	/**
	 * 已在配送中，不能移除该书
	 */
	public static final String CAN_NOT_REMOVE = "已在配送中，不能移除该书";
	/**
	 * 已在配送中，不能加入书架
	 */
	public static final String CAN_NOT_JOIN = "已在配送中，不能加入书架";
	/**
	 * 数据加载失败
	 */
	public static final String LOAD_FAIL_ISBN = "抱歉，没找到这本书";
	/**
	 * 数据加载失败
	 */
	public static final String VOTE_FALL_ME = "已参与过投票";

	/**
	 * 文本内容不合法
	 */
	public static final String TEXT_CANNOT_LAWFUL = "文本内容不合法";

	/**
	 * 图片不合法
	 */
	public static final String PHOTO_CANNOT_LAWFUL = "图片不合法";

	/**
	 * 发布成功
	 */
	public static final String RELEASE_SUCCESS = "发布成功";

	public static final String RELEASE_FAIL= "发布失败";

	/**
	 * 取消成功
	 */
	public static final String CANCEL_SUCCESS = "取消成功";
	
	/**
	 * 取消成功
	 */
	public static final String RESERVATIO_SUCCESS = "预约退还成功";	
	
	/**
     * 收书成功
     */
    public static final String RECEIVE_BOOK_SUCCESS = "收书成功";   
    
    /**
     * 收书失败
     */
    public static final String RECEIVE_BOOK_FAIL = "收书失败";     
    
	/**
	 * 续租成功
	 */
	public static final String RENEWAL_SUCCESS = "续租成功";
	
	/**
	 * 退还成功
	 */
	public static final String RETURN_SUCCESS = "退还成功";
	
	/**
	 * 领取成功
	 */
	public static final String RECEIVE_SUCCESS = "领取成功"; 
	
	/**
	 * 领取成功
	 */
	public static final String DELIVER_SUCCESS = "派送成功"; 
	
	/**
	 * 预订成功
	 */
	public static final String RESERVATION_SUCCESS = "预订成功";
	
	/**
	 * 添加成功
	 */
	public static final String  ADD_SUCCESS = "添加成功";

	/**
	 * 操作成功
	 */
	public static final String  OPERATE_SUCCESS = "操作成功";

	/**
	 * 您已经申请用户注销，请等待平台审核，如有疑问，请咨询：020-87573647
	 */
	public static final String  LOGOUT_INFO = "您已经申请用户注销，请等待平台审核，如有疑问，请咨询：020-87573647";

	/**
	 * 操作失败
	 */
	public static final String  OPERATE_FAILD = "操作失败";
	/**
	 * token过期
	 */
	public static final String  TOKEN_PASS = "token过期";
	/**
	 * 操作失败
	 */
	public static final String  UPDATE_PASS_FAILURE1 = "新密码不能与旧密码相同";
	 /*
	 操作失败
	 */
	public static final String  UPDATE_PASS_FAILURE2 = "修改失败，旧密码错误";

	/**
	 * 该机构正在审核中
	 */
	public static final String  GAI_JIGOU_AUDITE = "该机构正在审核中";

	/**
	 * 不能重复点赞
	 */
	public static final String  CAN_NOT_EXTI_PRAISE= "不能重复点赞";

	/**
	 * 已经购买该课程，请勿重复购买
	 */
	public static final String  REABET_SHOP_COURSER = "已经购买该课程，请勿重复购买";

	/**
	 * 该孩子已经购买过该课程，请勿重复下单
	 */
	public static final String  REABET_CHIRLD_SHOP_COURSER = "该孩子已经购买过该课程，请勿重复下单";

	/**
	 * 用户名重复
	 */
	public static final String  NAME_REPATITION = "用户名重复";

	/**
	 * 班级推荐码错误
	 */
	public static final String  FCLASSCODE_ERROR = "班级推荐码错误";

	/**
	 * 您已添加过该孩子信息
	 */
	public static final String  IS_HAVE_THISCHIRLD = "您已添加过该孩子信息";

	/**
	 * 名额不足
	 */
	public static final String  PLACES_DEFICIENCY = "名额不足";

	/**
     * 评论成功
     */
    public static final String  COMMENT_SUCCESS = "评论成功!";
	
	/**
	 * 删除成功
	 */
	public static final String DELETE_SUCCESS = "删除成功";
	
	/**
	 * 读取成功
	 */
	public static final String READ_SUCCESS = "读取成功";
	
	/**
	 * 认证成功
	 */
	public static final String IDCARD_SUCCESS = "认证成功";
	
	/**
	 * 信息填写成功
	 */
	public static final String USER_SUCCESS = "信息填写成功";
	
	/**
	 * 修改成功
	 */
	public static final String UPDATE_SUCCESS = "修改成功";
	
	/**
	 * 生成订单成功
	 */
	public static final String ADD_ORDER_SUCCESS = "生成订单成功";
	
	/**
     * 生成订单失败
     */
    public static final String ADD_ORDER_FAILD = "生成订单失败";
    
	
	/**
     * 提现成功
     */
    public static final String GET_MONEY_SUCCESS = "提现成功";
    
    /**
     * 提现失败
     */
    public static final String GET_MONEY_FAIL = "提现失败";
    
    /**
     * 获取签名失败
     */
    public static final String GET_SIGN_FAIL = "获取签名失败";
	
	/**
	 * 登录
	 */
	public static final String LOGIN_SUCCESS = "登录成功";
	
	/**
	 * 登录失败
	 */
	public static final String LOGIN_FAIL = "登录失败";
	
	
	/**
	 * 生成支付数据
	 */
	public static final String ALIPAY_STR_SUCCESS = "生成支付数据成功";
	
	/**
	 * 注册成功
	 */
	public static final String REG_SUCCESS = "注册成功";
	
	/**
	 * 注册失败
	 */
	public static final String RGE_FAIL = "注册失败";
	
	/**
	 * 已被预定
	 */
	public static final String IS_USED = "已被预定";

	/**
	 * 不可以重复购买
	 */
	public static final String NO_RE_BUY = "不可以重复购买";

	/**
	 * 学校信息为空
	 */
	public static final String MEMBER_SCHOOL_IS_NULL = "请先补充您的学校信息，再申请加入班级俱乐部";
	/**
	 * 学校信息为空
	 */
	public static final String MEMBER_USER_IS_NULL = "用户信息不存在，无法申请加入班级俱乐部";
	/**
	 * 未登陆
	 */
	public static final String  NO_LOGIN = "未登陆";
	/**
	 * 无法执行此操作，系统未授权
	 */
	public static final String EXEC_FAIL = "系统未授权，无法执行此操作";

	/**
	 * title重复
	 */
	public static final String  TITLE_RE = "计划名称不能重复";

	/**
	 *  验证码验证成功
	 */
	public static final String VERIFY_CODE_SUCCESS = "验证码验证成功";
	/**
	 *  验证码验证成功
	 */
	public static final String VERIFY_CODE_ING = "已提交申请";

	/**
	 *  验证码验证失败
	 */
	public static final String VERIFY_CODE_FAIL = "验证码验证失败";

	/**
	 *  评论，已评论过该书籍
	 */
	public static final String COMMENT_BOOK_ED = "已评论过该书籍";

	/**
	 *  该角色账号已存在
	 */
	public static final String ROLE_EXIT= "该手机号码已注册,请直接登录!";


	/**
	 *  不能重复提交审核
	 */
	public static final String CAN_NOT_COMMIT_AUDITE= "不能重复提交审核";

	/**
	 *  学号不能重复
	 */
	public static final String StudentNum_Repeat= "学号不能重复";

	/**
	 *  学校不能重复
	 */
	public static final String CAN_NOT_EXIT_SCHOOL= "该区学校不能重复";
	/**
	 *  邀约码错误
	 */
	public static final String INVITATION_CODE_ERROR= "邀约码错误";
	/**
	 *  超过班级最大选书数
	 */
	public static final String IS_OVER_MAX= "超过班级最大选书数";
	/**
	 *  超过班级最大选书数
	 */
	public static final String CAN_NOT_REPEATBOOK= "不能重复借书";
	/**
	 *  超过班级最大选书数
	 */
	public static final String GOODS_CART_IXIT= "心愿单已存在该商品";
	/**
	 *  课程上课时间冲突
	 */
	public static final String COURSE_TIME_CLASH= "课程上课时间冲突";

	/**
	 *  课程上课时间冲突
	 */
	public static final String CODE_IS_EXIT= "激活码已失效";

	/**
	 *  该手机号教师已存在
	 */
	public static final String TEACHAER_IS_EXIT= "该手机号已注册";

}
