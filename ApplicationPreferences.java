package com.selection.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApplicationPreferences {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer candidateId;

    private Integer primarySubjectId;

    private Integer secondarySubjectId;

    private Integer preferredMentoroneId;

    private Integer preferredMentortwoId;

    private Integer preferredMentorthreeId;

    private Integer acceptAdjustment;



}
