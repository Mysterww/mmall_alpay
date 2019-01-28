package cn.vpclub.model;

import lombok.Data;

import java.security.PrivateKey;
import java.util.List;

@Data
public class CateGoryModel
{
    private Integer id;
    private String name;
    private Integer pid;
    private List<CateGoryModel> childs;

}
