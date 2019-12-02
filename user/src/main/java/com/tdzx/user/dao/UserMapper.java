package com.tdzx.user.dao;

import com.tdzx.user.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    TdzxMainUser findMainUserByTel(String tel);

    int insertMainUser(TdzxMainUser mainUser);

    TdzxMainUser findMainUserByID(Integer fInnerID);

    int updateMainUser(TdzxMainUser mainUser);

    int insertUserStore(UserStore userStore);

    TdzxMainUser findMainUserByOpenID(String openID);

    UserThirtyaccount findUserThirtyByOpenID(String openid);

    int insertUserThirty(UserThirtyaccount userThirtyaccount);

    int insertAdress(UserAdress userAdress);

    int updateIsDefaultAdress(Integer fAcctID);

    int updateUserAdress(UserAdress userAdress);

    List<UserAdress> findUserAdress(Integer fAcctID);

    UserAdress getDeafaultUserAdress(Integer fAcctID);

    UserAdress getFirstUserAdress(Integer fAcctID);

    int deteleUserAdress(Integer fInnerID);

    List<TdzxMainUser> findMainUserByBatchID(String fInnerIDArr);

    UserMember findUserMember(Integer fMainUserID);

    UserMember findUserMemberFirst(Integer fMainUserID);

    List<UserMember> findChuZhiMember(Integer fMainUserID);

    UserStore findUserStore(@Param("fBussType") String fBussType, @Param("fAcctID") Integer fMainUserID);

    int registryYueDing(UserStore userStore);

    UserStore  loginYueDing(@Param("fName") String fName,@Param("fPwd") String fPwd);

    List<UserMember> getUserMemberList(@Param("storeSapId") String storeSapId,@Param("fRealName") String fRealName,
                                       @Param("fUserName") String fUserName,@Param("fMemberTypeID") Integer fMemberTypeID);

    int discountChiZhiCart(@Param("fChuZhiCartNum") String fChuZhiCartNum,@Param("fAmount") double fAmount);

    int findCountByName(@Param("fBussType")String fBussType,@Param("fAcctID")Integer fAcctID,
                        @Param("fName")String fName,@Param("fPwd") String fPwd);

    List<TdzxMainUser> getBusMainUserList(TdzxMainUser tdzxMainUser);

    TdzxMainUser findMainUserByOpenid(String unionid);

    List<UserStore>  findUserStoreByBusstype(@Param("fName")String fName,@Param("fRealName")String fRealName,
                                             @Param("fBussType") String fBussType, @Param("fAcctID") Integer fMainUserID);

    int updateUserStore(UserStore userStore);

    int updateUserStoreByAcctID(UserStore userStore);
    //今日新增用户
    int getTodayAddUser();
    //今日新增用户
    int getYesTodayAddUser();
    //本月新增用户
    int getMonthAddUser();
    //会员总数
    int getTotalMemberNum();
}
