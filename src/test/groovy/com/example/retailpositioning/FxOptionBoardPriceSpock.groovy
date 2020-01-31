package com.example.retailpositioning

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class FxOptionBoardPriceSpock extends Specification {
    def 'フィールドをCSVの一行にできること'() {
        when:
        def testInstance = new FxOptionBoardPrice(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.EURUSD, expiryDate: LocalDate.of(2020, Month.FEBRUARY, 19), putSellAt: 0.0043, putBuyAt: 0.0048, strike: 1.1100, callSellAt: 0.0045, callBuyAt: 0.0050)
        def expectedLine = "EURUSD,2020-02-19,0.0043,0.0048,1.11,0.0045,0.005" + System.properties['line.separator']
        then:
        expectedLine == testInstance.toCsvLine()
    }
}
