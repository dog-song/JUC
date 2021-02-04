package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Domi on 2021/01/27.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultModel {
    private Integer code;
    private MessageStatus msg;
    private Object data;
}
