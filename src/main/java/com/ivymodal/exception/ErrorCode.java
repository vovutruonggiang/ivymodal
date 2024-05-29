package com.ivymodal.exception;

public enum ErrorCode {

    CATEGORY_EXISTED(1001,"Category existed"),
    CATEGORY_NOT_FOUND(1002,"Category not found"),
    SIZE_EXISTED(1003,"Size existed"),
    SIZE_NOT_FOUND(1004,"Size not found"),
    COLOR_EXISTED(1005,"Color existed"),
    COLOR_NOT_FOUND(1006,"Color not found"),
    PRODUCT_EXISTED(1007,"Product existed"),
    PRODUCT_NOT_FOUND(1008,"Product not found"),
    VARIANT_EXISTED(1007,"Varant existed"),
    VARIANT_NOT_FOUND(1008,"varant not found"),
    IMAGES_EXISTED(1007,"Images existed"),
    IMAGES_NOT_FOUND(1008,"Images not found");

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
