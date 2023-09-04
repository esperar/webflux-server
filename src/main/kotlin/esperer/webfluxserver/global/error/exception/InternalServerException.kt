package esperer.webfluxserver.global.error.exception

import esperer.webfluxserver.global.error.BasicException
import esperer.webfluxserver.global.error.ErrorCode

class InternalServerException : BasicException(ErrorCode.INTERNAL_SERVER_ERROR.message, ErrorCode.INTERNAL_SERVER_ERROR.statusCode)