package com.selection.entity.view;

import com.selection.entity.RetestScores;
import lombok.Data;

import java.util.List;

@Data
public class RetestScoresView extends RetestScores {

    private String candidateName;

    private List<Integer> candList;

}
