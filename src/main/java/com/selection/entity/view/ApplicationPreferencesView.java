package com.selection.entity.view;

import com.selection.entity.ApplicationPreferences;
import lombok.Data;

@Data
public class ApplicationPreferencesView extends ApplicationPreferences {

    private String candidateName;

    private String mentorOneName;

    private String mentorTwoName;

    private String mentorThreeName;

    private String primarySubjectName;

    private String secondarySubjectName;


}
