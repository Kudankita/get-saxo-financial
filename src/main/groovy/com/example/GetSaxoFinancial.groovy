package com.example

import com.example.retailpositioning.RetailPositioningMain
import groovyx.net.http.HttpContextDecorator
import groovyx.net.http.RESTClient

class GetSaxoFinancial {
    static main(args) {
        // RetailPositioningMain.retailPositioningMain()

        def restClient = new RESTClient('http://dummy.restapiexample.com/')
        def res = restClient.get(path: "api/v1/employees")
        println res.status
    }
}
