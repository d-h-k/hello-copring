package io.hello.web

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


internal class ApiControllerTest {

    private val Objects = Int

    //@ParameterizedTest
    //@MethodSource("cal")
    @Test
    fun sdaf () {
        // [리턴 데이터 선언 실시]
        // [리턴 데이터 선언 실시]
        val resultMap = HashMap<String, Any>()


        // [URL 정보 설정 실시]


        // [URL 정보 설정 실시]
        var urlData = "http://jsonplaceholder.typicode.com/posts"


        // [쿼리 파람 데이터 정의 실시]


        // [쿼리 파람 데이터 정의 실시]
        val paramData: MutableMap<String, Any> = HashMap()
        paramData["userId"] = 1
        paramData["id"] = 1


        // [URL + 파라미터 결합 실시]


        // [URL + 파라미터 결합 실시]
        urlData += "?"
        // +  mapToUrlEncodeQueryString(paramData)


        // [리턴 데이터에 로그 삽입]


        // [리턴 데이터에 로그 삽입]
        resultMap["request"] = urlData


        // [로직 처리 실시]


        // [로직 처리 실시]
        try {

            // [http 설정]
            val url = URL(urlData)
            val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
            conn.setReadTimeout(20000) // 리드 타임 아웃
            conn.setConnectTimeout(20000) // 커넥션 타임 아웃
            conn.setRequestMethod("GET") // 전송 타입
            conn.setDoInput(true) // IN 설정
            conn.setDoOutput(true) // OUT 설정
            conn.addRequestProperty("Content-type", "application/x-www-form-urlencoded") // 프로퍼티 설정


            // [http response 데이터 확인]
            val br = BufferedReader(InputStreamReader(conn.getInputStream(), "UTF-8"))
            val sb = StringBuffer()
            var responseData: String? = ""
            while (br!!.readLine().also { responseData = it } != null) {
                sb.append(responseData) //StringBuffer 에 응답받은 데이터 순차적으로 저장 실시
            }
            try {
                if (br != null) {
                    br.close()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }


            // [리턴 데이터에 삽입 실시]
            resultMap["responseCode"] = conn.getResponseCode()
            resultMap["responseBody"] = sb.toString()
        } catch (e: Exception) {
            e.printStackTrace()

            // [에러 발생 시 map 에 추가 : 로그]
            resultMap["exception"] = e.message.toString()
        }

    }

}

