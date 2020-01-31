package com.example.retailpositioning

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class RetailPositioningMain {
    /**
     * SAXOのサイトからポジションの偏りとオプションの価格の情報をダウンロードし必要な情報を取得してCSVに保存する
     */
    static void retailPositioningMain() {
        def responseHtml = new URL("https://fxowebtools.saxobank.com/retail.html").getText()

        new File("result/html/" + ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmm")) + ".html").withWriterAppend { writer ->
            writer.write(responseHtml)
        }

        def retailPositioning = new RetailPositioning(responseHtml)
        def reportedDate = retailPositioning.blogTitleDate.blogTitleDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmm"))

        new File("result/retailPositionRatio/" + reportedDate + ".csv").withWriterAppend { writer ->
            retailPositioning.retailPositionRatios.each {
                writer.write(it.toCsvLine())
            }
        }

        new File("result/fxOptionBoardPrice/" + reportedDate + ".csv").withWriterAppend { writer ->
            retailPositioning.fxOptionBoardPrices.each {
                writer.write(it.toCsvLine())
            }
        }
    }
}
