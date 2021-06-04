package org.tian.news.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_news_tmp")
public class NewsTmp {
    @TableId(value = "n_id", type = IdType.AUTO)
    private int nId;

    @TableField("n_content")
    private String nContent;

    @TableField("n_create_time")
    private Date nCreateTime;

    @TableField("n_title")
    private String nTitle;

    @TableField("n_category_id")
    private Integer nCategoryId;

    @TableField(exist = false)
    private String nCategoryName;

    @TableField("n_status")
    private Integer nStatus;

}