package com.selection.qpage;

import lombok.Data;

@Data
public class QPage {
    /**
     * 偏移量
     */
    Integer page = 1;
    /**
     * 限制，限量
     */
    Integer rows = 10;
}
