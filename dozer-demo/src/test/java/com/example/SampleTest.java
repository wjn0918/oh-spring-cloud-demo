package com.example;


import com.github.dozermapper.core.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * @author wjn
 * @date 2020/5/13 10:11
 */
@ContextConfiguration(locations = {"classpath:spring-dozer.xml"})
@SpringBootTest
@RunWith(SpringRunner.class)
public class SampleTest {

    @Autowired
    Mapper mapper;

    @Test
    public void cs() {
//        ArrayList<String> names = new ArrayList<String>();
//        names.add("zs");
//        names.add("ls");

        User user = new User();
        user.setName("zs");
        ArrayList<User> users = new ArrayList<User>();
        users.add(user);
        Source cs = new Source();
//        cs.setInfo("wjn");
        cs.setUsers(users);
        Dest map = mapper.map(cs, Dest.class);
        System.out.println(map);

    }

    @Test
    public void cs1(){
        Source source = new Source();
        source.setInfo("wjn");
        Dest map = mapper.map(source, Dest.class);
        System.out.println(map);
    }
}
