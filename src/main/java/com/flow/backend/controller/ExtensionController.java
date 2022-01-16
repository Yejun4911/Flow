package com.flow.backend.controller;

import com.flow.backend.domain.Fix;
import com.flow.backend.domain.Message;
import com.flow.backend.domain.Variable;
import com.flow.backend.service.FixService;
import com.flow.backend.service.VariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ExtensionController {

    @Autowired
    FixService fixService;

    @Autowired
    VariableService variableService;

    @GetMapping("api/fix/list") // 고정 확장자 전체 리스트
    public ResponseEntity fList() {
        List<Fix> list = fixService.fixList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PostMapping("api/fix/check") // 고정 확장자 Checked 팡가
    public ResponseEntity check(@RequestParam(value = "id") int id){
        fixService.fixCheck(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("api/variable/list") // 가변 확장자 List
    public ResponseEntity vList() {
        List<Variable> list = variableService.variableList();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    @GetMapping("api/variable/count") // 가변 확장자 갯수
    public ResponseEntity variableCount(){
        long count = variableService.variableCount();
        return new ResponseEntity(count,HttpStatus.OK);
    }
    @PostMapping("api/variable/add") // 가변 확장자 추가
    public ResponseEntity variableAdd(@RequestParam(value = "name") String name) {
        Message message = variableService.addVariable(name);
        return new ResponseEntity(message.getMessage(), HttpStatus.OK);
    }
    @DeleteMapping("api/variable/delete") // 가변 확장자 삭제
    public ResponseEntity variableDelete(@RequestParam(value = "id") int id) {
        Message message = variableService.deleteVariable(id);
        return new ResponseEntity(message.getMessage(), HttpStatus.OK);
    }
}
