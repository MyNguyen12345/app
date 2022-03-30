package com.cnpm.workingspace.constants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    SOMETHING_WRONG("001","Something wrong !"),
    SUCCESS("200","Success !"),
    ERROR("002","Error !"),
    UNAUTHENTICATED("401", "Unauthorized"),
    USERNAME_ALREADY_EXISTS("402","Username already exists");
    public final String errorCode;
    public final String msg;
}
