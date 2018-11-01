package org.sopt.seminar3.service;

import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;

import java.util.List;

public interface UserService {
    DefaultRes<List<User>> findAll();
    DefaultRes<User> findByUserIdx(final int userIdx);
    DefaultRes save(final User user);
    DefaultRes<User> update(final int userIdx, final User user);
    DefaultRes deleteByUserIdx(final int userIdx);
}
