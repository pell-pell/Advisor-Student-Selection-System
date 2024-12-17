package com.selection.entity.view;

import com.selection.entity.PretestScores;
import lombok.Data;

import java.util.List;

@Data
public class PretestScoresView extends PretestScores {

    private String candidateName;

    private List<Integer> candList;


}
