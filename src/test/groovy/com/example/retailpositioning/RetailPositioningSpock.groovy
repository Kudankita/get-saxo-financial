package com.example.retailpositioning

import spock.lang.Specification

import java.time.LocalDate
import java.time.Month
import java.time.ZoneId
import java.time.ZonedDateTime

class RetailPositioningSpock extends Specification {
    def 'HTMLから正しく情報を取り出せること'() {
        when:
        String responseHtml = new File('src/test/resources/retailPositioning.html').text
        def positioning = new RetailPositioning(responseHtml)
        def expectedBlogTitleDate = ZonedDateTime.of(2020, 1, 23, 7, 0, 0, 0, ZoneId.of("GMT"))
        def expectedRetailPositionRatios = [
                new RetailPositionRatio(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.EURUSD, longCallWidth: 65.6958083024794, longCall: 65, longCallDifference: -1, longPutWidth: 34.3041916975206, longPut: 35, longPutDifference: 1),
                new RetailPositionRatio(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.USDJPY, longCallWidth: 50.8110918544194, longCall: 50, longCallDifference: 0, longPutWidth: 49.1889081455806, longPut: 50, longPutDifference: 0),
                new RetailPositionRatio(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.GBPUSD, longCallWidth: 73.9577311604228, longCall: 73, longCallDifference: -3, longPutWidth: 26.0422688395772, longPut: 27, longPutDifference: 3),
                new RetailPositionRatio(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.AUDUSD, longCallWidth: 48.7933458294283, longCall: 48, longCallDifference: 1, longPutWidth: 51.2066541705717, longPut: 52, longPutDifference: -1),
                new RetailPositionRatio(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.USDCAD, longCallWidth: 61.6487455197133, longCall: 61, longCallDifference: 8, longPutWidth: 38.3512544802867, longPut: 39, longPutDifference: -8),
                new RetailPositionRatio(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.USDCHF, longCallWidth: 55.1901907562392, longCall: 55, longCallDifference: 5, longPutWidth: 44.8098092437608, longPut: 45, longPutDifference: -5),
                new RetailPositionRatio(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.EURJPY, longCallWidth: 31.0427687019207, longCall: 31, longCallDifference: 1, longPutWidth: 68.9572312980793, longPut: 69, longPutDifference: -1),
                new RetailPositionRatio(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.EURGBP, longCallWidth: 43.2493371986422, longCall: 43, longCallDifference: 1, longPutWidth: 56.7506628013578, longPut: 57, longPutDifference: -1),
                new RetailPositionRatio(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.EURCHF, longCallWidth: 51.1828155747332, longCall: 51, longCallDifference: 1, longPutWidth: 48.8171844252668, longPut: 49, longPutDifference: -1),
                new RetailPositionRatio(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.GOLD, longCallWidth: 59.5609651408775, longCall: 59, longCallDifference: 1, longPutWidth: 40.4390348591225, longPut: 41, longPutDifference: -1),
                new RetailPositionRatio(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.SILVER, longCallWidth: 6.94984073304875, longCall: 6, longCallDifference: 0, longPutWidth: 93.0501592669513, longPut: 94, longPutDifference: 0)
        ]
        def expectedFxOptionBoardPrices = [
                new FxOptionBoardPrice(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.EURUSD, expiryDate: LocalDate.of(2020, Month.FEBRUARY, 19), putSellAt: 0.0043, putBuyAt: 0.0048, strike: 1.1100, callSellAt: 0.0045, callBuyAt: 0.0050),
                new FxOptionBoardPrice(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.USDJPY, expiryDate: LocalDate.of(2020, Month.FEBRUARY, 19), putSellAt: 0.57, putBuyAt: 0.63, strike: 109.50, callSellAt: 0.48, callBuyAt: 0.54),
                new FxOptionBoardPrice(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.GBPUSD, expiryDate: LocalDate.of(2020, Month.FEBRUARY, 19), putSellAt: 0.0092, putBuyAt: 0.0104, strike: 1.3150, callSellAt: 0.0089, callBuyAt: 0.0101),
                new FxOptionBoardPrice(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.AUDUSD, expiryDate: LocalDate.of(2020, Month.FEBRUARY, 19), putSellAt: 0.0045, putBuyAt: 0.0050, strike: 0.6875, callSellAt: 0.0037, callBuyAt: 0.0042),
                new FxOptionBoardPrice(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.USDCAD, expiryDate: LocalDate.of(2020, Month.FEBRUARY, 19), putSellAt: 0.0044, putBuyAt: 0.0052, strike: 1.3150, callSellAt: 0.0057, callBuyAt: 0.0066),
                new FxOptionBoardPrice(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.USDCHF, expiryDate: LocalDate.of(2020, Month.FEBRUARY, 19), putSellAt: 0.0060, putBuyAt: 0.0068, strike: 0.9700, callSellAt: 0.0029, callBuyAt: 0.0036),
                new FxOptionBoardPrice(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.EURJPY, expiryDate: LocalDate.of(2020, Month.FEBRUARY, 19), putSellAt: 0.65, putBuyAt: 0.74, strike: 121.50, callSellAt: 0.62, callBuyAt: 0.71),
                new FxOptionBoardPrice(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.EURGBP, expiryDate: LocalDate.of(2020, Month.FEBRUARY, 19), putSellAt: 0.0052, putBuyAt: 0.0061, strike: 0.8450, callSellAt: 0.0048, callBuyAt: 0.0056),
                new FxOptionBoardPrice(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.EURCHF, expiryDate: LocalDate.of(2020, Month.FEBRUARY, 19), putSellAt: 0.0029, putBuyAt: 0.0038, strike: 1.0700, callSellAt: 0.0062, callBuyAt: 0.0072),
                new FxOptionBoardPrice(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.GOLD, expiryDate: LocalDate.of(2020, Month.FEBRUARY, 19), putSellAt: 15.44, putBuyAt: 17.61, strike: 1560.00, callSellAt: 14.84, callBuyAt: 16.98)
        ]

        then:
        expectedBlogTitleDate == positioning.getBlogTitleDate().getBlogTitleDate()
        expectedRetailPositionRatios.containsAll(positioning.getRetailPositionRatios())
        expectedFxOptionBoardPrices.containsAll(positioning.getFxOptionBoardPrices())
    }
}
