# 📕난이도 평가 서비스

<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/AWS-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white">


![ez2on](https://github.com/JangHyeonChul/ez2onServer/assets/74286316/5e9ce0ce-1c4f-468d-a7a6-19a8779b3db8)




# *Description*<br/>
**<br/>프로젝트 명 : 난이도 평가 서비스**




- 분포해있는 여러가지 곡들의 코멘트를 달고 평가를 내릴수있다
- 내린 평가를 바탕으로 순위를 매길수있다
- 다양한 검색조건 (종합, DLC별)으로 확인할수 있다
- 배포를 통해 유저들의 건의사항(추가사항, 변경사항 등)를 수용하고 개선한다

<br/>👦 개인 프로젝트

🕛 프로젝트 제작 기간 : 2023-05-13 ~ 서비스 종료까지

🧑‍🤝‍🧑 참여 인원 1명 (개인)

🔍 사용 툴 IntellJ, AWS

<br/>
<br/>
<br/>
<br/>

# *Skills*<br/>
**FrontEnd**
- HTML5
- CSS
- JQUERY
- JS


**BackEnd**
- Spring Boot 3.0.x<br/>
- MySQL<br/>
- Mybatis<br/>
- 타임리프<br/><br/><br/>


**Etc**
- AWS(RDS, EC2, S3)<br/>
- IntellJ<br/><br/><br/>



# *Information*<br/>

**ERD**

<br/>

![ez2onerd](https://github.com/JangHyeonChul/ez2onServer/assets/74286316/3948e2cb-816e-43a5-bd6b-d6fc47a1bc8a)

<br/>
<br/>
<br/>


- 최대한 정규화를 통해 여러 이상현상들을 제어


<br/>
<br/>

프로젝트 제작과정에 쓰인 ERD로써 **ERD Cloud**를 사용하여 만들었습니다

**해당 주소 : [https://www.erdcloud.com/d/6Te5fmKs5DpDtHL7o](https://www.erdcloud.com/d/T2JFNAp2QvMFW9CML)**


<br/>

---

<br/>




**디렉터리구조**

![dearcki](https://github.com/JangHyeonChul/ez2onServer/assets/74286316/507ac8d2-c4de-47b0-9e82-fe7e58fc4aa1)

<br/>
<br/>
<br/>

프로젝트는 도메인 디렉터리 구조로 domain에 각각 공통된 기능을 하는 모듈로 묶어 관리하며

global에는 서비스에 전체적으로 쓰일수있는 기능을 위주로 묶어 관리하였습니다







<br/>

---

<br/>

**평가시스템**

![3](https://github.com/JangHyeonChul/ez2onServer/assets/74286316/3d1dc000-0244-4b7e-9cb1-34a53d930175)

<br/>
<br/>
<br/>

사용자는 평가를 원하는 곳에서 Commnet를 달아 평가난이도 (0 ~ 100)을 입력 후 평가가 집계됩니다

1차적으로 클라이언트에서 공백여부, 평가난이도의 범위 유효성, 입력여부 등을 체크하고 문제없을시

서버로 해당 데이터를 보내 다시 2차로 CommentValid를 통해 한번더 검사한뒤 최종적으로 평가 집계가 진행되며 갱신됩니다




<br/>

---

<br/>

**요구사항**

![4](https://github.com/JangHyeonChul/ez2onServer/assets/74286316/48caa260-52ae-4ab3-85c0-ad5ce33d104b)



<br/>
<br/>
<br/>

직접 해당 게임 커뮤니티사이트에 배포하고 나의 서비스를 이용, 

추가사항이나 개선사항을 Notion에 정리하여 하나씩 개선해나가는 방향으로 서비스의 품질을 높히고있으며,

비록 마이너한 주제다 보니깐 사용자가 그렇게 많지는 않지만 내가 만들었을때는 보지못했던 버그나, 더 좋은 방향을 사용자가 직접 말해주고 수용





<br/>

---

<br/>


# *Link*<br/>

**결과물**

**Notion : https://www.notion.so/janghyeonchul/1f4941b7920e4d468d50a0da31b4ed60**












