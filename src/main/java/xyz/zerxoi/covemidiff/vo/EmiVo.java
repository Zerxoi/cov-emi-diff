package xyz.zerxoi.covemidiff.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class EmiVo {
    private Integer taskId;
    @Range(min = 0, max = 1)
    private Integer method;
    private Integer status;
}
