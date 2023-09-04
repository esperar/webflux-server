package esperer.webfluxserver.global.error.exception

import esperer.webfluxserver.global.error.BasicException
import esperer.webfluxserver.global.error.ErrorCode

class UnAuthorizedException : BasicException(ErrorCode.UNAUTHORIZED.message, ErrorCode.UNAUTHORIZED.statusCode)