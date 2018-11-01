package org.sopt.seminar2.api;

import org.sopt.seminar2.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post") //Controller자체에 URL 매핑이 가능하다. 그냥 ""이렇게 냅두거나 생략시 default값은 Get이다.

public class PostController {
    @PostMapping("") //Post메소드 전용 Controller Annotation
    public String postUser(@RequestBody final User user){
        return user.getName();
    }
    //기본생성자 하나 만들어 줘야지 500에러 안뜸->다음주에 안써도 되는 법 알려줄것임
    //name만 보내거나 part만 보내도 된다. 그리고 심지어 다른거 보내도 됌->"phone"="Dd" 단지 값이 비어있을 뿐
    //톰캣으로 App배포 할때 인텔리제이 서버 끄고 해야함
}
