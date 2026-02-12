package com.around.community;

import com.around.community.dao.DiscussPostMapper;
import com.around.community.dao.UserMapper;
import com.around.community.entity.DiscussPost;
import com.around.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration
class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(1);
        System.out.println(user);

        user = userMapper.selectByName("alice");
        System.out.println(user);

        user = userMapper.selectByEmail("bob@example.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("jeffsun");
        user.setPassword("password123");
        user.setSalt("abc");
        user.setEmail("js1212@email.com");
        user.setHeaderUrl("http://images.com/d.png");
        user.setActivationCode("123");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser() {
        int row = userMapper.updateStatus(4, 1);
        System.out.println(row);

        row = userMapper.updateHeader(4, "http://images.com/jeff.png");
        System.out.println(row);
        row = userMapper.updatePassword(4,  "hello123");
        System.out.println(row);
    }

    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost post: list) {
            System.out.println(post);
        }
        int rows = discussPostMapper.selectDiscussPostRows(1);
        System.out.println(rows);
    }
}
