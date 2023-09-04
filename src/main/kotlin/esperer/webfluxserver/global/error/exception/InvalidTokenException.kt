package esperer.webfluxserver.global.error.exception

import esperer.webfluxserver.global.error.BasicException
import esperer.webfluxserver.global.error.ErrorCode

class InvalidTokenException : BasicException(ErrorCode.INVALID_TOKEN.message, ErrorCode.INVALID_TOKEN.statusCode)