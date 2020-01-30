package com.example.retailpositioning

import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.time.temporal.TemporalAccessor

class BlogTitleDate {
    /**
     *  class="blogTitle"が指定されているdivに記載されている日時。
     *  「23 Jan 2020, 0700 GMT」のような形式でHTMLに記載されている。
     *  ページの情報がいつ時点のものかを示しているはず。
     */
    ZonedDateTime blogTitleDate

    BlogTitleDate(String blogTitle) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM")
                .withLocale(Locale.ENGLISH)
        TemporalAccessor accessor = parser.parse(blogTitle[-18..-16])
        int dayOfMonth = accessor.get(ChronoField.MONTH_OF_YEAR)

        this.blogTitleDate = ZonedDateTime.of(blogTitle[-14..-11].toInteger(), dayOfMonth, blogTitle[0..1].toInteger(),
                blogTitle[-8..-7].toInteger(), blogTitle[-6..-5].toInteger(), 0, 0,
                ZoneId.of(blogTitle[-3..-1]))
    }
}
