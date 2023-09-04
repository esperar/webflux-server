package esperer.webfluxserver.global.error.exception

import esperer.webfluxserver.global.error.BasicException
import esperer.webfluxserver.global.error.ErrorCode

class NotFoundRequestHandlerException : BasicException(ErrorCode.NOT_FOUND_REQUEST_HANDLER.message, ErrorCode.NOT_FOUND_REQUEST_HANDLER.statusCode)