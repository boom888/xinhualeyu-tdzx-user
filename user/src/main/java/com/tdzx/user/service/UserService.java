package com.tdzx.user.service;

import com.tdzx.user.domain.*;
import com.tdzx.user.utils.CommonResult;
import com.tdzx.user.utils.PageTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    CommonResult<Boolean> sendTelCode(String ip, String tel, String templateCode);

    int mainUserRegistry(String fTel,String fCode,String fPwd);

    TdzxMainUser findMainUserByTel(String tel);

    String CreateToken(String fInnerID);

    CommonResult<Map<String,Object>> mainUserLogin(String fTel,String fCode,String fPwd);

    TdzxMainUser findMainUserByToken(String token) throws Exception;

    int updateMainUser(TdzxMainUser mainUser);

    int updateMainUserPwd(String fTel,String fCode,String fNewPwd);

    int bindStoreUser(String token,String fType,String fStoreMobile,String fCode);

    CommonResult<Map<String,Object>> VXRegistry(String openID,String fTel,String fPwd,String fTelCode,
                                                String fPic,String fName);

    //Map<String,Object> getTokenAndOpenID(String code,String fPic,String fName);

    //Map<String,Object> loginByTokenAndOpenID(String access_token,String refresh_token,String openID,String fPic,String fName);

    Map<String,Object> loginByVX(String unionid,String openID,String fPic,String fName);

    int addUserAdress(String token,Integer fAdressID,String fReceiveName,String fReceiveTel,Integer fAdressType,String fProvince,
                      String fCity,String fArea,String fDetailAdress,Integer fIsDefaultAdress);

    CommonResult<List<UserAdress>> selectUserAdress(String token);

    CommonResult<UserAdress> getDeafaultUserAdress(String token);

    CommonResult<List<UserAdress>> selectUserAdressByUserID(String fMainUserID);

    int deteleUserAdress(Integer fInnerID);

    List<TdzxMainUser> getBatchMainUserInfo(String fAcctIDArr);

    CommonResult<Double> getDiscountByUserID(String fMainUserID);

    CommonResult<List<UserMember>> getMemberByUserID(String fMainUserID);

    UserStore registryYueDing(UserStore userStore);

    CommonResult<Map<String,Object>> loginYueDing(String fBussType,Integer fAcctID,String fName,String fPwd);

    CommonResult<Map<String,Object>> loginByMainUser(String fBussType,Integer fAcctID);

    PageTO<UserMember> getUserMemberList(String storeSapId,String fRealName,String fUserName,Integer fMemberTypeID,Integer pageNum,Integer pageSize);

    CommonResult discountChiZhiCart(String fChuZhiCartNum,String fAmount);

    CommonResult<PageTO<TdzxMainUser>> getMainUserList(String fRealName,String fUserName,String fMobile,Integer pageNum,Integer pageSize);

    CommonResult<Boolean>   updatePwd(String fMobile,String code,String newPwd);

    CommonResult<Boolean>   updateMobile(String fOldMobile,String oldCode,String fNewMobile,String newCode);

    CommonResult<Map<String,Object>> loginXCX(String xcxCode);

    CommonResult<PageTO<UserStore>> getBussTypeUserList(String fName,String fRealName,String fBussType,Integer pageNum,Integer pageSize);

    CommonResult<PageTO<BusiStudentinfo>> getBussTypeStudentList(String studentname,Integer pageNum,Integer pageSize);

    CommonResult<PageTO<DzBusiStudentinfo>> getBussTypeCompanyList(String studentname,Integer pageNum,Integer pageSize);

    CommonResult<Map<String,Object>> bandXCX(String encryptedData,String iv,String fOpenID,String fPic,String fName);

    CommonResult<Boolean> updateUserList(UserStore userStore);

    CommonResult<Boolean> updateStudentList(BusiStudentinfo busiStudentinfo);

    CommonResult<Boolean> updateCompanyList(DzBusiStudentinfo dzBusiStudentinfo);

    CommonResult<PageTO<TdzxMainUser>> getBusMainUserList(String fName,String fRealName,Integer pageNum,Integer pageSize);

    CommonResult<Boolean> updateTdzxMainUser(TdzxMainUser tdzxMainUser);

    CommonResult<Map<String,Integer>> getInfo();
}
