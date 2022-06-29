package com.onejava.patterns;

import com.onejava.dto.User;
import com.onejava.dto.UserProjection;
import com.onejava.dto.UserUtil;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class UserHolder {
    public static void main(String[] args) {
        List<User> users = UserUtil.getUsers();
        List<UserProjection> userProjectionList = new ArrayList<>();
        Integer[] userAgeSum = {0};
        Integer sum =0;

        users.forEach(user -> {
            userProjectionList.add(new UserProjection(user.getName(), user.getAge()));
            userAgeSum[0] = userAgeSum[0] + user.getAge();
        });

        UserWrapper userWrapper = new UserWrapper(userProjectionList, userAgeSum[0]);
        System.out.println(userWrapper);

        users.stream().peek(user -> user.setName(user.getName().toLowerCase())).findAny()
                .ifPresent(System.out::println);


        users.stream().limit(1).forEach(System.out::println);
    }
}

@AllArgsConstructor
@ToString
class UserWrapper{
    private List<UserProjection> userProjectionList;
    private Integer userAgeSum;
}


