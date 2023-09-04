package esperer.webfluxserver.domain.user.exception

import esperer.webfluxserver.global.error.BasicException
import esperer.webfluxserver.global.error.ErrorCode

class UserNotFoundException : BasicException(ErrorCode.USER_NOT_FOUND.message, ErrorCode.USER_NOT_FOUND.statusCode)