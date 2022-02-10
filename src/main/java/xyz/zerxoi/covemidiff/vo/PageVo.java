package xyz.zerxoi.covemidiff.vo;

import lombok.Data;

@Data
public class PageVo {
    private Integer page;
    private Integer size;
    private String sidx;
    private boolean asc;
}
