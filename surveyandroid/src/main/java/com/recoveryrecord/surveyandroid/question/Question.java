package com.recoveryrecord.surveyandroid.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.recoveryrecord.surveyandroid.condition.Condition;

import java.util.ArrayList;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "question_type", visible = true, defaultImpl = UnsupportedQuestion.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SingleSelectQuestion.class, name = "single_select"),
        @JsonSubTypes.Type(value = MultiSelectQuestion.class, name = "multi_select"),
        @JsonSubTypes.Type(value = YearPickerQuestion.class, name = "year_picker"),
        @JsonSubTypes.Type(value = DatePickerQuestion.class, name = "date_picker"),
        @JsonSubTypes.Type(value = SingleTextFieldQuestion.class, name = "single_text_field"),
        @JsonSubTypes.Type(value = SingleTextAreaQuestion.class, name = "single_text_area"),
        @JsonSubTypes.Type(value = MultiTextFieldQuestion.class, name = "multi_text_field"),
        @JsonSubTypes.Type(value = DynamicLabelTextFieldQuestion.class, name = "dynamic_label_text_field"),
        @JsonSubTypes.Type(value = AddTextFieldQuestion.class, name = "add_text_field"),
        @JsonSubTypes.Type(value = SegmentSelectQuestion.class, name = "segment_select"),
        @JsonSubTypes.Type(value = TableSelectQuestion.class, name = "table_select")
})
public abstract class Question {

    public String id;
    public String header;
    public String question;

    @JsonProperty("question_type")
    public String questionType;

    @JsonProperty("sub_questions")
    public ArrayList<Question> subQuestions;

    @JsonProperty("show_if")
    public Condition showIf;
}
