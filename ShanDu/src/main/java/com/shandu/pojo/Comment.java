package com.shandu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int commentid;
    private int note_id;
    private int u_id;
    private String content;
    private String datatime;
    private int collecnum;
    private int code;
}
