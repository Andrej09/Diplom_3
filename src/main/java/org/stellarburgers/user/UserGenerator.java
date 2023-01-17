package org.stellarburgers.user;


import org.apache.commons.lang3.RandomStringUtils;
import org.stellarburgers.user.User;

public class UserGenerator {

    public User random(){
        return new User(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru",
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10));
    }
}