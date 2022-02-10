package xyz.zerxoi.covemidiff.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value ="diff")
@Data
public class Diff implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer taskId;
    private Integer method;
    private Integer fileTypeId;
    private Integer lineNum;
    private String reason;
    private Integer coverageToolId;
    private Integer count;
}