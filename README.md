# learning-spring-ohdoking
스프링 스터디!! 

# Spring 시작 방법
1. Spring starter Project(Spring Boot)
2. Spring Project

2번 방법을 실무에서 사용을 많이함

# Maven 
프로젝트 관리 도구로 프로젝트의 시작과 끝까지의 단계에 맞춰서 사용하는 개발도구이지만, 가장 많이 사용되는 용도는 프로젝트에 필요한 의존적인 라이브러리를 자동으로 관리해주는 용도로도 많이 사용됩니다.

라이브러리를 사용하는 경로는 .m2 라는 이름의 폴더임

#Spring

##장점

복잡함에 반기를 들어 만들어진 프레임워크
프로젝트의 전체 구조를 설계할때 유용한 프레임워크
다른 프레임워크 포용
개발 생산성과 개발도구 지원

##발전

2.5 어노테이션 생김
3.0 java 클래스로 설정파일 설정가능
4.0 모바일 환경과 웹 환경에서 많이 사용되는 REST 방식의 컨트롤러 지원

##주요 특징

POJO(Plain Old Java Object) 기반의 구성 
- 객체 간의 관계를 구성할 수 있는 특징을 가짐 
- 쉽게 말해서 java 코드를 이용하여 객체를 구성하는 방식을 그대로 사용가능
- (개발자가 특정 라이브러리나 컨테이너의 기술에 종속족이지 않다는것을 의미함) 
의존성 주입(DI)을 통한 객체간의 관계 구성
- ioc(Inversion Of Control - 제어의 역행) 메소드나 객체의 호출 작업을 개발자가 결정하는 것이 아니라 외부에서 결정됨!
- 의존성 : 어떤 객체가 혼자 일을 처리할수 없다는것을 의미
- 의존성 주입 : 제어의 역행으로 특정 객체에 필요한 객체를 외부에서 결정해서 연결 시키는것을 의미
- 의존성 주입의 종류(어노테이션으로 가능): 1) 생성자를 통한 주입, 2) set 메소드를 이용한 주입
AOP(Aspect-Oriented-Programming) 지원
- 횡단 관심사 (cross-concern) : 로그,트랜잭션같이 비지니스 로직이 아니지만 반드시 처리가 필요한 부분
- AOP는 횡단 관심사를 모듈로 분리하는 프로그래밍의 패러다임
- AspectJ의 문법을 통해 작성
- 보통 AOP proxy를 사용함(프록시란 말그대로 대리하여 업무를 처리. 함수 호출자는 주요 업무가 아닌 보조 업무를 프록시에게 맡기고, 프록시는 내부적으로 이러한 보조 업무를 처리. - 참고 : http://ooz.co.kr/201)
트랜잭션의 지원
- XML이나 어노테이션으로 트랜잭션 관리 가능
편리한 MVC 구조
WAS에 종속적이지 않은 개발 환경

# Mybatis

SQL Mapper 라이브러리

Spring <-> mybatis-Spring <-> mybatis <-> Mysql

##장점
- 간결한 코드
- SQL문의 분리 운영
- Spring과 연동으로 자동화된 처리
- 동적 SQL을 이용한 제어



## 라이브러리 추가
mybatis
mybatis-spring
spring-jdbc
spring-test


# 모델2 방식
화면과 데이터 처리를 분리해서 재사용이 가능하도록 하는 구조
모델: 데이터 혹은 데이터를 처리하는 영역
뷰: 결과 화면ㅇ르 만들어 내는 데 사용하는 자원
컨트롤러: 웹의 요청을 처리하는 존재로 뷰와 모델 사이의 중간 통신 역할

# Front Controller 패턴
스프링 MVC가 사용하는 구조
모델2 방식의 진화
가장 중요한 변화는 전체 로직의 일부만을 컨트롤러가 처리하도록 변경 
전체 로직의 일부를 컨트롤러에게 위임하고 모든 흐름의 제어는 앞쪽의 Front Controller가 담당하게
![Spring MVC](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/images/mvc.png)


## Mybatis 를 이용할때 SQL 문을 사용하는 방식
xml 만을 이용해서 SQL문을 설정, DAO에서는 XML을 찾아서 실행하는 코드를 작성하는 방식
어노테이션과 인터페이스만을 이용해서 SQL문을 설정
인터페이스와 XML로 작성된 SQL 문의 활용

##Mybatis를 XML을 사용해서 작성하는 경우 코딩의 순서
테이블 생성 및 개발준비
- 테이블 생성 및 기타 데이터베이스 관련 설정
- 도메인 객체의 설계와 클래스 작성
XML Mapper의 생성과 SQL문 작성
- xml 작성 및 sql 작성
- mybatis에서 작성된 xml Mapper를 인식하도록 설정
DAO 작성
- DAO 인터페이스 작성 및 구현
- 스프링 상에 DAO 등록 및 테스트




##참고
- xmlns:context="http://www.springframework.org/schema/context"
xml 네임 스페이스설정한것
- xml 에서 <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
id 는 스프링 내에서 특정 객체(빈)을 찾기위해 사용하는 일종의 가명(alias)
class는 불러오는 해당 클래스/ 모듈을 추가해두어야함!
- RunWith 
개발을 돌리기위한
- ContextConfiguration
해당 xml파일을 이용해서 스프링이 로딩됨
- @Inject
스프링이 주입해줌
- 테스트 케이스에서 spring-test 를 어노테이션 설정으로 실제 스프링의 동작을 확인할수잇음
- 스프링은 한개의 설정이 잘못되는 경우 실행 자체에 문제가 생기므로 하나씩 설정하고 테스트하느 습관이 필요함!
Restful
- 상태 없이 url만으로 상태를 파악하여 api를 요청하는것!
Ajax
- Ajax(Asynchronous JavaScript and XML)
- 






#기타

sts를 기본으로 생성하면 java1.6 버전으로 되어잇음
