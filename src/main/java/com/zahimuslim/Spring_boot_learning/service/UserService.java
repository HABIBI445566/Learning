package com.zahimuslim.Spring_boot_learning.service;

import com.zahimuslim.Spring_boot_learning.entity.User;
import com.zahimuslim.Spring_boot_learning.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);
    void saveVerificationTokenForUser(String token , User user);

}
