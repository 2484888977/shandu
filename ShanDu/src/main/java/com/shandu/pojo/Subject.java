package com.shandu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    private int s_id;
    private String subjectinfo;
    private int majorid;
}
