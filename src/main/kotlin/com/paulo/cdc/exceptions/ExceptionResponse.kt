package com.paulo.cdc.exceptions

import java.util.*

class ExceptionResponse(
    val timestamp: Date,
    val message: String?,
    val details: String?
)