package com.selection.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SecondarySubject {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer primarySubjectId;


}
