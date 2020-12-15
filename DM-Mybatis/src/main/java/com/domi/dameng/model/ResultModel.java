package com.domi.dameng.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Domi on 2020/12/15.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultModel {
    private Integer code;
    private MessageStatus msg;
    private Object data;
}
