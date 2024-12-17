package com.selection.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Admin {

    @TableId
    private Integer id;

    private String account;

    private String pwd;

    private String name;


}
