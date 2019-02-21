package com.djdu.category.entity;

import com.djdu.common.base.BaseEmtity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CategoryFirst
 * @Description TODO 一级分类表实体，存放分类信息，如电脑，手机，维修
 * @Author DJDU
 * @Date 2019/2/17 21:11
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "categoryFirst")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class CategoryFirst extends BaseEmtity {
    @Id
    @Column(name = "categoryFirst_id")
    private String categoryFirst_id;//分类的id

    private String name;//分类名

    private Integer morder;//同级分类顺序

    @OneToMany(cascade = CascadeType.ALL,mappedBy="categoryFirst",fetch=FetchType.LAZY)
    private List<CategorySecond> categorySecond = new ArrayList<CategorySecond>();//子 二级分类
}