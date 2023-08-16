# Web Server 와 WAS

## 웹 서버(Web Server)

- 웹에서 서버기능을 수행하는 프로그램으로 HTML 문서나 JPG, PNG 같은 이미지를 HTTP 프로토콜을 통해 웹 브라우저에 제공하는 서버

- 서버 내부에 이미 만들어져 있는 정적인 요소들을 화면에 제공하는 역할

- Apache : Apache Software Foundation에서 만든 웹 서버로 HTTP 통신에 대한 여러 라이브러리 제공

## 웹 어플리케이션 서버(WAS, Web Application Server)

- 웹 서버가 할 수 없는 다양한 비즈니스 로직을 수행하고 동적인 페이지를 만들어 제공하는 서버

- 웹 어플리케이션 서버는 웹 서버와 컨테이너로 구성

- Tomcat : Apache Software Foundation에서 서블릿(Servlet)과 JSP를 통한 동적인 웹 문서를 처리하기 위해 만든 웹 애플리케이션 서버

<br>

# 서블릿(Servlet)

- 웹 서비스를 위한 자바 클래스를 말하며 자바를 사용해서 웹을 만들기 위한 기술

- 웹 브라우저로부터 요청을 받아 처리하고 결과를 다시 웹 브라우저로 전송하는 역할

## 동작 구조

1. 클라이언트가 웹 브라우저를 통해 요청을 보낸다.

2. 해당 요청이 서블릿에 대한 요청이면, 서블릿 컨테이너에게 처리를 넘긴다.

3. 서블릿에서 요청이 대한 실행이 완료된 후에는 서블릿 컨테이너가 실행 결과를 웹 서버에 전달한다.

4. 웹 서버는 서비스를 요청한 클라이언트에 응답한다.

5. 컨테이너의 서블릿에 대한 설정은 배포 서술자(web.xml)에 작성한다.

### 배포 서술자(Deployment Descriptor)

- 배포 서술자(Deployment Descriptor)는 애플리케이션에 대한 전체 설정정보를 가지고 있는 파일

- 배포 서술자의 정보를 웹 컨테이너가 서블릿 구동한다.

### 서블릿 매핑

- 사용자의 요청을 서블릿에게 전달하기 위해서는 서블릿을 등록하고 매핑해야 한다.

- 매핑하는 방법은 web.xml과 @annotation을 이용하는 방법이 있다.

```java

@WebServlet("접근 URL 패턴")
public class 서블릿이름 extends HttpServlet{
    // servlet code....
}

```

```xml

<servlet>

    <servlet-name>서블릿 이름</servlet-name>
    <servlet-class>서블릿 클래스</servlet-class>

</servlet>

<servlet-mapping>

    <servlet-name>서블릿 이름</servlet-name>
    <url-pattern>접근 url 패턴</url-pattern>

</servlet-mapping>

```

## HttpServlet

- 서블릿이 웹상에서 HTTP 프로토콜을 이용해 서비스를 처리하기 위해 반드시 상속해야 하는 클래스이다.

```java

public class 클래스명 extends HttpServlet {

}

```

### HttpServletRequest

- 클라이언트(웹 브라우저)에서 서버에 보내는 요청 정보를 제공하는 객체

- javax.servlet.ServletRequest를 상속

- getParameter(String) : client가 보내준 값이 저장된 명칭이 매개변수와 같은 명칭에 저장된 값을 불러오는 메소드

- getParameterValues(String) : client가 보내준 값이 여러 개일 경우 그 값을 배열로 불러오는 메소드

- setCharacterEncoding(String) : 전송받은 request 객체의 값들의 CharacterSet을 설정해 주는 메소드

### HttpsServletResponse

- 서버가 클라이언트(웹 브라우저)로 보내는 응답 정보를 처리하는 객체

- javax.servlet.ServletResponse를 상속

- getWriter() : 문자를 페이지에 전송하기 위한 Stream을 가져오는 메소드

- setContentType(String) : 응답으로 작성하는 페이지의 MIME type을 정하는 메소드

## 서블릿 생명주기(Life Cycle)

- 서블릿 객체가 생성 후 소멸되기까지의 과정을 라이프 사이클이라고 한다.

1. 첫번째 요청일 경우, 서블릿 객체를 생성하고 init() 메소드를 호출한다. (단, 한번만 수행!)

2. service() 메소드가 클라이언트 요청 방식에 따라 doGet(), doPost() 메소드를 호출한다.

3. 최종적으로 서블릿이 서비스 되지 않았을 때 destroy() 메소드를 호출한다.

# JSP(Java Server Page)

- HTML 코드 안에서 스크립트 형태로 자바 언어를 사용하여 동적인 페이지를 구현한다.

- JSP의 목표를 서블릿의 비즈니스 로직으로부터 화면 로직을 분리하는 것을 목표로 한다.

```
<script>
    // 자바 스크립트 코드...
</script>

<%= ... %>
```

## Servlet vs JSP (차이)

- Servlet : Java 코드에 HTML 코드 삽입 (비즈니스 로직에 적합)

- JSP : HTML 코드에 Java 코드 삽입 (화면 로직에 적합)

## JSP 실행과정

- 웹 컨테이너는 클라이언트로부터의 요청이 JSP에 대한 요청일 경우 먼저 JSP
  파일을 자바코드(서블릿, Servlet)로 변환한다.

- 변환된 자바코드(서블릿, Servlet)를 컴파일하고, 서블릿 인스턴스를 생성한다.

- 서블릿 인스턴스가 생성되면 서블릿(Servlet)의 라이프 사이클(Life Cycle)을 거치면서 클라이언트의 요청을 처리해준다.

## JSP의 특징

- 자바 언어를 이용하기 때문에 대부분의 운영체제에서 사용이 가능하다.

- 서버 자원을 효율적으로 사용한다.(요청을 스레드 단위로 처리)

- MVC 패턴을 쉽게 적용할 수 있다.

- JSP 파일의 배포 위치는 HTML 파일과 동일하다.

---

## EL

- EL(Expression Language)은 JSP 2.0 버전에서 추가된 표현 언어

- 표현식(Expression) 태그를 대신 하여 클라이언트에 출력하고 자 하는 값들을 좀 더 간결하게 사용하는 방법

```
<%= request.getParameter("name") %>

${param.name}

```

### EL 내장 객체

- requestScope : Request 영역 객체에 접근

- sessionScope : Seesion 영역 객체에 접근

- applicationScope : Application 영역 객체에 접근

- param : 전달된 파라미터 값을 받아올 때 사용

- paramValues : 전달된 파라미터들을 배열로 받아올 때 사용

### EL 연산자

- 나눗셈(/) : div

- 나머지(%) : mod

- and, or, ! : and, or, not

- < : lt(less than)

- > : gt(greater than)

- <= : le(less or equal)

- > = : ge(greater or equal)

- == : eq(equal)

- != : ne(not equal)

- null값 처리(value==null) : empty

## JSP 액션 태그

- JSP 페이지에서 자바 코드를 직접 입력하지 않고 특정 작업을 수행하는데 사용하는 태그

- 액션 태그의 경우 웹 브라우저에서 실행되는 것이 아니라 웹 컨테이너에서 실행된다.

- 표준 액션 태그 : JSP페이지에서 바로사용, 태그 앞에 jsp 접두어가 붙음

- 커스텀 액션 태그 : 별도의 라이브러리 설치 필요, 라이브러리 선언에 맞는 접두어가 붙음

### JSTL (JSP Standard Tag Library)

- JSP에서 사용하는 커스텀 태그

- JSP 페이지에서 자주 사용하는 코드들을 사용하기 쉽게 태그로 만들어서 표준으로 제공한다.

#### JSTL 라이브러리

- 톰캣(http://tomcat.apache.org)에서 JSTL 라이브러리를 다운로드

- 웹 프로젝트의 lib 폴더에 다운로드한 JSTL 라이브러리를 붙여 넣는다.

- JSTL 라이브러리 JSP 페이지에서 taglib 지시자로 선언해야 사용이 가능하다.

```java

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

```

#### c:set 태그

- 변수를 선언하고 초기값을 대입하는 태그

- 변수의 자료형은 별도로 선언하지 않지만 초기값은 반드시 기술해야 한다.

- 선언된 변수는 EL 구문에서 사용이 가능하다.

```java

<c:set var="num" value="100"/>

${num}

```

- scope 속성은 변수가 저장된 영역을 지정한다. (기본값은 page)

```jsp

<c:set var="num" value="100" scope="request"/>

```

- <c:set> ~ </c:set> 사이에 ","를 이용해서 배열이나 Collection처럼 여러개의 값을 지정할 수 있다.

```jsp

<c:set var="array" scope="request">
yellow, blue, pink, red, green
</c:set>

```

#### c:if 태그

- 자바의 if 구문과 같은 역할을 하는 태그

- 조건식은 test 속성의 EL 구문으로 기술해야 한다.

- 조건식의 결과가 참일 때, `<c:if>~</c:if>`사이의 있는 내용을 처리한다.

```jsp

<c:if test="${num1 > num2}">
</c:if>

```

#### c:choose 태그

- 자바의 switch 구문과 같은 역할을 하는 태그

- 하위 태그인 `<c:when>`, `<c:otherwise>` 태그와 함께 사용되는데, 각각 switch 구문의 case, default 절과 비슷한 역할을 한다.

```jsp

<c:choose>
    <c:when test="${num1 eq 0}"></c:when>
    <c:when test="${num2 eq 1}"></c:when>
    <c:otherwise></c:otherwise>

</c:choose>

```

#### c:forEach 태그

- 자바의 for 구문에 해당하는 역할을 하는 태그

```jsp

<c:forEach begin="1" end="10" items="${list}" var="value">
</c:forEach>

```

- items : 반복할 객체 명 (Collection 객체)

- begin : 반복이 시작할 요소 번호

- end : 반복이 끝나는 요소 번호

- step : 반복할 횟수 번호

- var : 현재 반복 횟수에 해당하는 변수 이름

# Ajax (Asynchronous JavaScript and XML)

- JavaScript를 이용하여 비동기식으로 클라이언트와 서버가 데이터(XML)를 주고 받는(통신) 방식

- 데이터 형식을 XML 뿐만 아니라 Text, HTML, **JSON**, CSV 등 다양한 형식 사용가능

### 동기식 VS 비동기식

- **동기식 데이터 통신** : 클라이언트가 서버로 데이터를 요청하면 응답이 올때까지 다른 작업 대기

- **비동기식 데이터 통신** : 클라이언트가 서버로 데이터 요청 후 응답을 기다리지 않고 다른 작업 수행가능, 추후 응답이 오면 응답에 관련된 작업 진행

### 특징

- 전체 페이지를 갱신하지 않고 일부분만 업데이트가 가능하며 사용자에게 즉각적인 반응과 풍부한 UI 경험 제공

- JavaScript 또는 jQuery 방식으로 구현

### 단점

- Ajax는 JavaScript이므로 브라우저에 따른 크로스 브라우저 처리가 필요하다.

- 연속적인 데이터 요청 시 서버에 부하가 증가하여 페이지가 느려질 수 있음

- 페이지 내 복잡도가 증가하여 에러 발생 시 디버깅이 어려움

## JavaScript 방식

- 브라우저 내장 객체인 XMLHttpRequest를 이용하여 비동기식으로 데이터를 송수신한다.

1. 객체 생성 : script문에 요청을 위한 XMLHttpRequest 객체를 생성

2. 서버 응답 처리 함수 생성 및 지정 : onreadystatechange에 함수 지정

   - readyState : 서버 응답상태 확인
   - status : Http 응답 상태코드 확인
   - responseText / responseXML : 서버 응답 데이터에 접근

3. open() 메소드를 호출하여 요청방식, 대상(서버), 동기/비동기 지정

4. send() 메소드를 호출하여 대상(서버)에 전송

## jQuery 방식

- jQuery에 내장되어 있는 Ajax 통신을 위한 가장 기본적인 함수 이용

```js
$.ajax({
  url: "요청이 전송되는 url이 표함된 문자열(필수 구현 속성)",
  [settings...]
});
```

### 주요 속성

- url : 요청(request) 데이터를 전송할 URL

- type : Http 요청 방식 지정(GET/POST)

- data : 서버로 전송할 요청 Parameter 설정

- datatype : 서버의 응답(response) 데이터의 형식(xml, text, json, html, 등) 지정, 미작성 시 자동으로 판단하여 지정

- success(data) : ajax 통신 성공 시 호출되는 함수를 지정, 매개변수로 응답 데이터(data)를 받음

- error : ajax 통신 실패 시 호출되는 함수를 지정

- complete : ajax 통신 성공여부와 관계없이 통신 완료 후 실행되는 함수 지정(java의 try/catch의 finally와 유사)

- async : 비동기(true) / 동기(false) 지정

### 장점

- 코드 길이가 감소하여 JavaScript 방식보다 구현 방법이 간단

- 직관적이며 다양한 방법의 코딩 가능

- 크로스 브라우저 처리를 jQuery가 자동으로 해결

## JSON

- JavaScript Object Notation(자바스크립트 객체 표현법)의 약자

- 간단한 포맷 : 괄효 {} 내에 key:value 쌍으로 구성 -> {"key" : value}

- key는 반드시 문자열 사용하며 value는 String, Number, Boolean, Array, Object, null 저장 가능

- 객체 {} 또는 배열 [] 데이터를 효율적으로 표시 가능

### 특징

- Ajax 통신에서 Object 타입의 데이터 전송 시 XML 대비 용량이 자곡 속도가 빠름(경량 데이터 교환 방식)

- 간단한 포맷을 가지고 있어 이해하기 쉬움

- 순수 Text 기반으로 Text 형식이 구조화 되어 있으며 대부분의 프로그래밍 언어에서 JSON 포맷 데이터를 핸들링 할 수 있는 라이브러리를 제공하여 시스템간 객체 교환에 용이
