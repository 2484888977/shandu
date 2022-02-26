package com.shandu.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proposal {
    private int id;
    private int u_id;
    private String name;
    private String proposal;
}
