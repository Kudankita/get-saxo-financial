package com.example.retailpositioning

import groovy.transform.EqualsAndHashCode
import groovy.transform.MapConstructor
import org.jsoup.nodes.Element


@MapConstructor
@EqualsAndHashCode
class RetailPositionRatio {
    /**
     * 通貨ペア名
     */
    SaxoFxOptionsSentimentCurrencyPairs currencyPair
    /**
     * Long Calls / Short Puts
     * （画面表示されている数字ではなく、HTMLのタグ中のstyleにWidthの値として指定されている％）
     */
    double longCallWidth
    /**
     * Long Calls / Short Puts
     * （画面表示されている数字）
     */
    int longCall
    /**
     * Long Calls / Short Puts の前日比
     * （画面表示されている数字）
     */
    int longCallDifference
    /**
     * Long Puts / Short Calls
     * （画面表示されている数字ではなく、HTMLのタグ中のstyleにWidthの値として指定されている％）
     */
    double longPutWidth
    /**
     * Long Puts / Short Calls
     * （画面表示されている数字）
     */
    int longPut
    /**
     * Long Puts / Short Callsの前日比
     * （画面表示されている数字）
     */
    int longPutDifference

    RetailPositionRatio(Element elm) {
        this.currencyPair = elm.select("td.leftLabelCells").text() as SaxoFxOptionsSentimentCurrencyPairs
        this.longCallWidth = ((elm.select("td.leftPositionCells").attr("style").split(";")[1] - "width: ") - "%").trim() as double
        this.longCall = elm.select("td.leftPositionCells").text().replaceAll("\\(.+?\\)|%", "") as int
        this.longCallDifference = (elm.select("td.leftPositionCells").text() =~ /(?<=\().*?(?=%\))/)[0] as int
        this.longPutWidth = ((elm.select("td.rightPositionCells").attr("style").split(";")[1] - "width: ") - "%").trim() as double
        this.longPut = elm.select("td.rightPositionCells").text().replaceAll("\\(.+?\\)|%", "") as int
        this.longPutDifference = (elm.select("td.rightPositionCells").text() =~ /(?<=\().*?(?=%\))/)[0] as int
    }

    /**
     * CSVに書き込むための文字列を作る
     * @return フィールドをカンマで区切って1行にして最後に改行を付加した文字列
     */
    String toCsvLine() {
        this.currencyPair.toString() + "," + this.longCallWidth + "," + this.longCall + "," + this.longCallDifference + "," + this.longPutWidth + "," + this.longPut + "," + this.longPutDifference + System.properties['line.separator']
    }
}
