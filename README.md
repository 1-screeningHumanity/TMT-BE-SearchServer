# Search Server

## 📖 Description
회원 검색과, 종목 검색, 카테고리 검색 등의 서비스의 검색과 관련된 처리를 하는 서버
Logstash를 활용한 데이터 수집 파이프라인과 Elastic Search를 사용한 검색 기능 구현이 되어있는 서버.
네이버 Open Api를 활용한 종목 별 뉴스 데이터 제공 서버.

## ⚙ Function
1. 회원의 닉네임을 통한 검색 기능.
2. 종목 명을 통한 종목 검색 기능.
3. 종목에 대한 카테고리를 1차 2차 전처리를 진행. 이를 통한 카테고리 별 조회 기능.
4. 네이버 Open Api를 활용한, 종목별 및 메인 페이지 뉴스 정보 조회 기능.

## 🏴󠁧󠁢󠁥󠁮󠁧󠁿 Running
<p float="left">
    <img src="https://i.ibb.co/TgNhXCD/1.png" width=200 />
    <img src="https://i.ibb.co/TgNhXCD/1.png" width=200 />
    <img src="https://i.ibb.co/TgNhXCD/1.png" width=200 />
    <img src="https://i.ibb.co/zS47pZH/image.png" width=200 />
</p>
   
## 🔧 Stack
 - **Language** : Java 17
 - **Library & Framework** : Spring Boot 3.2.5
 - **Database** : Mysql, MongoDB, Elastic Search
 - **ORM** : Hibernate Jpa
 - **Deploy** : AWS EC2 / Jenkins
 - **Dependencies** : Lombok, Springdoc(Swagger), Model Mapper, Kafka, Feign Client

## 🔧 Architecture
- **Design Patter** : Hexa Gonal
- **Micro Service Architecture** : Spring Cloud
- **Event-Driven Architecture** : Kafka

## 👨‍👩‍👧‍👦 Developer
*  **강성욱** ([KangBaekGwa](https://github.com/KangBaekGwa))
*  **김도형** ([ddohyeong](https://github.com/ddohyeong))
*  **박태훈** ([hoontaepark](https://github.com/hoontaepark))
