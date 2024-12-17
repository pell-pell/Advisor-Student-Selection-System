package com.selection.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Admissioninfo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer candidateId;

    private Integer mentorId;

    private Integer admissionStatus;

    private String mentorAdmissionSignature;

    private String finalSelectionStatus;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date resultTime;



}
