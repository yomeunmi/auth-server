package com.auth.server.common.type;

public enum ErrorReason {
    Blank,					// null, "", " " Blank
    Invalid,  				// 데이터 정합성 문제 + 인증 토큰 인증 실패
    Expired,   				// 만료
    EntityNotFound,			// 존재하지 않음
    EntityDuplicated,		// 이미 존재하고 있음
    NotPermitted,			// 접근이 허용되지 않음
    NotActive, 				// 유저가 활성화 되어있지 않음
    UnAuthorized,			// 인증 실패

    // client invalid status
    UserDeviceBlocked,		// Device 블락된 상태 -> UserDevice 등록부터 다시 진행
    UserDeviceStatusInvalid,// Device 상태가 올바르지 않음 -> UserDevice 등록부터 다시 진행
    UserStatusInvalid,		// User 상태가 올바르지 않음 -> UserDevice 등록부터 다시 진행
    InternalServerError
}
