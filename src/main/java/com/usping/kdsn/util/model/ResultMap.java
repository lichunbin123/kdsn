package com.usping.kdsn.util.model;

import lombok.*;

import java.util.HashMap;
import java.util.List;


@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ResultMap {

    private boolean success;
    private List data;
    private Integer count;
    private boolean empty;



}
