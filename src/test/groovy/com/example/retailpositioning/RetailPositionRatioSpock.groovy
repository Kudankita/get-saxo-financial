package com.example.retailpositioning

import spock.lang.Specification


class RetailPositionRatioSpock extends Specification {
    def 'フィールドをCSVの一行にできること'() {
        when:
        def testInstance = new RetailPositionRatio(currencyPair: SaxoFxOptionsSentimentCurrencyPairs.EURUSD, longCallWidth: 65.6958083024794, longCall: 65, longCallDifference: -1, longPutWidth: 34.3041916975206, longPut: 35, longPutDifference: 1)
        def expectedLine = "EURUSD,65.6958083024794,65,-1,34.3041916975206,35,1" + System.properties['line.separator']
        then:
        expectedLine == testInstance.toCsvLine()
    }
}
