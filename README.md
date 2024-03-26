# WorkHub

### 프로젝트 소개
- 회사 내부 시스템으로 서비스를 제공하는 웹 애플리케이션

### 규칙
- Common
  - 요청, 응답 객체는 Model 패키지에 분리
  - 기능이 다르면 사용하는 필드가 비슷해도 클래스 분리 
    - ex) 생성, 수정 Request 객체는 처음엔 비슷하지만 나중에 달라질 가능성이 큼
- Controller
  - 요창받는 데이터 검증은 Spring Validation을 사용하여 Controller에서 처리
- Service
  - 비즈니스 로직을 처리하는 로직은 Service에서 처리
  - 요청, 응답하는 데이터 형식을 DTO로 변환한다.
  - 역할에 따라 분리될수 있음. 예) 게시판 CRUD, 비즈니스 로작을 처리하는 PostService, DTO 변환 처리하는 PostWebService 등 
- Repository
- Test Code
- Etc
  - 수정할 필드만 보낼지, 전체를 보낼지는 협의