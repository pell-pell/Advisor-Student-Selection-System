package com.selection.entity.view;

import com.selection.entity.MentorChoiceConfirmation;
import lombok.Data;

@Data
public class MentorChoiceConfirmationView extends MentorChoiceConfirmation {


    private String candidateName;

    private String mentorName;

}
