package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/10.
 */
@Data
public class WorkModel{

    private int id ;

    private String name ;

    private int age;

    private List<Long> projects;
}
