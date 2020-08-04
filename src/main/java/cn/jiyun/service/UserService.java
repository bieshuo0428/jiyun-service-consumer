package cn.jiyun.service;

import cn.jiyun.dao.UserDAO;
import cn.jiyun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> queryUserByIds(List<Long> ids){
        ArrayList<User> users = new ArrayList<>();

        ids.forEach(id->{
            users.add(this.userDAO.queryUserById(id));
        });
        return users;
    }

}
