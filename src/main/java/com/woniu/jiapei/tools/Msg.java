package com.woniu.jiapei.tools;

import com.woniu.jiapei.model.Bed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Msg {
    private String msg;
    private Boolean result;
    private Bed bed;
    private List<Bed> bedList;
}
