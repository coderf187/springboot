package com.example.swagger2.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@ApiModel(value = "book对象", description = "书籍对象book的描述")
@Getter
@Setter
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", name = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "书名", name = "name", example = "book1", required = true)
    private String name;

    @ApiModelProperty(value = "价格", name = "price", example = "100.00", hidden = true)
    private Double price;


}
