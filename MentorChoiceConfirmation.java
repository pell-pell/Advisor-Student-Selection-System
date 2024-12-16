package com.selection.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MentorChoiceConfirmation {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer mentorId;

    private Integer candidateId;

    private Integer preferenceOrder;

    private Integer confirmed;




}
