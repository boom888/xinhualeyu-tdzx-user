package com.tdzx.user.dao;

import com.tdzx.user.domain.MemberType;
import com.tdzx.user.domain.UserMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberMapper {
    List<MemberType> findMemberType(@Param("fBussType")String fBussType,@Param("fMemberTypeID")Integer fMemberTypeID);

    List<MemberType> findMemberTypeList(@Param("fBussType")String fBussType);

    MemberType findMemberTypeByName(String fMemberName);

    int insertUserMember(UserMember userMember);

    int updateUserMemberLock(@Param("fMemCardNum") String fMemCardNum, @Param("fIsLock") Integer fIsLock);

    UserMember findUserMember(@Param("fSubUserID")Integer fSubUserID,@Param("fMemberTypeID")Integer fMemberTypeID);

    UserMember findIsExitUserMember(@Param("fAcctID")Integer fAcctID,
                                    @Param("fMemCardNum")String memberCartNum,@Param("store_sap_id")String storeCode);

    MemberType findMemberTypeByNum(String fMemberNum);

    List<UserMember> findMemberList(@Param("fAcctID")Integer fAcctID);

    List<UserMember> findChuZhiCartList(@Param("fAcctID")Integer fAcctID);

    int deleteUserMember(Integer fInnerID);

    int updateNoDefaultUserMember(Integer fAcctID);

    int updateDefaultUserMember(Integer fInnerID);

    int updateUserMemberJf(@Param("fIntegralNum")Integer fIntegralNum,@Param("fInnerID")Integer fInnerID);

    UserMember findDefaultMember(@Param("fAcctID")Integer fAcctID);

    int unBindICCard(@Param("fMemCardNum") String fMemCardNum);

    int updateMember(UserMember userMember);
}
