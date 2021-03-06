package org.sopt.seminar4.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.seminar4.dto.User;
import org.sopt.seminar4.model.SignUpReq;

import javax.annotation.security.PermitAll;
import java.util.List;

@Mapper
public interface UserMapper { //mapper는 무조건 인터페이스에!!!!!

//
//    /**
//     * @SELECT
//     */
//
//    //모든 회원 리스트 조회
//    @Select("SELECT * FROM user")
//    List<User> findAll();
//
//    //회원 이름으로 조회
//    @Select("SELECT * FROM user WHERE name = #{name}") //동적 바인딩 잘 기억하기!!!!
//    User findByName(@Param("name")final String name); //이름값을 넘겨주어야 하기 때문에! Param으로 처리해준다
//
//    //회원 고유 번호로 조회
//    @Select("SELECT * FROM user WHERE suerIdx = #{userIdx}")
//    User findByUserIdx(@Param("userIdx")final int userIdx);
//
//    /**
//     * @INSERT
//     */
//
//    //회원 등록, Auto Increment는 회원 고유 번호
//    //Auto Increment 값을 받아오고 싶으면 리턴 타입을 int(Auto Increment 컬럼 타입)으로 하면 된다.
//    @Insert("INSERT INTO user(name, part) VALUES(#{user.name),#{user.part})")
//    @Options(useGeneratedKeys = true,keyColumn = "user.userIdx") //AI 키값 명시
//    int save(@Param("user") final User user);
//
//    //Auto Increment 값을 받아오고 싶지 않다면 필요 없다.
//    @Insert("INSERT INTO user(name,part) VALUES(#{user.name},#{user.part})")
//    void save2(@Param("user") final User user);
//
//    /**
//     * @UPDATE & DELETE
//     */
//
//    //회원정보 수정
//    @Update("UPDATE user SET name = #{user.name},part = #{user.part} WHERE userIdx = #{userIdx}")
//    void update(@Param("userIdx") final int userIdx,@Param("user") final User user);
//
//    //회원 삭제
//    @Delete("DELETE FROM user WHERE userIdx = #{userIdx}")
//    void deleteByUserIdx(@Param("userIdx") final int userIdx);

    //모든 회원 리스트 조회
    @Select("SELECT * FROM user")
    List<User> findAll();

    //회원 이름으로 조회
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") final String name);

    //회원 고유 번호로 조회
    @Select("SELECT * FROM user WHERE userIdx = #{userIdx}")
    User findByUserIdx(@Param("userIdx") final int userIdx);


    //회원 등록, Auto Increment는 회원 고유 번호
    //Auto Increment 값을 받아오고 싶으면 리턴 타입을 int(Auto Increment 컬럼 타입)으로 하면 된다.
    @Insert("INSERT INTO user(name, part, profileUrl) VALUES(#{signUpReq.name}, #{signUpReq.part}, #{signUpReq.profileUrl})")
    @Options(useGeneratedKeys = true, keyColumn = "user.userIdx")
    int save(@Param("signUpReq") final SignUpReq signUpReq);

    //Auto Increment 값을 받아오고 싶지 않다면 필요 없다.
    @Insert("INSERT INTO user(name, part) VALUES(#{user.name}, #{user.part})")
    void save2(@Param("user") final User user);
    //회원 정보 수정
    @Update("UPDATE user SET name = #{user.name}, part = #{user.part} WHERE userIdx = #{userIdx}")
    void update(@Param("userIdx") final int userIdx, @Param("user") final User user);

    //회원 삭제
    @Delete("DELETE FROM user where userIdx = #{userIdx}")
    void deleteByUserIdx(@Param("userIdx") final int userIdx);

    //이름과 비밀번호로 조회
    @Select("SELECT * FROM user WHERE name = #{name} AND password = #{password}")
    User findByNameAndPassword(@Param("name")final String name, @Param("password")final String password);


}
