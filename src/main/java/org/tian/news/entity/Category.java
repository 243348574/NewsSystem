package org.tian.news.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_category")
public class Category {
    @TableId(value = "c_id", type = IdType.AUTO)
    private Integer cId;

    @TableField("c_name")
    private String cName;

    @TableField("c_status")
    private Integer cStatus;

}
