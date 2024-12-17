package com.selection.entity.view;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.selection.entity.SecondarySubject;
import lombok.Data;

@Data
public class SecondarySubjectView  extends SecondarySubject {

    private String primarySubjectName;


}
