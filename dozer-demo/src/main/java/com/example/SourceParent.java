package com.example;

import lombok.Data;

import java.util.List;

/**
 * @author wjn
 * @date 2020/5/14 9:24
 */
@Data
public class SourceParent<T> {
    private List<T> users;
}
