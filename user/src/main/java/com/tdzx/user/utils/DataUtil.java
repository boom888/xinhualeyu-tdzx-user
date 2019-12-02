package com.tdzx.user.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class DataUtil<main> {
	
	/**
	 * @Title: listIsNotEmpty 
	 * @Description: TODO(验证集合是否为空) 
	 * @param @param list
	 * @param @return  参数说明 
	 * Boolean    返回类型
	 */
	public static <T> Boolean listIsNotEmpty(List<T> list)
	{
		if(list != null && list.size() > 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @Title: bigDecimalIsNotEmpty 
	 * @Description: TODO(验证bigDecimal是否为空) 
	 * @param @param bigDecimal
	 * @param @return  参数说明 
	 * Boolean    返回类型
	 */
	public static Boolean bigDecimalIsNotEmpty(BigDecimal bigDecimal){
		if(bigDecimal != null)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * @Title: doubleIsNotEmpty 
	 * @Description: TODO(验证double是否为空) 
	 * @param @param doub
	 * @param @return  参数说明 
	 * Boolean    返回类型
	 */
	public static Boolean doubleIsNotEmpty(Double doub){
		if(doub != null)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * @Title: integerIsNotEmpty 
	 * @Description: TODO(验证Integer是否为空) 
	 * @param @param inte
	 * @param @return  参数说明 
	 * Boolean    返回类型
	 */
	public static Boolean integerIsNotEmpty(Integer inte){
		if(inte != null)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * @Title: longIsNotEmpty 
	 * @Description: TODO(验证Integer是否为空) 
	 * @param @param lon
	 * @param @return  参数说明 
	 * Boolean    返回类型
	 */
	public static Boolean longIsNotEmpty(Long lon){
		if(lon != null)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * 验证Object是否为空
	 * @param obj
	 * @return
	 */
	public static Boolean objectIsNotEmpty(Object obj){
		if(obj != null)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * 保留两位小说(四舍五入)
	 * @param number
	 * @return
	 */
	public static Double number2Decimal(Double number)
	{
		 DecimalFormat df = new DecimalFormat("#########.00");
		
		return Double.valueOf(df.format(number));
	}
	
	/**
     * 保留两位小说(四舍五入)
     * @param number
     * @return
     */
    public static Double number4Decimal(Double number)
    {
         DecimalFormat df = new DecimalFormat("#########.0000");  
        
        return Double.valueOf(df.format(number));
    }
	
	/**
	 * 保留两位小说(四舍五入)
	 * @param number
	 * @return
	 */
	public static BigDecimal numberDecimal(Double number)
	{
		 DecimalFormat df = new DecimalFormat("#########.00");  
		String str = df.format(number);
		return new BigDecimal(str);
	}
	
	/**
	 * 将字符串转换为集合
	 * @param str
	 * @return
	 */
	public static List<String> strChangeList(String str)
	{
		List<String> list = new ArrayList<String>();
		if(StringUtils.isNotBlank(str))
		{
			String [] strs = str.split(",");
			for (int i = 0; i < strs.length; i++) {
				list.add(strs[i]);
			}
		}
		
		return list;
	}
	
	/**
	 * 将字符串转换为集合
	 * @param str
	 * @return
	 */
	public static List<String> strChangeList(String str,String slipt )
	{
		List<String> list = new ArrayList<String>();
		if(StringUtils.isNotBlank(str))
		{
			String [] strs = str.split(slipt);
			for (int i = 0; i < strs.length; i++) {
				list.add(strs[i]);
			}
		}
		
		return list;
	}
	
	
	/*public static void main(String[] args) {
		System.out.println(number2Decimal(2343224.124));
	}*/
	
	 /** 
     * 将一个 JavaBean 对象转化为一个  Map
     */ 
	 public static Map<String, Object> objectToMap(Object obj) throws Exception{
		if(obj == null)
			return null;

		Map<String, Object> map = new HashMap<String, Object>();

		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			String key = property.getName();
			if (key.compareToIgnoreCase("class") == 0) {
				continue;
			}
			Method getter = property.getReadMethod();
			Object value = getter!=null ? getter.invoke(obj) : null;
			if(value != null)
			{
				map.put(key, value);
			}

		}

		return map;
	 }
	
	 /**
		 * 参数为空的判断
		 * 
		 * @param map
		 * @return
		 */
	public String verifyInfo(Map<String, String> map) {
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			if (StringUtils.isBlank(key)) {
				return map.get(key) + "不能为空";
			}
		}
		return null;
	}

	private static void   createUserName(int k){
		int m=0;
		while (m<=k){
			char c=(char)('A'+Math.random()*('Z'-'A'+1));
			System.out.println(c);
			m++;
		}
	}
		//业务回滚 勿删
	public static void  rollBack(){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}

	public static void main(String[] args) throws Exception {
		createUserName(4);
		System.err.println((char)Math.random()*('Z'-'A'));
	}

}