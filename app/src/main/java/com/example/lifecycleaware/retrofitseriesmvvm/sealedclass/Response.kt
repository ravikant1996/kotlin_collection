package com.example.lifecycleaware.retrofitseriesmvvm.sealedclass

import com.example.lifecycleaware.retrofitseriesmvvm.QuoteList

//sealed class Response(val data: QuoteList? = null, val errorMessage: String? = null) {
//    class Loading : Response()
//    class Success(quoteList: QuoteList) : Response(data = quoteList)
//    class Failure(errorMessage: String) : Response(errorMessage = errorMessage)
//}

sealed class Response<T>(val data: T? = null, val errorMessage: String? = null) {
    class Loading<T> : Response<T>()
    class Success<T>(data: T? = null) : Response<T>(data = data)
    class Failure<T>(errorMessage: String) : Response<T>(errorMessage = errorMessage)
}