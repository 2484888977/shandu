package com.shandu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment_View {
    private int commentid;
    private int note_id;
    private int u_id;
    private String content;
    private String datatime;
    private String collecnum;
    private int code;
    private int userid;
    private String name;
    private String title;
    private String contentinfo;
    private String vx_head;
}
