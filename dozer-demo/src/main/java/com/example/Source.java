package com.example;

import lombok.Data;

import java.util.List;

/**
 * @author wjn
 * @date 2020/5/13 9:03
 */
@Data
public class Source<T> extends SourceParent<T>{
    private long id;
    private String info;
    private String name;
}