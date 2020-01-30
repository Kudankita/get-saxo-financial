package com.example.retailpositioning

import groovy.transform.EqualsAndHashCode
import groovy.transform.MapConstructor
import org.jsoup.nodes.Element

import java.time.LocalDate

@MapConstructor
@EqualsAndHashCode
class FxOptionBoardPrice {
    /**
     * 通貨ペア名
     */
    SaxoFxOptionsSentimentCurrencyPairs currencyPair
    /**
     * 権利行使日
     */
    LocalDate expiryDate
    double putSellAt
    double putBuyAt
    /**
     * 行使価格
     */
    double strike
    double callSellAt
    double callBuyAt

    FxOptionBoardPrice(Element elm) {
        this.currencyPair = elm.select("td.cross").text() as SaxoFxOptionsSentimentCurrencyPairs
        this.putSellAt = elm.select("td.price td")[0].text() as double
        this.putBuyAt = elm.select("td.price td")[1].text() as double
        this.strike = elm.select("td.strike").text() as double
        this.callSellAt = elm.select("td.price td")[2].text() as double
        this.callBuyAt = elm.select("td.price td")[3].text() as double
    }
}
