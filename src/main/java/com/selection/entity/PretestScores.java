package com.selection.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PretestScores {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer candidateId;

    private BigDecimal shuxueScore;

    private BigDecimal foreignLanguageScore;

    private BigDecimal comprehensiveScore;

    private BigDecimal retestMajorScore;

    private BigDecimal retestTotalScore;


}
