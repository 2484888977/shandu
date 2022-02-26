package com.shandu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    private int id;
    private int majorid;
    private int userid;
    private int comnum;
    private String title;
    private String contentinfo;
    private int collecnum;
    private int collecid;
    private String datatime;
    private int recommendid;
    private int subjectid;
}
