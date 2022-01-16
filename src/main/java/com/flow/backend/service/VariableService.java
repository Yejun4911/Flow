package com.flow.backend.service;

import com.flow.backend.domain.Fix;
import com.flow.backend.domain.Message;
import com.flow.backend.domain.Variable;
import com.flow.backend.repository.FixRepository;
import com.flow.backend.repository.VariableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VariableService {

    private final VariableRepository variableRepository;
    private Message message;

    public List<Variable> variableList(){ // 가변 확장자 전체 리스트 조회
        return variableRepository.findAll();
    }
    public long variableCount() { // 가변 확장자 갯수
        return variableRepository.count();
    }

    public Message addVariable(String name) { // 가변 확장자 추가 기능
        message = new Message();

        message.setMessage("추가완료 !");
        if (variableRepository.count() > 200) { // 가변 확장자가 200개가 넘으면 추가 할 수 없다 !
                message.setMessage("확장자 저장 공간이 부족합니다.");
        }
        Variable variable = Variable.builder().name(name).build();

        if (duplicateCheck(variable)) { // 중복 체크
            variableRepository.save(variable);
        } else {
            message.setMessage("중복입니다 !");
        }
        return message;

    }
    public Boolean duplicateCheck(Variable variable) { // 중복체크

        Optional<Variable> variable1 = variableRepository.findById(variable.getId());

        if (variable1.isPresent()) {
            return false;
        }
        else {
            return true;
        }
    }
    public Message deleteVariable(int id){ // 가변 확장자 삭제 기능
       Optional<Variable> variable1 = variableRepository.findById(id);
       message = new Message();

       message.setMessage("삭제완료");
       if (variable1 == null) {
           message.setMessage("없습니다 !");
       } else {
           variableRepository.delete(variable1.get());

       }
        return message;
    }

}
