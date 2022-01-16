package com.flow.backend.service;

import com.flow.backend.domain.Fix;
import com.flow.backend.domain.Variable;
import com.flow.backend.repository.FixRepository;
import com.flow.backend.repository.VariableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FixService {

    private final FixRepository fixRepository;

    public List<Fix> fixList(){ // 고정 확장자 전체 리스트 조회
        return fixRepository.findAll();
    }

    public Boolean fixCheck(int id) {
        Optional<Fix> temp = fixRepository.findById(id);

        Fix fix = temp.get();

        if (fix.getChecked() == 1) {
            fix.setChecked(0);
        } else {
            fix.setChecked(1);
        }

        fixRepository.save(fix);
        return true;
    }

}
