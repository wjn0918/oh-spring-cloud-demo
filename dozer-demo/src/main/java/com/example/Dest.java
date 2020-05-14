package com.example;

import lombok.Data;

import java.util.List;

/**
 * @author wjn
 * @date 2020/5/13 9:02
 */
@Data
public class Dest {
    private long id;
    private Info info;
    private List<UserDto> users;
    private String name;
}
