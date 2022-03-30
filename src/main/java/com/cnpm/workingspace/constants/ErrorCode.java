package com.cnpm.workingspace.constants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    SOMETHING_WRONG("001","Something wrong !"),
    SUCCESS("200","Success !"),
    ERROR("002","Error !"),
    UNAUTHENTICATED("401", "Unauthorized"),
    USERNAME_ALREADY_EXISTS("402","Username already exists"),
    INVALID_TOKEN("501","Invalid token"),
    INCORRECT_TOKEN("502","Incorrect token"),
    MISSING_AUTHORIZATION("503","Missing authorization"),
    USERNAME_OR_PASSWORD_INCORRECT("504","Username or password incorrect"),
    INTERNAL_SERVER_ERROR("500","Internal Server Error");
    public final String errorCode;
    public final String msg;
}
