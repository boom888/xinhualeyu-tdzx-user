package com.tdzx.user.service;

import com.tdzx.user.domain.*;
import com.tdzx.user.utils.CommonResult;

import java.util.List;

public interface MemberService {

    List<MemberType> getMemberType(String fBussType,Integer fMemberTypeID);

    CommonResult<Boolean> lockMemberCart(String fMemCardNum,Integer fIsLock);

    CommonResult<Boolean> userBandMember(String fBussType,Long userID,Long memberTypeID,String storeSapId);

    CommonResult<Boolean> userBandSapMember(String fBussType,String fMobile,String fCode);

    CommonResult<Boolean> memberAdmin(String fType,Integer fAcctID,Integer fUserMemberID);

    CommonResult<List<UserMember>> bindSapChuZhiCart(Integer fAcctID,String storeCode,String fMemberCartNum,String fChuZhiCartNum,String fChuZhiCartPwd);

    /**
     * 绑定提货卡
     * @param fBussType
     * @param memberCard
     * @param activeCode
     * @return
     */
    CommonResult<Boolean> cardBandVip(String fBussType,Integer fInnerID,String fName,String memberCard,String activeCode);

    CommonResult<Boolean>   userBandVip(String fBussType,Integer fInnerID,String mobile,String code);

    List<BusiSchoolxx>  findSchool(String province,String city,String area,String schoolName);

    List<BusiSchooljg>  getSchoolGradeClass(String schoolID);

    CommonResult<List<BusiStudentinfo>>   registryJCJF(String wxID,Integer userID,String realName,String schoolId,String schoolName,String gradeId,
                                                       String gradeName,String classId,String className,String mobile,String code);

    CommonResult<List<BusiStudentinfo>>   getStudentList(String wxID);

    List<DzBusiSchoolxx>  findCompany(String province,String city,String area,String companyName);

    List<DzBusiSchooljg>  getCompanyInfo(String companyID);

    CommonResult<DzBusiStudentinfo>   registryDZDW(Integer userID,String realName,String schoolId,String schoolName,String gradeId,
                                                       String gradeName,String classId,String className,String mobile,String code);

    CommonResult<DzBusiStudentinfo>   getCompanyUserInfo(Integer fAcctID);

    CommonResult<BusiSchoolxx> getSchoolInfoByID(String fschoolID);

    CommonResult<DzBusiSchoolxx> getCompanyInfoByID(String fcompanyID);

    CommonResult<Boolean> rechargeTbmChuZhiCart(Integer fAcctID,String fMemberCartNum,String fChuZhiCartNum,double totalPrice);

    CommonResult<Boolean> unBindICCard(Integer fAcctID,String fMemberCartNum,String fChuZhiCartNum);

    CommonResult<Boolean> unBindMemberCard(Integer fAcctID,String fMemberCartNum);
}
