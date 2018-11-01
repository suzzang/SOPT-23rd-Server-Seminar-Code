package org.sopt.seminar2.api;

import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

//서버실행 단축기 Shift+F10

@RestController//@Controller+@ResponseBody API에 관한 클래스다 라는걸 알려줌
public class FirstController {

    @GetMapping("") //Get method, ""이부분에 URL매핑을 시킬것 이부분을 디자인 잘 을 하는것이 앱잼의 성공유무, 리소스를 조회하는 요청에 사용
    public String hello(){
        return "hello world!";
    }

    //유알엘 안바꾸고 8080으로 그대로 들어갔는데, method = RequestMethod.Get이 위에 쓴거하고 같음, 이건 너무 길다, 그래서 겟매핑 어노테이션 쓸거임
//    @RequestMapping(method = RequestMethod.GET,value = "")
//    public String hello2(){
//        return "Nice to Meet You!";
//    }

    //같은 메소드가 두개면 서버 실행이 안된다.

    @GetMapping("1")
    public String hello2(){
        return "hello world!!";
    }

    @GetMapping("/get1")
    public String get1(){
        return "1";
    }

    // 슬래쉬를 생략해도 된다. 처음만 가능하다! 그건 밑에서 보여줌!

    @GetMapping("/get1/최수정")
    public String get2(){
        return "최수정";
    }

    //여기선 반드시 /최수정 이렇게 해줘야함!

    @GetMapping("/name/{name}")//required 에 따라 값을 반드시 넣어야하는지 안넣어도 되는지의 여부를 가림
    public String getName(@PathVariable(value = "name",required = false)final String name){
        return name;
    }




    //RequestParam이란 쿼리스트링을 처리할때 사용하는것! /part?part=서버 에서 ?part=서버 와 같은 문법

    @GetMapping("/part")
    public String getPart(@RequestParam(value = "part",defaultValue = "")final String part){
        return part;
    }
    @GetMapping("/info")
    public String getPart2(@RequestParam(value = "name")final String name,
                           @RequestParam(value = "type",defaultValue ="yb")final String type){
        return name+"이고"+type+"입니다.";
    }//http://127.0.0.1:8080/info?name=최수정&type=ob 요렇게!!

    @GetMapping("/num")
    public int number(@RequestParam(value = "num")final int[] num){
        int sum = 0;
        for (int i : num){
            sum += i;
        }
        return sum;
    }//http://127.0.0.1:8080/num?num=1&num=2&num=3 요런식으로 &로 묶어서 연속으로 날린다.



}
