package xyz.zerxoi.covemidiff.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class DiffVo {
    @NotNull
    private Integer taskId;
    @NotNull
    @Range(min = 0, max = 1)
    private Integer method;
}
