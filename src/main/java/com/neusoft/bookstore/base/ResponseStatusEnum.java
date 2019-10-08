package com.neusoft.bookstore.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ApiModel("返回状态码枚举类")
@AllArgsConstructor
@Getter
public enum ResponseStatusEnum {
    /**
     * 操作成功
     */
    @ApiModelProperty("操作成功")
    SUCCESS(0),
    /**
     * 操作失败
     */
    @ApiModelProperty("操作失败")
    ERROR(-1);
    /**
     * 操作代码
     */
    @ApiModelProperty("操作代码")
    private Integer code;
}
