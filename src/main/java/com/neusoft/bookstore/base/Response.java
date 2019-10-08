package com.neusoft.bookstore.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@ApiModel("操作结果实体")
@Data
@Builder
public class Response<T> implements Serializable {
    private static final long serializableUID = -4353042225436721264L;
    /**
     * 返回码
     */
    @ApiModelProperty("返回码")
    private Integer code;

    /**
     * 操作结果信息
     */
    @ApiModelProperty("操作结果信息")
    private String msg;

    /**
     * 返回实体 T
     */
    @ApiModelProperty("返回实体 T")
    private T data;

    /**
     * 操作成功方法（返回提示信息）
     *
     * @param msg 提示信息
     * @return 操作成功 返回提示信息
     */
    public static Response ok(String msg) {
        // 返回提示信息
        return Response.builder().code(ResponseStatusEnum.SUCCESS.getCode()).msg(msg).build();
    }

    /**
     * 操作成功方法（返回成功结果实体列表）
     *
     * @param data 操作返回实体列表
     * @param msg  操作提示信息
     * @return 操作成功结果实体
     */
    public static <T> Response<T> ok(T data, String msg) {
        // 返回操作成功结果实体
        return Response.<T>builder().code(ResponseStatusEnum.SUCCESS.getCode()).data(data).msg(msg).build();
    }

    /**
     * 操作失败方法
     *
     * @param msg 操作提示信息
     * @return 操作失败结果实体
     */
    public static Response error(String msg) {
        // 返回操作失败结果实体
        return Response.builder().code(ResponseStatusEnum.ERROR.getCode()).msg(msg).build();
    }

    /**
     * 操作失败方法（返回失败）
     *
     * @param data 操作返回实体列表
     * @param msg  操作提示信息
     * @return 操作失败结果实体
     */
    public static <T> Response<T> error(T data, String msg) {
        // 返回操作失败结果实体
        return Response.<T>builder().code(ResponseStatusEnum.ERROR.getCode()).data(data).msg(msg).build();
    }
}
