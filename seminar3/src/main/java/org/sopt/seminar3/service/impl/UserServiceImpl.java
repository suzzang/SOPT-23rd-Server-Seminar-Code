package org.sopt.seminar3.service.impl;

import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;
import org.sopt.seminar3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

//@Service
//public class UserServiceImpl implements UserService {
//    private static final List<User> userList = new LinkedList<>();
//    @Override
//    public DefaultRes<List<User>> findAll() {
//        if(userList.isEmpty())
//            return DefaultRes.res(HttpStatus.NOT_FOUND.value(),"리스트가 비었습니다.");
//        return DefaultRes.res(HttpStatus.OK.value(),"리스트 조회 성공",userList);
//    }
//
//    @Override
//    public DefaultRes<User> findByUserIdx(int userIdx) {
//        User finduser = userList.get(userIdx);
//        return DefaultRes.res(HttpStatus.OK.value(),"회원을 조회했습니다.",finduser);
//    }
//
//    @Override
//    public DefaultRes save(User user) {
//        userList.add(user);
//        return DefaultRes.res(HttpStatus.OK.value(),"회원정보를 저장했습니다.",userList);
//    }
//
//    @Override
//    public DefaultRes<User> update(int userIdx, User user) {
//        userList.set(userIdx,user);
//        return DefaultRes.res(HttpStatus.OK.value(),"정보를 수정했습니다.",user);
//    }
//
//    @Override
//    public DefaultRes deleteByUserIdx(int userIdx) {
//        userList.remove(userIdx);
//        return DefaultRes.res(HttpStatus.OK.value(),"삭제했습니다",userList);
//    }
//}

 //서비스 구현 실습 답지 ///////////////////////////////////////////////////////////////////////////////////////////////
@Service
public class UserServiceImpl implements UserService {

    private static final List<User> userList = new LinkedList<>();

    @Override
    public DefaultRes<List<User>> findAll() {
        if (userList.isEmpty()) return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "리스트가 비었습니다.");
        return DefaultRes.res(HttpStatus.OK.value(), "리스트 조회 성공", userList);
    }

    @Override
    public DefaultRes<User> findByUserIdx(final int userIdx) {
        for (User u : userList) {
            if (u.getUserIdx() == userIdx)
                return DefaultRes.res(HttpStatus.OK.value(), "조회 성공", u);
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "회원을 찾을 수 없습니다.");
    }

    @Override
    public DefaultRes<User> save(final User user) {
        userList.add(user);
        return DefaultRes.res(HttpStatus.NO_CONTENT.value(), "회원 가입 성공");
    }

    @Override
    public DefaultRes<User> update(final int userIdx, final User user) {
        for (User u : userList) {
            if (u.getUserIdx() == userIdx) {
                userList.remove(u);
                userList.add(user);
                return DefaultRes.res(HttpStatus.OK.value(), "회원 정보 수정 성공");
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "회원을 찾을 수 없습니다.");
    }

    @Override
    public DefaultRes<User> deleteByUserIdx(final int userIdx) {
        for (User u : userList) {
            if (u.getUserIdx() == userIdx) {
                userList.remove(u);
                return DefaultRes.res(HttpStatus.OK.value(), "회원 삭제 성공");
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "회원을 찾을 수 없습니다.");
    }
}



