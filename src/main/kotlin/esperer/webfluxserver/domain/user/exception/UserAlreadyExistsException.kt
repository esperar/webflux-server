package esperer.webfluxserver.domain.user.exception

import esperer.webfluxserver.global.error.BasicException
import esperer.webfluxserver.global.error.ErrorCode

class UserAlreadyExistsException : BasicException(ErrorCode.ALREADY_EXIST_USER.message, ErrorCode.ALREADY_EXIST_USER.statusCode)