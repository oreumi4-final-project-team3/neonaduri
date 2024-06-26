# neonaduri - 너나들이
## 대한민국 관광지 정보 제공 서비스 & 동행 매칭 서비스
[오르미 4기 Final 프로젝트]

![neonaduriLogo.png](src%2Fmain%2Fresources%2Fstatic%2Fimages%2FneonaduriLogo.png)<br>
<br>

### 목차

- [1. 프로젝트 소개](#1-프로젝트-소개)
- [2. 프로젝트 목표](#2-프로젝트-목표)
- [3. 프로젝트 진행기간](#3-프로젝트-진행-기간)
- [4. 배포 주소](#4-배포-주소)
- [5. 개발 인원 및 역할](#5-개발-인원-및-역할)
- [6. 배포 아키텍쳐](#6-배포-아키텍쳐)
- [7. 사용 기술](#7-skills)
- [8. 개발 일정](#8-개발-일정)
- [9. 플로우차트](#9-플로우차트flow-chart)
- [10. 데이터베이스 모델링](#10-데이터베이스-모델링er-diagram)
- [11. 요구사항 및 기능명세](#11-요구사항-및-기능명세)
- [12. API 명세서](#12-api-명세서)
- [13. 화면설계서](#13-화면설계서)
- [14. 프로젝트 구조](#14-프로젝트-구조)

  
## 1. 프로젝트 소개
**너나들이**란,<br>
"서로 너니 나니 하고 부르며 허물없이 말을 건네거나 그런 사이"를 나타내는 순우리말 입니다.<br>
우리 너나들이는 대한민국 곳곳의 정겨운 관광지들을 소개하고, 여행하는 즐거움을 함께 나눌 수 있는 서비스입니다.

## 2. 프로젝트 목표
- 국내 관광지 정보에 대한 지역별 상세 제공
- 동행 그룹을 모집하여 관광지를 함께 여행할 수 있는 매칭 시스템 제공
- 여행 후기에 대한 커뮤니티 게시판 제공

## 3. 프로젝트 진행 기간

- 2024-04-24 ~ 2024-05-15

## 4. 배포 주소
http://43.202.116.45:8080/neonaduri

## 5. 개발 인원 및 역할
## 🙌 안녕하세요.


|                                                                             김의찬                                                                             |                                                                                                                                                               임성현                                                                                                                                                               |                                                                            최재원                                                                             |                                                                            이하영                                                                             |                                                                    지윤호                                                                     |
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------------:|
| <img src="https://github.com/jeonginwoo/ormi4th-spring-project/assets/128672362/b87c72ea-4e4e-4600-ac82-32a3a3a7803a" style="width: 100px; height: 100px;"> | <img src="src/main/resources/static/images/Sunghyun.jpg" style="width: 100px; height: 100px;"> | <img src="src/main/resources/static/images/Jaewon.jpg" style="width: 100px; height: 100px;"> | <img src="src/main/resources/static/images/Hayoung.png" style="width: 100px; height: 100px;"> | <img src="src/main/resources/static/images/Yoonho.jpg" style="width: 100px; height: 100px;"> |
|                                                     <a href="https://github.com/euichan0927">🔗 김의찬</a>                                                     |                                                                                                                                      <a href="https://github.com/shlim0287">🔗 임성현</a>                                                                                                                                      |                                                     <a href="https://github.com/bbabbungtting">🔗 최재원</a>                                                     |                                                     <a href="https://github.com/emitlight">🔗 이하영</a>                                                     |                                                     <a href="https://github.com/UUUUUKnow">🔗 지윤호</a>                                                     |
|              ‣ 메인페이지 기능 구현 <br><br> ‣ 여기갈까?(관광지 게시글) 페이지 기능 구현<br><br> ‣후기볼까?(리뷰 게시글) 페이지 기능 구현<br><br> ‣ 관심목록 페이지 기능 구현<br><br>              | ‣공공데이터 API 크롤러 구현<br>‣ Alan-SSE API구현<br><br> ‣검색 기능 구현<br><br> ‣실시간 인기 검색어 기능 구현<br><br> ‣댓글 API 구현 <br><br> ‣관광지 상세 페이지 구현<br><br>‣Email API 구현<br>‣프로젝트 배포<br><br> |      ‣ S3 사용 이미지 관련 기능 구현<br><br> ‣ 게시물 관련 기능 구현<br><br> ‣ 퍼블리싱 구현<br><br> ‣ Security 구현<br><br>      |                                       ‣ 마이페이지 기능 구현<br><br> ‣ 나의 매칭 페이지 기능 구현<br><br> ‣ 로그인 페이지 기능 구현                                      |                           ‣ 같이갈까?(동행 게시글) 페이지 디자인 구현<br><br> ‣ 후기볼까?(후기 게시글 리스트 및 생성) 페이지 디자인 구현                                      |



## 6. 배포 아키텍쳐
### Architecture
![neonaduri_architecture](https://github.com/oreumi4-final-project-team3/neonaduri/assets/58384329/79398395-c71a-47cc-afe0-7827b336513f)

## 7. Skills
### Languages
[![My Skills](https://skillicons.dev/icons?i=spring,java,js,html,css)](https://skillicons.dev)

### Tools
[![My Skills](https://skillicons.dev/icons?i=idea,gradle,github,figma,docker)](https://skillicons.dev)

### DataBase
[![My Skills](https://skillicons.dev/icons?i=mysql)](https://skillicons.dev)

### OS
[![My Skills](https://skillicons.dev/icons?i=windows)](https://skillicons.dev)

### Deploy
[![My Skills](https://skillicons.dev/icons?i=aws,githubactions)](https://skillicons.dev)

### API
- Kakao map API
- Alan AI API
- Google login API
- Tour API - 한국관광공사
- Gmail API
- redis
  
## 8. 개발 일정
![간트](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128894133/1deda9ac-95de-4715-a724-b71247c456ca)

## 9. 플로우 차트 (Flow chart)
![flowchart.png](src%2Fmain%2Fresources%2Fstatic%2Fimages%2Fflowchart.png)

## 10. 데이터베이스 모델링(ER Diagram)
![ERD](https://github.com/oreumi4-final-project-team3/neonaduri/assets/58384329/142397f2-bd1f-48e6-9eb6-16d881996c94)

## 11. 기능 명세
![기능명세](https://github.com/oreumi4-final-project-team3/neonaduri/assets/58384329/b8e2d571-7c0a-459a-9c0d-a028a77a7d74)

## 12. API 명세서

### 🔗 API 명세서 노션 링크 : https://www.notion.so/oreumi/API-7bf6e85aa7714842a027135790e3f4b9
<br>

### bookers

| URL                 | HTTP Method | 설명        | 로그인 권한 필요 | 작성자 권한 필요 | Admin 권한 |
|:--------------------|:------------|:----------|:---------:|:---------:|:--------:|
| '/api/bookers/{comId}'           | POST        | 동행 게시글 예약 |     ✅     |          |          |


<br>

### companions

| URL                                      | HTTP Method | 설명                  | 로그인 권한 필요 | 작성자 권한 필요 | Admin 권한 |
|:-----------------------------------------|:------------|:--------------------|:---------:|:---------:|:--------:|
| '/api/companions'             | POST        | 동행 게시글 등록           |     ✅     |     ✅     |          |
| '//api/posts/companions/{userId}/{postId}'             | PUT         | 동행 게시글 수정           |     ✅     |     ✅     |          |
| '/api/companions/{comId}/bookers' | PUT         | 동행 게시글 예약 이후 페이지 수정 |     ✅     |     ✅     |          |
| '/api/companions/{comId}/wishlist' | PUT         | 동행 게시글 찜 이후 페이지 수정  |     ✅     |     ✅     |          |

<br>

### posts

| URL                     | HTTP Method | 설명             | 로그인 권한 필요 | 작성자 권한 필요 | Admin 권한 |
|:------------------------|:------------|:---------------|:---------:|:---------:|:--------:|
| '/api/posts'            | GET         | 게시글 전체 리스트 조회  |     ✅     |           |          |
| '/api/posts/{areaCode}' | GET         | 게시글 지역별 리스트 조회 |     ✅     |           |          |
| '/api/posts'            | POST        | 게시글 등록         |     ✅     |           |          |
| '/api/posts/{id}'       | DELETE      | 게시글 삭제         |     ✅     |     ✅     |          |
| '/api/posts/}id}'       | PUT         | 게시글 수정         |     ✅     |     ✅      |          |


<br>

### replies

| URL                        | HTTP Method | 설명                  | 로그인 권한 필요 | 작성자 권한 필요 | Admin 권한 |
|:---------------------------|:------------|:--------------------|:---------:|:---------:|:--------:|
| 'api/posts/reply/{postId}' | GET         | 게시물에 해당하는 댓글 리스트 조회 |     ✅     |           |          |
| 'api/posts/{postId}'       | POST        | 댓글 생성               |     ✅     |           |          |
| '/api/posts/{postId}/{replyId}/{userId}'       | PUT         | 댓글 수정               |     ✅     |     ✅      |          |
| '/api/posts/{replyId}/{userId}' | DELETE      | 댓글 삭제               |     ✅     |     ✅      |          |

<br>

### spots

| URL                          | HTTP Method | 설명             | 로그인 권한 필요 | 작성자 권한 필요 | Admin 권한 |
|:-----------------------------|:------------|:---------------|:---------:|:---------:|:--------:|
| '/api/alan/{spotName}'       | GET         | 앨런 응답 SSE      |     ✅     |          |          |
| '/api/spots/code/{areaCode}' | GET         | 지역코드 기반 관광지 조회 |     ✅     |          |          |


<br>

### userDetails

| URL                         | HTTP Method | 설명          | 로그인 권한 필요 | 작성자 권한 필요 | Admin 권한 |
|:----------------------------|:------------|:------------|:---------:|:---------:|:--------:|
| '/api/userDetails/{userId}' | PUT         | 사용자 세부정보 수정 |     ✅     |    ✅       |          |
| '/api/userDetails/{userId}' | GET         | 사용자 세부정보 조회 |     ✅     |           |          |

<br>

### users

| URL                   | HTTP Method | 설명          | 로그인 권한 필요 | 작성자 권한 필요 | Admin 권한 |
|:----------------------|:------------|:------------|:---------:|:---------:|:--------:|
| '/api/users'          | POST        | 사용자 정보 생성   |     ✅     |           |          |
| '/api/users/{userId}' | PUT         | 사용자 정보 수정   |     ✅     |     ✅      |          |
| '/api/users/{userId}' | GET         | 사용자 정보 조회   |     ✅     |           |          |
| '/register'           | POST        | 사용자 세부정보 생성 |     ✅     |           |          |

<br>

### wishlist

| URL                        | HTTP Method | 설명          | 로그인 권한 필요 | 작성자 권한 필요 | Admin 권한 |
|:---------------------------|:------------|:------------|:---------:|:---------:|:--------:|
| '/api/wishlist/{admin_id}' | GET         | 사용자 관심목록 조회 |     ✅     |           |          |
| '/api/wishlist/{postId}'   | POST        | 사용자 관심목록 추가 |     ✅     |           |          |

<br>

### view

| URL                                              | HTTP Method | 설명                   | 로그인 권한 필요 | 작성자 권한 필요 | Admin 권한 |
|:-------------------------------------------------|:------------|:---------------------|:---------:|:---------:|:--------:|
| '/companions'                                    | GET         | 동행 게시글페이지 조회         |     ✅     |           |          |
| '/companions/{areaCode}'                         | GET         | 지역 별 동행 게시글 조회       |     ✅     |           |          |
| '/companions/id/{comId}'                         | GET         | 동행 게시글 상세 조회         |     ✅     |           |          |
| '/uploadComapnion'                               | POST        | 동행 게시글 작성              |     ✅     |           |          |
| '/uploadCompanion/{postId}'                      | GET         | 관광지 정보를 통한 동행 게시글 작성 |     ✅     |           |          |
| '/reviews'                                       | GET         | 리뷰 전체 리스트 조회         |     ✅     |           |          |
| '/reviews/{areaCode}'                            | GET         | 지역별 리뷰 게시글 조회        |     ✅     |           |          |
| '/reviews/id/{postId}'                           | GET         | 리뷰 상세페이지 조회          |     ✅     |           |          |
| '/uploadReview'                                  | GET         | 리뷰 게시글 업로드 폼 조회      |     ✅     |           |          |
| '/spots'                                         | GET         | 관광지 전체 리스트 조회        |     ✅     |           |          |
| '/spots/id/{postId}'                             | GET         | 관광지 상세페이지 조회         |     ✅     |           |          |
| '/spots/{areaCode}}'                             | GET         | 관광지 지역별 리스트 조회       |     ✅     |           |          |

<br>

## 13. 화면설계서

|                                                                                                                                           |                                                                                                                                              |
|:------------------------------------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------|
| 회원가입<br/>![1-2 사용자-회원가입](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/3585136c-0f9b-47f4-bde9-2c4f2ed6a92e)                 | 로그인<br/>![1  사용자-로그인](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/5099c7bb-327e-4d73-a0a4-46dfb393b72d)                |
| 마이페이지<br/>![2-2 사용자-마이페이지-상세](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/b6b0613a-afbf-4767-95d4-c110294defb8)     | 관심있는 매칭<br/>![3-2 사용자-관심있는 매칭-상세](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/0934a144-4e08-4988-982d-3712fb776709)        |
| 메인페이지<br/>![1  메인](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/8ede4a22-354c-4fe8-add7-bc0ee2112979)              | 메인페이지-실시간 인기 검색어<br/>![2-3  메인-검색-실시간 인기검색어](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/a554b16e-7601-411a-b203-b08e092ce4e7)                 |
| 여기갈까?-관광지 전체지역 조회<br/>![여기갈까?-관광지 전체지역 조회](https://github.com/jeonginwoo/ormi4th-spring-project/assets/128672362/c1a9f885-8310-49e2-ada1-99226cdfb070)            | 여기갈까?-관광지 제주지역 조회<br/>![여기갈까-조회-지역-제주](https://github.com/jeonginwoo/ormi4th-spring-project/assets/128672362/270cd3bb-6723-4603-9df4-68ac8c895726) |
| 여기갈까?-관광지 상세조회 ai 답변 전<br/>![6  여기갈까-상세조회-제주-ai답변 후](https://github.com/jeonginwoo/ormi4th-spring-project/assets/128672362/ee9f6593-ef22-4ed1-9604-d34a67290a26)              | 여기갈까?-관광지 상세조회 ai 답변 후<br/>![5  여기갈까-상세조회-제주-ai답변 전](https://github.com/jeonginwoo/ormi4th-spring-project/assets/128672362/4084bfb8-0487-4bd9-b0d9-851581831d43)               |
| 여기갈까?-관광지 예약하기<br/>![6-1  여기갈까-상세조회-제주-예약하기](https://github.com/jeonginwoo/ormi4th-spring-project/assets/128672362/c7f6538a-9779-4a0e-9031-b6144a6b0e6b)              | 같이갈까?-동행 전체지역 조회<br/>![1  같이갈까-조회-지역-전체](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/9cec5082-6c92-491d-8720-b7fc5ac2bfb0)                 |
| 같이갈까?-동행 경북지역 조회<br/>![3  같이갈까-조회-지역-경북](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/7e0f2eb2-749c-4804-8697-cfa4687d5d06)            | 같이갈까?-상세페이지(마감 전)<br/>![1  같이갈까-상세 조회-동행 마감 전](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/9f6abbdd-9412-4ac0-84b1-0f47fddf8351)                 |
| 같이갈까?-상세페이지(마감 후)<br/>![2  같이갈까-상세 조회-동행 마감 후-댓글 생성](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/6f111c7a-80ec-43b4-bda9-0e32676e2259)              | 같이갈까?-동행게시글 생성<br/>![1  같이갈까-동행 생성](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/508731ff-8ad1-4085-93de-31fb97df56a4)                 |
| 후기볼까?-전체지역 조회)<br/>![1  후기볼까-조회-지역-전체](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/a8003f66-1634-4eda-a286-35fbc90bb376)              | 후기볼까?-서울 지역 조회<br/>![2  후기볼까-조회-지역-서울](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/345e93a2-3387-46b6-9ce6-2bb925b90ba0)                 |
| 후기볼까?-상세조회<br/>![1  후기볼까-상세조회](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/bdeaa5be-260e-41c1-900f-6a787fa21889)                 | 후기볼까?-후기 생성<br/>![1-2  후기볼까-후기 생성](https://github.com/oreumi4-final-project-team3/neonaduri/assets/128672362/e73f14c6-a52b-4d1a-b525-327430405f51)                |





## 14. 프로젝트 구조
```text
└───📁src
    ├──📁main
    │   ├───📁java
    │   │   └───📁com
    │   │       └───📁est
    │   │           └───📁neonaduri
    │   │               │   📄NeonaduriApplication.java
    │   │               │
    │   │               ├───📁domain
    │   │               │   ├───📁bookers
    │   │               │   │   ├───📁controller
    │   │               │   │   │       📄BookersController.java
    │   │               │   │   │
    │   │               │   │   ├───📁domain
    │   │               │   │   │       📄Bookers.java
    │   │               │   │   │
    │   │               │   │   ├───📁repository
    │   │               │   │   │       📄BookersRepository.java
    │   │               │   │   │
    │   │               │   │   └───📁service
    │   │               │   │           📄BookersService.java
    │   │               │   │
    │   │               │   ├───📁companions
    │   │               │   │   ├───📁controller
    │   │               │   │   │       📄CompanionsController.java
    │   │               │   │   │
    │   │               │   │   ├───📁domain
    │   │               │   │   │       📄Companions.java
    │   │               │   │   │
    │   │               │   │   ├───📁dto
    │   │               │   │   │       📄AddCompanionsRequest.java
    │   │               │   │   │       📄CompanionsDTO.java
    │   │               │   │   │       📄CompanionsListDTO.java
    │   │               │   │   │       📄CompanionsResponseDTO.java
    │   │               │   │   │       📄CompanionsWriteDTO.java
    │   │               │   │   │
    │   │               │   │   ├───📁repository
    │   │               │   │   │       📄CompanionsRepository.java
    │   │               │   │   │
    │   │               │   │   └───📁service
    │   │               │   │           📄CompanionsService.java
    │   │               │   │
    │   │               │   ├───📁postImages
    │   │               │   │   ├───📁domain
    │   │               │   │   │       📄PostImages.java
    │   │               │   │   │
    │   │               │   │   ├───📁repository
    │   │               │   │   │       📄PostImagesRepository.java
    │   │               │   │   │
    │   │               │   │   └───📁service
    │   │               │   │           📄PostImagesService.java
    │   │               │   │
    │   │               │   ├───📁posts
    │   │               │   │   ├───📁controller
    │   │               │   │   │       📄PostsController.java
    │   │               │   │   │       📄SearchController.java
    │   │               │   │   │
    │   │               │   │   ├───📁domain
    │   │               │   │   │       📄Posts.java
    │   │               │   │   │
    │   │               │   │   ├───📁dto
    │   │               │   │   │       📄AddPostRequest.java
    │   │               │   │   │       📄CreatePostDTO.java
    │   │               │   │   │       📄PostSearchCondition.java
    │   │               │   │   │       📄PostsListDTO.java
    │   │               │   │   │       📄PostsResponseDTO.java
    │   │               │   │   │       📄PostViewResponse.java
    │   │               │   │   │       📄PostWriteDTO.java
    │   │               │   │   │       📄UpdatePostDTO.java
    │   │               │   │   │       📄UpdatePostRequest.java
    │   │               │   │   │
    │   │               │   │   ├───📁repository
    │   │               │   │   │       📄PostsCustomRepository.java
    │   │               │   │   │       📄PostsRepository.java
    │   │               │   │   │       📄PostsRepositoryImpl.java
    │   │               │   │   │
    │   │               │   │   └───📁service
    │   │               │   │           📄PostsService.java
    │   │               │   │           📄SearchService.java
    │   │               │   │
    │   │               │   ├───📁replies
    │   │               │   │   ├───📁controller
    │   │               │   │   │       📄RepliesController.java
    │   │               │   │   │
    │   │               │   │   ├───📁domain
    │   │               │   │   │       📄Replies.java
    │   │               │   │   │
    │   │               │   │   ├───📁dto
    │   │               │   │   │       📄ReplyRequestDto.java
    │   │               │   │   │       📄ReplyResponseDto.java
    │   │               │   │   │
    │   │               │   │   ├───📁repository
    │   │               │   │   │       📄RepliesRepository.java
    │   │               │   │   │
    │   │               │   │   └───📁service
    │   │               │   │           📄RepliesService.java
    │   │               │   │
    │   │               │   ├───📁spots
    │   │               │   │   ├───📁controller
    │   │               │   │   │       📄SpotsController.java
    │   │               │   │   │
    │   │               │   │   ├───📁domain
    │   │               │   │   │       📄Spots.java
    │   │               │   │   │
    │   │               │   │   ├───📁dto
    │   │               │   │   │       📄SpotNameDTO.java
    │   │               │   │   │       📄SpotPageDto.java
    │   │               │   │   │       📄SpotsListDTO.java
    │   │               │   │   │
    │   │               │   │   ├───📁repository
    │   │               │   │   │       📄SpotsRepository.java
    │   │               │   │   │
    │   │               │   │   └───📁service
    │   │               │   │           📄SpotsService.java
    │   │               │   │
    │   │               │   ├───📁userDetails
    │   │               │   │   ├───📁controller
    │   │               │   │   │       📄UserDetailsController.java
    │   │               │   │   │
    │   │               │   │   ├───📁domain
    │   │               │   │   │       📄UserDetails.java
    │   │               │   │   │
    │   │               │   │   ├───📁dto
    │   │               │   │   │       📄UserDetailsRequestDto.java
    │   │               │   │   │
    │   │               │   │   ├───📁repository
    │   │               │   │   │       📄UserDetailsRepository.java
    │   │               │   │   │
    │   │               │   │   └───📁service
    │   │               │   │           📄UserDetailsService.java
    │   │               │   │
    │   │               │   ├───📁users
    │   │               │   │   ├───📁controller
    │   │               │   │   │       📄ProfileUploadController.java
    │   │               │   │   │       📄UserController.java
    │   │               │   │   │
    │   │               │   │   ├───📁domain
    │   │               │   │   │       📄Users.java
    │   │               │   │   │
    │   │               │   │   ├───📁dto
    │   │               │   │   │       📄UserDTO.java
    │   │               │   │   │
    │   │               │   │   ├───📁repository
    │   │               │   │   │       📄UserRepository.java
    │   │               │   │   │
    │   │               │   │   └───📁service
    │   │               │   │           📄UserService.java
    │   │               │   │
    │   │               │   └───📁wishlist
    │   │               │       ├───📁controller
    │   │               │       │       📄WishListController.java
    │   │               │       │
    │   │               │       ├───📁domain
    │   │               │       │       📄Wishlist.java
    │   │               │       │
    │   │               │       ├───📁repository
    │   │               │       │       📄WishListRepository.java
    │   │               │       │
    │   │               │       └───📁service
    │   │               │               📄WishListService.java
    │   │               │
    │   │               └───📁global
    │   │                   ├───📁config
    │   │                   │       📄BaseTimeEntity.java
    │   │                   │       📄ImageFileConfig.java
    │   │                   │       📄S3Config.java
    │   │                   │
    │   │                   ├───📁infra
    │   │                   │   ├───📁alanapi
    │   │                   │   │   │   📄AlanController.java
    │   │                   │   │   │
    │   │                   │   │   ├───📁config
    │   │                   │   │   │       📄ApiConst.java
    │   │                   │   │   │       📄AppConfig.java
    │   │                   │   │   │
    │   │                   │   │   ├───📁dto
    │   │                   │   │   │       📄AlanApiSseDto.java
    │   │                   │   │   │
    │   │                   │   │   └───📁service
    │   │                   │   │           📄AlanService.java
    │   │                   │   │
    │   │                   │   ├───📁emailapi
    │   │                   │   │   ├───📁config
    │   │                   │   │   │       📄EmailConfig.java
    │   │                   │   │   │
    │   │                   │   │   └───📁service
    │   │                   │   │           📄EmailApi.java
    │   │                   │   │
    │   │                   │   ├───📁redis
    │   │                   │   │   │   📄TempController.java
    │   │                   │   │   │
    │   │                   │   │   ├───📁config
    │   │                   │   │   │       📄RedisConfig.java
    │   │                   │   │   │
    │   │                   │   │   └───📁dto
    │   │                   │   │           📄SearchRankResponseDto.java
    │   │                   │   │
    │   │                   │   └───📁tourapi
    │   │                   │       ├───📁config
    │   │                   │       │       📄ApiConst.java
    │   │                   │       │       📄AreaCode.java
    │   │                   │       │       📄ContentCode.java
    │   │                   │       │
    │   │                   │       ├───📁dto
    │   │                   │       │       📄TourApiDto.java
    │   │                   │       │
    │   │                   │       └───📁service
    │   │                   │               📄ApiManager.java
    │   │                   │               📄TourApiCrawler.java
    │   │                   │
    │   │                   ├───📁utils
    │   │                   │       IdGenerator.java
    │   │                   │
    │   │                   └───📁view
    │   │                           📄CompanionPageController.java
    │   │                           📄mainPageController.java
    │   │                           📄ReviewPageController.java
    │   │                           📄SpotPageController.java
    │   │
    │   └───📁resources
    │       │   📄application.properties
    │       │   📄config.properties
    │       │   📄data.sql
    │       │
    │       ├───📁static
    │       │   ├───📁css
    │       │   │       📄companions.css
    │       │   │       📄companionsDetail.css
    │       │   │       📄header.css
    │       │   │       📄here.css
    │       │   │       📄login.css
    │       │   │       📄main.css
    │       │   │       📄my-matching.css
    │       │   │       📄mypage.css
    │       │   │       📄post-spot-page.css
    │       │   │       📄reviewdetail.css
    │       │   │       📄reviewList.css
    │       │   │       📄search-result.css
    │       │   │       📄uploadCompanion.css
    │       │   │       📄uploadReview.css
    │       │   │       📄wishlist.css
    │       │   │
    │       │   ├───📁images
    │       │   │       
    │       │   └───📁js
    │       │           📄alan.js
    │       │           📄companions.js
    │       │           📄companionsDetail.js
    │       │           📄here.js
    │       │           📄login.js
    │       │           📄main.js
    │       │           📄map.js
    │       │           📄myMatching.js
    │       │           📄mypage.js
    │       │           📄page.js
    │       │           📄post-spot-page.js
    │       │           📄posts.js
    │       │           📄review.js
    │       │           📄reviewList.js
    │       │           📄uploadCompanion.js
    │       │           📄uploadReview.js
    │       │           📄wishlist.js
    │       │
    │       └───📁templates
    │               📄companions.html
    │               📄companionsDetail.html
    │               📄footer.html
    │               📄header.html
    │               📄here.html
    │               📄login.html
    │               📄main.html
    │               📄myMatching.html
    │               📄mypage.html
    │               📄newReview.html
    │               📄post-spot-page.html
    │               📄review.html
    │               📄reviewList.html
    │               📄search-result.html
    │               📄uploadCompanion.html
    │               📄uploadReview.html
    │               📄wishlist.html
    │
    └───📁test
        └───📁java
            └───📁com
                └───📁est
                    └───📁neonaduri
                            📄NeonaduriApplicationTests.java

```




