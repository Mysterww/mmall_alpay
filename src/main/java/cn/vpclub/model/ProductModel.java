package cn.vpclub.model;

import lombok.Data;

@Data
public class ProductModel {
    private Integer id;
    private Integer categoryId;
    private  String name;
    private  Integer price;
}
