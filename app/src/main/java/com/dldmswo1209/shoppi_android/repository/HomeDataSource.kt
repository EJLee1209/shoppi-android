package com.dldmswo1209.shoppi_android.repository

import com.dldmswo1209.shoppi_android.model.HomeData

// 데이터 소스는 여러 유형이 존재할 수 있다.
// 예를 들어 파일, 네트워크 통신, 데이터베이스 등
// 이렇게 여러 유형의 데이터 소스에게 공통적으로 요청하는 것은 원본 데이터
// 이 요청을 인터페이스의 메서드를 선언하고, 인터페이스를 구현하는 클래스로 만드는 것...?
interface HomeDataSource {
    fun getHomeData(): HomeData?
}