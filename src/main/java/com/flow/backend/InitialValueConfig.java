package com.flow.backend;

import com.flow.backend.domain.Fix;
import com.flow.backend.domain.Variable;
import com.flow.backend.repository.FixRepository;
import com.flow.backend.repository.VariableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitialValueConfig implements CommandLineRunner {

    private final FixRepository fixRepository;
    private final VariableRepository variableRepository;

    @Override
    public void run(String... args) throws Exception{
        Fix fix1 = Fix.builder()
                .name("bat")
                .build();
        fixRepository.save(fix1);

        Fix fix2 = Fix.builder()
                .name("cmd")
                .build();
        fixRepository.save(fix2);

        Fix fix3 = Fix.builder()
                .name("com")
                .build();
        fixRepository.save(fix3);

        Fix fix4 = Fix.builder()
                .name("cpl")
                .build();
        fixRepository.save(fix4);
        Fix fix5 = Fix.builder()
                .name("exe")
                .build();
        fixRepository.save(fix5);

        Fix fix6 = Fix.builder()
                .name("scr")
                .build();
        fixRepository.save(fix6);

        Fix fix7 = Fix.builder()
                .name("js")
                .build();
        fixRepository.save(fix7);

        Variable variable1 = Variable.builder()
                .name("sh").
                build();
        variableRepository.save(variable1);

        Variable variable2 = Variable.builder()
                .name("ju").
                build();

        variableRepository.save(variable2);

        Variable variable3 = Variable.builder()
                .name("ch").
                build();
        variableRepository.save(variable3);

    }
}
