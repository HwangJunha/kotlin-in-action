package com.around

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.Year

val Int.days: Period
    get() = Period.ofDays(this)

val Period.ago: LocalDate
    get() = LocalDate.now() - this

val Period.fromNow: LocalDate
    get() = LocalDate.now() + this