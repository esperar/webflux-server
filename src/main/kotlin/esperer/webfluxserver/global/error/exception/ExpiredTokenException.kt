package esperer.webfluxserver.global.error.exception

import esperer.webfluxserver.global.error.BasicException
import esperer.webfluxserver.global.error.ErrorCode

class ExpiredTokenException : BasicException(ErrorCode.EXPIRED_TOKEN.message, ErrorCode.EXPIRED_TOKEN.statusCode)