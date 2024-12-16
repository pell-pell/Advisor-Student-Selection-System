package com.selection.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class AdmissionCatalog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer secondarySubjectId;

    private Integer year;

    private Integer totalQuota;

    private Integer recommendQuota;

    private Integer supplementalQuota;

    private String additionalNotes;

    private String preliminaryExamSubjects;

    private String subjectRetest;


}
