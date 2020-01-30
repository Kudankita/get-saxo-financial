package com.example.retailpositioning

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RetailPositioning {
    ArrayList<RetailPositionRatio> retailPositionRatios
    ArrayList<FxOptionBoardPrice> fxOptionBoardPrices
    BlogTitleDate blogTitleDate

    RetailPositioning(String responseHtml) {
        Document doc = Jsoup.parse(responseHtml)
        String blogTitle = doc.select("div.blogTitle").first().text()
        this.blogTitleDate = new BlogTitleDate(blogTitle)

        this.retailPositionRatios = []
        doc.select("table.postable").each {
            this.retailPositionRatios << new RetailPositionRatio(it)
        }

        this.fxOptionBoardPrices = []
        def fxOptionBoardExpiryDate = LocalDate.parse(doc.select("th.expirydate").text(), DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH))
        def trList = doc.select("div.posSection > table.boardTable > tbody > tr")
        trList.eachWithIndex {
            it, i ->
                if (i == 0 | i == 1) {
                    // 1行目と2行目は情報取得対象でないためスキップ
                    return
                }
                def tempBoardPrice = new FxOptionBoardPrice(it)
                tempBoardPrice.setExpiryDate(fxOptionBoardExpiryDate)
                this.fxOptionBoardPrices << tempBoardPrice
        }
    }
}
